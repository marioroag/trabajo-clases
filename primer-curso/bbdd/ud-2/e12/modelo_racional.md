PROFESOR(__NRP__, nombre, areaConocimiento, categoria, **idDepartamento**)
DEPARTAMENTO(**idDepartamento**, **NRP_DIRECTOR**)
GRUPO(**codigo**, maxAlumnos, tipo)
GRUPO_TEORIA(**codigo**, horasClase)
PK: codigo, en "GRUPO_TEORIA" viene de la tabla "GRUPO(codigo)"
GRUPO_PRACTICA(**codigo**, taller)
PK: codigo, en "GRUPO_PRACTICA" viene de la tabla "GRUPO"
ALUMNO(**DNI**, fechaNacimiento, nombre, beca)
