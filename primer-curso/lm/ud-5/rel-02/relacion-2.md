# 📰 **Relación de Ejercicios de Manipulación del DOM - Temática: Periódico** 📰
---

## 📌 **Ejercicio 1: Cambio de Titulares** 📝  
**Objetivo:** Modificar el texto de los encabezados (`<h1>` y `<h2>`) al cargar la página.

### 🏠 **HTML Base:**
```html
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Noticias Express</title>
</head>
<body>
    <h1 id="titulo">Noticia s de Hoy</h1>
    <h2 id="subtitulo">Las noticias más importantes del día</h2>
    
    <script src="js/script.js"></script>
</body>
</html>
```

### 📌 **Instrucciones:**
1. Al cargar la página:
   - Cambia el texto del `<h1>` a `"Última Hora: Impactantes Noticias"`.
   - Cambia el texto del `<h2>` a `"Mantente informado con nuestras noticias más recientes"`.

---

## 📌 **Ejercicio 2: Cambio de Imagen Destacada** 🎨  
**Objetivo:** Modificar dinámicamente la imagen principal de la noticia.

### 🏠 **HTML Base:**
```html
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Noticia Destacada</title>
</head>
<body>
    <h1>Noticia Principal</h1>
    <img id="imagen" src="imagen1.jpg" alt="Imagen de la noticia" width="600">

    <script src="js/script.js"></script>
</body>
</html>
```

### 📌 **Instrucciones:**
1. Al cargar la página, cambia la `src` de la imagen para mostrar `"imagen2.jpg"`.

📌 **Pista:** Usa `document.getElementById("imagen").src = "nueva_imagen.jpg"`.

---

## 📌 **Ejercicio 3: Resaltar Noticias Importantes** 📰  
**Objetivo:** Cambiar dinámicamente el estilo de las noticias destacadas.

### 🏠 **HTML Base:**
```html
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Sección de Noticias</title>
</head>
<body>
    <h1>Sección de Noticias</h1>
    <ul>
        <li class="noticia">Nueva ley de tránsito entra en vigor</li>
        <li class="noticia">Descubrimiento científico sorprendente</li>
        <li class="noticia">Eventos culturales en la ciudad</li>
    </ul>

    <script src="js/script.js"></script>
</body>
</html>
```

### 📌 **Instrucciones:**
1. Al cargar la página:
   - Cambia el color de fondo de las noticias impares a `lightgray`.
   - Cambia el color del texto de las noticias pares a `blue`.
   - Añade un emoji 🔥 al inicio de cada noticia.


---

## 📌 **Ejercicio 4: Destacar Precios de Suscripción** 💰  
**Objetivo:** Aplicar formato dinámico a los precios de suscripción en la tabla.

### 🏠 **HTML Base:**
```html
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Suscripciones</title>
</head>
<body>
    <h1>Planes de Suscripción</h1>
    <table border="1">
        <tr>
            <th>Plan</th>
            <th>Precio</th>
        </tr>
        <tr>
            <td>Básico</td>
            <td class="precio">20</td>
        </tr>
        <tr>
            <td>Premium</td>
            <td class="precio">60</td>
        </tr>
        <tr>
            <td>VIP</td>
            <td class="precio">100</td>
        </tr>
    </table>

    <script src="js/script.js"></script>
</body>
</html>
```

### 📌 **Instrucciones:**
1. Al cargar la página:
   - Aplica `fontWeight = "bold"` a los precios.
   - Si un precio es mayor a `50`, cámbialo a color rojo.


---

## 📌 **Ejercicio 5: Generar Noticias Aleatorias** ✍️  
**Objetivo:** Insertar contenido dinámico en una sección de noticias.

### 🏠 **HTML Base:**
```html
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Noticias Generadas</title>
</head>
<body>
    <h1>Noticias Generadas</h1>
    <div id="contenedor"></div>

    <script src="js/script.js"></script>
</body>
</html>
```

### 📌 **Instrucciones:**
1. Al cargar la página, usa JavaScript para agregar tres `<p>` dentro del `div` con `id="contenedor"` con frases como:
   - `"Descubren una nueva especie en la selva amazónica."`
   - `"Avances tecnológicos revolucionan la industria de la salud."`
   - `"El mercado financiero experimenta grandes cambios."`


