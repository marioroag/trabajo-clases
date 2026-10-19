# 🧠 RESUMEN — UNIDAD DIDÁCTICA 1: USO DE GIT Y GITHUB

## 1️⃣ Introducción a Git

### ¿Qué es Git?
Git es un **sistema de control de versiones distribuido** que permite gestionar y registrar los cambios de un proyecto a lo largo del tiempo.  
Cada desarrollador tiene una **copia completa del repositorio**, lo que permite trabajar sin conexión y facilita la colaboración.

🔹 **Ventajas clave:**
- Control de versiones local y distribuido.
- Registro detallado de cada cambio (quién, cuándo y por qué).
- Creación y fusión de ramas (branching).
- Posibilidad de volver a versiones anteriores fácilmente.

📘 **Ejemplo:**
Un desarrollador crea una rama para probar una nueva funcionalidad sin afectar la rama principal.  
Cuando termina, fusiona sus cambios mediante `git merge`.

---

## 2️⃣ Instalación y Configuración Inicial

### Instalación
- **Linux:** `sudo apt install git`
- **macOS:** `brew install git`
- **Windows:** Descargar desde [git-scm.com](https://git-scm.com)

### Configuración de identidad
Antes de hacer commits, debes asociar tu nombre y correo:

```bash
git config --global user.name "Tu Nombre"
git config --global user.email "tuemail@ejemplo.com"
```

🔹 `--global` aplica esta configuración a **todos los repositorios** del usuario.  
Si lo omites, solo se aplicará en el repositorio actual.

📘 Ver configuración actual:
```bash
git config --list
```

---

## 3️⃣ Fundamentos del Control de Versiones

### Crear un repositorio local
```bash
mkdir git-workshop
cd git-workshop
git init
```
Esto crea una carpeta oculta `.git` con el historial y la configuración del proyecto.

### Ciclo de vida de los archivos
| Estado | Descripción |
|--------|--------------|
| **Untracked** | Git aún no rastrea el archivo. |
| **Staged** | El archivo está preparado para commit (`git add`). |
| **Modified** | Se modificó un archivo existente. |
| **Committed** | Los cambios están guardados en el historial. |

---

## 4️⃣ Comandos esenciales de Git

| Acción | Comando | Descripción |
|--------|----------|-------------|
| **Ver estado** | `git status` | Muestra qué archivos fueron modificados o agregados. |
| **Agregar archivos** | `git add archivo.txt` / `git add .` | Mueve archivos al *staging area*. |
| **Hacer commit** | `git commit -m "Mensaje"` | Guarda los cambios en el historial. |
| **Reescribir último commit** | `git commit --amend` | Corrige el commit anterior. |

📘 **Ejemplo:**
```bash
git add .
git commit -m "Primer commit"
```

---

## 5️⃣ Trabajo con Ramas

### Crear y cambiar de rama
```bash
git branch nombre_rama      # Crear rama
git checkout nombre_rama    # Cambiar de rama
# o en un solo paso:
git checkout -b nombre_rama
```

### Fusionar ramas
```bash
git checkout master
git merge nombre_rama
```

📘 **Tipos de merge:**
- **Fast-forward:** cuando la rama principal no tiene commits nuevos.
- **Recursive (merge normal):** combina cambios distintos de ambas ramas.

### Ver estructura de ramas
```bash
git log --oneline --all --graph
```

🔹 Este comando muestra el árbol completo de commits y ramas.

---

## 6️⃣ Resolución de Conflictos

Un conflicto ocurre cuando **dos ramas modifican la misma parte del archivo**.  
Git marca el conflicto con:
```
<<<<<<< HEAD
(versión actual)
=======
(versión de la otra rama)
>>>>>>> rama-objetivo
```

### Pasos para resolver:
1. Editar el archivo y eliminar los marcadores.
2. Agregar el archivo corregido:
   ```bash
   git add archivo.txt
   ```
3. Finalizar el merge:
   ```bash
   git merge --continue
   ```
💡 Si prefieres, puedes hacer directamente un nuevo commit.

---

## 7️⃣ Trabajo con GitHub

### ¿Qué es GitHub?
GitHub es una **plataforma online** que aloja repositorios Git y permite la **colaboración remota**.

| Git | GitHub |
|-----|---------|
| Software local. | Plataforma en línea. |
| Controla versiones en tu máquina. | Aloja y comparte repositorios. |
| Funciona sin Internet. | Facilita la colaboración global. |

### Conectar un repositorio local con GitHub
```bash
git remote add origin https://github.com/usuario/repositorio.git
```

### Subir cambios al remoto
```bash
git push origin master
```

### Descargar cambios del remoto
```bash
git pull origin master
```

### Clonar un repositorio existente
```bash
git clone https://github.com/usuario/repositorio.git
```

---

## 8️⃣ Colaboración con GitHub

### Crear una *pull request (PR)*
1. Subir la rama al remoto:
   ```bash
   git push origin nombre_rama
   ```
2. En GitHub, abrir una *Pull Request*.
3. Esperar revisión y aprobación antes de fusionar.

### Buenas prácticas
- Escribir mensajes de commit claros y breves.
- Hacer commits pequeños y frecuentes.
- Revisar el código de tus compañeros.
- Resolver conflictos con cuidado antes de fusionar.

---

## 9️⃣ Comandos adicionales útiles

| Comando | Función |
|----------|----------|
| `git revert <id>` | Crea un commit que deshace otro. |
| `git reset --hard HEAD^` | Elimina el último commit (⚠️ irreversible). |
| `git stash` / `git stash pop` | Guarda cambios temporales y los recupera. |
| `git tag v1.0.0` | Marca una versión del proyecto. |
| `git push origin v1.0.0` | Sube la etiqueta al remoto. |

---

## 💬 Resumen de Preguntas Clave

- **¿Para qué sirve `--global`?**  
  Aplica la configuración (nombre, correo, etc.) a todos los repositorios del sistema.

- **¿Qué diferencia hay entre Git y GitHub?**  
  Git es la herramienta de control de versiones; GitHub es la plataforma en la nube para compartir y colaborar.

- **¿Por qué ocurre un conflicto de merge?**  
  Porque dos ramas modifican las mismas líneas del mismo archivo.

- **Desde una rama nueva, por qué un archivo puede estar vacío?**  
  Porque los cambios en Git solo existen en la rama donde fueron confirmados (cada rama tiene su propio historial).

- **¿Se ven todas las ramas tras hacer `git push origin master`?**  
  No, solo se sube la rama indicada. Las demás deben subirse con `git push origin nombre_rama`.

---

✳️ **Consejo final:**  
Usa `git log --oneline --all --graph` para visualizar todo el flujo de commits y ramas de tu repositorio.  
Es la forma más rápida de entender la estructura de tu proyecto en la prueba.
