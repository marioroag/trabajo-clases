// EJERCICIO 5 - Biblioteca con Diferentes Tipos de Materiales

class MaterialBibliografico {
    String titulo;
    String autor;

    MaterialBibliografico(String titulo, String autor) {
        this.titulo = titulo;
        this.autor = autor;
    }
}

class Libro extends MaterialBibliografico {
    int numPaginas;
    String genero;

    Libro(String titulo, String autor, int numPaginas, String genero) {
        super(titulo, autor);
        this.numPaginas = numPaginas;
        this.genero = genero;
    }

    public String toString() {
        String resultado = "Libro: " + titulo + " por " + autor + ", Género: " + genero + ", Páginas: " + numPaginas + ".";
        return resultado;
    }
}

class Revista extends MaterialBibliografico {
    int edicion;
    String periodicidad;

    Revista(String titulo, String autor, int edicion, String periodicidad) {
        super(titulo, autor);
        this.edicion = edicion;
        this.periodicidad = periodicidad;
    }

    public String toString() {
        String resultado = "Revista: " + titulo + " por " + autor + ", Edición: " + edicion + ", Periodicidad: " + periodicidad + ".";
        return resultado;
    }
}

public class Ejercicio05 {
    public static void main(String[] args) {
        Libro l = new Libro("Berserk", "Kentaro Miura", 350, "Manga");
        Revista r = new Revista("National Geographic", "Varios", 245, "Mensual");

        System.out.println(l.toString());
        System.out.println(r.toString());
    }
}
