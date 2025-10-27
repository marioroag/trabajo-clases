# **Unidad Didáctica 2: Gestión de Procesos y Administración de Usuarios y Grupos**
---

## **2.1. Permisos y Propiedad de Archivos (chmod, chown, chgrp)**

En los sistemas Unix/Linux, el control de acceso a los archivos y directorios se gestiona a través de un esquema de permisos que define qué operaciones pueden realizar los usuarios sobre un recurso específico. Estos permisos se establecen para tres tipos de entidades: el propietario del archivo, el grupo al que pertenece y otros usuarios. A continuación se detallan los conceptos y comandos fundamentales para gestionar permisos y propiedad de archivos.

### **Permisos de Archivos en Unix/Linux**

#### **Clasificación de Permisos**
Cada archivo y directorio en Linux tiene asociados un conjunto de permisos que definen el nivel de acceso permitido. Estos permisos se organizan en tres categorías:

- **Lectura (`r`)**:
  - Para un archivo: Permite visualizar su contenido, es decir, leer el contenido del archivo.
  - Para un directorio: Permite listar los archivos y subdirectorios que contiene.

- **Escritura (`w`)**:
  - Para un archivo: Permite modificar el contenido del archivo, lo que incluye la capacidad de agregar, editar o eliminar datos dentro del mismo.
  - Para un directorio: Permite agregar, eliminar y renombrar archivos dentro del directorio.

- **Ejecución (`x`)**:
  - Para un archivo: Permite ejecutar el archivo como un programa o script.
  - Para un directorio: Permite acceder a los archivos y subdirectorios contenidos dentro del directorio. Sin el permiso de ejecución, no es posible navegar dentro del directorio aunque se tengan permisos de lectura.

#### **Entidades de Permisos**
Los permisos se definen para tres tipos de usuarios en el sistema:

1. **Usuario (Owner)**: El propietario del archivo o directorio. Generalmente, es el usuario que crea el archivo y tiene privilegios completos sobre el recurso.
2. **Grupo (Group)**: Un grupo de usuarios que comparten ciertos permisos sobre el archivo o directorio. El grupo se asocia al archivo y, por lo general, los miembros de este grupo tienen permisos similares.
3. **Otros (Others)**: Todos los demás usuarios del sistema que no sean ni el propietario ni los miembros del grupo. Se les otorgan permisos específicos, como acceso restringido o nulo.

#### **Visualización de Permisos con `ls -l`**
Para verificar los permisos de un archivo o directorio, se utiliza el comando `ls` con la opción `-l` (long listing format), que muestra una lista detallada de los archivos y sus propiedades:

```bash
ls -l
```

##### **Salida de Ejemplo:**
```
-rwxr-xr-- 1 usuario grupo 4096 Oct  7 14:20 archivo.txt
```

Cada campo de esta salida tiene un significado específico:

1. **`-rwxr-xr--`**: Muestra los permisos de archivo.
   - **Primer carácter (`-`)**: Indica el tipo de archivo. Puede ser:
     - `-`: Archivo regular.
     - `d`: Directorio.
     - `l`: Enlace simbólico.
   - **Permisos del propietario (`rwx`)**: El propietario puede leer, escribir y ejecutar (`rwx`).
   - **Permisos del grupo (`r-x`)**: Los usuarios del grupo pueden leer y ejecutar, pero no escribir (`r-x`).
   - **Permisos de otros (`r--`)**: Los demás usuarios solo pueden leer (`r--`).

2. **`1`**: Número de enlaces simbólicos que apuntan al archivo.
3. **`usuario`**: Nombre del propietario del archivo.
4. **`grupo`**: Nombre del grupo al que pertenece el archivo.
5. **`4096`**: Tamaño del archivo en bytes.
6. **`Oct 7 14:20`**: Fecha y hora de la última modificación.
7. **`archivo.txt`**: Nombre del archivo.

### **Gestión de Permisos con `chmod`**
El comando `chmod` (change mode) se utiliza para cambiar los permisos de un archivo o directorio. Los permisos pueden especificarse en dos formatos: **simbólico** y **numérico** (octal).

#### **Formato Simbólico**
En el formato simbólico, los permisos se modifican utilizando combinaciones de letras y símbolos:
- `u`: Propietario (usuario).
- `g`: Grupo.
- `o`: Otros.
- `a`: Todos (propietario, grupo y otros).
- `+`: Añadir permisos.
- `-`: Eliminar permisos.
- `=`: Establecer permisos específicos.

**Ejemplos**:
- `chmod u+x archivo.sh`: Añade permiso de ejecución para el propietario.
- `chmod g-w archivo.txt`: Elimina el permiso de escritura para el grupo.
- `chmod a=r archivo.conf`: Establece permisos de solo lectura para todos.

#### **Formato Numérico (Octal)**
El formato numérico utiliza un valor de 3 dígitos para representar los permisos en base octal. Cada dígito puede ser 0-7 y se calcula sumando los permisos:
- **4**: Lectura (`r`).
- **2**: Escritura (`w`).
- **1**: Ejecución (`x`).

El valor de cada dígito corresponde a una entidad: propietario, grupo y otros.
- `chmod 755 archivo.txt`: Establece permisos `rwxr-xr-x`.
- `chmod 644 documento.txt`: Establece permisos `rw-r--r--` (solo el propietario puede escribir).

### **Gestión de Propiedad de Archivos**

#### **Cambio de Propietario con `chown`**
El comando `chown` (change owner) permite cambiar el propietario de un archivo o directorio. Es útil cuando se transfieren archivos entre usuarios o se requiere reasignar la propiedad de un recurso.

**Sintaxis**:
```bash
chown [nuevo_propietario] [archivo]
```

**Ejemplo**:
```bash
chown carlos documento.txt
```
En este ejemplo, el propietario de `documento.txt` se cambia a `carlos`. También es posible cambiar simultáneamente el grupo utilizando el formato `propietario:grupo`:

```bash
chown carlos:desarrollo proyecto.zip
```
Este comando asigna el archivo `proyecto.zip` a `carlos` y al grupo `desarrollo`.

#### **Cambio de Grupo con `chgrp`**
El comando `chgrp` (change group) se utiliza para cambiar el grupo al que pertenece un archivo o directorio. Esta operación es útil cuando se necesita reorganizar permisos basados en grupos.

**Sintaxis**:
```bash
chgrp [nuevo_grupo] [archivo]
```

**Ejemplo**:
```bash
chgrp marketing informe.doc
```
Aquí, el grupo del archivo `informe.doc` se cambia a `marketing`, permitiendo a los miembros de ese grupo acceder al archivo según los permisos definidos.

### **Combinación de `chown` y `chmod`**
Es frecuente combinar `chown` y `chmod` para establecer de manera efectiva permisos y propiedad en archivos recién creados o transferidos.

**Ejemplo**:
```bash
chown juan:administradores proyecto.sh
chmod 750 proyecto.sh
```
En este ejemplo, se asigna el archivo `proyecto.sh` a `juan` y al grupo `administradores`, y se establecen permisos de lectura, escritura y ejecución para el propietario (`juan`), permisos de lectura y ejecución para el grupo (`administradores`), y sin permisos para otros usuarios.

---

## **2.2. Gestión de Usuarios**

La gestión de usuarios en un sistema Unix/Linux es un componente fundamental para mantener un entorno controlado y seguro. Cada usuario tiene un perfil que define su acceso y permisos en el sistema, así como su entorno de trabajo y su asociación con grupos. La administración de usuarios implica la creación, modificación, eliminación de cuentas y el ajuste de sus privilegios. A continuación se presenta una guía técnica detallada sobre cómo gestionar usuarios en sistemas Linux.

### **2.2.1. Creación de Usuarios**

#### **Comando `adduser`**

El comando `adduser` es una herramienta de alto nivel que facilita la creación de un nuevo usuario en el sistema. Este comando no solo crea la cuenta de usuario, sino que también establece el entorno del usuario, su directorio de inicio, define su grupo principal y solicita la asignación de una contraseña inicial. En algunos sistemas, `adduser` es un script que interactúa con el administrador de manera más intuitiva que `useradd`.

- **Sintaxis**: 
  ```bash
  adduser [nombre_usuario]
  ```
  
- **Descripción**: 
  Al ejecutar el comando `adduser`, el sistema realiza las siguientes acciones:
  1. Crea una nueva entrada en el archivo `/etc/passwd` para el usuario.
  2. Asigna un **UID** (User ID) y **GID** (Group ID) únicos.
  3. Crea un directorio de inicio en `/home/nombre_usuario` con los permisos adecuados( USANDO -m).
  4. Copia archivos de configuración predeterminados desde `/etc/skel` al nuevo directorio de inicio.
  5. Solicita al administrador la introducción de una contraseña para el nuevo usuario.

- **Ejemplo**:
  ```bash
  adduser -m juan
  ```
  Este comando creará un nuevo usuario llamado `juan` con un directorio de inicio en `/home/juan` y pedirá al administrador una contraseña para completar la configuración.

#### **Opciones de `adduser`**

- `--home [ruta]`: Define un directorio de inicio específico.
  - Ejemplo: `adduser --home /opt/usuarios/juan juan` (Crea el directorio de inicio en `/opt/usuarios/juan`).
  
- `--shell [ruta_shell]`: Especifica el shell por defecto del usuario.
  - Ejemplo: `adduser --shell /bin/bash juan` (Establece `/bin/bash` como el shell predeterminado de `juan`).

- `--ingroup [nombre_grupo]`: Asigna el usuario a un grupo diferente al grupo por defecto.
  - Ejemplo: `adduser --ingroup desarrolladores juan` (Crea a `juan` dentro del grupo `desarrolladores`).

### **2.2.2. Eliminación de Usuarios**

#### **Comando `deluser`**

El comando `deluser` permite eliminar cuentas de usuario del sistema, eliminando también su pertenencia a grupos y otras asociaciones. Sin embargo, este comando no elimina el directorio de inicio del usuario de manera predeterminada, para evitar la pérdida accidental de datos.

- **Sintaxis**:
  ```bash
  deluser [nombre_usuario]
  ```
  
- **Descripción**:
  Al ejecutar `deluser`, el sistema elimina la entrada correspondiente del archivo `/etc/passwd` y ajusta las asociaciones de grupos en `/etc/group`. Opcionalmente, se pueden eliminar otros recursos relacionados, como el directorio de inicio o los archivos temporales creados por el usuario.

- **Ejemplo**:
  ```bash
  deluser juan
  ```
  Este comando elimina al usuario `juan` del sistema pero conserva su directorio de inicio en `/home/juan`.

#### **Opciones de `deluser`**

- `--remove-home`: Elimina el directorio de inicio y los archivos del usuario.
  - Ejemplo: `deluser --remove-home juan`

- `--backup`: Crea un archivo comprimido del directorio de inicio antes de eliminar al usuario.
  - Ejemplo: `deluser --backup juan`

- `--remove-all-files`: Elimina todos los archivos del usuario en todo el sistema.
  - Ejemplo: `deluser --remove-all-files juan`

### **2.2.3. Modificación de Usuarios con `usermod`**

El comando `usermod` se utiliza para modificar las propiedades de cuentas de usuario existentes. Permite cambiar el nombre de usuario, su directorio de inicio, el shell predeterminado y otras configuraciones sin necesidad de eliminar y volver a crear la cuenta.

- **Sintaxis**:
  ```bash
  usermod [opciones] [nombre_usuario]
  ```

#### **Opciones Comunes de `usermod`**

- `-l [nuevo_nombre]`: Cambia el nombre del usuario.
  - Ejemplo: `usermod -l juanperez juan` (Cambia el nombre del usuario `juan` a `juanperez`).

- `-d [nueva_ruta]`: Modifica el directorio de inicio del usuario.
  - Ejemplo: `usermod -d /mnt/almacen/juan juan` (Cambia el directorio de inicio a `/mnt/almacen/juan`).

- `-g [grupo]`: Cambia el grupo principal del usuario.
  - Ejemplo: `usermod -g administradores juan` (Establece `administradores` como el grupo principal de `juan`).

- `-aG [grupo]`: Añade el usuario a un grupo secundario.
  - Ejemplo: `usermod -aG sudo juan` (Añade a `juan` al grupo `sudo`).

- `-L`/`-U`: Bloquea (`-L`) o desbloquea (`-U`) la cuenta de usuario.
  - Ejemplo: `usermod -L juan` (Bloquea la cuenta de `juan`).

- `-s [shell]`: Cambia el shell predeterminado del usuario.
  - Ejemplo: `usermod -s /bin/zsh juan` (Establece `/bin/zsh` como el shell por defecto de `juan`).

### **2.2.4. Visualización de Información de Usuario**

#### **Comando `whoami`**
El comando `whoami` es una herramienta simple pero fundamental que permite conocer la identidad del usuario que está actualmente autenticado en la sesión de terminal. Esto es útil para verificar qué permisos tiene un usuario, especialmente cuando se están utilizando herramientas como `sudo` para cambiar de identidad temporalmente.

- **Sintaxis**:
  ```bash
  whoami
  ```
  
- **Descripción**:
  `whoami` devuelve el nombre de usuario de la sesión actual. En sistemas Linux, cada sesión de terminal tiene una identidad de usuario asociada. Saber quién es el usuario activo ayuda a comprender el contexto en el que se ejecutan los comandos.

- **Ejemplo**:
  Si el usuario `admin` está conectado y ejecuta el comando `whoami`:
  ```bash
  whoami
  ```
  La salida será:
  ```
  admin
  ```

#### **Comando `id`**
El comando `id` proporciona una visión completa de la identidad del usuario, mostrando el UID (User ID), GID (Group ID) y todos los grupos a los que pertenece el usuario.

- **Sintaxis**:
  ```bash
  id [nombre_usuario]
  ```
  
- **Descripción**:
  Muestra el UID, GID y grupos secundarios asociados al usuario especificado. Si se ejecuta sin opciones, muestra la información del usuario actual.

- **Ejemplo**:
  ```bash
  id juan
  ```
  Salida esperada:
  ```
  uid=1001(juan) gid=1001(juan) grupos=1001(juan),27(sudo),1002(desarrollo)
  ```

### **2.2.5. Archivos de Configuración de Usuarios**

#### **Archivo `/etc/passwd`**
El archivo `/etc/passwd` almacena información básica de todas las cuentas de usuario. Cada línea representa un usuario y contiene los siguientes campos separados por `:`:

```
usuario:x:UID:GID:comentario:/home/directorio:/bin/shell
```

- **usuario**: Nombre del usuario.
- **x**: Contraseña encriptada (en algunos sistemas se almacena en `/etc/shadow`).
- **UID**: User ID.
- **GID**: Group ID.
- **comentario**: Información descriptiva del usuario.
- **/home/directorio**: Directorio de inicio.
- **/bin/shell**: Shell de inicio del usuario.

#### **Archivo `/etc/group`**
Este archivo almacena información sobre los grupos de usuarios. Cada línea representa un grupo y contiene los siguientes campos:

```
nombre_grupo:x:GID:miembros
```

- **nombre_grupo**: Nombre del grupo.
- **x**: Contraseña del grupo (normalmente deshabilitada).
- **GID**: Group ID.
- **miembros**: Lista de usuarios que pertenecen al grupo, separados por comas.

---

## **2.3. Gestión de Grupos**

En sistemas Unix/Linux, los grupos representan un mecanismo de control de acceso que permite organizar a los usuarios en colecciones que comparten permisos y privilegios sobre archivos y recursos del sistema. A través de los grupos, se pueden definir políticas de acceso compartido de manera eficiente, asegurando que todos los miembros de un grupo tengan los mismos permisos en determinados archivos y directorios. La correcta gestión de grupos facilita la administración de usuarios en sistemas multiusuario, donde se necesita granularidad y control en la asignación de privilegios.

### **Concepto de Grupos en Unix/Linux**

#### **1. Tipos de Grupos**

1. **Grupo Primario**:
   - Es el grupo principal al que pertenece el usuario. Cada usuario debe tener un único grupo primario, definido en el momento de su creación.
   - El grupo primario se establece en el archivo `/etc/passwd` y se asigna automáticamente a los archivos y directorios creados por el usuario.

2. **Grupos Secundarios**:
   - Son grupos adicionales a los que un usuario puede pertenecer. Los grupos secundarios permiten a los usuarios acceder a archivos y directorios compartidos por otros grupos sin modificar su grupo primario.
   - Los grupos secundarios se definen en el archivo `/etc/group`.

3. **Grupos de Sistema**:
   - Son grupos utilizados por el sistema y servicios (como `sudo`, `docker`, `adm`, entre otros) para definir permisos especiales o de acceso a servicios específicos. No suelen tener usuarios de sesión interactiva.

#### **2. Archivos de Configuración de Grupos**

1. **`/etc/group`**: Contiene la definición de todos los grupos del sistema. Cada línea del archivo representa un grupo y sigue el formato:

   ```
   nombre_grupo:x:GID:miembros
   ```

   Donde:
   - **nombre_grupo**: Es el nombre del grupo.
   - **x**: Indica que la contraseña del grupo está almacenada en `/etc/gshadow` (si se habilita la opción).
   - **GID**: Es el **Group ID**, un identificador único para cada grupo.
   - **miembros**: Lista de usuarios que forman parte del grupo, separados por comas (si existen).

   **Ejemplo** de entrada en `/etc/group`:
   ```
   desarrollo:x:1002:juan,pedro
   ```

   Indica que el grupo `desarrollo` tiene el ID `1002` y cuenta con los usuarios `juan` y `pedro` como miembros.

2. **`/etc/gshadow`**: Archivo que almacena las contraseñas de los grupos y definiciones de seguridad relacionadas.

### **3. Comandos para la Gestión de Grupos**

Los comandos de gestión de grupos permiten crear, modificar y eliminar grupos en el sistema. A continuación se describe en detalle el uso de los comandos más comunes: `groupadd`, `groupdel` y `groupmod`.

#### **3.1. Creación de Grupos con `groupadd`**

El comando `groupadd` se utiliza para crear un nuevo grupo en el sistema. Al crear un grupo, se le asigna un **GID** único y opcionalmente se pueden definir parámetros como el ID del grupo y la información extendida.

- **Sintaxis**:
  ```bash
  groupadd [opciones] [nombre_grupo]
  ```

- **Parámetros Comunes**:
  - `-g [GID]`: Especifica el GID del nuevo grupo. Si no se proporciona, el sistema asignará el siguiente GID disponible.
  - `-r`: Crea un grupo de sistema con un GID menor a 1000. Los grupos de sistema se utilizan para servicios y aplicaciones.

- **Ejemplo**:
  ```bash
  groupadd -g 1500 desarrollo
  ```
  Crea un grupo llamado `desarrollo` con un GID de `1500`. Este comando es útil cuando se desea mantener una estructura de IDs consistente entre servidores.

#### **3.2. Eliminación de Grupos con `groupdel`**

El comando `groupdel` elimina un grupo existente del sistema. Es importante considerar que este comando solo elimina el grupo y no los archivos que estén asignados a él.

- **Sintaxis**:
  ```bash
  groupdel [nombre_grupo]
  ```

- **Descripción**:
  Al ejecutar `groupdel`, el grupo se elimina del archivo `/etc/group` y se elimina cualquier referencia a él en `/etc/gshadow`. Si un usuario tiene este grupo como grupo secundario, se eliminará esa asociación. Sin embargo, si un usuario tiene este grupo como grupo primario, el comando fallará y será necesario reasignar el grupo primario del usuario antes de eliminar el grupo.

- **Ejemplo**:
  ```bash
  groupdel desarrollo
  ```
  Elimina el grupo `desarrollo` del sistema. Si existen usuarios con `desarrollo` como grupo primario, se debe ejecutar previamente:

  ```bash
  usermod -g usuarios juan
  ```

  Este comando cambia el grupo principal de `juan` a `usuarios` antes de eliminar `desarrollo`.

#### **3.3. Modificación de Grupos con `groupmod`**

El comando `groupmod` se utiliza para modificar las propiedades de un grupo existente. Permite cambiar el nombre del grupo, su GID y la lista de miembros asociados.

- **Sintaxis**:
  ```bash
  groupmod [opciones] [nombre_grupo]
  ```

- **Parámetros Comunes**:
  - `-n [nuevo_nombre]`: Cambia el nombre del grupo.
  - `-g [nuevo_GID]`: Modifica el GID del grupo.
  - `-A [usuarios]`: Añade uno o más usuarios al grupo.
  - `-R [usuarios]`: Elimina uno o más usuarios del grupo.

- **Ejemplo**:
  ```bash
  groupmod -n equipo_proyecto desarrollo
  ```
  Cambia el nombre del grupo `desarrollo` a `equipo_proyecto`. Esto actualiza automáticamente el archivo `/etc/group` para reflejar el nuevo nombre.

### **4. Asignación de Usuarios a Grupos**

El comando `usermod` se puede utilizar para asignar usuarios a grupos de manera flexible.

- **Añadir un usuario a un grupo secundario**:
  ```bash
  usermod -aG desarrollo juan
  ```
  Añade a `juan` al grupo `desarrollo` como grupo secundario, manteniendo su grupo primario inalterado.

- **Cambiar el grupo primario de un usuario**:
  ```bash
  usermod -g desarrollo juan
  ```
  Establece `desarrollo` como el grupo primario de `juan`.

### **5. Visualización de Información de Grupos**

Existen varios comandos para consultar y verificar los grupos y sus miembros:

- **`groups [nombre_usuario]`**: Muestra los grupos a los que pertenece un usuario.
  ```bash
  groups juan
  ```
  Salida esperada:
  ```
  juan : juan desarrollo sudo
  ```
  Indica que el usuario `juan` pertenece a los grupos `juan` (grupo primario), `desarrollo` y `sudo` (grupos secundarios).

- **`getent group [nombre_grupo]`**: Muestra la información detallada de un grupo desde la base de datos del sistema.
  ```bash
  getent group desarrollo
  ```
  Salida esperada:
  ```
  desarrollo:x:1500:juan,pedro
  ```
  Indica que `desarrollo` tiene un GID de `1500` y sus miembros son `juan` y `pedro`.

### **6. Consideraciones de Seguridad en la Gestión de Grupos**

1. **Control de Acceso**: La correcta asignación de grupos ayuda a controlar el acceso a archivos y directorios. Los administradores deben asegurarse de que los usuarios solo pertenezcan a los grupos necesarios para su rol.

2. **Privilegios Elevados**: Los grupos como `sudo` y `wheel` otorgan privilegios elevados. Se recomienda restringir el acceso a estos grupos a un número mínimo de usuarios.

3. **Contraseñas de Grupo**: Aunque rara vez se utilizan, los grupos pueden tener contraseñas definidas en `/etc/gshadow`. Si se habilitan, las contraseñas deben ser gestionadas con cuidado para evitar accesos no autorizados.

---

## **2.4. Permisos y Roles de Superusuario (sudo)**

El comando `sudo` (abreviatura de "superuser do") es una herramienta fundamental en la administración de sistemas Unix/Linux, que permite a los usuarios ejecutar comandos con privilegios elevados de manera segura y controlada. Con `sudo`, un usuario puede ejecutar un comando con privilegios de superusuario (`root`) u otro usuario específico sin tener que iniciar sesión directamente como `root`. Esta capacidad es crucial para tareas administrativas como la instalación de software, la configuración del sistema y la modificación de archivos protegidos. El uso de `sudo` permite aplicar políticas de seguridad más estrictas, limitar el acceso a usuarios específicos y mantener un registro detallado de las actividades administrativas.

### **2.4.1. Concepto de Superusuario y `sudo`**

En sistemas Unix/Linux, el superusuario (también conocido como `root`) tiene control total sobre el sistema, con privilegios para acceder, modificar y eliminar cualquier archivo, así como para cambiar configuraciones críticas. Sin embargo, iniciar sesión directamente como `root` presenta riesgos significativos:

1. **Posibilidad de errores críticos**: Un comando mal ejecutado puede causar daños graves al sistema.
2. **Mayor riesgo de seguridad**: Cualquier error de seguridad puede proporcionar a un atacante acceso completo al sistema.

Por estas razones, `sudo` se utiliza para permitir a usuarios con privilegios limitados ejecutar comandos específicos como superusuario, mejorando la seguridad y control.

### **2.4.2. Sintaxis y Uso Básico de `sudo`**

La sintaxis básica de `sudo` es la siguiente:

```bash
sudo [opciones] [comando]
```

Cuando se ejecuta un comando con `sudo`, el sistema solicita la contraseña del usuario para verificar su identidad y, si el usuario está autorizado, ejecuta el comando con los privilegios de superusuario.

#### **Ejemplo Básico**:
```bash
sudo apt update
```
Este comando actualiza la lista de paquetes del sistema con privilegios de superusuario, una operación que no podría ser realizada por un usuario sin privilegios.

#### **Opción `-u` para Especificar el Usuario**
`sudo` no solo permite ejecutar comandos como superusuario (`root`), sino también como cualquier otro usuario del sistema. La opción `-u` permite especificar el nombre del usuario con el que se desea ejecutar el comando:

```bash
sudo -u [nombre_usuario] [comando]
```

**Ejemplo**:
```bash
sudo -u www-data ls /var/www
```
Este comando lista el contenido del directorio `/var/www` como si fuera ejecutado por el usuario `www-data`, que normalmente se utiliza para servicios web.

#### **Opción `-s` para Iniciar un Shell con Privilegios Elevados**
La opción `-s` permite abrir una sesión de shell con privilegios elevados. Este comando es útil cuando se desea realizar múltiples operaciones consecutivas como superusuario sin prefijar cada comando con `sudo`:

```bash
sudo -s
```

### **2.4.3. Configuración de `sudo` con el Archivo `/etc/sudoers`**

La configuración de `sudo` se define en el archivo `/etc/sudoers`, que determina qué usuarios pueden utilizar `sudo` y qué permisos tienen. La edición de este archivo se debe realizar utilizando el comando `visudo` para garantizar la integridad de la configuración y evitar errores de sintaxis que puedan bloquear el acceso a `sudo`.

- **Sintaxis para Editar el Archivo `sudoers`**:
  ```bash
  sudo visudo
  ```
  `visudo` abre el archivo `/etc/sudoers` en un entorno seguro y bloquea el archivo para evitar ediciones simultáneas. Si se produce un error de sintaxis, `visudo` advierte al administrador y permite corregir el problema antes de guardar los cambios.

#### **Formato del Archivo `sudoers`**

Cada línea en `/etc/sudoers` define permisos para usuarios o grupos. La sintaxis general es:

```
usuario HOST=(USUARIO_CUENTA) COMANDO
```

- **`usuario`**: Especifica el usuario que puede ejecutar el comando con `sudo`.
- **`HOST`**: Define el host en el que se aplica la regla (por lo general, se utiliza `ALL` para permitir en todos los hosts).
- **`(USUARIO_CUENTA)`**: Especifica la identidad bajo la cual se ejecutará el comando (por defecto `root`).
- **`COMANDO`**: Lista de comandos que el usuario puede ejecutar.

#### **Ejemplo de Entradas en `/etc/sudoers`**:

1. **Permitir a un Usuario Ejecutar Todos los Comandos**:
   ```
   juan ALL=(ALL) ALL
   ```
   Esta regla permite al usuario `juan` ejecutar cualquier comando con `sudo` en cualquier host, como si fuera `root`.

2. **Permitir a un Usuario Reiniciar el Sistema**:
   ```
   carlos ALL=(ALL) /sbin/shutdown
   ```
   Esta regla permite a `carlos` ejecutar solo el comando `/sbin/shutdown`, utilizado para apagar o reiniciar el sistema.

3. **Permitir a un Grupo Utilizar `sudo`**:
   ```
   %admin ALL=(ALL) ALL
   ```
   El símbolo `%` indica un grupo. En este ejemplo, todos los usuarios pertenecientes al grupo `admin` pueden ejecutar cualquier comando con `sudo`.

### **2.4.4. Control de Acceso y Políticas de Seguridad**

El uso de `sudo` proporciona un control de acceso granular y la capacidad de limitar el uso de comandos específicos a ciertos usuarios o grupos. Esto es especialmente importante en entornos de producción donde múltiples administradores pueden tener acceso a diferentes componentes del sistema. Al configurar el archivo `/etc/sudoers`, es recomendable seguir las siguientes prácticas de seguridad:

1. **Aplicar el Principio de Mínimos Privilegios**:
   - Otorgar a los usuarios solo los permisos necesarios para realizar su trabajo.
   - Limitar el uso de `sudo` a comandos específicos siempre que sea posible.

2. **Utilizar Grupos para Definir Acceso**:
   - En lugar de asignar permisos a usuarios individuales, utilizar grupos para facilitar la administración. Por ejemplo, definir un grupo `sysadmin` para todos los usuarios que necesiten permisos administrativos.

3. **Requerir Contraseñas para `sudo`**:
   - De forma predeterminada, `sudo` solicita la contraseña del usuario que ejecuta el comando. Se recomienda no deshabilitar esta funcionalidad para evitar accesos no autorizados.

4. **Registro de Actividad con `sudo`**:
   - `sudo` registra cada comando ejecutado en el archivo `/var/log/auth.log` (en la mayoría de distribuciones). Esta funcionalidad permite auditar la actividad administrativa y detectar posibles usos indebidos de `sudo`.

### **2.4.5. Opciones Avanzadas de `sudo`**

#### **Opción `NOPASSWD` para Omitir la Solicitud de Contraseña**
Es posible configurar `sudo` para que no solicite la contraseña al ejecutar comandos específicos. Aunque esta práctica se debe utilizar con precaución, es útil para automatizar tareas en scripts.

**Ejemplo en `sudoers`**:
```
juan ALL=(ALL) NOPASSWD: /usr/bin/systemctl restart apache2
```
Esta regla permite a `juan` reiniciar el servicio `apache2` con `sudo` sin que se le solicite una contraseña.

#### **Alias de Comandos y Usuarios**
El archivo `sudoers` admite la definición de alias para simplificar la configuración:

- **Alias de Usuarios**:
  ```
  User_Alias ADMINS = juan, carlos, maria
  ```
  Crea un alias `ADMINS` que agrupa a los usuarios `juan`, `carlos` y `maria`.

- **Alias de Comandos**:
  ```
  Cmnd_Alias SHUTDOWN_CMDS = /sbin/shutdown, /sbin/reboot
  ```
  Agrupa los comandos `shutdown` y `reboot` en un alias llamado `SHUTDOWN_CMDS`.

#### **Ejecución de Múltiples Comandos con `sudo`**
Si se desea ejecutar múltiples comandos con privilegios elevados, se puede utilizar `&&` o ejecutar un script completo con `sudo`:

```bash
sudo bash -c "apt update && apt upgrade -y"
```

### **2.4.6. Diferencias entre `sudo` y `su`**

El comando `su` permite cambiar a otro usuario y asumir su entorno, generalmente sin restricciones de permisos. A diferencia de `sudo`, `su` no requiere estar previamente configurado en el archivo `sudoers` y, por tanto, proporciona un acceso menos controlado y menos seguro.

- **`sudo`**: Proporciona acceso controlado, permite auditar actividades y limita el uso a comandos específicos.
- **`su`**: Cambia al usuario especificado, accediendo a su entorno y permisos. Requiere la contraseña del usuario al que se desea cambiar.

**Ejemplo de `su`**:
```bash
su - juan
```
Cambia al usuario `juan` en una nueva sesión interactiva, solicitando la contraseña de `juan`.

---

## **2.5. Seguridad de Cuentas y Contraseñas**

La seguridad de cuentas es un aspecto crítico en la administración de sistemas Unix/Linux, ya que asegura que solo los usuarios autorizados puedan acceder a los recursos del sistema. Una de las principales estrategias para proteger las cuentas es la correcta gestión y protección de las contraseñas. Dado que las contraseñas son la primera línea de defensa contra accesos no autorizados, es fundamental establecer políticas de seguridad sólidas que incluyan la configuración de contraseñas robustas, el control de caducidad y la aplicación de requisitos de complejidad. A continuación, se detallan las prácticas y herramientas disponibles en sistemas Unix/Linux para gestionar y proteger las contraseñas de manera efectiva.

### **2.5.1. Configuración de Contraseñas Seguras con el Comando `passwd`**

El comando `passwd` es la herramienta principal para establecer, cambiar y gestionar las contraseñas de usuario en sistemas Unix/Linux. Este comando puede ser utilizado tanto por el usuario para cambiar su propia contraseña como por el administrador del sistema (`root`) para establecer o modificar la contraseña de cualquier cuenta. La capacidad de cambiar las contraseñas de manera controlada es esencial para mantener la seguridad del sistema.

#### **Sintaxis de `passwd`**
```bash
passwd [nombre_usuario]
```

- **Si se ejecuta sin argumentos**:
  El comando `passwd` cambia la contraseña del usuario actual. Es útil para que cada usuario pueda gestionar su propia contraseña de manera segura.

  ```bash
  passwd
  ```
  Al ejecutar este comando, el sistema solicitará la contraseña actual (si existe) y, posteriormente, pedirá que se ingrese la nueva contraseña dos veces para confirmarla.

- **Si se especifica un nombre de usuario**:
  El comando `passwd` permite a un administrador cambiar la contraseña de otro usuario. Solo los usuarios con privilegios (como `root`) pueden modificar las contraseñas de otros usuarios.

  ```bash
  passwd juan
  ```
  En este caso, el administrador puede establecer o cambiar la contraseña de `juan` sin necesidad de conocer la contraseña actual del usuario.

#### **Opciones Comunes de `passwd`**

- `-e`: Expira inmediatamente la contraseña, forzando al usuario a cambiarla en el próximo inicio de sesión.
  ```bash
  passwd -e juan
  ```
  Este comando es útil para asegurar que un usuario recién creado o cuya contraseña ha sido restablecida cambie su contraseña la próxima vez que inicie sesión.

- `-l`: Bloquea la cuenta del usuario, deshabilitando su acceso.
  ```bash
  passwd -l juan
  ```
  Al bloquear la cuenta, el comando `passwd` agrega un prefijo `!` al hash de la contraseña en el archivo `/etc/shadow`, indicando que el usuario `juan` no puede autenticarse hasta que su cuenta sea desbloqueada.

- `-u`: Desbloquea la cuenta de un usuario previamente bloqueado.
  ```bash
  passwd -u juan
  ```
  Elimina el prefijo `!` en el hash de la contraseña de `juan`, restaurando su acceso.

- `-d`: Elimina la contraseña de un usuario, dejando la cuenta sin protección.
  ```bash
  passwd -d juan
  ```
  Este comando se debe usar con extrema precaución, ya que permite iniciar sesión sin contraseña, lo que constituye un grave riesgo de seguridad.

### **2.5.2. Archivos de Configuración de Contraseñas**

Las políticas de contraseñas en sistemas Unix/Linux se gestionan a través de diversos archivos de configuración y módulos de seguridad que definen cómo se deben establecer las contraseñas, la duración de las mismas y los requisitos de complejidad.

#### **1. Archivo `/etc/login.defs`**

El archivo `/etc/login.defs` define las configuraciones globales de las contraseñas y las políticas de usuario. Algunos de los parámetros más importantes en este archivo son:

- **`PASS_MAX_DAYS`**: Define el número máximo de días que una contraseña es válida antes de caducar.
  ```plaintext
  PASS_MAX_DAYS 90
  ```
  Establece que las contraseñas deben ser cambiadas cada 90 días.

- **`PASS_MIN_DAYS`**: Especifica el número mínimo de días que deben transcurrir antes de que un usuario pueda cambiar su contraseña nuevamente.
  ```plaintext
  PASS_MIN_DAYS 1
  ```
  Evita cambios de contraseñas demasiado frecuentes que puedan eludir las políticas de caducidad.

- **`PASS_WARN_AGE`**: Define el número de días antes de la caducidad en los que se alerta al usuario para que cambie su contraseña.
  ```plaintext
  PASS_WARN_AGE 7
  ```
  Genera un aviso al usuario 7 días antes de que su contraseña caduque.

#### **2. Archivo `/etc/shadow`**

El archivo `/etc/shadow` almacena las contraseñas cifradas y otra información de control de las cuentas de usuario. Cada línea en `/etc/shadow` representa una cuenta de usuario y contiene los siguientes campos:

```
usuario:contraseña:último_cambio:min_días:max_días:aviso:expiración:inactividad
```

- **contraseña**: Hash de la contraseña almacenada.
- **último_cambio**: Número de días desde la época Unix (1 de enero de 1970) en que se cambió la contraseña por última vez.
- **min_días**: Número mínimo de días antes de que se pueda cambiar la contraseña.
- **max_días**: Número máximo de días que la contraseña es válida.
- **aviso**: Días antes de la caducidad para advertir al usuario.
- **expiración**: Número de días tras la caducidad en que la cuenta se desactiva.

**Ejemplo de entrada en `/etc/shadow`**:
```
juan:$6$sklX1...$D9U/abc...:18045:0:90:7:::
```
Esta línea indica que la contraseña de `juan` se cambió por última vez el día `18045` (en formato de días desde 1970), debe cambiarse cada `90` días, y se avisa `7` días antes de la caducidad.

### **2.5.3. Políticas de Contraseñas con `pam_pwquality`**

El módulo `pam_pwquality` (anteriormente conocido como `pam_cracklib`) es una herramienta que permite establecer políticas de contraseñas más complejas y seguras. Se configura en el archivo `/etc/pam.d/common-password` y permite definir requisitos específicos para la longitud y complejidad de las contraseñas.

#### **Configuración de `pam_pwquality`**

Agregar las siguientes líneas en el archivo `/etc/pam.d/common-password` para habilitar políticas de seguridad:

```plaintext
password requisite pam_pwquality.so retry=3 minlen=12 difok=4 ucredit=-1 lcredit=-1 dcredit=-1 ocredit=-1
```

- **`retry=3`**: Permite al usuario 3 intentos para introducir una contraseña que cumpla con las políticas.
- **`minlen=12`**: Establece una longitud mínima de 12 caracteres.
- **`difok=4`**: Requiere al menos 4 caracteres diferentes a la contraseña anterior.
- **`ucredit=-1`**: Exige al menos 1 letra mayúscula.
- **`lcredit=-1`**: Exige al menos 1 letra minúscula.
- **`dcredit=-1`**: Exige al menos 1 número.
- **`ocredit=-1`**: Exige al menos 1 carácter especial.

#### **Verificación de la Fuerza de las Contraseñas**

El comando `pwscore` se utiliza para verificar la fortaleza de una contraseña y asegurar que cumple con las políticas definidas:

```bash
echo "contraseña_segura" | pwscore
```

Esto genera una puntuación basada en la complejidad de la contraseña, proporcionando información sobre los aspectos que deben mejorarse para cumplir con las políticas.

### **2.5.4. Caducidad y Expiración de Cuentas**

Es importante que las cuentas de usuario inactivas sean desactivadas o eliminadas para evitar accesos no autorizados. El comando `chage` permite gestionar la caducidad de las contraseñas y la expiración de cuentas de manera detallada:

- **`chage -l [usuario]`**: Muestra la información de caducidad de la cuenta.
  
  ```bash
  chage -l juan
  ```
  Muestra cuándo fue el último cambio de contraseña, los días hasta la próxima expiración y otros detalles.

- **`chage -E [fecha] [usuario]`**: Establece una fecha de expiración para la cuenta.
  
  ```bash
  chage -E 2024-12-31 juan
  ```
  Indica que la cuenta `juan` expirará el 31 de diciembre de 2024, después de lo cual el usuario no podrá iniciar sesión.

### **2.5.5. Bloqueo y Desbloqueo de Cuentas**

Además de gestionar la seguridad de las contraseñas, es fundamental saber cómo bloquear y desbloquear cuentas de usuario en situaciones donde se detecten actividades sospechosas o cuando un usuario abandona la organización.

- **`passwd -l [usuario]`**: Bloquea la cuenta de

 un usuario.
  ```bash
  passwd -l juan
  ```
  Este comando previene que `juan` inicie sesión en el sistema.

- **`passwd -u [usuario]`**: Desbloquea la cuenta.
  ```bash
  passwd -u juan
  ```

---

## **2.6. Conceptos de Procesos en Unix/Linux**

En los sistemas operativos Unix/Linux, un **proceso** es una instancia en ejecución de un programa. Cada vez que un usuario o el sistema inicia un programa, se genera un proceso, que es gestionado por el kernel. Los procesos son la base de todas las tareas que se realizan en un sistema y abarcan desde comandos ejecutados en la terminal hasta servicios en segundo plano que permiten la funcionalidad del sistema. La administración de procesos en Unix/Linux es un tema clave para los administradores de sistemas, ya que permite controlar el rendimiento y la estabilidad del entorno.

### **2.6.1. ¿Qué es un Proceso en Unix/Linux?**

Un proceso en Unix/Linux se define como un programa en ejecución, con su propio contexto, memoria asignada y estado. Cada proceso se identifica mediante un número único conocido como **PID** (Process ID). Un proceso puede ser creado por un usuario a través de la ejecución de un comando, o por el sistema para ejecutar tareas críticas y servicios. Los procesos en Unix/Linux se crean de manera jerárquica, donde cada proceso tiene un **proceso padre** y, opcionalmente, uno o más **procesos hijos**.

#### **Componentes Claves de un Proceso**
1. **PID (Process ID)**: Identificador único de un proceso.
2. **PPID (Parent Process ID)**: Identificador del proceso padre.
3. **UID/GID**: Identificadores de usuario y grupo que poseen el proceso.
4. **Estado**: Condición actual del proceso (ejecutándose, esperando, detenido, etc.).
5. **Prioridad (Nice value)**: Indica la prioridad del proceso para el uso de la CPU.
6. **Contexto de Memoria**: Espacio de direcciones y memoria asignada al proceso.
7. **Tabla de Archivos Abiertos**: Lista de archivos que el proceso está utilizando.

### **2.6.2. Tipos de Procesos en Unix/Linux**

Los procesos en Unix/Linux se clasifican según cómo interactúan con la terminal y el entorno de usuario. Existen dos tipos principales:

#### **1. Procesos en Primer Plano (Foreground Processes)**

Los procesos en primer plano son aquellos que el usuario ejecuta directamente desde la terminal y que interactúan con ella de forma directa. Estos procesos toman el control de la terminal y bloquean la entrada de comandos hasta que se completan. Los procesos en primer plano generalmente requieren de la intervención del usuario para iniciar y finalizar.

- **Ejemplo**:
  ```bash
  nano archivo.txt
  ```
  Al ejecutar el editor de texto `nano`, la terminal queda bloqueada hasta que se cierra el programa. Durante este tiempo, el proceso de `nano` se encuentra en primer plano.

- **Comportamiento**:
  - El usuario no puede ejecutar otros comandos en la misma terminal mientras el proceso está en primer plano.
  - Para enviar un proceso en primer plano a segundo plano, se utiliza la combinación de teclas `Ctrl + Z` para detener el proceso, el comando `fg` para reanudarlo en segundo plano y el comando el comando `bg` para listar los procesos en segundo plano

#### **2. Procesos en Segundo Plano (Background Processes)**

Los procesos en segundo plano se ejecutan sin bloquear la terminal, lo que permite al usuario seguir ejecutando otros comandos de manera simultánea. Los procesos en segundo plano son útiles para tareas que requieren tiempo prolongado o que no necesitan interactuar con el usuario.

- **Ejemplo**:
  ```bash
  find / -name "*.log" &
  ```
  El símbolo `&` al final del comando indica que debe ejecutarse en segundo plano. La terminal muestra el PID del proceso, y el usuario puede continuar usando la terminal mientras el comando `find` busca archivos en el sistema.

- **Comportamiento**:
  - El proceso se ejecuta de manera asíncrona.
  - El usuario puede verificar el estado de los procesos en segundo plano con el comando `jobs`.
  - Para llevar un proceso de segundo plano a primer plano, se utiliza el comando `fg` seguido del número de trabajo.

### **2.6.3. Estados de los Procesos en Unix/Linux**

Cada proceso en Unix/Linux puede estar en uno de varios estados que determinan su comportamiento y su disponibilidad para ser ejecutado por la CPU. Estos estados indican si el proceso está activo, esperando, detenido o finalizado. Los estados de los procesos se pueden consultar con comandos como `ps`, `top` o `htop`.

#### **Estados Principales de los Procesos**

1. **Running (R)**:
   - El proceso se encuentra actualmente en ejecución o está listo para ejecutarse. La CPU está procesando sus instrucciones, o está a la espera de ser programado por el planificador del sistema.
   - **Ejemplo**: Un script de copia (`cp archivo1 archivo2`) en progreso.
   
   **Indicación en `ps`**: Se muestra como `R`.

2. **Sleeping (S)**:
   - El proceso se encuentra inactivo, esperando un evento o recurso, como la entrada de un usuario, la finalización de una operación de E/S (entrada/salida), o la disponibilidad de un archivo.
   - Se divide en dos subtipos:
     - **Uninterruptible Sleep (`D`)**: El proceso no puede ser interrumpido por señales. Es común en operaciones de E/S de hardware.
     - **Interruptible Sleep (`S`)**: El proceso puede ser despertado por una señal.

   **Indicación en `ps`**: Se muestra como `S` (Interruptible Sleep) o `D` (Uninterruptible Sleep).

3. **Stopped (T)**:
   - El proceso ha sido detenido por una señal, generalmente por intervención del usuario (`Ctrl + Z`) o por el comando `kill -STOP [PID]`. Un proceso detenido no consume recursos del sistema, pero sigue existiendo en la tabla de procesos.
   - **Ejemplo**: Un programa de edición de texto detenido temporalmente.

   **Indicación en `ps`**: Se muestra como `T`.

4. **Zombie (Z)**:
   - El proceso ha terminado su ejecución, pero su descriptor aún está en la tabla de procesos porque su **proceso padre** no ha leído su estado de salida (esto ocurre cuando el proceso padre no ha ejecutado la llamada `wait()`). Los procesos zombie no consumen recursos, pero ocupan un lugar en la tabla de procesos, lo que puede indicar un problema de diseño del proceso padre.
   - **Ejemplo**: Un proceso hijo que finaliza y su proceso padre no captura su estado de salida.

   **Indicación en `ps`**: Se muestra como `Z`.

### **2.6.4. Otras Clasificaciones de Procesos**

Además de los estados y la ubicación en primer o segundo plano, existen otras clasificaciones y características que definen el comportamiento de los procesos:

#### **1. Procesos Huérfanos**
Un proceso huérfano es un proceso cuyo padre ha finalizado o ha sido eliminado, dejando al proceso hijo sin un controlador directo. Cuando un proceso se queda huérfano, el sistema lo reasigna al proceso `init` (`PID 1`), que se convierte en su nuevo padre.

- **Ejemplo**: Si un proceso de usuario lanza un script y el usuario cierra la sesión, el script se convierte en un proceso huérfano.

#### **2. Daemons**
Los **daemons** son procesos de sistema que se ejecutan en segundo plano y realizan tareas de soporte, como gestionar conexiones de red, administrar bases de datos o monitorear el sistema. Los daemons generalmente se inician durante el arranque del sistema y no tienen interacción directa con el usuario.

- **Ejemplo**: `sshd` (demonio del servicio SSH) o `httpd` (demonio del servidor web Apache).

### **2.6.5. Gestión de Procesos en Unix/Linux**

Los procesos en Unix/Linux se gestionan mediante diversos comandos y herramientas que permiten controlar su estado, finalizar su ejecución, ajustar su prioridad y cambiar su contexto. Algunos de los comandos más importantes incluyen:

1. **`ps`**: Muestra información sobre los procesos en ejecución.
   ```bash
   ps aux
   ```
   Muestra una lista detallada de todos los procesos activos en el sistema con información como PID, estado, consumo de CPU y memoria.

2. **`top`** y **`htop`**: Muestran información en tiempo real de los procesos, permitiendo observar el consumo de recursos.
   ```bash
   top
   ```
   Proporciona una vista dinámica del uso de la CPU, memoria y estado de los procesos.

3. **`kill`**: Envía señales a los procesos para detenerlos, terminarlos o cambiar su estado.
   ```bash
   kill -9 [PID]
   ```
   Envía la señal `SIGKILL` para forzar la terminación de un proceso específico.

---

## **2.7. Monitoreo de Procesos**

El monitoreo de procesos es una tarea fundamental en la administración de sistemas Unix/Linux. Permite a los administradores obtener información detallada sobre el estado de los procesos en ejecución, el consumo de recursos del sistema y la carga de trabajo, y detectar problemas de rendimiento o de uso indebido de los recursos. Existen múltiples herramientas para monitorear los procesos en tiempo real o generar reportes estáticos de los mismos. Las herramientas de monitoreo, como `ps`, `top` y `htop`, son esenciales para identificar cuellos de botella, procesos fuera de control y optimizar el rendimiento del sistema.

### **2.7.1. Herramientas de Monitoreo de Procesos**

#### **1. Comando `ps`**

El comando `ps` (Process Status) es una herramienta versátil y poderosa para listar y obtener información detallada de los procesos en ejecución. A diferencia de las herramientas de monitoreo en tiempo real, `ps` genera una instantánea estática del estado actual de los procesos en el momento de su ejecución. Su flexibilidad radica en la gran cantidad de opciones disponibles para personalizar la salida y enfocarse en los aspectos específicos de los procesos.

- **Sintaxis Básica**:
  ```bash
  ps [opciones]
  ```
  Si se ejecuta sin opciones, `ps` muestra solo los procesos asociados a la terminal actual.

- **Opciones Comunes**:

  - **`-e`**: Muestra todos los procesos en el sistema.
  - **`-f`**: Genera una salida detallada (formato extendido).
  - **`-u [usuario]`**: Muestra los procesos de un usuario específico.
  - **`aux`**: Muestra todos los procesos del sistema junto con detalles de su uso de CPU y memoria.

- **Ejemplo**:
  ```bash
  ps aux
  ```
  Este comando lista todos los procesos en el sistema, mostrando columnas con el nombre del usuario, el PID, el porcentaje de uso de CPU y memoria, el tiempo de ejecución, el estado y el comando que inició cada proceso.

- **Salida Típica**:
  ```
  USER       PID %CPU %MEM    VSZ   RSS TTY      STAT START   TIME COMMAND
  root         1  0.0  0.1  16648  1356 ?        Ss   08:24   0:01 /sbin/init
  juan      1234  0.2  1.0  12000  8000 pts/0    R+   12:34   0:05 /bin/bash
  ```
  - **USER**: Usuario propietario del proceso.
  - **PID**: Identificador del proceso.
  - **%CPU**: Porcentaje de CPU utilizado.
  - **%MEM**: Porcentaje de memoria utilizada.
  - **VSZ**: Tamaño virtual del proceso en memoria (en KB).
  - **RSS**: Tamaño de la memoria física (en KB).
  - **TTY**: Terminal asociada al proceso.
  - **STAT**: Estado del proceso (R = Running, S = Sleeping, Z = Zombie, T = Stopped).
  - **START**: Hora de inicio del proceso.
  - **TIME**: Tiempo total de CPU consumido.
  - **COMMAND**: Comando que inició el proceso.

- **Uso Avanzado**:
  - Filtrar por nombre de proceso:
    ```bash
    ps -C sshd
    ```
    Muestra solo los procesos con el nombre `sshd`.

  - Mostrar la jerarquía de procesos:
    ```bash
    ps -ejH
    ```
    Genera un árbol de procesos con sus relaciones jerárquicas.

#### **2. Comando `top`**

`top` es una herramienta de monitoreo en tiempo real que muestra una vista dinámica de los procesos en ejecución, actualizando su información a intervalos regulares. Proporciona una perspectiva completa del uso de recursos del sistema, incluyendo el consumo de CPU y memoria, la carga promedio y el tiempo de ejecución de los procesos. Su capacidad de interacción permite al administrador ordenar, filtrar y gestionar procesos directamente desde la interfaz.

- **Sintaxis Básica**:
  ```bash
  top
  ```

- **Interfaz y Elementos Clave**:
  Al ejecutar `top`, se despliega una interfaz dividida en dos secciones:

  1. **Resumen del Sistema (Header)**: La parte superior muestra información sobre el estado general del sistema.
     - **Load Average**: Carga promedio del sistema en los últimos 1, 5 y 15 minutos.
     - **Tareas (Tasks)**: Número de procesos en ejecución, durmientes, detenidos y zombies.
     - **CPU(s)**: Uso de la CPU, desglosado en tiempo de usuario, tiempo del sistema, tiempo de E/S, etc.
     - **Memoria**: Uso total de la memoria física y de intercambio (swap).

  2. **Lista de Procesos**: La parte inferior muestra información detallada de los procesos, como PID, uso de CPU y memoria, usuario propietario y comando de inicio.

- **Comandos Interactivos**:
  Mientras `top` está en ejecución, se pueden usar los siguientes comandos interactivos para ajustar la visualización:

  - **`P`**: Ordenar por uso de CPU.
  - **`M`**: Ordenar por uso de memoria.
  - **`k`**: Terminar un proceso especificando su PID.
  - **`r`**: Cambiar la prioridad de un proceso (requiere permisos de superusuario).

- **Uso Avanzado**:
  Es posible personalizar la interfaz de `top` con parámetros como:

  - Mostrar procesos de un usuario específico:
    ```bash
    top -u juan
    ```
    Muestra solo los procesos pertenecientes al usuario `juan`.

  - Ajustar el intervalo de actualización:
    ```bash
    top -d 5
    ```
    Cambia el intervalo de actualización a 5 segundos (por defecto es 3 segundos).

#### **3. Comando `htop`**

`htop` es una versión avanzada e interactiva de `top` que proporciona una interfaz gráfica más intuitiva y colorida. Permite una navegación más sencilla a través de los procesos y proporciona funciones adicionales para gestionar y visualizar el uso de recursos de manera más detallada.

- **Instalación**:
  En muchas distribuciones de Linux, `htop` no viene instalado por defecto y debe añadirse manualmente:
  ```bash
  sudo apt install htop
  ```

- **Sintaxis Básica**:
  ```bash
  htop
  ```

- **Interfaz de `htop`**:
  La interfaz de `htop` se divide en varias secciones que permiten un monitoreo granular del sistema:
  
  - **Barras de Uso de CPU y Memoria**: Muestra el uso de CPU por núcleo y el uso de memoria en tiempo real.
  - **Lista de Procesos**: Presenta los procesos en ejecución con colores que indican el estado del proceso y el tipo de carga (usuario, sistema, E/S, etc.).
  - **Panel de Información Detallada**: Permite seleccionar un proceso para ver información adicional como el árbol de procesos, archivos abiertos y entorno de ejecución.

- **Características Claves**:
  - **Búsqueda Interactiva**: Permite buscar procesos por nombre o comando (`/`).
  - **Cambio de Prioridad**: Facilita el ajuste de la prioridad (nice) y el envío de señales (`F9`) a los procesos.
  - **Árbol de Procesos**: Visualiza la relación jerárquica de los procesos (`F5`).

- **Uso Avanzado**:
  - Filtrar procesos por nombre:
    ```bash
    htop -p $(pgrep apache2)
    ```
    Muestra solo los procesos del servidor `apache2`.

  - Ejecutar `htop` con permisos de superusuario:
    ```bash
    sudo htop
    ```
    Permite gestionar todos los procesos del sistema, no solo los del usuario actual.

### **2.7.2. Consideraciones de Monitoreo**

1. **Uso de Recursos**:
   - El monitoreo en tiempo real, como `top` y `htop`, consume recursos adicionales del sistema. En sistemas con alta carga, es preferible utilizar `ps` para obtener una instantánea de los procesos sin añadir carga extra.

2. **Automatización del Monitoreo**:
   - Las herramientas de monitoreo pueden ser combinadas con scripts para generar reportes periódicos o alertas en función del estado de los procesos.

3. **Monitoreo Remoto**:
   - `top` y `htop` pueden ser utilizados en servidores remotos a través de SSH, permitiendo la administración y monitoreo desde cualquier lugar. Para iniciar un monitoreo persistente en segundo plano, se puede utilizar `screen` o `tmux`.

---

## **2.8. Control de Procesos**

El control de procesos en sistemas Unix/Linux es una tarea crítica que permite a los administradores gestionar el ciclo de vida de los procesos, ajustar sus prioridades y modificar su comportamiento. La gestión efectiva de los procesos garantiza un uso eficiente de los recursos del sistema y ayuda a evitar bloqueos o cuellos de botella. Los administradores de sistemas deben tener un conocimiento profundo de cómo iniciar, detener, mover y ajustar la prioridad de los procesos para optimizar el rendimiento del entorno y asegurar la estabilidad de los servicios.

### **2.8.1. Señales de Control de Procesos con `kill`**

El comando `kill` se utiliza para enviar **señales** a los procesos con el fin de alterar su comportamiento o terminar su ejecución. A pesar de su nombre, `kill` no siempre se usa para terminar procesos; su función principal es enviar señales que el proceso puede interpretar para ejecutar acciones específicas, como reanudar, detener temporalmente o finalizar su ejecución.

#### **Sintaxis de `kill`**
```bash
kill [opciones] [PID]
```

- **`PID`**: Es el **Process ID** del proceso al que se le envía la señal. Este ID es único para cada proceso en ejecución en el sistema.
- **`opciones`**: Se especifican con `-señal` o con `-número`. Por ejemplo, `-9` (para `SIGKILL`) o `-15` (para `SIGTERM`).

#### **Señales Comunes de `kill`**

1. **`SIGTERM` (15)**:
   - Solicita de manera educada que el proceso se termine. Permite al proceso limpiar recursos y cerrarse correctamente.
   - Ejemplo:
     ```bash
     kill -15 1234
     ```
     Envía la señal `SIGTERM` al proceso con `PID` 1234.

2. **`SIGKILL` (9)**:
   - Fuerza la terminación inmediata del proceso sin darle oportunidad de limpiar recursos o guardar su estado. Es la última opción cuando un proceso no responde.
   - Ejemplo:
     ```bash
     kill -9 1234
     ```
     Termina inmediatamente el proceso con `PID` 1234. Se utiliza con precaución, ya que puede dejar recursos en un estado inconsistente.

3. **`SIGHUP` (1)**:
   - Indica que el proceso debe recargar su configuración. Se utiliza comúnmente para reiniciar servicios sin detenerlos.
   - Ejemplo:
     ```bash
     kill -1 5678
     ```
     Solicita al proceso con `PID` 5678 que recargue su configuración.

4. **`SIGSTOP` y `SIGCONT`**:
   - **`SIGSTOP`**: Detiene (pausa) el proceso sin terminarlo.
     ```bash
     kill -STOP 1234
     ```
     Pausa el proceso con `PID` 1234.
   - **`SIGCONT`**: Reanuda un proceso detenido.
     ```bash
     kill -CONT 1234
     ```
     Reanuda el proceso previamente detenido.

#### **Uso Avanzado de `kill` con `pkill` y `killall`**

- **`pkill`**: Permite enviar señales a procesos basados en su nombre en lugar de su `PID`. Es útil cuando se desean controlar múltiples procesos a la vez.
  ```bash
  pkill -f nginx
  ```
  Termina todos los procesos que contienen la palabra `nginx` en su línea de comando.

- **`killall`**: Envía señales a todos los procesos con un nombre específico.
  ```bash
  killall httpd
  ```
  Termina todos los procesos `httpd` (comúnmente utilizados en servidores web Apache).

### **2.8.2. Control de Trabajos con `jobs`, `fg` y `bg`**

Los comandos `jobs`, `fg` y `bg` permiten gestionar los **trabajos** que se ejecutan en primer plano y segundo plano en la terminal. Un **trabajo** se refiere a un proceso iniciado desde la terminal que se puede controlar directamente (como mover entre primer y segundo plano).

#### **1. Comando `jobs`**

El comando `jobs` muestra una lista de los trabajos actuales en la sesión de terminal, indicando si están en primer plano, en segundo plano o detenidos.

- **Sintaxis**:
  ```bash
  jobs [opciones]
  ```
  Si se ejecuta sin opciones, `jobs` muestra todos los trabajos de la terminal actual.

- **Opciones Comunes**:
  - **`-l`**: Muestra el `PID` de cada trabajo.
  - **`-p`**: Muestra solo los `PID` de los trabajos en segundo plano.

- **Ejemplo**:
  ```bash
  jobs -l
  ```
  Muestra una lista de todos los trabajos con sus respectivos `PID`.

- **Salida de `jobs`**:
  ```
  [1]-  1234 Running                 script.sh &
  [2]+  5678 Stopped (user)           python script.py
  ```
  - `[1]-` y `[2]+`: Indican el número del trabajo y su estado (`Running` o `Stopped`).
  - `&`: Indica que el trabajo se ejecuta en segundo plano.

#### **2. Comando `bg`**

El comando `bg` se utiliza para reanudar un trabajo detenido y ejecutarlo en segundo plano. Los trabajos detenidos (usualmente con `Ctrl + Z`) pueden ser reanudados sin bloquear la terminal.

- **Sintaxis**:
  ```bash
  bg [número_de_trabajo]
  ```
  Si se omite el número, `bg` reanuda el último trabajo detenido.

- **Ejemplo**:
  ```bash
  bg %2
  ```
  Reanuda el trabajo número `2` y lo coloca en segundo plano (`%` se utiliza para referirse a los trabajos).

#### **3. Comando `fg`**

El comando `fg` trae un trabajo de segundo plano o detenido a primer plano. Esto permite interactuar con el proceso directamente en la terminal.

- **Sintaxis**:
  ```bash
  fg [número_de_trabajo]
  ```
  Si se omite el número, `fg` trae al primer plano el último trabajo.

- **Ejemplo**:
  ```bash
  fg %1
  ```
  Trae el trabajo `1` a primer plano.

### **2.8.3. Ajuste de la Prioridad de Procesos con `nice` y `renice`**

En Unix/Linux, cada proceso tiene un valor de **prioridad** que determina cuánto tiempo de CPU se le asigna en relación con otros procesos. El valor de prioridad se denomina **niceness** y varía de -20 (máxima prioridad) a 19 (mínima prioridad). Los comandos `nice` y `renice` permiten ajustar este valor para influir en la ejecución de los procesos.

#### **1. Comando `nice`**

El comando `nice` permite iniciar un nuevo proceso con un valor de prioridad específico.

- **Sintaxis**:
  ```bash
  nice [opciones] [comando]
  ```
  Si se ejecuta sin opciones, `nice` inicia el comando con una prioridad de 10.

- **Opciones Comunes**:
  - `-n [valor]`: Especifica el valor de `niceness` (entre -20 y 19).

- **Ejemplo**:
  ```bash
  nice -n 15 tar -czf archivo.tar.gz /home
  ```
  Inicia el comando `tar` con una baja prioridad (`15`), permitiendo que otros procesos con mayor prioridad tengan preferencia en el uso de la CPU.

#### **2. Comando `renice`**

El comando `renice` se utiliza para cambiar la prioridad de un proceso en ejecución. A diferencia de `nice`, `renice` se aplica a procesos existentes especificando su `PID`.

- **Sintaxis**:
  ```bash
  renice [valor] [PID]
  ```

- **Ejemplo**:
  ```bash
  renice -5 1234
  ```
  Cambia la prioridad del proceso con `PID` 1234 a `-5`, lo que incrementa su prioridad en el sistema.

#### **Consideraciones de `nice` y `renice`**

- Los valores negativos de `niceness` (alta prioridad) solo pueden ser establecidos por el superusuario (`root`).
- Cambiar la prioridad de procesos de usuario sin permisos de superusuario solo permite aumentar el valor (disminuir la prioridad).

### **2.8.4. Ejecución de Procesos en Segundo Plano con `&`**

El símbolo `&` al final de un comando permite iniciar un proceso directamente en segundo plano, sin bloquear la terminal.

- **Ejemplo**:
  ```bash
  sleep 60 &
  ```
  Inicia un comando `sleep` que se ejecutará durante 60 segundos en segundo plano. El `PID` del proceso y el número del trabajo se muestran al usuario.

---

## **2.9. Programación de Tareas**

La programación de tareas en sistemas Unix/Linux permite automatizar la ejecución de comandos y scripts en momentos específicos o a intervalos regulares, lo que es fundamental para la administración y mantenimiento del sistema. Automatizar tareas reduce la intervención manual, minimiza errores y asegura la ejecución puntual de tareas repetitivas, como copias de seguridad, actualizaciones de sistemas, o la eliminación de archivos temporales. En Unix/Linux, la programación de tareas se gestiona principalmente a través de dos herramientas: `cron` y `at`. A continuación se presenta un análisis detallado de ambas herramientas y cómo usarlas de manera eficiente.

### **2.9.1. Programación de Tareas Periódicas con `cron`**

El sistema `cron` es el servicio predeterminado en Unix/Linux para la ejecución de tareas recurrentes y periódicas. Permite a los administradores definir comandos o scripts que se ejecutan automáticamente a intervalos específicos: cada minuto, hora, día, semana o mes, e incluso combinaciones complejas de estos intervalos. Las tareas de `cron` se configuran en un archivo especial llamado **crontab**.

#### **1. Estructura y Sintaxis del Archivo `crontab`**

El archivo `crontab` es un archivo de texto que define las tareas programadas para cada usuario. Cada línea en el `crontab` representa una tarea y sigue un formato específico que consta de seis campos:

```
[minuto] [hora] [día_del_mes] [mes] [día_de_la_semana] [comando]
```

- **minuto**: Rango de `0-59`.
- **hora**: Rango de `0-23`.
- **día_del_mes**: Rango de `1-31`.
- **mes**: Rango de `1-12` o nombres abreviados (jan, feb, mar, etc.).
- **día_de_la_semana**: Rango de `0-7` (0 y 7 representan el domingo) o nombres abreviados (sun, mon, etc.).
- **comando**: El comando o script que se desea ejecutar.

Cada campo puede ser un valor específico, un rango (`1-5`), una lista de valores separados por comas (`1,15,30`), o un carácter comodín (`*`) para indicar "todos los valores posibles".

#### **2. Sintaxis para Editar el `crontab` de un Usuario**

El comando `crontab` se utiliza para gestionar el archivo de tareas cron de cada usuario. Cuando se edita el `crontab`, se guarda en el directorio `/var/spool/cron/crontabs` y cada usuario tiene su propio archivo independiente.

- **Editar el `crontab` del Usuario Actual**:
  ```bash
  crontab -e
  ```
  Al ejecutar `crontab -e`, se abre el editor de texto predeterminado para configurar las tareas cron del usuario actual.

- **Listar las Tareas `cron` Existentes**:
  ```bash
  crontab -l
  ```
  Muestra las tareas cron definidas para el usuario actual.

- **Eliminar el `crontab` de un Usuario**:
  ```bash
  crontab -r
  ```
  Elimina todas las tareas cron para el usuario actual.

#### **3. Ejemplos de Configuración en `crontab`**

- **Ejecutar un Script a las 2:30 a.m. Todos los Lunes**:
  ```
  30 2 * * 1 /ruta/comando.sh
  ```
  Este comando ejecuta el script `comando.sh` cada lunes a las 2:30 a.m.

- **Ejecutar un Comando Todos los Días a Medianoche**:
  ```
  0 0 * * * /usr/bin/actualizar.sh
  ```
  El script `actualizar.sh` se ejecutará todos los días a las 00:00 horas.

- **Limpiar Archivos Temporales Cada 15 Minutos**:
  ```
  */15 * * * * rm -rf /tmp/*.tmp
  ```
  Elimina todos los archivos `.tmp` en el directorio `/tmp` cada 15 minutos.

- **Ejecutar un Comando el Primer Día de Cada Mes**:
  ```
  0 0 1 * * /ruta/comando_mensual.sh
  ```
  Este comando ejecuta el script `comando_mensual.sh` a las 00:00 horas el primer día de cada mes.

#### **4. Archivos de Configuración Global de `cron`**

Además de los `crontabs` de usuario, `cron` tiene configuraciones globales en los siguientes archivos:

- **`/etc/crontab`**: Archivo del sistema que define tareas globales para todos los usuarios. Este archivo contiene un campo adicional para especificar el usuario que ejecutará cada tarea:
  ```
  [minuto] [hora] [día_mes] [mes] [día_semana] [usuario] [comando]
  ```

- **Directorios `cron`**: En `/etc/cron.d/` se pueden definir archivos con tareas programadas, y los directorios `/etc/cron.hourly/`, `/etc/cron.daily/`, `/etc/cron.weekly/` y `/etc/cron.monthly/` permiten colocar scripts que se ejecutan automáticamente según su frecuencia.

### **2.9.2. Programación de Tareas Puntuales con `at`**

El comando `at` permite programar la ejecución de comandos o scripts para un momento específico en el futuro, pero solo una vez. A diferencia de `cron`, `at` es ideal para tareas únicas que no necesitan repetirse. Una vez que la tarea se ejecuta, se elimina de la lista de tareas pendientes.

#### **1. Sintaxis Básica de `at`**

```bash
at [hora] [opciones]
```

- **hora**: Define el momento exacto en que se ejecutará la tarea. Se puede especificar en diversos formatos:
  - `10:00`: A las 10:00 a.m.
  - `now + 2 hours`: Dentro de 2 horas a partir del momento actual.
  - `midnight`: Medianoche.
  - `noon`: Mediodía.

- **opciones**:
  - `-f [archivo]`: Especifica un archivo que contiene los comandos a ejecutar.
  - `-m`: Envía un correo al usuario cuando la tarea se completa.

#### **2. Ejemplos de Uso de `at`**

- **Ejecutar un Comando a las 10:00 a.m.**:
  ```bash
  echo "tar -czf backup.tar.gz /home/usuario" | at 10:00
  ```
  Este comando crea un archivo comprimido `backup.tar.gz` del directorio `/home/usuario` a las 10:00 a.m.

- **Ejecutar un Script a Medianoche**:
  ```bash
  at midnight < /ruta/script.sh
  ```
  Programa la ejecución de `script.sh` a la medianoche del día actual.

- **Ejecutar un Comando en 2 Días**:
  ```bash
  at now + 2 days
  ```
  Inicia una sesión interactiva de `at` donde se puede ingresar una serie de comandos que se ejecutarán en dos días.

#### **3. Gestión de Tareas `at`**

Las tareas programadas con `at` se pueden gestionar y listar con los siguientes comandos:

- **`atq`**: Lista las tareas pendientes de ejecución para el usuario actual.
  ```bash
  atq
  ```
  Muestra la lista de tareas con su número de identificación y hora de ejecución.

- **`atrm [número]`**: Elimina una tarea programada.
  ```bash
  atrm 2
  ```
  Elimina la tarea número `2` de la lista.

### **2.9.3. Consideraciones de Seguridad en `cron` y `at`**

Para evitar que usuarios no autorizados programen tareas, el acceso a `cron` y `at` puede ser restringido mediante los archivos `/etc/cron.allow` y `/etc/cron.deny` para `cron`, y `/etc/at.allow` y `/etc/at.deny` para `at`.

- **`/etc/cron.allow` y `/etc/at.allow`**:
  - Contienen una lista de usuarios permitidos para usar `cron` o `at`.
  - Si el archivo existe, solo los usuarios especificados pueden programar tareas.

- **`/etc/cron.deny` y `/etc/at.deny`**:
  - Contienen una lista de usuarios denegados para usar `cron` o `at`.
  - Si el archivo existe y `cron.allow` no está presente, se deniega el acceso a los usuarios en la lista.

### **2.9.4. Beneficios y Casos de Uso de la Programación de Tareas**

1. **Mantenimiento del Sistema**: `cron` se utiliza para realizar copias de seguridad diarias, actualizar listas de paquetes, limpiar archivos temporales y monitorear la actividad del sistema.
2. **Automatización de Servicios**: `cron` y `at` permiten automatizar tareas como el reinicio de servicios, la generación de reportes y la rotación de logs.
3. **Optimización de Recursos**: La programación de tareas fuera de las horas pico evita la sobrecarga del sistema durante el horario de trabajo.
