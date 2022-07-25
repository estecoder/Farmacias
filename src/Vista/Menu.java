package Vista;

import Modelo.DBconnection;
import Modelo.Producto;


import javax.swing.*;
import javax.swing.table.DefaultTableModel;


public class Menu extends JFrame {
    private String id, nombre;
    private double temperatura, valorBase;
    private Producto producto = new Producto();
    private DBconnection db = new DBconnection();


    private JPanel rootPanel;
    private JScrollPane tablaPanel;
    public JTable tablaProductos;
    public JButton guardarButton;
    public JButton actualizarButton;
    public JButton eliminarButton;
    public JButton consultarButton;
    public JTextField in_valorBase;
    public JTextField in_temperatura;
    public JTextField in_nombre;
    public JTextField in_id;
    public JLabel respuestaLabel;

    public Menu() {


        tablaProductos.setModel(new DefaultTableModel(
                null,
                new String[]{"ID","NOMBRE","TEMPERATURA","VALOR BASE","COSTO"}
        ));
        this.setContentPane(rootPanel);
        this.pack();
    }

    /*
    public void getDatos() {
        id = in_id.getText();
        nombre = in_nombre.getText();
        temperatura = Double.parseDouble(in_temperatura.getText());
        valorBase = Double.parseDouble(in_valorBase.getText());
        producto.setNombre(nombre);
        producto.setTemperatura(temperatura);
        producto.setValorBase(valorBase);
        producto.setId(id);
    }*/

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
