package prog.ud_6.rel_01.e14;

public abstract class Producto {
    public String nombre;
    public double precio;

    public Producto(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    public abstract String toString();
}
