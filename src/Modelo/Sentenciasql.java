package Modelo;

import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Sentenciasql {
    private static String sentencia;
    public static String respuesta;
    private static boolean state;


    public static boolean agregar(Producto p){
        DBconnection db = new DBconnection();
        if (p.getId() != null && p.getNombre() != null && p.getTemperatura() != 0 && p.getValorBase() != 0){
            p.calcularCostoDeAlmacenamiento();
            sentencia = "INSERT INTO productos" +
                    "(id, nombre, temperatura, valor_base, costo)" +
                    "VALUES('" + p.getId()+"',"+
                    "'"+p.getNombre()+"',"+
                    p.getTemperatura()+","+
                    p.getValorBase()+","+
                    p.getCosto()+
                    ");";
            if (db.setAutoCommitBD(false)){
                if (db.insertarBD(sentencia)){
                    db.commitBD();
                    db.closeConnection(db.getConnection());
                    respuesta = "Producto agregado exitosamente.";
                    state = true;
                } else{
                    db.rollbackBD();
                    respuesta = "Error de sintaxis. INSERTDB";
                    state = false;
                }
            } else{
                db.closeConnection(db.getConnection());
                respuesta = "Error con database";
                state = false;
            }
        } else{
            respuesta =  "Complete todos los datos del producto a ingresar.";
            state = false;
        }

        return state;
    }

    public static String consultar(Producto p){ return "consultado";}


    public static boolean eliminar(Producto p){
        DBconnection db = new DBconnection();
        String sentencia = "DELETE FROM Empleados "
                + "WHERE id = "+ p.getId() +";";
        if (p.getId()!=null) {
            if (db.setAutoCommitBD(false)) {
                if (db.actualizarBD(sentencia)) {
                    db.commitBD();
                    db.closeConnection(db.getConnection());
                    respuesta = "Producto eliminado.";
                    state = true;
                    //return true;
                } else {
                    db.rollbackBD();
                    db.closeConnection(db.getConnection());
                    respuesta = "Error de Sintaxis. DELETE";
                    state = false;
                    //return false;
                }
            } else {
                db.closeConnection(db.getConnection());
                respuesta = "Error en la database";
                state = false;
                //return false;
            }
        }else{
            respuesta = "Ingrese un ID";
            state = false;
        }
        return state;
    }


    public static boolean actualizar(Producto p){
        if (p.getId() != null && p.getNombre() != null && p.getTemperatura() != 0 && p.getValorBase() != 0) {
            DBconnection db = new DBconnection();
            p.calcularCostoDeAlmacenamiento();
            String sentencia = "UPDATE productos SET "
                    + "nombre='" + p.getNombre() + "',"
                    + "temperatura=" + p.getTemperatura() + ","
                    + "valor_base=" + p.getValorBase() + ","
                    + "costo=" + p.getCosto()
                    + "WHERE id='" + p.getId() + "';";
            if (db.setAutoCommitBD(false)) {
                if (db.actualizarBD(sentencia)) {
                    db.commitBD();
                    db.closeConnection(db.getConnection());
                    respuesta = "El producto ha sido actulizado.";
                    state = true;
                    //return true;
                } else {
                    db.rollbackBD();
                    db.closeConnection(db.getConnection());
                    respuesta = "Error en la actualización";
                    state = false;
                    //return false;
                }
            } else {
                db.closeConnection(db.getConnection());
                respuesta = "Error con la database";
                state = false;
                //return false;
            }
        } else {
            respuesta = "Ingrese todos los campos del producto.";
            state = false;
        }
        return state;
    }
    public static List<Producto> listar() throws SQLException{
        DBconnection db = new DBconnection();
        String sentencia = "SELECT * FROM productos;";
        List<Producto> listaProductos = new ArrayList<>();
        ResultSet rs = db.consultarBD(sentencia);
        Producto prod;
        if (rs != null){
            while(rs.next()){
                prod = new Producto();
                prod.setId(rs.getString("id"));
                prod.setNombre(rs.getString("nombre"));
                prod.setTemperatura(rs.getDouble("temperatura"));
                prod.setValorBase(rs.getInt("valor_base"));
                prod.setCosto(rs.getDouble("costo"));

                listaProductos.add(prod);
            }
        }
        db.closeConnection(db.getConnection());
        return listaProductos;
    }
}
