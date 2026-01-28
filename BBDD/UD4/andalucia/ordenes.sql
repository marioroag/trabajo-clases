DROP DATABASE IF EXISTS andalucia_db;
CREATE DATABASE IF NOT EXISTS andalucia_db CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
USE andalucia_db;

-- Crear la tabla personas con estructura adecuada
CREATE TABLE personas (
    id INT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    apellido VARCHAR(50) NOT NULL,
    sexo ENUM('M', 'H') NOT NULL,
    fecha_nacimiento DATE NOT NULL,
    provincia VARCHAR(100) NOT NULL,
    municipio VARCHAR(150) NOT NULL,
    nivel_estudios VARCHAR(50),
    situacion_laboral VARCHAR(50),
    ingresos_anuales INT,
    estado_civil VARCHAR(20),
    num_hijos INT,
    nivel_socioeconomico VARCHAR(20),
    ocupacion VARCHAR(50)
);

alter table personas add column madre INT;
alter table personas add column padre INT;
alter table personas add foreign key (padre) references personas(id);
alter table personas add foreign key (madre) references personas(id);

SET FOREIGN_KEY_CHECKS=0;

LOAD DATA INFILE '/var/lib/mysql-files/data_andalucia.csv' INTO TABLE personas FIELDS TERMINATED BY ','  ENCLOSED BY '"' LINES TERMINATED BY '\n' IGNORE 1 ROWS;

SET FOREIGN_KEY_CHECKS=1;

-- Muestra la media de salario agrupada por ocupación
select ocupacion, round(avg(ingresos_anuales), 2) from personas group by ocupacion;

-- Muestra la media de salarios en cada provincia
select provincia, round(avg(ingresos_anuales), 2) from personas group by provincia;

-- Muestra la media de edad de cada nivel socioeconómico
select nivel_socioeconomico, floor(avg(year(now()) - year(fecha_nacimiento))) as edad_media from personas group by nivel_socioeconomico;

-- Dime la edad de las personas de menos de 60 años ordenadas por situación laboral.
select situacion_laboral, floor(avg(year(now()) - year(fecha_nacimiento))) as edad_media from personas group by situacion_laboral having edad_media < 60;

-- Muestra el nombre de la persona parada de más edad.
select nombre, floor(year(now()) - year(fecha_nacimiento)) as edad from personas where ocupacion = "Estudiante" and floor(year(now()) - year(fecha_nacimiento)) = (select floor(max(year(now()) - year(fecha_nacimiento))) from personas where ocupacion = "Estudiante");

-- Dime la provincia con la máxima edad media.
select provincia from personas GROUP BY provincia having floor(avg(year(now()) - year(fecha_nacimiento))) = (select max(edad_media) from (select floor(avg(year(now()) - year(fecha_nacimiento))) as edad_media from personas group by provincia) p);

-- Provincias
select provincia from personas GROUP BY provincia;

-- Edad media
select provincia, floor(avg(year(now()) - year(fecha_nacimiento))) as edad_media from personas group by provincia;

-- Max
(select max(edad_media) from (select floor(avg(year(now()) - year(fecha_nacimiento))) as edad_media from personas group by provincia) p);

-- Dime los hijos del ciudadano con id 1190
select nombre, num_hijos, id from personas where padre = 1190;

-- Muestra los nietos del ciudadano con id = 1190
select nombre from personas where padre in (select id from personas where padre = 1190) or madre in (select id from personas where padre = 1190);

-- Muestra la madre con más hijos
select nombre, num_hijos from personas where num_hijos = (select max(num_hijos) from personas) and sexo = "M";

-- Muestra la media de hijos por hombre
select round(avg(num_hijos), 2) from personas where sexo = "H";

-- Dime la media de hijos de personas con menos de 30 años.
select round(avg(num_hijos), 2) as media_hijos from personas where floor(year(now()) - year(fecha_nacimiento)) > 30;

-- Muestra el valor de numero de hijos que más se repite entre las mujeres.
select (select max(num_hijos) from personas WHERE sexo = "M") as max_hijos_mujer, count(*) as repiticiones_max_hijos from personas where num_hijos = (select max(num_hijos) from personas) and sexo = "M";

-- Dime la media de edad de las mujeres sin hijos de Sevilla provincia
select provincia, round(avg(floor(year(now()) - year(fecha_nacimiento))), 0) as media_edad_mujeres from personas where sexo = "M" and provincia = "Sevilla";

-- Dime la media de las modas del campo edad.
select round(avg(edad), 2) as media_modas_edad from (select floor(year(now()) - year(fecha_nacimiento)) as edad, count(floor(year(now()) - year(fecha_nacimiento))) as frecuencia from personas group by edad having frecuencia = (select max(frecuencia) from (select floor(year(now()) - year(fecha_nacimiento)) as edad, count(floor(year(now()) - year(fecha_nacimiento))) as frecuencia from personas group by edad) p) ) m;

-- Dime la provincia con menor edad media de las personas estudiantes.
SELECT provincia from personas where ocupacion = "Estudiante" group by provincia having avg(floor(year(now()) - year(fecha_nacimiento))) = (select min(media_edad) as min_media_edad from (select provincia, avg(floor(year(now()) - year(fecha_nacimiento))) as media_edad from personas where ocupacion = "Estudiante" group by provincia) p);

-- Órdename los municipios por numero total de hijos en cada uno.


-- ordena las provincias por mayor número medio de hijos por mujer (tasa de natalidad)
-- Dime los municipios que no superan la tasa de reemplazo (más de 2 hijos por mujer) pero tienen un salario medio mayor a 3000 euros al mes
-- Dime la provincia con la moda de edad más alta.
-- Dime los 5 sevillanos (municipio) de más edad ordenados por la longitud de su apellido.
-- Dime el municicpio con menos tasa de natalidad (num_hijos por mujer) de entre los municipios de Huelva con salario medio menor de 20000 euros anuales .