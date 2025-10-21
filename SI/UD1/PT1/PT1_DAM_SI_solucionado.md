# Prueba Técnica 1: Comandos Básicos en Linux

## [Enlace GitHub](https://classroom.github.com/a/eCikYF64)

### Ejercicio 1

1. Dentro de tu home, crea un directorio principal llamado `PT1`.
   
2. Dentro de `PT1`, crea la siguiente estructura de directorios y archivos:

```
PT1/
├── docs/
│   ├── manual.txt
│   ├── guia.txt
│   └── referencias.txt
│   └── apuntes.txt
├── src/
│   ├── script1.sh
│   ├── script2.sh
│   └── modulos/
│       └── modulo1.py
├── config/
│   ├── app.cfg
│   └── db.cfg
├── logs/
│   ├── access.log
│   ├── error.log
│   └── backup/
│       └── backup1.log
└── test/
    ├── test1.txt
    ├── test2.txt
    └── resultados/
        └── resultados1.txt
```

*Responde con los comandos utilizados para crear la estructura.*

```bash
#1.1
mkdir -p PT1/{docs,src/modulos,config,logs/backup,test/resultados}

#1.2
touch PT1/{docs/{manual,guia,referencias,apuntes}.txt,src/script{1,2}.sh,src/modulos/modulo1.py,config/{app,db}.cfg,logs/{access,error,backup/backup1}.log,test/{test1,test2,resultados/resultados1}.txt}

```

### Ejercicio 2

1. Mueve los archivos `referencias.txt` y `guia.txt` desde el subdirectorio `docs` a un nuevo subdirectorio llamado `backup_docs` dentro de `PT1`.

2. Copia de forma recursiva el directorio `logs` completo a un subdirectorio llamado `logs_backup` dentro de `PT1`. Debería quedar logs dentro de logs_backup


```bash
cd PT1

#2.2
mkdir backup_docs
mv docs/{referencias.txt,guia.txt} backup_docs

#2.3
mkdir logs_backup
cp -r logs logs_backup
```

---

### Ejercicio 3

1. Mueve el archivo `script1.sh` desde el subdirectorio `src` a `resultados`.

2. Renombra `script2.sh` a `script_final.sh` dentro del subdirectorio `src`.

3. Mueve el directorio `backup` completo desde `logs` a `test`.

4. Copia el contenido de la carpeta `config` dentro de una carpeta nueva llamada `config_backup` dentro de `docs`

```bash
#3.1
mv src/script1.sh test/resultados
#3.2
mv src/script2.sh src/script_final.sh
#3.3
mv logs/backup test
#3.4
mkdir config_backup
cp -r config/* docs/config backup

# o

cp -r config docs/config_backup
```

---

### Ejercicio 4

1. Abre el archivo `manual.txt` dentro de `docs` y agrega las siguientes líneas de texto:
   ```
   Este es el contenido del archivo manual
   ```
2. Abre el archivo `referencias.txt` dentro de `docs` y agrega las siguientes líneas de texto:
   ```
   Este es el contenido del archivo de referencias
   ```
3. Escribe las órdenes pertinentes para que el contenido de `referencias.txt` sea el contenido de `referencias.txt` y, después, dos veces el contenido de `manual.txt`.

Debería quedar así
```
Este es el contenido del archivo de referencias
Este es el contenido del archivo manual
Este es el contenido del archivo manual
```
```bash
#4.1
echo " Este es el contenido del archivo manual" > docs/manual.txt
#4.2
echo " Este es el contenido del archivo de referencias" > docs/referencias.txt
#4.3
cat docs/manual.txt docs/manual.txt >> docs/referencias.txt

```
---

### Ejercicio 5

1. Busca todos los archivos con extensión `.sh` dentro del directorio `PT1` y sus subdirectorios.
2. Encuentra todos los **directorios** y subdirectorios cuyo nombre contenga la palabra `log` dentro de `PT1`.
3. Busca en todo el sistema todos los archivos que pesen menos de 10 kilobytes y que hayan sido modificados en las últimas 24 horas.

*Responde con los comandos utilizados*

```bash
# 5.1
find . -type f -name "*.sh"
# 5.2
find . -type d -name "*log*"
# 5.3
find / -size -10k -mtime -1
  
```

---

### Ejercicio 6

1. Copia todos los archivos dentro de `docs` que comiencen por una vocal minúscula dentro de la carpeta `modulos` 
2. Encuentra los archivos dentro de `PT1` que contengan números (dígitos) dentro de su nombre de archivo y muéstralos por pantalla
3. Modifica la orden para que esta última búsqueda, en lugar de mostrarse por pantalla, se almacene en un archivo llamado digitos.txt, dentro de docs.

*Responde con los comandos utilizados*

```bash
#6.1
cp docs/{a,e,i,o,u}* modulos
#6.2
find . -name "*[0-9]*"
#6.3
find . -name "*[0-9]*" > docs/digitos.txt
```

---

### Ejercicio 7

1. Elimina los archivos `app.cfg` y `db.cfg` del subdirectorio `config`.
2. Borra de forma recursiva el subdirectorio `backup_docs` junto con su contenido.
3. Elimina el subdirectorio `modulos` dentro de `src`.


```bash
#7.1
rm config/{app,db}.cfg
#7.2
rm -r backup_docs
#7.3
rm -r src/modulos
```
### Ejercicio 8
1. Busca todos los archivos dentro de `PT1` que contengan dentro (en su contenido, no en el nombre de archivo) la palabra `archivo`
2. Deja en la carpeta `docs` solamente los archivos que comiencen por consonante.
3. Elimina todas las carpetas que existan en `src`

```bash
#8.1
grep -r archivo
#8.2
rm -r docs/{a,e,i,o,u,A,E,I,O,U}*
#8.3
rm -r src/*/
```
