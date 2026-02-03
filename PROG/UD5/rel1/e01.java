package PROG.UD5.rel1;

public class e01 {
    /*
     * Ejercicio 1: Clase Círculo
     * Crea una clase Círculo con el atributo radio.
     * Agrega un método calcularArea() que retorne el área del círculo (π * radio²)
     * y otro método calcularPerimetro() que retorne su perímetro (2 * π * radio).
     */
    public static void main(String[] args) {
        Circulo test = new Circulo(5.2);
        double radioCirculo = test.calcularArea();
        double permiteroCirculo = test.calcularPerimetro();

        System.out.println("Area del circulo: " + radioCirculo);
        System.out.println("Perímetro del circulo: " + permiteroCirculo);
    }
}

class Circulo {
    // Atributos
    double radio;

    // Constructor
    Circulo(double radio) {
        this.radio = radio;
    }

    // Método para calcular area π * r²
    double calcularArea() {
        return Math.PI * (radio * 2);
    }

    double calcularPerimetro() {
        return 2 * Math.PI * radio;
    }
}
