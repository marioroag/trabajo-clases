# 🧭 COMANDOS DE NAVEGACIÓN EN LINUX

### **pwd** – Mostrar el directorio actual  
📘 **Uso:** Muestra la ruta completa del directorio en el que estás.  
💻 **Ejemplo:**  
```bash
pwd
```
📤 **Salida:** `/home/usuario`

---

### **cd** – Cambiar de directorio  
📘 **Uso:** Permite moverte entre carpetas.  
💻 **Ejemplos:**  
```bash
cd /home/usuario/documentos     # Ir a un directorio
cd ..                           # Subir un nivel
cd ~                            # Ir al directorio personal
cd -                            # Volver al directorio anterior
```

---

### **ls** – Listar contenido de directorios  
📘 **Uso:** Muestra los archivos y carpetas del directorio actual.  
💻 **Ejemplos:**  
```bash
ls               # Lista simple
ls -l            # Lista detallada con permisos y fechas
ls -a            # Incluye archivos ocultos
ls -lh           # Tamaños legibles (KB, MB)
```

---

### **tree** – Mostrar estructura de directorios en forma de árbol  
📘 **Uso:** Visualiza jerárquicamente carpetas y subcarpetas.  
💻 **Ejemplos:**  
```bash
tree                  # Estructura del directorio actual
tree /etc             # Mostrar árbol de /etc
tree -h               # Muestra tamaños legibles
```

---

# 📂 MANIPULACIÓN DE ARCHIVOS Y DIRECTORIOS

### **cp** – Copiar archivos o directorios  
📘 **Uso:** Copia archivos o carpetas a otro lugar.  
💻 **Ejemplos:**  
```bash
cp archivo.txt /ruta/destino/         # Copiar un archivo
cp -r carpeta /ruta/destino/          # Copiar un directorio completo
```

---

### **mv** – Mover o renombrar archivos  
📘 **Uso:** Mueve archivos/directorios o cambia su nombre.  
💻 **Ejemplos:**  
```bash
mv archivo.txt /ruta/destino/         # Mover un archivo
mv archivo.txt nuevo_nombre.txt       # Renombrar
```

---

### **rm** – Eliminar archivos o directorios  
⚠️ **Cuidado:** No hay papelera, se borra definitivamente.  
📘 **Uso:** Borra archivos o carpetas.  
💻 **Ejemplos:**  
```bash
rm archivo.txt              # Eliminar un archivo
rm -r carpeta/              # Eliminar carpeta y su contenido
rm -f archivo.txt           # Forzar eliminación sin preguntar
```

---

### **mkdir** – Crear directorios  
📘 **Uso:** Crea carpetas nuevas.  
💻 **Ejemplos:**  
```bash
mkdir nueva_carpeta                     # Crear una carpeta
mkdir -p /ruta/completa/subdirectorio   # Crear varias carpetas a la vez
```

---

### **rmdir** – Eliminar directorios vacíos  
📘 **Uso:** Borra carpetas que no contienen archivos.  
💻 **Ejemplo:**  
```bash
rmdir carpeta_vacia
```

---

### **touch** – Crear o actualizar archivos  
📘 **Uso:** Crea archivos vacíos o actualiza la fecha de modificación.  
💻 **Ejemplos:**  
```bash
touch nuevo.txt              # Crear archivo vacío
touch archivo_existente.txt  # Actualizar fecha de modificación
```

---

# 📖 VISUALIZACIÓN Y EDICIÓN DE ARCHIVOS

### **cat** – Mostrar contenido de archivos  
📘 **Uso:** Muestra o concatena el contenido de archivos de texto.  
💻 **Ejemplos:**  
```bash
cat archivo.txt                              # Ver contenido
cat archivo1.txt archivo2.txt                # Concatenar
cat archivo1.txt archivo2.txt > nuevo.txt    # Guardar salida en nuevo archivo
```

---

### **head** – Mostrar las primeras líneas de un archivo  
📘 **Uso:** Muestra las primeras 10 líneas (por defecto) o más si se indica.  
💻 **Ejemplos:**  
```bash
head archivo.txt        # Primeras 10 líneas
head -n 20 archivo.txt  # Primeras 20 líneas
```

---

### **tail** – Mostrar las últimas líneas de un archivo  
📘 **Uso:** Muestra las últimas líneas o monitoriza archivos en tiempo real.  
💻 **Ejemplos:**  
```bash
tail archivo.txt          # Últimas 10 líneas
tail -n 50 archivo.txt    # Últimas 50 líneas
tail -f /var/log/syslog   # Ver un log en tiempo real
```

---

### **nano** – Editor de texto en terminal  
📘 **Uso:** Permite editar archivos de texto desde la consola.  
💻 **Ejemplo:**  
```bash
nano archivo.txt
```
📋 **Atajos útiles dentro de nano:**  
- `Ctrl + O`: Guardar  
- `Ctrl + X`: Salir  
- `Ctrl + K`: Cortar línea  
- `Ctrl + U`: Pegar  
- `Ctrl + W`: Buscar texto  

---

### **less** / **more** – Visualizar archivos grandes por páginas  
📘 **Uso:** Muestran archivos de texto de forma paginada.  
💻 **Ejemplos:**  
```bash
less archivo.txt
more archivo.txt
```

---

### **vim** / **vi** – Editores avanzados  
📘 **Uso:** Editar archivos con más control (más complejo que nano).  
💻 **Ejemplo:**  
```bash
vim archivo.txt
```

---

# 🔍 BÚSQUEDA DE ARCHIVOS Y CONTENIDO

### **find** – Buscar archivos y directorios  
📘 **Uso:** Busca archivos según nombre, tipo, fecha o tamaño.  
💻 **Ejemplos:**  
```bash
find /ruta -name "*.txt"          # Buscar archivos .txt
find /ruta -type d                # Buscar solo directorios
find /ruta -mtime -7              # Archivos modificados en los últimos 7 días
find /ruta -size +15k -size -20k  # Archivos entre 15 y 20 KiB
```

---

### **grep** – Buscar texto dentro de archivos  
📘 **Uso:** Busca líneas que contengan un patrón o palabra concreta.  
💻 **Ejemplos:**  
```bash
grep "error" archivo.log           # Buscar texto "error"
grep -i "error" archivo.log        # Ignorar mayúsculas/minúsculas
grep -r "error" /var/log           # Buscar recursivamente en una carpeta
grep -n "error" archivo.log        # Mostrar número de línea
grep -l "error" *.log              # Mostrar solo los nombres de archivos que contienen el texto
```

---

# 🧩 METACARACTERES ÚTILES EN LINUX

| Símbolo | Significado | Ejemplo | Resultado |
|----------|--------------|----------|------------|
| `*` | Cualquier número de caracteres | `ls *.txt` | Todos los archivos `.txt` |
| `?` | Un solo carácter | `ls archivo?.txt` | `archivo1.txt`, `archivo2.txt`, etc. |
| `[ ]` | Rango de caracteres | `ls archivo[1-3].txt` | `archivo1.txt`, `archivo2.txt`, `archivo3.txt` |
| `{ }` | Lista de opciones | `mv archivo{1,2,3}.txt /destino` | Mueve tres archivos |
