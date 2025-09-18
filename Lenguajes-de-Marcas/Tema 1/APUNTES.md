# UD: 1 - XML
Este tema introductorio a la asignatura de Lenguaje de Marcas en el que estudiaremos XML

### Características
- Aunque parecido al HTML no es lo mismo. HTML se usa para mostrar contenido en la web, mientras que XML se creó para almacenar y organizar datos de forma que las máquinas puedan entenderlos y usarlos fácilmente.
- XML es un lenguaje de nesting estilo cascada parecido a html
- Absolutamente todos los elementos necesitan un closing tag

### Sintaxis
- Todos los documentos XML deben empezar con esta línea de codigo:
```xml
<?xml version="1.0" encoding="UTF-8"?>
```
- La sintaxis es la siguiente:
```xml
<parent>
    <child>
    </child>
</parent>
```
- Para tener un elemento vacio se puede usar un solo tag de la siguiente forma:
```xml
<element/>
```