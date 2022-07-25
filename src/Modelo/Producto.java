package Modelo;

public class Producto {
    private String id, nombre;
    private double temperatura, valorBase, costo;

    public Producto() {
    }

    public Producto(String nombre, String id, double temperatura, double valorBase) {
        this.id = id;
        this.nombre = nombre;
        this.temperatura = temperatura;
        this.valorBase = valorBase;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(double temperatura) {
        this.temperatura = temperatura;
    }

    public double getValorBase() {
        return valorBase;
    }

    public void setValorBase(double valorBase) {
        this.valorBase = valorBase;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public void calcularCostoDeAlmacenamiento(){
        if (temperatura >= 21.0f ){
            costo = valorBase * 1.20;
        } else {
            costo = valorBase * 1.10;
        }
    }


    public void print(){
        System.out.println("ID:"+this.id);
        System.out.println("NOMBRE:"+this.nombre);
        System.out.println("TEMPERATURA:"+this.temperatura);
        System.out.println("VALOR BASE:"+this.valorBase);

    }
}
