# Unidad Didáctica 6: TCP/IP, Modelo OSI, HTTP y Servicios de Red

## 1. Introducción

Las **redes de computadoras** son infraestructuras tecnológicas diseñadas para permitir la interconexión de múltiples dispositivos con el propósito de compartir información, servicios y recursos de manera eficiente. Estas redes pueden estar compuestas por computadoras, servidores, dispositivos móviles, impresoras y otros equipos conectados a través de diferentes medios físicos y lógicos, como cables Ethernet, redes inalámbricas (Wi-Fi) o enlaces de fibra óptica.

Para que la comunicación entre estos dispositivos sea efectiva y estandarizada, se han desarrollado distintos **modelos de referencia** que establecen las reglas y procesos necesarios para la transmisión de datos. Existen dos modelos fundamentales que explican el funcionamiento de las redes:

### Modelo OSI (Open Systems Interconnection)

El **modelo OSI** fue desarrollado por la **Organización Internacional de Normalización (ISO)** con el objetivo de proporcionar una referencia teórica para el diseño e implementación de redes de comunicación. Su estructura se basa en **7 capas**, cada una con funciones específicas que garantizan la correcta transmisión de datos desde un emisor hasta un receptor. Este modelo es ampliamente utilizado como referencia académica y técnica para comprender cómo interactúan los diferentes protocolos de red.

### Modelo TCP/IP

El **modelo TCP/IP**, en contraste con el OSI, es un enfoque más práctico y está directamente implementado en la mayoría de las redes modernas, incluyendo Internet. Está compuesto por **4 capas** que agrupan las funcionalidades del modelo OSI de una manera más simplificada. Fue desarrollado por el Departamento de Defensa de los Estados Unidos (DoD) y se convirtió en el estándar fundamental para la transmisión de datos en redes globales. Su uso está ampliamente extendido en sistemas operativos, aplicaciones web, servidores y dispositivos conectados a Internet.

---

Uno de los protocolos más importantes dentro del modelo TCP/IP es el **HTTP (Hypertext Transfer Protocol)**, el cual opera en la **capa de aplicación** y es esencial para el funcionamiento de la web. HTTP es el protocolo utilizado por los navegadores y servidores web para la transferencia de documentos en formato HTML, imágenes, videos y otros recursos que conforman las páginas web modernas. Su evolución ha permitido la creación de versiones más eficientes y seguras, como **HTTPS**, que incorpora cifrado mediante **TLS (Transport Layer Security)** para proteger la integridad y confidencialidad de los datos transmitidos.

Además de HTTP, en las redes se emplean diversos **servicios y protocolos de comunicación** que permiten funciones como el acceso remoto a servidores, la transferencia de archivos, la resolución de nombres de dominio, el envío y recepción de correos electrónicos, entre otros. Cada uno de estos servicios opera en **puertos específicos**, los cuales permiten identificar qué tipo de tráfico se está manejando en una conexión de red. Comprender el uso de estos puertos y servicios es fundamental para la administración, seguridad y optimización de redes informáticas.

---

## 2. Modelo OSI: Definición y Capas

El **modelo OSI (Open Systems Interconnection)** es un estándar conceptual desarrollado por la **Organización Internacional de Normalización (ISO)** con el propósito de establecer una arquitectura de red que facilite la comunicación entre dispositivos de diferentes fabricantes y tecnologías. Este modelo organiza la transmisión de datos en **7 capas**, cada una con funciones específicas, asegurando un proceso estructurado y eficiente para la comunicación entre sistemas en red.

Cada capa del modelo OSI se encarga de un conjunto de tareas bien definidas, interactuando con la capa superior e inferior para garantizar que los datos sean transmitidos correctamente desde el origen hasta el destino. Esta segmentación permite que las tecnologías y protocolos puedan ser desarrollados y mejorados de manera modular sin afectar la funcionalidad global del sistema de comunicación.

A continuación, se describen las **7 capas del modelo OSI** y sus respectivas funciones:

| **Capa**                       | **Descripción y Función**                                                                                                                                                                                                                                                                                                                                                                              |
| ------------------------------------ | -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| **7. Capa de Aplicación**     | Es la capa más cercana al usuario y proporciona servicios de red a las aplicaciones, permitiendo la transferencia de datos entre programas en distintos dispositivos. Define protocolos como**HTTP, FTP, SMTP, POP3 y DNS**, que se utilizan en la navegación web, transferencia de archivos, envío de correos electrónicos y resolución de nombres de dominio.                                     |
| **6. Capa de Presentación**   | Se encarga del formato y la estructura de los datos intercambiados entre sistemas. Realiza funciones como**cifrado, compresión y conversión de formatos de datos** para garantizar que la información sea interpretada correctamente en ambos extremos de la comunicación. Protocolos como **SSL/TLS** operan en esta capa para proporcionar seguridad mediante el cifrado de datos en la web. |
| **5. Capa de Sesión**         | Administra la comunicación entre dispositivos estableciendo, manteniendo y finalizando sesiones de comunicación. Coordina el**diálogo entre aplicaciones** y gestiona la sincronización de datos en sesiones prolongadas. Protocolos como **RPC (Remote Procedure Call) y NetBIOS** operan en esta capa.                                                                                       |
| **4. Capa de Transporte**      | Proporciona una comunicación confiable entre dispositivos gestionando el**control de flujo, segmentación, reensamblado de datos y detección de errores**. Los dos principales protocolos de esta capa son **TCP (protocolo confiable y orientado a conexión)** y **UDP (protocolo más rápido pero sin control de errores)**.                                                           |
| **3. Capa de Red**             | Responsable del**direccionamiento, enrutamiento y entrega de paquetes** a través de múltiples redes. Utiliza direcciones IP para identificar dispositivos en una red y determina la mejor ruta para transmitir datos entre ellos. Protocolos clave incluyen **IP, ICMP, ARP, RIP y OSPF**.                                                                                                       |
| **2. Capa de Enlace de Datos** | Maneja la transmisión de datos dentro de una misma red física, asegurando la detección y corrección de errores. Define cómo los dispositivos acceden al medio de transmisión. Protocolos como**Ethernet, Wi-Fi (IEEE 802.11), MAC y PPP** operan en esta capa. Se divide en **sublayer MAC (Media Access Control)** y **sublayer LLC (Logical Link Control)**.                         |
| **1. Capa Física**            | Es la capa encargada de la transmisión real de bits a través del medio físico de la red. Define las características eléctricas, ópticas, de radiofrecuencia y mecánicas de la conexión. Incluye tecnologías como**cables de cobre (UTP, coaxial), fibra óptica y ondas de radio (Wi-Fi, Bluetooth, 4G/5G)**.                                                                                   |

## Importancia del Modelo OSI

El modelo OSI es una referencia fundamental en redes de computadoras, ya que permite:

- **Estandarizar la comunicación** entre dispositivos de diferentes fabricantes.
- **Facilitar el diseño y desarrollo de nuevas tecnologías de red** sin interferir con otras capas.
- **Ayudar a diagnosticar y solucionar problemas de conectividad** de manera estructurada.

A pesar de que el modelo OSI es utilizado principalmente como una herramienta conceptual y académica, su influencia sigue vigente en la arquitectura de redes modernas y en la comprensión de cómo funcionan los protocolos en el **modelo TCP/IP**, que es el estándar real en Internet.

---

## 3. Modelo TCP/IP: Definición y Capas

El **modelo TCP/IP (Transmission Control Protocol / Internet Protocol)** es una arquitectura de red diseñada para permitir la comunicación entre dispositivos en redes interconectadas, principalmente en **Internet**. A diferencia del modelo OSI, que es una referencia conceptual, el modelo **TCP/IP es un estándar práctico y ampliamente implementado en sistemas operativos, servidores y dispositivos de comunicación**.

TCP/IP fue desarrollado en la década de 1970 por el **Departamento de Defensa de los EE.UU.** como parte del proyecto ARPANET, la red precursora de Internet. Su diseño modular y su capacidad de adaptación a diferentes infraestructuras han permitido que sea la base del funcionamiento de redes modernas en todo el mundo.

Una de sus características más destacadas es la capacidad de **interconectar sistemas heterogéneos**, lo que significa que computadoras con diferentes arquitecturas y sistemas operativos pueden comunicarse utilizando un conjunto común de protocolos.

## Estructura del Modelo TCP/IP

A diferencia del modelo OSI, que se divide en **7 capas**, el modelo TCP/IP simplifica la arquitectura de red en **4 capas**, agrupando varias funciones de OSI en una estructura más compacta y funcional. Cada capa desempeña un papel esencial en la transmisión de datos a través de la red, y sus funciones están estrechamente relacionadas con protocolos específicos.

| **Capa OSI**                          | **Capa TCP/IP**     | **Protocolos y Tecnologías Asociadas**                    |
| ------------------------------------------- | ------------------------- | ---------------------------------------------------------------- |
| **Aplicación (7, 6, 5)**             | **Aplicación**     | HTTP, HTTPS, FTP, SSH, DNS, SMTP, POP3, IMAP, SNMP               |
| **Transporte (4)**                    | **Transporte**      | TCP (Protocolo confiable), UDP (Protocolo rápido sin conexión) |
| **Red (3)**                           | **Internet**        | IP (IPv4, IPv6), ICMP, ARP, RIP, OSPF, BGP                       |
| **Enlace de Datos (2) y Física (1)** | **Acceso a la red** | Ethernet, Wi-Fi, PPP, Token Ring, DSL, 4G/5G                     |

## Descripción de las Capas del Modelo TCP/IP

### 1. Capa de Aplicación

Esta capa es responsable de la interacción directa con el usuario y las aplicaciones que requieren comunicación en red. En **TCP/IP**, esta capa combina las funciones de las capas de Aplicación, Presentación y Sesión del modelo OSI.

Los protocolos de esta capa permiten la transferencia de datos y la prestación de servicios a los usuarios, como el acceso a páginas web, el envío y recepción de correos electrónicos, la transferencia de archivos y la gestión remota de dispositivos.

**Protocolos y servicios comunes:**

- **HTTP/HTTPS** → Transferencia de páginas web.
- **FTP/SFTP** → Transferencia de archivos.
- **SSH** → Acceso remoto seguro a sistemas.
- **DNS** → Resolución de nombres de dominio.
- **SMTP, POP3, IMAP** → Envío y recepción de correos electrónicos.
- **SNMP** → Monitoreo y administración de dispositivos de red.

Ejemplo de una solicitud HTTP:

```plaintext
GET /index.html HTTP/1.1  
Host: www.example.com  
```

### 2. Capa de Transporte

Esta capa proporciona una **comunicación confiable o no confiable** entre dispositivos finales. Es responsable de segmentar los datos en paquetes, controlar el flujo de información y corregir errores.

Los dos protocolos más importantes en esta capa son:

- **TCP (Transmission Control Protocol)** → Proporciona una comunicación confiable, estableciendo una conexión antes de transmitir datos y asegurando que lleguen en el orden correcto.
- **UDP (User Datagram Protocol)** → Es un protocolo rápido, sin conexión y sin control de errores, utilizado en aplicaciones donde la velocidad es más importante que la fiabilidad, como transmisión de video o juegos en línea.

**Ejemplo de verificación de puertos TCP abiertos en Linux:**

```bash
netstat -tulnp
```

### 3. Capa de Internet

La capa de Internet es responsable del **encaminamiento y direccionamiento** de los paquetes de datos a través de diferentes redes. Se encarga de asignar direcciones IP a los dispositivos y determinar la mejor ruta para la entrega de la información.

**Protocolos clave en esta capa:**

- **IP (Internet Protocol)** → Maneja el direccionamiento y el enrutamiento de los paquetes. Existen dos versiones principales: **IPv4 (direcciones de 32 bits)** e **IPv6 (direcciones de 128 bits)**.
- **ICMP (Internet Control Message Protocol)** → Se utiliza para diagnóstico de red y control de errores (Ejemplo: `ping`).
- **ARP (Address Resolution Protocol)** → Convierte direcciones IP en direcciones MAC para su uso en redes locales.

**Ejemplo de verificación de dirección IP en Linux:**

```bash
ip a
```

**Ejemplo de prueba de conectividad con `ping`:**

```bash
ping 8.8.8.8
```

### 4. Capa de Acceso a la Red

Esta capa combina las funciones de las **capas de Enlace de Datos y Física del modelo OSI**. Su función principal es gestionar la transmisión de datos a través del medio físico y controlar el acceso a la red.

Se encarga de convertir los paquetes IP en **tramas de datos** y transmitirlas mediante diferentes tecnologías de red, como **Ethernet, Wi-Fi, DSL, 4G/5G, Token Ring**. También define cómo los dispositivos en una red comparten el acceso al medio de transmisión.

**Protocolos y tecnologías comunes en esta capa:**

- **Ethernet (IEEE 802.3)** → Red cableada de alta velocidad.
- **Wi-Fi (IEEE 802.11)** → Conexiones inalámbricas de corto alcance.
- **PPP (Point-to-Point Protocol)** → Conexión entre dos nodos de red.
- **MAC (Media Access Control)** → Direccionamiento de dispositivos en una red local.

**Ejemplo de verificación de interfaces de red en Linux:**

```bash
ip link show
```

**Ejemplo de captura de tráfico en una interfaz con `tcpdump`:**

```bash
tcpdump -i eth0
```

## 5. Servicios de Red y Puertos Asociados

| **Servicio** | **Descripción**               | **Protocolo** | **Puerto** |
| ------------------ | ------------------------------------ | ------------------- | ---------------- |
| **HTTP**     | Transferencia de páginas web.       | TCP                 | 80               |
| **HTTPS**    | HTTP seguro con TLS/SSL.             | TCP                 | 443              |
| **FTP**      | Transferencia de archivos.           | TCP                 | 21               |
| **SSH**      | Acceso remoto seguro.                | TCP                 | 22               |
| **DNS**      | Resolución de nombres de dominio.   | UDP/TCP             | 53               |
| **SMTP**     | Envío de correos.                   | TCP                 | 25               |
| **IMAP**     | Acceso a correos electrónicos.      | TCP                 | 143              |
| **POP3**     | Recepción de correos electrónicos. | TCP                 | 110              |

## 4. HTTP: Protocolo de Transferencia de Hipertexto

### 4.1. ¿Qué es HTTP?

El **Hypertext Transfer Protocol (HTTP)** es un protocolo de comunicación utilizado en la web para la transferencia de información entre un **cliente**, como un navegador web, una aplicación API o una terminal, y un **servidor web** que aloja recursos como páginas HTML, imágenes, archivos y otros contenidos.

HTTP es la base de la comunicación en la World Wide Web y permite la interacción entre clientes y servidores mediante el intercambio de mensajes estructurados.

### Características principales de HTTP

- **Protocolo sin estado**: Cada solicitud HTTP es independiente de las anteriores, lo que significa que el servidor no guarda información sobre solicitudes previas del mismo cliente. Para mantener la persistencia de datos en aplicaciones web, se utilizan mecanismos como las **cookies**, **tokens** o **sesiones**.
- **Basado en TCP/IP**: HTTP opera sobre el protocolo de transporte **TCP (Transmission Control Protocol)** dentro del conjunto de protocolos **TCP/IP**, lo que garantiza una entrega confiable de los datos entre el cliente y el servidor.
- **Protocolo de aplicación**: HTTP pertenece a la capa de aplicación dentro del modelo OSI y se encarga de definir cómo los mensajes son formulados y transmitidos.
- **Uso de métodos estandarizados**: HTTP emplea **métodos o verbos** para realizar distintas operaciones sobre los recursos en un servidor, como **GET**, **POST**, **PUT**, **DELETE**, entre otros.
- **Funcionamiento basado en URLs**: HTTP permite acceder a recursos mediante **Uniform Resource Locators (URLs)**, las cuales identifican de manera única la ubicación de un recurso en la web.
- **Compatibilidad con diferentes formatos**: HTTP puede transferir información en distintos formatos, como **HTML**, **JSON**, **XML**, **CSS**, **JavaScript**, imágenes, vídeos, entre otros.

### 4.2. Flujo de Comunicación en HTTP

El funcionamiento de HTTP sigue un modelo de **cliente-servidor**, en el cual el cliente envía solicitudes y el servidor responde con los datos requeridos.

### Pasos en una comunicación HTTP

1. **El cliente envía una solicitud HTTP al servidor**

   - El cliente (navegador, API, aplicación) formula una petición HTTP a un servidor web utilizando una URL.
   - La solicitud incluye información como el método HTTP, la dirección del recurso, los encabezados de la solicitud y, en algunos casos, un cuerpo de datos.
2. **El servidor recibe y procesa la solicitud**

   - El servidor analiza la petición, identifica el recurso solicitado y decide cómo responder.
   - Puede procesar la solicitud consultando bases de datos o ejecutando lógica del lado del servidor antes de generar una respuesta.
3. **El servidor responde con un código de estado y el contenido**

   - El servidor envía una respuesta HTTP que incluye un **código de estado** (como 200 OK, 404 Not Found o 500 Internal Server Error), encabezados y, si es necesario, un cuerpo con los datos solicitados.
4. **El cliente recibe la respuesta y la interpreta**

   - El cliente procesa la respuesta del servidor. Si es una página web, el navegador la renderiza en pantalla. Si es una API, la respuesta se puede utilizar dentro de una aplicación.

### 4.3. Ejemplo de Solicitud y Respuesta HTTP

A continuación, se muestra un ejemplo de una solicitud HTTP y la correspondiente respuesta del servidor.

### Ejemplo de solicitud HTTP:

Cuando un usuario accede a un sitio web, su navegador envía una petición similar a la siguiente:

```plaintext
GET /index.html HTTP/1.1
Host: www.example.com
User-Agent: Mozilla/5.0
Accept: text/html
Connection: keep-alive
```

- `GET` es el método HTTP utilizado para solicitar un recurso.
- `/index.html` es la ruta del recurso solicitado en el servidor.
- `HTTP/1.1` es la versión del protocolo HTTP utilizada.
- `Host: www.example.com` indica el dominio del servidor al que se dirige la solicitud.
- `User-Agent: Mozilla/5.0` especifica información sobre el cliente que envía la solicitud.
- `Accept: text/html` indica que el cliente espera recibir una respuesta en formato HTML.
- `Connection: keep-alive` sugiere que la conexión debe mantenerse abierta para futuras solicitudes.

### Ejemplo de respuesta HTTP:

Si el servidor encuentra el recurso solicitado, responde con un mensaje HTTP como el siguiente:

```plaintext
HTTP/1.1 200 OK
Date: Tue, 05 Mar 2025 12:34:56 GMT
Server: Apache/2.4.41 (Ubuntu)
Content-Type: text/html
Content-Length: 1256
```

- `HTTP/1.1 200 OK` indica que la solicitud fue procesada exitosamente.
- `Date: Tue, 05 Mar 2025 12:34:56 GMT` es la fecha y hora en que el servidor generó la respuesta.
- `Server: Apache/2.4.41 (Ubuntu)` muestra el software del servidor web.
- `Content-Type: text/html` indica que el contenido devuelto está en formato HTML.
- `Content-Length: 1256` indica el tamaño del contenido en bytes.

Después de estos encabezados, el servidor envía el contenido HTML de la página web solicitada.

### 4.4. Métodos HTTP (Verbos HTTP)

#### 4.4.1. Métodos HTTP principales

Los **métodos HTTP**, también conocidos como **verbos HTTP**, son instrucciones utilizadas en el protocolo HTTP para indicar la acción que un cliente (navegador, API, aplicación móvil, etc.) desea realizar sobre un recurso en un servidor web.

Cada método tiene una función específica y define cómo se interactúa con los datos en el servidor, ya sea para **solicitar información, enviar datos, actualizar registros o eliminar recursos**.

Estos métodos se utilizan en combinación con **URLs** y se incluyen en la cabecera de la solicitud HTTP para especificar qué tipo de operación se desea realizar.

A continuación, se detallan los métodos HTTP más utilizados, su función y algunos ejemplos prácticos.

| **Método** | **Descripción**                                                                  | **Uso típico**                                                                |
| ----------------- | --------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------ |
| **GET**     | Solicita un recurso del servidor sin modificarlo. Es el método más común en la web.  | Navegar por sitios web, recuperar información de una API.                           |
| **POST**    | Envía datos al servidor para ser procesados o almacenados. Crea nuevos recursos.       | Formularios de registro, envío de datos en una API.                                 |
| **PUT**     | Actualiza completamente un recurso existente en el servidor o lo crea si no existe.     | Modificación de perfiles de usuario, actualización de registros en bases de datos. |
| **DELETE**  | Elimina un recurso en el servidor.                                                      | Eliminación de cuentas de usuario, eliminación de archivos en un servidor.         |
| **PATCH**   | Modifica parcialmente un recurso existente, actualizando solo los datos proporcionados. | Cambio de contraseña, actualización de algunos campos de un perfil.                |
| **HEAD**    | Similar a GET, pero solo devuelve los encabezados de la respuesta sin el cuerpo.        | Verificar si un recurso existe sin descargarlo, comprobar la última modificación.  |
| **OPTIONS** | Consulta qué métodos HTTP están permitidos en un servidor o recurso específico.     | Descubrir qué operaciones se pueden realizar sobre una API.                         |

#### 4.4.2. Explicación detallada de cada método HTTP

##### 1. GET: Obtener información

El método **GET** se usa para **recuperar datos** de un servidor sin modificar el recurso solicitado. Es el método más utilizado en la web y no tiene efectos secundarios en el servidor, ya que solo obtiene información.

**Características:**

- **Idempotente**: Repetir la solicitud no cambia el estado del servidor.
- **Seguro**: No altera los datos en el servidor.
- **Usado para obtener datos**: Páginas web, imágenes, archivos JSON, etc.

**Ejemplo de solicitud GET:**

```plaintext
GET /productos HTTP/1.1
Host: www.ejemplo.com
```

**Ejemplo de respuesta del servidor:**

```plaintext
HTTP/1.1 200 OK
Content-Type: application/json

[
  { "id": 1, "nombre": "Laptop", "precio": 800 },
  { "id": 2, "nombre": "Mouse", "precio": 20 }
]
```

##### 2. POST: Enviar datos para su procesamiento

El método **POST** se utiliza para **enviar datos** al servidor y crear un nuevo recurso. A diferencia de GET, POST **no es idempotente**, ya que cada solicitud puede crear un nuevo registro.

**Características:**

- Se usa para **formularios, autenticaciones, registros** y cualquier operación que envíe datos al servidor.
- Puede contener **un cuerpo de datos** en formato **JSON, XML, formulario, etc.**
- Generalmente se usa con autenticación en APIs.

**Ejemplo de solicitud POST:**

```plaintext
POST /usuarios HTTP/1.1
Host: www.ejemplo.com
Content-Type: application/json

{
  "nombre": "Juan Pérez",
  "email": "juan@example.com"
}
```

**Ejemplo de respuesta:**

```plaintext
HTTP/1.1 201 Created
Location: /usuarios/123
```

##### 3. PUT: Actualizar o reemplazar un recurso

El método **PUT** se usa para **actualizar completamente** un recurso en el servidor. Si el recurso no existe, PUT puede crear uno nuevo.

**Características:**

- **Idempotente**: Varias solicitudes PUT con los mismos datos generan el mismo resultado.
- **Reemplaza el recurso completamente**, por lo que debe incluirse toda la información necesaria.

**Ejemplo de solicitud PUT:**

```plaintext
PUT /usuarios/123 HTTP/1.1
Host: www.ejemplo.com
Content-Type: application/json

{
  "nombre": "Juan Pérez",
  "email": "juan_nuevo@example.com"
}
```

**Ejemplo de respuesta:**

```plaintext
HTTP/1.1 200 OK
```

##### 4. DELETE: Eliminar un recurso

El método **DELETE** se usa para **eliminar un recurso** en el servidor.

**Características:**

- **Idempotente**: Si el recurso ya fue eliminado, repetir la solicitud no tiene efecto.
- Puede devolver **404 Not Found** si el recurso no existe.

**Ejemplo de solicitud DELETE:**

```plaintext
DELETE /usuarios/123 HTTP/1.1
Host: www.ejemplo.com
```

**Ejemplo de respuesta:**

```plaintext
HTTP/1.1 204 No Content
```

##### 5. PATCH: Modificación parcial de un recurso

El método **PATCH** se usa cuando solo se necesita actualizar **una parte de un recurso** sin reemplazarlo completamente.

**Ejemplo de solicitud PATCH:**

```plaintext
PATCH /usuarios/123 HTTP/1.1
Host: www.ejemplo.com
Content-Type: application/json

{
  "email": "nuevo_correo@example.com"
}
```

**Ejemplo de respuesta:**

```plaintext
HTTP/1.1 200 OK
```

##### 6. HEAD: Obtener solo los encabezados

El método **HEAD** funciona igual que **GET**, pero la respuesta solo contiene los **encabezados HTTP**, sin el cuerpo del contenido. Se usa para verificar la existencia de recursos o su última modificación.

**Ejemplo de solicitud HEAD:**

```plaintext
HEAD /documento.pdf HTTP/1.1
Host: www.ejemplo.com
```

**Ejemplo de respuesta:**

```plaintext
HTTP/1.1 200 OK
Content-Length: 102400
Last-Modified: Mon, 04 Mar 2024 18:30:00 GMT
```

##### 7. OPTIONS: Métodos permitidos en un recurso

El método **OPTIONS** permite consultar **qué métodos HTTP están soportados** por un servidor o un recurso específico.

**Ejemplo de solicitud OPTIONS:**

```plaintext
OPTIONS /productos HTTP/1.1
Host: www.ejemplo.com
```

**Ejemplo de respuesta:**

```plaintext
HTTP/1.1 200 OK
Allow: GET, POST, OPTIONS
```

#### Creación de servidor json con json-server

Instalamos el servidor con ``bash sudo apt install json-server`` o el gestor de paquetes que tengamos instalado en nuestro equipo. Creamos un archivo db.json donde creamos la base de datos.

El ejemplo visto en clase sería el siguiente:

```json
{
  "alumnos": [
    { "id": 1, "nombre": "Cristian", "edad": 30, "profe_fav_id": 1 }
  ],
"profes": [
{"id":1, "nombre":"Paco", "asignaturas":
[{"titulo":"Sistemas", "curso": 1},
{"titulo":"Bases", "curso": 1}]}
]
}
```

tras tener la configuración de nuestra base de datos encendemos el servidor con ``bash json-server --watch db.json (o la ruta del archivo) --port 3000 `` y en esa terminal ya tenemos corriendo el servidor. Las peticiones habría que hacerlas desde otra terminal.

Con la orden curl podemos hacer peticiones http directamente desde la terminal. con la opción -x especificamos qué opcion http queremos utilizar (GET por defecto) y con -d pasamos el json necesario si es que la petición necesita parámetros (por ejemplo put o post). Sin opción, debemos pasar la url necesaria para conectarnos, especificando la IP/URL, puerto y objeto json al que vamos a hacer la petición, por ejemplo la tabla alumnos.

```bash
 curl -X POST -d '{ "id": 2, "nombre": "Carlota", "edad": 22, "profe_fav_id": 1 }' http://localhost:3000/alumnos 
```

A la hora de hacer consultas, por ejemplo las asignaturas de un profe, tenemos la limitación de que nuestra api no es api REST (no está implementada del todo, es solo para hacer pruebas). Pero dado que todas las órdenes con curl devuelven un json, sobretodo el GET, esto es una cadena de texto que podemos seguir parseando usando la orden jq, que busca dentro de un texto escrito en json.

Por ejemplo, ejecuta:

```bash
curl -X GET  http://localhost:3000/profes/1 2> /dev/null | jq '.asignaturas'

```

¿Qué significa cada cosa en esta línea de codigo? ¿por que esccribo 1 tras profes? ¿qué esta haciendo el 2> y porqué escribo un 2, y no 1< por ejemplo? ¿Qué esta haciendo el símbolo |, y qué sería jq? todo esto habría que saberlo ya.
