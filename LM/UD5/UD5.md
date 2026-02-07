# Unidad Didáctica 5: JavaScript y Manipulación del DOM  

## 1. Introducción a JavaScript  

JavaScript es un lenguaje de programación de alto nivel, interpretado y orientado a objetos, utilizado principalmente para dotar de interactividad y dinamismo a las páginas web. Es uno de los pilares fundamentales del desarrollo web moderno, complementando a HTML (HyperText Markup Language) y CSS (Cascading Style Sheets), que se encargan de la estructura y el diseño, respectivamente.  

Con JavaScript, los desarrolladores pueden modificar el contenido de una página después de que esta haya sido cargada, responder a las acciones del usuario (como clics, desplazamientos o escritura), validar formularios, crear animaciones y realizar solicitudes a servidores sin necesidad de recargar la página completa (técnica conocida como AJAX).  

Una de las características clave de JavaScript es que **se ejecuta del lado del cliente**, es decir, directamente en el navegador web del usuario. Esto significa que las acciones y modificaciones pueden realizarse de forma inmediata, sin depender de la comunicación constante con el servidor, lo que resulta en aplicaciones más rápidas y responsivas.  

Además, JavaScript es un lenguaje **multiplataforma y versátil**. Aunque su uso más común está en el desarrollo web, también se emplea en una variedad de entornos, como el desarrollo de aplicaciones móviles (mediante frameworks como React Native), aplicaciones de escritorio y programación de servidores (gracias a tecnologías como Node.js).  

En resumen, JavaScript es fundamental para crear experiencias de usuario dinámicas y ricas, permitiendo que las páginas web pasen de ser documentos estáticos a interfaces interactivas que se comportan como aplicaciones de escritorio o móviles.  

---

## 2. El DOM (Document Object Model)  

El **DOM (Document Object Model)** es una interfaz de programación que representa la estructura de un documento HTML o XML como un **árbol de nodos jerárquico**. Cada elemento de la página web, desde las etiquetas `<html>`, `<body>`, `<div>`, hasta los atributos y fragmentos de texto, se convierten en nodos que JavaScript puede manipular.  

El DOM actúa como un puente entre JavaScript y el contenido de la página web, permitiendo que los desarrolladores accedan y modifiquen la estructura, el estilo y el contenido de los documentos de forma dinámica. Esto significa que, mediante JavaScript, se pueden:  
- **Modificar el contenido de los elementos** (por ejemplo, cambiar el texto de un párrafo o el valor de un campo de formulario).  
- **Cambiar la apariencia visual de los elementos** alterando estilos CSS.  
- **Añadir o eliminar elementos** (como botones, imágenes o secciones completas).  
- **Responder a eventos del usuario** (como clics, movimientos del mouse o pulsaciones de teclado).  

### Estructura Jerárquica del DOM  
El DOM organiza el contenido de la página en una estructura de árbol donde:  
- **El nodo raíz es el documento** (`document`), que representa toda la página.  
- **Las etiquetas HTML** (`<html>`, `<head>`, `<body>`) son nodos hijos del documento.  
- **Cada etiqueta anidada dentro de otra** (como un `<div>` dentro de `<body>`) se convierte en un nodo hijo de su nodo padre correspondiente.  

Por ejemplo, el siguiente fragmento HTML:  
```html
<!DOCTYPE html>
<html>
  <head>
    <title>Mi página</title>
  </head>
  <body>
    <h1 id="titulo">Bienvenidos</h1>
    <p class="descripcion">Este es un párrafo de ejemplo</p>
  </body>
</html>
```  
Se representa en el DOM como:  
```
document
 └── html
      ├── head
      │    └── title (Mi página)
      └── body
           ├── h1 (Bienvenidos)
           └── p (Este es un párrafo de ejemplo)
```  

### Manipulación del DOM con JavaScript  
El DOM no es solo una representación estática del documento; puede ser modificado en tiempo real usando JavaScript. A través de métodos y propiedades, los desarrolladores pueden acceder a cualquier nodo del árbol y realizar cambios inmediatos.  

Por ejemplo, para cambiar el texto del encabezado `<h1>`, se puede utilizar:  
```javascript
const encabezado = document.getElementById("titulo")
encabezado.textContent = "Hola Mundo"
```  

De forma similar, para añadir un nuevo párrafo al cuerpo del documento:  
```javascript
const nuevoParrafo = document.createElement("p")
nuevoParrafo.textContent = "Este es un párrafo añadido dinámicamente"
document.body.appendChild(nuevoParrafo)
```  

El DOM proporciona una flexibilidad enorme, permitiendo que los sitios web no solo muestren información estática, sino que respondan y evolucionen en función de la interacción del usuario, ofreciendo experiencias web dinámicas y modernas.

---

## 3. Selección de Elementos del DOM  

La selección de elementos del DOM es el primer paso para manipular y modificar el contenido de una página web utilizando JavaScript. Al seleccionar un elemento, se obtiene acceso a su estructura, atributos, contenido y estilos, lo que permite realizar cambios dinámicos y responder a las interacciones del usuario.  

JavaScript ofrece varios métodos para seleccionar elementos, ya sea por su ID, clase, etiqueta o mediante selectores CSS. Estos métodos proporcionan flexibilidad y precisión para apuntar a elementos específicos o a grupos de elementos que comparten ciertas características.  

---

### 3.1. Selección por ID  

El método `getElementById` permite seleccionar un elemento HTML que tiene un atributo `id` específico. Dado que los `id` deben ser únicos en el documento, este método siempre devolverá un solo elemento.  

```javascript
const encabezado = document.getElementById("titulo")
```  

**Ejemplo en HTML:**  
```html
<h1 id="titulo">Bienvenidos</h1>
```  

Este método es rápido y eficiente, ya que `getElementById` accede directamente al elemento sin necesidad de recorrer todo el DOM. Es ideal para elementos que se manipulan con frecuencia o que necesitan identificarse de forma exclusiva (como formularios, encabezados principales o secciones clave).  

---

### 3.2. Selección por clase  

El método `getElementsByClassName` selecciona todos los elementos que tienen un atributo `class` con el valor especificado. Devuelve una **colección HTML (HTMLCollection)**, que es similar a un array, pero no tiene todos sus métodos.  

```javascript
const botones = document.getElementsByClassName("boton")
```  

**Ejemplo en HTML:**  
```html
<button class="boton">Enviar</button>
<button class="boton">Cancelar</button>
```  

Aunque `getElementsByClassName` devuelve una colección de elementos, estos no se actualizan automáticamente si el DOM cambia después de la selección. Para interactuar con cada elemento, se puede iterar sobre la colección usando un bucle:  

```javascript
for (const boton of botones) {
    boton.style.backgroundColor = "red"
}
```  

---

### 3.3. Selección por etiqueta  

El método `getElementsByTagName` selecciona todos los elementos que coinciden con una etiqueta HTML específica (como `div`, `p`, `a`). Devuelve una **colección HTML** similar a `getElementsByClassName`.  

```javascript
const parrafos = document.getElementsByTagName("p")
```  

**Ejemplo en HTML:**  
```html
<p>Primer párrafo</p>
<p>Segundo párrafo</p>
```  

Este método es útil cuando se necesita manipular elementos en bloque, como listas, párrafos o imágenes. Se pueden aplicar cambios iterando sobre cada elemento:  

```javascript
for (const parrafo of parrafos) {
    parrafo.style.color = "blue"
}
```  

---

### 3.4. Selección por selectores CSS  

Los métodos `querySelector` y `querySelectorAll` permiten seleccionar elementos utilizando selectores CSS, lo que los hace muy versátiles y potentes.  

- **`querySelector`** selecciona el **primer elemento** que coincide con el selector.  
- **`querySelectorAll`** selecciona **todos los elementos** que coinciden con el selector y devuelve una **NodeList** (similar a un array).  

```javascript
const primerBoton = document.querySelector(".boton")
const todosLosBotones = document.querySelectorAll(".boton")
```  

**Ejemplo en HTML:**  
```html
<button class="boton">Aceptar</button>
<button class="boton">Rechazar</button>
```  

La ventaja de estos métodos es que permiten usar selectores complejos, como:  
```javascript
const enlaceActivo = document.querySelector("nav a.activo")
const celdas = document.querySelectorAll("table td")
```  

Para iterar sobre los elementos de `querySelectorAll`:  
```javascript
todosLosBotones.forEach(boton => {
    boton.textContent = "Modificado"
})
```  

---

## 4. Modificación de Elementos del DOM  

Una vez que se seleccionan los elementos del DOM, se pueden modificar para cambiar su contenido, sus atributos o sus estilos. JavaScript proporciona métodos y propiedades que permiten realizar estos cambios de forma dinámica y en respuesta a las acciones del usuario.  

---

### 4.1. Modificar texto  

Modificar el contenido de un elemento es una de las operaciones más comunes. Se puede hacer usando:  

- **`textContent`**: Modifica o devuelve el texto de un elemento, ignorando cualquier etiqueta HTML.  
- **`innerHTML`**: Permite establecer o devolver el contenido HTML del elemento, lo que significa que puede interpretar etiquetas y renderizarlas.  

```javascript
const parrafo = document.getElementById("descripcion")
parrafo.textContent = "Nuevo texto modificado"
parrafo.innerHTML = "<strong>Texto en negrita</strong>"
```  

**Diferencias clave:**  
- `textContent` es más seguro si se desea evitar la inyección de código malicioso, ya que no interpreta HTML.  
- `innerHTML` permite insertar etiquetas HTML directamente en el documento, pero debe usarse con precaución.  

**Ejemplo en HTML:**  
```html
<p id="descripcion">Texto original</p>
```  

---

### 4.2. Cambiar atributos  

Con JavaScript, es posible modificar los atributos de cualquier elemento HTML utilizando el método `setAttribute`. También se pueden obtener o eliminar atributos con `getAttribute` y `removeAttribute`.  

```javascript
const imagen = document.querySelector("img")
imagen.setAttribute("src", "nueva-imagen.jpg")
imagen.setAttribute("alt", "Descripción de la imagen")
```  

**Ejemplo en HTML:**  
```html
<img src="imagen-antigua.jpg" alt="Imagen anterior">
```  

Si el atributo no existe, `setAttribute` lo crea automáticamente. Para eliminar un atributo:  
```javascript
imagen.removeAttribute("alt")
```  

---

### 4.3. Modificar estilos  

JavaScript permite modificar los estilos CSS directamente a través de la propiedad `style`. Esta propiedad accede a los estilos en línea (atributos `style` dentro de las etiquetas HTML).  

```javascript
const seccion = document.querySelector(".contenedor")
seccion.style.backgroundColor = "blue"
seccion.style.fontSize = "18px"
```  

**Ejemplo en HTML:**  
```html
<div class="contenedor">Sección de ejemplo</div>
```  

Sin embargo, modificar muchos estilos directamente puede llevar a un código difícil de mantener. Es preferible añadir o eliminar clases usando `classList`:  

```javascript
seccion.classList.add("resaltado")
seccion.classList.remove("contenedor")
```  

Estos métodos permiten mantener el CSS organizado, delegando el control de los estilos a hojas de estilo externas.

---

## 5. Creación y Eliminación de Elementos  

La capacidad de crear y eliminar elementos dinámicamente en el DOM es esencial para construir aplicaciones web interactivas. JavaScript permite manipular la estructura de una página en tiempo real, lo que facilita la generación de contenido nuevo o la eliminación de elementos innecesarios en respuesta a las acciones del usuario.  

Esto es útil para funcionalidades como agregar comentarios, crear listas de tareas, mostrar mensajes de error o notificaciones, y cualquier otra acción que requiera modificar la interfaz sin recargar la página.  

---

### 5.1. Crear nuevos elementos  

JavaScript permite crear elementos HTML directamente desde el DOM utilizando el método `document.createElement()`. Este método genera un nuevo nodo de elemento vacío, que luego puede personalizarse añadiendo contenido, atributos y clases antes de insertarlo en el documento.  

---

#### 5.1.1. Crear un elemento  

Para crear un nuevo elemento, se invoca `document.createElement()` con la etiqueta HTML deseada. Posteriormente, se puede definir el contenido del elemento mediante `textContent` o `innerHTML`.  

```javascript
const nuevoParrafo = document.createElement("p")
nuevoParrafo.textContent = "Este es un nuevo párrafo"
```  

**Ejemplo en HTML:**  
```html
<!-- Elemento que se añadirá dinámicamente -->
<div id="contenedor"></div>
```  

Aquí, se crea un párrafo (`<p>`) que contiene texto. Este elemento existe en memoria, pero aún no se ha agregado visualmente a la página.  

**Notas:**  
- `createElement` solo crea el elemento, pero no lo agrega automáticamente al DOM. Es necesario añadirlo explícitamente usando otros métodos como `appendChild()`.  

---

#### 5.1.2. Añadir al DOM  

El método `appendChild()` permite añadir un nodo hijo al final de otro nodo. Se usa para agregar elementos recién creados a un contenedor existente.  

```javascript
const contenedor = document.getElementById("contenedor")
contenedor.appendChild(nuevoParrafo)
```  

Esto inserta el párrafo dentro del contenedor con `id="contenedor"`, colocándolo al final de cualquier otro contenido que pudiera haber en su interior.  

**Resultado final en HTML:**  
```html
<div id="contenedor">
    <p>Este es un nuevo párrafo</p>
</div>
```  

---

#### 5.1.3. Insertar en una posición específica  

Si se desea insertar un elemento en una posición específica, se puede usar el método `insertBefore()`. Este método añade un nodo antes de un nodo hijo existente dentro de un contenedor.  

```javascript
const referencia = document.getElementById("referencia")
contenedor.insertBefore(nuevoParrafo, referencia)
```  

En este caso, el nuevo párrafo se inserta justo antes del elemento con `id="referencia"`. Si no hay referencia específica, el elemento se añadirá al final, similar a `appendChild()`.  

**Ejemplo en HTML:**  
```html
<div id="contenedor">
    <p id="referencia">Este es un párrafo existente</p>
</div>
```  

**Resultado final:**  
```html
<div id="contenedor">
    <p>Este es un nuevo párrafo</p>
    <p id="referencia">Este es un párrafo existente</p>
</div>
```  

---

### 5.2. Eliminar elementos del DOM  

Eliminar elementos es igualmente importante para mantener la interfaz limpia y actualizada. JavaScript proporciona varios métodos para eliminar elementos existentes, ya sea directamente o eliminando nodos hijos específicos de un contenedor.  

---

#### 5.2.1. Eliminar un elemento directamente  

El método `remove()` se aplica directamente al elemento que se desea eliminar. Este método no requiere que el nodo padre conozca o controle el elemento hijo.  

```javascript
const parrafoEliminar = document.getElementById("eliminar")
parrafoEliminar.remove()
```  

**Ejemplo en HTML:**  
```html
<p id="eliminar">Este párrafo será eliminado</p>
```  

**Resultado (después de la eliminación):**  
```html
<!-- El párrafo ha sido eliminado del DOM -->
```  

---

#### 5.2.2. Eliminar un elemento hijo  

Si se necesita eliminar un elemento que es hijo de otro nodo, se puede usar el método `removeChild()`. Este método requiere primero seleccionar el nodo padre, y luego apuntar al elemento hijo que se desea eliminar.  

```javascript
const lista = document.getElementById("lista")
const item = lista.querySelector("li")
lista.removeChild(item)
```  

**Ejemplo en HTML:**  
```html
<ul id="lista">
    <li>Elemento 1</li>
    <li>Elemento 2</li>
</ul>
```  

**Resultado (después de eliminar el primer elemento):**  
```html
<ul id="lista">
    <li>Elemento 2</li>
</ul>
```  

---

### Comparación de Métodos de Eliminación  

| Método               | Descripción                                               | Aplicación Directa al Elemento | Requiere Nodo Padre |
|---------------------|-----------------------------------------------------------|--------------------------------|---------------------|
| `remove()`           | Elimina directamente el elemento seleccionado.            | Sí                             | No                  |
| `removeChild()`      | Elimina un elemento hijo del nodo padre especificado.     | No                             | Sí                  |  

---

### Uso Combinado: Crear, Insertar y Eliminar  

Estos métodos pueden combinarse para construir interfaces dinámicas y fluidas. Por ejemplo:  

```javascript
const lista = document.getElementById("lista")

// Crear un nuevo elemento de lista
const nuevoElemento = document.createElement("li")
nuevoElemento.textContent = "Elemento añadido"

// Añadir el nuevo elemento
lista.appendChild(nuevoElemento)

// Eliminar el primer elemento de la lista
const primerItem = lista.querySelector("li")
lista.removeChild(primerItem)
```  

Este flujo permite:  
1. Crear un nuevo elemento de lista.  
2. Añadirlo al final de una lista existente.  
3. Eliminar el primer elemento de la lista.  

---

## 6. Eventos y Listeners  

Los eventos son una parte fundamental de la interactividad en las páginas web. Permiten que JavaScript responda a las acciones del usuario, como hacer clic en un botón, mover el cursor sobre un elemento o enviar un formulario.  

Cuando ocurre un evento, se puede ejecutar una función (conocida como manejador o **listener**) que realiza una acción específica. Esto permite que las interfaces web sean dinámicas y reactivas, proporcionando una experiencia de usuario más fluida y atractiva.  

El modelo de eventos de JavaScript se basa en la escucha y el manejo de estos eventos, lo que permite que los desarrolladores agreguen comportamientos interactivos sin modificar directamente el HTML.  

---

### 6.1. Escuchar eventos  

Para manejar eventos, JavaScript proporciona el método `addEventListener()`, que permite asociar un evento específico con un elemento del DOM. Este método escucha las acciones del usuario y, cuando ocurre el evento especificado, ejecuta una función asociada.  

El método `addEventListener` tiene dos parámetros principales:  
1. **El tipo de evento** (como `click`, `mouseover`, `keydown`).  
2. **La función manejadora** que se ejecuta cuando ocurre el evento.  

Este enfoque es más flexible que el uso de atributos HTML como `onclick`, ya que permite añadir múltiples listeners a un mismo elemento y separar claramente el comportamiento del diseño.  

---

#### 6.1.1. Evento de clic  

Un ejemplo común de evento es el de **clic** (`click`). Se puede agregar un listener que muestra un mensaje cuando el usuario hace clic en un botón.  

```javascript
const boton = document.querySelector("#miBoton")
boton.addEventListener("click", function() {
    alert("¡Botón clicado!")
})
```  

**HTML correspondiente:**  
```html
<button id="miBoton">Haz clic aquí</button>
```  

En este caso, cuando el usuario haga clic en el botón con el `id="miBoton"`, aparecerá una ventana emergente con el mensaje "¡Botón clicado!".  

---

#### 6.1.2. Pasar funciones externas  

En lugar de definir la función manejadora directamente dentro de `addEventListener`, se puede pasar una función externa. Esto hace que el código sea más limpio y fácil de reutilizar.  

```javascript
function mostrarMensaje() {
    alert("¡Evento activado!")
}
boton.addEventListener("click", mostrarMensaje)
```  

Separar las funciones facilita la organización del código y permite que el mismo manejador se utilice para múltiples elementos o eventos.  

**Ventajas de este enfoque:**  
- Mejora la legibilidad del código.  
- Permite reutilizar la misma función en diferentes elementos o eventos.  
- Facilita la depuración y mantenimiento del código.  

---

### 6.2. Tipos de eventos comunes  

Existen numerosos tipos de eventos que se pueden escuchar y manejar con JavaScript. A continuación, se presentan algunos de los eventos más utilizados:  

- **`click`** – Se activa al hacer clic en un elemento.  
- **`mouseover`** – Ocurre cuando el mouse pasa sobre un elemento.  
- **`mouseout`** – Se activa cuando el mouse sale de un elemento.  
- **`keydown`** – Se dispara cuando el usuario presiona una tecla.  
- **`keyup`** – Se activa cuando el usuario suelta una tecla.  
- **`submit`** – Se dispara cuando se envía un formulario.  
- **`change`** – Ocurre cuando el valor de un campo de formulario cambia (por ejemplo, en un `<select>` o `<input>`).  
- **`focus`** – Se activa cuando un campo de formulario gana foco.  
- **`blur`** – Se dispara cuando un campo pierde el foco.  

---

#### Ejemplo de evento de teclado (`keydown`)  

El siguiente ejemplo muestra cómo capturar la tecla presionada por el usuario en un campo de texto y mostrarla en la consola.  

```javascript
const campoTexto = document.querySelector("#campo")
campoTexto.addEventListener("keydown", function(event) {
    console.log("Tecla presionada: " + event.key)
})
```  

**HTML correspondiente:**  
```html
<input type="text" id="campo" placeholder="Escribe algo...">
```  

**Explicación:**  
- Cada vez que el usuario presione una tecla mientras escribe en el campo de texto, se mostrará en la consola el valor de la tecla (`event.key`).  
- `event` es un objeto que representa el evento y proporciona información detallada sobre la acción que ocurrió (en este caso, la tecla presionada).  

---

### 6.3. Delegación de eventos  

En aplicaciones complejas, agregar listeners a múltiples elementos puede ser ineficiente. En lugar de eso, se puede usar la **delegación de eventos**, que consiste en agregar un listener a un elemento padre y aprovechar el hecho de que los eventos se propagan (burbujean) desde los elementos hijos hacia sus ancestros.  

```javascript
const lista = document.querySelector("#lista")
lista.addEventListener("click", function(event) {
    if (event.target.tagName === "LI") {
        alert("Elemento de lista clicado: " + event.target.textContent)
    }
})
```  

**HTML correspondiente:**  
```html
<ul id="lista">
    <li>Elemento 1</li>
    <li>Elemento 2</li>
    <li>Elemento 3</li>
</ul>
```  

**Explicación:**  
- El listener se agrega a la lista (`<ul>`), pero responde a clics en cualquier `<li>` dentro de ella.  
- `event.target` identifica el elemento exacto que disparó el evento.  

**Ventajas de la delegación de eventos:**  
- Reduce la cantidad de listeners, mejorando el rendimiento.  
- Permite manejar elementos dinámicamente generados que no existían al cargar la página.  

---

### 6.4. Remover listeners de eventos  

Si es necesario eliminar un listener de un elemento, se puede usar el método `removeEventListener()`. Este método requiere que la función manejadora sea una referencia nombrada (no una función anónima).  

```javascript
boton.removeEventListener("click", mostrarMensaje)
```  

Esto evita que el listener siga activo, lo que puede ser útil para optimizar el rendimiento o prevenir comportamientos repetidos innecesarios.  

## 7. Métodos y Propiedades Útiles en el DOM  

En JavaScript, al manipular el DOM es común usar ciertas **propiedades y métodos** para acceder y modificar elementos. En esta sección se explicarán algunos de los más utilizados en la manipulación de listas y otros elementos dinámicos.

---

### 7.1. `childElementCount`  

La propiedad `childElementCount` devuelve el **número de hijos directos** que tiene un nodo. Solo cuenta los **nodos de tipo elemento** (como etiquetas HTML), ignorando los nodos de texto o comentarios.  

```js
const lista = document.getElementById("lista");
console.log(lista.childElementCount); // Muestra la cantidad de <li> en la lista
```

---

### 7.2. `lastElementChild`  

`lastElementChild` selecciona el **último hijo** de un elemento padre. Si el nodo no tiene hijos, devuelve `null`.

```js
const ultimoElemento = lista.lastElementChild;
console.log(ultimoElemento.textContent); // Muestra el contenido del último <li>
```

---

### 7.3. `replaceChild()`  

El método `replaceChild()` permite **reemplazar un nodo hijo** por otro nuevo. Necesita dos parámetros:  
1. **El nuevo nodo** que reemplazará al existente.  
2. **El nodo que será reemplazado**.

```js
const nuevoElemento = document.createElement("li");
nuevoElemento.textContent = "Elemento nuevo";

const lista = document.getElementById("lista");
lista.replaceChild(nuevoElemento, lista.lastElementChild);
```

---

### 7.4. `parseInt()` y `parseFloat()`  

En JavaScript, `parseInt()` y `parseFloat()` son funciones utilizadas para **convertir cadenas de texto a números**.

- `parseInt()` convierte un valor a un **número entero**.  
- `parseFloat()` convierte un valor a un **número decimal (flotante)**.

```js
let numero = parseInt("42");
let precio = parseFloat("42.99");
```

---

### 7.5. Ejemplos Combinados  

```js
let contadorElementos = 3;

function aniadirElementoLista() {
    const lista = document.getElementById("lista");
    contadorElementos++;
    
    const nuevoElemento = document.createElement("li");
    nuevoElemento.innerHTML = "Elemento " + contadorElementos;
    
    lista.appendChild(nuevoElemento);
}

function reemplazarUltimoElementoLista() {
    const lista = document.getElementById("lista");
    
    if (lista.lastElementChild) {
        const nuevoElemento = document.createElement("li");
        nuevoElemento.innerHTML = "Elemento editado";
        
        lista.lastElementChild.remove();
        lista.appendChild(nuevoElemento);
    }
}
```

---

### 7.6. Buenas Prácticas  
- Utiliza `parseInt()` cuando solo necesites números enteros.
- Usa `parseFloat()` para cálculos con decimales.
- **Verifica siempre** la existencia de un nodo antes de manipularlo con `lastElementChild` o `replaceChild()` para evitar errores.
- **Evita usar `innerHTML`** para crear elementos dinámicamente si no es necesario, ya que puede introducir problemas de seguridad (XSS). Prefiere `textContent` o métodos como `createElement()`.
