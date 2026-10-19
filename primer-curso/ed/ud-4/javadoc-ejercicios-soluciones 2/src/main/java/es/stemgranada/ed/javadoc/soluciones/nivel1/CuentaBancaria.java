package es.stemgranada.ed.javadoc.soluciones.nivel1;

/**
 * Representa una cuenta bancaria asociada a un titular y a un saldo.
 *
 * Permite realizar operaciones básicas como ingresos y retiradas,
 * manteniendo la integridad del saldo.
 *
 * @author Alumno
 * @since 1.0
 */
public class CuentaBancaria {

    private final Usuario titular;
    private double saldo;

    /**
     * Crea una nueva cuenta bancaria con un titular y un saldo inicial.
     *
     * @param titular      usuario propietario de la cuenta
     * @param saldoInicial importe inicial de la cuenta
     * @throws IllegalArgumentException si el titular es {@code null}
     *                                  o el saldo inicial es negativo
     */
    public CuentaBancaria(Usuario titular, double saldoInicial) {
        if (titular == null) {
            throw new IllegalArgumentException("El titular no puede ser null");
        }

        if (saldoInicial < 0) {
            throw new IllegalArgumentException("El saldo inicial no puede ser negativo");
        }

        this.titular = titular;
        this.saldo = saldoInicial;
    }

    /**
     * Obtiene el titular de la cuenta bancaria.
     *
     * @return usuario propietario de la cuenta
     */
    public Usuario getTitular() {
        return titular;
    }

    /**
     * Obtiene el saldo actual de la cuenta.
     *
     * @return saldo disponible
     */
    public double getSaldo() {
        return saldo;
    }

    /**
     * Ingresa una cantidad en la cuenta bancaria.
     *
     * @param cantidad importe a ingresar
     * @throws IllegalArgumentException si la cantidad es menor o igual que cero
     */
    public void ingresar(double cantidad) {
        if (cantidad <= 0) {
            throw new IllegalArgumentException("La cantidad debe ser positiva");
        }

        saldo += cantidad;
    }

    /**
     * Retira una cantidad de la cuenta bancaria si existe saldo suficiente.
     *
     * @param cantidad importe a retirar
     * @throws IllegalArgumentException si la cantidad es menor o igual que cero
     *                                  o si no hay saldo suficiente
     */
    public void retirar(double cantidad) {
        if (cantidad <= 0) {
            throw new IllegalArgumentException("La cantidad debe ser positiva");
        }

        if (cantidad > saldo) {
            throw new IllegalArgumentException("Saldo insuficiente");
        }

        saldo -= cantidad;
    }
}
