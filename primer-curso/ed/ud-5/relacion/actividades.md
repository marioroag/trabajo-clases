# Actividades para practicar diagramas de clases UML

- [Actividades para practicar diagramas de clases UML](#actividades-para-practicar-diagramas-de-clases-uml)
  - [Actividad 1. Sistema de usuarios sencillo](#actividad-1-sistema-de-usuarios-sencillo)
  - [Actividad 2. Biblioteca mínima](#actividad-2-biblioteca-mínima)
  - [Actividad 3. Catálogo de productos con herencia](#actividad-3-catálogo-de-productos-con-herencia)
  - [Actividad 4. Gestión académica](#actividad-4-gestión-académica)
  - [Actividad 5. Sistema logístico de reparto](#actividad-5-sistema-logístico-de-reparto)
  - [Actividad 6. Plataforma de comercio electrónico (con opción de mejora)](#actividad-6-plataforma-de-comercio-electrónico-con-opción-de-mejora)
  - [Actividad 7. Videojuego básico con herencia](#actividad-7-videojuego-básico-con-herencia)
  - [Actividad 8. Sistema de biblioteca con herencia y clase intermedia](#actividad-8-sistema-de-biblioteca-con-herencia-y-clase-intermedia)
  - [Actividad 9. Sistema de secretaría académica completo](#actividad-9-sistema-de-secretaría-académica-completo)
  - [Actividad 10. Sistema de evaluación de un módulo de Formación Profesional](#actividad-10-sistema-de-evaluación-de-un-módulo-de-formación-profesional)

## Actividad 1. Sistema de usuarios sencillo

En esta primera actividad se trabajará con un único concepto principal para centrarse en la identificación de clases, atributos y métodos.

Se desea modelar un sistema muy básico de gestión de usuarios de una aplicación. El sistema debe permitir representar usuarios con un nombre, un correo electrónico y una contraseña, así como operaciones relacionadas con su gestión.

A partir de este enunciado, crea un diagrama de clases UML que cumpla los siguientes requisitos:

- Debe existir una clase que represente al usuario.
- La clase debe incluir atributos que representen la información básica.
- La clase debe incluir métodos relacionados con su comportamiento.
- No escribas código Java, solo el diagrama UML.

## Actividad 2. Biblioteca mínima

En esta actividad se introduce la relación entre clases y el uso de multiplicidades.

La biblioteca gestiona libros y lectores. Cada libro tiene un título y un autor. Cada lector tiene un nombre y un número de socio. Un lector puede tomar prestados varios libros, pero un libro solo puede estar prestado a un lector al mismo tiempo.

El diagrama debe incluir las clases necesarias, sus atributos principales y la relación entre ellas con multiplicidades correctamente indicadas.

## Actividad 3. Catálogo de productos con herencia

En esta actividad se incorpora el uso de generalización y especialización entre clases.

Una empresa quiere modelar su catálogo de productos. Cada producto tiene un código, un nombre y un precio. Existen productos digitales y productos físicos. Los productos físicos tienen peso y dimensiones, mientras que los digitales incluyen una URL de descarga.

Representa las clases necesarias, aplicando herencia donde corresponda, y añade al menos un método común que pueda heredarse desde la clase base.

## Actividad 4. Gestión académica

En esta actividad se combinan varias clases con distintas asociaciones y multiplicidades.

Se desea modelar un sistema de gestión académica. Existen estudiantes y profesores, ambos con nombre y correo electrónico. Los profesores imparten asignaturas y los estudiantes se matriculan en ellas. Cada asignatura tiene un código y un título.

Incluye en el diagrama todas las clases implicadas, sus atributos, métodos representativos y las asociaciones entre ellas con sus multiplicidades correctas.

## Actividad 5. Sistema logístico de reparto

En esta actividad se incrementa la complejidad introduciendo herencia junto con agregación o composición, que deberán decidirse de forma razonada.

Una empresa de reparto quiere modelar su sistema logístico. Los pedidos están formados por uno o varios paquetes. Cada paquete tiene peso y volumen. Un pedido pertenece a un cliente, que tiene nombre y dirección. Los pedidos se asignan a repartidores, que son empleados de la empresa y tienen un identificador y un salario.

Representa las relaciones entre clases usando herencia cuando proceda y decide cuándo debe utilizarse agregación o composición, justificando la elección de cada relación en el modelo.

## Actividad 6. Plataforma de comercio electrónico (con opción de mejora)

Esta última actividad integra todos los conceptos trabajados en la unidad.

Se quiere diseñar el modelo de clases para una plataforma de comercio electrónico. Los usuarios pueden registrarse y realizar pedidos. Cada pedido contiene varias líneas de pedido, y cada línea hace referencia a un producto y a una cantidad concreta. Los productos pueden pertenecer a diferentes categorías. Algunos usuarios tienen rol de administrador y pueden gestionar el catálogo.

Crea un diagrama completo que incluya:

- Herencia para distinguir tipos de usuarios.
- Composición donde una entidad no pueda existir sin otra.
- Asociaciones con multiplicidades precisas.
- Métodos relevantes en las clases principales.

Como mejora opcional, añade un enumerado para representar el estado de un pedido (por ejemplo: creado, pagado, enviado, entregado) e intégralo correctamente en el modelo.

## Actividad 7. Videojuego básico con herencia

En esta actividad se trabajará la identificación de jerarquías de clases y relaciones simples con multiplicidad.

Se desea modelar el núcleo estructural de un videojuego. En el sistema existen distintos elementos que pueden aparecer en el escenario:

- Personajes.
- Enemigos.
- Objetos muebles (móviles).
- Objetos inmuebles (inmóviles).

Todos los elementos del juego tienen una posición definida por coordenadas `x` e `y`.

Los personajes y los enemigos comparten características comunes: nivel de energía, número de vidas y capacidad ofensiva.

Los personajes pueden recoger hasta tres objetos muebles en una mochila.

Las armas son un tipo de objeto mueble que dispone de un nivel de energía propio y un factor potenciador de la capacidad ofensiva del personaje que la utiliza.

## Actividad 8. Sistema de biblioteca con herencia y clase intermedia

En esta actividad se trabajará la modelización de herencia múltiple junto con relaciones mediadas por una clase intermedia.

Se desea diseñar un sistema para gestionar una biblioteca. En el sistema existen distintos tipos de materiales que pueden ser prestados a los usuarios.

Todos los materiales de la biblioteca tienen un título, un autor o editor y un código único de identificación.

Existen tres tipos de materiales:

- Libros, que tienen número de páginas y categoría.
- Revistas, que tienen número de edición y fecha de publicación.
- Periódicos, que tienen nombre, fecha de publicación y país de origen.

Los usuarios pueden solicitar préstamos de materiales. Cada usuario tiene un nombre y un número de identificación.

El sistema debe registrar cada préstamo indicando:

- El usuario que realiza el préstamo.
- El material prestado.
- La fecha de inicio.
- La fecha de devolución.

Un usuario puede tener hasta cinco materiales prestados simultáneamente. Un material solo puede estar asociado a un préstamo activo en un momento dado.

## Actividad 9. Sistema de secretaría académica completo

En esta actividad se trabajará el modelado de un sistema académico completo que combina herencia implícita, asociaciones múltiples, restricciones numéricas y clases intermedias.

Se desea diseñar el diagrama de clases de una aplicación para la gestión de la secretaría de un centro educativo.

Cuando un alumno se matricula, debe rellenar una ficha con los siguientes datos:

- DNI.
- Número de expediente.
- Nombre.
- Apellidos.
- Domicilio.
- Teléfono.
- Correo electrónico.

El centro ya dispone de información sobre los cursos que se imparten. De cada curso se almacena:

- Código.
- Nombre.
- Aula.
- Horario.

Cada curso incluye varias asignaturas. De cada asignatura se desea almacenar:

- Nombre.
- Número de horas semanales.
- Profesor que la imparte.

Los profesores forman parte del sistema y de cada uno se guarda:

- Nombre.
- Apellidos.
- Domicilio.
- Correo electrónico.

Un profesor:

- Puede impartir como máximo seis asignaturas.
- Debe impartir al menos una.
- Puede ser tutor de un curso, aunque no es obligatorio que lo sea.

Los alumnos se matriculan en asignaturas. Cada alumno debe estar matriculado en al menos una asignatura.

El sistema debe almacenar también:

- Las notas de cada alumno en cada asignatura a lo largo de las distintas evaluaciones.
- Las observaciones asociadas a dichas evaluaciones.
- El compañero con el que cada alumno realiza prácticas o trabajos en cada asignatura (siempre el mismo durante el curso).

## Actividad 10. Sistema de evaluación de un módulo de Formación Profesional

En esta actividad se trabajará el modelado estructural completo de un sistema real de evaluación de un módulo profesional dentro de un ciclo formativo de Formación Profesional.

Se desea diseñar el diagrama de clases de una aplicación que represente cómo se organiza y evalúa un módulo profesional en un ciclo formativo de DAM o DAW según la normativa vigente.

El sistema debe permitir modelar:

- El ciclo formativo al que pertenece el módulo.
- Los módulos profesionales que componen el ciclo.
- Los Resultados de Aprendizaje (RA) de cada módulo.
- Los Criterios de Evaluación (CE) asociados a cada RA.
- Los alumnos matriculados en el módulo.
- Los profesores que lo imparten.
- Los instrumentos de evaluación utilizados.
- Las evaluaciones trimestrales.
- Las convocatorias oficiales.
- Las calificaciones obtenidas por los alumnos.

Un ciclo formativo tiene un nombre y una duración total en horas, y está compuesto por varios módulos profesionales.

Un módulo profesional tiene un nombre y un número total de horas, pertenece a un ciclo formativo y está formado por varios Resultados de Aprendizaje.

Cada Resultado de Aprendizaje tiene un código identificador (por ejemplo: RA1, RA2) y una descripción, e incluye varios Criterios de Evaluación.

Cada Criterio de Evaluación tiene un código identificador (por ejemplo: 1.a, 2.c), una descripción y pertenece exactamente a un Resultado de Aprendizaje.

En el sistema existen personas:

- Alumnos, que tienen nombre, apellidos y número de expediente, están matriculados en un módulo profesional y obtienen calificaciones en los distintos criterios de evaluación.
- Profesores, que tienen nombre y correo electrónico e imparten uno o varios módulos profesionales.

Cada módulo profesional se evalúa mediante distintos instrumentos de evaluación (exámenes, actividades, proyectos, etc.), está dividido en evaluaciones trimestrales y puede tener varias convocatorias oficiales (por ejemplo, ordinaria y extraordinaria).

Cada instrumento de evaluación tiene un nombre y un porcentaje de ponderación, y evalúa uno o varios Criterios de Evaluación.

El sistema debe almacenar:

- La calificación obtenida por cada alumno en cada Criterio de Evaluación.
- Las observaciones asociadas a dichas calificaciones cuando existan.
- La nota final del módulo en cada convocatoria.

Deben tenerse en cuenta las siguientes restricciones:

- Un módulo debe tener al menos un Resultado de Aprendizaje.
- Un Resultado de Aprendizaje debe tener al menos un Criterio de Evaluación.
- Un profesor debe impartir al menos un módulo profesional.
- Un instrumento de evaluación debe evaluar al menos un Criterio de Evaluación.
- Cada calificación debe estar asociada a un alumno y a un Criterio de Evaluación concreto.
- La nota final del módulo debe depender de las calificaciones obtenidas en los distintos Criterios de Evaluación.
