package prog.ud_4.apuntes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class apuntes {
    public static void main(String[] args) {
        // Variable de prueba:
        int opcion = 0;

        /* ================== CREAR SCANNER ================== */
        Scanner scanner = new Scanner(System.in); // Objeto scanner

        // IMPORTANTE: Al terminar de preguntar cerrar scanner con scanner.close();

        /* =============== PEDIR INPUT AL USER =============== */
        System.out.println("- SIN CONTROL -");

        System.out.println("Selecciona tu opción"); // Imprimimos en la consola para describir la peticion

        opcion = Integer.parseInt(scanner.nextLine()); // Igualamos el input a la variable
        // Nota: pedimos un string y luego lo cambiamos a entero para evitar errores

        /* ============== CONTROL INPUT ERRONEO ============== */
        opcion = -1; // Reset
        System.out.println("- CON CONTROL -");

        /**
         * Hace un while mientras que el input sea menor a 0
         * Comprueba cada vez que el valor que introduciremos a scanner es un número
         * entero antes de darselo (Evita un crash)
         */
        System.out.println("Selecciona tu opción");
        do {
            if (scanner.hasNextInt()) {
                opcion = scanner.nextInt();
                if (opcion <= 0) {
                    System.out.println("La opción introducida no es mayor que 0");
                }
            } else {
                scanner.nextLine();
                System.out.println("Introduce una opción mayor que 0");
            }
        } while (opcion <= 0);

        /* =================== CREAR ARRAY =================== */

        ArrayList<String> arrayVacio = new ArrayList<>(); // Array vacío
        ArrayList<String> arrayStrings = new ArrayList<>(Arrays.asList("ex1", "ex2")); // Array con varios elementos
        ArrayList<Integer> arrayIntegers = new ArrayList<>(Arrays.asList(1, 2, 3, 4)); // Array con varios elementos

        /* ================== IMPRIMIR ARRAY STRING ================= */
        System.out.println("- ARRAY STRING ADAPTADO -");
        System.out.println(String.join(" - ", arrayStrings));

        /* ================== IMPRIMIR ARRAY NUMERO ================= */
        System.out.println("- ARRAY INT ADAPTADO -");
        /**
         * Crea una variable mensaje
         * Recorre el array elemento por elemento añadiendolo al mensaje
         * Lo imprime
         */
        String mensaje = "";
        for (Integer elemento : arrayIntegers) {
            mensaje += elemento + " - ";
        }

        mensaje = mensaje.substring(0, mensaje.length() - 1);
        System.out.println("Ejemplos: " + mensaje);

        /* ============== MENÚ DE OPCIONES ============== */

        System.out.println(arrayVacio);
        scanner.close();
    }
}
