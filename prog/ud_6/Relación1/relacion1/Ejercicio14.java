// EJERCICIO 14 - Productos en una Tienda Online

abstract class Producto {
    String nombre;
    double precio;

    Producto(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    public abstract String toString();
}

class Electronico extends Producto {
    int garantia;

    Electronico(String nombre, double precio, int garantia) {
        super(nombre, precio);
        this.garantia = garantia;
    }

    public String toString() {
        String resultado = "Electrónico: " + nombre + ", Precio: " + precio + "€, Garantía: " + garantia + " años.";
        return resultado;
    }
}

class Ropa extends Producto {
    String talla;

    Ropa(String nombre, double precio, String talla) {
        super(nombre, precio);
        this.talla = talla;
    }

    public String toString() {
        String resultado = "Ropa: " + nombre + ", Precio: " + precio + "€, Talla: " + talla + ".";
        return resultado;
    }
}

public class Ejercicio14 {
    public static void main(String[] args) {
        Electronico e = new Electronico("Auriculares Sony", 149.99, 2);
        Ropa r = new Ropa("Camiseta Básica", 19.99, "M");

        System.out.println(e.toString());
        System.out.println(r.toString());
    }
}
