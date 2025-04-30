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
    String nota;

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

    Notas not = null;
    Figura fig = null;
    int oct = 0;

    public void agregar() {

        NotaMusical notamusical = null;

        int ind = cmbnotas.getSelectedIndex();
        int ind2 = cmbfiguras.getSelectedIndex();
        int ind3 = cmboctavas.getSelectedIndex();

        switch (ind) {

            case 0:
            not = not.DO;
            break;
            case 1:
            not = not.RE;
            break;
            case 2:
            not = not.MI;
            break;
            case 3:
            not = not.FA;
            break;
            case 4:
            not = not.SOL;
            break;
            case 5:
            not = not.SI;
            break;
        }

        switch (ind2) {

            case 0:
            fig = fig.REDONDA;
            break;
            case 1:
            fig = fig.BLANCA;
            break;
            case 2:
            fig = fig.NEGRA;
            break;
            case 3:
            fig = fig.CORCHEA;

        }

        switch (ind3) {

            case 0:
            oct = Integer.parseInt(octavas[0]);
            break;
            case 1:
            oct = Integer.parseInt(octavas[1]);
            break;
            case 2:
            oct = Integer.parseInt(octavas[2]);
            break;
            case 3:
            oct = Integer.parseInt(octavas[3]);
            break;
            
        }

        notamusical = new NotaMusical(not, fig, oct);

        try {

            JOptionPane.showMessageDialog(null, "Guardado exitosamente");

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
