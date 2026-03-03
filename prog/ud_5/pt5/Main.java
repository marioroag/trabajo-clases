package prog.ud_5.pt5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    /**
     * Imprime un mensaje que deja el siguiente input justo despues del mensaje
     * Se usa para prompts
     * 
     * @param mensaje String
     */
    static void imprimirPrompt(String mensaje) {
        System.out.print(mensaje);
    }

    /**
     * Imprime un mensaje con nueva línea
     * 
     * @param mensaje String
     */
    public static void imprimirMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    /**
     * Usa el sistema para imprimir errores de Java
     * 
     * @param mensaje
     */
    public static void imprimirError(String mensaje) {
        System.err.println(mensaje);
    }

    /**
     * Valida que el input esta en un rango de minimos y maximos antes de continuar
     * 
     * @param opcionValor
     * @param max
     * @return Boolean
     */
    public static boolean validarOpcion(int opcionValor, int max) {
        return opcionValor > 0 && opcionValor <= max;
    }

    /**
     * Lee un texto y comprueba si esta vacío antes de continuar hasta que recibe un
     * texto valido
     * 
     * @param scanner
     * @param mensaje
     * @return String
     */
    public static String leerTexto(Scanner scanner, String mensaje) {
        String texto;
        do {
            imprimirPrompt(mensaje);
            texto = scanner.nextLine().trim();
            if (texto.isEmpty()) {
                imprimirError("No puede estar vacío");
            }
        } while (texto.isEmpty());

        return texto;
    }

    /**
     * Pregunta por un número entero hsta que recibe uno
     * 
     * @param scanner
     * @param mensaje
     * @return Integer
     */
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

    /**
     *
     * Genera y muestra el menú con sus opciones
     * 
     * @param opciones Array de opciones a convertir al menu
     * @param cabecera Cabecera del menu (primera línea)
     */
    public static void mostrarMenu(ArrayList<String> opciones, String cabecera) {
        String menu = cabecera;
        for (int i = 0; i < opciones.size(); i++) {
            menu += ("\n" + (i + 1) + ". " + opciones.get(i));
        }

        imprimirMensaje(menu);
    }

    /**
     * Usa mostrarMenu(), leerInt() y validarOpcion() para hacer que el menu sea
     * funcional
     * 
     * Muestra el menu, y espera un int valido dentro de la cantidad de opciones que
     * tiene el menu para continuar
     * 
     * @param scanner
     * @param menu
     * @param cabecera
     * @return
     */
    public static int leerOpcionMenu(Scanner scanner, ArrayList<String> menu, String cabecera) {
        int opcion;
        do {
            mostrarMenu(menu, cabecera);
            opcion = leerInt(scanner, "Seleccione una opción: ");
            if (!validarOpcion(opcion, menu.size())) {
                imprimirMensaje("Número fuera de rango");
            }
        } while (!validarOpcion(opcion, menu.size()));

        return opcion;
    }

    /**
     * Espera un codigo para buscar el animal con el método de Zoologico
     * buscarPorCodigo()
     * 
     * Separado de opcionBuscar() para poder reusar en otros metodos
     * 
     * @param scanner
     * @param zoo
     * @return Animal
     */
    public static Animal buscarAnimal(Scanner scanner, Zoologico zoo) {
        // Buscar un animal por código
        String codigoBuscar = leerTexto(scanner, "Código del animal a buscar: ").toUpperCase();
        Animal animalEncontrado = zoo.buscarPorCodigo(codigoBuscar);

        return animalEncontrado;
    }

    /**
     * Muestra todos los animales usando el toString() de Zoologico
     * 
     * @param zoo
     */
    public static void mostrarAnimales(Zoologico zoo) {
        imprimirMensaje(zoo.toString());
    }

    /**
     * Imprime el animal si recibe uno, de caso contrario imprime animal no
     * encontrado
     * 
     * @param animalEncontrado
     */
    public static void opcionBuscar(Animal animalEncontrado) {
        if (animalEncontrado != null) {
            imprimirMensaje(animalEncontrado.toString());
        } else {
            imprimirMensaje("Animal no encontrado.");
        }
    }

    /**
     * Pide un animal y agrega la cantidad recibida
     * 
     * @param scanner
     * @param zoo
     */
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

    /**
     * Pide un animal y retira la cantidad recibida
     * 
     * @param scanner
     * @param zoo
     */
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

    /**
     * Elimina un animal completamente del zoo solo si este
     * * @param scanner
     * 
     * @param zoo
     */
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
         * - PENSAR E IMPLEMENTAR FUNCIONES PARA GESTIONAR EN ZOOLOGICO.JAVA
         */

        // [ Variables ]
        Scanner scanner = new Scanner(System.in);

        int opcionMenu;
        final String cabeceraMenu = "\n===== GESTIÓN DE ZOOLÓGICO =====";
        ArrayList<String> opcionesMenu = new ArrayList<>(
                Arrays.asList("Mostrar todos los animales", "Buscar un animal por código",
                        "Agregar ejemplares a un animal", "Retirar ejemplares de un animal", "Eliminar un animal",
                        "Salir"));

        final int MAXANIMALES = 1000;
        int cantidadAnimales = 0;

        // [ Creación del Zoológico ]
        Zoologico zooStem = new Zoologico();

        Animal animalGenerar;
        for (int i = 0; cantidadAnimales < MAXANIMALES; i++) {
            animalGenerar = new Animal(Faker.codigoAnimal(), Faker.nombreAnimal(), Faker.cantidadAnimal(),
                    Faker.precioAnimal());
            cantidadAnimales += animalGenerar.getCantidad();

            // Si el proximo animal sobrepasa el límite del faker fuerza su cantidad a ser
            // lo que quedaría para llegar al limite
            if (cantidadAnimales > MAXANIMALES) {
                animalGenerar.setCantidad(animalGenerar.getCantidad() - (cantidadAnimales - MAXANIMALES));
                cantidadAnimales -= cantidadAnimales - MAXANIMALES;
            }
            zooStem.aniadirAnimal(animalGenerar);
        }

        // [ Menú de gestión ]
        do {
            opcionMenu = leerOpcionMenu(scanner, opcionesMenu, cabeceraMenu);

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
