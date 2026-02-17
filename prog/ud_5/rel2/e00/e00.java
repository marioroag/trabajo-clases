package prog.ud_5.rel2.e00;

//Crea una clase Estudiante con atributos nombre, edad y número de matrícula. 
// Implementa los métodos get y set para cada atributo, así como el método toString()

public class e00 {

    public static void main(String[] args) {

        Estudiante estudiante1 = new Estudiante("Carlota", 5, "STEM0067");
        estudiante1.setNombre("María");
        estudiante1.setEdad(-15);
        // System.out.println(estudiante1.getNombre());
        // System.out.println(estudiante1.getEdad());
        // System.out.println(estudiante1.getNumeroDeMatricula());
        Estudiante estudiante2 = new Estudiante("Miguel", 25);
        Estudiante estudiante3 = new Estudiante("Raul", "STE0068");
        System.out.println(estudiante1);
        System.out.println(estudiante2);
        System.out.println(estudiante3);
    }
}

class Estudiante {

    private String nombre;
    private int edad;
    private String numeroDeMatricula;

    public Estudiante(String nombre, int edad, String numeroDeMatricula) {
        this.nombre = nombre;
        setEdad(edad);
        setNumeroDeMatricula(numeroDeMatricula);
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
        }
    }

    @Override
    public String toString() {
        String estudianteSring = "Estudiante [nombre=" + nombre + ", edad=" + edad + ", numeroDeMatricula="
                + numeroDeMatricula
                + "]";
        if (edad < 18) {
            estudianteSring = "Estudiante menor de edad. Información restringida" +
                    "\nFacilitamos numero de matricula: " + getNumeroDeMatricula();
        }
        return estudianteSring;
    }

}
