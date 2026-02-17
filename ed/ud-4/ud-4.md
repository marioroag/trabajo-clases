# Unidad Didáctica 4: Código Limpio y Documentación del Software

## Índice

- [Unidad Didáctica 4: Código Limpio y Documentación del Software](#unidad-didáctica-4-código-limpio-y-documentación-del-software)
  - [Índice](#índice)
  - [1. Objetivo de la Unidad](#1-objetivo-de-la-unidad)
  - [2. Introducción al Clean Code](#2-introducción-al-clean-code)
    - [2.1. ¿Qué es Clean Code?](#21-qué-es-clean-code)
    - [2.2. Características Clave](#22-características-clave)
  - [3. Importancia de los Estándares de Nomenclatura](#3-importancia-de-los-estándares-de-nomenclatura)
    - [3.1. Uso de Convenciones de Nomenclatura](#31-uso-de-convenciones-de-nomenclatura)
      - [3.1.1. CamelCase](#311-camelcase)
      - [3.1.2. Aplicaciones de CamelCase y PascalCase](#312-aplicaciones-de-camelcase-y-pascalcase)
      - [3.1.3. Snake Case](#313-snake-case)
      - [3.1.4. Kebab Case](#314-kebab-case)
      - [3.1.5. Elección de la Convención Adecuada](#315-elección-de-la-convención-adecuada)
    - [3.2. Uso de Nombres Descriptivos](#32-uso-de-nombres-descriptivos)
      - [3.2.1. Regla General](#321-regla-general)
      - [3.2.2. Abreviaturas](#322-abreviaturas)
  - [4. Documentación del Software](#4-documentación-del-software)
    - [4.1. Importancia de la Documentación en el Desarrollo de Software](#41-importancia-de-la-documentación-en-el-desarrollo-de-software)
    - [4.2. Beneficios de una Buena Documentación](#42-beneficios-de-una-buena-documentación)
    - [4.3. Tipos de Documentación en un Proyecto de Software](#43-tipos-de-documentación-en-un-proyecto-de-software)
    - [4.4. Herramientas de Documentación de Código](#44-herramientas-de-documentación-de-código)
    - [4.5. Documentación de Código en JavaScript con JSDoc](#45-documentación-de-código-en-javascript-con-jsdoc)
      - [4.5.1. ¿Qué es JSDoc?](#451-qué-es-jsdoc)
      - [4.5.2. Estructura Básica de un Comentario JSDoc](#452-estructura-básica-de-un-comentario-jsdoc)
      - [4.5.3. Etiquetas Principales en JSDoc](#453-etiquetas-principales-en-jsdoc)
        - [4.5.3.1. Etiqueta `@param`](#4531-etiqueta-param)
        - [4.5.3.2. Etiqueta `@returns`](#4532-etiqueta-returns)
        - [4.5.3.3. Etiqueta `@throws`](#4533-etiqueta-throws)
      - [4.5.4. Ejemplo Completo de JSDoc en una Función](#454-ejemplo-completo-de-jsdoc-en-una-función)
      - [4.5.5. Uso de JSDoc en Editores y Herramientas](#455-uso-de-jsdoc-en-editores-y-herramientas)
    - [4.6. Documentación de Código en Java con Javadoc](#46-documentación-de-código-en-java-con-javadoc)
      - [4.6.1. ¿Qué es Javadoc?](#461-qué-es-javadoc)
      - [4.6.2. Estructura Básica de un Comentario Javadoc](#462-estructura-básica-de-un-comentario-javadoc)
      - [4.6.3. Etiquetas Principales en Javadoc](#463-etiquetas-principales-en-javadoc)
        - [4.6.3.1. Etiqueta `@param`](#4631-etiqueta-param)
        - [4.6.3.2. Etiqueta `@return`](#4632-etiqueta-return)
        - [4.6.3.3. Etiqueta `@throws`](#4633-etiqueta-throws)
        - [4.6.3.4. Etiqueta `@author`](#4634-etiqueta-author)
        - [4.6.3.5. Etiqueta `@since`](#4635-etiqueta-since)
        - [4.6.3.6. Etiqueta `{@link}`](#4636-etiqueta-link)
        - [4.6.3.7. Etiqueta `{@linkplain}`](#4637-etiqueta-linkplain)
        - [4.6.3.8. Etiqueta `@see`](#4638-etiqueta-see)
        - [4.6.3.9. Etiqueta `@deprecated`](#4639-etiqueta-deprecated)
        - [4.6.3.10. Etiqueta `{@inheritDoc}`](#46310-etiqueta-inheritdoc)
        - [4.6.3.11. Etiqueta `{@code}`](#46311-etiqueta-code)
        - [4.6.3.12. Etiqueta `@version`](#46312-etiqueta-version)
        - [4.6.3.13. Etiqueta `{@value}`](#46313-etiqueta-value)
        - [4.6.3.14. Etiquetas personalizadas (Custom Tags)](#46314-etiquetas-personalizadas-custom-tags)
      - [4.6.4. Ejemplo Completo de Javadoc en una Clase](#464-ejemplo-completo-de-javadoc-en-una-clase)
      - [4.6.5. Generación de Documentación con Javadoc](#465-generación-de-documentación-con-javadoc)
        - [4.6.5.1. Generación desde la línea de comandos](#4651-generación-desde-la-línea-de-comandos)
          - [Generación básica en entornos Linux / WSL / Git Bash compatible](#generación-básica-en-entornos-linux--wsl--git-bash-compatible)
          - [Generación en Windows PowerShell](#generación-en-windows-powershell)
          - [Buenas prácticas](#buenas-prácticas)
        - [4.6.5.2. Generación desde un IDE](#4652-generación-desde-un-ide)

---

## 1. Objetivo de la Unidad

El propósito de esta unidad es guiar a los estudiantes y desarrolladores en la adopción de prácticas que permitan escribir código limpio, claro y fácil de mantener. La escritura de código limpio no solo mejora la calidad del software, sino que también facilita la colaboración entre equipos, reduce el tiempo de depuración y agiliza la incorporación de nuevos desarrolladores al proyecto.

En el desarrollo de software, un código mal escrito puede derivar en errores difíciles de rastrear, mantenimiento costoso y repetir trabajo innecesariamente. Por ello, aplicar principios de clean code garantiza que el código sea comprensible y funcione de manera eficiente durante todo el ciclo de vida del software.

Además, uno de los aspectos fundamentales que se aborda en esta unidad es la importancia de la nomenclatura adecuada, el uso de convenciones como camelCase, y la creación de documentación precisa utilizando Javadoc. Esto no solo mejora la legibilidad del código, sino que permite a los desarrolladores entender rápidamente el propósito de cada fragmento, facilitando la integración de nuevas funcionalidades o la corrección de errores sin afectar otras partes del sistema.

---

## 2. Introducción al Clean Code

### 2.1. ¿Qué es Clean Code?

Clean Code, o código limpio, se refiere a un conjunto de prácticas y principios que promueven la escritura de código que sea fácil de leer, mantener y mejorar. Es un enfoque que busca reducir la complejidad, evitar duplicidades y fomentar el uso de estructuras claras y coherentes.

El código limpio no solo se centra en que el programa funcione correctamente, sino en que cualquier desarrollador, incluso uno que no haya participado en el desarrollo inicial, pueda comprender y modificar el código con facilidad.

El concepto de Clean Code fue popularizado por Robert C. Martin (conocido como "Uncle Bob") en su libro *Clean Code: A Handbook of Agile Software Craftsmanship*, donde destaca que el código limpio debe ser simple y directo, permitiendo expresar claramente la lógica del programa sin ambigüedades.

Algunas de las características principales del clean code incluyen:

- **Claridad:** Cada línea de código debe reflejar claramente su propósito.
- **Eficiencia:** El código debe ser lo más simple posible sin comprometer la funcionalidad.
- **Estructura:** La organización del código debe facilitar la navegación y modificación.

### 2.2. Características Clave

1. **Legibilidad:**
   - La legibilidad es una de las principales cualidades del clean code. El código debe ser escrito de tal forma que cualquier desarrollador pueda entenderlo sin necesidad de explicaciones adicionales.
   - **Ejemplo:** Prefiera nombres de variables como `totalCost` en lugar de `tc` o `x`.

2. **Simplicidad:**
   - Se debe evitar añadir complejidad innecesaria. Un buen código resuelve el problema de la forma más directa y sencilla posible.
   - **Regla general:** Si una función o método se puede dividir en partes más pequeñas, probablemente debería hacerse.

3. **Consistencia:**
   - Mantener un estilo uniforme en todo el proyecto es crucial para que el código sea fácil de seguir.
   - **Ejemplo:** Si se decide usar camelCase para métodos y PascalCase para clases, esa convención debe mantenerse en todo el código.

4. **Bajo acoplamiento y alta cohesión:**
   - El código debe estar estructurado de manera que cada componente sea independiente (bajo acoplamiento) y que las funcionalidades relacionadas estén agrupadas (alta cohesión).
   - Esto facilita la reusabilidad y la comprensión del sistema.

---

## 3. Importancia de los Estándares de Nomenclatura

El uso de estándares de nomenclatura es un elemento clave en la escritura de código limpio y profesional. Una nomenclatura coherente y bien definida permite comprender la intención del código sin necesidad de comentarios adicionales, facilitando su lectura, mantenimiento y evolución a lo largo del tiempo.

En entornos colaborativos, seguir convenciones comunes reduce errores, evita malentendidos y mejora la integración del trabajo de distintos desarrolladores. Además, muchos lenguajes, frameworks y herramientas imponen o recomiendan convenciones concretas que deben respetarse para garantizar el correcto funcionamiento del proyecto.

### 3.1. Uso de Convenciones de Nomenclatura

Nombrar correctamente variables, métodos, clases, archivos y otros elementos del software es uno de los pilares del clean code. Una buena elección de nombres mejora la legibilidad del código, reduce la complejidad cognitiva y facilita la detección de errores.

No existe una convención única válida para todos los casos. La convención adecuada depende del lenguaje de programación, del tipo de elemento que se esté nombrando y del entorno en el que se desarrolla el proyecto. Un desarrollador profesional debe conocer estas diferencias y aplicarlas de forma consistente.

#### 3.1.1. CamelCase

CamelCase es una convención de nomenclatura en la que las palabras se escriben sin espacios ni separadores, comenzando la primera palabra en minúscula y las siguientes con mayúscula. Su nombre proviene de la similitud visual con las jorobas de un camello.

Ejemplos correctos:

- `calculateInterestRate`
- `userProfileDetails`
- `maxRetryCount`

Ejemplos incorrectos:

- `calculate_interest_rate`
- `userprofiledetails`
- `Calculate_interest_rate`

CamelCase es ampliamente utilizado en lenguajes como Java, JavaScript y C# para mejorar la legibilidad de identificadores compuestos por varias palabras.

#### 3.1.2. Aplicaciones de CamelCase y PascalCase

Variables y métodos:

- Se utiliza camelCase.
- Ejemplo:

```java
int userAge = 25;
double totalOrderAmount = 199.99;

double calculateInterest(double capital) {
    return capital * 0.05;
}
```

Clases e interfaces:

- Se utiliza PascalCase, una variante de CamelCase en la que todas las palabras comienzan con mayúscula.
- En Java, el nombre del archivo debe coincidir exactamente con el nombre de la clase pública.

```java
public class UserAccount {
}

public class PaymentProcessor {
}
```

Nombre correcto de archivo en Java:

```text
UserAccount.java
PaymentProcessor.java
```

Ejemplos incorrectos de nombres de archivo en Java:

```text
user_account.java
user-account.java
useraccount.java
```

#### 3.1.3. Snake Case

Snake case es una convención de nomenclatura en la que las palabras se escriben completamente en minúscula y se separan mediante guiones bajos (`_`). Este formato prioriza la claridad visual cuando los identificadores contienen varias palabras.

Ejemplos de snake case:

- `user_age`
- `total_order_amount`
- `calculate_interest_rate`
- `max_retry_count`

Uso habitual de snake case:

Variables y funciones en Python:

```python
user_age = 30
total_price = 149.99

def calculate_interest_rate(capital, interest_rate):
    return capital * interest_rate
```

Nombres de columnas en bases de datos:

```sql
CREATE TABLE users (
    user_id INT,
    first_name VARCHAR(50),
    last_name VARCHAR(50),
    created_at DATE
);
```

Scripts y configuraciones técnicas:

```text
load_user_data.py
backup_database.sh
max_connection_limit
```

Snake case no es una mala práctica frente a camelCase; es una convención adecuada en determinados lenguajes y entornos, y debe respetarse cuando forma parte de sus estándares.

#### 3.1.4. Kebab Case

Kebab case es una convención de nomenclatura en la que las palabras se escriben en minúscula y se separan mediante guiones medios (`-`). Este formato es especialmente adecuado para entornos donde los espacios no están permitidos o pueden causar problemas.

Ejemplos de kebab case:

- `user-profile`
- `payment-service`
- `asir1-entornos-desarrollo`
- `create-user-account`

Uso habitual de kebab case:

Nombres de archivos y carpetas:

```text
user-profile.component.html
payment-service.config
entornos-desarrollo-docs
```

URLs y rutas web:

```text
https://example.com/user-profile
https://api.example.com/payment-service
```

Repositorios Git:

```text
asir1-entornos-desarrollo
dam2-clean-code-practica
```

Comandos y herramientas de línea de comandos:

```bash
create-user-account
backup-database-prod
```

Kebab case es especialmente relevante en proyectos web y en el uso de Git y GitHub, donde mejora la legibilidad y evita problemas de compatibilidad entre sistemas.

#### 3.1.5. Elección de la Convención Adecuada

Un principio fundamental del código limpio es seleccionar la convención adecuada según el contexto y mantenerla de forma consistente en todo el proyecto.

Buenas prácticas:

- No mezclar convenciones dentro del mismo ámbito.
- Respetar las reglas del lenguaje y del framework utilizado.
- Priorizar la claridad y la coherencia frente a preferencias personales.

La correcta aplicación de las convenciones de nomenclatura es una señal de profesionalidad y una base esencial para el trabajo en equipo.

### 3.2. Uso de Nombres Descriptivos

Los nombres descriptivos ayudan a que el código sea autoexplicativo, reduciendo la necesidad de agregar comentarios adicionales. Un nombre adecuado puede comunicar de inmediato la función de una variable, método o clase.

#### 3.2.1. Regla General

1. Evitar nombres genéricos o de una sola letra (`x`, `y`, `temp`).
2. Utilizar nombres que reflejen la intención detrás del código.

**Ejemplo:**

- En lugar de usar `a` para una lista de usuarios, es preferible `userList`.

#### 3.2.2. Abreviaturas

Las abreviaturas pueden generar confusión, especialmente si no son estándar o ampliamente conocidas. Evitar abreviaturas ambiguas y optar por nombres completos siempre que sea posible.

**Ejemplo:**

- **Incorrecto:** `calcInt` (puede ser calcular interés o entero).
- **Correcto:** `calculateInterest`.

---

## 4. Documentación del Software

### 4.1. Importancia de la Documentación en el Desarrollo de Software

La documentación es una parte esencial del desarrollo de software profesional. Su objetivo principal es explicar el funcionamiento, la estructura y las decisiones tomadas durante el desarrollo de una aplicación, permitiendo que el código pueda ser comprendido, mantenido y ampliado a lo largo del tiempo.

Un proyecto de software rara vez es desarrollado por una sola persona y en un único momento. La documentación permite que otros desarrolladores puedan incorporarse al proyecto, entenderlo rápidamente y trabajar sobre él sin necesidad de interpretar todo el código desde cero. Además, incluso el propio autor del código se beneficia de la documentación cuando retoma un proyecto pasado un tiempo.

En entornos profesionales, la ausencia de documentación incrementa el coste de mantenimiento, dificulta la corrección de errores y aumenta el riesgo de introducir fallos al modificar el código.

### 4.2. Beneficios de una Buena Documentación

Una documentación clara, actualizada y bien estructurada aporta múltiples beneficios a un proyecto de software:

- Facilita la comprensión del código sin necesidad de leer su implementación completa.
- Reduce la dependencia de explicaciones verbales entre desarrolladores.
- Mejora la mantenibilidad y escalabilidad del proyecto.
- Permite detectar errores de diseño o incoherencias en etapas tempranas.
- Ayuda a estandarizar el trabajo dentro de un equipo de desarrollo.
- Sirve como apoyo en procesos de formación, revisión de código y auditorías técnicas.

En el contexto del código limpio, una buena documentación complementa a unos nombres descriptivos y a una estructura clara, evitando comentarios redundantes y centrándose en explicar el propósito y el uso del código.

### 4.3. Tipos de Documentación en un Proyecto de Software

En un proyecto de software pueden coexistir distintos tipos de documentación, cada uno con un propósito concreto:

- Documentación de código:
  - Se integra directamente en el código fuente mediante comentarios estructurados.
  - Describe el comportamiento de funciones, métodos, clases y módulos.
  - Ejemplos: JSDoc en JavaScript, Javadoc en Java.

- Documentación técnica:
  - Explica la arquitectura del sistema, las decisiones de diseño y las dependencias.
  - Suele incluir diagramas, esquemas y descripciones técnicas.

- Documentación de usuario:
  - Está orientada a usuarios finales o perfiles no técnicos.
  - Describe cómo utilizar la aplicación o sus funcionalidades principales.

- Documentación de despliegue y configuración:
  - Detalla cómo instalar, configurar y ejecutar el software en distintos entornos.

### 4.4. Herramientas de Documentación de Código

Las herramientas de documentación de código permiten generar documentación estructurada a partir de comentarios escritos siguiendo un formato estándar dentro del propio código fuente. Estas herramientas facilitan la creación de documentación consistente y evitan duplicar información.

Algunas características comunes de estas herramientas son:

- Uso de etiquetas específicas para describir parámetros, valores de retorno y excepciones.
- Generación automática de documentación en formatos como HTML.
- Integración con editores de código y entornos de desarrollo.

En esta unidad se trabajarán dos herramientas ampliamente utilizadas:

- JSDoc, empleada para documentar código JavaScript.
- Javadoc, utilizada para documentar código Java.

Ambas herramientas siguen principios similares, aunque adaptados a las características de cada lenguaje, y permiten mantener la documentación sincronizada con el código fuente.

### 4.5. Documentación de Código en JavaScript con JSDoc

#### 4.5.1. ¿Qué es JSDoc?

JSDoc es una herramienta de documentación que permite describir el comportamiento y el uso del código JavaScript mediante comentarios estructurados escritos directamente en el propio código fuente. Estos comentarios siguen una sintaxis concreta basada en etiquetas, lo que permite que herramientas automáticas puedan interpretar esa información y generar documentación legible para otros desarrolladores.

El objetivo principal de JSDoc no es explicar cómo funciona internamente una función, sino dejar claro qué hace, qué datos recibe, qué devuelve y en qué condiciones puede fallar. De esta forma, un desarrollador puede entender cómo utilizar una función o un módulo sin necesidad de analizar toda su implementación.

JSDoc es especialmente útil en proyectos JavaScript porque el lenguaje no impone tipos de datos de forma estricta. La documentación ayuda a clarificar qué tipo de valores se esperan y qué comportamiento tiene cada función, mejorando la legibilidad y reduciendo errores.

#### 4.5.2. Estructura Básica de un Comentario JSDoc

Un comentario JSDoc se escribe utilizando una sintaxis especial de comentario multilínea que comienza con `/**` y finaliza con `*/`. Este tipo de comentario se coloca inmediatamente antes del elemento que se desea documentar, como una función, un método o una clase.

Dentro del comentario se incluye una descripción general y, a continuación, una serie de etiquetas que aportan información más detallada sobre los parámetros, el valor de retorno u otros aspectos relevantes.

Ejemplo básico de comentario JSDoc aplicado a una función:

```javascript
/**
 * Calcula el precio final de un producto aplicando un porcentaje de descuento.
 *
 * @param {number} price Precio original del producto.
 * @param {number} discount Porcentaje de descuento a aplicar.
 * @returns {number} Precio final tras aplicar el descuento.
 */
function calculateFinalPrice(price, discount) {
    return price - (price * discount / 100);
}
```

En este ejemplo, la descripción inicial explica de forma clara la finalidad de la función. Las etiquetas `@param` indican los parámetros que recibe, especificando su tipo y significado, mientras que `@returns` describe el valor que devuelve. Gracias a esta estructura, cualquier desarrollador puede entender rápidamente cómo usar la función sin necesidad de inspeccionar su código interno.

#### 4.5.3. Etiquetas Principales en JSDoc

Las etiquetas de JSDoc permiten describir de forma precisa los distintos elementos que intervienen en una función o método. Mediante estas etiquetas se especifican los parámetros de entrada, el valor de retorno y las posibles situaciones de error, aportando información clave para el uso correcto del código.

A continuación se describen algunas de las etiquetas más utilizadas en JSDoc.

##### 4.5.3.1. Etiqueta `@param`

La etiqueta `@param` se utiliza para documentar cada uno de los parámetros que recibe una función. En ella se indica el tipo de dato esperado y una breve descripción del propósito del parámetro.

Documentar correctamente los parámetros es especialmente importante en JavaScript, ya que el lenguaje no obliga a declarar tipos de forma explícita. La documentación ayuda a evitar errores y malentendidos sobre qué valores son válidos.

Ejemplo con varios parámetros:

```javascript
/**
 * Registra un nuevo usuario en el sistema.
 *
 * @param {string} username Nombre de usuario.
 * @param {string} email Dirección de correo electrónico.
 * @param {number} age Edad del usuario.
 */
function registerUser(username, email, age) {
    // Implementación
}
```

También es posible indicar parámetros opcionales o con valores por defecto:

```javascript
/**
 * Muestra un mensaje en consola.
 *
 * @param {string} message Texto a mostrar.
 * @param {string} [type="info"] Tipo de mensaje.
 */
function logMessage(message, type = "info") {
    console.log(`[${type}] ${message}`);
}
```

##### 4.5.3.2. Etiqueta `@returns`

La etiqueta `@returns` se utiliza para documentar el valor que devuelve una función. En ella se indica el tipo de dato retornado y una descripción clara de lo que representa dicho valor.

Esta etiqueta resulta especialmente útil cuando el valor de retorno no es evidente a simple vista o cuando la función puede devolver distintos tipos de resultados.

Ejemplo de función que devuelve un valor numérico:

```javascript
/**
 * Calcula el área de un rectángulo.
 *
 * @param {number} width Ancho del rectángulo.
 * @param {number} height Alto del rectángulo.
 * @returns {number} Área total del rectángulo.
 */
function calculateArea(width, height) {
    return width * height;
}
```

Ejemplo de función que devuelve un objeto:

```javascript
/**
 * Crea un objeto con la información del usuario.
 *
 * @param {string} name Nombre del usuario.
 * @param {string} role Rol asignado.
 * @returns {Object} Objeto con los datos del usuario.
 */
function createUser(name, role) {
    return {
        name,
        role
    };
}
```

##### 4.5.3.3. Etiqueta `@throws`

La etiqueta `@throws` se utiliza para documentar las excepciones o errores que una función puede lanzar en determinadas circunstancias. Indicar estos casos permite a otros desarrolladores saber cuándo deben gestionar errores y qué situaciones deben evitar.

Aunque JavaScript no obliga a declarar las excepciones, documentarlas mejora la robustez y el uso correcto del código.

Ejemplo de uso de `@throws`:

```javascript
/**
 * Divide dos números.
 *
 * @param {number} dividend Número a dividir.
 * @param {number} divisor Número por el cual se divide.
 * @returns {number} Resultado de la división.
 * @throws {Error} Se lanza si el divisor es cero.
 */
function divide(dividend, divisor) {
    if (divisor === 0) {
        throw new Error("No se puede dividir entre cero");
    }
    return dividend / divisor;
}
```

Documentar las excepciones ayuda a que el comportamiento de la función sea predecible y a que el código que la utiliza pueda manejar correctamente las situaciones de error.

#### 4.5.4. Ejemplo Completo de JSDoc en una Función

Un ejemplo completo de JSDoc combina una descripción clara de la función con el uso adecuado de las etiquetas principales. El objetivo es que cualquier desarrollador pueda entender qué hace la función, cómo utilizarla y qué resultados esperar, sin necesidad de analizar su implementación interna.

Ejemplo de función documentada con JSDoc:

```javascript
/**
 * Calcula el precio final de un pedido aplicando impuestos y descuentos.
 *
 * La función recibe el precio base del pedido, un porcentaje de descuento
 * opcional y un porcentaje de impuesto, y devuelve el precio final calculado.
 *
 * @param {number} basePrice Precio base del pedido.
 * @param {number} taxRate Porcentaje de impuestos a aplicar.
 * @param {number} [discount=0] Porcentaje de descuento opcional.
 * @returns {number} Precio final del pedido.
 * @throws {Error} Se lanza si alguno de los valores es negativo.
 */
function calculateFinalOrderPrice(basePrice, taxRate, discount = 0) {
    if (basePrice < 0 || taxRate < 0 || discount < 0) {
        throw new Error("Los valores no pueden ser negativos");
    }

    const discountedPrice = basePrice - (basePrice * discount / 100);
    return discountedPrice + (discountedPrice * taxRate / 100);
}
```

En este ejemplo, la descripción inicial explica el propósito general de la función. Las etiquetas permiten conocer los parámetros obligatorios y opcionales, el valor de retorno y las posibles excepciones. Esta información es suficiente para utilizar correctamente la función sin necesidad de revisar su código.

#### 4.5.5. Uso de JSDoc en Editores y Herramientas

JSDoc se integra de forma natural con muchos editores de código y herramientas de desarrollo modernas. Al escribir comentarios JSDoc correctamente, los editores pueden mostrar información contextual que ayuda durante la programación.

En editores como Visual Studio Code, los comentarios JSDoc permiten:

- Mostrar información emergente sobre funciones y parámetros al pasar el cursor.
- Sugerir automáticamente los parámetros y tipos esperados al llamar a una función.
- Mejorar la autocompletación y la detección de errores.

Además, existen herramientas que permiten generar documentación HTML a partir de los comentarios JSDoc, facilitando la creación de documentación externa para proyectos más grandes. Estas herramientas analizan el código fuente, interpretan las etiquetas y generan páginas navegables que describen las funciones, clases y módulos del proyecto.

El uso de JSDoc, combinado con editores y herramientas adecuadas, contribuye a un desarrollo más ordenado, reduce errores y mejora la experiencia de trabajo en proyectos JavaScript.

### 4.6. Documentación de Código en Java con Javadoc

#### 4.6.1. ¿Qué es Javadoc?

Javadoc es la herramienta estándar del lenguaje Java para documentar código fuente de forma estructurada. Permite describir clases, métodos, constructores y atributos mediante comentarios especiales que pueden ser interpretados automáticamente para generar documentación en formato HTML.

A diferencia de los comentarios normales, los comentarios Javadoc están pensados para ser leídos tanto por desarrolladores como por herramientas automáticas. Su finalidad principal no es explicar cómo funciona internamente el código, sino cómo debe utilizarse: qué responsabilidad tiene una clase, qué hace un método, qué parámetros recibe, qué devuelve y en qué situaciones puede producir errores.

Javadoc forma parte del ecosistema oficial de Java y es ampliamente utilizado en proyectos profesionales, librerías y APIs públicas. En muchos contextos industriales, el uso de Javadoc no es opcional, sino un requisito de calidad. Documentar correctamente con Javadoc facilita el mantenimiento del software, mejora la colaboración en equipo y reduce el tiempo necesario para que otros desarrolladores comprendan y utilicen el código sin necesidad de analizar su implementación interna.

#### 4.6.2. Estructura Básica de un Comentario Javadoc

Un comentario Javadoc se escribe utilizando un comentario multilínea que comienza con `/**` y finaliza con `*/`. Este tipo de comentario se coloca inmediatamente antes del elemento que se desea documentar, como una clase, un método, un constructor o, en casos concretos, un atributo.

La estructura básica de un comentario Javadoc incluye:

- Una descripción breve inicial que resume el propósito del elemento.
- Opcionalmente, una descripción más detallada en uno o varios párrafos.
- Un conjunto de etiquetas que documentan parámetros, valores de retorno y excepciones.

Javadoc permite el uso de etiquetas HTML simples dentro de Javadoc como `<p>`, `<ul>` o `<code>`, que mejoran la legibilidad de la documentación generada.

Ejemplo de comentario Javadoc aplicado a un método:

```java
/**
 * Calcula el interés simple a partir de un capital y una tasa de interés.
 *
 * <p>Este método aplica la fórmula del interés simple utilizando el capital
 * inicial, la tasa de interés anual y el tiempo expresado en años.</p>
 *
 * @param principal Cantidad inicial sobre la que se aplica el interés.
 * @param rate Tasa de interés anual expresada como decimal.
 * @param time Tiempo en años.
 * @return El interés simple calculado.
 */
public double calculateInterest(double principal, double rate, int time) {
    return principal * rate * time;
}
```

En este ejemplo, la primera línea proporciona una descripción clara y concisa del método. El párrafo adicional amplía la explicación utilizando `<p>`, y las etiquetas permiten especificar con precisión el significado de cada parámetro y del valor devuelto.

Los comentarios Javadoc también pueden utilizarse para documentar clases completas y, cuando sea relevante, atributos, ofreciendo una visión general de la responsabilidad de cada elemento dentro del sistema y de cómo debe ser utilizado.

#### 4.6.3. Etiquetas Principales en Javadoc

Las etiquetas de Javadoc permiten describir de forma precisa cómo debe utilizarse una **clase** o un **método**. A través de estas etiquetas se documentan los parámetros de entrada, el valor que devuelve un método y las posibles excepciones que pueden producirse durante su ejecución.

El uso correcto de estas etiquetas es fundamental para que la documentación generada sea clara, útil y coherente con el comportamiento real del código.

##### 4.6.3.1. Etiqueta `@param`

La etiqueta `@param` se utiliza para documentar cada uno de los parámetros que recibe un método o constructor. En ella se indica el nombre del parámetro y una descripción clara de su propósito.

Documentar los parámetros es especialmente importante en métodos con varios argumentos o cuando el significado de un parámetro no es evidente a partir de su nombre.

Ejemplo de uso de `@param` en un método con varios parámetros:

```java
/**
 * Crea un nuevo usuario en el sistema.
 *
 * @param username Nombre de usuario único.
 * @param email Dirección de correo electrónico del usuario.
 * @param age Edad del usuario.
 */
public void createUser(String username, String email, int age) {
    // Implementación
}
```

Ejemplo en un constructor:

```java
/**
 * Construye una cuenta bancaria con un saldo inicial.
 *
 * @param accountNumber Número identificador de la cuenta.
 * @param initialBalance Saldo inicial de la cuenta.
 */
public BankAccount(String accountNumber, double initialBalance) {
    this.accountNumber = accountNumber;
    this.balance = initialBalance;
}
```

##### 4.6.3.2. Etiqueta `@return`

La etiqueta `@return` se utiliza para documentar el valor que devuelve un método. En ella se describe qué representa el valor retornado y, cuando es necesario, bajo qué condiciones se produce.

Esta etiqueta solo debe utilizarse en métodos que devuelven un valor. En métodos `void` no se emplea.

Ejemplo de uso de `@return` en un método que devuelve un valor simple:

```java
/**
 * Obtiene el saldo actual de la cuenta.
 *
 * @return El saldo disponible.
 */
public double getBalance() {
    return balance;
}
```

Ejemplo de método que devuelve un objeto:

```java
/**
 * Genera un resumen de la cuenta bancaria.
 *
 * @return Un objeto con la información resumida de la cuenta.
 */
public AccountSummary getAccountSummary() {
    return new AccountSummary(accountNumber, balance);
}
```

##### 4.6.3.3. Etiqueta `@throws`

La etiqueta `@throws` se utiliza para documentar las excepciones que un método puede lanzar durante su ejecución. En ella se indica el tipo de excepción y una descripción de la situación que provoca el error.

Documentar las excepciones permite a otros desarrolladores saber qué errores deben gestionar cuando utilizan el método y en qué condiciones pueden producirse.

Ejemplo de uso de `@throws` en un método que valida datos:

```java
/**
 * Retira una cantidad de dinero de la cuenta.
 *
 * @param amount Cantidad a retirar.
 * @throws IllegalArgumentException Si la cantidad es negativa.
 * @throws IllegalStateException Si el saldo es insuficiente.
 */
public void withdraw(double amount) {
    if (amount < 0) {
        throw new IllegalArgumentException("La cantidad no puede ser negativa");
    }
    if (amount > balance) {
        throw new IllegalStateException("Saldo insuficiente");
    }
    balance -= amount;
}
```

##### 4.6.3.4. Etiqueta `@author`

Indica la autoría de una clase o interfaz. Es habitual incluirla en la documentación a nivel de clase.

```java
/**
 * Clase que representa una cuenta bancaria.
 *
 * @author Luis Miguel
 */
public class CuentaBancaria {
}
```

##### 4.6.3.5. Etiqueta `@since`

Permite indicar desde qué versión existe una clase o método.

```java
/**
 * @since 1.0
 */
public class Calculadora {
}
```

##### 4.6.3.6. Etiqueta `{@link}`

Inserta un enlace a otra clase o método dentro del texto de la documentación.
Si se usa `Clase#metodo`, el enlace apunta directamente a ese método.

```java
/**
 * Véase {@link CuentaBancaria#getSaldo()}.
 */
```

##### 4.6.3.7. Etiqueta `{@linkplain}`

Funciona igual que `{@link}`, pero el texto se muestra sin formato de código.

```java
/**
 * Consultar la clase {@linkplain Cliente}.
 */
```

##### 4.6.3.8. Etiqueta `@see`

Añade una sección de referencias relacionadas al final de la documentación.

```java
/**
 * @see CuentaBancaria
 * @see Cliente
 */
```

##### 4.6.3.9. Etiqueta `@deprecated`

Marca un método o clase como obsoleto e indica qué debe usarse en su lugar.

```java
/**
 * @deprecated usar {@link #retirar(double)}.
 */
public void sacar(double cantidad) {
}
```

##### 4.6.3.10. Etiqueta `{@inheritDoc}`

Hereda automáticamente la documentación de la superclase o interfaz.

```java
/**
 * {@inheritDoc}
 */
@Override
public double getSaldo() {
    return saldo;
}
```

##### 4.6.3.11. Etiqueta `{@code}`

Muestra fragmentos como código dentro del texto descriptivo.

```java
/**
 * Devuelve {@code true} si la cuenta está activa.
 */
```

##### 4.6.3.12. Etiqueta `@version`

Indica la versión actual del componente.

```java
/**
 * @version 2.1
 */
public class PedidoService {
}
```

##### 4.6.3.13. Etiqueta `{@value}`

Muestra el valor de una constante documentada.

```java
public static final int MAX_INTENTOS = 3;

/**
 * Número máximo de intentos: {@value}.
 */
```

##### 4.6.3.14. Etiquetas personalizadas (Custom Tags)

Javadoc permite definir etiquetas propias del proyecto cuando se genera la documentación.

Para crear una etiqueta llamada `@location`:

```bash
javadoc -tag location:a:"Notable Locations:" -d doc src/*
```

La opción `-tag` sigue el formato:

```bash
-tag nombre:ubicación:encabezado
```

Donde:

- `location` es el nombre que se usará en el código (`@location`).
- `a` indica que se permite en cualquier elemento.
  También pueden usarse:

  - `p` para paquetes.
  - `t` para tipos.
  - `m` para métodos.
  - `f` para campos.
  - `c` para constructores.
- `"Notable Locations:"` es el título que aparecerá en la documentación HTML.

En lugar de verse:

```java
@location New York
```

En la documentación se mostrará:

```text
Notable Locations:
New York
```

Ejemplo de uso:

```java
/**
 * @location New York
 * @return resultado de la operación
 */
```

Cuando se utilizan etiquetas personalizadas desde línea de comandos, es obligatorio incluir siempre la opción `-tag` en cada ejecución:

```bash
javadoc -d doc src/* -tag location:a:"Notable Locations:"
```

Esto se debe a que Javadoc **no recuerda** estas definiciones entre ejecuciones.

En proyectos Maven, estas etiquetas pueden configurarse en el `pom.xml` para que se apliquen automáticamente:

```xml
<tags>
    <tag>
        <name>location</name>
        <placement>a</placement>
        <head>Notable Places:</head>
    </tag>
</tags>
```

#### 4.6.4. Ejemplo Completo de Javadoc en una Clase

Un ejemplo completo de Javadoc a nivel de clase permite comprender de forma global la responsabilidad de la clase y el comportamiento de sus métodos públicos. La documentación debe centrarse en explicar qué representa la clase, qué funcionalidades ofrece y cómo deben utilizarse sus métodos.

A continuación se muestra un ejemplo de una clase documentada con Javadoc que gestiona una cuenta bancaria sencilla:

```java
/**
 * Representa una cuenta bancaria con operaciones básicas.
 *
 * <p>Esta clase permite realizar ingresos y retiradas de dinero,
 * así como consultar el saldo actual de la cuenta. Está pensada
 * para ser utilizada como parte de un sistema de gestión bancaria.</p>
 */
public class BankAccount {

    private double balance;

    /**
     * Crea una cuenta bancaria con un saldo inicial.
     *
     * @param initialBalance Saldo inicial de la cuenta.
     * @throws IllegalArgumentException Si el saldo inicial es negativo.
     */
    public BankAccount(double initialBalance) {
        if (initialBalance < 0) {
            throw new IllegalArgumentException("El saldo inicial no puede ser negativo");
        }
        this.balance = initialBalance;
    }

    /**
     * Deposita una cantidad de dinero en la cuenta.
     *
     * @param amount Cantidad a depositar.
     * @throws IllegalArgumentException Si la cantidad es negativa.
     */
    public void deposit(double amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("La cantidad no puede ser negativa");
        }
        balance += amount;
    }

    /**
     * Retira una cantidad de dinero de la cuenta.
     *
     * @param amount Cantidad a retirar.
     * @throws IllegalArgumentException Si la cantidad es negativa.
     * @throws IllegalStateException Si el saldo es insuficiente.
     */
    public void withdraw(double amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("La cantidad no puede ser negativa");
        }
        if (amount > balance) {
            throw new IllegalStateException("Saldo insuficiente");
        }
        balance -= amount;
    }

    /**
     * Devuelve el saldo actual de la cuenta.
     *
     * @return El saldo disponible.
     */
    public double getBalance() {
        return balance;
    }
}
```

En este ejemplo, la documentación a nivel de clase describe su propósito general y su contexto de uso. Cada método público está documentado indicando claramente sus parámetros, su comportamiento y las posibles excepciones que puede lanzar. De esta forma, la clase puede ser utilizada correctamente sin necesidad de revisar su implementación interna.

#### 4.6.5. Generación de Documentación con Javadoc

Una de las principales ventajas de Javadoc es la posibilidad de generar documentación automática en formato HTML a partir de los comentarios escritos en el código fuente. Esta documentación puede consultarse desde un navegador y resulta especialmente útil en proyectos medianos y grandes, donde es necesario disponer de una referencia clara de las clases y métodos disponibles.

La generación de documentación puede realizarse tanto desde la línea de comandos como directamente desde un entorno de desarrollo integrado (IDE).

##### 4.6.5.1. Generación desde la línea de comandos

Java incluye de forma nativa la herramienta `javadoc`, que permite generar documentación HTML a partir de los comentarios presentes en el código fuente.

La generación debe realizarse **desde la raíz del proyecto**, es decir, desde la carpeta que contiene el directorio `src/`.

Esta forma de generación es válida tanto para proyectos simples como para proyectos con estructura Maven, siempre que no existan dependencias externas que requieran configuración adicional.

En un proyecto Java estándar con estructura Maven, la organización habitual es:

```text
ProyectoJava/
│
├── src/
│   └── main/
│       └── java/
│           └── es/
│               └── empresa/
│                   └── proyecto/
│                       └── Clase.java
│
└── docs/
```

La carpeta `docs/` **no existe inicialmente** y será creada automáticamente por la herramienta al generar la documentación.

###### Generación básica en entornos Linux / WSL / Git Bash compatible

Desde la raíz del proyecto, se puede ejecutar:

```bash
javadoc -d docs src/main/java/**/*.java
```

Este comando:

- Ejecuta la herramienta `javadoc`.
-Indica con `-d docs` que la documentación se guardará en la carpeta `docs/`, situada en la raíz del proyecto.
- Procesa recursivamente todos los archivos `.java` del proyecto.

Tras la ejecución se generará:

```text
ProyectoJava/
└── docs/
    ├── index.html
    └── es/
```

El archivo `index.html` es el punto de entrada principal para navegar por la documentación.

###### Generación en Windows PowerShell

En PowerShell, el patrón `**/*.java` no siempre se interpreta correctamente.
En ese caso debe usarse una búsqueda explícita:

```powershell
javadoc -d docs (Get-ChildItem -Recurse -Filter *.java src\main\java).FullName
```

Este comando localiza todos los archivos Java y los pasa a `javadoc` para su procesamiento.

###### Buenas prácticas

- Ejecutar siempre los comandos desde la raíz del proyecto.
- No modificar manualmente los archivos dentro de `docs/`.
- No versionar la carpeta `docs/` en Git salvo indicación expresa.
- Revisar los mensajes y advertencias mostrados por la herramienta.
- Abrir siempre `docs/index.html` para comprobar el resultado final.

##### 4.6.5.2. Generación desde un IDE

La mayoría de los entornos de desarrollo integrados para Java permiten generar documentación Javadoc de forma gráfica, sin necesidad de utilizar la línea de comandos. Esta opción resulta especialmente cómoda para proyectos educativos y para desarrolladores que se están iniciando en Java.

En general, el proceso consiste en:

- Seleccionar el proyecto o los paquetes que se desean documentar.
- Acceder a la opción de generación de Javadoc desde el menú del IDE.
- Indicar el directorio de salida para la documentación.
- Ejecutar el proceso de generación.

IDEs como IntelliJ IDEA, Eclipse o NetBeans reconocen automáticamente los comentarios Javadoc y generan la documentación HTML correspondiente. Además, estos entornos suelen ofrecer validación y sugerencias mientras se escriben los comentarios, ayudando a mantener una documentación correcta y completa.

La generación de documentación desde el IDE facilita integrar la documentación como parte del flujo de trabajo habitual, fomentando la creación de proyectos bien documentados desde las primeras fases de desarrollo.
