package PROG.UD5.rel2.e01;

import PROG.UD5.faker;

import java.util.Scanner;

// Crea una clase Estudiante con atributos nombre, edad y número de matrícula. 
// Implementa los métodos get y set para cada atributo, así como el método toString()

public class main {
    public static void main(String[] args) {
        String matriculaABuscar;
        Scanner input = new Scanner(System.in);
        estudiante buscado;
        estudiante estudiante1 = new estudiante("Carlota", 5, "STEM0067");
        estudiante estudiante2 = new estudiante("Miguel", 25);
        estudiante estudiante3 = new estudiante("Raul", "STE0068");

        Universidad uni = new Universidad();
        uni.agregarEstudiante(estudiante1);
        uni.agregarEstudiante(estudiante2);
        uni.agregarEstudiante(estudiante3);

        System.out.println(uni);
        matriculaABuscar = input.nextLine();
        buscado = uni.buscarEstudiante(matriculaABuscar);
        if (buscado != null) {
            System.out.println(buscado);
        } else {
            System.err.println("Estudiante no encontrado");
        }

        input.close();

        final int CANTIDAD_ALUMNOS = 100;

        Universidad laRioja = new Universidad();
        estudiante aleatorio = new estudiante();

        for (int i = 0; i < CANTIDAD_ALUMNOS; i++) {
            aleatorio = new estudiante(faker.nombre(), faker.edad(), "STEM" + i);
            laRioja.agregarEstudiante(aleatorio);
        }

        System.out.println(laRioja);

    }
}
