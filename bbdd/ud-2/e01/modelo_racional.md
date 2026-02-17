ESTUDIANTES(**idEstudiante**, nombre, direccion, fecha_nacimiento)
CURSOS(**idCurso**, nombre, duracion, descripcion)
INSCRIPCIONES(**idEstudiante**, fecha_inicio, **FK: idCurso, FK: idEstudiante**)
PROFESORES(**idProfesor**, nombre, especialidad, telefono, **FK: idCurso**)