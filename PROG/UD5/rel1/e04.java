package PROG.UD5.rel1;

public class e04 {
    /*
     * Ejercicio 4: Clase Auto
     * Crea una clase Auto con atributos marca, modelo y velocidadActual. Agrega
     * métodos acelerar(cantidad) y frenar(cantidad) que aumenten o reduzcan la
     * velocidad actual
     */

    public static void main(String[] args) {
        Auto coche1 = new Auto("Porsche", "911 Targa", 100);

        System.out.println("Velocidad actual: " + coche1.velocidadActual + "km/h");
        System.out.println("Acelerando 20kmh/h...");
        coche1.acelerar(20);

        System.out.println(coche1.velocidadActual + "km/h");
        System.out.println("Frenando 40kmh/h...");
        coche1.frenar(40);

        System.out.println(coche1.velocidadActual + "km/h");
    }
}

class Auto {
    // Atributos
    String marca;
    String modelo;
    int velocidadActual;

    // Constructor
    Auto(String marca, String modelo, int velocidadActual) {
        this.marca = marca;
        this.modelo = modelo;
        this.velocidadActual = velocidadActual;
    }

    // Metodos
    void acelerar(int cantidad) {
        velocidadActual += cantidad;
    }

    void frenar(int cantidad) {
        velocidadActual -= cantidad;
    }

    @Override
    public String toString() {
        return "Coche: " + marca + " | Modelo: " +  modelo;
    }
}
