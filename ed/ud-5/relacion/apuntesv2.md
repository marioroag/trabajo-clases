Para un diagrama de clases UML de análisis (como suelen pedir en DAW) normalmente se ponen:
	•	Clases
	•	Atributos
	•	Métodos básicos
	•	Relaciones
	•	Cardinalidades
	•	Herencia
	•	Clases de asociación

Te dejo todo completo para que puedas dibujarlo directamente.

⸻

1️⃣ Clase Socio

Atributos
	•	dni : String
	•	nombre : String
	•	direccion : String
	•	telefono : String
	•	fechaIncorporacion : Date

Métodos
	•	registrarSocio()
	•	actualizarDatos()
	•	agregarEmbarcacion()
	•	eliminarEmbarcacion()
	•	comprarAmarre()

⸻

2️⃣ Clase Embarcacion

Atributos
	•	matricula : String
	•	nombre : String
	•	tipo : String
	•	dimensiones : String

Métodos
	•	registrarEmbarcacion()
	•	actualizarDatos()
	•	asignarAmarre()
	•	liberarAmarre()

⸻

3️⃣ Clase Amarre

Atributos
	•	idAmarre : int
	•	lecturaAgua : double
	•	lecturaLuz : double
	•	mantenimientoContratado : boolean

Métodos
	•	actualizarLecturaAgua()
	•	actualizarLecturaLuz()
	•	contratarMantenimiento()
	•	liberarAmarre()
	•	asignarEmbarcacion()

⸻

4️⃣ Clase Zona

Atributos
	•	letra : String
	•	tipoEmbarcaciones : String
	•	numeroBarcos : int
	•	profundidad : double
	•	anchoAmarres : double

Métodos
	•	agregarAmarre()
	•	eliminarAmarre()
	•	asignarEmpleado()
	•	consultarAmarres()

⸻

5️⃣ Clase Empleado

Atributos
	•	codigoEmpleado : int
	•	nombre : String
	•	direccion : String
	•	telefono : String

Métodos
	•	asignarZona()
	•	consultarZonas()
	•	registrarActividad()

⸻

6️⃣ Subclases de Empleado

EmpleadoOperacion

(Hereda de Empleado)

Métodos
	•	atenderSocio()
	•	supervisarZona()

⸻

EmpleadoMantenimiento

Métodos
	•	repararInstalacion()
	•	revisarEmbarcacion()

⸻

7️⃣ Clases de asociación

Estas son clave porque el enunciado dice que la fecha pertenece a la relación.

⸻

AsignacionAmarre

(Relación entre Embarcacion y Amarre)

Atributos
	•	fechaAsignacion : Date

Métodos
	•	registrarAsignacion()
	•	finalizarAsignacion()

⸻

PropiedadAmarre

(Relación entre Socio y Amarre)

Atributos
	•	fechaAdquisicion : Date

Métodos
	•	registrarCompra()

⸻

EmpleadoZona

(Relación entre Empleado y Zona)

Atributos
	•	numeroEmbarcacionesResponsable : int

Métodos
	•	asignarResponsabilidad()

⸻

8️⃣ Relaciones (cardinalidad UML)

Socio 1 ———— * Embarcacion

Embarcacion 1 ———— 1 Amarre
(clase asociación: AsignacionAmarre)

Socio 1 ———— * Amarre
(clase asociación: PropiedadAmarre)

Zona 1 ———— * Amarre

Empleado *** ———— *** Zona**
(clase asociación: EmpleadoZona)

Empleado △ herencia

Empleado
   ▲
   │
 ┌───────────────┐
 │               │
EmpleadoOperacion
EmpleadoMantenimiento


⸻

9️⃣ Estructura final del UML (resumen)

Clases:
	•	Socio
	•	Embarcacion
	•	Amarre
	•	Zona
	•	Empleado
	•	EmpleadoOperacion
	•	EmpleadoMantenimiento
	•	AsignacionAmarre
	•	PropiedadAmarre
	•	EmpleadoZona

⸻

💡 Consejo para DAW:
En este ejercicio el profesor seguramente quiere que detectes 3 cosas clave:

1️⃣ Clases asociativas con atributos
2️⃣ Herencia en empleados
3️⃣ Cardinalidades correctas

⸻

Si quieres, puedo también dibujarte el diagrama UML completo exactamente como quedaría en el examen, porque visualmente es mucho más fácil de memorizar y te puede ahorrar mucho tiempo en la prueba.