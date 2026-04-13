// EJERCICIO 12 - Vehículos con Métodos Abstractos

abstract class Vehiculo {
    String marca;

    Vehiculo(String marca) {
        this.marca = marca;
    }

    abstract String arrancar();
    abstract String detener();
}

class Moto extends Vehiculo {
    int cilindrada;

    Moto(String marca, int cilindrada) {
        super(marca);
        this.cilindrada = cilindrada;
    }

    String arrancar() {
        String resultado = "La moto " + marca + " de " + cilindrada + "cc arranca rugiendo.";
        return resultado;
    }

    String detener() {
        String resultado = "La moto " + marca + " frena y se detiene.";
        return resultado;
    }
}

class Camion extends Vehiculo {
    double cargaMaxima;

    Camion(String marca, double cargaMaxima) {
        super(marca);
        this.cargaMaxima = cargaMaxima;
    }

    String arrancar() {
        String resultado = "El camión " + marca + " con carga máxima " + cargaMaxima + "t arranca lentamente.";
        return resultado;
    }

    String detener() {
        String resultado = "El camión " + marca + " frena con retardador y se detiene.";
        return resultado;
    }
}

public class Ejercicio12 {
    public static void main(String[] args) {
        Moto m = new Moto("Yamaha", 600);
        Camion c = new Camion("Volvo", 18.5);

        System.out.println(m.arrancar());
        System.out.println(m.detener());
        System.out.println(c.arrancar());
        System.out.println(c.detener());
    }
}
