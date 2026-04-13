// EJERCICIO 7 - Transporte Público con Múltiples Modos

interface Transporte {
    String arrancar();
    String detener();
}

class Autobus implements Transporte {
    String horaSalida;
    String horaParada;

    Autobus(String horaSalida, String horaParada) {
        this.horaSalida = horaSalida;
        this.horaParada = horaParada;
    }

    public String arrancar() {
        String resultado = "El autobús arranca a las " + horaSalida + ".";
        return resultado;
    }

    public String detener() {
        String resultado = "El autobús se detiene a las " + horaParada + ".";
        return resultado;
    }
}

class Metro implements Transporte {
    int numeroVagones;

    Metro(int numeroVagones) {
        this.numeroVagones = numeroVagones;
    }

    public String arrancar() {
        String resultado = "El metro arranca con " + numeroVagones + " vagones.";
        return resultado;
    }

    public String detener() {
        String resultado = "El metro se detiene en la estación.";
        return resultado;
    }
}

class Bicicleta implements Transporte {
    String tipo;

    Bicicleta(String tipo) {
        this.tipo = tipo;
    }

    public String arrancar() {
        String resultado = "La bicicleta " + tipo + " empieza a pedalear.";
        return resultado;
    }

    public String detener() {
        String resultado = "La bicicleta " + tipo + " se detiene.";
        return resultado;
    }
}

public class Ejercicio07 {
    public static void main(String[] args) {
        Autobus a = new Autobus("08:30", "09:15");
        Metro m = new Metro(6);
        Bicicleta b = new Bicicleta("de montaña");

        System.out.println(a.arrancar());
        System.out.println(a.detener());
        System.out.println(m.arrancar());
        System.out.println(m.detener());
        System.out.println(b.arrancar());
        System.out.println(b.detener());
    }
}
