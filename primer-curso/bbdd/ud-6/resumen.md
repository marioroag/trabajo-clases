Perfecto — te hago una chuleta mejorada + explicaciones clave (lo que suelen preguntar o confundir en examen). Está pensada para que entiendas rápido y memorices fácil 👇

⸻

🧠 CHULETA MYSQL – ADMINISTRACIÓN (UD6) + EXPLICACIONES

⸻

🔹 1. USUARIOS

✅ Crear usuario

CREATE USER 'usuario'@'host' IDENTIFIED BY 'password';

📌 Qué significa cada parte:
	•	'usuario' → nombre
	•	'host' → desde dónde se conecta (MUY IMPORTANTE en examen)
	•	'password' → contraseña

📌 Hosts típicos:
	•	localhost → solo desde el propio servidor
	•	% → desde cualquier IP (menos seguro ⚠️)
	•	192.168.1.% → red concreta

💡 Truco examen:
Si no ponen host → está MAL → SIEMPRE hay host

⸻

✅ Ver usuarios

SELECT User, Host FROM mysql.user;

📌 MySQL guarda usuarios en tabla interna → mysql.user

⸻

✅ Cambiar contraseña

ALTER USER 'usuario'@'host' IDENTIFIED BY 'nueva_pass';


⸻

✅ Forzar cambio de contraseña

ALTER USER 'usuario'@'host' PASSWORD EXPIRE;

📌 Sirve para seguridad → usuario debe cambiarla al entrar

⸻

✅ Eliminar usuario

DROP USER 'usuario'@'host';


⸻

🔹 2. PRIVILEGIOS

📌 Idea clave:
Controlan qué puede hacer un usuario (leer, escribir, borrar…)

⸻

✅ Dar permisos

GRANT privilegios ON bd.tabla TO 'usuario'@'host';

📌 Tipos:
	•	SELECT → leer
	•	INSERT → insertar
	•	UPDATE → modificar
	•	DELETE → borrar
	•	ALL PRIVILEGES → todo

📌 Alcance:
	•	bd.* → toda la base de datos
	•	bd.tabla → tabla concreta
	•	*.* → TODO el servidor

⸻

💡 Ejemplos típicos examen:

GRANT ALL PRIVILEGES ON tienda.* TO 'admin'@'localhost';
GRANT SELECT, INSERT ON tienda.pedido TO 'user'@'%';


⸻

✅ Ver permisos

SHOW GRANTS FOR 'usuario'@'host';

📌 MUY preguntado → muestra TODO lo que tiene el usuario

⸻

✅ Quitar permisos

REVOKE privilegios ON bd.tabla FROM 'usuario'@'host';


⸻

✅ Aplicar cambios

FLUSH PRIVILEGES;

📌 🔥 CLAVE:
	•	MySQL guarda permisos en tablas internas
	•	Este comando recarga los permisos en memoria  ￼

💡 En examen:
👉 después de cambios → suele ir este comando

⸻

🔹 3. ROLES

📌 Idea clave:
Un rol = conjunto de permisos reutilizable

💡 Ejemplo real:
	•	rol → admin
	•	usuarios → muchos → todos heredan permisos

⸻

✅ Crear rol

CREATE ROLE 'rol';


⸻

✅ Dar permisos al rol

GRANT SELECT, INSERT ON bd.* TO 'rol';

📌 Igual que con usuarios

⸻

✅ Asignar rol a usuario

GRANT 'rol' TO 'usuario'@'host';


⸻

⚠️ IMPORTANTE (TRAMPA EXAMEN)

SET DEFAULT ROLE 'rol' TO 'usuario'@'host';

📌 Diferencia:

Comando	Qué hace
GRANT rol	Lo asigna pero NO se activa
SET DEFAULT ROLE	Se activa automáticamente

👉 Muy preguntado  ￼

⸻

✅ Ver roles / permisos

SHOW GRANTS FOR 'usuario'@'host';


⸻

✅ Usuario y rol actual

SELECT CURRENT_USER(), CURRENT_ROLE();

📌 Diferencia:
	•	CURRENT_USER() → quién eres
	•	CURRENT_ROLE() → qué permisos estás usando  ￼

⸻

🔹 4. ÍNDICES

📌 Qué son

➡️ Estructuras que hacen las consultas MÁS RÁPIDAS  ￼

💡 Sin índice → MySQL revisa TODA la tabla
💡 Con índice → va directo al dato

⸻

✅ Crear índice

CREATE INDEX idx_nombre ON tabla(columna);


⸻

✅ Índice compuesto

CREATE INDEX idx_multi ON tabla(col1, col2);

📌 Se usa en consultas con varias columnas

⸻

✅ Ver índices

SHOW INDEX FROM tabla;


⸻

✅ Eliminar índice

DROP INDEX idx_nombre ON tabla;


⸻

🔥 PREGUNTAS TÍPICAS DE EXAMEN (IMPORTANTE)

❓ ¿Por qué usar roles?

➡️ Para no repetir permisos y facilitar gestión

⸻

❓ Diferencia GRANT vs REVOKE
	•	GRANT → dar permisos
	•	REVOKE → quitarlos

⸻

❓ ¿Qué hace FLUSH PRIVILEGES?

➡️ Aplica cambios de permisos en el sistema

⸻

❓ ¿Para qué sirven los índices?

➡️ Acelerar consultas

⸻

❓ Diferencia usuario vs rol
	•	Usuario → persona/sistema que accede
	•	Rol → conjunto de permisos

⸻

❓ ¿Qué pasa si no pongo host?

➡️ ERROR (siempre hay host)

⸻

⚡ RESUMEN FINAL (MEMORIZAR)
	•	Usuario = acceso
	•	Host = desde dónde entra
	•	GRANT = dar permisos
	•	REVOKE = quitar permisos
	•	Rol = permisos agrupados
	•	Índice = velocidad
	•	FLUSH PRIVILEGES = aplicar cambios

⸻

🚀 TIP FINAL PARA EL EXAMEN

Si dudas:
👉 piensa en seguridad + control de acceso
	•	quién entra → usuario
	•	qué puede hacer → privilegios
	•	cómo agrupar → roles
	•	cómo optimizar → índices

⸻

Si quieres, te hago ahora un examen real tipo test (nivel FP) para practicar antes de entrar 💀

Perfecto — te hago una pequeña extensión tipo “extra para rascar nota” que puedes añadir al final de tu chuleta sin hacerla demasiado larga 👇

⸻

➕ EXTENSIÓN (DETALLES QUE SUMAN PUNTOS)

⸻

🔹 5. TIPOS DE PRIVILEGIOS IMPORTANTES

📌 No todos los permisos son iguales:
	•	DML (datos):
	•	SELECT, INSERT, UPDATE, DELETE
	•	DDL (estructura):
	•	CREATE, ALTER, DROP
	•	ADMIN:
	•	GRANT OPTION → permite dar permisos a otros

💡 Pregunta típica:
👉 ¿Qué permiso permite modificar estructura? → ALTER

⸻

🔹 6. NIVELES DE PRIVILEGIOS

📌 MySQL permite dar permisos a distintos niveles:

Nivel	Ejemplo	Qué afecta
Global	*.*	Todo el servidor
Base de datos	tienda.*	Toda la BD
Tabla	tienda.clientes	Tabla concreta
Columna	(raro en examen)	Columna

💡 Truco:
Cuanto más específico → más seguro

⸻

🔹 7. SEGURIDAD BÁSICA (MUY PREGUNTABLE)

📌 Buenas prácticas:
	•	❌ NO usar % si no hace falta
	•	✅ Usar contraseñas fuertes
	•	✅ Limitar permisos (principio de mínimo privilegio)
	•	✅ Usar roles en vez de permisos directos

💡 Frase clave examen:
👉 “mínimo privilegio = solo lo necesario”

⸻

🔹 8. ORDEN LÓGICO (PREGUNTA TRAMPA)

📌 Cómo se trabaja normalmente:
	1.	Crear usuario
	2.	Crear rol (opcional)
	3.	Dar permisos
	4.	Asignar rol
	5.	FLUSH PRIVILEGES

💡 Si te piden “proceso completo” → este orden

⸻

🔹 9. ERRORES COMUNES

❌ Olvidar el host
❌ Confundir GRANT con REVOKE
❌ No usar FLUSH PRIVILEGES
❌ Pensar que GRANT rol activa el rol (NO)

⸻

🔹 10. DIFERENCIA CLAVE (RESUMEN PRO)

Concepto	Función
Usuario	Accede al sistema
Privilegio	Permiso concreto
Rol	Grupo de permisos
Índice	Mejora rendimiento


⸻

⚡ MINI EXTRA FINAL (DE LOS QUE DAN PUNTOS)

👉 ¿Por qué usar índices?
	•	Evitan escaneo completo de tabla
	•	Mejoran SELECT y JOIN

👉 ¿Cuándo NO usar muchos índices?
	•	Porque ralentizan INSERT y UPDATE

⸻

🧠 FRASES CLAVE PARA REDACTAR

Si es examen teórico, suelta esto:
	•	“MySQL gestiona el acceso mediante usuarios y privilegios”
	•	“Los roles permiten una administración más eficiente”
	•	“Los índices optimizan el rendimiento de las consultas”
	•	“Se debe aplicar el principio de mínimo privilegio”

⸻
