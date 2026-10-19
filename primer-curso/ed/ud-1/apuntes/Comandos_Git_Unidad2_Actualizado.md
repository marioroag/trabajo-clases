# 🧩 COMANDOS DE GIT — UNIDAD DIDÁCTICA 2: ENTORNOS DE DESARROLLO

## 🔧 CONFIGURACIÓN INICIAL

### **git config** – Configurar opciones globales o locales  
📘 **Uso:** Define opciones como nombre, correo y editor predeterminado.  
💻 **Ejemplos:**  
```bash
git config --global user.name "Tu Nombre"
git config --global user.email "tunombre@correo.com"
git config --list              # Ver configuración actual
```

---

## 🏗️ INICIALIZAR Y CLONAR REPOSITORIOS

### **git init** – Crear un nuevo repositorio  
📘 **Uso:** Convierte una carpeta en un repositorio Git.  
💻 **Ejemplo:**  
```bash
git init
```

---

### **git clone** – Clonar un repositorio existente  
📘 **Uso:** Crea una copia local de un repositorio remoto.  
💻 **Ejemplo:**  
```bash
git clone https://github.com/usuario/proyecto.git
```

---

## 📂 GESTIÓN DE ARCHIVOS Y CAMBIOS

### **git status** – Ver el estado del repositorio  
📘 **Uso:** Muestra los archivos modificados, nuevos o pendientes de confirmar.  
💻 **Ejemplo:**  
```bash
git status
```

---

### **git add** – Añadir archivos al área de preparación (*staging area*)  
📘 **Uso:** Prepara los archivos para ser confirmados (commit).  
💻 **Ejemplos:**  
```bash
git add archivo.txt           # Añadir un archivo
git add .                     # Añadir todos los archivos modificados
```

---

### **git commit** – Guardar los cambios en el historial  
📘 **Uso:** Crea una nueva versión del proyecto con los cambios añadidos.  
💻 **Ejemplo:**  
```bash
git commit -m "Mensaje descriptivo del cambio"
```

---

### **git rm** – Eliminar archivos del repositorio  
📘 **Uso:** Borra archivos del repositorio y del área de trabajo.  
💻 **Ejemplo:**  
```bash
git rm archivo.txt
```

---

### **git mv** – Mover o renombrar archivos  
📘 **Uso:** Cambia el nombre o la ubicación de un archivo y lo prepara para commit.  
💻 **Ejemplo:**  
```bash
git mv viejo.txt nuevo.txt
```

---

## 🔍 INSPECCIÓN Y VISUALIZACIÓN DE CAMBIOS

### **git log** – Ver el historial de commits  
📘 **Uso:** Muestra la lista de confirmaciones (commits) realizadas.  
💻 **Ejemplos:**  
```bash
git log                    # Historial completo
git log --oneline          # Versión corta de una línea por commit
git log --graph --oneline  # Gráfico de ramas
```

---

### **git diff** – Ver diferencias entre versiones o commits  
📘 **Uso:** Muestra los cambios realizados entre commits o en el área de trabajo.  
💻 **Ejemplos:**  
```bash
git diff                    # Cambios no añadidos al área de preparación
git diff --staged           # Cambios que serán incluidos en el próximo commit
```

---

## 🌿 GESTIÓN DE RAMAS (BRANCHES)

### **git branch** – Listar, crear o eliminar ramas  
📘 **Uso:** Permite gestionar las ramas de desarrollo.  
💻 **Ejemplos:**  
```bash
git branch                  # Ver ramas existentes
git branch nueva-rama       # Crear una nueva rama
git branch -d vieja-rama    # Eliminar una rama
```

---

### **git checkout** – Cambiar de rama o restaurar archivos  
📘 **Uso:** Permite moverse entre ramas o recuperar archivos antiguos.  
💻 **Ejemplos:**  
```bash
git checkout nueva-rama         # Cambiar a otra rama
git checkout archivo.txt        # Restaurar archivo al último commit
```

---

### **git switch** – Cambiar de rama (alternativa moderna a checkout)  
📘 **Uso:** Simplifica el cambio de rama.  
💻 **Ejemplo:**  
```bash
git switch main
```

---

### **git merge** – Fusionar ramas  
📘 **Uso:** Combina los cambios de una rama con otra.  
💻 **Ejemplo:**  
```bash
git merge nueva-rama
```

---

### **git rebase** – Reaplicar commits sobre otra base  
📘 **Uso:** Reorganiza el historial de commits para mantenerlo limpio.  
💻 **Ejemplo:**  
```bash
git rebase main
```

---

## 🌐 TRABAJO CON REPOSITORIOS REMOTOS

### **git remote** – Gestionar conexiones remotas  
📘 **Uso:** Añade, elimina o muestra repositorios remotos.  
💻 **Ejemplos:**  
```bash
git remote -v                             # Ver repositorios remotos
git remote add origin https://github.com/usuario/proyecto.git
git remote remove origin                  # Eliminar un remoto
```

---

### **git fetch** – Descargar cambios del remoto sin aplicarlos  
📘 **Uso:** Actualiza las referencias locales con lo que hay en el remoto.  
💻 **Ejemplo:**  
```bash
git fetch origin
```

---

### **git pull** – Descargar y fusionar cambios del remoto  
📘 **Uso:** Trae los cambios del remoto y los combina con la rama actual.  
💻 **Ejemplo:**  
```bash
git pull origin main
```

---

### **git push** – Subir cambios al repositorio remoto  
📘 **Uso:** Envía los commits locales al remoto.  
💻 **Ejemplo:**  
```bash
git push origin main
```

---

## 🧰 OTROS COMANDOS ÚTILES

### **git stash** – Guardar cambios temporales sin confirmar  
📘 **Uso:** Guarda los cambios actuales para poder cambiar de rama sin perderlos.  
💻 **Ejemplo:**  
```bash
git stash
git stash pop       # Recuperar los cambios guardados
```

---

### **git reset** – Deshacer commits o cambios  
📘 **Uso:** Elimina commits recientes o saca archivos del área de preparación.  
💻 **Ejemplos:**  
```bash
git reset archivo.txt       # Quitar un archivo del área de preparación
git reset --hard HEAD~1     # Eliminar el último commit
```

---

### **git revert** – Deshacer un commit creando uno nuevo  
📘 **Uso:** Revierte los cambios de un commit sin modificar el historial.  
💻 **Ejemplo:**  
```bash
git revert a1b2c3d
```

---

### **git tag** – Crear marcas o versiones  
📘 **Uso:** Marca versiones específicas del proyecto.  
💻 **Ejemplo:**  
```bash
git tag v1.0
git push origin v1.0
```


### **git commit --amend** – Reescribir el último commit  
📘 **Uso:** Permite modificar el último commit, ya sea para corregir el mensaje o incluir cambios olvidados.  
💻 **Ejemplos:**  
```bash
git commit --amend -m "Nuevo mensaje del último commit"
git add archivo_olvidado.txt
git commit --amend
```
🔎 *Útil para ajustar pequeños errores sin crear un nuevo commit.*

---

### **git merge --continue** – Completar un merge tras resolver conflictos  
📘 **Uso:** Se utiliza cuando un `git merge` genera conflictos. Una vez resueltos, este comando finaliza la fusión.  
💻 **Ejemplo:**  
```bash
# Resolver manualmente los conflictos en los archivos
git add archivo_conflictivo.txt
git merge --continue
```

---

### **git log --oneline --all --graph** – Visualizar todas las ramas con estructura  
📘 **Uso:** Muestra el historial de todos los commits en formato compacto y gráfico, incluyendo todas las ramas.  
💻 **Ejemplo:**  
```bash
git log --oneline --all --graph
```
🔎 *Ideal para comprender la estructura completa del proyecto y sus ramas.*

---

### **mkdir, cd, touch, echo** – Comandos del sistema usados en los ejercicios  
📘 **Uso:** Son comandos de la terminal del sistema operativo, no de Git, pero se emplean frecuentemente durante el trabajo con repositorios.  
💻 **Ejemplos:**  
```bash
mkdir proyecto          # Crear una carpeta
cd proyecto             # Entrar en la carpeta
touch archivo.txt       # Crear un archivo vacío
echo "Hola Git" > nota.txt  # Crear un archivo con contenido
```
🔎 *Sirven para crear, navegar y preparar archivos dentro de los ejercicios de Git.*

---
