
import interfaz.Menu;
import logica.Producto;
import logica.Sentenciasql;
import logica.DBconnection;

public class Main {
    public static void main(String[] args) {
        DBconnection db = new DBconnection();
        Producto p = new Producto();
        Menu vista = new Menu();

        //Controller control = new Controller(p, vista);
        //control.iniciar();

    }
}
