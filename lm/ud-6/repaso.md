# 📋 Chuleta — Fetch y APIs RESTful (UD6)

---

## 1. Conceptos clave

| Término | Definición |
|--------|-----------|
| **API** | Puente que permite que dos aplicaciones intercambien datos |
| **REST** | Estilo arquitectónico que usa HTTP. Cada petición es independiente (*stateless*) |
| **JSON** | Formato de datos más usado en APIs. Fácil de leer y procesar en JS |
| **URI/Endpoint** | Dirección única de cada recurso. Ej: `/paises`, `/paises/es` |

---

## 2. Métodos HTTP (CRUD)

| Método | Acción | Código respuesta | ¿Necesita body? |
|--------|--------|-----------------|----------------|
| `GET` | Leer datos | 200 OK | ❌ No |
| `POST` | Crear recurso | 201 Created | ✅ Sí |
| `PUT` | Actualizar recurso | 200 OK | ✅ Sí |
| `DELETE` | Eliminar recurso | 204 No Content | ❌ No |

---

## 3. `fetch()` — Estructura base

### GET (leer)
```javascript
async function obtenerDatos(url) {
    try {
        const respuesta = await fetch(url);

        if (!respuesta.ok) throw new Error("Error en la petición");

        const datos = await respuesta.json();
        return datos;

    } catch (error) {
        console.error(error);
        return null;
    }
}
```

> ⚠️ `respuesta.ok` es `true` si el código HTTP está entre **200–299**.  
> Un 404 **no** lanza error automáticamente, hay que comprobarlo.

---

### POST (crear)
```javascript
const nuevoPost = {
    title: "Nuevo artículo",
    body: "Contenido del artículo",
    userId: 1
};

const respuesta = await fetch("https://api.example.com/posts", {
    method: "POST",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify(nuevoPost)
});

const datos = await respuesta.json();
```

---

### PUT (actualizar)
```javascript
const actualizado = {
    id: 1,
    title: "Título actualizado",
    body: "Nuevo contenido",
    userId: 1
};

const respuesta = await fetch("https://api.example.com/posts/1", {
    method: "PUT",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify(actualizado)
});

const datos = await respuesta.json();
```

---

### DELETE (eliminar)
```javascript
await fetch("https://api.example.com/posts/1", {
    method: "DELETE"
});

console.log("Recurso eliminado");
// No hace falta llamar a .json() — la respuesta no tiene body
```

---

## 4. Reglas de oro

| Método | ¿Necesita `method`? | ¿Necesita `headers`? | ¿Necesita `JSON.stringify()`? |
|--------|--------------------|--------------------|------------------------------|
| GET | ❌ | ❌ | ❌ |
| POST | ✅ | ✅ | ✅ |
| PUT | ✅ | ✅ | ✅ |
| DELETE | ✅ | ❌ | ❌ |

> 💡 **GET y DELETE** → solo la URL (y `method` en DELETE).  
> 💡 **POST y PUT** → siempre `headers` + `JSON.stringify()` en el `body`.

---

## 5. Funciones de utilidad del ejercicio

```javascript
// Limpiar contenedor antes de mostrar nuevos datos
function limpiarContenedor(contenedor) {
    contenedor.innerHTML = "";
}

// Mostrar mensaje de error con estilo
function mostrarError(contenedor, mensaje) {
    contenedor.innerHTML = `<p class="mensaje-error">${mensaje}</p>`;
}

// Petición genérica reutilizable
async function obtenerDatos(url) {
    let datos = null;
    try {
        const respuesta = await fetch(url);
        if (respuesta.ok) {
            datos = await respuesta.json();
        } else {
            throw new Error("Error");
        }
    } catch (error) {
        console.error(error);
    }
    return datos;
}
```

---

## 6. Endpoints de REST Countries (`/v3.1`)

| Endpoint | Descripción | Resultado |
|----------|------------|-----------|
| `/name/:nombre` | Buscar por nombre | Array → usar `[0]` |
| `/region/:region` | Países de una región | Array |
| `/capital/:capital` | Buscar por capital | Array → usar `[0]` |
| `/alpha/:codigo` | Buscar por código (es, esp) | Objeto o array |
| `/all?fields=...` | Todos los países (campos filtrados) | Array |

**Regiones válidas:** `europe` · `africa` · `asia` · `americas` · `oceania`

---

## 7. Extracción de datos de un país

```javascript
// Capital (puede tener varias)
pais.capital.join(", ")

// Idiomas
Object.values(pais.languages).join(", ")

// Monedas
Object.values(pais.currencies).forEach(m => `${m.name} (${m.symbol})`)

// Continentes
pais.continents.join(", ")

// Población formateada
pais.population.toLocaleString()

// Bandera
pais.flags.svg

// Mapa de Google
pais.maps.googleMaps
```

---

## 8. Flujo completo de una función principal

```javascript
async function buscarPaisPorNombre(nombre) {
    // 1. Limpiar el contenedor
    limpiarContenedor(resultadoNombre);

    // 2. Validar el input
    if (!nombre) {
        mostrarError(resultadoNombre, "Introduce un país");
        return;
    }

    // 3. Hacer la petición
    const datos = await obtenerDatos(`${URL_BASE}/name/${nombre}`);

    // 4. Mostrar resultado o error
    if (datos) {
        resultadoNombre.innerHTML = crearTarjetaDetallePais(datos[0]);
    } else {
        mostrarError(resultadoNombre, "País no encontrado");
    }
}
```

---

## 9. Eventos del DOM

```javascript
// Formulario con submit
form.addEventListener("submit", e => {
    e.preventDefault(); // Evitar recarga de página
    buscarPaisPorNombre(input.value.trim().toLowerCase());
});

// Botones con data attributes
botonesRegion.forEach(boton => {
    boton.addEventListener("click", () => {
        buscarPorRegion(boton.dataset.region);
    });
});

// Botón simple
btnTodos.addEventListener("click", cargarTodos);
```

---

*API de referencia: [restcountries.com](https://restcountries.com) · Documentación fetch: [MDN](https://developer.mozilla.org/es/docs/Web/API/Fetch_API)*