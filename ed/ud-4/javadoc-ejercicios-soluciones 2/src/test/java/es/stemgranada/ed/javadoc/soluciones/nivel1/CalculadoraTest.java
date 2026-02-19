package es.stemgranada.ed.javadoc.soluciones.nivel1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Pruebas unitarias para la clase {@link Calculadora}.
 */
class CalculadoraTest {

    private Calculadora calculadora;

    @BeforeEach
    void setUp() {
        calculadora = new Calculadora();
    }

    @Test
    @DisplayName("Cálculo correcto del interés simple")
    void testCalcularInteresSimpleCorrecto() {
        double resultado = calculadora.calcularInteresSimple(1000, 0.05, 2);
        assertEquals(100.0, resultado, 0.0001);
    }

    @Test
    @DisplayName("Interés simple con ceros devuelve cero")
    void testCalcularInteresSimpleCeros() {
        double resultado = calculadora.calcularInteresSimple(0, 0.1, 5);
        assertEquals(0.0, resultado);
    }

    @Test
    @DisplayName("Interés simple con valores negativos lanza excepción")
    void testCalcularInteresSimpleNegativo() {
        assertThrows(
                IllegalArgumentException.class,
                () -> calculadora.calcularInteresSimple(-100, 0.05, 2)
        );
    }

    @Test
    @DisplayName("Cálculo correcto del descuento")
    void testCalcularDescuentoCorrecto() {
        double resultado = calculadora.calcularDescuento(200, 10);
        assertEquals(180.0, resultado, 0.0001);
    }

    @Test
    @DisplayName("Descuento del 0% no cambia el precio")
    void testCalcularDescuentoCero() {
        double resultado = calculadora.calcularDescuento(100, 0);
        assertEquals(100.0, resultado);
    }

    @Test
    @DisplayName("Descuento mayor de 100 lanza excepción")
    void testCalcularDescuentoInvalido() {
        assertThrows(
                IllegalArgumentException.class,
                () -> calculadora.calcularDescuento(100, 150)
        );
    }

    @Test
    @DisplayName("Conversión correcta de euros a dólares")
    void testConvertirEurosADolaresCorrecto() {
        double resultado = calculadora.convertirEurosADolares(50, 1.1);
        assertEquals(55.0, resultado, 0.0001);
    }

    @Test
    @DisplayName("Conversión con cambio cero lanza excepción")
    void testConvertirEurosADolaresCambioInvalido() {
        assertThrows(
                IllegalArgumentException.class,
                () -> calculadora.convertirEurosADolares(50, 0)
        );
    }

    @Test
    @DisplayName("Conversión con euros negativos lanza excepción")
    void testConvertirEurosADolaresEurosNegativos() {
        assertThrows(
                IllegalArgumentException.class,
                () -> calculadora.convertirEurosADolares(-10, 1.2)
        );
    }
}
