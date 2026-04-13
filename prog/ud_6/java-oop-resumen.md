# CHULETA JAVA OOP — UD6

---

## 1. HERENCIA (`extends`)

Una clase hija hereda atributos y métodos de la clase padre.

```java
class Animal {
    String nombre;

    void hacerSonido() {
        System.out.println("Sonido genérico");
    }
}

class Perro extends Animal {
    // hereda nombre y hacerSonido()
    // puede sobreescribir (override) métodos:
    void hacerSonido() {
        System.out.println("Guau");
    }
}
```

**Reglas clave:**
- Java solo permite herencia simple (1 padre).
- La subclase hereda todo lo `public` y `protected`, NO lo `private`.
- Para acceder a atributos `private` del padre → usar getters/setters.

---

## 2. USO DE `super`

### Llamar a un método del padre

```java
class Gato extends Animal {
    void hacerSonido() {
        super.hacerSonido();   // ejecuta el método del padre
        System.out.println("Miau");
    }
}
```

### Llamar al constructor del padre

```java
class Persona {
    private String nombre;
    private int edad;

    Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }
}

class Estudiante extends Persona {
    private double nota;

    Estudiante(String nombre, int edad, double nota) {
        super(nombre, edad);  // OBLIGATORIO si el padre no tiene constructor vacío
        this.nota = nota;
    }
}
```

**Regla:** `super(...)` siempre va en la PRIMERA línea del constructor hijo.

---

## 3. CLASES ABSTRACTAS (`abstract`)

- NO se pueden instanciar (`new ClaseAbstracta()` → ERROR).
- Pueden tener métodos abstractos (sin cuerpo) y métodos concretos (con cuerpo).
- Las hijas DEBEN implementar todos los métodos abstractos.

```java
abstract class Figura {
    String color;

    Figura(String color) {
        this.color = color;
    }

    // Método ABSTRACTO → sin cuerpo, las hijas lo implementan
    abstract double calcularArea();

    // Método CONCRETO → tiene cuerpo, las hijas lo heredan tal cual
    void mostrarInfo() {
        System.out.println("Figura de color " + color);
    }
}

class Circulo extends Figura {
    double radio;

    Circulo(String color, double radio) {
        super(color);
        this.radio = radio;
    }

    // OBLIGATORIO implementar el abstracto
    double calcularArea() {
        return Math.PI * radio * radio;
    }
}

class Rectangulo extends Figura {
    double ancho, alto;

    Rectangulo(String color, double ancho, double alto) {
        super(color);
        this.ancho = ancho;
        this.alto = alto;
    }

    double calcularArea() {
        return ancho * alto;
    }
}
```

---

## 4. INTERFACES (`interface` / `implements`)

- Definen un **contrato**: qué métodos DEBE tener una clase.
- Solo declaran métodos (sin cuerpo).
- Una clase puede implementar MÚLTIPLES interfaces.
- Los métodos implementados deben ser `public`.

```java
interface Volador {
    void volar();
}

interface Nadador {
    void nadar();
}

// Implementa MÚLTIPLES interfaces
class Pato implements Volador, Nadador {
    public void volar() {
        System.out.println("El pato vuela");
    }
    public void nadar() {
        System.out.println("El pato nada");
    }
}
```

### Interfaces con parámetros y retorno

```java
interface Asignable {
    boolean asignarInstrumento(String nombre, double valor);
    boolean quitarInstrumento(String nombre, double valor);
}

class Trompetista extends Musico implements Asignable {
    private int numeroInstrumentos;
    private double valorInstrumentos;

    public boolean asignarInstrumento(String nombre, double valor) {
        if (nombre == null || nombre.isEmpty()) return false;
        if (valor <= 0) return false;
        numeroInstrumentos++;
        valorInstrumentos += valor;
        return true;
    }

    public boolean quitarInstrumento(String nombre, double valor) {
        if (numeroInstrumentos == 0) return false;
        if (valor <= 0) return false;
        numeroInstrumentos--;
        valorInstrumentos -= valor;
        if (valorInstrumentos < 0) valorInstrumentos = 0;
        return true;
    }
}
```

---

## 5. HERENCIA + ABSTRACTA + INTERFACE (combo completo)

```java
// CLASE ABSTRACTA (nivel 1)
abstract class PersonaAgrupacion {
    private String nombre;
    private int edad;
    private int antiguedad;

    PersonaAgrupacion(String nombre, int edad, int antiguedad) {
        this.nombre = nombre;
        this.edad = edad;
        this.antiguedad = antiguedad;
    }

    // Getters y setters...
    public String getNombre() { return nombre; }
    public int getEdad() { return edad; }
    public int getAntiguedad() { return antiguedad; }

    public abstract double calcularAportacion();
    public abstract boolean puedeParticipar();

    public void cumplirAnio() { edad++; }
    public void aumentarAntiguedad() { antiguedad++; }
}

// INTERFACE
interface GestionHumana {
    boolean asignarMusico(PersonaAgrupacion persona);
    boolean expulsarMusico(String nombre);
}

// CLASE que hereda de abstracta + implementa interface (nivel 2)
class Director extends PersonaAgrupacion implements GestionHumana {
    private String especialidad;
    private int maximoMusicos;
    private ArrayList<PersonaAgrupacion> musicosAsignados;
    private double plusDireccion;

    Director(String nombre, int edad, int antiguedad,
             String especialidad, int maximoMusicos, double plusDireccion) {
        super(nombre, edad, antiguedad);
        this.especialidad = especialidad;
        this.maximoMusicos = maximoMusicos;
        this.plusDireccion = plusDireccion;
        this.musicosAsignados = new ArrayList<>();
    }

    public double calcularAportacion() {
        return getAntiguedad() * 10 + plusDireccion + (musicosAsignados.size() * 5);
    }

    public boolean puedeParticipar() {
        return getEdad() >= 18;
    }

    public boolean asignarMusico(PersonaAgrupacion persona) {
        if (persona == null) return false;
        // Comprobar duplicados por nombre
        for (PersonaAgrupacion p : musicosAsignados) {
            if (p.getNombre().equals(persona.getNombre())) return false;
        }
        if (musicosAsignados.size() >= maximoMusicos) return false;
        musicosAsignados.add(persona);
        return true;
    }

    public boolean expulsarMusico(String nombre) {
        for (int i = 0; i < musicosAsignados.size(); i++) {
            if (musicosAsignados.get(i).getNombre().equals(nombre)) {
                musicosAsignados.remove(i);
                return true;
            }
        }
        return false;
    }

    // Método propio extra
    public double calcularValorTotalAportacionMusicos() {
        double total = 0;
        for (PersonaAgrupacion p : musicosAsignados) {
            total += p.calcularAportacion();
        }
        return total;
    }
}
```

---

## 6. CADENA DE HERENCIA (3 niveles)

```java
// Nivel 1: abstracta
abstract class PersonaAgrupacion { ... }

// Nivel 2: hereda de abstracta
class Musico extends PersonaAgrupacion {
    private int nivel;
    private int asistenciaEnsayos;
    private double valorBase;

    public double calcularAportacion() {
        return valorBase + (nivel * 2) + (asistenciaEnsayos * 1.5);
    }

    public boolean puedeParticipar() {
        return asistenciaEnsayos >= 3;
    }
}

// Nivel 3: hereda de Musico + implementa interface
class Trompetista extends Musico implements Asignable {
    private int resistencia;
    private int numeroSolos;

    // Usa super.calcularAportacion() para reutilizar el cálculo del padre
    public double calcularAportacion() {
        return super.calcularAportacion() + resistencia + (numeroSolos * 3);
    }

    // Combina la condición del padre con la suya propia
    public boolean puedeParticipar() {
        return super.puedeParticipar() && resistencia >= 5;
    }
}
```

**Patrón `super.metodo()` en cadena:**
- `Trompetista.calcularAportacion()` llama a `super.calcularAportacion()` → ejecuta el de `Musico`
- Así se **acumula** el cálculo de cada nivel.

---

## 7. POLIMORFISMO

### Referencia del padre, objeto del hijo

```java
// La variable es de tipo Figura, el objeto real es Circulo
Figura f = new Circulo("rojo", 5.0);
f.calcularArea();  // ✅ ejecuta el de Circulo (enlace dinámico)
```

### Recorrer colección polimórfica

```java
ArrayList<PersonaAgrupacion> todos = new ArrayList<>();
todos.add(new Director("Ana", 40, 10, "Viento", 20, 50));
todos.add(new Trompetista("Luis", 25, 3, "Trompeta", 6, 8, 20, 0, 0, 7, 4));
todos.add(new Percusionista("Marta", 22, 2, "Caja", 5, 6, 15, 0, 0, 6, 3));

double totalAportacion = 0;
int puedenParticipar = 0;

for (PersonaAgrupacion p : todos) {
    totalAportacion += p.calcularAportacion();  // cada uno ejecuta SU versión
    if (p.puedeParticipar()) {
        puedenParticipar++;
    }
}

System.out.println("Aportación total: " + totalAportacion);
System.out.println("Pueden participar: " + puedenParticipar);
```

### Referencia de tipo Interface

```java
Asignable ref = new Trompetista(...);
ref.asignarInstrumento("Trompeta Bach", 1200);
// Solo puedes usar métodos de Asignable, no los de Musico
```

### ⚠️ Limitación

```java
Figura f = new Circulo("rojo", 5.0);
f.calcularArea();       // ✅ definido en Figura
f.metodoSoloCirculo();  // ❌ ERROR — la referencia es Figura, no ve métodos de Circulo
```

**Regla:** con una referencia del padre solo accedes a métodos definidos en el padre. Java ejecuta la versión del hijo (enlace dinámico), pero el compilador solo ve la del padre.

---

## 8. PATRONES COMUNES EN EJERCICIOS

### Validar antes de modificar

```java
public void sumarPuntos(double puntos) {
    if (puntos > 0) {       // solo si es positivo
        this.puntos += puntos;
    }
}

public void consumirActuacion() {
    if (actuacionesDisponibles > 0) {  // solo si queda algo
        actuacionesDisponibles--;
    }
}
```

### Buscar y eliminar en ArrayList

```java
public boolean eliminarPorNombre(String nombre) {
    for (int i = 0; i < lista.size(); i++) {
        if (lista.get(i).getNombre().equals(nombre)) {
            lista.remove(i);
            return true;
        }
    }
    return false;
}
```

### Comprobar duplicados antes de añadir

```java
public boolean asignar(PersonaAgrupacion persona) {
    if (persona == null) return false;
    for (PersonaAgrupacion p : lista) {
        if (p.getNombre().equals(persona.getNombre())) return false;
    }
    lista.add(persona);
    return true;
}
```

### Sumar valores de toda la lista

```java
public double calcularTotal() {
    double total = 0;
    for (PersonaAgrupacion p : lista) {
        total += p.calcularAportacion();
    }
    return total;
}
```

### Evitar valores negativos

```java
valorInstrumentos -= valor;
if (valorInstrumentos < 0) valorInstrumentos = 0;
```

---

## 9. TABLA RESUMEN RÁPIDA

| Concepto | Palabra clave | ¿Se instancia? | ¿Herencia múltiple? | ¿Tiene constructor? |
|---|---|---|---|---|
| Clase normal | `class` | ✅ Sí | ❌ No | ✅ Sí |
| Clase abstracta | `abstract class` | ❌ No | ❌ No | ✅ Sí (para las hijas) |
| Interface | `interface` | ❌ No | ✅ Sí (múltiples) | ❌ No |

| Relación | Palabra | Ejemplo |
|---|---|---|
| Herencia | `extends` | `class Perro extends Animal` |
| Implementar | `implements` | `class Pato implements Volador, Nadador` |
| Combo | ambas | `class Guitarrista extends Musico implements Tocable, Revisable` |

---

## 10. ESQUELETO COMPLETO DE UN MAIN TÍPICO

```java
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        // 1. Crear objetos
        Director dir = new Director("Ana", 40, 10, "Viento", 20, 50);
        Trompetista t1 = new Trompetista("Luis", 25, 3, "Trompeta", 6, 8, 20, 0, 0, 7, 4);
        Trompetista t2 = new Trompetista("Carlos", 30, 5, "Trompeta", 7, 10, 25, 0, 0, 8, 5);
        Percusionista p1 = new Percusionista("Marta", 22, 2, "Caja", 5, 6, 15, 0, 0, 6, 3);
        Percusionista p2 = new Percusionista("Sara", 28, 4, "Timbal", 6, 7, 18, 0, 0, 5, 2);

        // 2. Modificar estado
        t1.registrarEnsayo();
        t1.subirNivel();
        t1.asignarInstrumento("Bach Strad", 1200);
        t1.registrarSolo();
        t1.aumentarResistencia(3);

        p1.registrarEnsayo();
        p1.asignarInstrumento("Caja Pearl", 800);
        p1.registrarCambioRitmoCorrecto();
        p1.aumentarPotencia(2);

        dir.asignarMusico(t1);
        dir.asignarMusico(p1);

        // 3. Referencias polimórficas
        PersonaAgrupacion referencia1 = t1;          // ref padre → objeto hijo
        Asignable referencia2 = t2;                   // ref interface → objeto que la implementa

        // 4. Colección polimórfica
        ArrayList<PersonaAgrupacion> todos = new ArrayList<>();
        todos.add(dir);
        todos.add(t1);
        todos.add(t2);
        todos.add(p1);
        todos.add(p2);

        double totalAportacion = 0;
        int puedenParticipar = 0;
        for (PersonaAgrupacion p : todos) {
            totalAportacion += p.calcularAportacion();
            if (p.puedeParticipar()) puedenParticipar++;
        }

        // 5. Mostrar resultados
        System.out.println("Aportación director: " + dir.calcularAportacion());
        System.out.println("Aportación t1: " + t1.calcularAportacion());
        System.out.println("Aportación t2: " + t2.calcularAportacion());
        System.out.println("Aportación p1: " + p1.calcularAportacion());
        System.out.println("Aportación p2: " + p2.calcularAportacion());
        System.out.println("Músicos asignados: " + dir.contarMusicosAsignados());
        System.out.println("Valor total músicos: " + dir.calcularValorTotalAportacionMusicos());
        System.out.println("Aportación total: " + totalAportacion);
        System.out.println("Pueden participar: " + puedenParticipar);
    }
}
```
