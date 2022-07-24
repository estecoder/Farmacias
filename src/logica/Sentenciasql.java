package logica;

import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Sentenciasql {
    private static String respuesta, sentencia;


    public static String agregar(Producto p){
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
                } else{
                    db.rollbackBD();
                    respuesta = "Error de sintaxis. INSERTDB";
                }
            } else{
                db.closeConnection(db.getConnection());
                respuesta = "Error con database";
            }
        } else{
            respuesta =  "Complete todos los datos del producto a ingresar.";
        }

        return respuesta;
    }

    public static String consultar(Producto p){ return "consultado";}


    public static String eliminar(Producto p){
        DBconnection db = new DBconnection();
        String sentencia = "DELETE FROM Empleados "
                + "WHERE id = "+ p.getId() +";";
        if (p.getId()!=null) {
            if (db.setAutoCommitBD(false)) {
                if (db.actualizarBD(sentencia)) {
                    db.commitBD();
                    db.closeConnection(db.getConnection());
                    respuesta = "Producto eliminado.";
                    //return true;
                } else {
                    db.rollbackBD();
                    db.closeConnection(db.getConnection());
                    respuesta = "Error de Sintaxis. DELETE";
                    //return false;
                }
            } else {
                db.closeConnection(db.getConnection());
                respuesta = "Error en la database";
                //return false;
            }
        }else{
            respuesta = "Ingrese un ID";
        }
        return respuesta;
    }


    public static String actualizar(Producto p){
        if (p.getId()!=null) {
            DBconnection db = new DBconnection();
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
                    //return true;
                } else {
                    db.rollbackBD();
                    db.closeConnection(db.getConnection());
                    respuesta = "Error en la actualización";
                    //return false;
                }
            } else {
                db.closeConnection(db.getConnection());
                respuesta = "Error con la database";
                //return false;
            }
        } else {
            respuesta = "Ingrese un numero de ID";
        }
        return respuesta;
    }
    public static List<Producto> listar() throws SQLException{
        DBconnection db = new DBconnection();
        String sentencia = "SELECT * FROM productos;";
        List<Producto> listaProductos = new ArrayList<>();
        ResultSet rs = db.consultarBD(sentencia);
        Producto prod;

        while(rs.next()){
            prod = new Producto();
            prod.setId(rs.getString("id"));
            prod.setNombre(rs.getString("nombre"));
            prod.setTemperatura(rs.getDouble("temperatura"));
            prod.setValorBase(rs.getInt("valor_base"));
            prod.setCosto(rs.getDouble("costo"));

            listaProductos.add(prod);
        }
        db.closeConnection(db.getConnection());
        return listaProductos;
    }
}
