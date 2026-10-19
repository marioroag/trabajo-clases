package prog.ud_5.rel_02.e01;

public class Estudiante {
    private String nombre;
    private int edad;
    private String numeroDeMatricula;

    public Estudiante(String nombre, int edad, String numeroDeMatricula) {
        this.nombre = nombre;
        setEdad(edad);
        setNumeroDeMatricula(numeroDeMatricula);
    }

    public Estudiante() {
        this.nombre = null;
        this.edad = 0;
        this.numeroDeMatricula = null;
    }

    public Estudiante(String nombre, int edad) {
        this.nombre = nombre;
        setEdad(edad);
        this.numeroDeMatricula = "SIN ASIGNAR";
    }

    public Estudiante(String nombre, String numeroDeMatricula) {
        this.nombre = nombre;
        setNumeroDeMatricula(numeroDeMatricula);
    }

    public String getNombre() {
        String nombreMostar = nombre;
        if (edad < 18) {
            nombreMostar = "Estudiante menor de edad. Nombre restringido";
        }
        return nombreMostar;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        if (edad >= 0) {
            this.edad = edad;
        }
    }

    public String getNumeroDeMatricula() {
        return numeroDeMatricula;
    }

    public void setNumeroDeMatricula(String numeroDeMatricula) {
        if (numeroDeMatricula.startsWith("STEM")) {
            this.numeroDeMatricula = numeroDeMatricula;
        } else {
            this.numeroDeMatricula = "MATRICULA PENDIENTE";

        }
    }

    @Override
    public String toString() {
        String estudianteString = "Estudiante [nombre=" + nombre + ", edad=" + getEdad() + ", numeroDeMatricula="
                + numeroDeMatricula
                + "]";
        if (edad < 18) {
            estudianteString = "Estudiante menor de edad. Información restringida" +
                    "\nFacilitamos numero de matricula: " + getNumeroDeMatricula();
        }
        return estudianteString;
    }

}
