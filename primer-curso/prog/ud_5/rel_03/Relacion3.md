# Relación 3 — Programación Orientada a Objetos

En esta relación vas a trabajar con sistemas más cercanos a situaciones reales. Cada ejercicio representa un pequeño sistema de gestión que deberá modelarse mediante varias clases relacionadas entre sí. 

Debes aplicar correctamente la encapsulación:
- Los atributos **privados** deben tener **getters y setters**.
- Los atributos **públicos** podrán modificarse directamente.
- Todas las clases deben implementar `toString()`.
- Cada clase debe tener al menos un constructor completo.
- Deben validarse datos básicos cuando tenga sentido.
- El programa principal debe incluir un menú interactivo para probar todas las funcionalidades.
- En el `main`, **antes de mostrar el menú**, debes crear objetos de prueba utilizando la clase `Faker` (la que se os proporciona) para poder probar el programa con datos sin tener que escribirlos a mano.

---

## Ejercicio 1 — Sistema de Gestión de un Puerto Náutico

Un puerto deportivo quiere informatizar el control de sus amarres y embarcaciones. Para ello necesita un sistema orientado a objetos que modele correctamente los elementos del puerto.

### Clases a crear

#### 1) Clase `Embarcacion`
Representa cada barco registrado en el puerto.

**Campos y tipos (y por qué son private/public):**
- `private String matricula`  
  Identificador único. No debe poder modificarse libremente.
- `private String nombre`  
  Protege la integridad del dato (no debería cambiarse sin control).
- `private double eslora`  
  Condiciona si puede amarrar o no. No debe alterarse sin validación.
- `private String tipo`  
  Afecta a precios y reglas del puerto.
- `private String propietario`  
  Dato personal: debe protegerse.
- `private int anioFabricacion`  
  Evita inconsistencias y datos absurdos.
- `public double valorEstimado`  
  Es un dato informativo y no afecta a la lógica interna.

**Restricciones obligatorias:**
- `matricula` no puede ser `null` ni vacía.
- `eslora` debe ser `> 0`.
- `anioFabricacion` debe estar entre **1950 y 2026** (incluidos).
- `tipo` solo puede ser uno de: **"Velero", "Lancha", "Yate", "Catamarán", "Moto de agua"**.
- `valorEstimado` debe ser `>= 0` (si alguien lo pone negativo, corrígelo a 0 o rechaza la asignación).

---

#### 2) Clase `Amarre`
Representa una plaza de amarre dentro del puerto.

**Campos y tipos (y por qué son private/public):**
- `private int numero`  
  Identificador único del amarre.
- `private double longitudMaxima`  
  Condiciona si una embarcación cabe o no. Debe validarse.
- `public double precioDia`  
  Información visible (tarifa).
- `private boolean ocupado`  
  Solo el sistema debe cambiarlo.
- `public String tipoAmarre`  
  Dato informativo para el usuario.

**Restricciones obligatorias:**
- `numero` debe ser `> 0`.
- `longitudMaxima` debe ser `>= 4.0`.
- `tipoAmarre` solo puede ser uno de: **"Normal", "Premium", "Megayate"**.
- `precioDia` se calcula automáticamente en el constructor (no lo decide el usuario):
  - Si `tipoAmarre` es `"Normal"` → `precioDia = 25 + (1.5 * longitudMaxima)`
  - Si `tipoAmarre` es `"Premium"` → `precioDia = 60 + (2.2 * longitudMaxima)`
  - Si `tipoAmarre` es `"Megayate"` → `precioDia = 120 + (3.5 * longitudMaxima)`

---

#### 3) Clase `Puerto`
Será el sistema principal que gestiona embarcaciones y amarres.

**Campos y tipos (y por qué son private/public):**
- `private String nombre`  
  Identidad del puerto.
- `public String ubicacion`  
  Dato informativo.
- `private int capacidadMaxima`  
  Regla interna del sistema: no debe modificarse sin control.
- `public String telefonoContacto`  
  Dato informativo.
- `private Amarre[] amarres`  
  Solo el puerto debe gestionar su contenido.
- `private Embarcacion[] embarcaciones`  
  Solo el puerto debe gestionar su contenido.
- *(recomendado)* `private String[] matriculasAmarradas` o `private int[] amarreDeEmbarcacion`  
  Para poder saber qué barco está en qué amarre (elige UNA forma).

**Restricciones y reglas del puerto (muy importantes):**
- La cantidad de amarres **nunca** puede superar `capacidadMaxima`.
- Una embarcación **solo puede** amarrar si:
  1. Existe un amarre libre.
  2. `embarcacion.eslora <= amarre.longitudMaxima`.
  3. La embarcación **no está ya amarrada** en otro amarre.
- Un amarre **solo puede** ocuparse por **una** embarcación.
- Al liberar un amarre:
  - El amarre pasa a `ocupado = false`
  - La embarcación queda como “no amarrada” dentro del sistema.

**Métodos mínimos obligatorios (puedes añadir más):**
- `registrarEmbarcacion(Embarcacion e)`  
  No debe permitir matrículas repetidas.
- `altaAmarre(Amarre a)`  
  No debe permitir números de amarre repetidos.
- `asignarAmarre(String matricula, int numeroAmarre)`  
  Aplica las reglas anteriores y devuelve si se pudo o no.
- `liberarAmarre(int numeroAmarre)`
- `mostrarAmarresLibres()`, `mostrarAmarresOcupados()`
- `buscarEmbarcacion(String matricula)`  
  Debe mostrar si está amarrada y en qué amarre.
- `calcularIngresosDiariosActuales()`  
  Suma `precioDia` de amarres ocupados.
- `calcularIngresosDiariosMaximos()`  
  Suma `precioDia` de todos los amarres.

### Datos de prueba obligatorios con Faker
En el `main`, antes del menú:
- Genera **50 amarres** con `Faker` y añádelos al puerto (números del 1 al 50).
- Genera **100 embarcaciones** con `Faker` y regístralas en el puerto.
- Asigna automáticamente **al menos 20 embarcaciones** a amarres aleatorios para empezar con datos realistas.

 

---

## Ejercicio 2 — Sistema de Gestión de una Gestoría

Una gestoría quiere digitalizar su trabajo. El sistema debe controlar clientes, trámites y expedientes administrativos.

### Clases a crear

#### 1) Clase `Cliente`
- `private int id` (único, no se repite)
- `private String nombre`
- `private String dni` (único, no se repite)
- `public String telefono`
- `public String email`
- `private String direccion`

**Restricciones:**
- `id > 0`
- `dni` no vacío y no repetido.
- `email` debe contener `@` (validación simple).
- `telefono` debe tener al menos 9 dígitos (validación simple).

---

#### 2) Clase `Tramite`
- `private String codigo` (único)
- `private String nombreTramite`
- `public double precioBase`
- `private boolean requiereCita`
- `public int duracionDias`

**Restricciones:**
- `precioBase >= 0`
- `duracionDias >= 1`
- `requiereCita`:
  - Será `true` si el trámite es: **"Trámite de extranjería"** o **"Gestión de herencias"** o **"Constitución de sociedad"**
  - En otro caso, `false`

---

#### 3) Clase `Expediente`
- `private int numeroExpediente` (único)
- `private Cliente cliente`
- `private Tramite tramite`
- `public String estado` (ABIERTO, EN_PROCESO, FINALIZADO)
- `private boolean pagado`
- `public String fechaApertura` (formato `YYYY-MM-DD`)

**Restricciones y reglas:**
- `estado` solo puede ser: **"ABIERTO"**, **"EN_PROCESO"**, **"FINALIZADO"**
- No se puede marcar como pagado si el estado es `"ABIERTO"`.
- No se puede poner `"FINALIZADO"` si antes no pasó por `"EN_PROCESO"`. (control de flujo simple)
- Si se marca como pagado, se guarda `pagado = true` y ya no vuelve a `false`.

---

#### 4) Clase `Gestoria`
- `private String nombre`
- `public String direccion`
- `public String telefono`
- `private String horario`
- `private Cliente[] clientes`
- `private Tramite[] tramites`
- `private Expediente[] expedientes`

**Reglas del sistema:**
- No se permiten DNIs repetidos.
- No se permiten códigos de trámite repetidos.
- Un cliente puede tener muchos expedientes.
- Un expediente siempre pertenece a un cliente y a un trámite.

**Métodos mínimos obligatorios:**
- Alta de cliente
- Alta de trámite
- Abrir expediente
- Cambiar estado (con reglas)
- Marcar pagado (con reglas)
- Listar por estado
- Listar pendientes de pago
- Calcular facturación total (solo expedientes pagados)

### Datos de prueba obligatorios con Faker
En el `main`, antes del menú:
- Genera **50 clientes**.
- Crea **10 trámites**.
- Genera **80 expedientes** mezclando clientes y trámites aleatoriamente (con estados variados).
  

---

## Ejercicio 3 — Sistema de Torneo de Brisca

Se quiere desarrollar un sistema que gestione un torneo de cartas donde los jugadores compiten en parejas.

### Clases a crear

#### 1) Clase `Jugador`
- `private int id` (único)
- `private String nombre`
- `private int edad`
- `public String nivel` (Principiante, Intermedio, Experto)
- `public String pais`

**Restricciones:**
- `edad` entre **18 y 80**
- `nivel` solo puede ser: **"Principiante"**, **"Intermedio"**, **"Experto"**

---

#### 2) Clase `Pareja`
- `private int idPareja` (único)
- `private Jugador jugador1`
- `private Jugador jugador2`
- `private int victorias`
- `public int puntosTotales`

**Reglas:**
- `jugador1` y `jugador2` no pueden ser la misma persona.
- Un jugador no puede estar en dos parejas distintas.
- `victorias` solo puede incrementarse mediante el método `registrarVictoria()`.

---

#### 3) Clase `Partida`
- `private int idPartida` (único)
- `private Pareja parejaA`
- `private Pareja parejaB`
- `public int puntosA`
- `public int puntosB`
- `private Pareja ganadora`
- `public String fecha`

**Reglas:**
- `puntosA` y `puntosB` entre **0 y 120**
- `ganadora` se calcula automáticamente:
  - Si `puntosA > puntosB` gana A
  - Si `puntosB > puntosA` gana B
  - Si empatan, gana la pareja con **más victorias acumuladas** (si aún así empatan, gana A por defecto)

---

#### 4) Clase `TorneoBrisca`
- `private String nombreTorneo`
- `private String fechaInicio`
- `public String ciudad`
- `public double premioTotal`
- `private Jugador[] jugadores`
- `private Pareja[] parejas`
- `private Partida[] partidas`

**Reglas del torneo:**
- Cada partida suma puntos a `puntosTotales` de la pareja correspondiente.
- La pareja ganadora incrementa victorias.
- Debes poder mostrar:
  - ranking por puntos
  - ranking por victorias
  - historial de partidas de una pareja

**Métodos mínimos:**
- Registrar jugador
- Formar parejas
- Registrar partida
- Ranking de parejas
- Historial de pareja
- Campeona actual
- Detectar paliza (diferencia > 60)
- Promedio de puntos por partida

### Datos de prueba obligatorios con Faker
En el `main`, antes del menú:
- Genera **60 jugadores**.
- Forma **30 parejas**.
- Genera **40 partidas**.


---

## Ejercicio 4 — Plataforma de Streaming

Se quiere modelar una plataforma similar a Twitch para gestionar creadores, directos y suscripciones.

### Clases a crear

#### 1) Clase `Streamer`
- `private int id` (único)
- `private String nombreCanal` (único)
- `private int seguidores`
- `public String categoriaPrincipal`
- `public String pais`

**Restricciones:**
- `seguidores >= 0`
- `nombreCanal` no vacío y no repetido.

---

#### 2) Clase `Stream`
- `private int id` (único)
- `private Streamer streamer`
- `private String titulo`
- `private int duracionMin`
- `public String categoria`
- `public int mediaViewers`
- `public String fecha`
- `public boolean activo`

**Reglas:**
- `duracionMin >= 1`
- `mediaViewers >= 0`
- Solo puede haber **un stream activo por streamer** al mismo tiempo.

---

#### 3) Clase `Suscripcion`
- `private int id` (único)
- `private String usuario`
- `private Streamer streamer`
- `private int meses`
- `public int tier` (1, 2 o 3)
- `public String fechaInicio`

**Restricciones y reglas:**
- `tier` solo puede ser 1, 2 o 3
- `meses >= 1`
- Ingreso mensual por tier:
  - tier 1 → 4.99
  - tier 2 → 9.99
  - tier 3 → 24.99

---

#### 4) Clase `PlataformaTwitch`
- `private String nombrePlataforma`
- `private String empresaPropietaria`
- `public String paisSede`
- `public int anioFundacion`
- `private Streamer[] streamers`
- `private Stream[] streams`
- `private Suscripcion[] suscripciones`

**Reglas de la plataforma:**
- No permitir canales duplicados.
- Un streamer puede tener muchos streams (histórico).
- Un usuario puede suscribirse a varios streamers, pero **solo una suscripción activa por streamer** (si ya existe, se actualizan meses o se rechaza).

**Métodos mínimos:**
- Alta streamer
- Iniciar stream (activo = true)
- Finalizar stream (activo = false)
- Crear suscripción
- Listar streams de streamer
- Calcular ingresos estimados por suscripciones:
  - ingresos = suma(tierPrecio * meses) de suscripciones
- Top 5 streamers por ingresos
- Contar streams por categoría
- Media global de viewers

### Datos de prueba obligatorios con Faker
En el `main`, antes del menú:
- Genera **30 streamers**.
- Genera **120 streams** (mezclando activos y finalizados).
- Genera **200 suscripciones**.


---