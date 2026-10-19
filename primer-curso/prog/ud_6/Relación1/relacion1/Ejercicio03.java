// EJERCICIO 3 - Vehículos con Tipos de Combustible

class Vehiculo {
    String marca;
    String tipoCombustible;

    Vehiculo(String marca, String tipoCombustible) {
        this.marca = marca;
        this.tipoCombustible = tipoCombustible;
    }
}

class Coche extends Vehiculo {
    int numeroPuertas;

    Coche(String marca, String tipoCombustible, int numeroPuertas) {
        super(marca, tipoCombustible);
        this.numeroPuertas = numeroPuertas;
    }

    public String toString() {
        String resultado = "Coche: " + marca + ", Combustible: " + tipoCombustible + ", Puertas: " + numeroPuertas;
        return resultado;
    }
}

class Moto extends Vehiculo {
    int cilindrada;

    Moto(String marca, String tipoCombustible, int cilindrada) {
        super(marca, tipoCombustible);
        this.cilindrada = cilindrada;
    }

    public String toString() {
        String resultado = "Moto: " + marca + ", Combustible: " + tipoCombustible + ", Cilindrada: " + cilindrada + "cc";
        return resultado;
    }
}

public class Ejercicio03 {
    public static void main(String[] args) {
        Coche c = new Coche("Toyota", "Gasolina", 5);
        Moto m = new Moto("Yamaha", "Gasolina", 600);

        System.out.println(c.toString());
        System.out.println(m.toString());
    }
}
