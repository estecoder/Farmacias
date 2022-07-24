import logica.Producto;

public class ProductoNoRefrigerado extends Producto {

    public ProductoNoRefrigerado(String nombre, String id, double temperatura, double valorBase) {
        super(nombre, id, temperatura, valorBase);
    }

    public void calcularCostoDeAlmacenamiento(){
        double temp = super.getTemperatura();
        double valBase = super.getValorBase();

        if (temp >= 21.0f ){
            valBase *= 1.20;
        } else {
            valBase *= 1.10;
        }
        
    }
}
