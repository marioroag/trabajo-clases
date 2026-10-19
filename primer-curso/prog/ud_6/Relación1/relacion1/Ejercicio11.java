// EJERCICIO 11 - Figuras Geométricas con Cálculo de Áreas

abstract class Figura {
    abstract double calcularArea();
}

class Triangulo extends Figura {
    double base;
    double altura;

    Triangulo(double base, double altura) {
        this.base = base;
        this.altura = altura;
    }

    double calcularArea() {
        double resultado = (base * altura) / 2;
        return resultado;
    }
}

class Cuadrado extends Figura {
    double lado;

    Cuadrado(double lado) {
        this.lado = lado;
    }

    double calcularArea() {
        double resultado = lado * lado;
        return resultado;
    }
}

public class Ejercicio11 {
    public static void main(String[] args) {
        Triangulo t = new Triangulo(6, 4);
        Cuadrado c = new Cuadrado(5);

        System.out.println("Area triangulo: " + t.calcularArea());
        System.out.println("Area cuadrado: " + c.calcularArea());

        // Polimorfismo
        Figura f = new Triangulo(10, 3);
        System.out.println("Area (ref Figura): " + f.calcularArea());
    }
}
