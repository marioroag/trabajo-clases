package PROG.UD5.rel2.e03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/*
 * Ejercicio 3: Supermercado y Productos
 * 
 * Crea una clase Producto con atributos id, nombre, descripción, precio y
 * cantidadEnStock. Implementa los métodos get y set para cada atributo, así
 * como el método toString(). Luego, crea una clase Supermercado con un array de
 * productos y métodos para:
 * 
 * Agregar productos
 * Vender un producto (reducir cantidadEnStock)
 * Mostrar el inventario
 * En el main, implementa un menú para vender y reponer productos. Usa la clase
 */

public class main {
    // imprimirPrompt("Mensajedeimpresion");
    static void imprimirPrompt(String mensaje) {
        System.out.print(mensaje);
    }

    // imprimirMensaje("Mensajedeimpresion");
    public static void imprimirMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    // validarOpcion(opcionValor, max);
    public static boolean validarOpcion(int opcionValor, int max) {
        return opcionValor >= 0 && opcionValor <= max;
    }

    // leerInt(scanner, "Mensajedeentrada");
    public static int leerInt(Scanner scanner, String mensaje) {
        int num = -1;
        boolean intValido = false;

        do {
            imprimirPrompt(mensaje);
            if (scanner.hasNextInt()) {
                num = scanner.nextInt();
                scanner.nextLine(); // limpiar buffer
                intValido = true;
            } else {
                imprimirMensaje("Introduce un número entero válido");
                scanner.nextLine(); // limpiar buffer
            }
        } while (!intValido);

        return num;
    }

    // mostrarMenu(opciones);
    public static void mostrarMenu(ArrayList<String> opciones) {
        imprimirMensaje("\n--- MENÚ ---");
        for (int i = 0; i < opciones.size(); i++) {
            imprimirMensaje(i + ". " + opciones.get(i));
        }
    }

    // leerOpcionMenu(scanner, menu);
    public static int leerOpcionMenu(Scanner scanner, ArrayList<String> menu) {
        int opcion;
        do {
            mostrarMenu(menu);
            opcion = leerInt(scanner, "Opción: ");
            if (!validarOpcion(opcion, menu.size() - 1)) {
                imprimirMensaje("Opción fuera de rango");
            }
        } while (!validarOpcion(opcion, menu.size() - 1));

        return opcion;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        ArrayList<String> opcionesMenu = new ArrayList<>(
                Arrays.asList("Salir", "Reponer producto", "Vender producto", "Mostrar inventario"));

        int opcionMenu;

        do {
            opcionMenu = leerOpcionMenu(scanner, opcionesMenu);

            if (opcionMenu == 0) {
                imprimirMensaje("Saliendo del programa...");
            } else if (opcionMenu == 1) {
                // codigo
            } else if (opcionMenu == 2) {
                // codigo
            } else if (opcionMenu == 3) {
                // codigo
            } else if (opcionMenu == 4) {
                // codigo
            }

        } while (opcionMenu != 0);

        scanner.close();
    }
}