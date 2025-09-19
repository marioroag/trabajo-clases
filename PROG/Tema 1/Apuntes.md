19/09/25

# UD: 1 - Introducción a la Programacion en JS
(Puntos 1 y 2 los saltamos)

## 3. Tipos de Datos y Variables en JavaScript

### 3.1 Tipos de Datos
- string: cadenas de texto, se crean entre comillas ''
- int: Numeros enteros
- float: umeros con decimales
- boolean: Verdadero (1) o Falso (0)
```js
let nombre = 'Mario'
let edad = 21 // int
let altura = 1.85 // float
let esEstudiante = true //boolean
```

### 3.2 Variables
Reglas basicas de nomenclatura en variables:
- Mantener la coherencia
- Para nombrar variables se debe empezar con una letra, '_' o '$'
- No usar espacios al nombre variables, ej validos: 'nombreUsuario, nombre_usuario'
- No usar palabras reservadas, ej: 'while, if, for...'
- Evitar nombre genericos que podrian repetirse en el futuro y generar problemas

### Declaracion de Variables
```js
let edad = 25  // Declaración con let
const nombre = "Ana"  // Declaración de constante
var pais = "España"  // Declaración con var
```

#### Operaciones modulo (REPASAR ESTO)
se identifican en programacion con el simbolo '%', calculan el resto

## 4. Entrada y Salida de Datos en JavaScript

### 4.1 Funciones de Entrada: prompt()
- Sirve para que el user proporcione input a una variable
```js
let nombre = prompt('Como te llamas: ')
```
- Si esperamos que el user nos de un número tenemos que usar antes Number()
```js
let numero = Number(prompt('Número: '))
```

### 4.2 Funciones de Salida: console.log()
- Muestra mensajes en la consola, útil para depuración, ver el estado de variables o resultados intermedios del programa
**Ejemplo:**
```js
<script>
    // Permite al usuario dar input en la variable 'nombre'
    let nombre = prompt('Introduzca su nombre de usuario')
    // La variable 'nombre' se imprime en consola
    console.log('Hola ' + nombre + '!')
</script>
```

### 4.3 Operaciones en JavaScript

#### Op. aritméticas:
- **Suma (`+`)**: Adiciona dos números.
  ```javascript
  let suma = 10 + 5  // Resultado: 15
  ```

- **Resta (`-`)**: Resta un número de otro.
  ```javascript
  let resta = 10 - 5  // Resultado: 5
  ```

- **Multiplicación (`*`)**: Multiplica dos números.
  ```javascript
  let multiplicacion = 10 * 5  // Resultado: 50
  ```

- **División (`/`)**: Divide un número por otro.
  ```javascript
  let division = 10 / 2  // Resultado: 5
  ```

- **Módulo (`%`)**: Devuelve el resto de una división.
  ```javascript
  let modulo = 10 % 3  // Resultado: 1
  ```

Cuando necesitas hacer operaciones matemáticas con los datos ingresados por el usuario, es imprescindible convertir esas cadenas a números.

### 4.3 Conversión entre Tipos de Datos