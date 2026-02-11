Tema 4 (TCP/IP y transmisión de datos)

⸻

1. Capas del modelo TCP/IP (función básica)

Aplicación: servicios al usuario (web, email, ftp).
Transporte: comunicación extremo a extremo, control de errores y flujo (TCP/UDP).
Internet / Red: direccionamiento lógico y enrutamiento (IP).
Acceso a red / Enlace: transmisión física en la red local, direcciones MAC y tramas.

Idea clave:
Aplicación → Transporte → Red → Enlace → Medio físico

⸻

2. Encapsulación

Las tramas encapsulan los paquetes.

Motivo:
	•	Capa Red genera paquetes
	•	Capa Enlace los mete dentro de tramas para enviarlos físicamente

Orden:
Datos → Segmento → Paquete → Trama

⸻

5. Difusión vs Punto a punto

Difusión (broadcast): un emisor envía a muchos receptores.
Punto a punto: comunicación directa entre dos dispositivos.

Ejemplos fuera de redes:
	•	Difusión: TV, radio
	•	Punto a punto: llamada telefónica, conversación cara a cara

⸻

6. Fracción de ancho de banda ocupada por cabeceras

Fórmula:

\text{Fracción} = \frac{n \cdot h}{M + n \cdot h}

Datos:
	•	n = 4
	•	h = 64
	•	M = 1500

Cabeceras = 4×64 = 256

\frac{256}{1500+256}=\frac{256}{1756}=0.15

Resultado: 0.15 (15%)

⸻

8. Confirmación de paquetes

Confirmación individual
	•	Más fiable
	•	Más tráfico de confirmaciones
	•	Mejor para redes poco fiables

Confirmación final
	•	Menos tráfico
	•	Si falla algo hay que repetir mucho
	•	Mejor para redes fiables

⸻

9. Clasificación difusión / punto a punto

a. Radio y TV → difusión
b. WLAN → difusión
c. ADSL → punto a punto
d. Cable → difusión
e. WIFI → difusión

⸻

10. Orientado / no orientado a conexión

Servicio	Conexión	Confirmación
Correo postal ordinario	no orientado	sin confirmación
Correo certificado	no orientado	confirmado
Fax	orientado	confirmado
Teléfono	orientado	sin confirmación


⸻

7. Tiempo de envío paquete

Fórmulas clave:

Tiempo transmisión:

T_t=\frac{\text{bits}}{\text{velocidad}}

Tiempo propagación:

T_p=\frac{\text{distancia}}{\text{velocidad propagación}}

Tiempo mínimo ACK:

T_{total}=2T_p + T_t

(esto aparece constantemente en ejercicios)

⸻

11. Idea clave ejercicios largos

Siempre separar:
	1.	Tiempo de transmisión paquete
	2.	Tiempo propagación
	3.	Confirmación (ida y vuelta)
	4.	Multiplicar por número de paquetes

⸻

Resumen ultra corto (lo que debes memorizar)
	•	Trama encapsula paquete
	•	Broadcast = uno a muchos
	•	Punto a punto = uno a uno
	•	Cabeceras: nh/(M+nh)
	•	Tiempo total confirmación ≈ transmisión + 2 propagaciones

⸻

Chuleta matemática definitiva (ejercicios de redes)
# Chuleta rápida – Problemas de envío de paquetes (Redes)

## Paso 1. Convertir unidades
- Bytes → bits = **Bytes × 8**
- Mbps → bps = **Mbps × 10⁶**
- Km → metros = **Km × 1000**

---

## Paso 2. Tiempo de transmisión
Tiempo necesario para poner los bits en el enlace:

\[
T_{tx}=\frac{\text{tamaño (bits)}}{\text{velocidad (bps)}}
\]

---

## Paso 3. Tiempo de propagación
Tiempo que tarda la señal en viajar:

\[
T_{prop}=\frac{\text{distancia}}{\text{velocidad propagación}}
\]

Velocidad típica si no la indican:

\[
2 \times 10^8 \, m/s
\]

---

## Paso 4. Confirmación (ACK)
Tiempo mínimo hasta recibir confirmación:

\[
T_{ACK}=T_{tx}+2T_{prop}
\]

---

## Paso 5. Varios paquetes
Si hay varios paquetes:

\[
T_{total}=N \cdot T_{tx}+2T_{prop}
\]

(donde N es número de paquetes)

---

## Paso 6. Si preguntan “tiempo del primer paquete”
Solo calcular:

\[
T_{primer}=T_{tx}
\]

---

## Esquema mental rápido (examen)
1. Convertir unidades
2. Calcular transmisión
3. Calcular propagación
4. Añadir confirmación si existe
5. Multiplicar por nº paquetes si corresponde

---

## Idea clave
En enlaces rápidos y distancias largas:

- La **propagación** suele dominar el tiempo total.