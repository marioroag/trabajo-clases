# Unidad Didáctica 6: Herencia, Interfaces y Clases Abstractas en Java

## 1. Introducción a la Programación Orientada a Objetos (POO)
La Programación Orientada a Objetos (POO) es un paradigma de programación que se basa en el concepto de "objetos", los cuales pueden contener datos, en forma de campos, y código, en forma de procedimientos. Este paradigma organiza el código en torno a estos objetos, que son instancias de clases, permitiendo una estructura más modular y reutilizable.

### Principales Pilares de la POO

- **Encapsulamiento**: El encapsulamiento es el mecanismo que restringe el acceso directo a algunos de los componentes de un objeto. Esto se logra mediante el uso de modificadores de acceso, como `private`, `protected` y `public`. El encapsulamiento permite proteger los datos del objeto y asegurar que solo se puedan modificar a través de métodos definidos, proporcionando así una mayor seguridad y control sobre los datos.

- **Herencia**: La herencia es una característica que permite que una clase (denominada subclase o clase hija) herede propiedades y comportamientos de otra clase (denominada superclase o clase padre). Esto facilita la reutilización del código y la creación de jerarquías de clases. En Java, la herencia se implementa utilizando la palabra clave `extends`.

- **Polimorfismo**: El polimorfismo es la capacidad de un objeto de tomar muchas formas. En el contexto de la POO, esto significa que una misma interfaz puede ser utilizada para diferentes tipos de datos. El polimorfismo permite que una función o un método se comporte de manera diferente según el objeto que lo invoque. En Java, el polimorfismo se logra principalmente a través de la herencia y las interfaces.

- **Abstracción**: La abstracción es el proceso de ocultar los detalles de implementación y mostrar solo la funcionalidad esencial del objeto. Esto se logra mediante el uso de clases abstractas e interfaces. La abstracción permite a los desarrolladores centrarse en lo que hace un objeto en lugar de cómo lo hace, facilitando así el diseño y la implementación de sistemas complejos.

Estos pilares trabajan juntos para proporcionar una estructura de código que es más fácil de mantener, extender y reutilizar. La POO es ampliamente utilizada en el desarrollo de software moderno debido a sus beneficios en términos de organización y gestión del código.

---

## 2. Herencia en Java
La **herencia** es uno de los pilares fundamentales de la Programación Orientada a Objetos (POO) y permite que una clase (denominada subclase o clase hija) adquiera propiedades y comportamientos de otra clase (denominada superclase o clase padre). La herencia facilita la reutilización del código y la creación de jerarquías de clases, promoviendo un diseño más modular y mantenible. En Java, la herencia se define utilizando la palabra clave `extends`.

### 2.1 Sintaxis de la Herencia
Para declarar que una clase hereda de otra, se utiliza la siguiente sintaxis:
```java
class SuperClase {
    // Propiedades y métodos de la superclase
}

class SubClase extends SuperClase {
    // Propiedades y métodos adicionales de la subclase
}
```
Ejemplo práctico:
```java
class Animal {
    String nombre;
    void hacerSonido() {
        System.out.println("El animal hace un sonido");
    }
}

class Perro extends Animal {
    void hacerSonido() {
        System.out.println("El perro ladra");
    }
}
```
En este ejemplo, `Perro` es una subclase de `Animal` y hereda la propiedad `nombre` y el método `hacerSonido` de `Animal`. Sin embargo, `Perro` también puede redefinir el método `hacerSonido` para proporcionar una implementación específica.

### 2.2 Uso de `super`
La palabra clave `super` se utiliza en Java para referirse a la superclase inmediata de un objeto. Se puede utilizar para acceder a métodos y constructores de la superclase, permitiendo así extender o modificar su comportamiento.

#### Acceso a Métodos de la Superclase
```java
class Mamifero {
    void hacerSonido() {
        System.out.println("El mamífero hace un sonido");
    }
}

class Gato extends Mamifero {
    void hacerSonido() {
        super.hacerSonido(); // Llama al método hacerSonido() de Mamifero
        System.out.println("El gato maúlla");
    }
}
```
En este ejemplo, `Gato` redefine el método `hacerSonido` y utiliza `super.hacerSonido()` para llamar al método de la superclase `Mamifero` antes de agregar su propia implementación.

#### Uso de `super` en Constructores
La palabra clave `super` también se puede utilizar para llamar al constructor de la superclase desde el constructor de la subclase.
```java
class Mamifero {
    Mamifero() {
        System.out.println("Constructor de Mamífero");
    }
}

class Gato extends Mamifero {
    Gato() {
        super(); // Llama al constructor de Mamífero
        System.out.println("Constructor de Gato");
    }
}
```
En este ejemplo, cuando se crea una instancia de `Gato`, primero se llama al constructor de `Mamifero` debido a la llamada `super()`, y luego se ejecuta el constructor de `Gato`.

### 2.3 Herencia y Modificadores de Acceso
Los modificadores de acceso (`private`, `protected`, `public`) juegan un papel crucial en la herencia, ya que determinan la visibilidad de las propiedades y métodos de la superclase en la subclase.

- **`private`**: Los miembros privados de la superclase no son accesibles directamente desde la subclase.
- **`protected`**: Los miembros protegidos son accesibles en la subclase y en otras clases del mismo paquete.
- **`public`**: Los miembros públicos son accesibles desde cualquier clase.

### 2.4 Beneficios de la Herencia
La herencia ofrece varios beneficios clave en el desarrollo de software:

- **Reutilización de Código**: Permite reutilizar el código existente, reduciendo la duplicación y facilitando el mantenimiento.
- **Jerarquía de Clases**: Facilita la creación de jerarquías de clases que reflejan relaciones del mundo real.
- **Extensibilidad**: Permite extender y modificar el comportamiento de las clases existentes sin alterar su código original.
- **Polimorfismo**: Facilita el uso del polimorfismo, permitiendo que una subclase sea tratada como una instancia de su superclase.

---

## 3. Interfaces en Java
Una **interfaz** en Java es una referencia de tipo que solo puede contener constantes, firmas de métodos, métodos predeterminados, métodos estáticos y tipos anidados. Las interfaces no pueden contener implementaciones de métodos (hasta Java 8, donde se introdujeron los métodos predeterminados y estáticos). Las clases que implementan una interfaz deben proporcionar implementaciones para todos los métodos definidos en la interfaz, a menos que la clase sea abstracta.

### 3.1 Definición y Uso
Las interfaces se definen utilizando la palabra clave `interface`. A continuación se muestra un ejemplo de cómo definir y usar una interfaz en Java:

```java
interface Vehiculo {
    void acelerar();
    void frenar();
}

class Coche implements Vehiculo {
    public void acelerar() {
        System.out.println("El coche acelera");
    }
    public void frenar() {
        System.out.println("El coche frena");
    }
}
```

En este ejemplo, `Vehiculo` es una interfaz que declara dos métodos: `acelerar` y `frenar`. La clase `Coche` implementa la interfaz `Vehiculo` y proporciona implementaciones para ambos métodos.

### 3.2 Herencia Múltiple y Interfaces
Java no permite la herencia múltiple de clases, pero una clase puede implementar múltiples interfaces. Esto permite que una clase herede comportamientos de múltiples fuentes.

#### Ejemplo de Implementación de Múltiples Interfaces
```java
interface Volador {
    void volar();
}

interface Nadador {
    void nadar();
}

class Pato implements Volador, Nadador {
    public void volar() {
        System.out.println("El pato vuela");
    }
    public void nadar() {
        System.out.println("El pato nada");
    }
}
```

En este ejemplo, la clase `Pato` implementa dos interfaces, `Volador` y `Nadador`, y proporciona implementaciones para los métodos `volar` y `nadar`.

### 3.3 Ventajas de Usar Interfaces
El uso de interfaces ofrece varias ventajas en el diseño de software orientado a objetos:

- **Desacoplamiento**: Las interfaces permiten desacoplar el código, lo que facilita la modificación y el mantenimiento del software.
- **Flexibilidad**: Permiten definir contratos que pueden ser implementados por cualquier clase, proporcionando flexibilidad en el diseño.
- **Herencia Múltiple**: Permiten que una clase implemente múltiples interfaces, lo que proporciona una forma de herencia múltiple.
- **Polimorfismo**: Facilitan el uso del polimorfismo, permitiendo que una clase sea tratada como una instancia de cualquier interfaz que implemente.

### 3.4 Ejemplo Avanzado de Interfaces
Para ilustrar el uso avanzado de interfaces, consideremos un ejemplo más complejo que involucra múltiples interfaces y clases:

```java
interface Volador {
    void volar();
}

interface Nadador {
    void nadar();
}

interface Corredor {
    void correr();
}

class SuperHeroe implements Volador, Nadador, Corredor {
    public void volar() {
        System.out.println("El superhéroe vuela");
    }
    public void nadar() {
        System.out.println("El superhéroe nada");
    }
    public void correr() {
        System.out.println("El superhéroe corre");
    }
}
```

En este ejemplo, la clase `SuperHeroe` implementa tres interfaces: `Volador`, `Nadador` y `Corredor`, y proporciona implementaciones para los métodos `volar`, `nadar` y `correr`.

---

## 4. Clases Abstractas
Las **clases abstractas** son un tipo especial de clase en Java que no pueden ser instanciadas directamente. Esto significa que no se puede crear un objeto de una clase abstracta utilizando el operador `new`. Las clases abstractas están diseñadas para ser extendidas por otras clases, proporcionando una base común de propiedades y métodos que pueden ser compartidos por múltiples subclases.

### 4.1 Definición y Uso
Una clase abstracta se define utilizando la palabra clave `abstract`. Además de contener métodos concretos (con implementación), una clase abstracta puede contener métodos abstractos, que son métodos sin implementación. Las subclases que extienden una clase abstracta deben proporcionar implementaciones para todos los métodos abstractos de la clase abstracta, a menos que también sean abstractas.

#### Ejemplo de Clase Abstracta
```java
abstract class Figura {
    // Método abstracto: debe ser implementado por las subclases
    abstract double calcularArea();

    // Método concreto: puede ser utilizado por las subclases tal cual
    void mostrarInfo() {
        System.out.println("Soy una figura");
    }
}

class Circulo extends Figura {
    double radio;

    Circulo(double radio) {
        this.radio = radio;
    }

    // Implementación del método abstracto calcularArea
    double calcularArea() {
        return Math.PI * radio * radio;
    }
}
```
En este ejemplo, `Figura` es una clase abstracta que define un método abstracto `calcularArea` y un método concreto `mostrarInfo`. La clase `Circulo` extiende `Figura` y proporciona una implementación para el método `calcularArea`.

### 4.2 Propiedades de las Clases Abstractas
Las clases abstractas pueden tener las siguientes propiedades:

- **Métodos Abstractos**: Métodos que no tienen implementación en la clase abstracta y deben ser implementados por las subclases.
- **Métodos Concretos**: Métodos que tienen una implementación en la clase abstracta y pueden ser utilizados tal cual por las subclases.
- **Constructores**: Aunque no se pueden instanciar directamente, las clases abstractas pueden tener constructores que son llamados cuando una subclase es instanciada.
- **Propiedades**: Las clases abstractas pueden tener propiedades (variables de instancia) que pueden ser heredadas y utilizadas por las subclases.

### 4.3 Ventajas de Usar Clases Abstractas
El uso de clases abstractas ofrece varias ventajas en el diseño de software orientado a objetos:

- **Reutilización de Código**: Permiten definir una base común de propiedades y métodos que pueden ser reutilizados por múltiples subclases, reduciendo la duplicación de código.
- **Organización y Estructura**: Facilitan la organización del código al proporcionar una estructura clara y coherente para las jerarquías de clases.
- **Flexibilidad**: Permiten definir métodos abstractos que deben ser implementados por las subclases, proporcionando flexibilidad para que cada subclase proporcione su propia implementación específica.
- **Encapsulamiento**: Ayudan a encapsular el comportamiento común en una clase base, mejorando la modularidad y mantenibilidad del código.

### 4.4 Diferencias entre Clases Abstractas e Interfaces
Aunque tanto las clases abstractas como las interfaces se utilizan para definir métodos que deben ser implementados por otras clases, existen diferencias clave entre ellas:

| Característica      | Clase Abstracta | Interfaz |
|---------------------|----------------|----------|
| Métodos            | Puede tener métodos abstractos y concretos | Solo métodos abstractos (hasta Java 8, luego también métodos por defecto) |
| Herencia múltiple  | No permitida    | Permitida (una clase puede implementar múltiples interfaces) |
| Constructores      | Puede tener     | No puede tener |
| Uso               | Cuando hay una relación de "es un" | Cuando hay una relación de "puede hacer" |

### 4.5 Ejemplo Avanzado de Clases Abstractas
Para ilustrar el uso avanzado de clases abstractas, consideremos un ejemplo más complejo que involucra una jerarquía de figuras geométricas:

```java
abstract class Figura {
    String color;

    Figura(String color) {
        this.color = color;
    }

    // Método abstracto
    abstract double calcularArea();

    // Método concreto
    void mostrarInfo() {
        System.out.println("Soy una figura de color " + color);
    }
}

class Rectangulo extends Figura {
    double ancho, alto;

    Rectangulo(String color, double ancho, double alto) {
        super(color);
        this.ancho = ancho;
        this.alto = alto;
    }

    // Implementación del método abstracto calcularArea
    double calcularArea() {
        return ancho * alto;
    }
}

class Triangulo extends Figura {
    double base, altura;

    Triangulo(String color, double base, double altura) {
        super(color);
        this.base = base;
        this.altura = altura;
    }

    // Implementación del método abstracto calcularArea
    double calcularArea() {
        return (base * altura) / 2;
    }
}
```
En este ejemplo, `Figura` es una clase abstracta con una propiedad `color`, un método abstracto `calcularArea` y un método concreto `mostrarInfo`. Las clases `Rectangulo` y `Triangulo` extienden `Figura` y proporcionan implementaciones específicas para el método `calcularArea`.