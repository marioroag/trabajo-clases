// EJERCICIO 1 - Herencia con Electrodomésticos

class Electrodomestico {
    String marca;
    String modelo;

    Electrodomestico(String marca, String modelo) {
        this.marca = marca;
        this.modelo = modelo;
    }
}

class Lavadora extends Electrodomestico {
    double capacidadCarga;

    Lavadora(String marca, String modelo, double capacidadCarga) {
        super(marca, modelo);
        this.capacidadCarga = capacidadCarga;
    }

    public String toString() {
        String resultado = "Lavadora: " + marca + " " + modelo + ", Capacidad: " + capacidadCarga + "kg";
        return resultado;
    }
}

class Televisor extends Electrodomestico {
    int tamañoPantalla;

    Televisor(String marca, String modelo, int tamañoPantalla) {
        super(marca, modelo);
        this.tamañoPantalla = tamañoPantalla;
    }

    public String toString() {
        String resultado = "Televisor: " + marca + " " + modelo + ", Pantalla: " + tamañoPantalla + " pulgadas";
        return resultado;
    }
}

public class Ejercicio01 {
    public static void main(String[] args) {
        Lavadora l = new Lavadora("Bosch", "Serie 6", 8.0);
        Televisor t = new Televisor("Samsung", "QLED", 55);

        System.out.println(l.toString());
        System.out.println(t.toString());
    }
}
