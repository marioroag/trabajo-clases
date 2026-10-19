// EJERCICIO 4 - Animales Domésticos y Salvajes

class Animal {
    String nombre;
    String tipoAlimentacion;

    Animal(String nombre, String tipoAlimentacion) {
        this.nombre = nombre;
        this.tipoAlimentacion = tipoAlimentacion;
    }
}

class Domestico extends Animal {
    String dueño;

    Domestico(String nombre, String tipoAlimentacion, String dueño) {
        super(nombre, tipoAlimentacion);
        this.dueño = dueño;
    }

    public String convivirConHumanos() {
        String resultado = "El animal doméstico " + nombre + " convive con su dueño " + dueño
                + " y se alimenta de " + tipoAlimentacion + ".";
        return resultado;
    }
}

class Salvaje extends Animal {
    String habitat;

    Salvaje(String nombre, String tipoAlimentacion, String habitat) {
        super(nombre, tipoAlimentacion);
        this.habitat = habitat;
    }

    public String cazar() {
        String resultado = "El animal salvaje " + nombre + " caza en su hábitat " + habitat
                + " y se alimenta de " + tipoAlimentacion + ".";
        return resultado;
    }
}

public class Ejercicio04 {
    public static void main(String[] args) {
        Domestico d = new Domestico("Max", "pienso", "Mario");
        Salvaje s = new Salvaje("Simba", "carne", "sabana africana");

        System.out.println(d.convivirConHumanos());
        System.out.println(s.cazar());
    }
}
