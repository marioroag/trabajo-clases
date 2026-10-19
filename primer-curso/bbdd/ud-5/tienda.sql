-- Crear base de datos si no existe
DROP DATABASE IF EXISTS tienda;
CREATE DATABASE tienda;
USE tienda;

-- Crear tablas de ejemplo
CREATE TABLE cliente (
    id INT PRIMARY KEY,
    nombre VARCHAR(50),
    email VARCHAR(100)
);

CREATE TABLE pedido (
    id INT PRIMARY KEY,
    id_cliente INT,
    fecha DATE,
    total DECIMAL(10, 2),
    FOREIGN KEY (id_cliente) REFERENCES cliente(id)
);

CREATE TABLE producto (
    id INT PRIMARY KEY,
    nombre VARCHAR(50),
    precio DECIMAL(10, 2)
);

CREATE TABLE detalle_pedido (
    id INT PRIMARY KEY,
    id_pedido INT,
    id_producto INT,
    cantidad INT,
    FOREIGN KEY (id_pedido) REFERENCES pedido(id),
    FOREIGN KEY (id_producto) REFERENCES producto(id)
);

-- Insertar datos en la tabla cliente
INSERT INTO cliente (id, nombre, email) VALUES
(1, 'Juan Perez', 'juan.perez@example.com'),
(2, 'Ana Gomez', 'ana.gomez@example.com'),
(3, 'Luis Martinez', 'luis.martinez@example.com'),
(4, 'Martina Lopez', 'martina.lopez@example.com');

-- Insertar datos en la tabla pedido
INSERT INTO pedido (id, id_cliente, fecha, total) VALUES
(1, 1, '2025-01-01', 100.50),
(2, 1, '2025-01-10', 50.00),
(3, 2, '2025-01-15', 75.25),
(4, 3, '2025-01-20', 200.00);

-- Insertar datos en la tabla producto
INSERT INTO producto (id, nombre, precio) VALUES
(1, 'Laptop', 800.00),
(2, 'Mouse', 20.00),
(3, 'Teclado', 50.00),
(4, 'Monitor', 150.00);

-- Insertar datos en la tabla detalle_pedido
INSERT INTO detalle_pedido (id, id_pedido, id_producto, cantidad) VALUES
(1, 1, 1, 1),
(2, 1, 2, 2),
(3, 2, 3, 1),
(4, 3, 4, 2),
(5, 4, 1, 1),
(6, 4, 3, 3);

-- Ejemplo 1: JOIN
-- Obtener nombres de clientes y los detalles de sus pedidos
select c.nombre, p.*
from cliente c
join detalle_pedido p
on p.id = c.id;

-- Ejemplo 2: JOIN con detalles de productos
-- Obtener los productos en cada pedido
select c.nombre, p.*
from producto c
join detalle_pedido p
on p.id = c.id
order by id_pedido;

-- Ejemplo 3: JOIN con filtro
-- Obtener clientes que han realizado pedidos mayores a 100
select c.nombre, p.*
from cliente c
join detalle_pedido p
on p.id = c.id
where p.cantidad > 100;

-- Ejemplo 4: JOIN con funciones de agregación
-- Obtener el total gastado por cada cliente
select nombre, gasto_cliente
from cliente 
join (select sum(c.precio) as gasto_cliente, p.id_pedido as id_pedido
from producto c
join detalle_pedido p
on p.id = c.id
group by p.id_pedido) p
on p.id_pedido = id;

-- Ejemplo 5: JOIN con múltiples uniones
-- Obtener el detalle completo de cada pedido con información del cliente y productos
select *
from pedido
join cliente
join producto;