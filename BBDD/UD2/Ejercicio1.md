# Enunciado: Sistema de Gestión de Cursos

Una academia de formación necesita un sistema para gestionar los cursos que imparte y los estudiantes que los toman. A continuación se describen los elementos del sistema:

1. **Estudiantes**: Cada estudiante tiene un número de identificación único, nombre, dirección y fecha de nacimiento.
2. **Profesores**: Cada profesor tiene un número de identificación único, nombre, especialidad y teléfono. Cada profesor imparte un único curso.
3. **Cursos**: Cada curso tiene un código único, nombre, duración y descripción. Un profesor imparte un curso, pero un curso puede tener varios estudiantes.
4. **Inscripciones**: Los estudiantes pueden inscribirse en varios cursos, y un curso puede tener varios estudiantes. Cada inscripción almacena la fecha en la que el estudiante se inscribió al curso.

## Relaciones

- Cada **profesor** imparte un único **curso**.
- Un **curso** puede tener varios **estudiantes**, pero un estudiante solo puede estar inscrito en un curso a la vez.
- Un **estudiante** puede estar inscrito en varios **cursos**, y un curso puede tener varios estudiantes.

## Tareas

1. Realiza el Diagrama Entidad-Relación (ER) para representar el sistema de gestión de cursos.
2. A partir del Diagrama ER, transforma el diseño en un modelo relacional.
