package controlador;

import interfaz.Menu;
import logica.Producto;
import logica.Sentenciasql;
import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Controller {
    private Producto prod;
    private Sentenciasql sentProd;
    private Menu vista;

    public Controller (Producto p, Menu vista) {
        this.prod = p;
        this.vista = vista;

        this.vista.actualizarButton.addActionListener(this);
        this.vista.eliminarButton.addActionListener(this);
        this.vista.consultarButton.addActionListener(this);
        this.vista.guardarButton.addActionListener(this);
    }

    public void iniciar(){
        this.vista.setTitle("Farmacias");
        this.vista.setVisible(true);
        this.vista.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


}
