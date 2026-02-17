package prog.ud_4.ud2_rel2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Ejercicio4 {

    public static boolean aniadirSinDuplicados(String posibleDuplicado, ArrayList<String> array) {
        boolean duplicadosEncontrado = false;

        for (int i = 0; i < array.size() && !duplicadosEncontrado; i++) {
            if (array.get(i).equalsIgnoreCase(posibleDuplicado)) {
                duplicadosEncontrado = true;
            }
        }
        if (!duplicadosEncontrado) {
            array.add(posibleDuplicado);

        } else {
            imprimirMensaje("No se añade " + posibleDuplicado + " ya que está en el array");
        }

        return duplicadosEncontrado;
    }

    public static void leerStringArray(String mensajeString, ArrayList<String> array, Scanner sc) {
        String stringUsuario;
        do {
            imprimirMensaje(mensajeString);
            stringUsuario = sc.nextLine();
        } while (aniadirSinDuplicados(stringUsuario, array));
    }

    public static void imprimirMensaje(String mensajeAMostrar) {
        System.out.println(mensajeAMostrar);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> libros = new ArrayList<>(
                Arrays.asList("El quijote", "La Biblia", "Manual de resistencia", "La criada"));
        ArrayList<Integer> cantidades = new ArrayList<>(Arrays.asList(5, 3, 1, 7));

        String opcion = "";
        int cantidadLibroNuevo;
        String libroActualizado;
        int cantidadLibroActualizado;
        boolean encontrado;
        String mensaje;

        while (!opcion.equals("4")) {
            System.out.println("1. Añadir un nuevo libro\n" +
                    "2. Actualizar cantidad\n" +
                    "3. Ver inventario\n" +
                    "4. Salir");

            opcion = scanner.nextLine();

            if (opcion.equals("1")) {

                leerStringArray("Introduzca el nombre del nuevo libro", libros, scanner);

                System.out.println("Cantidad disponible: ");
                cantidadLibroNuevo = scanner.nextInt();
                scanner.nextLine();
                cantidades.add(cantidadLibroNuevo);

            } else if (opcion.equals("2")) {
                System.out.println("Nombre del libro a Actualizar");
                libroActualizado = scanner.nextLine();

                System.out.println("Nueva cantidad: ");
                cantidadLibroActualizado = scanner.nextInt();
                scanner.nextLine();

                encontrado = false;

                for (int i = 0; i < libros.size() && !encontrado; i++) {
                    if (libros.get(i).equalsIgnoreCase(libroActualizado)) {
                        encontrado = true;
                        cantidades.set(i, cantidadLibroActualizado);
                    }
                }

                if (!encontrado) {
                    System.out.println("Libro no encontrado");
                }

            } else if (opcion.equals("3")) {
                System.out.println("Inventario: ");
                mensaje = "";
                for (int i = 0; i < libros.size(); i++) {
                    mensaje += libros.get(i) + " - " + cantidades.get(i) + " unidades\n";
                }

                System.out.println(mensaje);

            } else if (opcion.equals("4")) {
                System.out.println("Programa finalizado");
            } else {
                System.out.println("Introduce una opción válida");
            }
        }

        scanner.close();
    }
}
