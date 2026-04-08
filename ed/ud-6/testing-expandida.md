# TESTING JAVA RESUMEN

---

## 1. ESTRUCTURA AAA — EN DETALLE

```java
@Test
void nombreMetodo_resultadoEsperado_condicion() {

    // ── ARRANGE ─────────────────────────────────────────
    // Crear objetos, inicializar datos, preparar mocks
    Calculadora calc = new Calculadora();
    int a = 2, b = 3;

    // ── ACT ─────────────────────────────────────────────
    // UNA SOLA acción: ejecutar el método bajo prueba
    int result = calc.add(a, b);

    // ── ASSERT ──────────────────────────────────────────
    // Verificar el resultado (idealmente un solo assert)
    assertEquals(5, result);
}
```

> ⚠️ **Reglas de oro:**
> - Un test = **un comportamiento**. Si falla, sabes exactamente qué.
> - El Act debe ser **una sola línea**. Si necesitas más, el diseño tiene un problema.
> - No mezcles fases. Nada de asserts en el Arrange.

---

## 2. ANOTACIONES — CICLO DE VIDA COMPLETO

```
CLASE DE PRUEBA
│
├── @BeforeAll (static) ──────────── se ejecuta UNA VEZ al inicio
│
├── TEST 1
│   ├── @BeforeEach ──────────────── antes de Test 1
│   ├── @Test ────────────────────── Test 1
│   └── @AfterEach ───────────────── después de Test 1
│
├── TEST 2
│   ├── @BeforeEach ──────────────── antes de Test 2 (objeto nuevo)
│   ├── @Test ────────────────────── Test 2
│   └── @AfterEach ───────────────── después de Test 2
│
└── @AfterAll (static) ───────────── se ejecuta UNA VEZ al final
```

```java
class ContadorTest {

    private Contador contador;  // se reinicia en cada test → independencia garantizada

    @BeforeAll
    static void configurarEntorno() {
        // Útil para: abrir conexión costosa, cargar fichero grande
        // DEBE ser static
        System.out.println("Inicio de la batería");
    }

    @BeforeEach
    void crearContador() {
        // Esto se ejecuta antes de CADA @Test
        // Es donde más se trabaja normalmente
        contador = new Contador();
    }

    @AfterEach
    void limpiarContador() {
        // Limpiar estado, cerrar recursos ligeros
        contador = null;
    }

    @AfterAll
    static void cerrarEntorno() {
        // Cerrar conexión costosa, limpiar ficheros
        // DEBE ser static
        System.out.println("Fin de la batería");
    }

    @Test
    void contador_devuelve0_siEstadoInicial() {
        assertEquals(0, contador.getValue());
    }

    @Test
    void contador_devuelve1_siSeIncrementaUnaVez() {
        contador.increment();
        assertEquals(1, contador.getValue());
    }

    @Disabled("Pendiente de implementar reset()")
    @Test
    void contador_devuelve0_siSeReinicia() {
        // Este test existe pero NO se ejecuta
        // Documenta un comportamiento futuro
    }
}
```

---

## 3. ASSERTIONS — GUÍA COMPLETA

### 3.1 `assertEquals` / `assertNotEquals`

```java
// Tipos primitivos
assertEquals(5, calc.add(2, 3));
assertEquals(3.14, calc.pi(), 0.001);   // con delta para doubles ← MUY IMPORTANTE
assertNotEquals(0, calc.add(1, 1));

// Strings
assertEquals("HOLA", texto.toUpperCase());

// Objetos → usa .equals() internamente
assertEquals(new Producto("Leche", 1.2), repo.findById(1));
// ⚠️ La clase Producto debe tener equals() implementado
```

### 3.2 `assertTrue` / `assertFalse`

```java
// Directo con booleano
assertTrue(validator.isAdult(20));
assertFalse(validator.isAdult(15));

// Con expresión lambda (evaluación lazy → más eficiente)
assertTrue(() -> lista.size() > 0);

// Con mensaje de error personalizado (aparece cuando falla)
assertTrue(resultado > 0, "El resultado debería ser positivo, fue: " + resultado);
assertFalse(lista.isEmpty(), "La lista no debería estar vacía");
```

### 3.3 `assertNull` / `assertNotNull`

```java
// Cuando se espera null (ej: no encontrado)
assertNull(repo.findById(999));
assertNull(usuario.getEmail());   // campo opcional sin valor

// Cuando NO debe ser null
assertNotNull(repo.findById(1));
assertNotNull(servicio.crearUsuario("Ana"));

// Con mensaje
assertNotNull(resultado, "El servicio no debería devolver null");
```

### 3.4 `assertThrows` — Excepciones

```java
// ── Forma básica ────────────────────────────────────────
assertThrows(
    IllegalArgumentException.class,       // excepción esperada
    () -> validator.isAdult(-1)           // código que debe lanzarla
);

// ── Capturar la excepción para inspeccionar el mensaje ──
IllegalArgumentException ex = assertThrows(
    IllegalArgumentException.class,
    () -> validator.isAdult(-1)
);
assertEquals("Edad no válida", ex.getMessage());

// ── Verificar que NO lanza excepción ────────────────────
assertDoesNotThrow(() -> validator.isAdult(25));

// ── Casos típicos a probar ───────────────────────────────
assertThrows(NullPointerException.class,       () -> servicio.procesar(null));
assertThrows(IllegalArgumentException.class,   () -> servicio.procesar(-1));
assertThrows(IllegalStateException.class,      () -> servicio.ejecutarSinInicializar());
```

### 3.5 `assertAll` — Agrupar assertions

```java
// Sin assertAll → si falla el primero, los demás NO se ejecutan
assertEquals(25, usuario.getEdad());     // si esto falla →
assertEquals("Ana", usuario.getNombre()); // esto nunca se comprueba

// Con assertAll → TODOS se ejecutan aunque alguno falle
assertAll("datos del usuario",
    () -> assertEquals(25, usuario.getEdad()),
    () -> assertEquals("Ana", usuario.getNombre()),
    () -> assertNotNull(usuario.getEmail())
);
// Si fallan 2 de 3 → el informe muestra LOS DOS fallos a la vez
```

### 3.6 `assertSame` / `assertNotSame`

```java
// Comprueba que son el MISMO objeto en memoria (==), no equivalencia
Producto p1 = repo.findById(1);
Producto p2 = repo.findById(1);

assertNotSame(p1, p2);   // objetos distintos aunque sean iguales en valor
assertEquals(p1, p2);    // pero tienen el mismo contenido (equals)
```

### 3.7 `assertIterableEquals` / `assertArrayEquals`

```java
// Listas con el mismo contenido en el mismo orden
List<String> esperado = List.of("Ana", "Luis", "Marta");
List<String> resultado = servicio.obtenerNombres();
assertIterableEquals(esperado, resultado);

// Arrays
int[] esperado = {1, 2, 3};
int[] resultado = calc.generarSecuencia(3);
assertArrayEquals(esperado, resultado);
```

---

## 4. PRUEBAS PARAMETRIZADAS — TODOS LOS SABORES

### 4.1 `@ValueSource` — Un parámetro, mismo comportamiento esperado

```java
// Números positivos → todos deben devolver true
@ParameterizedTest
@ValueSource(ints = {1, 5, 100, Integer.MAX_VALUE})
void esPositivo_devuelveTrue(int number) {
    assertTrue(utils.isPositive(number));
}

// Strings no vacíos
@ParameterizedTest
@ValueSource(strings = {"Ana", "Luis", "  "})
void noEsVacio_devuelveTrue(String texto) {
    assertTrue(validator.noEsVacio(texto));
}
```

### 4.2 `@CsvSource` — Múltiples parámetros con resultado esperado

```java
@ParameterizedTest
@CsvSource({
    "2,  3,  5",    // 2 + 3 = 5
    "0,  0,  0",    // 0 + 0 = 0
    "-1, 1,  0",    // -1 + 1 = 0
    "10, -3, 7"     // 10 + (-3) = 7
})
void sumar_devuelveResultadoCorrecto(int a, int b, int esperado) {
    assertEquals(esperado, calc.add(a, b));
}

// Con booleanos
@ParameterizedTest
@CsvSource({
    "18,  true",
    "17,  false",
    "0,   false",
    "120, true"
})
void isAdult_devuelveResultadoCorrecto(int edad, boolean esperado) {
    assertEquals(esperado, validator.isAdult(edad));
}
```

### 4.3 `@NullSource` / `@EmptySource` — Casos nulos y vacíos

```java
@ParameterizedTest
@NullSource    // pasa null
void procesar_lanzaExcepcion_siEntradaNula(String input) {
    assertThrows(IllegalArgumentException.class, () -> servicio.procesar(input));
}

@ParameterizedTest
@EmptySource   // pasa "" (string vacío) o colección vacía
void procesar_lanzaExcepcion_siEntradaVacia(String input) {
    assertThrows(IllegalArgumentException.class, () -> servicio.procesar(input));
}

// Combinados → prueba null Y vacío en el mismo test
@ParameterizedTest
@NullAndEmptySource
void procesar_lanzaExcepcion_siEntradaNulaOVacia(String input) {
    assertThrows(IllegalArgumentException.class, () -> servicio.procesar(input));
}
```

---

## 5. VALIDACIÓN DE EXCEPCIONES — CASOS COMPLETOS

```java
public class ValidadorEdad {
    public boolean isAdult(int age) {
        if (age < 0 || age > 120) {
            throw new IllegalArgumentException("Edad no válida: " + age);
        }
        return age >= 18;
    }
}
```

```java
class ValidadorEdadTest {

    private ValidadorEdad validator;

    @BeforeEach
    void init() { validator = new ValidadorEdad(); }

    // ── Caso nominal ──────────────────────────────────────
    @Test
    void isAdult_devuelveTrue_siEdad25() {
        assertTrue(validator.isAdult(25));
    }

    // ── Caso límite inferior adulto ───────────────────────
    @Test
    void isAdult_devuelveTrue_siEdad18() {
        assertTrue(validator.isAdult(18));
    }

    // ── Caso límite: justo por debajo ─────────────────────
    @Test
    void isAdult_devuelveFalse_siEdad17() {
        assertFalse(validator.isAdult(17));
    }

    // ── Caso límite superior válido ───────────────────────
    @Test
    void isAdult_devuelveTrue_siEdad120() {
        assertTrue(validator.isAdult(120));
    }

    // ── Caso erróneo: negativo ────────────────────────────
    @Test
    void isAdult_lanzaExcepcion_siEdadNegativa() {
        assertThrows(IllegalArgumentException.class,
            () -> validator.isAdult(-1));
    }

    // ── Caso erróneo con mensaje ──────────────────────────
    @Test
    void isAdult_lanzaExcepcion_conMensajeCorrecto_siEdad200() {
        IllegalArgumentException ex = assertThrows(
            IllegalArgumentException.class,
            () -> validator.isAdult(200)
        );
        assertTrue(ex.getMessage().contains("200"));
    }

    // ── Caso erróneo: no lanza cuando es válido ───────────
    @Test
    void isAdult_noLanzaExcepcion_siEdad50() {
        assertDoesNotThrow(() -> validator.isAdult(50));
    }
}
```

---

## 6. MOCKS CON MOCKITO — EN PROFUNDIDAD

```java
public interface PasarelaPago {
    boolean processPayment(double amount);
    void refund(double amount);
}

public class ServicioPedido {
    private PasarelaPago pasarela;

    public ServicioPedido(PasarelaPago pasarela) {
        this.pasarela = pasarela;    // inyección de dependencia → testeable
    }

    public boolean placeOrder(double amount) {
        if (amount <= 0) throw new IllegalArgumentException("Importe inválido");
        return pasarela.processPayment(amount);
    }
}
```

```java
class ServicioPedidoTest {

    private PasarelaPago mockPasarela;
    private ServicioPedido servicio;

    @BeforeEach
    void init() {
        mockPasarela = mock(PasarelaPago.class);      // crear mock
        servicio = new ServicioPedido(mockPasarela);  // inyectar
    }

    // ── when / thenReturn ─────────────────────────────────
    @Test
    void placeOrder_devuelveTrue_siPagoAprobado() {
        when(mockPasarela.processPayment(100.0)).thenReturn(true);

        boolean result = servicio.placeOrder(100.0);

        assertTrue(result);
        verify(mockPasarela).processPayment(100.0);  // se llamó exactamente 1 vez
    }

    // ── when / thenReturn false ───────────────────────────
    @Test
    void placeOrder_devuelveFalse_siPagoRechazado() {
        when(mockPasarela.processPayment(100.0)).thenReturn(false);

        assertFalse(servicio.placeOrder(100.0));
    }

    // ── when / thenThrow ──────────────────────────────────
    @Test
    void placeOrder_propagaExcepcion_siPasarelaFalla() {
        when(mockPasarela.processPayment(anyDouble()))
            .thenThrow(new RuntimeException("Timeout"));

        assertThrows(RuntimeException.class, () -> servicio.placeOrder(50.0));
    }

    // ── verify: número de invocaciones ───────────────────
    @Test
    void placeOrder_llamaPasarelaUnaVez() {
        when(mockPasarela.processPayment(100.0)).thenReturn(true);
        servicio.placeOrder(100.0);

        verify(mockPasarela, times(1)).processPayment(100.0);  // exactamente 1
        verify(mockPasarela, never()).refund(anyDouble());      // nunca se llama
    }

    // ── Excepción propia del método (no del mock) ─────────
    @Test
    void placeOrder_lanzaExcepcion_siImporteNegativo() {
        // El mock NI SE USA porque la excepción ocurre antes
        assertThrows(IllegalArgumentException.class,
            () -> servicio.placeOrder(-10.0));

        verify(mockPasarela, never()).processPayment(anyDouble()); // confirmado
    }
}
```

### Matchers de Mockito

```java
when(mock.metodo(anyInt())).thenReturn(true);         // cualquier int
when(mock.metodo(anyDouble())).thenReturn(true);      // cualquier double
when(mock.metodo(anyString())).thenReturn("ok");      // cualquier String
when(mock.metodo(eq(42))).thenReturn(true);           // exactamente 42
when(mock.metodo(isNull())).thenThrow(...);           // cuando es null
```

---

## 7. TABLA RESUMEN: ¿QUÉ USAR EN CADA SITUACIÓN?

| Situación | Qué usar |
|---|---|
| Comparar números, strings, objetos | `assertEquals` |
| Comparar doubles con margen | `assertEquals(esperado, real, delta)` |
| Comprobar condición booleana | `assertTrue` / `assertFalse` |
| Esperar que sea null | `assertNull` |
| Esperar que NO sea null | `assertNotNull` |
| Esperar una excepción | `assertThrows` |
| Esperar que NO lanze excepción | `assertDoesNotThrow` |
| Comprobar varios a la vez | `assertAll` |
| Comparar listas/colecciones | `assertIterableEquals` |
| Comparar arrays | `assertArrayEquals` |
| Simular dependencia externa | `mock()` + `when().thenReturn()` |
| Verificar que se llamó un método | `verify(mock).metodo(args)` |
| Mismo test con múltiples valores | `@ParameterizedTest` |
| Probar null y vacío | `@NullAndEmptySource` |

---

## 8. IMPORTS DE REFERENCIA

```java
// JUnit 5 — anotaciones
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Disabled;

// JUnit 5 — assertions (static para usarlas sin prefijo)
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

// O todo de golpe:
import static org.junit.jupiter.api.Assertions.*;

// JUnit 5 — parametrizados
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

// Mockito
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.anyDouble;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.anyString;
import static org.mockito.Mockito.eq;

// O todo de golpe:
import static org.mockito.Mockito.*;
```

---

> ⚡ **Recuerda:** AAA · un comportamiento por test · assertEquals para valores · assertThrows para excepciones · mock() + when() + verify() para dependencias externas
