import controlador.Controller;
import interfaz.Menu;
import logica.Producto;
import logica.Sentenciasql;

public class Main {
    public static void main(String[] args) {

        Producto p = new Producto();
        Menu vista = new Menu();

        Controller control = new Controller(p, vista);
        control.iniciar();

    }
}
