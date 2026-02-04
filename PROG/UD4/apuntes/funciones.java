package apuntes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class funciones {
    public static int leerIntPositivo(Scanner scanner, String mensaje) {
        int num;
        do {
            num = leerInt(scanner, mensaje);
            if (num <= 0) {
                imprimirMensaje("Debe ser mayor que 0");
            }
        } while (num <= 0);

        return num;
    }

    public static double leerDouble(Scanner scanner, String mensaje) {
        boolean doubleValido = false;
        double num = -1;

        do {
            imprimirMensaje(mensaje);
            if (scanner.hasNextDouble()) {
                num = scanner.nextDouble();
                scanner.nextLine(); // limpiar buffer
                doubleValido = true;
            }
            imprimirMensaje("Introduce un número válido");
            scanner.nextLine();

        } while (!doubleValido);

        return num;
    }

    public static double leerDoublePositivo(Scanner scanner, String mensaje) {
        double num;
        do {
            num = leerDouble(scanner, mensaje);
            if (num <= 0) {
                imprimirMensaje("Debe ser mayor que 0");
            }
        } while (num <= 0);

        return num;
    }

    public static String leerTexto(Scanner scanner, String mensaje) {
        String texto;
        do {
            imprimirMensaje(mensaje);
            texto = scanner.nextLine();
            if (texto.isEmpty()) {
                imprimirMensaje("No puede estar vacío");
            }
        } while (texto.isEmpty());

        return texto;
    }

    // Comprobar si opcion esta en array antes de continuar
    public static boolean opcionEnLista(Scanner scanner, ArrayList<String> arrayOpciones, String aComprobar,
            String mensaje) {
        aComprobar = leerTexto(scanner, mensaje);

        do {
            imprimirMensaje("Esa opción no está en la lista.");
            aComprobar = leerTexto(scanner, mensaje);
        } while (!arrayOpciones.contains(aComprobar));

        return true;
    }

    /*
     * EJ:
     * public static String elegirAleatorio(ArrayList<String> lista) {
     * int pos = (int)(Math.random() * lista.size());
     * return lista.get(pos);
     * }
     */
    public static String elegirAleatorio(ArrayList<String> lista) {
        int pos = (int) (Math.random() * lista.size());
        return lista.get(pos);
    }

    // Sirve para tres arrays, adptar en caso de ejercicio diferente
    public static void mostrarListado(
            ArrayList<?> lista1,
            ArrayList<?> lista2,
            ArrayList<?> lista3,
            String etiqueta1,
            String etiqueta2,
            String etiqueta3) {
        String mensaje = "";

        for (int i = 0; i < lista1.size(); i++) {
            mensaje += "\n" + (i + 1) + ". "
                    + etiqueta1 + ": " + lista1.get(i) + " | "
                    + etiqueta2 + ": " + lista2.get(i) + " | "
                    + etiqueta3 + ": " + lista3.get(i);
        }

        imprimirMensaje(mensaje);
    }

    public static void eliminarPorIndice(
            Scanner scanner,
            int cantidadElementos,
            String mensaje,
            ArrayList<?>... listas) {
        int indice;

        do {
            indice = leerInt(scanner, mensaje) - 1;
        } while (!validarOpcion(indice, cantidadElementos - 1));

        for (ArrayList<?> lista : listas) {
            lista.remove(indice);
        }
    }

    public static boolean validarOpcion(int opcion, int max) {
        return opcion >= 0 && opcion <= max;
    }

    // -- FUNCIONES PARA MENU --
    public static void imprimirMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public static int leerInt(Scanner scanner, String mensaje) {
        int num = -1;
        boolean intValido = false;

        do {
            imprimirMensaje(mensaje);
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

    public static boolean rangoOpcionVálido(int opcion, int max) {
        return opcion >= 0 && opcion <= max;
    }

    public static void mostrarMenu(ArrayList<String> opciones) {
        imprimirMensaje("\n--- MENÚ ---");
        for (int i = 0; i < opciones.size(); i++) {
            imprimirMensaje(i + ". " + opciones.get(i));
        }
    }

    public static int leerOpcionMenu(Scanner scanner, ArrayList<String> menu) {
        int opcion;
        do {
            mostrarMenu(menu);
            opcion = leerInt(scanner, "Opción: ");
            if (!rangoOpcionVálido(opcion, menu.size() - 1)) {
                imprimirMensaje("Opción fuera de rango");
            }
        } while (!rangoOpcionVálido(opcion, menu.size() - 1));

        return opcion;
    }

    // PLANTILLA MENU:
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        ArrayList<String> opcionesMenu = new ArrayList<>(Arrays.asList("Opcion1", "Opcion2", "Opcion3", "Opcion4"));

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
