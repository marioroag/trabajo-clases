[text](vscode-local:/c%3A/Users/paco/Documents/stem-pruebas/Temario/SI/901%20CURSO%2023-25/001%20UNIDADES%20DID%C3%81CTICAS/UD5.md)# **Unidad Didáctica 5: Funciones en Bash**  

---

## **1. Introducción a las Funciones en Bash**  

Las funciones en Bash permiten agrupar bloques de código que se pueden reutilizar en diferentes partes de un script. Esto facilita la organización, reduce la repetición de código y hace que los scripts sean más legibles y fáciles de mantener.  

Al igual que en otros lenguajes de programación, una función puede recibir argumentos y devolver valores. Las funciones ayudan a dividir scripts largos en secciones más manejables, promoviendo la reutilización de código.  

---

## **2. Declaración y Uso de Funciones**  

Las funciones son bloques de código reutilizables que permiten organizar mejor los scripts de Bash. Al encapsular instrucciones en funciones, se mejora la legibilidad del código, se reduce la duplicidad y se facilita el mantenimiento.  

Una función puede realizar tareas específicas, como imprimir un mensaje, realizar cálculos o procesar archivos, y se puede invocar múltiples veces durante la ejecución del script.  

### **2.1. Sintaxis Básica**  

La declaración de una función en Bash sigue una sintaxis sencilla y directa:  

```bash
nombre_de_la_funcion() {
  # Bloque de comandos
}
```  

- **`nombre_de_la_funcion`** – Es el identificador de la función. El nombre debe ser descriptivo y seguir las convenciones de Bash (letras minúsculas y sin espacios).  
- **`{ }`** – Las llaves encierran el bloque de comandos que se ejecutará cuando se invoque la función.  
- **`# Bloque de comandos`** – Instrucciones que se ejecutarán cuando se llame a la función.  

**Para llamar a una función, simplemente escribe su nombre en el script:**  

```bash
nombre_de_la_funcion
```  

- Cuando Bash encuentra el nombre de una función, ejecuta las instrucciones definidas en el bloque de comandos.  
- Las funciones deben **declararse antes de ser llamadas**. Si intentas llamar a una función que aún no ha sido definida, Bash mostrará un error.  

**Ejemplo simple de declaración y llamada:**  

```bash
#!/bin/bash

mostrar_mensaje() {
  echo "Este es un mensaje desde la función."
}

mostrar_mensaje
```  

**Explicación:**  
- Se define la función `mostrar_mensaje` que imprime un texto.  
- El script llama a la función escribiendo `mostrar_mensaje` después de su definición.  
- Cuando se ejecuta el script, Bash invoca la función y muestra el mensaje en la terminal.  

**Resultado esperado:**  
```
Este es un mensaje desde la función.
```  

### **2.2. Ejemplo de Función Simple**  

Vamos a crear una función más detallada que simule un saludo personalizado:  

```bash
#!/bin/bash

saludo() {
  echo "¡Hola! Bienvenido al sistema."
}

saludo  # Llamada a la función
```  

**Análisis paso a paso:**  
1. **Definición de la función:**  
   - Se declara la función `saludo` usando la palabra clave `saludo()`.  
   - Dentro de la función, `echo` imprime el texto `"¡Hola! Bienvenido al sistema."` cada vez que se llama.  

2. **Llamada a la función:**  
   - Al escribir `saludo` fuera del bloque de la función, esta se ejecuta, y el texto se imprime en la terminal.  

**Salida esperada:**  
```
¡Hola! Bienvenido al sistema.
```  

### **2.3. Función con Retorno de Valores**  

En Bash, a diferencia de otros lenguajes de programación, las funciones no devuelven valores directamente usando `return`. Sin embargo, se puede lograr un comportamiento similar usando `echo` o asignando el resultado de la función a una variable.  

**Ejemplo: Sumar dos números con retorno de valor mediante `echo`**  

```bash
#!/bin/bash

sumar() {
  resultado=$(( $1 + $2 ))  # Sumar los valores de $1 y $2
  echo $resultado  # Devolver el resultado
}

suma=$(sumar 5 3)
echo "La suma es: $suma"
```  

**Desglose del código:**  
1. **Definición de la función `sumar`:**  
   - La función toma **dos argumentos** (`$1` y `$2`) que se pasan al llamarla.  
   - Los valores de los argumentos se suman y el resultado se almacena en la variable `resultado`.  
   - `echo` imprime el resultado, lo que permite que se capture en el contexto exterior.  

2. **Llamada y almacenamiento del resultado:**  
   - La función `sumar` se invoca con los valores `5` y `3` (`sumar 5 3`).  
   - La salida de la función se captura usando `$( )` y se asigna a la variable `suma`.  

3. **Impresión del resultado:**  
   - `echo "La suma es: $suma"` imprime el valor almacenado en la variable `suma`.  

**Resultado esperado:**  
```
La suma es: 8
```  

---

## **3. Uso de Argumentos en Funciones**  

Las funciones en Bash pueden aceptar argumentos que permiten personalizar su comportamiento y hacerlas más dinámicas. Los argumentos se pasan durante la llamada a la función y se pueden utilizar dentro de ella para modificar su ejecución según las necesidades.  

Bash proporciona variables especiales que facilitan el acceso a los argumentos dentro de una función:  

- **`$1`** – Primer argumento pasado a la función.  
- **`$2`** – Segundo argumento pasado a la función.  
- **`$@`** – Lista de todos los argumentos recibidos.  
- **`$#`** – Número total de argumentos pasados a la función.  

Esto permite construir funciones versátiles que pueden recibir diferentes cantidades de datos sin necesidad de definir explícitamente cada argumento.  

### **3.1. Ejemplo de Función con Argumentos**  

**Supongamos que queremos crear una función que salude a un usuario y mencione un sistema operativo específico.**  

```bash
#!/bin/bash

saludar() {
  echo "Hola, $1. Bienvenido a $2."
}

saludar "Carlos" "Linux"
```  

**Explicación detallada:**  
1. **Definición de la función:**  
   - Se declara la función `saludar()`, que espera dos argumentos al ser llamada.  
   - `$1` representa el primer argumento (el nombre del usuario) y `$2` representa el segundo argumento (el sistema operativo).  

2. **Llamada a la función:**  
   - Se llama a la función con dos valores: `"Carlos"` y `"Linux"`.  
   - Estos valores reemplazan `$1` y `$2` respectivamente.  

3. **Resultado esperado:**  
   ```
   Hola, Carlos. Bienvenido a Linux.
   ```  

4. **Sin argumentos:**  
   - Si la función se llama sin argumentos, la salida será:  
     ```
     Hola, . Bienvenido a .
     ```  
   - No se muestra un error porque Bash simplemente deja los valores vacíos.  

### **3.2. Validar Argumentos dentro de una Función**  

En muchas situaciones, es importante validar que la función reciba el número adecuado de argumentos antes de ejecutar su lógica interna. Esto ayuda a evitar errores y proporciona una forma clara de advertir al usuario sobre el uso correcto de la función.  

**Ejemplo: Función para Calcular el Área de un Rectángulo**  

```bash
calcular_area() {
  if [ $# -ne 2 ]; then
    echo "Uso: calcular_area <base> <altura>"
    return 1
  fi
  area=$(( $1 * $2 ))
  echo "El área es: $area"
}

calcular_area 5 10
calcular_area 7
```  

**Desglose del código:**  

1. **Validación del número de argumentos:**  
   - La función `calcular_area` espera exactamente **dos argumentos** (base y altura).  
   - La condición `if [ $# -ne 2 ]` verifica si el número de argumentos (`$#`) es diferente de 2.  

2. **Mensaje de error:**  
   - Si el número de argumentos no es igual a 2, se muestra el siguiente mensaje:  
     ```
     Uso: calcular_area <base> <altura>
     ```  
   - La función termina prematuramente con `return 1`, lo que indica que ocurrió un error.  

3. **Cálculo del área:**  
   - Si se reciben exactamente dos argumentos, la función calcula el área (`base * altura`) y muestra el resultado usando `echo`.  

**Resultados esperados:**  
1. **Llamada con dos argumentos válidos:**  
   ```bash
   calcular_area 5 10
   ```  
   **Salida:**  
   ```
   El área es: 50
   ```  

2. **Llamada con un solo argumento:**  
   ```bash
   calcular_area 7
   ```  
   **Salida:**  
   ```
   Uso: calcular_area <base> <altura>
   ```  

3. **Llamada sin argumentos:**  
   ```bash
   calcular_area
   ```  
   **Salida:**  
   ```
   Uso: calcular_area <base> <altura>
   ```  

### **3.3. Uso de `$@` y `$#` en Funciones**  

- **`$@`** – Se utiliza para iterar sobre todos los argumentos pasados a la función, lo que resulta útil si la cantidad de argumentos es variable.  
- **`$#`** – Indica cuántos argumentos recibió la función, permitiendo implementar validaciones y bucles dinámicos.  

**Ejemplo: Iterar sobre Argumentos y Mostrar Cada Uno**  

```bash
mostrar_argumentos() {
  echo "Número de argumentos: $#"
  for arg in "$@"; do
    echo "Argumento: $arg"
  done
}

mostrar_argumentos "Archivo1" "Archivo2" "Archivo3"
```  

**Explicación:**  
1. **Conteo de argumentos:**  
   - `echo "Número de argumentos: $#" ` muestra el total de argumentos recibidos.  
2. **Iteración con `for`:**  
   - `for arg in "$@"` recorre cada argumento y lo imprime uno por uno.  

**Resultado esperado:**  
```
Número de argumentos: 3
Argumento: Archivo1
Argumento: Archivo2
Argumento: Archivo3
```  

### **3.4. Combinando Validación y Argumentos Múltiples**  

**Ejemplo Completo: Sumar una Lista de Números**  

```bash
sumar_numeros() {
  if [ $# -eq 0 ]; then
    echo "Uso: sumar_numeros <num1> <num2> ... <numN>"
    return 1
  fi
  
  suma=0
  for numero in "$@"; do
    suma=$(( suma + numero ))
  done
  echo "La suma total es: $suma"
}

sumar_numeros 4 8 15 16 23 42
sumar_numeros
```  

**Explicación:**  
- Si no se proporciona al menos un número, la función muestra un mensaje de error.  
- La función suma todos los argumentos usando un bucle `for` que recorre `"$@"`.  

**Resultados esperados:**  
1. **Con argumentos:**  
   ```
   La suma total es: 108
   ```  
2. **Sin argumentos:**  
   ```
   Uso: sumar_numeros <num1> <num2> ... <numN>
   ```  

---

## **4. Uso de `shift` para Gestionar Argumentos**  

El comando `shift` es una herramienta poderosa en Bash que permite manipular los argumentos pasados a una función o script. Al ejecutar `shift`, los argumentos se desplazan hacia la izquierda, eliminando el primer argumento (`$1`) y moviendo los demás:  

- **`$2` pasa a ser `$1`**  
- **`$3` pasa a ser `$2`**  
- **Así sucesivamente...**  

El uso de `shift` es especialmente útil cuando se necesita procesar una lista variable de argumentos de manera iterativa, permitiendo manejar cada uno por separado sin necesidad de referirse a índices específicos.  

### **4.1. Ejemplo de `shift` en una Función**  

Veamos cómo usar `shift` para procesar una lista de archivos, imprimiendo cada uno por separado:  

```bash
procesar_argumentos() {
  echo "Número de argumentos: $#"
  while [ $# -gt 0 ]; do
    echo "Procesando: $1"
    shift
  done
}

procesar_argumentos "archivo1.txt" "archivo2.txt" "archivo3.txt"
```  

**Explicación detallada:**  

1. **Definición de la función:**  
   - Se define la función `procesar_argumentos`, que espera recibir una lista de argumentos (en este caso, nombres de archivos).  

2. **Conteo inicial:**  
   - `echo "Número de argumentos: $#" ` muestra el número total de argumentos recibidos.  
   - `$#` es una variable especial que indica cuántos argumentos están disponibles.  

3. **Bucle `while` para iterar:**  
   - La condición `while [ $# -gt 0 ]` mantiene el bucle en ejecución mientras haya argumentos (es decir, mientras `$#` sea mayor que 0).  

4. **Procesamiento de cada argumento:**  
   - En cada iteración, `echo "Procesando: $1"` imprime el argumento actual (`$1`).  
   - A continuación, `shift` elimina el argumento procesado y mueve el siguiente a `$1`.  

5. **Repetición hasta finalizar:**  
   - El proceso continúa hasta que no quedan más argumentos.  

**Resultado esperado:**  
```
Número de argumentos: 3
Procesando: archivo1.txt
Procesando: archivo2.txt
Procesando: archivo3.txt
```  

Si se llaman más o menos argumentos, la función los procesará en la misma lógica sin necesidad de modificar el script.  

### **4.2. Función con `shift` para Sumar Números**  

`shift` también se puede utilizar para procesar números y realizar operaciones matemáticas iterativas, como sumar una lista de valores.  

**Ejemplo: Sumar Números Pasados como Argumentos**  

```bash
sumar_numeros() {
  suma=0
  while [ $# -gt 0 ]; do
    suma=$(( suma + $1 ))
    shift
  done
  echo "La suma total es: $suma"
}

sumar_numeros 4 8 15 16 23 42
```  

**Explicación paso a paso:**  

1. **Inicialización de variables:**  
   - Se define una variable `suma` y se inicializa en `0`.  

2. **Iteración con `while`:**  
   - El bucle `while` se ejecuta mientras haya argumentos (`$# > 0`).  
   - `suma=$(( suma + $1 ))` agrega el primer argumento al valor de `suma`.  

3. **Desplazamiento de argumentos con `shift`:**  
   - `shift` elimina el primer argumento procesado y desplaza el siguiente, repitiendo el ciclo hasta que no queden más valores.  

4. **Resultado final:**  
   - Una vez que todos los números se han sumado, el resultado se imprime con `echo`.  

**Resultado esperado:**  
```
La suma total es: 108
```  

**Si se pasa una lista diferente de números:**  
```bash
sumar_numeros 10 20 30
```  
**Salida esperada:**  
```
La suma total es: 60
```  

### **4.3. Manejo de Errores con `shift`**  

Si `shift` se ejecuta cuando no hay argumentos restantes, no causa un error crítico, pero puede dejar la variable `$1` vacía. Para evitar problemas, es recomendable validar la existencia de argumentos antes de usar `shift`.  

**Ejemplo con Validación:**  
```bash
procesar() {
  if [ $# -eq 0 ]; then
    echo "Error: No se han pasado argumentos."
    return 1
  fi

  while [ $# -gt 0 ]; do
    echo "Procesando: $1"
    shift
  done
}

procesar "dato1" "dato2"
procesar  # Llamada sin argumentos
```  

**Resultado esperado:**  
```
Procesando: dato1
Procesando: dato2
Error: No se han pasado argumentos.
```  

### **4.4. Ejemplo Completo: Copia de Archivos**  

Imaginemos un script que reciba una lista de archivos y los copie a una carpeta de respaldo:  

```bash
copiar_archivos() {
  destino="./respaldo"
  mkdir -p "$destino"
  
  if [ $# -eq 0 ]; then
    echo "Error: No se especificaron archivos para copiar."
    return 1
  fi
  
  while [ $# -gt 0 ]; do
    if [ -f "$1" ]; then
      cp "$1" "$destino"
      echo "$1 copiado a $destino"
    else
      echo "Error: $1 no existe."
    fi
    shift
  done
}

copiar_archivos "archivo1.txt" "archivo2.txt" "archivo_inexistente.txt"
```  

**Explicación:**  
- El script crea una carpeta `respaldo` si no existe (`mkdir -p`).  
- Copia cada archivo especificado como argumento.  
- Si el archivo no existe, se muestra un mensaje de error, pero el bucle continúa.  

**Resultado esperado:**  
```
archivo1.txt copiado a ./respaldo
archivo2.txt copiado a ./respaldo
Error: archivo_inexistente.txt no existe.
```  

### **Ventajas del Uso de `shift` en Funciones**  

1. **Procesamiento Dinámico:**  
   `shift` permite manejar una cantidad variable de argumentos sin necesidad de conocer su número exacto de antemano.  

2. **Flexibilidad:**  
   Las funciones pueden procesar datos en lotes o de forma iterativa sin modificar su estructura.  

3. **Simplicidad:**  
   Elimina la necesidad de bucles con contadores, haciendo que los scripts sean más concisos y fáciles de leer.  

4. **Gestión de Errores:**  
   `shift` se puede combinar con validaciones (`if` y `while`) para gestionar correctamente entradas incorrectas o incompletas.  

Con `shift`, tus scripts ganan flexibilidad y robustez, facilitando la creación de herramientas automatizadas y de propósito general.