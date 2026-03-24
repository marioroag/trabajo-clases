Ejercicios peticiones http

1. Crea una base de datos en json con 2 personas, que tenga como datos sus coches. Ahora sí podemos apuntar una persona y sus coches, y no id dueño en cada coche. Fijate en profes y asignaturas.
2. Enciende un servidor usando json-server que aloje esta base de datos.
3. Realiza una peticion GET para ver todas las personas
4. Realiza una petición GET para ver a la segunda persona que aparece en la base de datos.
5. Añade una nueva persona
6. Modifica la edad a la tercera persona.
7. Muestra todas las personas de más de 30 años
8. Muestra todos los coches de una persona. solo los coches

⸻


# 🧪 Ejercicios HTTP + curl + jq resueltos

---

## 🔹 1. Crear base de datos (`db.json`)

```json
{
  "personas": [
    {
      "id": 1,
      "nombre": "Juan",
      "edad": 35,
      "coches": [
        { "marca": "BMW", "modelo": "X5" },
        { "marca": "Audi", "modelo": "A3" }
      ]
    },
    {
      "id": 2,
      "nombre": "Ana",
      "edad": 25,
      "coches": [
        { "marca": "Seat", "modelo": "Ibiza" }
      ]
    }
  ]
}


⸻

🔹 2. Encender servidor

json-server --watch db.json

👉 Servidor en:

http://localhost:3000/personas


⸻

🔹 3. GET → ver todas las personas

curl http://localhost:3000/personas


⸻

🔹 4. GET → ver la segunda persona

curl http://localhost:3000/personas/2


⸻

🔹 5. POST → añadir nueva persona

curl -X POST http://localhost:3000/personas \
-H "Content-Type: application/json" \
-d '{
  "nombre": "Luis",
  "edad": 40,
  "coches": [
    { "marca": "Ford", "modelo": "Focus" }
  ]
}'


⸻

🔹 6. PATCH → modificar edad de la tercera persona

curl -X PATCH http://localhost:3000/personas/3 \
-H "Content-Type: application/json" \
-d '{"edad":45}'


⸻

🔹 7. Mostrar personas de más de 30 años

curl -s http://localhost:3000/personas | jq '.[] | select(.edad > 30)'

👉 Solo nombres:

curl -s http://localhost:3000/personas | jq -r '.[] | select(.edad > 30) | .nombre'


⸻

🔹 8. Mostrar todos los coches de una persona

Ejemplo: persona 1

curl -s http://localhost:3000/personas/1 | jq '.coches'


⸻

Solo marcas

curl -s http://localhost:3000/personas/1 | jq '.coches[].marca'


⸻

Marca y modelo

curl -s http://localhost:3000/personas/1 | jq '.coches[] | {marca, modelo}'


⸻

🧠 Resumen mental rápido
	•	GET → leer
	•	POST → crear
	•	PATCH → modificar
	•	.campo → objeto
	•	[] → array
	•	select() → filtrar

⸻

🔥 TIP EXAMEN

Si no sabes qué hacer:
	1.	Mira si es array → []
	2.	Filtrar → select()
	3.	Sacar campo → .campo

---

Si quieres, ahora te hago un **ejercicio sorpresa tipo examen (nivel profe cabrón 😈)** para que vayas sobrado.