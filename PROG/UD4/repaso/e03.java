package repaso;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class e03 {
    // -- FUNCIONES PARA MENU --
    public static boolean validarOpcion(int opcionValor, int max) {
        return opcionValor >= 0 && opcionValor <= max;
    }

    public static void imprimirMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    static void imprimirPrompt(String mensaje) {
        System.out.print(mensaje);
    }

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
            if (!validarOpcion(opcion, menu.size() - 1)) {
                imprimirMensaje("Opción fuera de rango");
            }
        } while (!validarOpcion(opcion, menu.size() - 1));

        return opcion;
    }

    public static String leerTexto(Scanner scanner, String mensaje) {
        String texto;
        do {
            imprimirPrompt(mensaje);
            texto = scanner.nextLine();
            if (texto.isEmpty()) {
                imprimirMensaje("No puede estar vacío");
            }
        } while (texto.isEmpty());

        return texto;
    }

    public static void aniadirDatos(
            Scanner scanner,
            ArrayList<String> lista1, String mensaje1,
            ArrayList<Integer> lista2, String mensaje2,
            ArrayList<Integer> lista3, String mensaje3,
            ArrayList<String> lista4, String mensaje4) {

        lista1.add(leerTexto(scanner, mensaje1)); // modelo

        lista2.add(leerIntPositivo(scanner, mensaje2)); // precio inicial

        lista3.add(0); // mejor puja (empieza en 0)

        lista4.add("NADIE"); // mejor postor

    }

    public static void mostrarListado(
            ArrayList<?> lista1,
            ArrayList<?> lista2,
            ArrayList<?> lista3,
            ArrayList<?> lista4,
            String etiqueta1,
            String etiqueta2,
            String etiqueta3,
            String etiqueta4) {
        String mensaje = "";

        for (int i = 0; i < lista1.size(); i++) {
            mensaje += "\n" + (i + 1) + ". "
                    + etiqueta1 + ": " + lista1.get(i) + " | "
                    + etiqueta2 + ": " + lista2.get(i) + " | "
                    + etiqueta3 + ": " + lista3.get(i) + " | "
                    + etiqueta4 + ": " + lista4.get(i);
        }

        imprimirMensaje(mensaje);
    }

    public static int elegirIndice(Scanner scanner, int cantidadElementos, String mensaje) {
        int indice;

        do {
            indice = leerInt(scanner, mensaje) - 1;
        } while (!validarOpcion(indice, cantidadElementos - 1));

        return indice;
    }

    public static void eliminarPorIndice(Scanner scanner, int cantidadElementos, String mensaje,
            ArrayList<?>... listas) {
        int indice = elegirIndice(scanner, cantidadElementos, mensaje);

        for (ArrayList<?> lista : listas) {
            lista.remove(indice);
        }
    }

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

    // PLANTILLA MENU:
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Variables
        int pujaSeleccionada = -1;
        String nuevaPostor = "";
        int nuevaPuja = -1;

        // Almacenaje:
        ArrayList<String> modelo = new ArrayList<>(Arrays.asList(
                "Rolex Submariner",
                "Omega Speedmaster",
                "Tag Heuer Carrera"));

        ArrayList<Integer> precioInicial = new ArrayList<>(Arrays.asList(
                8000,
                6000,
                4500));

        ArrayList<Integer> mejorPuja = new ArrayList<>(Arrays.asList(
                9200,
                6500,
                5000));

        ArrayList<String> postor = new ArrayList<>(Arrays.asList(
                "Carlos",
                "Lucía",
                "Miguel"));

        ArrayList<String> opcionesMenu = new ArrayList<>(
                Arrays.asList("Salir", "Añadir lote", "Listar lotes", "Hacer puja", "Ver ganador actual",
                        "Eliminar lote"));

        int opcionMenu;

        do {
            opcionMenu = leerOpcionMenu(scanner, opcionesMenu);

            if (opcionMenu == 0) {
                imprimirMensaje("Saliendo del programa...");
            } else if (opcionMenu == 1) {
                // Añadir lote
                aniadirDatos(scanner, modelo, "Modelo: ", precioInicial, "Precio inicial: ", mejorPuja, "Mejor puja: ",
                        postor, "Postor: ");

            } else if (opcionMenu == 2) {
                // Listar lotes
                mostrarListado(modelo, precioInicial, mejorPuja, postor, "Modelo", "Precio inicial", "Mejor puja",
                        "Postor");

            } else if (opcionMenu == 3) {
                // Hacer puja
                mostrarListado(modelo, precioInicial, mejorPuja, postor, "Modelo", "Precio inicial", "Mejor puja",
                        "Postor");

                // Solicito datos
                pujaSeleccionada = elegirIndice(scanner, modelo.size(), "Selecciona un lote: ");
                nuevaPostor = leerTexto(scanner, "Tu nombre: ");
                nuevaPuja = leerInt(scanner, "Cantidad (€): ");

                // Compruebo validez
                if (nuevaPuja > mejorPuja.get(pujaSeleccionada) && nuevaPuja > precioInicial.get(pujaSeleccionada)) {
                    // Cambio del mejor postor
                    mejorPuja.set(pujaSeleccionada, nuevaPuja);
                    postor.set(pujaSeleccionada, nuevaPostor);
                    System.out.println("Puja realizada con éxito.");
                } else {
                    if (nuevaPuja < mejorPuja.get(pujaSeleccionada)) {
                        imprimirMensaje("No supera la mejor puja actual.");
                    } else if (nuevaPuja < precioInicial.get(pujaSeleccionada)) {
                        imprimirMensaje("No llega al precio inicial.");
                    }
                }

            } else if (opcionMenu == 4) {
                // Ver ganador actual
                mostrarListado(modelo, precioInicial, mejorPuja, postor, "Modelo", "Precio inicial", "Mejor puja",
                        "Postor");

                // Solicito una puja
                pujaSeleccionada = elegirIndice(scanner, modelo.size(), "Selecciona un lote: ");

                // Solo si existen lotes disponibles
                if (modelo.size() == 0) {
                    imprimirMensaje("No hay lotes disponibles.");
                } else {
                    // Solo muestro los datos si hay alguna puja
                    if (mejorPuja.get(pujaSeleccionada) == 0) {
                        imprimirMensaje("Sin pujas todavía.");
                    } else {
                        imprimirMensaje("Ganador actual: " + postor.get(pujaSeleccionada) + " | Puja ganadora: "
                                + mejorPuja.get(pujaSeleccionada));
                    }
                }

            } else if (opcionMenu == 5) {
                // Eliminar lote
                if (modelo.size() == 0) {
                    imprimirMensaje("No hay lotes disponibles.");
                } else {
                    mostrarListado(modelo, precioInicial, mejorPuja, postor, "Modelo", "Precio inicial", "Mejor puja",
                            "Postor");
                    eliminarPorIndice(scanner, modelo.size(), "Elige el lote a eliminar: ", modelo, mejorPuja, postor,
                            precioInicial);
                }
            }
        } while (opcionMenu != 0);

        scanner.close();
    }
}
