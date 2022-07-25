import Controlador.Controller;
import Modelo.DBconnection;
import Vista.Menu;
import Modelo.Producto;


public class Main {
    public static void main(String[] args) {
        System.out.println("====================================FARMACIAS 2022====================================");

        Producto p = new Producto();
        Menu vista = new Menu();

        Controller control = new Controller(p, vista);
        control.iniciar();

    }
}
