# Prueba Técnica 1: Comandos Básicos en Linux

## [Enlace GitHub](https://classroom.github.com/a/eCikYF64)

### Ejercicio 1

1. Dentro de tu home, crea un directorio principal llamado `proyecto`.
   
2. Dentro de `proyecto`, crea la siguiente estructura de directorios y archivos:

```
proyecto/
├── docs/
│   ├── manual.txt
│   ├── guia.txt
│   └── referencias.txt
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
mkdir -p proyecto/{docs/,src/modulos,config/,logs/backup,test/resultados} && touch proyecto/{docs/{manual.txt,guia.txt,referencias.txt},src/{script1.sh,script2.sh,modulos/modulo1.py},config/{app.cfg,db.cfg},logs/{access.log,error.log,backup/backup1.log},test/{test1.txt,test2.txt,resultados/resultados1.txt}}
```

### Ejercicio 2

1. Copia los archivos `manual.txt` y `guia.txt` desde el subdirectorio `docs` a un nuevo subdirectorio llamado `backup_docs` dentro de `proyecto`.

2. Copia de forma recursiva el directorio `config` completo junto con su contenido a un subdirectorio llamado `config_backup` dentro de `proyecto`.

*Responde con los comandos utilizados y verifica la estructura resultante con `ls` o `tree`.*

```bash
mkdir proyecto/backup_docs && cp proyecto/docs/{manual.txt,guia.txt} proyecto/backup_docs
```

---

### Ejercicio 3

1. Mueve el archivo `script1.sh` desde el subdirectorio `src` a `test/resultados`.

2. Renombra `script2.sh` a `script_final.sh` dentro del subdirectorio `src`.

3. Mueve el directorio `backup` completo desde `logs` a `test`.

*Responde con los comandos y verifica la estructura final con `ls` o `tree`.*

```bash
mv proyecto/src/script1.sh proyecto/test/resultados && mv proyecto/src/script2.sh proyecto/src/script_final.sh && mv proyecto/logs/backup proyecto/test && tree proyecto
```

---

### Ejercicio 4

1. Abre el archivo `manual.txt` dentro de `docs` y agrega las siguientes líneas de texto:
   ```
   Capítulo 1: Introducción
   Capítulo 2: Instalación
   Capítulo 3: Uso Básico
   ```
2. Guarda y cierra el archivo.
3. Visualiza el contenido del archivo editado.
4. Muestra las primeras 10 líneas del archivo.
5. Muestra las primeras dos líneas del archivo.

*Responde con los comandos utilizados*

```bash
# -e indica que interprete caracteres especiales "\n" para linea nueva
echo -e "Capítulo 1: Introducción\nCapítulo 2: Instalación\nCapítulo 3: Uso Básico" > docs/manual.log 
echo -e \n Archivo entero:
cat docs/manual.log
echo -e \n Primeras 10 lineas:
head docs/manual.log
echo -e \n Primeras 2 lineas:
head -n 2 docs/manual.log
```

---

### Ejercicio 5

1. Busca todos los archivos con extensión `.txt` dentro del directorio `proyecto` y sus subdirectorios.
2. Encuentra todos los **directorios** cuyo nombre contenga la palabra `backup` dentro de `proyecto`.
3. Busca todos los archivos que hayan sido modificados en las últimas 24 horas.

*Responde con los comandos utilizados*

```bash
find proyecto/ -name "*.txt"
find proyecto/ -name "*backup*"
find proyecto/ -mtime -24
```

---

### Ejercicio 6

1. Busca en todos los archivos `.log` dentro de `proyecto` las líneas que contengan la palabra "ERROR" (sin importar mayúsculas o minúsculas).
2. Encuentra las líneas que contengan números (dígitos) dentro de los archivos `.log` dentro de la estructura `proyecto`.

*Responde con los comandos utilizados*

```bash
grep --include="*.log" -il "ERROR" -r
```

---

### Ejercicio 7

1. Elimina los archivos `app.cfg` y `db.cfg` del subdirectorio `config`.
2. Borra de forma recursiva el subdirectorio `backup_docs` junto con su contenido.
3. Elimina el subdirectorio `modulos` (que contiene el archivo `modulo1.py`) dentro de `src`.

*Responde con los comandos utilizados y verifica la estructura final con `ls` o `tree`.*

```bash
rm proyecto/config/{app.cfg,db.cfg}
rm -r proyecto/backup_docs/
rm -r proyecto/src/modulos/
```