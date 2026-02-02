package PROG.UD5.rel1;

public class ej2 {
    /*
     * Ejercicio 2: Clase CuentaBancaria
     * Crea una clase CuentaBancaria con atributos titular y saldo.
     * Agrega métodos depositar(cantidad) y retirar(cantidad), asegurando que el
     * saldo no sea negativo después de un retiro.
     */

    public static void main(String[] args) {
        CuentaBancaria alfonso = new CuentaBancaria("alfonso", 1000);

        System.out.println("Saldo actual de " + alfonso.titular + ": " + alfonso.saldo);
        alfonso.retirar(2000);
        System.out.println("Saldo actual de " + alfonso.titular + " despues de retirar 200€: " + alfonso.saldo);
        alfonso.depositar(2000);
        System.out.println("Saldo actual de " + alfonso.titular + " despues de depositar 2000€: " + alfonso.saldo);
    }
}

class CuentaBancaria {
    String titular;
    int saldo;

    CuentaBancaria(String titular, int saldo) {
        this.titular = titular;
        this.saldo = saldo;
    }

    void depositar(int cantidad) {
        this.saldo += cantidad;
    }

    void retirar(int cantidad) {
        if ((this.saldo -= cantidad) < 0) {
            System.err.println("No puedes retirar y quedarte en negativo");
        } else {
            this.saldo -= cantidad;
        }
    }
}
