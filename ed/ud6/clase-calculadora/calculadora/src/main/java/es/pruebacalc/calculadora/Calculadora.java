package es.pruebacalc.calculadora;

/**
 * Clase que proporciona operaciones matemáticas básicas y utilidades
 * numéricas con validaciones explícitas de entrada.
 */
public class Calculadora {

    /**
     * Suma dos números enteros.
     */
    public int sumar(int a, int b) {
        return a + b;
    }

    /**
     * Resta dos números enteros.
     */
    public int restar(int a, int b) {
        return a - b;
    }

    /**
     * Multiplica dos números enteros.
     */
    public int multiplicar(int a, int b) {
        return a * b;
    }

    /**
     * Divide dos números.
     *
     * @throws IllegalArgumentException si el divisor es cero
     */
    public double dividir(double a, double b) {
        if (b == 0) {
            throw new IllegalArgumentException("No se puede dividir entre cero");
        }
        return a / b;
    }

    /**
     * Calcula la potencia base elevado a exponente.
     *
     * @throws IllegalArgumentException si el exponente es negativo
     */
    public double potencia(double base, int exponente) {
        if (exponente < 0) {
            throw new IllegalArgumentException("El exponente no puede ser negativo");
        }

        double resultado = 1;

        for (int i = 0; i < exponente; i++) {
            resultado *= base;
        }

        return resultado;
    }

    /**
     * Calcula la media aritmética de un conjunto de valores.
     *
     * @throws IllegalArgumentException si el array es null o está vacío
     */
    public double media(double[] valores) {
        if (valores == null || valores.length == 0) {
            throw new IllegalArgumentException("El array no puede ser null ni estar vacío");
        }

        double suma = 0;

        for (double valor : valores) {
            suma += valor;
        }

        return suma / valores.length;
    }

    /**
     * Determina si un número es par.
     */
    public boolean esPar(int numero) {
        return numero % 2 == 0;
    }

    /**
     * Calcula el factorial de un número.
     *
     * @throws IllegalArgumentException si el número es negativo
     */
    public long factorial(int numero) {
        if (numero < 0) {
            throw new IllegalArgumentException("El número no puede ser negativo");
        }

        if (numero == 0 || numero == 1) {
            return 1;
        }

        long resultado = 1;

        for (int i = 2; i <= numero; i++) {
            resultado *= i;
        }

        return resultado;
    }
}