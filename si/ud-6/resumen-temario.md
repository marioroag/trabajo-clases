
# Resumen examen HTTP + `curl` + `jq` + `json-server`

## 1. Ideas clave

- `json-server` usa un archivo `db.json` como base de datos.
- Cada clave principal del JSON se convierte en un endpoint.
- Si tienes:

```json
{
  "personas": [...]
}
```

el endpoint es:

```bash
http://localhost:3000/personas
```

- `curl` sirve para hacer peticiones HTTP desde terminal.
- `jq` sirve para leer, recortar y filtrar JSON.

---

## 2. Estructura básica de JSON

### Objeto
```json
{
  "nombre": "Cristian",
  "edad": 37
}
```

### Array
```json
[
  { "nombre": "Cristian" },
  { "nombre": "Ana" }
]
```

### Persona con coches
```json
{
  "id": 1,
  "nombre": "Cristian",
  "edad": 37,
  "coches": [
    { "marca": "BMW", "modelo": "X5" },
    { "marca": "Audi", "modelo": "A3" }
  ]
}
```

### Recordatorio de símbolos

- `{}` → objeto
- `[]` → array
- `"clave": valor` → propiedad
- `,` → separa elementos
- `:` → separa clave y valor
- `()` → no se usa en JSON

---

## 3. Plantilla general de `curl`

```bash
curl -X METODO URL -H "Content-Type: application/json" -d 'JSON'
```

### Qué es cada parte

- `curl` → herramienta
- `-X` → método HTTP
- `URL` → dónde haces la petición
- `-H "Content-Type: application/json"` → indicas que mandas JSON
- `-d '...'` → datos en JSON

---

## 4. Métodos HTTP que te pueden pedir

## GET → obtener datos

### Ver todo un recurso
```bash
curl http://localhost:3000/personas
```

### Ver un elemento concreto
```bash
curl http://localhost:3000/personas/1
```

---

## POST → crear un recurso nuevo

- Se usa para añadir una persona nueva.
- Suele generar el `id` automáticamente.
- Es flexible: puedes crear un objeto con los campos que quieras.

### Ejemplo
```bash
curl -X POST http://localhost:3000/personas \
-H "Content-Type: application/json" \
-d '{"nombre":"Elisabeth","edad":25,"coches":[{"marca":"Mini","modelo":"one"}]}'
```

### Idea clave
- `POST` crea
- no necesitas mandar todos los campos que tienen otros objetos
- puedes crear uno con otra estructura si te lo piden

---

## PUT → reemplazar TODO el objeto

- Se usa para sustituir un recurso completo.
- Tienes que mandar todos los campos que quieres conservar.
- Si no mandas uno, desaparece.

### Ejemplo
```bash
curl -X PUT http://localhost:3000/personas/1 \
-H "Content-Type: application/json" \
-d '{"id":1,"nombre":"Cristian","edad":37,"coches":[{"marca":"BMW","modelo":"X5"},{"marca":"Audi","modelo":"A3"}]}'
```

### Idea clave
- `PUT` rehace el objeto entero
- si te olvidas de `coches`, se borran
- si te olvidas de `edad`, desaparece

---

## PATCH → modificar solo una parte

- Se usa para cambiar un campo o añadir uno nuevo.
- No toca lo demás.

### Cambiar edad
```bash
curl -X PATCH http://localhost:3000/personas/1 \
-H "Content-Type: application/json" \
-d '{"edad":37}'
```

### Añadir edad si no existe
```bash
curl -X PATCH http://localhost:3000/personas/2 \
-H "Content-Type: application/json" \
-d '{"edad":22}'
```

### Idea clave
- `PATCH` modifica solo lo que mandas
- es más cómodo que `PUT`

---

## DELETE → borrar

```bash
curl -X DELETE http://localhost:3000/personas/1
```

---

## 5. Diferencias rápidas entre POST, PUT y PATCH

### POST
- crea
- flexible
- objeto nuevo

### PUT
- reemplaza todo
- tienes que mandar el objeto completo

### PATCH
- modifica una parte
- más seguro si solo cambias un campo

### Regla mental
- `POST` → añadir algo nuevo
- `PUT` → rehacer el objeto entero
- `PATCH` → cambiar una cosa

---

## 6. `jq` básico

## Regla base

- `.campo` → acceder a un campo
- `[]` → recorrer un array
- `.[].campo` → campo de cada elemento del array

---

## Ejemplos básicos

### Nombre de una persona
```bash
jq '.nombre'
```

### Nombre de todas
```bash
jq '.[].nombre'
```

### Todos los coches
```bash
jq '.[].coches[]'
```

### Todas las marcas
```bash
jq '.[].coches[].marca'
```

### Marca y modelo
```bash
jq '.[].coches[] | {marca, modelo}'
```

### Nombre y edad
```bash
jq '{nombre, edad}'
```

Esto equivale a:

```bash
jq '{nombre: .nombre, edad: .edad}'
```

---

## 7. Símbolos de `jq`

## El punto `.`
El punto significa: “el JSON actual”.

### Ejemplo
```bash
jq '.nombre'
```

---

## Los corchetes `[]`
Sirven para entrar en cada elemento de un array.

### Ejemplo
```bash
jq '.[].nombre'
```

---

## La barra `|`
Sirve para encadenar pasos.

### Ejemplo
```bash
jq '.[].coches[] | {marca, modelo}'
```

Primero entra en cada coche, luego se queda con `marca` y `modelo`.

---

## Las llaves `{}` en `jq`
Sirven para construir un objeto nuevo con los campos que quieras.

### Ejemplo
```bash
jq '{nombre, edad}'
```

---

## `select()`
Sirve para filtrar.

### Ejemplo
```bash
jq '.[] | select(.edad > 30)'
```

---

## `==`
Sirve para comparar.

### Ejemplo
```bash
jq 'select(.marca == "Mini")'
```

### Ojo
- `==` → comparar
- `=` → incorrecto para comparar en este contexto

---

## 8. Errores típicos

## Error 1: olvidar el punto
Incorrecto:

```bash
jq 'nombre'
```

Correcto:

```bash
jq '.nombre'
```

---

## Error 2: usar `.campo` sobre un array
Incorrecto:

```bash
jq '.nombre'
```

si lo que tienes es una lista.

Correcto:

```bash
jq '.[].nombre'
```

---

## Error 3: olvidar `[]` en arrays anidados
Incorrecto:

```bash
jq '.[].coches.marca'
```

Correcto:

```bash
jq '.[].coches[].marca'
```

---

## Error 4: usar `=` en vez de `==`
Incorrecto:

```bash
jq 'select(.marca = "Mini")'
```

Correcto:

```bash
jq 'select(.marca == "Mini")'
```

---

## Error 5: si aparece `>`
Si la terminal muestra:

```bash
>
```

significa que el comando se ha quedado abierto:
- faltan comillas
- falta cerrar JSON
- falta cerrar llaves o corchetes

### Salir
```bash
Ctrl + C
```

---

## Error 6: con arrays y `PATCH`
Si haces:

```bash
curl -X PATCH http://localhost:3000/personas/1 \
-H "Content-Type: application/json" \
-d '{"coches":[{"marca":"Citroen","modelo":"C4"}]}'
```

no añades un coche: reemplazas el array `coches` entero.

---

## 9. Tu base de datos de ejemplo

### `db.json`
```json
{
  "personas": [
    {
      "id": 1,
      "nombre": "Cristian",
      "edad": 37,
      "coches": [
        { "marca": "BMW", "modelo": "X5" },
        { "marca": "Audi", "modelo": "A3" },
        { "marca": "Citroen", "modelo": "C4" }
      ]
    },
    {
      "id": 2,
      "nombre": "Ana",
      "edad": 22,
      "coches": [
        { "marca": "Seat", "modelo": "Ibiza" }
      ]
    },
    {
      "id": 3,
      "nombre": "Elisabeth",
      "edad": 25,
      "coches": [
        { "marca": "Mini", "modelo": "one" }
      ]
    }
  ]
}
```

---

## 10. Ejemplos visuales con tu base de datos

## Encender el servidor

```bash
json-server --watch db.json
```

---

## Ver todas las personas

```bash
curl http://localhost:3000/personas
```

---

## Ver la persona 1

```bash
curl http://localhost:3000/personas/1
```

---

## Añadir una nueva persona

```bash
curl -X POST http://localhost:3000/personas \
-H "Content-Type: application/json" \
-d '{"nombre":"Luis","edad":31,"coches":[{"marca":"Ford","modelo":"Focus"}]}'
```

---

## Cambiar la edad de la persona 1

```bash
curl -X PATCH http://localhost:3000/personas/1 \
-H "Content-Type: application/json" \
-d '{"edad":38}'
```

---

## Reemplazar completa la persona 1

```bash
curl -X PUT http://localhost:3000/personas/1 \
-H "Content-Type: application/json" \
-d '{"id":1,"nombre":"Cristian","edad":37,"coches":[{"marca":"BMW","modelo":"X5"},{"marca":"Audi","modelo":"A3"},{"marca":"Citroen","modelo":"C4"}]}'
```

---

## Ver solo el nombre de Cristian

```bash
curl -s http://localhost:3000/personas/1 | jq '.nombre'
```

---

## Ver nombre y edad de Cristian

```bash
curl -s http://localhost:3000/personas/1 | jq '{nombre, edad}'
```

---

## Ver los nombres de todas las personas

```bash
curl -s http://localhost:3000/personas | jq '.[].nombre'
```

---

## Ver todos los coches de todas las personas

```bash
curl -s http://localhost:3000/personas | jq '.[].coches[]'
```

---

## Ver todas las marcas de todos los coches

```bash
curl -s http://localhost:3000/personas | jq '.[].coches[].marca'
```

---

## Ver marca y modelo de todos los coches

```bash
curl -s http://localhost:3000/personas | jq '.[].coches[] | {marca, modelo}'
```

---

## Ver personas de más de 30 años

```bash
curl -s http://localhost:3000/personas | jq '.[] | select(.edad > 30)'
```

---

## Ver nombres de personas de más de 30 años

```bash
curl -s http://localhost:3000/personas | jq -r '.[] | select(.edad > 30) | .nombre'
```

---

## Ver coches de personas de más de 30 años

```bash
curl -s http://localhost:3000/personas | jq '.[] | select(.edad > 30) | .coches[]'
```

---

## Ver marcas de coches de personas de más de 30 años

```bash
curl -s http://localhost:3000/personas | jq '.[] | select(.edad > 30) | .coches[].marca'
```

---

## Ver marca y modelo de coches de personas de más de 30 años

```bash
curl -s http://localhost:3000/personas | jq '.[] | select(.edad > 30) | .coches[] | {marca, modelo}'
```

---

## Ver coches de personas menores de 30

```bash
curl -s http://localhost:3000/personas | jq '.[] | select(.edad < 30) | .coches[]'
```

---

## Ver marca y modelo de coches de personas menores de 30

```bash
curl -s http://localhost:3000/personas | jq '.[] | select(.edad < 30) | .coches[] | {marca, modelo}'
```

---

## Filtrar coches Mini de personas menores de 30

```bash
curl -s http://localhost:3000/personas | jq '.[] | select(.edad < 30) | .coches[] | select(.marca == "Mini")'
```

---

## Sacar la persona menor de 30 que tenga un Mini

```bash
curl -s http://localhost:3000/personas | jq '.[] | select(.edad < 30 and (.coches[].marca == "Mini"))'
```

---

## Ver solo los coches de una persona concreta

### Coches de la persona 1
```bash
curl -s http://localhost:3000/personas/1 | jq '.coches'
```

### Marcas de la persona 1
```bash
curl -s http://localhost:3000/personas/1 | jq '.coches[].marca'
```

### Marca y modelo de la persona 1
```bash
curl -s http://localhost:3000/personas/1 | jq '.coches[] | {marca, modelo}'
```

---

## 11. Chuleta final ultra rápida

### `curl`
```bash
curl -X METODO URL -H "Content-Type: application/json" -d 'JSON'
```

### Métodos
- `GET` → leer
- `POST` → crear
- `PUT` → reemplazar todo
- `PATCH` → modificar parte
- `DELETE` → borrar

### `jq`
- `.campo` → objeto
- `.[].campo` → array de objetos
- `.array[]` → elementos del array
- `.array[].campo` → campo de cada elemento
- `|` → encadenar
- `{a, b}` → crear objeto
- `select()` → filtrar
- `==` → comparar

### Aclaracion:
- `.[].campo` → lista de cosas
- `.array[]` → saco cosas dentro de algo

---

## 12. Lo más probable que te pidan mañana

- crear `db.json`
- levantar `json-server`
- hacer un `GET`
- hacer un `POST`
- modificar con `PATCH`
- sacar un campo con `jq`
- filtrar con `select()`
- recorrer arrays con `[]`

Si dudas:
1. mira si tienes objeto o array
2. si es array, usa `[]`
3. si quieres filtrar, usa `select()`
4. si quieres varios campos, usa `{campo1, campo2}`
