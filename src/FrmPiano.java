import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
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
    JTable tblinfo;
    DefaultComboBoxModel mdl1, mdl2, mdl3;
    String[] titulos = new String[] {"Nota", "Figura", "Octava"};
    String[] notas = new String[] {"DO", "RE", "MI", "FA", "SOL", "LA", "SI"};
    String[] figuras = new String[] {"REDONDA", "BLANCA", "NEGRA", "CORCHEA"};
    String[] octavas = new String[] {"0", "3", "4", "5"};

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

    public void buscar() {

    }

    public void guardar() {

    }


    String[] datos = new String[20];
    int total = -1;
    String[][] strtbl = new String[20][titulos.length];

    public void agregar() {

        try {
            
            String dt = "";
            
            int nota = cmbnotas.getSelectedIndex();
            int figura = cmbfiguras.getSelectedIndex();
            int octava = cmboctavas.getSelectedIndex();
            
            dt = notas[nota];
            
            total++;
            datos[total] = dt;

            for(int i = 0; i < datos.length; i++) {

                strtbl[i][0] = datos[i];
            }
    
            DefaultTableModel dtm = new DefaultTableModel(strtbl, titulos);
            tblinfo.setModel(dtm);

        } catch(Exception e) {
            JOptionPane.showMessageDialog(null, "Limite excedido");
        }

    }

    public void modificar() {
    
    }

    public void eliminar() {
        
    }

    public void sonido() {
        
    }
    
}
