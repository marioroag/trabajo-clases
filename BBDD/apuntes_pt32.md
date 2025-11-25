# **Chuleta de SQL - Examen de Bases de Datos**

## **1. Comandos Básicos de SQL**

### **Crear una base de datos**

```sql
CREATE DATABASE nombre_base_de_datos;
```

### **Usar una base de datos**

```sql
USE nombre_base_de_datos;
```

### **Crear una tabla**

```sql
CREATE TABLE tabla (
    columna1 tipo_dato [opciones],
    columna2 tipo_dato [opciones],
    ...
);
```

### **Eliminar una tabla**

```sql
DROP TABLE tabla;
```

### **Eliminar una base de datos**

```sql
DROP DATABASE nombre_base_de_datos;
```

---

## **2. Definición de Tipos de Datos**

* **INT**: Números enteros.
* **VARCHAR(n)**: Cadenas de texto de longitud variable (hasta n caracteres).
* **TEXT**: Cadenas de texto de longitud variable (sin límite).
* **DATE**: Fecha (formato: `YYYY-MM-DD`).
* **DATETIME**: Fecha y hora (formato: `YYYY-MM-DD HH:MM:SS`).
* **BOOLEAN**: Valores `TRUE` o `FALSE`.
* **DECIMAL(p,s)**: Número decimal, con p dígitos en total y s decimales.

---

## **3. Modificar una Tabla**

### **Agregar una columna**

```sql
ALTER TABLE tabla ADD columna tipo_dato;
```

### **Eliminar una columna**

```sql
ALTER TABLE tabla DROP COLUMN columna;
```

### **Cambiar el tipo de dato de una columna**

```sql
ALTER TABLE tabla MODIFY columna tipo_dato;
```

---

## **4. Claves Primarias y Foráneas**

### **Definir una clave primaria**

```sql
CREATE TABLE tabla (
    id INT PRIMARY KEY,
    ...
);
```

### **Definir una clave foránea**

```sql
CREATE TABLE tabla (
    id INT,
    id_tabla_foranea INT,
    FOREIGN KEY (id_tabla_foranea) REFERENCES tabla_foranea(id)
);
```

### **Eliminar una clave foránea**

```sql
ALTER TABLE tabla DROP FOREIGN KEY nombre_de_la_clave_foranea;
```

---

## **5. Consultas SELECT**

### **Seleccionar todos los datos de una tabla**

```sql
SELECT * FROM tabla;
```

### **Seleccionar columnas específicas**

```sql
SELECT columna1, columna2 FROM tabla;
```

### **Filtrar datos con WHERE**

```sql
SELECT * FROM tabla WHERE columna = valor;
```

### **Ordenar resultados con ORDER BY**

```sql
SELECT * FROM tabla ORDER BY columna ASC;  -- Ascendente
SELECT * FROM tabla ORDER BY columna DESC; -- Descendente
```

### **Limitar los resultados con LIMIT**

```sql
SELECT * FROM tabla LIMIT 10;  -- Muestra solo 10 registros
```

---

## **6. Operadores Comunes en WHERE**

* **=**: Igual a.
* **!=** o **<>**: Diferente a.
* **>**: Mayor que.
* **<**: Menor que.
* **>=**: Mayor o igual que.
* **<=**: Menor o igual que.
* **BETWEEN**: Rango (inclusivo).
* **IN**: Valores específicos.
* **LIKE**: Búsqueda por patrón (usualmente con `%` para cualquier cadena).
* **IS NULL**: Filtra valores nulos.

Ejemplo con LIKE:

```sql
SELECT * FROM tabla WHERE nombre LIKE 'Juan%';  -- Comienza con 'Juan'
```

---

## **7. Funciones de Agregación**

* **COUNT()**: Cuenta registros.

  ```sql
  SELECT COUNT(*) FROM tabla;
  ```
* **SUM()**: Suma los valores de una columna numérica.

  ```sql
  SELECT SUM(columna) FROM tabla;
  ```
* **AVG()**: Promedio de los valores de una columna numérica.

  ```sql
  SELECT AVG(columna) FROM tabla;
  ```
* **MIN()**: Valor mínimo.

  ```sql
  SELECT MIN(columna) FROM tabla;
  ```
* **MAX()**: Valor máximo.

  ```sql
  SELECT MAX(columna) FROM tabla;
  ```

---

## **8. Joins - Unir Tablas**

### **INNER JOIN**: Devuelve filas cuando hay una coincidencia en ambas tablas.

```sql
SELECT * 
FROM tabla1 t1
INNER JOIN tabla2 t2 ON t1.id = t2.id_tabla1;
```

### **LEFT JOIN**: Devuelve todas las filas de la primera tabla, y las coincidencias de la segunda tabla.

```sql
SELECT * 
FROM tabla1 t1
LEFT JOIN tabla2 t2 ON t1.id = t2.id_tabla1;
```

---

## **9. Insertar Datos**

### **Insertar una fila**

```sql
INSERT INTO tabla (columna1, columna2, ...)
VALUES (valor1, valor2, ...);
```

### **Insertar múltiples filas**

```sql
INSERT INTO tabla (columna1, columna2, ...)
VALUES 
(valor1a, valor2a, ...),
(valor1b, valor2b, ...);
```

---

## **10. Actualizar Datos**

### **Actualizar una fila**

```sql
UPDATE tabla
SET columna1 = valor1, columna2 = valor2
WHERE condicion;
```

---

## **11. Eliminar Datos**

### **Eliminar una fila**

```sql
DELETE FROM tabla WHERE condicion;
```

---

## **12. Subconsultas**

### **Subconsulta en el WHERE**

```sql
SELECT * FROM tabla WHERE columna IN (SELECT columna FROM otra_tabla);
```

### **Subconsulta en el SELECT**

```sql
SELECT columna1, (SELECT columna2 FROM otra_tabla WHERE condicion) AS alias
FROM tabla;
```

---

## **13. Índices y Optimizaciones**

### **Crear un índice**

```sql
CREATE INDEX nombre_indice ON tabla(columna);
```

---

¡Perfecto! Te voy a crear un ejemplo completo con una tabla de ejemplo, su definición en SQL y algunos datos insertados, para que puedas usarlo de referencia en tu examen.

### **Escenario: Sistema de gestión de empleados**

Imagina que estás creando un sistema de gestión de empleados para una empresa. Necesitas almacenar la información de los empleados, como su ID, nombre, correo electrónico, salario, fecha de contratación y si están activos en la empresa.

### **1. Estructura de la Tabla `Empleados`**

La tabla `Empleados` tendrá los siguientes campos:

* **id_empleado**: Clave primaria, identificador único del empleado.
* **nombre**: Nombre completo del empleado.
* **email**: Dirección de correo electrónico del empleado.
* **salario**: Salario mensual del empleado.
* **fecha_contratacion**: Fecha en la que el empleado fue contratado.
* **activo**: Indica si el empleado sigue activo en la empresa.

### **2. Código SQL para Crear la Tabla**

```sql
-- Crear la base de datos
CREATE DATABASE empresa;
USE empresa;

-- Crear la tabla Empleados
CREATE TABLE Empleados (
    id_empleado INT AUTO_INCREMENT PRIMARY KEY,    -- Clave primaria auto incrementable
    nombre VARCHAR(100) NOT NULL,                   -- Nombre del empleado
    email VARCHAR(100) NOT NULL UNIQUE,             -- Email único del empleado
    salario DECIMAL(10, 2) NOT NULL,                -- Salario mensual
    fecha_contratacion DATE NOT NULL,               -- Fecha de contratación
    activo BOOLEAN DEFAULT TRUE                     -- Si está activo (por defecto TRUE)
);
```

### **3. Insertar Datos en la Tabla `Empleados`**

Ahora, vamos a insertar algunos datos de ejemplo en la tabla `Empleados`.

```sql
-- Insertar datos de ejemplo
INSERT INTO Empleados (nombre, email, salario, fecha_contratacion, activo)
VALUES 
('Juan Pérez', 'juan.perez@example.com', 2500.00, '2020-03-15', TRUE),
('María López', 'maria.lopez@example.com', 3200.00, '2019-07-01', TRUE),
('Carlos García', 'carlos.garcia@example.com', 2800.00, '2021-05-10', FALSE),
('Ana Fernández', 'ana.fernandez@example.com', 3000.00, '2022-08-25', TRUE);
```

---

### **Resumen**

1. **Estructura SQL de la tabla `Empleados`**: Definimos una tabla con campos clave (ID, nombre, email, salario, fecha de contratación, y activo).
2. **Datos insertados**: Agregamos algunos empleados con diferentes estados (activos e inactivos).
3. **Consultas SQL**: Mostramos algunas consultas básicas para obtener información sobre los empleados, como filtrado por salario, estado, y fechas, así como actualizar o eliminar datos.

Este ejemplo te da una base sólida para comprender cómo trabajar con bases de datos relacionales, cómo hacer consultas, y cómo manipular los datos con SQL. Puedes usarlo como referencia para tu examen o para proyectos más complejos.

Para implementar una relación **muchos a muchos** (N a N) entre dos tablas, necesitamos utilizar una **tabla intermedia** que contenga claves foráneas de ambas tablas, creando así la relación.

Voy a explicarte cómo hacerlo con un ejemplo. Supongamos que estamos trabajando en un sistema de gestión de proyectos y empleados. En este escenario, un **empleado** puede estar asignado a **varios proyectos**, y un **proyecto** puede tener **varios empleados** trabajando en él. Esto forma una relación **muchos a muchos** entre la tabla `Empleados` y la tabla `Proyectos`.

### **1. Estructura de las Tablas**

#### a) **Tabla `Empleados`**:

La tabla `Empleados` ya la hemos definido antes, pero para completar el ejemplo, la volveré a mostrar aquí.

```sql
CREATE TABLE Empleados (
    id_empleado INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    salario DECIMAL(10, 2) NOT NULL,
    fecha_contratacion DATE NOT NULL,
    activo BOOLEAN DEFAULT TRUE
);
```

#### b) **Tabla `Proyectos`**:

La tabla `Proyectos` almacenará información sobre los proyectos.

```sql
CREATE TABLE Proyectos (
    id_proyecto INT AUTO_INCREMENT PRIMARY KEY,
    nombre_proyecto VARCHAR(100) NOT NULL,
    fecha_inicio DATE NOT NULL,
    fecha_fin DATE
);
```

#### c) **Tabla Intermedia `Empleado_Proyecto`**:

Esta tabla `Empleado_Proyecto` será la que defina la relación **muchos a muchos** entre `Empleados` y `Proyectos`. Contendrá las claves foráneas de ambas tablas.

```sql
CREATE TABLE Empleado_Proyecto (
    id_empleado INT,
    id_proyecto INT,
    PRIMARY KEY (id_empleado, id_proyecto),
    FOREIGN KEY (id_empleado) REFERENCES Empleados(id_empleado),
    FOREIGN KEY (id_proyecto) REFERENCES Proyectos(id_proyecto)
);
```

### **2. Insertar Datos**

#### a) Insertamos algunos empleados y proyectos:

```sql
-- Insertar empleados
INSERT INTO Empleados (nombre, email, salario, fecha_contratacion)
VALUES 
('Juan Pérez', 'juan.perez@example.com', 2500.00, '2020-03-15'),
('María López', 'maria.lopez@example.com', 3200.00, '2019-07-01');

-- Insertar proyectos
INSERT INTO Proyectos (nombre_proyecto, fecha_inicio, fecha_fin)
VALUES
('Proyecto A', '2022-01-10', '2022-12-31'),
('Proyecto B', '2023-05-01', '2023-10-01');
```

#### b) Relacionamos a los empleados con los proyectos usando la tabla intermedia `Empleado_Proyecto`:

```sql
-- Relacionar empleados con proyectos
INSERT INTO Empleado_Proyecto (id_empleado, id_proyecto)
VALUES 
(1, 1), -- Juan Pérez está en Proyecto A
(2, 1), -- María López está en Proyecto A
(1, 2); -- Juan Pérez está también en Proyecto B
```
---

### **3. Resumen de la Relación N a N**

* **Empleados y Proyectos** tienen una relación de **muchos a muchos**, ya que un empleado puede estar asignado a varios proyectos y un proyecto puede tener varios empleados.
* Se crea una **tabla intermedia** (`Empleado_Proyecto`) que tiene las **claves foráneas** de ambas tablas, lo que permite establecer la relación.
* Las consultas SQL para esta relación son principalmente **JOINs**, que unen las tablas a través de la tabla intermedia.

---

¡Con este ejemplo tienes una implementación básica de una relación **muchos a muchos** (N a N) en SQL! Si tienes más preguntas o necesitas más detalles, no dudes en preguntar.
  
