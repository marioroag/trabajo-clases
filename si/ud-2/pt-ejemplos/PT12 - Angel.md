# PT12 - Gestión de usuarios UNIX/Linux


***

## Hoteles Comiló

La cadena Hoteles Comiló ha solicitado tu ayuda para realizar una serie de tareas relacionadas con la gestión de usuarios y permisos en un entorno Linux.

### 1. Crea los siguientes grupos: 

- **chef**
- **pinche**

```bash
# Escribe aquí los comandos necesarios

```

### 2. Crea los siguientes usuarios:

- **pinchePrincipal**: Su grupo principal es *pinche*. Tendrá un directorio personal `/home/pinche`. La shell por defecto será *bash* y su contraseña *134679*.  
- **chefJefe**: Su grupo principal es *chef* y su grupo secundario es *pinche*. Tendrá un directorio personal `/home/chefJefe`. La shell por defecto sera *bash* y su contraseña *1470*.   
- **chef1**: Su grupo principal es *chef*. Tendrá un directorio personal `/home/chef1`. La shell por defecto sera *bash*  y su contraseña *qwerty*. 

```bash
# Escribe aquí los comandos necesarios

```

### 3. Dentro del directorio `/opt` crea la siguiente estructura de directorios:  

```bash
/opt$: ls -ltr  
drwxrwxrwx 5 chefJefe chef 4096 feb 21 12:40 HotelesComilo

/opt$: cd HotelesComilo
/opt/HotelesComilos$: ls -ltr  

drwxrwxr-- 2 chefJefe pinche      4096 feb 21 12:39 recetas
drwxrwxr-x 2 chefJefe chef 4096 feb 21 12:39 pinches
drwxr-x--- 2 chefJefe chef 4096 feb 21 12:40 gestion
```

```bash
# Escribe aquí los comandos necesarios para crear la estructura de directorios

```

### 4. Preguntas:

1. ¿Puede el usuario *chefJefe* escribir en el directorio *recetas*? ¿Por qué? 

```
Responde aquí a la pregunta 1
```

2. El *chef1* tiene que entrar en el directorio *recetas* para consultar las recetas disponibles. ¿Cómo modificarías el directorio *recetas* para que los *pinches* puedan seguir accediendo con todos los permisos? 

```
Responde aquí a la pregunta 2
```

3. ¿Puede el usuario *pinchePrincipal* subir su ficha personal (*ficha_personal.pdf*) al directorio *pinches*?

```
Responde aquí a la pregunta 3
```