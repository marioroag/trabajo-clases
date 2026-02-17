# 🧠 MAPUNTES DE EXAMEN – BASES DE DATOS (E–R Y MODELO RELACIONAL)

Guía completa para resolver ejercicios como los de la **Prueba Técnica 1** y la **Relación de Problemas de Diagramas E–R**. Pensada para exámenes de diseño conceptual y modelo relacional.

---

## ⚙️ 1️⃣ FUNDAMENTOS DE DISEÑO DE BASES DE DATOS

### 🧩 Objetivo del diseño
Transformar una **descripción de un sistema real** (texto o requisitos) en un **modelo estructurado de datos** que luego se implementará en tablas.

Etapas:
1. **Modelo conceptual (E–R):** entidades, relaciones y atributos.
2. **Modelo lógico (Relacional):** tablas con claves primarias y foráneas.
3. **Modelo físico:** implementación en un SGBD (no entra en este examen).

---

## 🧱 2️⃣ MODELO ENTIDAD–RELACIÓN (E–R)

### 🔹 Elementos básicos
| Elemento | Significado | Representación |
|-----------|--------------|----------------|
| **Entidad** | Objeto o cosa real con existencia propia | Rectángulo |
| **Atributo** | Propiedad de una entidad o relación | Elipse |
| **Clave primaria (PK)** | Identificador único de cada instancia | Subrayado |
| **Relación** | Asociación entre entidades | Rombos |
| **Cardinalidad** | Cuántas veces una entidad puede relacionarse | (1,1) (0,N) etc. |
| **Herencia / Jerarquía** | Entidad general (superclase) y tipos específicos (subclases) | Triángulo |

### 🔹 Tipos de atributos
| Tipo | Ejemplo | Observaciones |
|------|----------|----------------|
| **Simple** | nombre, edad | No se divide |
| **Compuesto** | dirección (calle, ciudad) | Puede separarse |
| **Derivado** | edad calculada a partir de fecha_nac | No se almacena |
| **Multivaluado** | teléfono(s) | Varios valores → requiere tabla aparte |

### 🔹 Cardinalidades comunes
| Tipo | Descripción | Ejemplo |
|------|--------------|----------|
| 1:1 | Cada entidad A se asocia con **una sola** de B y viceversa | Persona–DNI |
| 1:N | Una A se asocia con **muchas** B, pero cada B solo con **una** A | Cliente–Pedido |
| N:M | Una A se asocia con **muchas** B y viceversa | Alumno–Asignatura |

### 🔹 Relaciones con atributos
Si una relación tiene información adicional (como cantidad, fecha, nota…), debe transformarse en una **entidad intermedia**.

Ejemplo: Un *pedido contiene artículos con cantidad* → `PEDIDO_CONTIENE_ARTÍCULO (id_pedido, id_artículo, cantidad)`.

### 🔹 Jerarquías (Herencia)
- Una entidad **general** agrupa atributos comunes.
- Subentidades añaden atributos específicos.

Ejemplo:
```
PARTICIPANTE (dni, nombre, teléfono)
  ├── ALUMNO (curso, grado)
  └── PROFESOR (nss, área)
```

Transformación al modelo relacional:
1. Cada subentidad → tabla propia.
2. Copia la clave primaria de la general.

---

## 🔍 3️⃣ CÓMO ANALIZAR UN ENUNCIADO

### 🧠 Paso a paso
1. **Subraya los sustantivos:** posibles **entidades** (cliente, pedido, producto…).
2. **Subraya los verbos:** posibles **relaciones** (hace, tiene, pertenece a…).
3. **Atributos:** adjetivos o datos concretos (nombre, precio, tipo…).
4. **Determina cardinalidades:** busca pistas como:
   - “Un cliente puede tener varios pedidos” → (1,N)
   - “Cada pedido pertenece a un solo cliente” → (N,1)
5. **Detecta dependencias:**
   - Si dice “de un pedido se sabe su cliente” → atributo foráneo.
   - Si dice “cada X puede tener varios Y” → relación 1:N.
6. **Identifica atributos en relaciones:** si hay cantidades, fechas, puntuaciones… la relación tiene atributos propios.

---

## 📘 4️⃣ CÓMO PASAR DE E–R A MODELO RELACIONAL

### 🧩 Reglas de transformación

1️⃣ **Entidad fuerte → Tabla**
```text
CLIENTE (id_cliente, nombre, teléfono)
```

2️⃣ **Entidad débil → Tabla + clave de la entidad fuerte**
```text
MESA (num_mesa, num_comensales, id_bar)
```

3️⃣ **Relación 1:N**
- La clave primaria de la entidad del lado 1 pasa como **clave foránea (FK)** a la tabla del lado N.
```text
CLIENTE (id_cliente, nombre)
PEDIDO (id_pedido, fecha, id_cliente)
```

4️⃣ **Relación N:M**
- Se crea una tabla intermedia con las **claves primarias de ambas entidades** + atributos propios.
```text
ARTÍCULO (id_artículo, nombre, precio)
PEDIDO (id_pedido, fecha)
PEDIDO_CONTIENE_ARTÍCULO (id_pedido, id_artículo, cantidad)
```

5️⃣ **Relación 1:1**
- Se fusionan en una tabla o se pone una FK con restricción de unicidad.
```text
PERSONA (dni, nombre, direccion)
DNI (numero, fecha_emision, dni_persona UNIQUE)
```

6️⃣ **Jerarquía (Herencia)**
- Opción más usada: crear una tabla por subentidad.
```text
PARTICIPANTE (dni, nombre, teléfono)
ALUMNO (dni, curso, grado)
PROFESOR (dni, nss, area)
```

7️⃣ **Atributo multivaluado**
- Crear una tabla aparte con una columna para el valor.
```text
ALUMNO (dni, nombre)
ALUMNO_TIENE_TELEFONO (dni, telefono)
```

---

## 🔑 5️⃣ CLAVES Y DEPENDENCIAS

### 🔹 Clave primaria (PK)
- Identifica de forma única cada registro.
- No puede repetirse ni ser nula.

### 🔹 Clave foránea (FK)
- Campo que enlaza con la PK de otra tabla.
- Permite mantener la integridad referencial.

### 🔹 Clave compuesta
- PK formada por **varios campos**.
```text
PEDIDO_CONTIENE_ARTÍCULO (id_pedido, id_artículo)
```

### 🔹 Integridad referencial
- Un valor FK debe existir previamente en la tabla referenciada.
- Ejemplo: no se puede asignar un pedido a un cliente que no existe.

---

## 📦 6️⃣ PATRONES FRECUENTES EN EXAMEN

### 🧩 Relación con atributo propio (N:M)
> Se crea una tabla intermedia con los atributos adicionales.

Ejemplo: *Pedido – Artículo (cantidad)*
```text
PEDIDO (id_pedido, fecha, id_cliente)
ARTÍCULO (id_artículo, nombre, precio)
PEDIDO_CONTIENE_ARTÍCULO (id_pedido, id_artículo, cantidad)
```

### 🧩 Herencia / subtipos
> Cuando un conjunto de entidades comparte campos comunes pero tiene otros distintos.

Ejemplo: *Participante / Alumno / Profesor*
```text
PARTICIPANTE (dni, nombre, teléfono)
ALUMNO (dni, curso, grado)
PROFESOR (dni, nss, area)
```

### 🧩 Entidad con relación a sí misma (recursiva)
> Una entidad se relaciona consigo misma (jefe–empleado, padre–hijo).

```text
EMPLEADO (id_empleado, nombre, id_jefe)
```

### 🧩 Entidad con varios roles
> Una entidad puede cumplir varios papeles en una misma relación (ej. árbitro y jugador en partidos).

```text
PARTIDO (id_partido, equipo1, equipo2, dni_arbitro)
```

---

## 🧮 7️⃣ ESTRUCTURA GENERAL DE UN MODELO RELACIONAL

Cada tabla debe tener:
- **Clave primaria (PK)**
- **Claves foráneas (FK)** si hay relaciones.
- Atributos simples (sin repetir grupos ni listas).

Ejemplo genérico:
```text
TABLA_A (id_a, atributo1, atributo2)
TABLA_B (id_b, atributo1, id_a)
```

---

## 🧱 8️⃣ NORMALIZACIÓN (básico)
> Proceso para eliminar redundancias y asegurar consistencia.

| Forma normal | Condición | Objetivo |
|---------------|------------|-----------|
| **1FN** | Todos los valores son atómicos (sin listas o grupos repetidos). | Evitar campos multivaluados. |
| **2FN** | Cumple 1FN y todos los atributos dependen de la PK completa. | Eliminar dependencias parciales. |
| **3FN** | Cumple 2FN y no hay dependencias transitivas. | Evitar dependencias entre atributos no clave. |

Ejemplo: dividir direcciones, teléfonos o datos derivados en tablas aparte.

---

## 🧠 9️⃣ ESTRATEGIA DE EXAMEN

### 🔹 Paso a paso para resolver un enunciado tipo
1. **Detecta las entidades:** todos los sustantivos importantes.
2. **Detecta las relaciones:** los verbos que conectan entidades.
3. **Añade atributos:** según lo que se “quiera saber de…”
4. **Marca cardinalidades:** cuántas veces ocurre cada relación.
5. **Busca jerarquías:** si hay tipos de una misma entidad.
6. **Transforma a modelo relacional:** aplica las reglas.
7. **Comprueba:**
   - Todas las PK están definidas.
   - Las FK apuntan a entidades correctas.
   - Los N:M se han convertido en tablas intermedias.

### 🔹 Cómo detectar cardinalidades
| Frase típica | Traducción | Relación |
|---------------|-------------|-----------|
| “Un cliente puede hacer muchos pedidos” | 1 cliente → N pedidos | 1:N |
| “Cada pedido pertenece a un solo cliente” | N pedidos → 1 cliente | 1:N |
| “Un producto puede estar en muchos pedidos y un pedido tiene varios productos” | ambos lados muchos | N:M |
| “Cada coche tiene una matrícula única” | uno a uno | 1:1 |

### 🔹 Cómo razonar una herencia
1. ¿Comparten los tipos los mismos atributos? → entidad general.
2. ¿Tienen atributos específicos? → subentidades.
3. ¿Se comportan igual en las relaciones? → subentidades conectadas por la PK común.

---

## 🧩 10️⃣ CHULETAS RÁPIDAS

### 🔹 Símbolos y lectura
| Notación | Significado |
|-----------|--------------|
| (1,1) | Obligatoria y única |
| (0,1) | Opcional y única |
| (1,N) | Obligatoria y varios |
| (0,N) | Opcional y varios |

### 🔹 Cómo nombrar las tablas
| Tipo de relación | Convención |
|------------------|-------------|
| N:M con atributos | `ENTIDAD1_REL_ENTIDAD2` |
| Relación sin atributos | añadir FK directamente |

### 🔹 Reglas de oro
- Cada tabla debe tener **una PK**.
- Cada FK debe **coincidir en tipo y nombre lógico** con la PK que referencia.
- No repetir información que ya esté determinada por otra tabla.
- Si algo depende de dos entidades → relación con PK compuesta.

### 🔹 Abreviaturas frecuentes
| Abreviatura | Significado |
|--------------|--------------|
| PK | Clave primaria |
| FK | Clave foránea |
| NN | Not null |
| N:M | Muchos a muchos |
| 1:N | Uno a muchos |
| 1:1 | Uno a uno |

---

## 📚 11️⃣ PATRONES RESUMIDOS (PRUEBA TÉCNICA 1)

### 🧩 Bar Las Tostas
- Entidades: **Usuario**, **Mesa**, **Pedido**, **Artículo**, **Alérgeno**.
- Relaciones clave:
  - Usuario se sienta en una Mesa → 1:1 o 1:N (según diseño).
  - Usuario hace Pedido(s) → 1:N.
  - Pedido incluye Artículos con cantidad → N:M con atributo `cantidad`.
  - Artículo contiene Alérgenos → N:M con atributo `nivel_urgencia`.

**Tablas finales (resumen):**
```text
USUARIO (id_usuario, nombre, correo, telefono, id_mesa)
MESA (id_mesa, num_max_comensales)
PEDIDO (id_pedido, id_usuario)
ARTICULO (id_articulo, tipo, precio, nombre)
ALERGENO (id_alergeno, nombre, nivel_urgencia)
PEDIDO_CONTIENE_ARTICULO (id_pedido, id_articulo, cantidad)
ARTICULO_CONTIENE_ALERGENO (id_articulo, id_alergeno)
```

### 🧩 Trofeo Grados Granada
- Entidades: **Participante**, **Alumno**, **Profesor**, **Academia**, **Equipo**, **Torneo**, **Deporte**, **Partido**.
- Herencia: Participante → Alumno / Profesor.
- Relaciones clave:
  - Alumno estudia en una Academia (1:N).
  - Profesor trabaja en varias Academias (N:M).
  - Equipo pertenece a una Academia y se inscribe a un Torneo (1:N).
  - Torneo corresponde a un solo Deporte (1:1 o 1:N).
  - Partido enfrenta a dos Equipos y tiene un árbitro (relación ternaria o con FK múltiples).

**Tablas finales (resumen):**
```text
PARTICIPANTE (dni, nombre, telefono, foto)
ALUMNO (dni, curso, grado, id_academia)
PROFESOR (dni, nss, area)
ACADEMIA (id_academia, nombre, direccion, año_apertura)
EQUIPO (id_equipo, nombre, id_torneo, id_academia, dni_capitan)
DEPORTE (id_deporte, nombre, max_jugadores, min_jugadores)
TORNEO (id_torneo, nombre, max_equipos, id_deporte)
PARTIDO (id_partido, id_equipo1, id_equipo2, fecha, lugar, dni_arbitro)
PROFESOR_TRABAJA_ACADEMIA (dni_profesor, id_academia)
PARTICIPANTE_PERTENECE_EQUIPO (dni_participante, id_equipo)
```

---

## 🧭 12️⃣ RESUMEN DE RAZONAMIENTO

1️⃣ **Detectar entidades:** sustantivos principales del texto.  
2️⃣ **Relacionarlas:** verbos que las unen.  
3️⃣ **Añadir atributos:** los datos que “se quieren saber de cada cosa”.  
4️⃣ **Determinar cardinalidades:** cuántas veces una entidad se asocia con otra.  
5️⃣ **Transformar:** aplicar reglas 1:N → FK, N:M → tabla intermedia.  
6️⃣ **Revisar:** toda PK definida, toda FK válida, nada repetido.

---

✍️ **Consejo final de Profe Byte:**
> No memorices diagramas: aprende a *traducir texto → entidades → relaciones*.  
> Todo enunciado es una historia. Cada sustantivo es una tabla, cada verbo una relación, y cada número o atributo una columna.

