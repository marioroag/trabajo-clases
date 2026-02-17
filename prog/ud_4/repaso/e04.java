package prog.ud_4.repaso;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class e04 {

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
            imprimirMensaje(mensaje);
            texto = scanner.nextLine().trim();
            if (texto.isEmpty()) {
                imprimirMensaje("No puede estar vacío");
            }
        } while (texto.isEmpty());

        return texto;
    }

    public static double leerDouble(Scanner scanner, String mensaje) {
        boolean doubleValido = false;
        double num = -1;

        do {
            imprimirPrompt(mensaje);
            if (scanner.hasNextDouble()) {
                num = scanner.nextDouble();
                scanner.nextLine(); // limpiar buffer
                doubleValido = true;
            } else {
                imprimirMensaje("Introduce un número válido");
                scanner.nextLine();
            }
        } while (!doubleValido);

        return (double) num;
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

    public static boolean opcionEnLista(Scanner scanner, ArrayList<String> arrayOpciones, String aComprobar,
            String mensaje) {
        aComprobar = leerTexto(scanner, mensaje);

        do {
            imprimirPrompt("Esa opción no está en la lista.");
            aComprobar = leerTexto(scanner, mensaje);
        } while (!arrayOpciones.contains(aComprobar));

        return true;
    }

    public static void aniadirDatos(
            Scanner scanner,
            ArrayList<String> lista1, String mensaje1,
            ArrayList<Double> lista2, String mensaje2,
            ArrayList<Double> lista3, String mensaje3,
            ArrayList<String> lista4, String mensaje4, ArrayList<String> opcionesLista4) {

        lista1.add(leerTexto(scanner, mensaje1));
        lista2.add(leerDoublePositivo(scanner, mensaje2));
        lista3.add(leerDoublePositivo(scanner, mensaje3));

        String opcion;
        do {
            opcion = leerTexto(scanner, mensaje4);
            if (!opcionesLista4.contains(opcion)) {
                imprimirMensaje("Esa opción no está en la lista.");
            }
        } while (!opcionesLista4.contains(opcion));

        lista4.add(opcion);

    }

    public static void eliminarPorIndice(Scanner scanner, int cantidadElementos, String mensaje,
            ArrayList<?>... listas) {

        // Eliminar lote
        if (cantidadElementos == 0) {
            imprimirMensaje("No hay lotes disponibles.");
        } else {
            int indice = elegirIndice(scanner, cantidadElementos, mensaje);
            for (ArrayList<?> lista : listas) {
                lista.remove(indice);
            }
        }
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

    public static String elegirAleatorio(ArrayList<String> lista) {
        int pos = (int) (Math.random() * lista.size());
        return lista.get(pos);
    }

    public static void mostrarMensajeAleatorioCondicional(
            boolean condicion,
            ArrayList<String> mensajesTrue,
            ArrayList<String> mensajesFalse,
            String mensajeExtraFalse) {

        if (condicion) {
            imprimirMensaje(elegirAleatorio(mensajesTrue));
        } else {
            imprimirMensaje(elegirAleatorio(mensajesFalse));

            if (mensajeExtraFalse != null && !mensajeExtraFalse.isEmpty()) {
                imprimirMensaje(mensajeExtraFalse);
            }
        }
    }

    // PLANTILLA MENU:
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Variables:
        int tractorAComprobar = -1;

        // Variables para poder calcular el gasto de ruta
        String terreno;
        int indiceTerreno;
        double gasto;

        // Almacenaje en arrays

        ArrayList<String> opcionesMenu = new ArrayList<>(
                Arrays.asList("Salir", "Añadir ruta", "Listar rutas", "Calcular consumo", "Eliminar ruta"));

        ArrayList<String> tractores = new ArrayList<>(
                Arrays.asList("Tractor A", "Tractor B", "Tractor C", "Tractor D"));
        ArrayList<Double> kilometros = new ArrayList<>(Arrays.asList(345.1, 625.9, 145.7, 215.2));
        ArrayList<Double> litrosDisponibles = new ArrayList<>(Arrays.asList(23.1, 68.9, 42.6, 53.0));
        ArrayList<String> terrenos = new ArrayList<>(Arrays.asList("llano", "mixto", "montaña", "llano"));

        ArrayList<Double> gastosTerrenos = new ArrayList<>(Arrays.asList(0.12, 0.18, 0.25));
        ArrayList<String> opcionesTerrenos = new ArrayList<>(Arrays.asList("llano", "mixto", "montaña"));

        ArrayList<String> mensajesViable = new ArrayList<>(Arrays.asList("Ruta aprobada para el tractor.",
                "El tractor tiene suficiente combustible para la ruta."));
        ArrayList<String> mensajesNoViable = new ArrayList<>(
                Arrays.asList("No hay suficiente combustible.", "Reposta antes de comenzar la ruta."));

        int opcionMenu;

        do {
            opcionMenu = leerOpcionMenu(scanner, opcionesMenu);

            if (opcionMenu == 0) {
                imprimirMensaje("Saliendo del programa...");
            } else if (opcionMenu == 1) {
                // Añadir ruta
                aniadirDatos(scanner, tractores, "Añadir tractor: ", kilometros, "Kilometros: ", litrosDisponibles,
                        "Litros disponibles: ", terrenos, "Terrenos: ", opcionesTerrenos);
            } else if (opcionMenu == 2) {
                // Listar rutas
                mostrarListado(tractores, kilometros, litrosDisponibles, terrenos, "Tractor", "Kilometros",
                        "Litros Disp.", "Terrenos");
            } else if (opcionMenu == 3) {
                // Calcular consumo
                mostrarListado(tractores, kilometros, litrosDisponibles, terrenos, "Tractor", "Kilometros",
                        "Litros Disp.", "Terrenos");

                // Pregunto por un indice
                tractorAComprobar = elegirIndice(scanner, tractores.size(),
                        "Selecciona que tractor quieres comprobar: ");

                // Calculos de gasto
                terreno = terrenos.get(tractorAComprobar);
                indiceTerreno = opcionesTerrenos.indexOf(terreno);
                gasto = gastosTerrenos.get(indiceTerreno) * kilometros.get(tractorAComprobar);

                // Dif mensaje dependiendo en si puede completar ruta
                if (gasto > litrosDisponibles.get(tractorAComprobar)) {
                    imprimirMensaje(elegirAleatorio(mensajesViable));
                } else {
                    imprimirMensaje(elegirAleatorio(mensajesNoViable));
                    imprimirMensaje("Te faltan " + Math.round(litrosDisponibles.get(tractorAComprobar) - gasto)
                            + " litros para poder completar esta ruta.");
                }

            } else if (opcionMenu == 4) {
                // Eliminar ruta
                mostrarListado(tractores, kilometros, litrosDisponibles, terrenos, "Tractor", "Kilometros",
                        "Litros Disp.", "Terrenos");

                eliminarPorIndice(scanner, tractores.size(), "Elige la ruta a eliminar: ", tractores, kilometros,
                        litrosDisponibles, terrenos);
            }
        } while (opcionMenu != 0);

        scanner.close();
    }
}