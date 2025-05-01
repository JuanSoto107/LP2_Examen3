import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;

import entidades.NotaMusical;
import entidades.Notas;
import entidades.Figura;

import javax.swing.JToolBar;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;

public class FrmPiano extends JFrame {

    JButton btnbuscar, btnguardar, btnagregar, btnmodificar, btneliminar, btnsonido;
    JComboBox cmbnotas, cmbfiguras, cmboctavas;
    DefaultComboBoxModel mdl1, mdl2, mdl3;
    JTable tblinfo;
    String[] titulos = new String[] {"Nota", "Figura", "Octava"};
    String[] notas = new String[] {"DO", "RE", "MI", "FA", "SOL", "LA", "SI"};
    String[] figuras = new String[] {"REDONDA", "BLANCA", "NEGRA", "CORCHEA"};
    String[] octavas = new String[] {"0", "3", "4", "5"};
    String nombreArchivo = "";

    public FrmPiano() {

        setSize(700, 500);
        setTitle("Editor De Melodias");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JToolBar tb = new JToolBar();

        btnbuscar = new JButton();
        btnguardar = new JButton();
        btnagregar = new JButton();
        btnmodificar = new JButton();
        btneliminar = new JButton();
        btnsonido = new JButton();

        btnbuscar.setIcon(new ImageIcon(getClass().getResource("/iconos/imagen1.png")));
        btnguardar.setIcon(new ImageIcon(getClass().getResource("/iconos/imagen2.png")));
        btnagregar.setIcon(new ImageIcon(getClass().getResource("/iconos/imagen3.png")));
        btnmodificar.setIcon(new ImageIcon(getClass().getResource("/iconos/imagen4.png")));
        btneliminar.setIcon(new ImageIcon(getClass().getResource("/iconos/imagen5.png")));
        btnsonido.setIcon(new ImageIcon(getClass().getResource("/iconos/imagen6.png")));


        btnbuscar.setToolTipText("Buscar");
        btnguardar.setToolTipText("Guardar");
        btnagregar.setToolTipText("Agregar");
        btnmodificar.setToolTipText("Modificar");
        btneliminar.setToolTipText("Eliminar");
        btnsonido.setToolTipText("Sonido");

        btnbuscar.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                buscar();
            }


        });

        btnguardar.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                guardar();
            }


        });

        btnagregar.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                agregar();
            }


        });

        btnmodificar.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                modificar();
            }


        });

        btneliminar.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                eliminar();
            }


        });

        btnsonido.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                sonido();
            }


        });

        cmbnotas = new JComboBox();
        cmbfiguras = new JComboBox();
        cmboctavas = new JComboBox();


        mdl1 = new DefaultComboBoxModel(notas);
        mdl2 = new DefaultComboBoxModel(figuras);
        mdl3 = new DefaultComboBoxModel(octavas);
        cmbnotas.setModel(mdl1);
        cmbfiguras.setModel(mdl2);
        cmboctavas.setModel(mdl3);


        tb.add(btnbuscar);
        tb.add(btnguardar);
        tb.add(cmbnotas);
        tb.add(cmbfiguras);
        tb.add(cmboctavas);
        tb.add(btnagregar);
        tb.add(btnmodificar);
        tb.add(btneliminar);
        tb.add(btnsonido);


        tblinfo = new JTable();
        JScrollPane spinfo = new JScrollPane(tblinfo);
        DefaultTableModel dtm = new DefaultTableModel(null, titulos);
        tblinfo.setModel(dtm);



        getContentPane().add(tb, BorderLayout.NORTH);
        getContentPane().add(spinfo, BorderLayout.CENTER);



        

    }

    private void buscar() {

        nombreArchivo = Archivo.elegirArchivo();
        if (!nombreArchivo.equals("")) {
            lista.desdeJSON(nombreArchivo);
        }
    }

    private void guardar() {

        nombreArchivo = Archivo.elegirArchivo();
        if(!nombreArchivo.equals("")) {
            if(lista.guardarJSON(nombreArchivo)) {
                JOptionPane.showMessageDialog(null, "Melodia guardada");
            } else {
                JOptionPane.showMessageDialog(null, "Error al guardar");
            }
        }
    }

    Notas not = null;
    Figura fig = null;
    int oct = 0;

    private ListaLigada lista = new ListaLigada();

    private void agregar() {

        try {

            NotaMusical notamusical = null;


            int ind = cmbnotas.getSelectedIndex();
            int ind2 = cmbfiguras.getSelectedIndex();
            int ind3 = cmboctavas.getSelectedIndex();
    
            not = Notas.values()[ind];
            fig = Figura.values()[ind2];
            oct = Integer.parseInt(octavas[ind3]);
    
            notamusical = new NotaMusical(not, fig, oct);
            lista.agregarNodo(new Nodo(notamusical));

            Nodo actual = lista.getCabeza();
    
            int i = 0;            
            String[][] strtbl = new String[lista.getLongitud()][titulos.length];
    
            while(actual != null) {
    
                strtbl[i][0] = String.valueOf(actual.getNotamusical().getNota());
                strtbl[i][1] = String.valueOf(actual.getNotamusical().getFigura());
                strtbl[i][2] = String.valueOf(actual.getNotamusical().getOctava());
    
                i++;
    
                actual = actual.siguiente;

            }
    
            DefaultTableModel dtm = new DefaultTableModel(strtbl, titulos);
            tblinfo.setModel(dtm);

            JOptionPane.showMessageDialog(null, "Guardado");

        } catch(Exception e) {
            JOptionPane.showMessageDialog(null, "Limite excedido");
        }

    }

    private void modificar() {
    
    }

    private void eliminar() {

        Nodo actual = lista.getCabeza();
        int seleccionado = tblinfo.getSelectedRow();

        DefaultTableModel modelo = (DefaultTableModel) tblinfo.getModel();
        modelo.removeRow(seleccionado);

        while(actual != null) {
            if(actual == lista.seleccionar(seleccionado)) {
                lista.eliminarNodo(actual);
                break;
            }
            actual = actual.siguiente;
        }



    }

    private void sonido() {
        
    }
    
}
