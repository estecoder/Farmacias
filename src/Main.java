import controlador.Controller;
import interfaz.Menu;
import logica.Producto;
import logica.Sentenciasql;

public class Main {
    public static void main(String[] args) {
        System.out.println("====================================FARMACIAS 2022====================================");
        Producto p = new Producto();
        Menu vista = new Menu();

        Controller control = new Controller(p, vista);
        control.iniciar();

    }
}
