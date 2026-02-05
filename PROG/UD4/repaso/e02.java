package repaso;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class e02 {
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

    // -- FUNCIONES PARA MENU --
    public static void imprimirMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public static boolean validarOpcion(int opcion, int max) {
        return opcion >= 0 && opcion <= max;
    }

    public static void mostrarMenu(ArrayList<String> opciones) {
        imprimirMensaje("\n--- MENÚ ---");
        for (int i = 0; i < opciones.size(); i++) {
            imprimirMensaje(i + ". " + opciones.get(i));
        }
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

    // Comprobar si opcion esta en array antes de continuar
    public static String opcionEnLista(
            Scanner scanner,
            ArrayList<String> arrayOpciones,
            String mensaje) {
        String opcion;

        do {
            opcion = leerTexto(scanner, mensaje);

            if (!arrayOpciones.contains(opcion)) {
                imprimirMensaje("Esa opción no está en la lista.");
            }

        } while (!arrayOpciones.contains(opcion));

        return opcion;
    }

    public static void eliminarPorIndice(Scanner scanner, int cantidadElementos, String mensaje,
            ArrayList<?>... listas) {
        int indice = elegirIndice(scanner, cantidadElementos, mensaje);

        for (ArrayList<?> lista : listas) {
            lista.remove(indice);
        }
    }

    public static int elegirIndice(Scanner scanner, int cantidadElementos, String mensaje) {
        int indice;

        do {
            indice = leerInt(scanner, mensaje) - 1;
        } while (!validarOpcion(indice, cantidadElementos - 1));

        return indice;
    }

    public static void main(String[] args) {
        // EJERCICIO 2 — Taller de Tractores: Revisiones
        // Objetivo: Gestionar un historial de revisiones y calcular el coste final de
        // cada una.

        // Variables
        String stringTemp = "", matriculaActual;
        int revisionSeleccionada = -1;
        int cantidadRevisiones = 3;
        double costoEstaRevision = 0;

        final double costoBasica = 60;
        final double costoCompleta = 120;
        final double precioPorExtra = 15;

        ArrayList<String> tiposRevision = new ArrayList<>(Arrays.asList("basica", "completa"));

        // Almacenaje de datos
        ArrayList<String> matriculas = new ArrayList<>();
        ArrayList<String> revision = new ArrayList<>();
        ArrayList<Integer> extras = new ArrayList<>();
        ArrayList<Double> costeFinal = new ArrayList<>();
        ArrayList<Boolean> descuentoAplicado = new ArrayList<>();

        // Placeholder:
        matriculas.add("1234ABC");
        revision.add("basica");
        extras.add(2);
        costeFinal.add(250.50);

        matriculas.add("5678DEF");
        revision.add("completa");
        extras.add(0);
        costeFinal.add(180.00);

        matriculas.add("9012GHI");
        revision.add("basica");
        extras.add(4);
        costeFinal.add(320.75);

        Scanner scanner = new Scanner(System.in);

        ArrayList<String> opcionesMenu = new ArrayList<>(Arrays.asList("Salir", "Añadir revisión", "Listar revisiones",
                "Mostrar coste (por índice)", "Eliminar revisión"));

        int opcionMenu;

        do {
            opcionMenu = leerOpcionMenu(scanner, opcionesMenu);

            if (opcionMenu == 0) {
                // Salir
                imprimirMensaje("Saliendo del programa...");

            } else if (opcionMenu == 1) {
                // Añadir revisiones
                matriculas.add(leerTexto(scanner, "Introduce la matrícula:"));
                stringTemp = opcionEnLista(
                        scanner,
                        tiposRevision,
                        "Introduzca un tipo de revisión (basica o completa):");
                revision.add(stringTemp);
                extras.add(leerInt(scanner, "Introduce cantidad de extras:"));

                // Calculos coste final
                if (revision.getLast().equals("basica")) {
                    costoEstaRevision += costoBasica;
                } else {
                    costoEstaRevision += costoCompleta;
                }

                costoEstaRevision += precioPorExtra * extras.getLast();

                // DESCUENTO POR MATRÍCULA PAR
                matriculaActual = matriculas.getLast();
                char ultimoCaracter = matriculaActual.charAt(matriculaActual.length() - 1);

                if (Character.isDigit(ultimoCaracter) && (ultimoCaracter - '0') % 2 == 0) {
                    costoEstaRevision *= 0.9; // 10% de descuento
                    imprimirMensaje("Descuento del 10% aplicado por matrícula par.");
                    descuentoAplicado.add(true);
                } else {
                    imprimirMensaje("La matrícula no termina en número par. No hay descuento.");
                    descuentoAplicado.add(false);
                }

                costeFinal.add(costoEstaRevision);

                costoEstaRevision = 0; // reset

                cantidadRevisiones++;
            } else if (opcionMenu == 2) {
                // Listar revisiones
                if (cantidadRevisiones <= 0) {
                    imprimirMensaje("No tienes revisiones todavía.");
                } else {
                    mostrarListado(matriculas, revision, extras, costeFinal, "Matrícula", "Revision", "Extras",
                            "Coste");
                }

            } else if (opcionMenu == 3) {
                // Mostrar coste
                revisionSeleccionada = elegirIndice(scanner, cantidadRevisiones,
                        "Elige sobre que indice quieres ver el coste: ");

                imprimirMensaje(String.valueOf(costeFinal.get(revisionSeleccionada)));

            } else if (opcionMenu == 4) {
                // codigo
                mostrarListado(matriculas, revision, extras, costeFinal, "Matrícula", "Revision", "Extras",
                        "Coste");

                eliminarPorIndice(
                        scanner,
                        cantidadRevisiones,
                        "Elige un tractor para eliminar (1 - " + cantidadRevisiones + "): ",
                        matriculas,
                        revision,
                        extras,
                        costeFinal);

                cantidadRevisiones--;
            }

        } while (opcionMenu != 0);

        scanner.close();
    }
}
