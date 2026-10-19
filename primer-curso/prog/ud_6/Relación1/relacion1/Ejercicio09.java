// EJERCICIO 9 - Instrumentos Musicales

interface InstrumentoMusical {
    String tocar();
    String afinar();
}

class Guitarra implements InstrumentoMusical {
    String marca;
    String tipoCuerdas;

    Guitarra(String marca, String tipoCuerdas) {
        this.marca = marca;
        this.tipoCuerdas = tipoCuerdas;
    }

    public String tocar() {
        String resultado = "La guitarra de marca " + marca + " está tocando una melodía.";
        return resultado;
    }

    public String afinar() {
        String resultado = "La guitarra de marca " + marca + " con cuerdas " + tipoCuerdas + " está siendo afinada.";
        return resultado;
    }
}

class Piano implements InstrumentoMusical {
    String marca;
    String tipoTeclas;

    Piano(String marca, String tipoTeclas) {
        this.marca = marca;
        this.tipoTeclas = tipoTeclas;
    }

    public String tocar() {
        String resultado = "El piano de marca " + marca + " está tocando una pieza clásica.";
        return resultado;
    }

    public String afinar() {
        String resultado = "El piano de marca " + marca + " con teclas " + tipoTeclas + " está siendo afinado.";
        return resultado;
    }
}

public class Ejercicio09 {
    public static void main(String[] args) {
        Guitarra g = new Guitarra("Gibson", "nylon");
        Piano p = new Piano("Yamaha", "marfil");

        System.out.println(g.tocar());
        System.out.println(g.afinar());
        System.out.println(p.tocar());
        System.out.println(p.afinar());
    }
}
