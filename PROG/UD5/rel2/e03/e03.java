package PROG.UD5.rel2.e03;

import PROG.UD5.faker;
import PROG.UD5.rel2.e01.Universidad;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class e03 {
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

    // leerDoublePositivo(scanner, "Mensajedeentrada");
    public static double leerDouble(Scanner scanner, String mensaje) {
        boolean doubleValido = false;
        double num = -1;

        do {
            imprimirPrompt(mensaje);
            if (scanner.hasNextDouble()) {
                num = scanner.nextDouble();
                scanner.nextLine(); // limpiar buffer
                doubleValido = true;
            }
            imprimirMensaje("Introduce un número válido");
            scanner.nextLine();

        } while (!doubleValido);

        return (double) num;
    }

    public static void main(String[] args) {
        final int CANTIDAD_PRODUCTOS = 50;

        Producto champu = new Producto("Champu", "Olor a menta", 3.49, 10);
        Producto champu2 = new Producto("Champu 2", "Olor a vainilla", 5.99, 20);

        Supermercado Mercadona = new Supermercado();

        Producto productoAleatorio = new Producto();
        for (int i = 0; i < CANTIDAD_PRODUCTOS; i++) {
            productoAleatorio = new Producto(faker.loremCorto(), faker.loremLargo(), faker.precio(0, 30),
                    faker.entero(0, 99));
            Mercadona.agregarProducto(productoAleatorio);
        }

        // PLANTILLA MENU:
        Scanner scanner = new Scanner(System.in);

        ArrayList<String> opcionesMenu = new ArrayList<>(
                Arrays.asList("Salir", "Agregar productos", "Vender un producto", "Mostrar el inventario"));

        int opcionMenu;
        int cantidadUnidades, precioNuevoProducto;
        String productoSeleccionado, nuevoProductoNombre, nuevaDescripcion;
        Double stockNuevoProducto;
        Producto productoEncontrado;
        Producto nuevoProducto;

        do {
            opcionMenu = leerOpcionMenu(scanner, opcionesMenu);
            if (opcionMenu == 0) {
                // Cerrar programa
                imprimirMensaje("Saliendo del programa...");

            } else if (opcionMenu == 1) {
                // Agregar productos
                // Info sobre producto
                nuevoProductoNombre = leerTexto(scanner, "Nombre del producto:\n");
                nuevaDescripcion = leerTexto(scanner, "Descripcion del producto:\n");
                precioNuevoProducto = leerInt(scanner, "Precio del producto:\n");
                stockNuevoProducto = leerDouble(scanner, "Stock del producto:\n");

                // Creacion de producto
                nuevoProducto = new Producto(nuevoProductoNombre, nuevaDescripcion,
                        stockNuevoProducto, precioNuevoProducto);

                // Se añade a supermercado
                Mercadona.agregarProducto(nuevoProducto);

            } else if (opcionMenu == 2) {
                // Vender un producto (Reducir stock)
                // Pregunta
                productoSeleccionado = leerTexto(scanner, "Id del producto vendido?:\n");
                cantidadUnidades = leerInt(scanner, "Unidades vendidas?\n");

                // Lo busca
                productoEncontrado = Mercadona.buscarProducto(productoSeleccionado);

                // Cambia unidades
                Mercadona.venderProducto(productoEncontrado, cantidadUnidades);
                System.out.println(productoEncontrado);

            } else if (opcionMenu == 3) {
                // Mostrar el inventario
                System.out.println(Mercadona);
            }
        } while (opcionMenu != 0);

        scanner.close();
    }
}