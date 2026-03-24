package prog.ud_6.rel_01.e14;

public class Ropa extends Producto {
    public String talla;

    public Ropa(String talla, String nombre, double precio) {
        super(nombre, precio);
        this.talla = talla;
    }

    @Override
    public String toString() {
        return nombre + " es de talla " + talla + " y cuesta " + precio + " €";
    }
}
