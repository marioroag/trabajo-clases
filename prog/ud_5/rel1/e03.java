package prog.ud_5.rel1;

public class e03 {
    /*
     * Ejercicio 3: Clase Alumno
     * Crea una clase Alumno con atributos nombre, materia y calificacion. Agrega un
     * método aprobo() que devuelva True si la calificación es mayor o igual a 6, y
     * False en caso contrario.
     */

    public static void main(String[] args) {
        Alumno alumno1 = new Alumno("Pepe", "Programacion", 3);

        System.out.println("¿" + alumno1.nombre + " aprobó " + alumno1.materia + " con una calificacion de "
                + alumno1.calificacion + "?");

        if (alumno1.aprobo()) {
            System.out.println("Si");
        } else {
            System.out.println("No");
        }
    }
}

class Alumno {
    String nombre;
    String materia;
    int calificacion;

    Alumno(String nombre, String materia, int calificacion) {
        this.nombre = nombre;
        this.materia = materia;
        this.calificacion = calificacion;
    }

    boolean aprobo() {
        return (this.calificacion >= 6);
    }
}
