## Ejercicios resueltos

Comenzamos por recordar que en el sistema de archivos de Linux todos los archivos proceden de la carpeta raíz, la madre de todas, que se nombra con el síbolo '/'. Normalmente vuestro usuario se encuentra dentro de /home, que sería la carpeta home dentro de '/'.

Además de /home, tenemos otra carpeta llamada /etc donde se encuentran archivos de configuración de Linux.

Teniendo en cuenta esta estructura de archivos.

Los dos primeros ejercicios podéis hacerlos directamente en la terminal o dentro de un script. Os recomiendo practicar la creación de scxripts pero muchos se quedarán en una línea y basta con identificar la orden correcta.

```
/
└── home/
    └──tu_usuario/
└── etc/
    └── mysql/
    └── fonts/
    └── systemd/
        └── system/
    
```


## Ejercicio 1
- Crea un script (en la carpeta que quieras) que lea el contenido de la carpeta mysql
- modificalo para que no devuelva solamente los nombres de archivos y carpetas en mysql sino también sus permisos actuales.
- modificalo para que lea el contenido de fonts de manera recursiva. Es decir, que abra todo lo que haya en las subcarpetas de fonts.



**Respuesta:**
```bash
//1.1
ls /etc/mysql

//1.2
ls -l /etc/mysql

ls -r /etc/systemd/fonts
```




## Ejercicio 2
- Crea un script (en la carpeta que quieras) que lea el contenido del archivo fonts.conf, que se encuentra en fonts.
- Cambia el script de carpeta y piensa si tendrías que modificar el código para que funcione.
- Modifica el script para que en lugar de leer el contenido del archivo fonts.conf, me devuelva el número de caracteres, palabras y lineas.


**Respuesta:**
```bash
#!/bin/bash
# 1.1
cat /etc/fonts/fonts.conf

# 1.2
# En este caso no habría que modificarlo ya que es una ruta absoluta, no relativa

# 1.3 esta opción redirige la salida de cat, que lee archivos, como
# entrada del comando wc, que cuenta líneas, palabras y caracteres 
cat /etc/fonts/fonts.conf | wc
# otra opción es usar solamente el comando wc, que puede leer archivos directamente
wc /etc/fonts/fonts.conf
```


## Ejercicio 3
- Escribe un script en bash (en la carpeta que quieras) que se ejecute con 1 parámetro. El primer parámetro será la ruta de una carpeta.
- El programa debe devolver por la terminal el número de archivos que contiene la carpeta pasada como primer parámetro. 


**Respuesta:**
Para que nos devuelvan el número de archivos tenemos varias opciones.
Si usamos ls -l nos aseguramos que haya una línea por archivo pero se añade una primera línea que hay que restar. 

Otra opción es asumir que cada palabra es un archivo ya que en Linux no es recomendable usar espacios para crear archivos, luego nos ahorraríamos la resta. Os recomiendo que al usar redireccion de salida, el símbolo |, vayáis ejecutando comando a comando para ver que devuelve cada uno. 

Por ejemplo antes de ejecutar `ls -l | wc -l`, ejecutar `ls -l` solamente y asegurarnos de qué devuelve como entrada para `wc`
```bash
# Opción 1
resultado=(ls -l $1 | wc -l)
echo $(($resultado - 1))

# como se ve en esta opción hay que tirar de crear variables, en este caso resultado, cosa que nos ahorramos con la opción 2.

# Opción 2
ls $1 | wc -w
```

## Ejercicio 4.

Escribe un programa en bash que se ejecute con 2 parámetros. El primero sera una carpeta y el segundo una cadena de letras, la que sea, una palabra por ejemplo.

El programa debe buscar todos los archivos que contengan esa cadena de caracteres y devolver **el número** de archivos que tengan la cadena en su nombre de archivo, no en su interior.

Por ejemplo, si ejecutamos dentro de `carpeta` esta orden:

```
└── carpeta/
    └── carpeta1/
        └── prueba1.sh
        └── prueba.txt
        └── log.txt
        └── prueba2.sh
        └── prueba3.md
```


``` bash
./ejercicio4.sh carpeta1 prueba
```
Debería devolver el número 4.

**Respuesta:**
```bash
#!/bin/bash

ls $1 | grep $2 | wc -l
```

###  Ej 1 extra:

dentro de una carpeta, crea dos carpetas documentacion y documentacion2
dos archivos, archivo1.txt y archivo2.txt
dos programas, programa1.sh y programa2.sh
crear 3 archivos que se llamen carpetas, programas y archivos

```bash
mkdir documentacion && mkdir documentacion2

touch archivo1.txt archivo2.txt programa1.sh programa2.sh
```


crea un script dentro de docs que haga lo siguiente:
quiero que almaceneis en "carpetas" los nombres de las carpetas que estén en vuestra carpeta, en programas los nombres de los los programas (.sh)  y en archivos los nombres de los archivos(.txt).

```bash
find -type d > carpetas # UN SOLO ">" SUSTITUYE EL DOCUMENTO, DOS ">>" AÑADE AL DOCUMENTO
find -name '*.sh' > programas
find -name '*.txt' > archivos
``` 

### Ej 2 extra:

rellena archivo1.txt y archivo2.txt con algo de texto, el que tu quieras.

```bash
echo "xxxxxx" > archivo1.txt
echo "yyyyyy" > archivo2.txt

```

escribe un script que almacene dentro de archivo2.txt el contenido de archivo2.txt y detras el contenido de archivo1.txt

```bash
chmod +r archivo1.txt
cat archivo1.txt >> archivo2.txt
```

sabrías hacerlo a la inversa? que se almacene primero archivo1.txt y después archivo2.txt en archivo2.

```bash
chmod +r archivo2.txt
cat archivo2.txt >> archivo1.txt >> archivo2.txt # terminar
```

### Ej3 extra:

Repite el ejercicio 1 pero como lo pensamos originalmente. En este caso, carpetas, archivos y programas serán carpetas y hay que almacenar en cada uno lo que corresponde. En carpetas, mover todas las carpetas que haya en la carpeta donde estas haciendo el ejercicio, en archivos los archivos y en programas los programas.

NOTA: carpetas no puede estar dentro de la carpeta donde estás trabajando. Qué pasa si intentamos hacerlo con carpetas dentro de nuestra carpeta? Por qué falla?

```bash

```