package controlador;

import interfaz.*;
import logica.*;

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

public class Controller implements ActionListener{
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


    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == vista.guardarButton){
            prod.setNombre(vista.in_nombre.getText());
            prod.setId(vista.in_id.getText());
            prod.setTemperatura(Double.parseDouble(vista.in_temperatura.getText()));
            prod.setValorBase(Double.parseDouble(vista.in_valorBase.getText()));
            prod.calcularCostoDeAlmacenamiento();

            if (sentProd.agregar(prod)){
                vista.respuestaLabel.setText(sentProd.respuesta);
                JOptionPane.showMessageDialog(null, "Registro exitoso");
            } else {
                vista.respuestaLabel.setText("Fallo en guardado");
                JOptionPane.showMessageDialog(null, "Error en el registro");
            }

        }

        if (e.getSource()==vista.eliminarButton){
            prod.setId(vista.in_id.getText());
            if (sentProd.eliminar(prod)){
                vista.respuestaLabel.setText(sentProd.respuesta);
                JOptionPane.showMessageDialog(null, "Borrado exitoso");
            } else {
                JOptionPane.showMessageDialog(null, "Error en borrado");
            }
        }

        if (e.getSource() == vista.actualizarButton){
            prod.setId(vista.in_id.getText());
            prod.setNombre(vista.in_nombre.getText());
            prod.setTemperatura(Double.parseDouble(vista.in_temperatura.getText()));
            prod.setValorBase(Double.parseDouble(vista.in_valorBase.getText()));
            prod.calcularCostoDeAlmacenamiento();


            if (sentProd.actualizar(prod)){
                vista.respuestaLabel.setText(sentProd.respuesta);
                JOptionPane.showMessageDialog(null, "Actualizacion exitosa");
            } else {
                JOptionPane.showMessageDialog(null, "Error en la actualizacion");
            }


        }

    }
}
