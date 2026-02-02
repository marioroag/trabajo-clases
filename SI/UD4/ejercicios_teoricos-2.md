### Ejercicio tamaño cabeceras

**6-**  Un sistema tiene una jerarquía de protocolos de n capas. Las aplicaciones generan mensajes de M bytes de longitud. En cada capa se añade una cabecera de h bytes. ¿Qué fracción del ancho de banda de la red se llena con información de la capa de aplicación? Aplique el resultado a una conexión a 400 Kbps con tamaño de datos de 1000 Bytes y 7 capas, cada una de las cuales añade 64 Bytes de cabecera.

### Ejercicio transmision

Queremos enviar un archivo de 2000 bytes usando paquetes de 1000 bytes por un enlace de 120 Mbps entre dos torres situadas a 15 Km de distancia. Teniendo en cuenta que las cabeceras ocupan 50 bytes también por tanto los paquetes de confirmación, ¿Cuánto tiempo tardaremos en enviar el primer paquete? ¿Cúanto tiempo tardaremos (desde que comienza el primer envío, si no hay errores) en recibir la confirmación del correcto envío de todos los paquetes?

Nº Paquetes = 3 (1000, 1000, 150)

TT1 = (1000B * 8b) / (120Mb/s * 10^6)
TT2 = (1000B * 8b/B) / (120Mb/s * 10^6)
TT3 = (150B * 8b/B) / (120Mb/s * 10^6)
Tp = (15000m) / 2*10^8m/s =
TACK =  (50B * 8b/B) / 120Mbps = 3,33 microsegundos

A) TT1

B) T = TT1 + TT2 + TT3 + 2TP + TACK

### Ejercicio IP.

- tengo una red 192.170.0.0   /24 y quiero hacer 3 subredes lo más grandes posible. (minima mascara de red que puedas hacer).
- dentro de cada subred que hayas creado, asigna una ip a 3 dispositivos diferentes (9 en total)
- en una de las 3 subredes que has creado, la que tú quieras, define 2 subredes más.

### Ejercicio transmision

- Queremos enviar una foto de resolucion HD (1920X1080) con una profundidad de color de 32 bits. El protocolo nos permite hacer paquetes de hasta 4MB.
- La velocidad de transferencia es de 1Gbps y la distancia entre torres es de 80 Km.
- Dime el tiempo que transcurre desde que comenzamos a emitir hasta que llega la ultima confirmación.
- ¿Qué tiempo mínimo de confirmación antes de reenviar establecerías para **cada paquete**?
