package prog.ud_4.repaso;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class e01 {
    // EJERCICIO 1 — TractoMatch
    public static boolean validarTrabajo(String trabajo) {
        return trabajo.equals("arado")
                || trabajo.equals("transporte")
                || trabajo.equals("siembra");
    }

    public static int leerInt(Scanner scanner, String mensaje) {
        int num = -1;
        boolean intValido = false;

        do {
            System.out.print(mensaje);
            if (scanner.hasNextInt()) {
                num = scanner.nextInt();
                scanner.nextLine(); // limpiar buffer
                intValido = true;
            } else {
                System.out.println("Introduce un número entero válido");
                scanner.nextLine(); // limpiar buffer
            }
        } while (!intValido);

        return num;
    }

    public static boolean validarOpcion(int opcion, int max) {
        return opcion >= 0 && opcion <= max;
    }

    public static void mostrarMenu(ArrayList<String> opciones) {
        System.out.println("\n--- MENÚ ---");
        for (int i = 0; i < opciones.size(); i++) {
            System.out.println(i + ". " + opciones.get(i));
        }
    }

    public static int leerOpcionMenu(Scanner sc, ArrayList<String> menu) {
        int opcion;
        do {
            mostrarMenu(menu);
            opcion = leerInt(sc, "Opción: ");
            if (!validarOpcion(opcion, menu.size() - 1)) {
                System.out.println("Opción fuera de rango");
            }
        } while (!validarOpcion(opcion, menu.size() - 1));
        return opcion;
    }

    public static String mostrarTractores(ArrayList<String> marcaTractores, ArrayList<Integer> potenciaTractores,
            ArrayList<String> trabajoTractor) {
        String mensaje = "";
        for (int i = 0; i < marcaTractores.size(); i++) {
            mensaje += "\n" + (i + 1) + ". " + marcaTractores.get(i) + " | CV: " + potenciaTractores.get(i)
                    + " | Trabajo: "
                    + trabajoTractor.get(i);
        }

        return mensaje;
    }

    public static String elegirMensajeAleatorio(ArrayList<String> mensajes) {
        int pos = (int) (Math.random() * mensajes.size());
        return mensajes.get(pos);
    }

    public static String leerTexto(Scanner sc, String mensaje) {
        String texto;
        do {
            System.out.print(mensaje);
            texto = sc.nextLine();
            if (texto.isEmpty()) {
                System.out.println("No puede estar vacío");
            }
        } while (texto.isEmpty());
        return texto;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        final int minCvArado = 120;
        final int minCvTransporte = 90;
        final int minCvSiembra = 70;

        int opcionMenu, indiceTractores, cantidadTractores = 3;

        String trabajoAValidar;
        ArrayList<String> opcionesMenu = new ArrayList<>(Arrays.asList("Salir.", "Añadir tractor", "Listar tractores.",
                "Evaluar tractor (por índice).", "Eliminar tractor."));

        ArrayList<String> marca = new ArrayList<>();
        ArrayList<Integer> cvPotencia = new ArrayList<>();
        ArrayList<String> trabajoAsignado = new ArrayList<>();

        // (arado, transporte, siembra)
        ArrayList<Integer> cvPotenciaMin = new ArrayList<>(Arrays.asList(minCvArado, minCvTransporte, minCvSiembra));

        ArrayList<String> mensajesApto = new ArrayList<>(
                Arrays.asList(
                        "Tractor apto para el trabajo",
                        "Puede realizar la tarea sin problemas"));

        ArrayList<String> mensajesNoApto = new ArrayList<>(
                Arrays.asList(
                        "El tractor no es adecuado",
                        "Potencia insuficiente para este trabajo"));

        // Tractores de prueba (placeholder)
        marca.add("John Deere");
        cvPotencia.add(120);
        trabajoAsignado.add("arado");

        marca.add("Kubota");
        cvPotencia.add(85);
        trabajoAsignado.add("transporte");

        marca.add("Massey Ferguson");
        cvPotencia.add(70);
        trabajoAsignado.add("siembra");

        do {
            opcionMenu = leerOpcionMenu(scanner, opcionesMenu);

            if (opcionMenu == 0) {
                System.out.println("Saliendo del programa...");

            } else if (opcionMenu == 1) {
                marca.add(leerTexto(scanner, "Introduce la marca: "));
                cvPotencia.add(leerInt(scanner, "Introduce la potencia (cv): "));
                System.out.print("Introduce el trabajo que desempeña: ");

                do {
                    trabajoAValidar = scanner.nextLine();
                    if (validarTrabajo(trabajoAValidar)) {
                        trabajoAsignado.add(trabajoAValidar);
                        cantidadTractores++;
                    } else {
                        System.out.println("Introduce un trabajo válido (arado, transporte, siembra)");
                    }
                } while (!validarTrabajo(trabajoAValidar));

            } else if (opcionMenu == 2) {
                if (cantidadTractores <= 0) {
                    System.out.println("No tienes tractores todavia.");
                } else {
                    System.out.println(mostrarTractores(marca, cvPotencia, trabajoAsignado));
                }

            } else if (opcionMenu == 3) {
                System.out.println(mostrarTractores(marca, cvPotencia, trabajoAsignado));

                do {
                    indiceTractores = leerInt(scanner,
                            "Elige un tractor para evaluar (1 - " + cantidadTractores + "): ");
                } while (!validarOpcion(indiceTractores - 1, cantidadTractores - 1)); // - 1 para corregir a humano

                if (cvPotencia.get(indiceTractores - 1) >= cvPotenciaMin
                        .get(trabajoAsignado.indexOf(trabajoAsignado.get(indiceTractores - 1)))) {
                    System.out.println(elegirMensajeAleatorio(mensajesApto));
                } else {
                    System.out.println(elegirMensajeAleatorio(mensajesNoApto));
                }

            } else if (opcionMenu == 4) {
                System.out.println(mostrarTractores(marca, cvPotencia, trabajoAsignado));

                do {
                    // - 1 para ajustar del indice mostrado al real
                    indiceTractores = leerInt(scanner,
                            "Elige un tractor para eliminar (1 - " + cantidadTractores + "): ");
                } while (!validarOpcion(indiceTractores - 1, cantidadTractores - 1));

                marca.remove(indiceTractores - 1);
                cvPotencia.remove(indiceTractores - 1);
                trabajoAsignado.remove(indiceTractores - 1);
                cantidadTractores--;
            }

        } while (opcionMenu != 0);

        scanner.close();

    }
}
