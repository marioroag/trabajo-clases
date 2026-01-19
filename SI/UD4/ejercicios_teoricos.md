## Relación ejercicios teóricos Tema 4

**1.** Explique brevemente las funciones de cada una de las capas del modelo de comunicación de datos TCP/IP
    - Capa de Acceso a la Red: Interactua con el hardware de la red
    - Capa de Internet (IP): Se encarga de saber a dond va la transmision de paquetes y el enrootamiento a traves de varias redes
    - Capa de Transporte (TCP/UDP): Sabe si tiene que mandar confirmacion o no, y se encarga de mandarlo en caso de que asi sea
    - Capa de Aplicacion: Proporciona servicios de red a las aplicaciones que usa el usuario (HTTP, FTP, SSH)


**2.** Si la unidad de datos de protocolo en la capa de enlace se llama trama y la unidad de datos de protocolo en la capa de red se llama paquete, ¿son las tramas las que encapsulan los paquetes o son los paquetes los que encapsulan las tramas? Explicar la respuesta.
La de trama encapsula a la de red porque la capa de enlace está mas abajo que la de red


**5-** ¿Qué diferencia, en el contexto de una red de computadores, existe entre la tecnología de difusión y la tecnología punto a punto? y fuera del contexto de redes de computadores, dime 2 ejemplos de comunicaciones por difusión y otros dos de punto a punto
Punto a punto el que manda elije quien lo recibe, en el de difusion la informacion se pasa a todo el mundo y el receptor se encarga de recibirlo

Difusion:
    Decir algo en voz alta, lo escucha mucha gente pero va dirigido a una persona
    Un graffiti dirigido a una persona, cualquiera que pase lo puede ver pero solo lo entiende esa persona

Comunicacion directa:
    Hablar con alguien a solas
    Darle un papel a alguien con algo escrito


**6-**  Un sistema tiene una jerarquía de protocolos de n capas. Las aplicaciones generan mensajes de M bytes de longitud. En cada capa se añade una cabecera de h bytes. ¿Qué fracción del ancho de banda de la red se llena con cabeceras? Aplique el resultado a una conexión a 512 Kbps con tamaño de datos de 1500 Bytes y 4 capas, cada una de las cuales añade 64 Bytes de cabecera.
La fracción del ancho de banda que se llena con cabeceras es (tomando únicamente dos decimales y redondeando con el tercero):
432Kbps


**8-** Cuando se intercambia un fichero entre dos hosts se pueden seguir dos estrategias de confirmación. En la primera, el fichero se divide en paquetes que se confirman individualmente por el receptor, pero el fichero en conjunto no se confirma. En la segunda, los paquetes individuales no se confirman individualmente, es el fichero entero el que se confirma cuando llega completo. Discutir las dos opciones



**9.** Clasifique como difusión o punto a punto cada uno de los siguientes sistemas de transmisión:
    a. Radio y TV: Difusion
    b. Redes inalámbricas (WLAN): Difusion 
    c. ADSL: Difusion
    d. Redes de Cable: Punto a Punto
    e. conexión WIFI: Punto a Punto

**10**. Clasifique los siguientes servicios como orientados a conexión / no orientados a conexión y confirmados /sin confirmación. Justifique la respuesta.
    no orientados a conexión:
    a. Correo postal ordinario sin confirmacion
    b. Correo certificado con confirmacion

    orientados a conexión:
    c. Envío y recepción de fax sin confirmacion
    d. Conversación telefónica con confirmacion

### Ejercicio extra:

**7.** ¿Cuál es el tiempo necesario en enviar un paquete de 1000 Bytes, incluidos 50 Bytes de cabecera, por un enlace de 100 Mbps y 10Km? ¿cuál es el tiempo mínimo desde que se envía hasta que se recibe confirmación? ¿qué relación hay entre este tiempo y los temporizadores en, por ejemplo, las capas de enlace y transporte?