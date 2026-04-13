// EJERCICIO 13 - Animales con Tipos de Sonidos

abstract class Animal {
    String nombre;

    Animal(String nombre) {
        this.nombre = nombre;
    }

    abstract String hacerSonido();
}

class Leon extends Animal {
    Leon(String nombre) {
        super(nombre);
    }

    String hacerSonido() {
        String resultado = "El león " + nombre + " ruge: ROAAAR!";
        return resultado;
    }
}

class Elefante extends Animal {
    Elefante(String nombre) {
        super(nombre);
    }

    String hacerSonido() {
        String resultado = "El elefante " + nombre + " barrita: PRRRR!";
        return resultado;
    }
}

public class Ejercicio13 {
    public static void main(String[] args) {
        Leon l = new Leon("Simba");
        Elefante e = new Elefante("Dumbo");

        System.out.println(l.hacerSonido());
        System.out.println(e.hacerSonido());

        // Polimorfismo
        Animal a = new Leon("Mufasa");
        System.out.println(a.hacerSonido());
    }
}
