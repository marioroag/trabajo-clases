# Tutorial: Configurar las rutas temporales de PHP en XAMPP

Entorno: Windows 11 · XAMPP · PHP 8.2.12

## 1\. Identificar el archivo php.ini

Abre el archivo de configuración de PHP:

text

```
D:\xampp\php\php.ini
```

Este es el archivo que utiliza Apache según la configuración de tu instalación.

## 2\. Configurar las directivas temporales

Abre `php.ini` con el Bloc de notas o Visual Studio Code.

Pulsa `Ctrl + F` para localizar cada una de las siguientes directivas.

### A. Directorio de sesiones

Busca:

ini

```ini
session.save_path
```

&nbsp;

Configura:

ini

```ini
session.save_path = "D:/xampp/tmp"
```

&nbsp;

Esta directiva indica dónde PHP almacena los archivos de sesión.

### B. Directorio temporal para subir archivos

Busca:

ini

```ini
upload_tmp_dir
```

&nbsp;

Configura:

ini

```ini
upload_tmp_dir = "D:/xampp/tmp"
```

&nbsp;

Esta directiva establece dónde se almacenan temporalmente los archivos que los usuarios suben mediante formularios.

### C. Directorio temporal del sistema

Busca:

ini

```ini
sys_temp_dir
```

&nbsp;

Configura:

ini

```ini
sys_temp_dir = "D:/xampp/tmp"
```

&nbsp;

Esta directiva establece el directorio temporal general utilizado por PHP.

## 3\. Configuración final de php.ini

Las tres directivas deben quedar configuradas de la siguiente manera:

ini

```ini
session.save_path = :/"Dxampp/tmp"

upload_tmp_dir = "D:/xampp/tmp"

sys_temp_dir = "D:/xampp/tmp"
```

&nbsp;

Importante: Si alguna directiva tiene un punto y coma (`;`) delante, elimínalo para activarla.

## 4\. Comprobar que existe el directorio temporal

Abre el Explorador de Windows y accede a:

text

```
D:\xampp\
```

Comprueba que existe la carpeta:

text

```
D:\xampp\tmp
```

Si no existe, créala manualmente.

También debes comprobar que el usuario con el que se ejecuta Apache tiene permisos de lectura y escritura sobre esta carpeta.

## 5\. Guardar los cambios y reiniciar Apache

Una vez modificadas las directivas:

1. Guarda el archivo `php.ini`.  
2. Abre el panel de control de XAMPP.  
3. Pulsa Stop en Apache.  
4. Espera a que Apache se detenga completamente.  
5. Pulsa Start para volver a iniciarlo.

Los cambios de configuración se aplicarán cuando Apache vuelva a cargar PHP.

## 6\. R