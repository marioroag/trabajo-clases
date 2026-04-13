// EJERCICIO 8 - Juegos con Interfaz de Jugador

interface Jugador {
    String mover();
    String atacar();
}

class Guerrero implements Jugador {
    String nombre;
    int fuerza;
    String arma;

    Guerrero(String nombre, int fuerza, String arma) {
        this.nombre = nombre;
        this.fuerza = fuerza;
        this.arma = arma;
    }

    public String mover() {
        String resultado = "El Guerrero " + nombre + " se mueve con fuerza " + fuerza + ".";
        return resultado;
    }

    public String atacar() {
        String resultado = "El Guerrero " + nombre + " ataca con su " + arma + ".";
        return resultado;
    }
}

class Mago implements Jugador {
    String nombre;
    int mana;
    String hechizo;

    Mago(String nombre, int mana, String hechizo) {
        this.nombre = nombre;
        this.mana = mana;
        this.hechizo = hechizo;
    }

    public String mover() {
        String resultado = "El Mago " + nombre + " se desplaza utilizando su mana " + mana + ".";
        return resultado;
    }

    public String atacar() {
        String resultado = "El Mago " + nombre + " lanza un hechizo " + hechizo + ".";
        return resultado;
    }
}

class Arquero implements Jugador {
    String nombre;
    int agilidad;
    String arco;

    Arquero(String nombre, int agilidad, String arco) {
        this.nombre = nombre;
        this.agilidad = agilidad;
        this.arco = arco;
    }

    public String mover() {
        String resultado = "El Arquero " + nombre + " se mueve ágilmente con agilidad " + agilidad + ".";
        return resultado;
    }

    public String atacar() {
        String resultado = "El Arquero " + nombre + " dispara una flecha con su " + arco + ".";
        return resultado;
    }
}

public class Ejercicio08 {
    public static void main(String[] args) {
        Guerrero g = new Guerrero("Guts", 95, "Dragonslayer");
        Mago m = new Mago("Schierke", 80, "Bola de Fuego");
        Arquero a = new Arquero("Irvine", 70, "Arco largo");

        System.out.println(g.mover());
        System.out.println(g.atacar());
        System.out.println(m.mover());
        System.out.println(m.atacar());
        System.out.println(a.mover());
        System.out.println(a.atacar());
    }
}
