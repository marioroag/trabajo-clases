# 🎯 **Relación de Ejercicios de Manipulación del DOM en JavaScript** 🎯

---

## 📌 **Ejercicio 1: Gestión de Animales del Zoológico 🐾**  
**Objetivo:** Practicar el uso de `getElementsByClassName`.

### Instrucciones:
1. Crea varios elementos `<div>` con la clase `animal` que contengan nombres de diferentes animales.
2. Al cargar la página, cambia el color de fondo de todos los animales a un color suave (por ejemplo, `lightyellow`).
3. Añade un botón llamado **"Resaltar Animales"**. Al hacer clic en este botón:
   - Cambia el color del texto de todos los elementos con la clase `animal` a **verde**.
   - Aumenta el tamaño de la fuente de todos los nombres.

### Pistas:
- Usa `getElementsByClassName("animal")` para obtener todos los elementos con la clase `animal`.
- Recorre la colección utilizando un bucle `for`.

---

## 📌 **Ejercicio 2: Lista de Frutas Saludables 🍎🍌🍇**  
**Objetivo:** Practicar el uso de `getElementsByTagName`.

### Instrucciones:
1. Crea una lista desordenada (`<ul>`) con varios elementos de lista (`<li>`) que contengan nombres de frutas.
2. Al cargar la página, agrega un borde de color naranja alrededor de cada elemento `<li>`.
3. Añade un botón llamado **"Marcar Frutas"**. Al hacer clic en este botón:
   - Cambia el fondo de todos los elementos `<li>` a un color pastel.
   - Añade un emoji de ✅ al final de cada nombre de fruta.

---

## 📌 **Ejercicio 3: Panel de Control de Botones 🎛️**  
**Objetivo:** Practicar el uso de `querySelector` y `querySelectorAll`.

### Instrucciones:
1. Crea varios botones con la clase `boton`. Cada botón debe tener un texto diferente (por ejemplo: **Iniciar**, **Detener**, **Reiniciar**).
2. Al cargar la página:
   - Cambia el color del primer botón usando `document.querySelector(".boton")`.
3. Añade otro botón llamado **"Cambiar Estilo de Todos"**. Al hacer clic en este botón:
   - Cambia el color de fondo de **todos** los botones con la clase `boton` a un color diferente usando `document.querySelectorAll(".boton")`.
   - Añade un borde a cada botón.

### Pistas:
- Usa `const primerBoton = document.querySelector(".boton")` para seleccionar el primer botón.
- Usa `const todosLosBotones = document.querySelectorAll(".boton")` para obtener una NodeList de todos los botones.
- Recorre la NodeList usando `forEach`.
