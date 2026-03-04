# Unidad Didáctica 5: Diagramas de Clases UML

## Índice

- [Unidad Didáctica 5: Diagramas de Clases UML](#unidad-didáctica-5-diagramas-de-clases-uml)
  - [Índice](#índice)
  - [Glosario](#glosario)
  - [1. Introducción y fundamentos](#1-introducción-y-fundamentos)
    - [1.1. Contexto técnico](#11-contexto-técnico)
    - [1.2. Programación orientada a objetos y modelado estructural](#12-programación-orientada-a-objetos-y-modelado-estructural)
    - [1.3. Importancia del modelado previo en el desarrollo de software](#13-importancia-del-modelado-previo-en-el-desarrollo-de-software)
    - [1.4. Rol del diagrama de clases dentro de UML](#14-rol-del-diagrama-de-clases-dentro-de-uml)
  - [2. Fundamentos técnicos del diagrama de clases](#2-fundamentos-técnicos-del-diagrama-de-clases)
    - [2.1. Estructura formal de una clase en UML](#21-estructura-formal-de-una-clase-en-uml)
    - [2.2. Visibilidad y encapsulamiento](#22-visibilidad-y-encapsulamiento)
    - [2.3. Tipado de atributos y métodos](#23-tipado-de-atributos-y-métodos)
    - [2.4. Firmas de métodos y valores de retorno](#24-firmas-de-métodos-y-valores-de-retorno)
    - [2.5. Clases abstractas e interfaces](#25-clases-abstractas-e-interfaces)
    - [2.6. Enumeraciones y tipos especiales](#26-enumeraciones-y-tipos-especiales)
  - [3. Relaciones estructurales entre clases](#3-relaciones-estructurales-entre-clases)
    - [3.1. Asociación](#31-asociación)
      - [3.1.1. Asociación reflexiva (autoasociación)](#311-asociación-reflexiva-autoasociación)
    - [3.2. Multiplicidad y navegabilidad](#32-multiplicidad-y-navegabilidad)
    - [3.3. Dependencia](#33-dependencia)
    - [3.4. Agregación](#34-agregación)
    - [3.5. Composición](#35-composición)
    - [3.6. Generalización y herencia](#36-generalización-y-herencia)
    - [3.7. Realización](#37-realización)
  - [4. Elementos avanzados del modelado estructural](#4-elementos-avanzados-del-modelado-estructural)
    - [4.1. Clases de asociación](#41-clases-de-asociación)
    - [4.2. Clases anidadas](#42-clases-anidadas)
    - [4.3. Paquetes y organización modular](#43-paquetes-y-organización-modular)
    - [4.4. Restricciones y notas](#44-restricciones-y-notas)
  - [5. Integración con el entorno de desarrollo](#5-integración-con-el-entorno-de-desarrollo)
    - [5.1. Generación de código a partir del diagrama](#51-generación-de-código-a-partir-del-diagrama)
    - [5.2. Ingeniería inversa desde código existente](#52-ingeniería-inversa-desde-código-existente)
    - [5.3. Sincronización modelo–código](#53-sincronización-modelocódigo)
    - [5.4. Limitaciones y riesgos de la generación automática](#54-limitaciones-y-riesgos-de-la-generación-automática)
  - [6. Análisis crítico y calidad del modelado](#6-análisis-crítico-y-calidad-del-modelado)
    - [6.1. Identificación de responsabilidades](#61-identificación-de-responsabilidades)
    - [6.2. Cohesión y acoplamiento](#62-cohesión-y-acoplamiento)
    - [6.3. Buenas prácticas de diseño estructural](#63-buenas-prácticas-de-diseño-estructural)
    - [6.4. Errores frecuentes en el modelado](#64-errores-frecuentes-en-el-modelado)
    - [6.5. Sobre-modelado y sub-modelado](#65-sobre-modelado-y-sub-modelado)
  - [7. Síntesis estructural de la unidad](#7-síntesis-estructural-de-la-unidad)

---

## Glosario

- **Agregación**: Relación estructural débil entre clases en la que una clase contiene referencias a otra, pero las instancias pueden existir de forma independiente.
- **Asociación**: Relación estructural básica entre clases que indica que sus objetos están conectados o interactúan entre sí.
- **Atributo**: Propiedad o característica de una clase que define su estado. En UML se representa en el segundo compartimento de la clase.
- **Clase**: Elemento fundamental del modelado orientado a objetos que define un conjunto de atributos y métodos comunes para sus instancias.
- **Clase abstracta**: Clase que no puede instanciarse directamente y que sirve como base para otras clases mediante herencia.
- **Clase de asociación**: Clase que modela información adicional sobre una relación entre dos clases.
- **Cohesión**: Grado en el que los elementos internos de una clase están relacionados entre sí y cumplen una única responsabilidad clara.
- **Composición**: Relación estructural fuerte en la que una clase contiene a otra y su ciclo de vida depende completamente de la clase contenedora.
- **Dependencia**: Relación en la que un elemento utiliza a otro de forma puntual, sin mantener una relación estructural permanente.
- **Diagrama de clases**: Diagrama estructural de UML que representa clases, atributos, métodos y las relaciones entre ellas.
- **Encapsulamiento**: Principio de la programación orientada a objetos que consiste en restringir el acceso directo a los atributos de una clase mediante niveles de visibilidad.
- **Enumeración**: Tipo especial que define un conjunto limitado y fijo de valores posibles.
- **Firma de método**: Definición formal de un método compuesta por su nombre, parámetros y tipo de retorno.
- **Generalización**: Relación que representa herencia entre clases, donde una clase hija extiende o especializa a una clase padre.
- **Herencia**: Mecanismo de reutilización que permite que una clase derive de otra heredando sus atributos y métodos.
- **Ingeniería inversa**: Proceso de generación automática de un diagrama de clases a partir del código fuente existente.
- **Interfaz**: Tipo que define un conjunto de métodos sin implementación que deben ser desarrollados por las clases que la implementan.
- **Método**: Operación o comportamiento definido dentro de una clase. En UML se representa en el tercer compartimento.
- **Modelado estructural**: Representación formal de la estructura estática de un sistema mediante clases y relaciones.
- **Multiplicidad**: Indicador que especifica cuántas instancias de una clase pueden relacionarse con instancias de otra clase.
- **Navegabilidad**: Dirección en la que una asociación puede recorrerse dentro del modelo.
- **Paquete**: Elemento organizativo que agrupa clases relacionadas dentro de un modelo UML.
- **Programación orientada a objetos**: Paradigma de programación basado en el uso de clases y objetos que encapsulan estado y comportamiento.
- **Realización**: Relación que indica que una clase implementa una interfaz.
- **Responsabilidad**: Función o propósito específico que una clase debe cumplir dentro del sistema.
- **UML**: Lenguaje de Modelado Unificado utilizado para especificar, visualizar y documentar sistemas de software.

---

## 1. Introducción y fundamentos

### 1.1. Contexto técnico

El desarrollo profesional de software no consiste únicamente en escribir código que funcione. Antes de implementar una solución es necesario **comprender el problema, estructurarlo y representarlo formalmente**. Esta fase previa permite tomar decisiones de diseño que afectan directamente a la calidad, mantenibilidad y escalabilidad del sistema.

En proyectos reales, el modelado actúa como una herramienta de ingeniería. Permite abstraer los detalles técnicos de la implementación y centrarse en la estructura del sistema: qué elementos lo componen, qué responsabilidades tienen y cómo se relacionan entre sí. Esta representación previa reduce la ambigüedad y facilita que distintos miembros de un equipo compartan una visión común del diseño.

Dentro de este contexto aparece UML (*Unified Modeling Language*), un lenguaje de modelado estandarizado que proporciona una notación gráfica común para representar sistemas orientados a objetos. UML no es un lenguaje de programación, sino un lenguaje de especificación visual.

### 1.2. Programación orientada a objetos y modelado estructural

La programación orientada a objetos (POO) es un paradigma basado en la definición de **clases** que encapsulan estado y comportamiento. Una clase describe cómo será un objeto, qué datos almacenará y qué operaciones podrá realizar.

Este paradigma se fundamenta en varios principios esenciales:

- Encapsulamiento: consiste en ocultar los detalles internos de una clase y exponer únicamente lo necesario. Por ejemplo, una clase `CuentaBancaria` puede tener un atributo privado `saldo` y métodos públicos como `ingresar()` o `retirar()`. El saldo no se modifica directamente desde fuera, sino a través de métodos controlados.

- Abstracción: implica centrarse en las características relevantes de un objeto y omitir los detalles irrelevantes. Una clase `Vehiculo` puede definirse con atributos como `marca` y `modelo` sin necesidad de modelar inicialmente todos los componentes mecánicos internos.

- Herencia: permite que una clase derive de otra y reutilice su comportamiento. Por ejemplo, `Empleado` puede heredar de `Persona`, reutilizando atributos como `nombre` o `fechaNacimiento`.

- Polimorfismo: posibilita que diferentes clases respondan de manera distinta a una misma operación. Si `Figura` define un método `calcularArea()`, las clases `Circulo` y `Rectangulo` podrán implementarlo de forma diferente.

El modelado estructural consiste en representar gráficamente estos conceptos antes de escribir código. En lugar de comenzar directamente con la implementación, se construye un modelo que muestra las clases y sus relaciones. Este modelo actúa como plano arquitectónico del sistema.

### 1.3. Importancia del modelado previo en el desarrollo de software

Modelar antes de programar introduce una fase de análisis estructural que mejora la calidad del diseño. Permite identificar responsabilidades mal distribuidas, dependencias innecesarias o clases excesivamente complejas antes de que el problema se traslade al código.

Cuando se omite esta fase, es frecuente que aparezcan síntomas como clases con demasiadas funciones, lógica duplicada o acoplamientos difíciles de mantener. En cambio, un diseño previo facilita una arquitectura más coherente y modular.

Además, el modelado cumple una función documental. Un diagrama bien construido permite comprender la estructura del sistema sin necesidad de analizar cientos o miles de líneas de código. Esto resulta especialmente relevante en entornos profesionales donde distintos desarrolladores intervienen en el mismo proyecto.

Por tanto, el modelado no es una tarea decorativa, sino una herramienta técnica que reduce riesgos y mejora la sostenibilidad del software.

### 1.4. Rol del diagrama de clases dentro de UML

UML incluye distintos tipos de diagramas que representan diferentes perspectivas de un sistema. Algunos describen el comportamiento dinámico, mientras que otros representan su estructura estática. El diagrama de clases pertenece a este segundo grupo.

El diagrama de clases muestra la arquitectura estructural del sistema. Representa:

- Las clases que lo componen.
- Los atributos que definen su estado.
- Los métodos que describen su comportamiento.
- Las relaciones estructurales entre ellas.

Su utilidad es doble. Por un lado, permite diseñar la estructura antes de la implementación. Por otro, puede generarse automáticamente a partir del código mediante ingeniería inversa, convirtiéndose en una herramienta de análisis y documentación.

---

## 2. Fundamentos técnicos del diagrama de clases

### 2.1. Estructura formal de una clase en UML

En UML, una clase se representa mediante un rectángulo dividido en tres compartimentos horizontales:

1. Nombre de la clase.
2. Atributos.
3. Métodos.

El nombre aparece en la parte superior y debe escribirse con la primera letra en mayúscula siguiendo convención de nomenclatura. Si la clase es abstracta, su nombre se escribe en *cursiva*.

Ejemplo textual simplificado:

```text
-------------------------
|        Usuario        |
-------------------------
| - nombre: String      |
| - email: String       |
-------------------------
| + login(): boolean    |
| + logout(): void      |
-------------------------
```

El segundo compartimento contiene los atributos que definen el estado interno de la clase. El tercero contiene los métodos que describen su comportamiento.

En UML no es obligatorio incluir todos los atributos o métodos. El nivel de detalle dependerá del objetivo del modelo: análisis conceptual, diseño técnico o documentación detallada.

### 2.2. Visibilidad y encapsulamiento

La visibilidad indica el nivel de acceso que otros elementos del sistema tienen sobre los atributos y métodos de una clase. UML utiliza símbolos específicos para representarla:

- `+` público
- `-` privado
- `#` protegido
- `~` paquete

La visibilidad de paquete (`~`) permite que el atributo o método sea accesible únicamente desde clases que pertenecen al mismo paquete. Es equivalente al acceso por defecto en lenguajes como Java.

Un atributo privado (`-`) solo puede ser accedido desde la propia clase. Esto refuerza el principio de *encapsulamiento*, que consiste en proteger el estado interno del objeto y controlar cómo se modifica.

Por ejemplo, si una clase `CuentaBancaria` define:

```text
- saldo: double
+ ingresar(cantidad: double): void
```

El atributo `saldo` no debe modificarse directamente desde el exterior. La única forma de alterarlo será a través del método `ingresar()`, lo que permite validar reglas como evitar ingresos negativos.

Además de la visibilidad, UML permite indicar si un atributo o método es *estático*. Los miembros estáticos pertenecen a la clase y no a sus instancias. Se representan subrayando su nombre o mediante la etiqueta `{static}`.

Ejemplo:

```text
+----------------------------------+
|              Usuario             |
+----------------------------------+
| {static} - contador: int         |
+----------------------------------+
| {static} + getTotal(): int       |
+----------------------------------+
```

En este caso, `contador` no pertenece a cada objeto `Usuario`, sino a la clase en su conjunto. Todos los objetos comparten el mismo valor.

### 2.3. Tipado de atributos y métodos

En UML, los atributos deben especificar su tipo de dato utilizando la siguiente sintaxis:

```text
visibilidad nombre: Tipo
```

Ejemplo:

```text
- fechaNacimiento: LocalDate
- precio: double
```

El tipado no es un detalle menor. Permite definir con precisión la naturaleza del dato y anticipar restricciones técnicas. En fases de diseño detallado, es recomendable indicar tipos reales del lenguaje objetivo, como `String`, `int` o `List<Producto>`.

En el caso de los métodos, también debe indicarse el tipo de retorno:

```text
+ calcularTotal(): double
```

Si el método no devuelve ningún valor, se indica `void`.

Cuando un método es estático, debe indicarse igualmente con `{static}` o mediante subrayado:

```text
{static} + crearInvitado(): Usuario
```

El tipado claro y la correcta identificación de miembros estáticos facilitan la comprensión del modelo y su posterior traducción automática a código.

### 2.4. Firmas de métodos y valores de retorno

La firma de un método está compuesta por:

- Nombre del método.
- Lista de parámetros.
- Tipo de retorno.

En UML, la sintaxis general es:

```text
visibilidad nombreMetodo(parametro: Tipo): TipoRetorno
```

Ejemplo:

```text
+ transferir(destino: CuentaBancaria, cantidad: double): boolean
```

En este caso, el método `transferir` recibe dos parámetros y devuelve un valor booleano que podría indicar si la operación se realizó correctamente.

Es importante diferenciar entre método y atributo. El método representa una acción; el atributo representa estado. Confundir ambos en el modelado conduce a diseños poco claros.

Cuando existen métodos sobrecargados (mismo nombre, distinta lista de parámetros), cada variante debe representarse por separado en el diagrama.

### 2.5. Clases abstractas e interfaces

Una clase abstracta es aquella que no puede instanciarse directamente. Se utiliza como base para otras clases más concretas. En UML se representa escribiendo el nombre de la clase en *cursiva* o indicando la etiqueta `{abstract}`.

Ejemplo conceptual:

```text
-------------------------------
|          *Empleado*         |
-------------------------------
| - nombre: String            |
-------------------------------
| + calcularSalario(): double |
-------------------------------
```

Una clase derivada como `Gerente` heredaría de `Empleado` e implementaría el método `calcularSalario()`.

Una interfaz, por su parte, define un conjunto de métodos sin implementación. En UML se representa con la palabra `<<interface>>` encima del nombre:

```text
-----------------------------
|        <<interface>>      |
|          Pagable          |
-----------------------------
| + calcularTotal(): double |
-----------------------------
```

La relación entre una clase y una interfaz se denomina *realización* y se representa mediante una línea discontinua con flecha triangular.

Las interfaces favorecen diseños desacoplados y flexibles.

### 2.6. Enumeraciones y tipos especiales

Una enumeración define un conjunto finito y cerrado de valores posibles. En UML se representa con la etiqueta `<<enumeration>>`.

Ejemplo:

```text
-------------------------
|    <<enumeration>>    |
|     EstadoPedido      |
-------------------------
| PENDIENTE             |
| ENVIADO               |
| ENTREGADO             |
-------------------------
```

Las enumeraciones son útiles cuando un atributo solo puede adoptar ciertos valores predefinidos.

Otros tipos especiales que pueden aparecer en un diagrama de clases incluyen:

- Colecciones genéricas como `List<Producto>`.
- Tipos definidos por el propio modelo.
- Clases externas representadas como dependencias.

---

## 3. Relaciones estructurales entre clases

### 3.1. Asociación

La asociación representa una relación estructural entre dos clases cuyos objetos mantienen algún tipo de vínculo estable. Es la relación más básica dentro del modelado estructural.

Por ejemplo, si un `Cliente` realiza un `Pedido`, existe una asociación entre ambas clases. Esta relación indica que los objetos de una clase conocen o utilizan a los de la otra.

En UML se representa mediante una línea continua entre las clases. Puede ser bidireccional o unidireccional dependiendo de si ambas clases se conocen mutuamente o solo una mantiene referencia a la otra.

#### 3.1.1. Asociación reflexiva (autoasociación)

Una asociación reflexiva se produce cuando una clase se relaciona consigo misma. Es decir, las instancias de una clase mantienen una relación estructural con otras instancias de la misma clase.

Este tipo de relación es frecuente en estructuras jerárquicas internas.

Ejemplo clásico: un `Empleado` puede supervisar a otros `Empleado`.

```text
Empleado 0..* -------- 0..1 Empleado
```

En este modelo:

- Un empleado puede supervisar a varios empleados.
- Cada empleado puede estar supervisado, como máximo, por un único empleado.

Es importante no confundir esta relación con la herencia. En la herencia existe una relación de tipo *“es un”* entre clases distintas. En la asociación reflexiva, la relación se produce entre objetos de la misma clase, no entre clases diferentes.

La autoasociación permite modelar jerarquías internas, estructuras en árbol o relaciones recursivas dentro de un mismo tipo.

### 3.2. Multiplicidad y navegabilidad

La multiplicidad especifica cuántas instancias de una clase pueden estar relacionadas con instancias de otra clase. Se indica junto a los extremos de la asociación.

Algunos ejemplos habituales son:

- `1` → exactamente una instancia.
- `0..1` → cero o una.
- `1..*` → una o muchas.
- `0..*` → cero o muchas.

Si un `Cliente` puede tener varios `Pedido`, la multiplicidad se representaría como:

```text
Cliente 1 -------- 0..* Pedido
```

Esto significa que cada pedido pertenece a un único cliente, pero un cliente puede tener varios pedidos.

La navegabilidad indica la dirección en la que puede recorrerse la relación. Se representa con una flecha en el extremo correspondiente.

Aquí es importante no confundir conceptos:

- La visibilidad (`+`, `-`, `#`, `~`) afecta a atributos y métodos dentro de una clase.
- La navegabilidad afecta a la dirección de una relación entre clases.

Una clase puede tener un atributo privado que almacene una referencia a otra clase, pero eso no implica necesariamente que la relación sea bidireccional. La navegabilidad se decide a nivel estructural del modelo.

### 3.3. Dependencia

La dependencia indica que una clase utiliza a otra de forma puntual, sin mantener una relación estructural permanente. No existe atributo que almacene la referencia.

Se representa con línea discontinua y flecha:

```text
GeneradorInforme - - - - -> Cliente
```

En este caso, `Cliente` puede aparecer como parámetro de un método:

```text
+ generar(cliente: Cliente): Documento
```

La diferencia con la asociación es clara: en la dependencia el uso es temporal; en la asociación existe un vínculo estructural estable.

### 3.4. Agregación

La agregación representa una relación todo–parte débil. Una clase agrupa a otra, pero las instancias de la parte pueden existir de forma independiente.

Se representa con un rombo blanco en el extremo del todo:

```text
Universidad ◇ -------- 0..* Estudiante
```

En este ejemplo, `Universidad` agrupa `Estudiante`, pero un estudiante puede existir aunque cambie de universidad o incluso aunque no esté asociado temporalmente a ninguna.

La agregación expresa organización lógica, no dependencia de ciclo de vida.

### 3.5. Composición

La composición es una relación todo–parte fuerte. La parte depende completamente del todo y no puede existir de manera independiente.

Se representa con un rombo negro en el extremo del todo:

```text
Casa ◆ -------- 1..* Habitacion
```

En este modelo, `Habitacion` forma parte estructural de `Casa`. Si la casa desaparece, las habitaciones también dejan de existir dentro del sistema.

La diferencia esencial respecto a la agregación es la dependencia de ciclo de vida: en la composición, la parte no tiene sentido sin el todo.

### 3.6. Generalización y herencia

La generalización representa una relación jerárquica entre una clase general (superclase) y una clase específica (subclase). Se modela mediante una línea continua con una flecha triangular vacía apuntando a la clase padre.

```text
Empleado --------|> Persona
```

En este ejemplo, `Empleado` es un tipo específico de `Persona`. Hereda sus atributos y métodos, pudiendo además añadir comportamiento propio o redefinir operaciones.

Otro ejemplo encadenado:

```text
Gerente --------|> Empleado --------|> Persona
```

La herencia debe utilizarse únicamente cuando exista una verdadera relación semántica de tipo *“es un”*. Si esta condición no se cumple, el modelo pierde coherencia y aumenta el acoplamiento innecesario.

### 3.7. Realización

La realización indica que una clase implementa una interfaz. Se representa mediante una línea discontinua con flecha triangular apuntando a la interfaz.

```text
Factura - - - - |> Pagable
```

Si `Pagable` define el método `calcularTotal(): double`, la clase `Factura` deberá proporcionar su implementación concreta.

La interfaz se representa así:

```text
+----------------------------+
|        <<interface>>       |
|           Pagable          |
+----------------------------+
| + calcularTotal(): double  |
+----------------------------+
```

La realización permite definir contratos de comportamiento sin depender de clases concretas. Esto favorece el desacoplamiento y facilita sustituir una implementación por otra sin modificar el resto del sistema.

---

## 4. Elementos avanzados del modelado estructural

### 4.1. Clases de asociación

Una clase de asociación se utiliza cuando una relación entre dos clases necesita almacenar información propia. No basta con indicar que existe una asociación; es necesario modelar datos adicionales vinculados a esa relación.

Por ejemplo, si un `Alumno` se matricula en un `Curso`, puede ser necesario almacenar la `fechaMatricula` o la `calificacion`. En ese caso, la relación deja de ser una simple asociación y pasa a modelarse mediante una clase intermedia:

```text
+-----------+    1                 0..*   +-----------+
|  Alumno   |-----------------------------|   Curso   |
+-----------+                             +-----------+
        \                                  /
         \                                /
          \                              /
           \                            /
            +--------------------------+
            |        Matricula         |
            +--------------------------+
            | - fecha: LocalDate       |
            | - calificacion: double   |
            +--------------------------+
```

La clase `Matricula` contiene los atributos propios de la relación:

```text
+--------------------------+
|         Matricula        |
+--------------------------+
| - fecha: LocalDate       |
| - calificacion: double   |
+--------------------------+
```

Este mecanismo es especialmente útil en relaciones muchos a muchos con información adicional.

### 4.2. Clases anidadas

Una clase anidada es una clase definida dentro del ámbito de otra. En UML puede representarse visualmente dentro del rectángulo de la clase contenedora o mediante una relación de composición explícita.

Ejemplo conceptual:

```text
+------------------------------------+
|              Pedido                |
+------------------------------------+
| - numero: String                   |
+------------------------------------+
| + calcularTotal(): double          |
+------------------------------------+
|                                    |
|   +----------------------------+   |
|   |        LineaPedido         |   |
|   +----------------------------+   |
|   | - cantidad: int            |   |
|   | - precio: double           |   |
|   +----------------------------+   |
|                                    |
+------------------------------------+
```

La clase `LineaPedido` forma parte estructural de `Pedido` y normalmente no tiene sentido fuera de ese contexto.

Las clases anidadas permiten reforzar el encapsulamiento y modelar elementos que solo existen dentro del ámbito lógico de otra clase.

### 4.3. Paquetes y organización modular

Los paquetes permiten organizar clases en grupos coherentes. Son elementos estructurales que facilitan la modularidad y reducen la complejidad del modelo.

Se representan mediante un rectángulo con una pestaña superior:

```text
+----------------------+
| paquete ventas       |
+----------------------+
| Pedido               |
| Factura              |
| Cliente              |
+----------------------+
```

Los paquetes ayudan a:

- Agrupar clases relacionadas funcionalmente.
- Reducir dependencias innecesarias entre módulos.
- Mejorar la escalabilidad del sistema.

En proyectos reales, los paquetes suelen corresponder con la organización del código en carpetas o *namespaces*.

### 4.4. Restricciones y notas

Las restricciones permiten especificar reglas adicionales que no pueden expresarse únicamente mediante relaciones estructurales. Se indican entre llaves `{}` o mediante notas conectadas al elemento correspondiente.

Ejemplo de restricción:

```text
Pedido
-------------------------
- total: double {total >= 0}
```

Aquí se indica que el atributo `total` no puede ser negativo.

Las notas se representan como un rectángulo con esquina doblada y pueden conectarse mediante línea discontinua:

```text
[Nota]
Un cliente no puede tener más de 5 pedidos activos
```

Las restricciones y notas enriquecen el modelo, aportando precisión semántica sin añadir complejidad estructural innecesaria.

---

## 5. Integración con el entorno de desarrollo

El diagrama de clases no es únicamente una representación conceptual. En entornos profesionales puede integrarse directamente con el IDE mediante herramientas CASE que permiten generar código, reconstruir diagramas desde código existente y mantener cierta sincronización entre ambos.

Esta integración conecta el diseño estructural con la implementación real.

### 5.1. Generación de código a partir del diagrama

La generación de código consiste en crear automáticamente clases del lenguaje de programación a partir del diagrama UML.

Si se define el siguiente modelo:

```text
+--------------------------+
|          Cliente         |
+--------------------------+
| - nombre: String         |
| - email: String          |
+--------------------------+
| + registrar(): void      |
+--------------------------+
```

Una herramienta CASE puede generar automáticamente una estructura base como:

```java
public class Cliente {

    private String nombre;
    private String email;

    public void registrar() {
        // TODO: implementar
    }
}
```

La generación automática crea la estructura inicial: atributos, constructores básicos y firmas de métodos. Sin embargo, no implementa la lógica interna.

Este enfoque es útil cuando se diseña primero el modelo y después se pasa a implementación.

### 5.2. Ingeniería inversa desde código existente

La ingeniería inversa realiza el proceso contrario: analiza el código fuente y genera automáticamente el diagrama de clases correspondiente.

Si existe una jerarquía como:

```java
public class Empleado extends Persona {
}
```

La herramienta generará una relación de generalización:

```text
Empleado --------|> Persona
```

Este mecanismo resulta especialmente útil para:

- Documentar proyectos existentes.
- Analizar código heredado.
- Detectar dependencias estructurales.
- Revisar diseño en proyectos grandes.

La ingeniería inversa permite visualizar de forma gráfica lo que el código expresa textualmente.

### 5.3. Sincronización modelo–código

Algunas herramientas permiten mantener sincronización bidireccional entre el modelo y el código.

Esto implica que:

- Cambios en el diagrama pueden actualizar el código.
- Cambios en el código pueden reflejarse en el diagrama.

Sin embargo, esta sincronización no siempre es perfecta. En proyectos reales, el modelo suele utilizarse como guía inicial y como documentación estructural, pero el código termina siendo la fuente definitiva de verdad.

Una mala gestión de la sincronización puede provocar inconsistencias entre modelo y sistema real.

### 5.4. Limitaciones y riesgos de la generación automática

La generación automática de código no sustituye el diseño ni el criterio técnico.

Algunas limitaciones importantes son:

- El código generado suele ser estructural y requiere implementación manual.
- No garantiza un buen diseño si el modelo es deficiente.
- Puede generar clases excesivamente rígidas si el modelo está mal planteado.
- No sustituye principios como cohesión, bajo acoplamiento o responsabilidad única.

El riesgo principal es asumir que un diagrama correcto implica automáticamente un buen sistema. El modelo es una herramienta de apoyo, no un sustituto del diseño consciente.

La integración con el entorno de desarrollo debe entenderse como un apoyo técnico, no como un mecanismo automático que garantice calidad.

---

## 6. Análisis crítico y calidad del modelado

El diagrama de clases no debe evaluarse únicamente por su corrección sintáctica. Un modelo puede estar formalmente bien dibujado y, sin embargo, presentar problemas estructurales graves. Analizar la calidad del modelado implica examinar cómo se distribuyen responsabilidades, cómo se relacionan las clases y si el diseño favorece la mantenibilidad del sistema.

### 6.1. Identificación de responsabilidades

Cada clase debe tener una responsabilidad clara y bien delimitada. Una responsabilidad es el conjunto de tareas que justifican la existencia de esa clase dentro del sistema.

Por ejemplo, si una clase `Pedido` contiene lógica de cálculo, validación, generación de informes y acceso a base de datos, probablemente esté asumiendo demasiadas responsabilidades. En un diseño adecuado, estas funciones deberían repartirse entre clases específicas.

Un buen modelo permite responder con claridad a la pregunta:
*¿Cuál es el propósito de esta clase dentro del sistema?*

Si la respuesta es ambigua o demasiado amplia, el diseño necesita revisión.

### 6.2. Cohesión y acoplamiento

La cohesión mide el grado en que los elementos internos de una clase están relacionados entre sí. Una clase con alta cohesión contiene atributos y métodos que trabajan sobre el mismo conjunto lógico de datos.

Por ejemplo, una clase `Factura` cuyos métodos operan todos sobre los atributos `lineas`, `fecha` y `cliente` presenta cohesión adecuada.

El acoplamiento, en cambio, mide el grado de dependencia entre clases. Un modelo con alto acoplamiento presenta muchas relaciones innecesarias o dependencias cruzadas que dificultan el mantenimiento.

Visualmente, un exceso de líneas entre clases puede indicar un diseño demasiado interconectado.

Un modelo equilibrado busca:

- Alta cohesión interna.
- Bajo acoplamiento externo.

### 6.3. Buenas prácticas de diseño estructural

Un diagrama de clases de calidad suele cumplir varias condiciones:

- Cada clase tiene una responsabilidad bien definida.
- Las relaciones están justificadas semánticamente.
- La herencia se utiliza únicamente cuando existe una relación real de tipo *“es un”*.
- Las asociaciones reflejan necesidades estructurales, no simples usos puntuales.
- La multiplicidad está correctamente definida.

El objetivo no es añadir más elementos al modelo, sino representar únicamente lo necesario para describir la estructura del sistema con claridad y precisión.

### 6.4. Errores frecuentes en el modelado

Entre los errores más habituales se encuentran:

- Utilizar herencia donde debería emplearse composición.
- Omitir multiplicidades en las asociaciones.
- Modelar métodos irrelevantes que pertenecen a la implementación y no al diseño estructural.
- Crear clases genéricas con nombres ambiguos como `Gestor`, `Manager` o `Utilidades` sin una responsabilidad clara.
- Confundir dependencia con asociación estructural.

Estos errores no suelen ser sintácticos, sino conceptuales. Por ello, el análisis crítico es fundamental.

### 6.5. Sobre-modelado y sub-modelado

El sobre-modelado ocurre cuando se añaden clases, relaciones o detalles innecesarios que complican el diagrama sin aportar valor estructural. Un diagrama excesivamente detallado puede volverse ilegible y difícil de mantener.

El sub-modelado, por el contrario, consiste en representar el sistema de forma demasiado simplificada, omitiendo relaciones clave o responsabilidades importantes.

Un buen modelo se sitúa en un punto intermedio: suficiente detalle para describir la arquitectura, pero sin caer en complejidad innecesaria.

La calidad del modelado no depende del número de elementos representados, sino de la claridad y coherencia del diseño.

---

## 7. Síntesis estructural de la unidad

El diagrama de clases constituye la representación estructural estática de un sistema orientado a objetos. Su función principal es modelar la arquitectura interna del software antes o después de su implementación, describiendo clases, atributos, métodos y relaciones.

Una clase en UML se compone de:

- Nombre.
- Atributos con tipo y visibilidad.
- Métodos con parámetros y tipo de retorno.

La visibilidad (`+`, `-`, `#`, `~`) permite aplicar el principio de encapsulamiento y controlar el acceso a los elementos internos.

Las relaciones estructurales fundamentales son:

- Asociación: vínculo estable entre clases.
- Dependencia: uso puntual sin almacenamiento permanente.
- Agregación: relación todo–parte débil.
- Composición: relación todo–parte fuerte con dependencia de ciclo de vida.
- Generalización: jerarquía de herencia basada en una relación real de tipo *“es un”*.
- Realización: implementación de una interfaz.

El modelado estructural avanzado incorpora:

- Clases de asociación para relaciones con información propia.
- Paquetes para organización modular.
- Restricciones y notas para enriquecer la semántica del modelo.

La integración con el entorno de desarrollo permite:

- Generar código a partir del diagrama.
- Generar diagramas mediante ingeniería inversa.
- Mantener sincronización parcial entre modelo y código.

Sin embargo, la calidad del sistema no depende de la herramienta, sino del diseño. Un buen modelo presenta:

- Responsabilidades claramente definidas.
- Alta cohesión interna.
- Bajo acoplamiento entre clases.
- Uso justificado de herencia y composición.
- Nivel adecuado de detalle, evitando tanto el sobre-modelado como el sub-modelado.

El diagrama de clases no es un dibujo decorativo, sino una herramienta de ingeniería que formaliza la estructura del sistema y facilita su análisis, mantenimiento y evolución.
