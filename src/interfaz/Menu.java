package interfaz;

import logica.DBconnection;
import logica.Producto;
import logica.Sentenciasql;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;




public class Menu extends JFrame {
    private String id, nombre;
    private double temperatura, valorBase;
    private Producto producto = new Producto();
    private DBconnection db = new DBconnection();
    //private Sentenciasql sql;

    private JPanel rootPanel;
    private JTable tablaProductos;
    private JButton guardarButton;
    private JButton actualizarButton;
    private JButton eliminarButton;
    private JButton consultarButton;
    private JTextField in_valorBase;
    private JTextField in_temperatura;
    private JTextField in_nombre;
    private JTextField in_id;
    private JScrollPane tablaPanel;
    private JLabel respuestaLabel;

    public Menu() {
        this.setContentPane(rootPanel);
        this.pack();

        guardarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getDatos();
                respuestaLabel.setText(Sentenciasql.agregar(producto));
                producto.print();
            }
        });
        actualizarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getDatos();
                respuestaLabel.setText(Sentenciasql.actualizar(producto));
                producto.print();
            }
        });
        eliminarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getDatos();
                respuestaLabel.setText(Sentenciasql.eliminar(producto));
                producto.print();
            }
        });
        consultarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getDatos();
                respuestaLabel.setText(Sentenciasql.consultar(producto));
                producto.print();
            }
        });
    }

    public void getDatos(){
        id = in_id.getText();
        nombre = in_nombre.getText();
        temperatura = Double.parseDouble(in_temperatura.getText());
        valorBase = Double.parseDouble(in_valorBase.getText());
        producto.setNombre(nombre);
        producto.setTemperatura(temperatura);
        producto.setValorBase(valorBase);
        producto.setId(id);
    }

    public static void main(String[] args) {
        JFrame frame = new Menu();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

}
