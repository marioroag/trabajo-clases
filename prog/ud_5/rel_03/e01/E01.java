package prog.ud_5.rel_03.e01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import prog.ud_5.rel_03.Faker;

public class E01 {
    public static void imprimirMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public static void imprimirPrompt(String mensaje) {
        System.out.print(mensaje);
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

    // leerTexto(scanner, "Mensajedeentrada");
    public static String leerTexto(Scanner scanner, String mensaje) {
        String texto;
        do {
            imprimirPrompt(mensaje);
            texto = scanner.nextLine().trim();
            if (texto.isEmpty()) {
                imprimirMensaje("No puede estar vacío");
            }
        } while (texto.isEmpty());

        return texto;
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
        int opcionMenu;

        Scanner scanner = new Scanner(System.in);

        ArrayList<String> opcionesMenu = new ArrayList<>(
                Arrays.asList("Salir", "Registrar embarcacion", "Mostrar amarres", "Gestionar amarres",
                        "Buscar embarcacion (Por matrícula)", "Ver ingresos diarios"));

        ArrayList<String> opcionesAmarre = new ArrayList<>(
                Arrays.asList("Atrás", "Dar de alta", "Asignar amarre", "Liberar amarre"));

        Amarre amarre1 = new Amarre(10, "Normal");
        Amarre amarre2 = new Amarre(20, "Premium");
        Amarre amarre3 = new Amarre(15, "Normal");

        Embarcacion embarcacion1 = new Embarcacion("001", "embarcacion1", 0, "Yate", "Mario", 2024, 150000);
        Embarcacion embarcacion2 = new Embarcacion("002", "embarcacion2", 0, "Velero", "Felipe", 2001, 2000);
        Embarcacion embarcacion3 = new Embarcacion("003", "embarcacion3", 0, "Moto de agua", "Fernando", 1950, 1000);

        Embarcacion nuevaEmbarcacion;
        Amarre nuevoAmarre;

        ArrayList<Amarre> amarresTotal = new ArrayList<>(Arrays.asList(amarre1, amarre2, amarre3));
        ArrayList<Embarcacion> embarcacionesTotal = new ArrayList<>(
                Arrays.asList(embarcacion1, embarcacion2, embarcacion3));

        Puerto puerto1 = new Puerto("puerto1", "Puerto de la Cruz", 100, "123123123", amarresTotal, embarcacionesTotal);

        for (int i = 0; i < 50; i++) {
            amarre1 = new Amarre(Faker.longitudMaximaAmarre(), Faker.tipoAmarre());
            puerto1.altaAmarre(amarre1);
        }

        for (int i = 0; i < 50; i++) {
            embarcacion1 = new Embarcacion(Faker.matriculaEmbarcacion(), Faker.eslora(), Faker.tipoEmbarcacion(),
                    Faker.nombre(), Faker.anioFabricacionEmbarcacion(), Faker.longitudMaximaAmarre());
            puerto1.registrarEmbarcacion(embarcacion1);
        }

        do {
            opcionMenu = leerOpcionMenu(scanner, opcionesMenu);

            if (opcionMenu == 0) {
                imprimirMensaje("Saliendo del programa...");

            } else if (opcionMenu == 1) { // Registrar embarcacion
                nuevaEmbarcacion = new Embarcacion(leerTexto(scanner, "Matricula: "),
                        leerTexto(scanner, "Nombre: "),
                        leerInt(scanner, "Eslora: "), leerTexto(scanner, "Tipo: "), leerTexto(scanner, "Propietario: "),
                        leerInt(scanner, "Año de fabricacion: "), leerInt(scanner, "Valor Estimado: "));

                puerto1.registrarEmbarcacion(nuevaEmbarcacion);
                imprimirMensaje("Embarcacion Registrada.");

            } else if (opcionMenu == 2) { // Mostrar amarres
                imprimirMensaje("[ Amarres Libres ]\n" + puerto1.mostrarAmarresLibres());
                imprimirMensaje("[ Amarres Ocupados ]\n" + puerto1.mostrarAmarresOcupados());

            } else if (opcionMenu == 3) { // Dar de alta, asignar y liberar amarres
                imprimirMensaje("[ Amarres Libres ]\n" + puerto1.mostrarAmarresLibres());
                imprimirMensaje("[ Amarres Ocupados ]\n" + puerto1.mostrarAmarresOcupados());

                opcionMenu = leerOpcionMenu(scanner, opcionesAmarre);
                if (opcionMenu == 0) { // arreglar que saca del programa
                    System.out.println("0");
                } else if (opcionMenu == 1) { // Dar de alta
                    nuevoAmarre = new Amarre(leerInt(scanner, "Longitud: "), leerTexto(scanner, "Tipo de amarre: "));
                    puerto1.altaAmarre(nuevoAmarre);
                    System.out.println(nuevoAmarre + " ha sido dado de alta con éxito");

                } else if (opcionMenu == 2) { // Asignar amarre a embarcacion
                    puerto1.asignarAmarre(leerTexto(scanner, "Matricula de embarcacion: "),
                            leerInt(scanner, "Nº Amarre: "));

                } else if (opcionMenu == 3) { // Liberar amarre
                    puerto1.liberarAmarre(leerInt(scanner, "Nº Amarre a liberar: "));

                }

            } else if (opcionMenu == 4) { // Buscar embarcación por matricula
                // El "" + está ahi porque imprimirMensaje no deja imprimir solo la embarcacion
                imprimirMensaje(
                        "" + puerto1.buscarEmbarcacion(leerTexto(scanner, "Matricula de la embarcacion: ")));

            } else if (opcionMenu == 5) { // Ver ingresos diarios actuales y máximos
                imprimirMensaje("[ Ingresos Actuales ]\n" + puerto1.calcularIngresosDiariosActuales());
                imprimirMensaje("\n[ Ingresos Potenciales Máximos ]\n" + puerto1.calcularIngresosDiariosMaximos());
            }

        } while (opcionMenu != 0);

        scanner.close();
    }

}
