# Relación 2: Arrays

---

## 1. Registro de Temperatura Diaria

Escribe un programa que permita al usuario ingresar las temperaturas registradas durante una semana (7 días). Una vez ingresadas las temperaturas, el programa debe mostrar al usuario un menú con las siguientes opciones:

1. Mostrar la temperatura más alta registrada.
2. Mostrar la temperatura más baja registrada.
3. Calcular la temperatura promedio de la semana.
4. Salir del programa.

El programa debe ejecutarse hasta que el usuario elija la opción de salir.

*Solución:*
```javascript
const temperaturas = []
let temperaturaSolicitada
let opcion

for (let i = 1; i <= 7; i++) {
    temperaturaSolicitada = Number(prompt("Inserte la temperatura del día " + i + ":"))
    temperaturas.push(temperaturaSolicitada)
}

while (opcion !== "4") {

    opcion = prompt("1. Mostrar la temperatura más alta registrada.
2. Mostrar la temperatura más baja registrada.
3. Calcular la temperatura promedio de la semana.
4. Salir del programa.")

    if (opcion === "1") {

        let temperaturaMaxima = temperaturas[0]

        for (let i = 1; i < temperaturas.length; i++) {
            if (temperaturas[i] > temperaturaMaxima) {
                temperaturaMaxima = temperaturas[i]
            }
        }

        alert("La temperatura máxima es de " + temperaturaMaxima + " ºC")

    } else if (opcion === "2") {

        let temperaturaMinima = temperaturas[0]

        for (let i = 1; i < temperaturas.length; i++) {
            if (temperaturas[i] < temperaturaMinima) {
                temperaturaMinima = temperaturas[i]
            }
        }

        alert("La temperatura mínima es de " + temperaturaMinima + " ºC")

    } else if (opcion === "3") {

        let sumatorioTemperaturas = 0

        for (let i = 0; i < temperaturas.length; i++) {
            sumatorioTemperaturas += temperaturas[i]
        }

        let temperaturaMedia = sumatorioTemperaturas / temperaturas.length

        alert("La temperatura media es de " + temperaturaMedia + " ºC")
    }
}
```

---

## 2. Sistema de Puntuación de un Videojuego

Escribe un programa que gestione las puntuaciones de los jugadores en un videojuego utilizando dos arrays: uno para los nombres de los jugadores y otro para sus respectivas puntuaciones. El programa debe funcionar de la siguiente manera:

1. **Crea dos arrays**:
   - Uno para almacenar los nombres de los últimos 5 jugadores.
   - Otro para almacenar las puntuaciones correspondientes de esos jugadores.

2. El programa debe mostrar un menú con las siguientes opciones:
   - **Añadir un nuevo jugador y su puntuación**: El usuario debe poder ingresar el nombre del jugador y su puntuación. La información del jugador más antiguo (el primer elemento de ambos arrays) debe ser eliminada y los nuevos datos deben añadirse al final de ambos arrays.
   - **Mostrar los jugadores y sus puntuaciones actuales**: Se deben mostrar los nombres de los jugadores junto con sus respectivas puntuaciones.
   - **Salir del programa**: Terminar la ejecución del programa.

3. **Ejecución continua**: El programa debe seguir ejecutándose hasta que el usuario seleccione la opción de salir.

#### Ejemplo de arrays iniciales:
```javascript
const jugadores = ["Jugador1", "Jugador2", "Jugador3", "Jugador4", "Jugador5"]
const puntuaciones = [120, 200, 150, 180, 220]
```

*Solución:*
```javascript
const jugadores = ["Jugador1", "Jugador2", "Jugador3", "Jugador4", "Jugador5"]
const puntuaciones = [120, 200, 150, 180, 220]

let opcion

while (opcion !== "3") {

    opcion = prompt("1. Añadir jugador
2. Ver jugadores
3. Salir")

    if (opcion === "1") {
        let nombreJugadorNuevo = prompt("Introduce el nombre del nuevo jugador:")
        let puntuacionJugadorNuevo = Number(prompt("Introduce la puntuación del nuevo jugador:"))

        jugadores.shift()
        puntuaciones.shift()

        jugadores.push(nombreJugadorNuevo)
        puntuaciones.push(puntuacionJugadorNuevo)

    } else if (opcion === "2") {
        console.log("Jugador - Puntuación")
        for (let i = 0; i < jugadores.length; i++) {
            console.log(jugadores[i] + " - " + puntuaciones[i])
        }
    }
}
```

---

## 3. Sistema de Compras en Almacén

Desarrolla un programa que gestione las compras en un almacén. Para esto:

1. Crea un array que contenga los nombres de 10 productos disponibles en el almacén.
2. Crea otro array que contenga los precios correspondientes a esos 10 productos.
3. El programa debe permitir al usuario realizar una compra solicitando el nombre del producto y la cantidad deseada.
4. El programa debe buscar el precio del producto seleccionado, multiplicarlo por la cantidad y añadirlo al total de la compra.
5. Si el usuario escribe "FIN", el programa debe finalizar la compra, mostrando un resumen con todos los productos adquiridos, sus cantidades, y el costo total a pagar.

*Solución:*
```javascript
const productos = ["Manzanas", "Plátanos", "Leche", "Pan", "Huevos", "Azúcar", "Harina", "Arroz", "Pasta", "Café"]
const precios = [1.20, 0.80, 1.50, 1.00, 2.00, 1.10, 0.90, 0.70, 1.30, 3.00]

let productoUsuario
let cantidadProducto
let subtotal
let total = 0

while (productoUsuario !== "FIN") {
    productoUsuario = prompt("Introduzca el nombre del producto:")

    if (productoUsuario !== "FIN") {
        cantidadProducto = Number(prompt("Introduzca la cantidad comprada:"))

        let encontrado = false
        for (let i = 0; i < productos.length && !encontrado; i++) {
            if (productos[i] === productoUsuario) {
                encontrado = true
                subtotal = precios[i] * cantidadProducto
                total += subtotal

                console.log(productoUsuario + " - " + cantidadProducto + ": " + subtotal + "€")
            }
        }
    }
}

console.log("TOTAL: " + total + "€")
```

---

## 4. Gestión de Inventario de una Librería

Escribe un programa que permita al usuario gestionar el inventario de una librería. El programa debe usar dos arrays: uno para almacenar los títulos de los libros y otro para almacenar las cantidades disponibles de cada libro. El usuario debe poder realizar las siguientes acciones a través de un menú:

1. Añadir un nuevo libro al inventario (con su título y cantidad).
2. Actualizar la cantidad de un libro existente.
3. Ver el inventario completo (título y cantidad de cada libro).
4. Salir del programa.

El programa debe actualizar el inventario según las acciones del usuario y seguir ejecutándose hasta que se elija la opción de salir.

*Solución:*
```javascript
const libros = ["El quijote", "La Biblia", "Manual de resistencia", "La criada"]
const cantidades = [5, 3, 1, 7]

let opcion

while (opcion !== "4") {
    opcion = prompt("1. Añadir un nuevo libro.
2. Actualizar cantidad.
3. Ver inventario.
4. Salir.")

    if (opcion === "1") {
        let libroNuevo = prompt("Introduzca el nombre del libro:")
        let cantidadLibroNuevo = Number(prompt("Cantidad disponible:"))

        libros.push(libroNuevo)
        cantidades.push(cantidadLibroNuevo)

    } else if (opcion === "2") {

        let libroActualizado = prompt("Nombre del libro a actualizar:")
        let cantidadLibroActualizado = Number(prompt("Nueva cantidad:"))

        let encontrado = false

        for (let i = 0; i < libros.length && !encontrado; i++) {
            if (libros[i] === libroActualizado) {
                encontrado = true
                cantidades[i] = cantidadLibroActualizado
            }
        }

        if (!encontrado) {
            alert("Libro no encontrado")
        }

    } else if (opcion === "3") {

        console.log("Inventario:")
        for (let i = 0; i < libros.length; i++) {
            console.log(libros[i] + " - " + cantidades[i] + " unidades")
        }
    }
}
```

---

## 5. Sistema de Registro de Calificaciones

Desarrolla un programa que permita registrar y gestionar las calificaciones de los estudiantes en una clase. Usa dos arrays: uno para los nombres de los estudiantes y otro para sus calificaciones. El programa debe ofrecer al usuario un menú con las siguientes opciones:

1. Añadir un estudiante y su calificación.
2. Mostrar la calificación promedio de la clase.
3. Mostrar la calificación más alta y el nombre del estudiante correspondiente.
4. Mostrar la calificación más baja y el nombre del estudiante correspondiente.
5. Salir del programa.

*Solución:*
```javascript
const nombres = []
const calificaciones = []

let opcion

while (opcion !== "5") {
    opcion = prompt("1. Añadir estudiante.
2. Ver media.
3. Nota más alta.
4. Nota más baja.
5. Salir.")

    if (opcion === "1") {
        let nombreNuevo = prompt("Nombre del alumno:")
        let notaNueva = Number(prompt("Calificación del alumno:"))

        nombres.push(nombreNuevo)
        calificaciones.push(notaNueva)

    } else if (opcion === "2") {
        let suma = 0

        for (let i = 0; i < calificaciones.length; i++) {
            suma += calificaciones[i]
        }

        console.log("La media es " + (suma / calificaciones.length))

    } else if (opcion === "3") {

        let max = calificaciones[0]
        let nombreMax = nombres[0]

        for (let i = 1; i < calificaciones.length; i++) {
            if (calificaciones[i] > max) {
                max = calificaciones[i]
                nombreMax = nombres[i]
            }
        }

        console.log("Máxima calificación: " + nombreMax + " (" + max + ")")

    } else if (opcion === "4") {

        let min = calificaciones[0]
        let nombreMin = nombres[0]

        for (let i = 1; i < calificaciones.length; i++) {
            if (calificaciones[i] < min) {
                min = calificaciones[i]
                nombreMin = nombres[i]
            }
        }

        console.log("Mínima calificación: " + nombreMin + " (" + min + ")")
    }
}
```

---

## 6. Sistema de Seguimiento de Tareas

Desarrolla un programa que permita hacer un seguimiento de las tareas diarias de un equipo. El programa debe usar dos arrays: uno para almacenar los nombres de las tareas y otro para almacenar el estado de cada tarea (*true* = completada y *false* = pendiente). El menú del programa debe ofrecer las siguientes opciones:

1. Añadir una nueva tarea.
2. Marcar una tarea como completada.
3. Ver la lista de tareas pendientes.
4. Ver la lista de tareas completadas.
5. Salir del programa.

*Solución:*
```javascript
const tareas = ["tarea1", "tarea2", "tarea3"]
const completadas = [false, true, false]

let opcion

while (opcion !== "5") {
    opcion = prompt("1. Añadir tarea.
2. Marcar completada.
3. Ver pendientes.
4. Ver completadas.
5. Salir.")

    if (opcion === "1") {
        let nueva = prompt("Nueva tarea:")
        tareas.push(nueva)
        completadas.push(false)

    } else if (opcion === "2") {
        let buscar = prompt("Nombre de la tarea:")
        let encontrado = false

        for (let i = 0; i < tareas.length && !encontrado; i++) {
            if (tareas[i] === buscar) {
                encontrado = true
                completadas[i] = true
            }
        }

        if (!encontrado) console.log("No encontrada")

    } else if (opcion === "3") {
        let pendientes = []

        for (let i = 0; i < completadas.length; i++) {
            if (!completadas[i]) pendientes.push(tareas[i])
        }

        console.log("Pendientes: " + pendientes)

    } else if (opcion === "4") {
        let hechas = []

        for (let i = 0; i < completadas.length; i++) {
            if (completadas[i]) hechas.push(tareas[i])
        }

        console.log("Completadas: " + hechas)
    }
}
```

---

## 7. Control de Gastos Mensuales

Escribe un programa que permita al usuario llevar un control de sus gastos mensuales. Usa dos arrays: uno para los nombres de los gastos (por ejemplo, "comida", "transporte", etc.) y otro para las cantidades gastadas en cada categoría. El programa debe mostrar un menú con las siguientes opciones:

1. Añadir un nuevo gasto (nombre y cantidad).
2. Ver el total de gastos hasta el momento.
3. Ver los gastos más altos y más bajos del mes.
4. Ver el promedio de gasto diario (suponiendo un mes de 30 días).
5. Salir del programa.

*Solución:*
```javascript
const nombreGastos = []
const cantidadGastos = []

let opcion

while (opcion !== "5") {
    opcion = prompt("1. Añadir gasto.
2. Ver total.
3. Ver máximo y mínimo.
4. Promedio diario.
5. Salir.")

    if (opcion === "1") {
        let nombre = prompt("Nombre del gasto:")
        let cantidad = Number(prompt("Cantidad:"))

        nombreGastos.push(nombre)
        cantidadGastos.push(cantidad)

    } else if (opcion === "2") {
        let total = 0
        for (let i = 0; i < cantidadGastos.length; i++) total += cantidadGastos[i]
        console.log("Total: " + total + "€")

    } else if (opcion === "3") {

        let posMax = 0
        let posMin = 0

        for (let i = 1; i < cantidadGastos.length; i++) {
            if (cantidadGastos[i] > cantidadGastos[posMax]) posMax = i
            if (cantidadGastos[i] < cantidadGastos[posMin]) posMin = i
        }

        console.log("Mayor: " + nombreGastos[posMax] + " - " + cantidadGastos[posMax] + "€")
        console.log("Menor: " + nombreGastos[posMin] + " - " + cantidadGastos[posMin] + "€")

    } else if (opcion === "4") {
        let total = 0
        for (let i = 0; i < cantidadGastos.length; i++) total += cantidadGastos[i]
        console.log("Promedio diario: " + (total / 30))
    }
}
```

---

## 8. Gestión de Reservas de un Restaurante

Escribe un programa para gestionar las reservas en un restaurante. Usa dos arrays: uno para los nombres de los clientes que han hecho una reserva y otro para almacenar el número de personas que cada cliente ha reservado. El programa debe mostrar un menú con las siguientes opciones:

1. Añadir una nueva reserva (nombre del cliente y número de personas).
2. Ver la lista de reservas actuales.
3. Calcular el total de personas reservadas para ese día.
4. Cancelar una reserva existente (por nombre del cliente).
5. Salir del programa.

*Solución:*
```javascript
const nombreReservas = ["Laura", "Victoria", "Pedro", "Alejandro"]
const cantidadPersonas = [2, 5, 3, 7]

let opcion

while (opcion !== "5") {
    opcion = prompt("1. Añadir reserva.
2. Ver reservas.
3. Total personas.
4. Cancelar.
5. Salir.")

    if (opcion === "1") {

        let nombre = prompt("Nombre:")
        let personas = Number(prompt("Número de personas:"))

        nombreReservas.push(nombre)
        cantidadPersonas.push(personas)

    } else if (opcion === "2") {

        console.log("Reservas:")
        for (let i = 0; i < nombreReservas.length; i++) {
            console.log(nombreReservas[i] + " - " + cantidadPersonas[i])
        }

    } else if (opcion === "3") {

        let total = 0
        for (let i = 0; i < cantidadPersonas.length; i++) total += cantidadPersonas[i]

        console.log("Total personas: " + total)

    } else if (opcion === "4") {
        let nombre = prompt("Nombre a cancelar:")

        let encontrado = false
        for (let i = 0; i < nombreReservas.length && !encontrado; i++) {
            if (nombreReservas[i] === nombre) {
                encontrado = true
                nombreReservas[i] = nombreReservas.pop()
                cantidadPersonas[i] = cantidadPersonas.pop()
            }
        }
    }
}
```

