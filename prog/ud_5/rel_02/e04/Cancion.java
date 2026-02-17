package prog.ud_5.rel_02.e04;

public class Cancion {
    /*
     * ### Ejercicio 4: Playlist y Canciones
     * Crea una clase `Cancion` con atributos `titulo`, `artista` y `duracion`.
     * Implementa los métodos **get** y **set** para cada atributo, así como el
     * método `toString()`. Luego, crea una clase `Playlist` que contenga un **array
     * de canciones** y métodos para:
     * - Agregar canciones
     * - Mostrar todas las canciones
     * - Calcular la duración total de la playlist
     * 
     * En el `main`, implementa un **menú** para agregar y mostrar canciones. Usa la
     * clase `Faker` para generar 100 canciones.
     */

    private String titulo, artista;
    private double duracion; // GUARDARE COMO MINUTOS,SEGUNDOS, AL MOSTRAR CONVIERTO A STRING Y SUSTITUYO ','
    // POR ':'

    public Cancion(String titulo, String artista, double duracion) {
        this.titulo = titulo;
        this.artista = artista;
        this.duracion = duracion;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public void setDuracion(double duracion) {
        if (duracion > 0) {
            this.duracion = duracion;
        }
    }

    public String getTitulo() {
        return titulo;
    }

    public String getArtista() {
        return artista;
    }

    public double getDuracion() {
        return duracion;
    }

    public String duracionString() {
        String resultado;
        resultado = Double.toString(this.duracion);
        resultado = resultado.replace(".", ":");
        return resultado;
    }

    @Override
    public String toString() {
        String cancionMostrable = "Título: " + getTitulo() + " | Artista: " + getArtista() + " | Duracion: "
                + duracionString();
        return cancionMostrable;
    }
}
