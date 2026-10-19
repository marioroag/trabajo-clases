-- Crear base de datos si no existe
CREATE DATABASE if not exists billar;
USE billar;

-- Crear tabla de jugadores
CREATE TABLE jugador (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50)
);

-- Crear tabla de mesas de billar
CREATE TABLE mesa (
    id INT AUTO_INCREMENT PRIMARY KEY,
    numero INT,
    tipo VARCHAR(20) -- Ej: "Pool", "Snooker", "Carambola"
);

-- Crear tabla de torneos
CREATE TABLE torneo (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50),
    fecha DATE
);

-- Crear tabla de tacos de billar
CREATE TABLE taco (
    id INT AUTO_INCREMENT PRIMARY KEY,
    marca VARCHAR(50),
    material VARCHAR(30) -- Ej: "Madera", "Fibra de carbono"
);

-- Insertar datos en la tabla jugador
INSERT INTO jugador (nombre) VALUES
('Carlos'),
('Andrea'),
('Miguel'),
('Lucía'),
('Fernando');

-- Insertar datos en la tabla mesa
INSERT INTO mesa (numero, tipo) VALUES
(1, 'Pool'),
(2, 'Snooker'),
(3, 'Carambola'),
(4, 'Pool');

-- Insertar datos en la tabla torneo
INSERT INTO torneo (nombre, fecha) VALUES
('Torneo de Verano', '2025-06-15'),
('Copa Nacional', '2025-09-20'),
('Desafío Internacional', '2025-12-05');

-- Insertar datos en la tabla taco
INSERT INTO taco (marca, material) VALUES
('Predator', 'Madera'),
('Cuetec', 'Fibra de carbono'),
('McDermott', 'Madera'),
('Lucasi', 'Fibra de carbono');

-- ALTER TABLE: Añadir una clave foránea en la tabla 'jugador' para asociarlo con la tabla 'torneo'.
ALTER TABLE jugador ADD COLUMN torneo_id INT;
ALTER TABLE jugador ADD CONSTRAINT fk_jugador_torneo FOREIGN KEY (torneo_id) REFERENCES torneo(id);

-- ALTER TABLE: Añadir una clave foránea en la tabla 'jugador' para asociarlo con la tabla 'taco'.
ALTER TABLE jugador ADD COLUMN taco_id INT;
ALTER TABLE jugador ADD CONSTRAINT fk_jugador_taco FOREIGN KEY (taco_id) REFERENCES taco(id);

-- ALTER TABLE: Añadir una clave foránea en la tabla 'mesa' para asociarla con la tabla 'torneo'.
ALTER TABLE mesa ADD COLUMN torneo_id INT;
ALTER TABLE mesa ADD CONSTRAINT fk_mesa_torneo FOREIGN KEY (torneo_id) REFERENCES torneo(id);

-- ALTER TABLE: Añadir una clave foránea en la tabla 'torneo' para indicar qué jugador organizó el torneo.
ALTER TABLE torneo ADD COLUMN organizador_id INT;
ALTER TABLE torneo ADD CONSTRAINT fk_torneo_organizador FOREIGN KEY (organizador_id) REFERENCES jugador(id);

-- ALTER TABLE: Modificar el tamaño del campo 'nombre' en la tabla 'jugador' para permitir hasta 100 caracteres.
ALTER TABLE jugador MODIFY COLUMN nombre VARCHAR(100);

-- ALTER TABLE: Eliminar la columna 'material' en la tabla 'taco'.
ALTER TABLE taco DROP COLUMN material;

-- ALTER TABLE: Cambiar el nombre de la columna 'numero' en la tabla 'mesa' por 'identificador_mesa'.
ALTER TABLE mesa CHANGE COLUMN numero identificador_mesa INT;
-- **Alternativa con rename
-- ALTER TABLE mesa RENAME COLUMN identificador_mesa to identificador_mesa_1;

-- ALTER TABLE: Añadir una nueva columna 'telefono' en la tabla 'jugador' para almacenar su número de contacto.
ALTER TABLE jugador ADD COLUMN telefono VARCHAR(13);

-- ALTER TABLE: Añadir una restricción UNIQUE para que los nombres de torneos sean únicos.
ALTER TABLE torneo ADD CONSTRAINT uq_nombre_torneo UNIQUE (nombre);

-- ALTER TABLE: Añadir una restricción CHECK para que las fechas de los torneos sean posteriores al año 2026.
ALTER TABLE torneo ADD CONSTRAINT chk_fecha_torneo CHECK (fecha > '2025-12-31');

-- UPDATE: Asignar a cada jugador un torneo en el que participará.
UPDATE jugador SET torneo_id = (SELECT id FROM torneo WHERE nombre = 'Torneo de Verano') WHERE nombre IN ('Carlos', 'Andrea');
UPDATE jugador SET torneo_id = (SELECT id FROM torneo WHERE nombre = 'Copa Nacional') WHERE nombre IN ('Miguel', 'Lucía');
UPDATE jugador SET torneo_id = (SELECT id FROM torneo WHERE nombre = 'Desafío Internacional') WHERE nombre = 'Fernando';

-- UPDATE: Asignar un taco de billar a cada jugador.
UPDATE jugador SET taco_id = 1 WHERE nombre = 'Carlos';
UPDATE jugador SET taco_id = 2 WHERE nombre = 'Andrea';
UPDATE jugador SET taco_id = 3 WHERE nombre = 'Miguel';
UPDATE jugador SET taco_id = 4 WHERE nombre = 'Lucía';
UPDATE jugador SET taco_id = 1 WHERE nombre = 'Fernando';

-- UPDATE: Asignar mesas a los torneos.
UPDATE mesa SET torneo_id = (SELECT id FROM torneo WHERE nombre = 'Torneo de Verano') WHERE identificador_mesa IN (1, 2);
UPDATE mesa SET torneo_id = (SELECT id FROM torneo WHERE nombre = 'Copa Nacional') WHERE identificador_mesa = 3;
UPDATE mesa SET torneo_id = (SELECT id FROM torneo WHERE nombre = 'Desafío Internacional') WHERE identificador_mesa = 4;

-- CONDICIÓN: Asignar un torneo a todos los jugadores que no tengan torneo asignado aún.
UPDATE jugador SET torneo_id = (SELECT id FROM torneo ORDER BY RAND() LIMIT 1) WHERE torneo_id IS NULL;

-- CONDICIÓN: Asignar un taco aleatorio a los jugadores que no tengan taco asignado.
UPDATE jugador SET taco_id = (SELECT id FROM taco ORDER BY RAND() LIMIT 1) WHERE taco_id IS NULL;

-- CONDICIÓN: Cambiar el torneo de todos los jugadores que actualmente participan en torneos entre julio y noviembre.
UPDATE jugador 
SET torneo_id = 1
WHERE torneo_id IN (SELECT id FROM torneo WHERE MONTH(fecha) BETWEEN 7 AND 11);

-- CONDICIÓN: Cambiar la mesa de todos los torneos que se celebren después del 1 de diciembre de 2025.
UPDATE mesa 
SET torneo_id = 1
WHERE torneo_id IN (SELECT id FROM torneo WHERE fecha > '2025-12-01');

-- CONDICIÓN: Asignar un torneo a todas las mesas que aún no tienen torneo asignado.
UPDATE mesa SET torneo_id = (SELECT id FROM torneo ORDER BY RAND() LIMIT 1) WHERE torneo_id IS NULL;

-- CONDICIÓN: Cambiar el taco de todos los jugadores que tengan un taco de fibra de carbono a un taco de madera.
UPDATE jugador 
SET taco_id = (SELECT id FROM taco WHERE marca = 'McDermott' LIMIT 1) 
WHERE taco_id IN (SELECT id FROM taco WHERE marca IN ('Cuetec', 'Lucasi'));

-- CONDICIÓN: Cambiar el torneo de todas las mesas que sean de tipo "Pool" al "Torneo de Verano".
UPDATE mesa 
SET torneo_id = (SELECT id FROM torneo WHERE nombre = 'Torneo de Verano') 
WHERE tipo = 'Pool';

-- Consultas equivalentes

-- UPDATE mesa 
-- SET torneo_id = 1
-- WHERE tipo = 'Pool';

