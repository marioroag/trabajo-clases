### Prueba Técnica 1 Base de Datos 1º DAM

#### *14/10/2025*

#### Ejercicio 1. Base de datos Bar las Tostas.

Junto a la Plaza de Toros de Granada existe un bar llamados Las Tostas que desde hace años ha innovado en su servicio al cliente de la siguiente forma. Los camareros no tienen que tomar nota y únicamente se dedican a servir las mesas, la comanda se toma de forma telemática. Para la base de datos que alimenta a la aplicación necesitaremos lo siguiente.

- Los usuarios que se apuntan en la app del bar, los cuales se registrarán con un nombre, un correo y un numero de telefono.
- Las mesas, de las cuales únicamente querremos saber su número y número máximo de comensales que pueden sentarse en ella.
- Cada usuario podrá sentarse únicamente en una mesa.
- Un usuario, durante su estancia en la mesa, puede hacer tantos pedidos como quiera.
- De un pedido se desea saber únicamente el cliente que lo ha realizado y los artículos que ha pedido.
- De un artículo se desea saber que tipo es (bebida, tapa o ración), precio, nombre y alérgenos que contiene.
- De un alérgeno se sabrá solo el nombre y un nivel de urgencia del 1 al 5.
- Cuando un artículo se pide en un pedido se debería saber la cantidad que se ha pedido. Por ejemplo, en un mismo pedido se deberían poder pedir 2 cocacolas y 3 tapas de croquetas.

#### Ejercicio 2. Base de Datos Trofeo Grados Granada

Los distintos centros de Grados de FP en la ciudad de Granada han decidido crear una serie de torneos de distintos deportes para promocionar la actividad deportiva entre sus alumnos. Para ello ha decidido crear una base de datos para gestionar la información de estudiantes, profesores, torneos, deportes, partidos, equipos y academias que participarán. Se requiere que el sistema cumpla con las siguientes especificaciones:

---

- Se asume que tanto profesores como estudiantes pueden participar de las actividades deportivas. En una categoría que abarque a los dos, llamada participantes, se desea almacenar nombre, dni, numero de telefono y una fotografía de cada jugador. Tanto estudiantes como trabajadores son tipos de participantes.

  - De los estudiantes se desea almacenar también el curso donde están matriculados y el grado.
  - De los profesores, su numero de la Seguridad Social y su área de conocimiento
- De los estudiantes se desea saber en qué academia estudian, la cual es única. Sin embargo los trabajadores pueden trabajar para más de una academia.
- De una academia se quiere saber nombre, dirección y año de apertura.
- Los equipos están formados por un nombre y inscriben a un torneo concreto y se desea saber también a qué academia pertenecen. De un equipo se deberá saber a qué torneo (único) está inscrito y de qué academia viene, además de los jugadores que lo forman.
- Cada equipo tendrá además un capitán.
- Un participante se puede apuntar a tantos equipos como quiera.
- Aunque un alumno o profesor no esté apuntado aún a ningún equipo, se debería poder saber en qué academia estudia/trabaja.
- De un torneo se debe poder saber nombre, número maximo de equipos que pueden inscribirse y de qué deporte se trata.
- Dado que la aplicación en principio está pensada solo para usarse durante el año 2026, se asumirá que cada deporte tiene sólo un torneo.
- De un deporte además se quiere saber nombre, número maximo de inscritos por equipo y número mínimo de inscritos por equipo.
- De los partidos se quiere saber los dos equipos que participan, la fecha cuando se realizará y el lugar.
- Adermás, para cada partido un único miembro de la entidad participantes participará como árbitro.
- De cada partido se debe poder saber quién será su árbitro.

---

Realiza el diagrama E-R necesario para diseñar la base de datos que necesita nuestra aplicación.
