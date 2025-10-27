# Ejercicios gestión usuarios UNIX/Linux

Necesitamos crear la siguiente estructura de carpetas en nuestro servidor para albergar nuestro primer proyecto: 

Dentro de la carpeta `/opt` tendremos que crear una estructura de carpetas con la siguiente estructura : 

```bash
/opt$: ls -tlr  
drwxrwxrwx 5 propietario direccion 4096 feb 18 12:05 proyTicketsAlhambra

/opt$: cd proyTicketsAlhambra/  

/opt/proyTicketsAlhambra$: ls -ltr  
drwx------ 2 propietario direccion  4096 feb 18 12:05 gestion_economica    
drwxrwxr-x 2 propietario desarrollo 4096 feb 18 12:29 software    
drwxrwxr-x 2 propietario analisis   4096 feb 18 12:34 analisis 
```


Para ello tendremos que crear los siguientes grupos y usuarios:   

**Grupos:** 
- direccion 
- desarrollo 
- analisis 

```bash
# SOLUCIÓN:
sudo groupadd  direccion
sudo groupadd  desarrollo
sudo groupadd  analisis
```

**Usuarios:**  

- **propietario**: Su grupo principal sera direccion y sus grupos secundarios desarrollo y analisis. Como contraseña tendrá *12345*, tendrá una carpeta personal en `/home/propietario` y su shell asociada sera *bash*.  
- **desarrollador1**: Su grupo principal será desarrollo. No pertenecerá a ningún grupo mas.Como contraseña tendrá *123*, tendrá una carpeta personal en `/home/desarrollador1` y su shell asociada sera *bash*.    
- **analista1**: Su grupo principal será analisis. No pertenecerá a ningún grupo más. Como contraseña tendrá *123*, tendrá una carpeta personal en `/home/analista1` y su shell asociada sera *bash*.    

 
``` bash
# SOLUCIÓN:
sudo useradd -g direccion -G desarrollo -G analisis -m -s /bin/bash propietario
sudo useradd -g desarrollo -m -s /bin/bash desarrollador1
sudo useradd -g analisis -m -s /bin/bash analista1

sudo sudo usermod -aG desarrollo propietario

sudo passwd propietario
12345
sudo passwd desarrollador1
123
sudo passwd analista1
123
```


**Realiza las siguientes operaciones:**
1. Entra con el usuario analista1 en la carpeta de software y crea un fichero tickets.java.  
2. Entra con el usuario desarrollador1 en la carpeta gestion_ecomica y haz un listado de los elementos.

* Cambiando los propietarios y los grupos de la estructura de carpetas :  

```bash
# Creando la estructuras de carpetas:
cd /opt
sudo mkdir proyTicketsAlhambra
cd proyTicketsAlhambra
sudo mkdir software 
sudo mkdir analisis
sudo mkdir gestion_economica
```

```bash
 ## CAMBIO DE PROPIETARIOS DE LOS DIRECTORIOS

 # Para la carpeta proyTicketsAlhambra:
 cd /opt
 sudo chown propietario:direccion proyTicketsAlhambra

 # Para las carpetas dentro de proyTicketsAlhambra: 
 cd proyTicketsAlhambra
 sudo chown -R propietario:desarrollo  software/
 sudo chown -R propietario:analisis analisis/
 sudo chown -R propietario:direccion  gestion_economica/
```

```bash
# Estableciendo los permisos:
cd proyTicketsAlhambra
sudo chmod 777 g=rwx
sudo chmod 775 analisis
sudo chmod 775 software

```