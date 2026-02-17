package prog.ud_5.rel1;

import java.util.Scanner;

public class e02 {
    /*
     * Ejercicio 2: Clase CuentaBancaria
     * Crea una clase CuentaBancaria con atributos titular y saldo.
     * Agrega métodos depositar(cantidad) y retirar(cantidad), asegurando que el
     * saldo no sea negativo después de un retiro.
     */

    public static void main(String[] args) {
        CuentaBancaria alfonso = new CuentaBancaria("alfonso", 1000);
        int opcion = 0;
        double cantidadUsuario = 0;

        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Selecciona una opción:\n1. Depositar\n2. Retirar\n3. Salir");
            opcion = Integer.parseInt(scanner.nextLine());

            if (opcion == 1) {
                System.out.println("Cuanto dinero quieres depostar?");
                cantidadUsuario = Double.parseDouble(scanner.nextLine());
                alfonso.depositar(cantidadUsuario);

                System.out.println("Saldo actual de " + alfonso.titular + " despues de depositar " + cantidadUsuario
                        + "€: " + alfonso.saldo);
            } else if (opcion == 2) {
                System.out.println("Cuanto dinero quieres retirar?");
                cantidadUsuario = Double.parseDouble(scanner.nextLine());
                alfonso.retirar(cantidadUsuario);
                System.out.println("Saldo actual de " + alfonso.titular + " despues de depositar " + cantidadUsuario
                        + "€: " + alfonso.saldo);
            }
        } while (opcion != 3);

        scanner.close();
    }
}

class CuentaBancaria {
    String titular;
    double saldo;

    CuentaBancaria(String titular, double saldo) {
        this.titular = titular;
        this.saldo = saldo;
    }

    void depositar(double cantidad) {
        this.saldo += cantidad;
    }

    void retirar(double cantidad) {
        if ((this.saldo - cantidad) <= 0) {
            System.err.println("No puedes retirar más dinero del que tienes");
        } else {
            this.saldo -= cantidad;
        }
    }
}
