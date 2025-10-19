# 🧠 MAPUNTES DE EXAMEN – LÓGICA Y PROGRAMACIÓN EN JAVASCRIPT

Guía definitiva para resolver cualquier ejercicio de examen de DAW sobre **condicionales** y **bucles** en JavaScript.

---

## ⚙️ 1. ESTRUCTURA BÁSICA DE UN PROGRAMA

### 🧩 Orden mental para resolver cualquier ejercicio
1. **Leer el enunciado y separar en partes:**
   - Qué datos pide el programa.
   - Qué debe hacer con ellos.
   - Cuándo termina o cambia el flujo.
2. **Elegir herramientas:**
   - Variables → guardar datos.
   - `if / else` → decidir cosas.
   - `for` o `while` → repetir acciones.
3. **Definir variables iniciales:**
   - Acumuladores → sumas o totales → `let suma = 0`
   - Contadores → número de repeticiones → `let contador = 0`
   - Centinelas → condiciones de parada → `let salir = false` o `while (valor != -1)`
4. **Diseñar el flujo:**
   - Entrada → Procesamiento → Salida.
5. **Verificar tipos:** siempre convertir con `Number()` si se espera número.

---

## 🔢 2. VARIABLES Y TIPOS

### 🧩 Declaración
```js
let edad = 20;
const PI = 3.14;
```
- Usa `let` para valores que cambian.
- Usa `const` para valores fijos.

### 🔁 Conversión de tipos
```js
let numero = Number(prompt('Introduce un número:'));
let texto = String(123);
```
- `prompt()` **siempre devuelve texto**, incluso si escribes un número.
- Convierte a número antes de operar o comparar magnitudes.

---

## 🧭 3. CONDICIONALES

### 🔹 Sintaxis general
```js
if (condición) {
  // se ejecuta si la condición es verdadera
} else if (otraCondición) {
  // se ejecuta si la anterior era falsa y esta es verdadera
} else {
  // se ejecuta si todas las anteriores son falsas
}
```

### 🔹 Comparadores
| Operador | Significado | Ejemplo |
|-----------|--------------|----------|
| `>` | Mayor que | `x > 5` |
| `<` | Menor que | `x < 10` |
| `>=` | Mayor o igual | `nota >= 5` |
| `<=` | Menor o igual | `edad <= 18` |
| `===` | Igual (valor y tipo) | `color === 'rojo'` |
| `!==` | Distinto (valor y tipo) | `x !== 0` |

### 🔹 Operadores lógicos
| Operador | Significado | Ejemplo |
|-----------|--------------|----------|
| `&&` | Y (ambas verdaderas) | `edad > 17 && edad < 65` |
| `||` | O (una verdadera) | `nota < 5 || nota > 10` |
| `!` | Negación | `!(x === 0)` |

### 🧠 Patrones comunes
- **Rango válido:**
  ```js
  if (valor >= -20 && valor <= 50)
  ```
- **Validación contraria:**
  ```js
  if (valor < -20 || valor > 50)
  ```
- **Par / impar:**
  ```js
  if (numero % 2 === 0)
  ```
- **Múltiplo:**
  ```js
  if (numero % 5 === 0)
  ```

### 🚫 Errores comunes
- Usar `=` en vez de `===` → cambia el valor, no lo compara.
- Comparar sin convertir → `'5' === 5` es `false`.
- Olvidar llaves `{}` cuando hay varias líneas en un `if`.

---

## 🔁 4. BUCLES

### 🔹 `for`
> Cuando **sabes cuántas veces** se repetirá algo.

```js
for (let i = 0; i < 10; i++) {
  console.log(i);
}
```
- `i` = contador.
- Primer bloque → inicio (`i = 0`).
- Segundo → condición (`mientras i < 10`).
- Tercero → incremento (`i++`).

### 🔹 `while`
> Cuando **no sabes cuántas veces** se repetirá.

```js
let numero = 0;
while (numero >= 0) {
  numero = Number(prompt('Introduce un número negativo para salir:'));
}
```
- Se ejecuta **mientras** la condición sea verdadera.

### 🔹 Bucle controlado por centinela
> Se repite hasta que el usuario introduzca un valor especial.

```js
let nota = 0;
let suma = 0;
let contador = 0;

while (nota !== -1) {
  nota = Number(prompt('Introduce una nota (-1 para salir):'));
  if (nota !== -1) {
    suma += nota;
    contador++;
  }
}
```

---

## 📊 5. ACUMULADORES Y CONTADORES

### 🧩 Conceptos clave
| Tipo | Uso | Ejemplo |
|------|-----|----------|
| **Acumulador** | Guarda una suma o total | `total += valor` |
| **Contador** | Aumenta el número de elementos procesados | `contador++` |

**Siempre inicialízalos a 0**.

```js
let suma = 0;
let contador = 0;
```

### 🧮 Calcular promedio
```js
let media = suma / contador;
```
Asegúrate de que `contador` no sea 0 antes de dividir.

---

## 🧱 6. ESTRUCTURAS REPETIDAS EN EXÁMENES

### 🔸 1. Bucle con valor centinela (`-1`, `SALIR`)
```js
let dato = '';
while (dato !== 'SALIR') {
  dato = prompt('Introduce un valor (SALIR para terminar):');
}
```

### 🔸 2. Validación de rango
```js
let valor = Number(prompt('Introduce una temperatura:'));
while (valor < -20 || valor > 50) {
  console.log('Temperatura incorrecta. Debe estar entre -20 y 50');
  valor = Number(prompt('Introduce una temperatura válida:'));
}
```

### 🔸 3. Control de saldo o recursos
```js
let saldo = 1000;
while (saldo > 0) {
  let retirada = Number(prompt('Saldo: ' + saldo + ' | Cantidad a retirar:'));
  if (retirada > saldo) {
    console.log('Saldo insuficiente');
  } else {
    saldo -= retirada;
  }
}
console.log('Te has quedado sin saldo');
```

### 🔸 4. Cálculo acumulativo hasta valor nulo o 0
```js
let total = 0;
let precio = -1;

while (precio !== 0) {
  precio = Number(prompt('Precio del producto (0 para terminar):'));
  total += precio;
}
console.log('Total: ' + total);
```

### 🔸 5. Validación con texto especial (“SALIR”)
```js
let salir = false;

while (!salir) {
  let dato = prompt('Introduce un número o escribe SALIR:');
  if (dato === 'SALIR') {
    salir = true;
  } else {
    let numero = Number(dato);
    console.log('Has introducido el número ' + numero);
  }
}
```

---

## 📐 7. FIGURAS Y BUCLES ANIDADOS

### 🧩 Pirámides y patrones visuales

#### Creciente simple
```js
let n = Number(prompt('Filas:'));
let linea = '';
for (let i = 0; i < n; i++) {
  linea += '*';
  console.log(linea);
}
```

#### Derecha alineada
```js
let n = Number(prompt('Filas:'));
for (let i = 1; i <= n; i++) {
  console.log(' '.repeat(n - i) + '*'.repeat(i));
}
```

#### Invertida
```js
let n = Number(prompt('Filas:'));
for (let i = n; i >= 1; i--) {
  console.log('*'.repeat(i));
}
```

### 💡 Concepto de bucle anidado
Un bucle **dentro de otro**: el interior se ejecuta completo cada vez que el exterior da una vuelta.

```js
for (let i = 1; i <= filas; i++) {
  let linea = '';
  for (let j = 1; j <= i; j++) {
    linea += '*';
  }
  console.log(linea);
}
```

---

## 🧠 8. ESTRATEGIA DE EXAMEN

### 🧩 Pasos al enfrentarte a cualquier ejercicio
1. **Identifica el tipo:**
   - ¿Tiene repeticiones? → bucle.
   - ¿Hay decisiones o límites? → if.
   - ¿Pide media, total, suma? → acumuladores.
2. **Detecta el fin del proceso:**
   - ¿Depende de un valor (`-1`, `0`, `SALIR`)?
   - ¿O es un número fijo de repeticiones (`for`)?
3. **Diseña las variables necesarias:**
   - Una para cada dato que se pide.
   - Una para cada cálculo (sumas, contadores, etc.).
4. **Crea la estructura del esqueleto:**
   ```js
   let variable;
   while (condición) {
       // pedir dato
       // validar
       // calcular
   }
   ```
5. **Prueba con un caso mental:**
   - Imagina los valores que introduce el usuario y verifica si se cumple el flujo.

### 🚨 Errores que más restan puntos
- No inicializar acumuladores o contadores → `NaN`.
- Olvidar convertir `prompt()` a número.
- Escribir `=` en vez de `===` en condiciones.
- Escribir mal los límites de bucle (`i <= n`, `i++`).
- No controlar división por cero (`contador` vacío).

---

## 🧩 9. CHULETAS RÁPIDAS

### 🔹 Inicializaciones típicas
```js
let suma = 0;
let contador = 0;
let salir = false;
let i = 0;
```

### 🔹 Validaciones de datos
```js
if (isNaN(valor)) {
  console.log('Valor no válido');
}
```

### 🔹 Formateo de salida
```js
console.log('Total: ' + total.toFixed(2) + '€');
```

### 🔹 Condiciones más comunes
| Situación | Condición |
|------------|------------|
| Salir con palabra | `dato === 'SALIR'` |
| Rango válido | `x >= min && x <= max` |
| Número positivo | `x >= 0` |
| Fin con -1 | `x !== -1` |

### 🔹 Operaciones útiles
| Tarea | Código |
|--------|--------|
| Redondear | `Math.round(x)` |
| Quitar decimales | `Math.floor(x)` |
| Resto | `x % y` |
| Repetir texto | `'texto'.repeat(n)` |
| Convertir texto a número | `Number(valor)` |

---

## 🧩 10. RESUMEN FINAL

> En cualquier ejercicio, piensa así:
> 1️⃣ ¿Qué datos me piden y cuántas veces? → elige `for` o `while`.
> 2️⃣ ¿Qué debo decidir? → `if / else`.
> 3️⃣ ¿Qué acumulo o cuento? → variables inicializadas a 0.
> 4️⃣ ¿Cuándo termina el programa? → condición o centinela.
> 5️⃣ ¿Qué muestro al final? → cálculos y `console.log()`.

Si dominas esas 5 preguntas, puedes construir cualquier ejercicio de examen.

---

✍️ **Consejo final de Profe Byte:**
> No intentes memorizar los ejercicios. Aprende a ver el patrón detrás: todos son combinaciones de *pedir → comprobar → acumular → mostrar*. Si entiendes el orden, puedes resolver cualquier variante.

