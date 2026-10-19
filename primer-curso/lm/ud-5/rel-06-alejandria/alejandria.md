# Ejercicio Práctico: Biblioteca de Alejandría - Manipulación del DOM en JavaScript

## Descripción del Ejercicio

Desarrolla una página web interactiva para la **Biblioteca de Alejandría** utilizando **JavaScript** y **Manipulación del DOM**. La página debe permitir a los usuarios:

- **Buscar libros** por título o autor.
- **Agregar y eliminar** libros de una lista de favoritos.
- **Modificar información** de los libros en tiempo real.
- **Ordenar la lista de libros** por título o autor.
- **Interactuar con eventos** como clics, doble clics y teclas.

El diseño debe ser **responsivo y dinámico**, utilizando **HTML** y **CSS** para la estructura y el estilo, y **JavaScript** para la lógica interactiva. 

## METE CADA ARCHIVO EN SU CARPETA(CSS, JS)

---

## Requisitos Funcionales


### 1. Búsqueda de libros
- Permite buscar libros **filtrando por título o autor**, mostrando solo los resultados coincidentes.
- La búsqueda debe actualizarse **en tiempo real** a medida que el usuario escribe.

### 2. Agregar a favoritos
- Incluye un **botón** en cada libro para **agregarlo** a una lista de favoritos.
- Los libros favoritos deben aparecer en una **sección separada**.

### 3. Eliminar de favoritos
- Cada libro en la lista de favoritos debe tener un **botón** para **eliminarlo**.

### 4. Modificar información del libro
- Al hacer **doble clic** en el título o autor de un libro, permitir la **edición directa** de su contenido.

### 5. Ordenar la lista de libros
- Añadir **botones** para **ordenar** la lista alfabéticamente por **título** o **autor**.

### 6. Eventos interactivos
- Implementar eventos de:
  - **Clic** (`click`)
  - **Doble clic** (`dblclick`)
  - **Teclas** (`keydown`)

---

## Requisitos Técnicos

### 1. Uso de JavaScript nativo
- **Sin frameworks** (No usar React, Angular, jQuery, etc.)
- Manipulación del **DOM** usando:
  - `getElementById`
  - `getElementsByClassName`
  - `querySelector` y `querySelectorAll`

### 2. Crear y eliminar elementos dinámicamente
- Utiliza:
  - `createElement()`
  - `remove()`

### 3. Modificar atributos y estilos
- Utiliza:
  - `setAttribute()`
  - `removeAttribute()`
  - `.style`

### 4. Eventos y listeners
- Utiliza:
  - `addEventListener()`
  - `removeEventListener()`

### 5. Métodos avanzados del DOM
- Utiliza:
  - `childElementCount`
  - `lastElementChild`
  - `replaceChild()`
  - `parseInt()` y `parseFloat()` (si es necesario manipular datos numéricos)

---

## Pistas y Sugerencias

- Utiliza **`textContent`** para modificar el texto de los elementos y **`innerHTML`** para insertar etiquetas HTML (con precaución).
- Organiza el código **separando la lógica de eventos de la manipulación del DOM**.
- Utiliza **delegación de eventos** para manejar clics en listas dinámicamente generadas.
- Aprovecha **`classList`** para gestionar **clases** y **estilos** de los elementos de forma dinámica.
- Aplica **`parseInt()`** y **`parseFloat()`** cuando necesites convertir **valores de texto a números**.

