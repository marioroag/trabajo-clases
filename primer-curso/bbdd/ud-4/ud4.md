# **Unidad Didáctica 4: MySQL y Consultas Simples**  

## **1. Introducción a MySQL y Consultas Simples**  

MySQL es un sistema de gestión de bases de datos relacional (SGBD) que permite almacenar, gestionar y manipular datos mediante el lenguaje SQL (Structured Query Language). Es una herramienta fundamental en el desarrollo de aplicaciones web, sistemas empresariales y cualquier entorno que requiera una gestión estructurada de grandes volúmenes de información.  

Las consultas SQL permiten interactuar con las bases de datos para realizar operaciones de lectura (SELECT), escritura (INSERT), actualización (UPDATE) y eliminación (DELETE).  

En esta unidad se profundizará en consultas **simples** que trabajan con una sola tabla, sin realizar combinaciones (`JOIN`) con otras tablas.  

---

## **2. Consultas Básicas con `SELECT`**  

La instrucción `SELECT` es la base de cualquier consulta en SQL. Su objetivo es recuperar datos de una tabla. Se puede utilizar para seleccionar columnas específicas o todos los registros (`*`).  

**Sintaxis básica:**  
```sql
SELECT columna1, columna2 FROM nombre_tabla;
```  
Para seleccionar todos los campos:  
```sql
SELECT * FROM nombre_tabla;
```  
**Ejemplo:**  
```sql
SELECT id, nombre FROM empleados;
```  

---

## **3. Filtrado de Registros con `WHERE` y `DISTINCT`**  

La cláusula `WHERE` en MySQL es una de las herramientas más importantes y utilizadas para la gestión de datos. Permite aplicar **criterios de filtrado** sobre los registros devueltos por la instrucción `SELECT`. Gracias a `WHERE`, es posible limitar los resultados de una consulta a solo aquellos registros que cumplen ciertas condiciones, lo que optimiza la recuperación de datos y mejora la eficiencia en el análisis de información.  

Sin `WHERE`, `SELECT` devolvería **todos los registros** de una tabla, lo que podría resultar en grandes volúmenes de datos innecesarios. Al utilizar `WHERE`, podemos reducir el conjunto de resultados y centrarnos solo en los registros relevantes.  

Además, cuando se necesita evitar registros duplicados en los resultados, se puede utilizar el modificador **`DISTINCT`** en combinación con `SELECT`. `DISTINCT` garantiza que los resultados devueltos sean únicos, eliminando duplicados basados en las columnas especificadas.  

---

### **Sintaxis General**  
```sql
SELECT [DISTINCT] columnas FROM nombre_tabla WHERE condición;
```  

- **`DISTINCT`** se coloca inmediatamente después de `SELECT` para asegurar que solo se devuelvan valores únicos en las columnas especificadas.  
- La cláusula `WHERE` se aplica después para filtrar los resultados basados en condiciones específicas.  

#### **Ejemplo - Sin `DISTINCT` (Resultados con Duplicados):**  
```sql
SELECT departamento FROM empleados WHERE salario > 3000;
```  
Esto devolverá una lista con todos los departamentos donde los empleados ganan más de 3000, incluyendo departamentos repetidos si varios empleados cumplen la condición.  

#### **Ejemplo - Con `DISTINCT` (Resultados Únicos):**  
```sql
SELECT DISTINCT departamento FROM empleados WHERE salario > 3000;
```  
En este caso, se devolverá una lista de departamentos únicos donde al menos un empleado tiene un salario superior a 3000, eliminando duplicados.  

#### **Combinación de Múltiples Condiciones con `WHERE` y `DISTINCT`**  
Es posible combinar `DISTINCT` con condiciones complejas usando operadores lógicos como `AND`, `OR` y `NOT`.  

**Ejemplo - Departamentos con salarios altos y sede en Madrid:**  
```sql
SELECT DISTINCT departamento FROM empleados WHERE salario > 3000 AND ciudad = 'Madrid';
```  
Esta consulta devuelve una lista única de departamentos donde hay empleados con salarios superiores a 3000 y que trabajan en la ciudad de Madrid.   

#### **Importante:**  
- `DISTINCT` se aplica **a todas las columnas seleccionadas**. Si se seleccionan múltiples columnas, la combinación de valores debe ser única para que el registro se devuelva.  
- **Ejemplo:**  
```sql
SELECT DISTINCT nombre, departamento FROM empleados WHERE salario > 4000;
```  
Esto devolverá combinaciones únicas de `nombre` y `departamento`, pero puede incluir empleados con el mismo nombre en diferentes departamentos.  

### **Operadores de Comparación**  

Los operadores de comparación permiten establecer relaciones entre los valores de los campos y los criterios de búsqueda. Son esenciales para realizar filtrados precisos.  

- **`=`** – **Igual a:** Devuelve los registros donde el valor de la columna es exactamente igual al valor especificado.  
- **`!=` o `<>`** – **Diferente de:** Devuelve los registros donde el valor de la columna es distinto al valor especificado.  
- **`>`** – **Mayor que:** Devuelve los registros donde el valor de la columna es mayor que el valor indicado.  
- **`<`** – **Menor que:** Devuelve los registros donde el valor de la columna es menor que el valor especificado.  
- **`>=`** – **Mayor o igual que:** Devuelve los registros donde el valor de la columna es mayor o igual al valor indicado.  
- **`<=`** – **Menor o igual que:** Devuelve los registros donde el valor de la columna es menor o igual al valor especificado.  

**Ejemplo - Filtrado por salario mayor que un umbral:**  
```sql
SELECT * FROM empleados WHERE salario > 4000;
```  
Esto devolverá únicamente los registros de los empleados cuyo salario sea superior a 4000.  

**Ejemplo - Filtrado por igualdad:**  
```sql
SELECT * FROM clientes WHERE ciudad = 'Madrid';
```  
Aquí se seleccionan los clientes que residen en la ciudad de Madrid.  

### **Operadores Lógicos**  

Los operadores lógicos permiten **combinar múltiples condiciones** en una misma cláusula `WHERE`, proporcionando un filtrado más avanzado.  

- **`AND`** – Ambas condiciones deben cumplirse para que el registro sea devuelto.  
- **`OR`** – Al menos una de las condiciones debe cumplirse.  
- **`NOT`** – Niega la condición especificada, devolviendo los registros donde la condición no se cumple.  

**Ejemplo - Uso de `AND`:**  
```sql
SELECT * FROM empleados WHERE salario > 3000 AND edad < 40;
```  
Este ejemplo devuelve empleados con un salario superior a 3000 y que tienen menos de 40 años.  

**Ejemplo - Uso de `OR`:**  
```sql
SELECT * FROM empleados WHERE departamento = 'Ventas' OR departamento = 'Marketing';
```  
Devuelve los empleados que trabajan en los departamentos de Ventas o Marketing.  

**Ejemplo - Uso de `NOT`:**  
```sql
SELECT * FROM empleados WHERE NOT departamento = 'Recursos Humanos';
```  
Devuelve todos los empleados que **no** pertenecen al departamento de Recursos Humanos.  

### **Operadores de Patrón y Rango**  

#### **1. `LIKE` (Coincidencia Parcial)**  

El operador `LIKE` permite buscar valores que cumplan con patrones específicos. Es útil cuando no se conoce exactamente el valor a buscar o cuando se desea encontrar registros con una coincidencia parcial.  

- **`%`** – Representa **cualquier número de caracteres** (incluyendo cero caracteres).  
- **`_`** – Representa **un solo carácter**.  

**Ejemplo - Nombres que comienzan con 'M':**  
```sql
SELECT * FROM empleados WHERE nombre LIKE 'M%';
```  
Selecciona todos los empleados cuyos nombres comienzan con la letra 'M'.  

**Ejemplo - Nombres que terminan con 'ez':**  
```sql
SELECT * FROM clientes WHERE apellido LIKE '%ez';
```  
Devuelve clientes con apellidos que terminan en 'ez', como 'López' o 'Gómez'.  

**Ejemplo - Nombres que contienen 'an' en cualquier posición:**  
```sql
SELECT * FROM empleados WHERE nombre LIKE '%an%';
```  

**Ejemplo - Nombres con cuatro letras y que terminan en 'o':**  
```sql
SELECT * FROM empleados WHERE nombre LIKE '___o';
```  

#### **2. `IN` (Lista de Valores)**  

El operador `IN` permite verificar si un valor pertenece a una lista específica. Es más eficiente y legible que utilizar múltiples condiciones con `OR`.  

**Ejemplo - Filtrado por lista de IDs:**  
```sql
SELECT * FROM empleados WHERE id IN (1, 3, 5, 7);
```  
Devuelve los empleados cuyos IDs sean 1, 3, 5 o 7.  

**Ejemplo - Selección de múltiples departamentos:**  
```sql
SELECT * FROM empleados WHERE departamento IN ('Ventas', 'Finanzas', 'IT');
```  

#### **3. `BETWEEN` (Rango de Valores)**  

`BETWEEN` permite seleccionar registros cuyos valores se encuentran dentro de un rango determinado, **incluyendo los límites del rango**.  

**Ejemplo - Filtrado por rango de salarios:**  
```sql
SELECT * FROM empleados WHERE salario BETWEEN 2500 AND 5000;
```  
Este ejemplo selecciona empleados cuyos salarios estén entre 2500 y 5000 (inclusive).  

**Ejemplo - Filtrado por fechas:**  
```sql
SELECT * FROM pedidos WHERE fecha_pedido BETWEEN '2023-01-01' AND '2023-12-31';
```  
Devuelve los pedidos realizados durante el año 2023.  

### **Consideraciones**  

- **Orden de Evaluación**:  
  Cuando se combinan `AND` y `OR` en una misma consulta, `AND` tiene mayor prioridad. Esto significa que las condiciones con `AND` se evalúan antes que las condiciones con `OR`, a menos que se utilicen paréntesis.  

**Ejemplo:**  
```sql
SELECT * FROM empleados WHERE departamento = 'Ventas' AND (edad > 30 OR salario > 5000);
```  

- **Filtrado de Nulos (`IS NULL`)**:  
  Para buscar registros con valores nulos en una columna, se debe utilizar `IS NULL` o `IS NOT NULL`.  

**Ejemplo:**  
```sql
SELECT * FROM empleados WHERE telefono IS NULL;
```  
Esto selecciona empleados sin número de teléfono registrado.  

**Ejemplo de registros no nulos:**  
```sql
SELECT * FROM empleados WHERE telefono IS NOT NULL;
```  

---

## **4. Ordenación de Resultados con `ORDER BY`**  

La cláusula `ORDER BY` en MySQL proporciona la capacidad de organizar los resultados de una consulta en función de los valores de una o más columnas. Esto es fundamental para estructurar la salida de datos de manera coherente y facilitar su análisis.  

Cuando se realiza una consulta `SELECT`, los registros devueltos no están garantizados en ningún orden específico a menos que se utilice explícitamente `ORDER BY`. Esta cláusula permite definir un criterio de ordenación, lo que es esencial en informes, listados de clientes, productos o cualquier conjunto de datos que deba mostrarse de forma estructurada.  

---

### **Sintaxis General**  
```sql
SELECT columnas FROM nombre_tabla  
ORDER BY columna1 [ASC | DESC], columna2 [ASC | DESC];
```  

- **`ASC` (Ascendente):** Ordena los registros del valor más bajo al más alto. Es el comportamiento predeterminado, por lo que si no se especifica `ASC` o `DESC`, se asume ascendente.  
- **`DESC` (Descendente):** Ordena los registros del valor más alto al más bajo.  

---

### **Ordenación por una Columna**  
```sql
SELECT * FROM empleados ORDER BY salario DESC;
```  
Este ejemplo ordena los registros de la tabla `empleados` por el campo `salario` en orden descendente, mostrando primero los empleados con salarios más altos.  

Si se quisiera ordenar por salario en orden ascendente, el mismo ejemplo se escribiría así:  
```sql
SELECT * FROM empleados ORDER BY salario ASC;
```  

---

### **Ordenación por Múltiples Columnas**  
Es posible ordenar por varias columnas. En este caso, la ordenación se realiza primero por la primera columna especificada y, en caso de empate, por la segunda columna, y así sucesivamente.  

**Ejemplo - Ordenar por departamento y luego por salario (ascendente):**  
```sql
SELECT * FROM empleados ORDER BY departamento ASC, salario DESC;
```  
Esto organiza a los empleados por departamento en orden alfabético y, dentro de cada departamento, por salario en orden descendente.  

---

### **Ordenar por Campos Calculados o Alias**  
También se puede ordenar por columnas que no existen directamente en la tabla, pero que se generan a partir de cálculos o alias en la consulta.  

**Ejemplo - Ordenar por longitud del nombre:**  
```sql
SELECT nombre, CHAR_LENGTH(nombre) AS longitud  
FROM empleados  
ORDER BY longitud DESC;
```  
Este ejemplo ordena los empleados por la longitud de sus nombres, mostrando primero los más largos.  

---

### **Ordenación con Valores Nulos (`NULLS` Handling)**  
MySQL por defecto coloca los valores `NULL` al principio de una ordenación ascendente y al final en una ordenación descendente.  

**Ejemplo - Ordenar clientes por número de teléfono (posicionando `NULL` al final):**  
```sql
SELECT * FROM clientes ORDER BY telefono IS NULL, telefono;
```  
Esto moverá todos los valores `NULL` al final, mientras que los valores no nulos se ordenan en orden ascendente.  

---

## **5. Limitación de Resultados con `LIMIT`**  

La cláusula `LIMIT` restringe el número de registros devueltos por una consulta `SELECT`. Es útil en situaciones donde solo se necesita una muestra de datos o cuando se implementa paginación en una aplicación.  

---

### **Sintaxis General**  
```sql
SELECT columnas FROM nombre_tabla  
ORDER BY columna1  
LIMIT cantidad_filas [OFFSET inicio];
```  

- **`cantidad_filas`**: Define el número máximo de registros que se devolverán.  
- **`OFFSET inicio`** (opcional): Especifica desde qué posición iniciar la selección. Si no se define, el valor predeterminado es 0.  

---

### **Ejemplos Prácticos**  

**Seleccionar los 5 empleados con los salarios más altos:**  
```sql
SELECT * FROM empleados  
ORDER BY salario DESC  
LIMIT 5;
```  

**Implementar paginación - Seleccionar los empleados del 6 al 10:**  
```sql
SELECT * FROM empleados  
ORDER BY fecha_ingreso DESC  
LIMIT 5 OFFSET 5;
```  

Esto selecciona 5 registros comenzando desde el sexto resultado (es decir, saltando los primeros 5).  

---

### **Aplicaciones Comunes de `LIMIT`**  
- Obtener los 10 productos más vendidos.  
- Mostrar los 5 clientes más recientes.  
- Paginar resultados en una interfaz web.  

---

## **6. Funciones de Agregación**  

Las funciones de agregación son herramientas clave en SQL que permiten realizar cálculos sobre un conjunto de registros y devolver un único valor. Estas funciones son fundamentales para generar informes y realizar análisis de datos.  

---

### **Principales Funciones de Agregación**  

- **`COUNT()`**: Devuelve el número total de registros.  
- **`SUM()`**: Calcula la suma total de los valores en una columna.  
- **`AVG()`**: Calcula el promedio de los valores.  
- **`MAX()`**: Devuelve el valor máximo de una columna.  
- **`MIN()`**: Devuelve el valor mínimo de una columna.  

---

### **Ejemplos de Uso**  

**Contar el número total de empleados:**  
```sql
SELECT COUNT(*) AS total_empleados FROM empleados;
```  

**Calcular el salario promedio de empleados mayores de 30 años:**  
```sql
SELECT AVG(salario) AS salario_promedio  
FROM empleados  
WHERE edad > 30;
```  

**Obtener el salario máximo:**  
```sql
SELECT MAX(salario) AS salario_maximo FROM empleados;
```  

**Suma total de salarios:**  
```sql
SELECT SUM(salario) AS total_salarios FROM empleados;
```  

---

## **7. Agrupación con `GROUP BY` y Filtrado con `HAVING`**  

`GROUP BY` permite agrupar registros que comparten un valor común en una o varias columnas y aplicar funciones de agregación a cada grupo.  

`HAVING` es una cláusula que filtra los resultados después de aplicar `GROUP BY`. A diferencia de `WHERE`, que filtra registros individuales, `HAVING` opera sobre grupos de registros agregados.  

---

### **Sintaxis General**  
```sql
SELECT columna, función_agregada  
FROM tabla  
GROUP BY columna  
HAVING condición;
```  

---

### **Ejemplos Prácticos**  

**Contar empleados agrupados por departamento:**  
```sql
SELECT departamento, COUNT(*) AS cantidad_empleados  
FROM empleados  
GROUP BY departamento;
```  

**Calcular el salario promedio por edad, filtrando edades con promedio superior a 3000:**  
```sql
SELECT edad, AVG(salario) AS salario_promedio  
FROM empleados  
GROUP BY edad  
HAVING AVG(salario) > 3000;
```  

**Suma de ventas por cliente, mostrando solo clientes con ventas superiores a 10000:**  
```sql
SELECT cliente_id, SUM(importe) AS total_ventas  
FROM ventas  
GROUP BY cliente_id  
HAVING SUM(importe) > 10000;
```    


**ORDEN DE ENVALUACIÓN EN CONSULTAS SQL**


[ORDEN DE ENVALUACIÓN EN CONSULTAS SQL](https://stackoverflow.com/questions/14048672/why-cant-i-use-an-alias-for-an-aggregate-in-a-having-clause)
---

## **8. Funciones de Texto en MySQL**  

Las funciones de texto en MySQL permiten manipular y transformar cadenas de caracteres. Estas funciones son esenciales para limpiar, formatear y extraer información textual de los registros almacenados en la base de datos. Son especialmente útiles en tareas como la generación de informes, validación de datos, y procesamiento de nombres, direcciones, o descripciones.  

---

### **8.1. `CONCAT()`**  
La función `CONCAT()` combina dos o más cadenas en una sola. Es útil para unir valores almacenados en diferentes columnas, como nombres y apellidos, o para crear etiquetas formateadas.  

**Sintaxis:**  
```sql
SELECT CONCAT(cadena1, cadena2, ...);
```  

**Características:**  
- Puede concatenar múltiples cadenas en una sola operación.  
- Si alguno de los valores es `NULL`, `CONCAT()` devuelve `NULL` a menos que se utilice `COALESCE()` para manejar los valores nulos.  

**Ejemplo – Concatenar nombres y apellidos:**  
```sql
SELECT CONCAT(nombre, ' ', apellido) AS nombre_completo FROM empleados;
```  
Esto unirá el nombre y apellido de cada empleado, añadiendo un espacio entre ellos.  

**Ejemplo – Evitar resultados `NULL` al concatenar:**  
```sql
SELECT CONCAT(COALESCE(nombre, 'Desconocido'), ' ', COALESCE(apellido, '')) AS nombre_completo  
FROM empleados;
```  
En este caso, si el nombre o apellido es `NULL`, se muestra como 'Desconocido' o se deja vacío.  

---

### **8.2. `SUBSTRING()`**  
`SUBSTRING()` extrae una subcadena a partir de una cadena existente, comenzando en una posición específica y con una longitud opcional.  

**Sintaxis:**  
```sql
SELECT SUBSTRING(cadena, inicio [, longitud]);
```  

- **`inicio`**: Posición desde donde comenzar la extracción. La posición comienza en 1.  
- **`longitud`**: Número de caracteres a extraer. Si se omite, `SUBSTRING()` extrae hasta el final de la cadena.  

**Ejemplo – Extraer los primeros 3 caracteres del nombre:**  
```sql
SELECT SUBSTRING(nombre, 1, 3) FROM empleados;
```  

**Ejemplo – Extraer los últimos 4 caracteres:**  
```sql
SELECT SUBSTRING(nombre, CHAR_LENGTH(nombre)-3) FROM empleados;
```  

---

### **8.3. `CHAR_LENGTH()`**  
`CHAR_LENGTH()` devuelve el número de caracteres en una cadena. A diferencia de `LENGTH()`, que cuenta bytes, `CHAR_LENGTH()` cuenta caracteres multibyte correctamente.  

**Sintaxis:**  
```sql
SELECT CHAR_LENGTH(cadena);
```  

**Ejemplo – Calcular la longitud de un nombre:**  
```sql
SELECT nombre, CHAR_LENGTH(nombre) AS longitud FROM empleados;
```  
Esto permite identificar nombres que tienen más de cierto número de caracteres.  

---

### **8.4. `REPLACE()`**  
`REPLACE()` sustituye todas las apariciones de una subcadena dentro de una cadena por otra.  

**Sintaxis:**  
```sql
SELECT REPLACE(cadena, subcadena_buscar, subcadena_nueva);
```  

**Ejemplo – Reemplazar 'Juan' por 'Carlos' en los nombres:**  
```sql
SELECT REPLACE(nombre, 'Juan', 'Carlos') FROM empleados;
```  
Este ejemplo reemplaza todas las ocurrencias de 'Juan' por 'Carlos' en la columna `nombre`.  

---

### **8.5. `TRIM()`, `LTRIM()`, `RTRIM()`**  
Estas funciones eliminan espacios en blanco (u otros caracteres) del inicio, final o ambos extremos de una cadena.  

- **`TRIM()`**: Elimina espacios de ambos lados.  
- **`LTRIM()`**: Elimina espacios a la izquierda.  
- **`RTRIM()`**: Elimina espacios a la derecha.  

**Ejemplo – Eliminar espacios en blanco:**  
```sql
SELECT TRIM('   Hola Mundo   ') AS resultado;
```  
Resultado: `'Hola Mundo'`  

**Ejemplo – Eliminar caracteres específicos:**  
```sql
SELECT TRIM(LEADING '0' FROM '000123') AS resultado;
```  
Resultado: `'123'`  

---

## **9. Funciones Numéricas en MySQL**  

Las funciones numéricas en MySQL permiten realizar operaciones matemáticas sobre datos almacenados en columnas numéricas. Estas funciones son esenciales para realizar cálculos, redondear valores y generar números aleatorios.  

---

### **9.1. `ROUND()`**  
`ROUND()` redondea un número al valor entero o al número de decimales especificado.  

**Sintaxis:**  
```sql
SELECT ROUND(numero, decimales);
```  
- Si no se especifica el número de decimales, `ROUND()` redondea al entero más cercano.  

**Ejemplo – Redondear salarios a dos decimales:**  
```sql
SELECT ROUND(salario, 2) FROM empleados;
```  

---

### **9.2. `FLOOR()` y `CEIL()`**  
- **`FLOOR()`**: Redondea hacia abajo al entero más cercano.  
- **`CEIL()`**: Redondea hacia arriba al entero más cercano.  

**Ejemplo – Aplicar `FLOOR()` y `CEIL()`:**  
```sql
SELECT FLOOR(15.7), CEIL(15.3);
```  
Resultado: `15` y `16`  

---

### **9.3. `RAND()`**  
`RAND()` genera un número decimal aleatorio entre 0 y 1.  

**Ejemplo – Generar un número aleatorio:**  
```sql
SELECT RAND();
```  

**Ejemplo – Número aleatorio entre 1 y 100:**  
```sql
SELECT FLOOR(1 + (RAND() * 100));
```  

---

## **10. Funciones de Fecha y Hora en MySQL**  

Las funciones de fecha y hora permiten manipular y formatear datos temporales, calcular diferencias y extraer componentes específicos de una fecha (`año`, `mes`, `día`, etc.).  

---

### **10.1. `NOW()`**  
`NOW()` devuelve la fecha y hora actuales en formato `YYYY-MM-DD HH:MM:SS`.  

**Ejemplo – Obtener la fecha y hora actuales:**  
```sql
SELECT NOW();
```  

---

### **10.2. `DATE_FORMAT()`**  
`DATE_FORMAT()` permite formatear una fecha en un formato personalizado.  

**Sintaxis:**  
```sql
SELECT DATE_FORMAT(fecha, formato);
```  

- `%d` – Día (2 dígitos).  
- `%m` – Mes (2 dígitos).  
- `%Y` – Año completo.  
- `%H` – Hora (24 horas).  
- `%i` – Minutos.  
- `%s` – Segundos.  

**Ejemplo – Formatear la fecha de ingreso:**  
```sql
SELECT DATE_FORMAT(fecha_ingreso, '%d/%m/%Y') FROM empleados;
```  

---

### **10.3. `DATEDIFF()`**  
Calcula la diferencia en días entre dos fechas.  

**Ejemplo – Calcular antigüedad en días:**  
```sql
SELECT DATEDIFF(NOW(), fecha_ingreso) AS antiguedad FROM empleados;
```  

---

### **10.4. `EXTRACT()`**  
`EXTRACT()` permite extraer partes específicas de una fecha (`YEAR`, `MONTH`, `DAY`).  

**Ejemplo – Extraer el año de ingreso:**  
```sql
SELECT EXTRACT(YEAR FROM fecha_ingreso) FROM empleados;
```  

## **11. Subconsultas en SQL** 

## **¿Qué es una Subconsulta?**
Una subconsulta es una consulta anidada dentro de otra consulta. Se utiliza para calcular un valor o conjunto de valores que la consulta principal necesita para procesar los resultados.

---

## **Tipos de Subconsultas**
1. **Subconsultas Escalares:**
   Devuelven un único valor.
   ```sql
   SELECT nombre
   FROM empleados
   WHERE salario > (SELECT AVG(salario) FROM empleados);
   ```
   *Selecciona empleados cuyo salario es mayor que el promedio de todos los salarios.*

2. **Subconsultas de Columna:**
   Devuelven una columna con múltiples valores.
   ```sql
   SELECT nombre
   FROM empleados
   WHERE departamento IN (SELECT departamento FROM departamentos);
   ```
   *Selecciona empleados que pertenecen a departamentos existentes en la tabla departamentos.*

3. **Subconsultas de Tabla:**
   Devuelven una tabla completa.
   ```sql
   SELECT *
   FROM (SELECT nombre, salario FROM empleados WHERE salario > 4000) AS subconsulta;
   ```
   *Selecciona todos los registros de una subconsulta que filtra empleados con salarios mayores a 4000.*

---

## **¿Dónde se Usan las Subconsultas?**
1. **En `WHERE`:**
   ```sql
   SELECT nombre
   FROM empleados
   WHERE salario = (SELECT MAX(salario) FROM empleados);
   ```
   *Encuentra el empleado con el salario más alto.*

2. **En `FROM`:**
   ```sql
   SELECT sub.departamento, sub.salario_promedio
   FROM (SELECT departamento, AVG(salario) AS salario_promedio FROM empleados GROUP BY departamento) AS sub;
   ```
   *Calcula el salario promedio por departamento y lo utiliza como una tabla para análisis posterior.*

3. **En `HAVING`:**
   ```sql
   SELECT departamento, SUM(salario) AS total_salarios
   FROM empleados
   GROUP BY departamento
   HAVING SUM(salario) > (SELECT AVG(salario) FROM empleados);
   ```
   *Muestra departamentos con un salario total mayor al promedio de todos los salarios.*
