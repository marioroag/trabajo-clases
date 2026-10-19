-- Solución a los ejercicios de administración de MySQL
USE administracion_mysql;
-- **Ejercicio 1: Creación de Usuarios**
CREATE USER 'analista'@'localhost' IDENTIFIED BY 'analistaPass';
CREATE USER 'reportes'@'%' IDENTIFIED BY 'report123';
SELECT User, Host FROM mysql.user;

-- **Ejercicio 2: Gestión de Privilegios**
GRANT SELECT ON administracion_mysql.* TO 'analista'@'localhost';
GRANT SELECT, INSERT ON ventas TO 'reportes'@'%';
REVOKE INSERT ON ventas FROM 'reportes'@'%';
SHOW GRANTS FOR 'analista'@'localhost';

-- **Ejercicio 3: Administración de Roles**
CREATE ROLE 'gestor_ventas';
GRANT SELECT, INSERT, UPDATE ON administracion_mysql.* TO 'gestor_ventas';
GRANT 'gestor_ventas' TO 'analista'@'localhost';
SET DEFAULT ROLE 'gestor_ventas' TO  'analista'@'localhost';
SHOW GRANTS FOR 'analista'@'localhost';

-- **Ejercicio 4: Creación y Gestión de Índices**
CREATE INDEX idx_producto ON ventas(producto);
CREATE INDEX idx_nombre_email ON usuarios(nombre, email);
SHOW INDEX FROM ventas;
DROP INDEX idx_producto ON ventas;

-- **Ejercicio 5: Seguridad y Gestión de Contraseñas**
ALTER USER 'analista'@'localhost' IDENTIFIED BY 'newPass456';
ALTER USER 'reportes'@'%' PASSWORD EXPIRE;
DROP USER 'reportes'@'%';

-- **Ejercicio 6: Aplicación de Privilegios y Optimización**
EXPLAIN SELECT * FROM ventas WHERE cantidad > 5;
CREATE INDEX idx_cantidad ON ventas(cantidad);
EXPLAIN SELECT * FROM ventas WHERE cantidad > 5;

FLUSH PRIVILEGES;