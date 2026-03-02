package prog.ud_5.pt5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static void imprimirPrompt(String mensaje) {
        System.out.print(mensaje);
    }

    public static void imprimirMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public static void imprimirError(String mensaje) {
        System.err.println(mensaje);
    }

    public static boolean validarOpcion(int opcionValor, int max) {
        return opcionValor > 0 && opcionValor <= max;
    }

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
        imprimirMensaje("\n===== GESTIÓN DE ZOOLÓGICO =====");
        for (int i = 0; i < opciones.size(); i++) {
            imprimirMensaje((i + 1) + ". " + opciones.get(i));
        }
    }

    public static int leerOpcionMenu(Scanner scanner, ArrayList<String> menu) {
        int opcion;
        do {
            mostrarMenu(menu);
            opcion = leerInt(scanner, "Seleccione una opción: ");
            if (!validarOpcion(opcion, menu.size())) {
                imprimirMensaje("Número fuera de rango");
            }
        } while (!validarOpcion(opcion, menu.size()));

        return opcion;
    }

    public static Animal buscarAnimal(Scanner scanner, Zoologico zoo) {
        // Buscar un animal por código
        String codigoBuscar = leerTexto(scanner, "Código del animal a buscar: ").toUpperCase();
        Animal animalEncontrado = zoo.buscarPorCodigo(codigoBuscar);

        return animalEncontrado;
    }

    public static void mostrarAnimales(Zoologico zoo) {
        imprimirMensaje(zoo.toString());
    }

    // Opcion 2
    public static void opcionBuscar(Animal animalEncontrado) {
        if (animalEncontrado != null) {
            imprimirMensaje(animalEncontrado.toString());
        } else {
            imprimirMensaje("Animal no encontrado.");
        }
    }

    // Opcion 3
    public static void agregarAnimales(Scanner scanner, Zoologico zoo) {
        Animal animalAgregar = buscarAnimal(scanner, zoo);

        // Solo continúa si se encontró un an imal
        if (animalAgregar != null) {
            int cantidadAgregar = leerInt(scanner, "Ejemplares de " + animalAgregar.getNombre() + " a agregar: ");
            if (cantidadAgregar > 0) {
                animalAgregar.setCantidad(animalAgregar.getCantidad() + cantidadAgregar);
            } else {
                imprimirError("No se permite agregar numeros negativos.");
            }
        } else {
            imprimirError("Animal no encontrado.");
        }
    }

    // Opcion 4
    public static void retirarAnimales(Scanner scanner, Zoologico zoo) {
        Animal animalRetirar = buscarAnimal(scanner, zoo);

        // Solo continúa si se encontró un an imal
        if (animalRetirar != null) {
            int cantidadRetirar = leerInt(scanner, "Ejemplares de " + animalRetirar.getNombre() + " a retirar: ");
            // No permite que se eliminen más animales de los que hay
            if ((animalRetirar.getCantidad() - cantidadRetirar) >= 0 && cantidadRetirar > 0) {
                animalRetirar.setCantidad(animalRetirar.getCantidad() - cantidadRetirar);
            } else {
                imprimirError("No se puede retirar más ejemplares de los disponibles.");
            }
        } else {
            imprimirError("Animal no encontrado.");
        }
    }

    // Opcion 5
    public static void eliminarAnimal(Scanner scanner, Zoologico zoo) {
        Animal animalEliminar = buscarAnimal(scanner, zoo);

        if (animalEliminar != null) {
            if (animalEliminar.getCantidad() == 0) {
                zoo.eliminarAnimal(animalEliminar);
                imprimirMensaje("Se ha eliminado el animal del zoológico");
            } else {
                imprimirError("No se puede eliminar un animal con ejemplares disponibles.");
            }
        } else {
            imprimirError("Animal no encontrado.");
        }
    }

    public static void main(String[] args) {
        /*
         * TODO:
         * - IMPLEMENTAR FAKER
         * - REVISAR INSTRUCCIONES CUMPLIDAS
         * - INTENTAR ROMPER PROGRAMA
         */

        // [ Variables ]
        Scanner scanner = new Scanner(System.in);

        int opcionMenu;

        ArrayList<String> opcionesMenu = new ArrayList<>(
                Arrays.asList("Mostrar todos los animales", "Buscar un animal por código",
                        "Agregar ejemplares a un animal", "Retirar ejemplares de un animal", "Eliminar un animal",
                        "Salir"));

        // [ Creación del Zoológico ]
        Animal animal1 = new Animal("Leon", 10, 9200);
        Animal animal2 = new Animal("Foca", 25, 3240);
        Animal animal3 = new Animal("Pinguino", 20, 1200);
        Animal animal4 = new Animal("Leopardo", 7, 2600);
        Animal animal5 = new Animal("ABF234", "Tigre", 12, 6000);
        Animal animal6 = new Animal("Tiburon", 3, 8200);
        Animal animal7 = new Animal("FD4963", "Oso", 15, 7400);

        ArrayList<Animal> animales = new ArrayList<>(
                Arrays.asList(animal1, animal2, animal3, animal4, animal5, animal6, animal7));
        Zoologico zooStem = new Zoologico(animales);

        // Faker

        // [ Menú de gestión ]
        do {
            opcionMenu = leerOpcionMenu(scanner, opcionesMenu);

            if (opcionMenu == 1) {
                // Mostrar todos los animales
                mostrarAnimales(zooStem);
            } else if (opcionMenu == 2) {
                // Buscar un animal por código
                opcionBuscar(buscarAnimal(scanner, zooStem));
            } else if (opcionMenu == 3) {
                // Agregar ejemplares a un animal
                mostrarAnimales(zooStem);
                agregarAnimales(scanner, zooStem);
            } else if (opcionMenu == 4) {
                // Retirar ejemplares de un animal
                mostrarAnimales(zooStem);
                retirarAnimales(scanner, zooStem);
            } else if (opcionMenu == 5) {
                // Eliminar un animal
                mostrarAnimales(zooStem);
                eliminarAnimal(scanner, zooStem);
            } else if (opcionMenu == 6) {
                // Salir
                imprimirMensaje("Saliendo del programa...");
            }
        } while (opcionMenu != opcionesMenu.size());

        scanner.close();
    }
}
