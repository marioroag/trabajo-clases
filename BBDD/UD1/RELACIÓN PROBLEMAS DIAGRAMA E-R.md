# **Ejercicio 1:**

Se desea construir una base de datos que almacene la carta de un restaurante.

* Para cada plato, se desea obtener su nombre, descripción, una foto y el precio final para el cliente.  
* Cada plato pertenece a una categoría.  
* Las categorías se caracterizan por su nombre y una breve descripción.  
* Además de los platos, se desean conocer las recetas para su realización.  
* De cada receta queremos conocer el código de receta, el tiempo de elaboración y el nivel de dificultad.  
* Cada receta usa una serie de ingredientes, aportando la cantidad requerida y las unidades de medida (gramos, litros, etc.).  
* De cada ingrediente se desea conocer el nombre, una foto y la cantidad de stock disponible.

Realiza el diagrama Entidad-Relación.

# **Ejercicio 2:**

Disponemos de los siguientes elementos de información: Tarjetas de crédito (identificadas por un número, pueden ser de distinto tipo), titulares de dichas tarjetas (de los que conocemos DNI, domicilio y teléfono) y cuentas corrientes (con un código, un saldo y una fecha de apertura).

* Cada persona puede tener más de una tarjeta.  
* Cada tarjeta tiene un único titular o propietario.  
* Cada tarjeta está asociada a una única cuenta.  
* Podemos cargar más de una tarjeta a una cuenta determinada.  
* Cada cuenta pertenece a una sola persona.  
* Una persona puede tener más de una cuenta.

Realiza el diagrama Entidad-Relación.

# **Ejercicio 3:**

Con la próxima edición de la Vuelta Ciclista a España, un periódico deportivo quiere crear una base de datos para mantener información sobre las pruebas ciclistas por etapas.

* En la base de datos debe aparecer información sobre los ciclistas, los equipos a los que pertenecen y las pruebas en las que cada equipo ha participado (se asume que participa todo el equipo).  
* De cada ciclista, se desea conocer su nombre, nacionalidad y fecha de nacimiento, así como el equipo al que pertenece, manteniendo la fecha de inicio y fin de contrato con el equipo.  
* De cada equipo también se desea conocer su nombre, su nacionalidad, el nombre del director y las pruebas en las que ha participado, con su nombre, año de edición, número de etapas, kilómetros totales y puesto que ocupó el equipo en la clasificación final.  
* Un dato adicional para las pruebas es saber el nombre del ciclista que quedó ganador.

Realiza el diagrama E-R.

# **Ejercicio 4:**

Acabas de empezar tu colección de películas y quieres hacer una base de datos para construir su ficha técnica. 

* De cada película, necesitas su título, año, nacionalidad y algunos datos de su director: el nombre, la fecha de nacimiento y su país de origen.  
* Además, quieres saber el idioma de la película, si está en blanco y negro o en color, si tiene alguna restricción de edad, un resumen y poder poner tus propias observaciones.  
* La ficha técnica de cada película también debe incluir el reparto de actores, donde aparecerá su nombre, su nacionalidad y el nombre del personaje que tiene en la película.

Realiza el diagrama E-R.

# **Ejercicio 5:**

Se desea crear una base de datos que contenga información sobre las revistas a las que estás suscrito o compras habitualmente.

* De cada publicación, se pide su título, el ISSN (un código que identifica a la revista), el número y el año de publicación.   
* También se desea almacenar información de cada uno de los artículos publicados: el título, la página de inicio y la página de fin. Se asume que no hay dos artículos con el mismo título.   
* Cada artículo puede estar escrito por varios autores, de quienes interesa conocer su nombre, una dirección de correo electrónico y su departamento, así como un número que indique la posición en la que aparece en cada artículo: un 1 si es el primer autor, un 2 si aparece en segundo lugar, etc.

Realiza el diagrama E-R.

# **Ejercicio 6:**

Una ONG desea elaborar una base de datos para llevar el seguimiento de todos sus proyectos.

* Tiene diversas sedes en varios países que se encargan de gestionar y coordinar los proyectos de ese país, cada uno de los cuales puede afectar a una o varias poblaciones.   
* Sobre la sedes se desea mantener un identificador, la ciudad y país en el que se encuentra, junto con su dirección, un teléfono de contacto y el nombre del director.  
* Cada sede gestiona un conjunto de proyectos, con un código, un título, fechas de inicio y finalización, el presupuesto asignado y el nombre del responsable.  
* De cada proyecto es necesario conocer qué actuaciones se realizan en cada población,almacenando el nombre, país y número de habitantes y un identificador para diferenciarlas.   
* Además, se desea conocer la inversión del proyecto que corresponde a la población y una pequeña descripción de la actuación.

Realiza el diagrama E-R.

# **Ejercicio 7:**

Un parque zoológico quiere construir una BD para organizar las especies que posee y los distintos itinerarios para visitar el parque.

* De las especies, se desea conocer su nombre común (puede tener varios) y su nombre científico, así como una descripción general y una fotografía.  
* Cada especie puede vivir en distintos hábitats naturales, definidos por su nombre, clima y vegetación predominante. Cada especie tiene asociado un índice de vulnerabilidad dentro de cada hábitat, que mide el riesgo de extinción de la especie en dicho hábitat.  
* Para organizar las visitas, y en función de los hábitats que desee recorrer un visitante, el parque le ofrece una serie de recorridos por los hábitats, que se identifican por su código y se caracterizan por su duración estimada, longitud y número máximo de visitantes permitidos.   
* Un hábitat solo puede formar parte de un recorrido.

Realiza el diagrama E-R.

# **Ejercicio 8:**

Una agencia de publicidad necesita una base de datos para registrar todas sus campañas en la web.

* Sus clientes tienen un nombre, una dirección postal, el número de teléfono y una dirección de email.  
* Cada cliente puede contratar varios anuncios.  
* Los anuncios quedan identificados por un código y se caracterizan por un nombre, tipo (banner, popup, enlace patrocinado, etc.), título, contenido, categoría (tipo del producto que anuncia) y precio.   
* Los anuncios pueden aparecer en más de una página web.  
* Cada web se caracteriza por su URL, nombre y tópico de interés. También se debe almacenar la fecha de inicio y de fin de la aparición del anuncio en la página web.

Realiza el diagrama E-R.

# **Ejercicio 9:**

Tenemos que diseñar una base de datos para una empresa de material informático, de la que tenemos esta información:

* Un equipo consta de varios componentes. Pueden ser necesarios varios componentes del mismo tipo para montar un equipo, por lo que será necesario almacenar la cantidad de componentes que se necesitan en cada caso.  
* Un cliente puede comprar artículos. Los artículos pueden ser equipos completos o componentes sueltos. Habrá que almacenar la cantidad de artículos que compra cada cliente. También habrá que guardar la fecha de compra.  
* De cada artículo guardamos un código de artículo.  
* Tenga en cuenta que un mismo cliente puede comprar el mismo artículo en diferentes fechas. El diseño de la base de datos debe permitir almacenar un histórico con todas las fechas y las cantidades de artículos que se han comprado.  
* Cada equipo está etiquetado con un nombre, una descripción, un precio y el stock disponible.  
* Cada componente está etiquetado con un nombre, una descripción, un precio y el stock disponible.  
* Los datos que almacenamos de los clientes son el NIF, nombre, apellidos, domicilio, ciudad, provincia y teléfono.  
* Los datos que almacenamos de los empleados son el NIF, nombre, apellidos y la sección donde trabaja.  
* Un empleado trabaja en una única sección.  
* Una sección se identifica por un id y un nombre de sección.  
* Toda sección tiene un director (que es un empleado).  
* En cada compra realizada por un cliente interviene un empleado y será necesario guardar qué empleado es el que ha atendido a cada cliente para cada una de las compras.

Realiza el diagrama Entidad-Relación.

# 

# **Ejercicio 10:**

Una base de datos para una pequeña empresa debe contener información acerca de clientes, artículos y pedidos. Hasta el momento se registran los siguientes datos en documentos varios:

* Para cada cliente: Número de cliente (único), direcciones de envío (varias por cliente), saldo y descuento.  
* Para cada artículo: Número de artículo (único), fábricas que lo distribuyen, existencias de ese artículo en cada fábrica, descripción del artículo.  
* Cada pedido está formado por el número del cliente, la dirección de envío y la fecha del pedido. Se debe indicar la cantidad de productos de cada tipo que contiene el pedido.  
* Además, se ha determinado que se debe almacenar la información de las fábricas. Número de fábrica (único) y teléfono de contacto. Y se desea ver cuántos artículos (en total) provee la fábrica.   
* NOTA: La dirección se entiende como número, calle, pueblo y ciudad. La fecha incluye la hora.

Realiza el diagrama Entidad-Relación.

# **Ejercicio 11:**

Se desea diseñar la bbdd de un aeropuerto:

* De cada aeropuerto se conoce su código, nombre, ciudad y país.  
* En cada aeropuerto pueden aterrizar diversos modelos de aviones. El modelo de un avión determina su capacidad, es decir, el número de plazas.  
* Existe una colección de programas de vuelo. En cada programa de vuelo se indica la compañía, la ruta aérea y los días de la semana en que existe dicho vuelo.  
* Cada programa de vuelo despega de un aeropuerto y aterriza en otro.  
* Los números de vuelo son únicos para todo el mundo.  
* En cada aeropuerto hay múltiples aterrizajes y despegues.  
* Cada vuelo realizado pertenece a un cierto programa de vuelo.  
* Para cada vuelo se quiere conocer su fecha, plazas vacías y el modelo de avión utilizado.

Realiza el diagrama Entidad-Relación.

# 

# 

# 

# **Ejercicio 12:**

Se quiere obtener el esquema conceptual correspondiente a la organización docente de un centro. Algunas de las restricciones:

* Se considera que un profesor pertenece a un solo departamento y que debe pertenecer a alguno.  
* Se considera que un profesor puede impartir a varios grupos de la misma o de diferentes asignaturas y que un grupo de una asignatura ha de ser impartido por, al menos, un profesor.  
* Existen dos tipos de grupos, los de teoría y los de prácticas, con un máximo de alumnos por grupo.  
* De los grupos de teoría se almacenan las horas de clase y de los grupos de práctica el taller utilizado.  
* Los alumnos se matriculan de varias asignaturas (al menos una) pero han de hacerlo en un determinado grupo. A su vez, cada grupo tendrá varios alumnos matriculados.  
* Todo departamento debe tener un director, que es un profesor.

Atributos:

* De los profesores se almacena: el NRP, el nombre, el área de conocimiento y la categoría.  
* De los departamentos se almacena: Código de departamento.  
* De los grupos se almacena: El código de grupo, el máximo de alumnos y el tipo.  
* De las asignaturas se almacena: el código de la asignatura, el nombre, los créditos, el carácter y el curso.  
* De los alumnos se almacena: el nombre, el DNI, la fecha de nacimiento, la dirección y la beca.

Realiza el diagrama Entidad-Relación.

# 

# 

# **Ejercicio 13:**

Se organiza la información relativa a una serie de carreras locales.

* Un participante puede participar en varias carreras.  
* Del participante queremos saber el nombre, DNI y número de dorsal.  
* Cada organizador asiste a varias carreras.  
* De cada organizador queremos saber su nombre, edad, cargo y fecha de inicio como organizador.  
* La carrera se divide en etapas.  
* De cada etapa queremos saber el número de etapa y los kilómetros. Cada etapa pertenece a una única carrera.  
* De cada carrera queremos saber la fecha, el lugar de inicio y el lugar de fin.  
* Si la carrera es a pie, queremos saber el desnivel total.  
* Si la carrera es en bicicleta queremos saber la temperatura, si llueve o no y las bicicletas permitidas.  
* De las bicicletas permitidas queremos saber si son eléctricas o no, el peso y el modelo de bicicleta.  
* Además, cada carrera tiene un director de carrera que es un tipo de organizador del que queremos saber su curriculum.

Realiza el diagrama Entidad-Relación.

# **Ejercicio 14:**

Se organiza la información relativa a una compañía de seguros de automóvil, donde se mantienen los datos acerca de los clientes, los vehículos, las pólizas y los partes de accidente.

* Un cliente puede tener asegurado más de un vehículo en la compañía.  
* De cada cliente queremos conocer DNI, nombre, fecha de nacimiento y fecha de obtención del permiso de conducir.  
* De cada vehículo se desea conocer la matrícula, el número de bastidor, marca, modelo, color y fecha de primera matriculación.  
* Cada vehículo posee una única póliza de seguro identificada por un número de póliza y un precio.  
* Cada póliza puede tener asociada varias coberturas.  
* De la cobertura se desea almacenar el tipo, un código identificador de cobertura y la cuantía que asegura.  
* Sobre los siniestros ocurridos deberá conocerse la fecha, el lugar, la causa y la cuantía de los daños ocasionados. 

Realiza el diagrama Entidad-Relación.

# **Ejercicio 15:**

Consideraremos la gestión de la información que se manipula en un hospital.

* De cada paciente queremos saber nombre, apellidos, DNI, número de Seguridad Social y fecha de nacimiento.  
* Las habitaciones pueden tener varias camas, que irán numeradas y serán de un determinado tipo. De cada habitación queremos conocer la planta y el número de habitación.  
* Durante un ingreso, el paciente ocupará una misma cama y habitación y se le podrán realizar tantas pruebas como sea necesario. Queremos saber la fecha de ingreso y alta del paciente.  
* Los distintos tipos de pruebas van codificadas y se realizan con un determinado aparato.  
* Es importante saber cuándo (fecha) se ha realizado cada prueba a un paciente y qué especialista la ha llevado a cabo.  
* De el especialista queremos el número de colegiado, el nombre y la especialidad.  
* De los aparatos queremos conocer el nombre, si son eléctricos o no, y si es un aparato fungible o no.

Realiza el diagrama Entidad-Relación.

# **Ejercicio 16:**

Se desea crear una bbdd con información sobre todas las carreteras del país:

* Las carreteras tienen identificador, y pueden ser de distintas categorías (locales, comerciales, regionales, nacionales, autovías, etc).  
* Las carreteras se dividen en tramos.  
* Un tramo siempre pertenece a una única carretera y no puede cambiar de carretera.  
* Un tramo puede pasar por varios municipios, nos interesa conocer el Km de la carretera y el municipio en el que empieza el tramo de carretera y el municipio donde termina.  
* Para los tramos que suponen final de carretera, interesa saber si es que la carretera acaba o es que se une a otra carretera. En este caso de que se una a otra carretera, interesa conocer con qué carretera se une, en qué kilómetro, tramo y municipio.

Realiza el diagrama Entidad-Relación.

# **Ejercicio 17**

* Las sedes olímpicas se dividen en complejos deportivos.   
* Para cada sede, se conservará el nombre, la ciudad, el país, el número de complejos que tiene y su presupuesto asignado.  
* Un complejo tiene un identificador, una localización, un jefe de organización individual (que es un comisario) y un área total ocupada. Solo puede haber un jefe de organización y este no puede serlo de varios complejos.  
* Los complejos deportivos se subdividen en aquellos en los que se desarrolla un único deporte y en los polideportivos.   
* Los complejos polideportivos tienen áreas designadas para cada deporte con un indicador de localización y una superficie. Además, de los polideportivos se desea conocer si están al aire libre o cubiertos.  
* Para los complejos de deporte único, se quiere conocer el deporte practicado y el aforo máximo permitido, además, los complejos individuales tendrán un nombre único.  
* De los deportes se desea almacenar un nombre único, el número de deportistas implicados y las normas del deporte, así como una lista de materiales necesarios.  
* Cada complejo celebra una serie de eventos.  
* Para cada evento está prevista una fecha, duración, número de participantes, número de comisarios y deporte o deportes del evento.  
* Los comisarios pueden estar involucrados en varios eventos, ya sea cumpliendo la tarea de juez u observador.   
* De los comisarios se conoce el DNI, nombre y fecha de nacimiento.

# **Ejercicio 18**

* Cada proyecto está dirigido por uno o varios departamentos.   
* Cada empleado puede monitorizar uno o varios proyectos.  
* Queremos saber en todo momento qué empleados monitorizan qué proyectos en nombre de qué departamento, así como la fecha de inicio y fin de dicha monitorización.  
* De los proyectos queremos conocer el Nombre del proyecto, la Fecha de inicio, la Fecha de finalización, el Presupuesto y una Descripción.  
* De los departamentos queremos conocer el Nombre del departamento, la Ubicación, el Presupuesto del departamento y el Jefe de departamento (un empleado).  
* De los empleados queremos conocer el Nombre del empleado, la Fecha de contratación y su Salario.

# **Ejercicio 19**

Se desea informatizar la gestión de una empresa de transportes que reparte paquetes por toda España. 

* Los encargados de llevar los paquetes son los camioneros, de los que se quiere guardar el DNI, nombre, teléfono, dirección y salario.  
* De los paquetes transportados interesa conocer el código del paquete, descripción, destinatario y dirección del destinatario.  
* Un camionero distribuye muchos paquetes.  
* De los centros logísticos a los que llegan los paquetes interesa guardar la provincia y el nombre del centro.  
* Un paquete sólo puede llegar a un centro logístico.  
* De los camiones que llevan los camioneros, interesa conocer la matrícula, modelo, tipo y potencia.  
* Un camionero puede conducir diferentes camiones en fechas diferentes, y un camión puede ser conducido por varios camioneros.

# 

# 

# 

# **Ejercicio 20**

Un concesionario de automóviles desea informatizar su gestión de ventas de vehículos. En particular, se quiere tener almacenada la información referente a los clientes que compran en el concesionario, los vehículos vendidos, así como los vendedores que realizan las distintas ventas. Para ello se tendrá en cuenta que:

* Existen diferentes marcas de automóviles, para cada marca se almacena un identificador único y un nombre. Por ejemplo, pueden existir las marcas Audi, BMW, Volkswagen, etc.  
* Una marca puede tener muchos modelos diferentes pero un modelo sólo puede pertenecer a una marca.   
* De cada modelo se almacena un identificador único y un nombre. Por ejemplo, para la marca Audi, podemos tener los modelos A1, A3, A4, etc.  
* Para cada modelo pueden existir diferentes versiones.   
* De cada versión se almacena un identificador único, un nombre de versión, la potencia, un precio base y el tipo de combustible que usa.  
* Cada una de las versiones dispondrá de unos extras adicionales (aire acondicionado, pintura metalizada, etc). Los extras vienen definidos por un identificador, nombre y una descripción. Hay que tener en cuenta que un extra puede ser común para varias versiones variando sólo el precio en cada caso.  
* En cuanto a los clientes, la información de interés es el nombre, apellidos, NIF, dirección y teléfono, lo mismo que para los vendedores.  
* Se desea saber qué vendedor ha vendido qué modelo a qué cliente. También la fecha de la venta y la matrícula del nuevo vehículo.