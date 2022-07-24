import logica.Producto;

import java.util.*;

public class Lote {
    private List<Producto>productos;

    public Lote(){
        this.productos = new ArrayList<>();
    }

    public void agregarProducto(Producto p) {
        this.productos.add(p);
    }

    public void mostrarProductos(){
        for (Producto producto : productos) {
            System.out.println(producto.getNombre());
        }
    }
}
