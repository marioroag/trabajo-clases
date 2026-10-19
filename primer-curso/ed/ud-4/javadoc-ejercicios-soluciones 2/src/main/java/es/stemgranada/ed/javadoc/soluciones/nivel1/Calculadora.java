package es.stemgranada.ed.javadoc.soluciones.nivel1;

/**
 * Proporciona operaciones financieras y matemáticas básicas como el cálculo
 * de intereses simples, descuentos y conversiones de divisa.
 *
 * Esta clase no mantiene estado y ofrece métodos independientes entre sí.
 *
 * @author Alumno
 * @since 1.0
 */
public class Calculadora {

    /**
     * Calcula el interés simple generado por un capital durante un número
     * determinado de años.
     *
     * La fórmula aplicada es: capital × tasa × años.
     *
     * @param capital importe inicial sobre el que se calcula el interés
     * @param tasa    porcentaje de interés expresado como valor decimal
     * @param anios   número de años durante los que se aplica el interés
     * @return importe del interés generado
     * @throws IllegalArgumentException si alguno de los valores es negativo
     */
    public double calcularInteresSimple(double capital, double tasa, int anios) {
        if (capital < 0 || tasa < 0 || anios < 0) {
            throw new IllegalArgumentException("Los valores no pueden ser negativos");
        }

        return capital * tasa * anios;
    }

    /**
     * Calcula el precio final tras aplicar un descuento porcentual
     * sobre un importe inicial.
     *
     * @param precio     precio original del producto
     * @param porcentaje porcentaje de descuento a aplicar, entre 0 y 100
     * @return precio resultante tras aplicar el descuento
     * @throws IllegalArgumentException si el precio es negativo o el porcentaje
     *                                  no está dentro del rango permitido
     */
    public double calcularDescuento(double precio, double porcentaje) {
        if (precio < 0 || porcentaje < 0 || porcentaje > 100) {
            throw new IllegalArgumentException("Valores no válidos");
        }

        return precio - (precio * porcentaje / 100);
    }

    /**
     * Convierte una cantidad expresada en euros a dólares utilizando
     * un tipo de cambio indicado.
     *
     * @param euros  cantidad en euros a convertir
     * @param cambio valor del tipo de cambio aplicado
     * @return importe equivalente en dólares
     * @throws IllegalArgumentException si la cantidad en euros es negativa
     *                                  o el tipo de cambio es menor o igual que
     *                                  cero
     */
    public double convertirEurosADolares(double euros, double cambio) {
        if (euros < 0 || cambio <= 0) {
            throw new IllegalArgumentException("Valores no válidos");
        }

        return euros * cambio;
    }
}
