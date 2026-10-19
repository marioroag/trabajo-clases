# Taller Introductorio a Git y GitHub

## 1 Configuración inicial

¡Configura tu nombre, correo electrónico y editor de texto!

**Ejemplo de configuración:**

```bash
git config --global user.name "pelegrinalopezsem"
git config --global user.email "pelegrinalopezsem001.alu@stemgranada.com"
```

Para verificar los parámetros globales:

```bash
git config --global --list
```

**Explicación:**
`--global` aplica la configuración a todos los repositorios del usuario. Sin él, la configuración solo se aplicaría al repositorio actual.

---

## 2 Primer repositorio local

Crea un directorio y entra en él:

```bash
mkdir git-workshop
cd git-workshop
git init
```

Crea los archivos `README.md` y `Jose.txt`:

```bash
echo. > README.md
echo. > Jose.txt
```

Agrega los archivos al staging area y haz el primer commit:

```bash
git add README.md Jose.txt
git commit -m "Primer commit: agrega README.md y Jose.txt"
```

**Explicación:**
`git add` prepara los archivos para el commit. `git commit` guarda los cambios en el historial del repositorio.

---

## 3 Correcciones básicas

Renombra el archivo para que coincida con tu nombre:

```bash
git mv Jose.txt sem.txt
git commit --amend -m "Renombra Jose.txt a sem.txt"
```

**Explicación:**
`git commit --amend` modifica el último commit en lugar de crear uno nuevo.

---

## 4 Crear ramas

Crea una nueva rama `yo++` y cámbiate a ella:

```bash
git checkout -b yo++
```

Edita `sem.txt` agregando una breve descripción personal. Luego:

```bash
git add sem.txt
git commit -m "Añade descripción personal en sem.txt"
```

Ahora, vuelve a `master`, crea otra rama `taller-info` y agrega información sobre el taller:

```bash
git checkout master
git checkout -b taller-info
# Edita README.md como quieras
git add README.md
git commit -m "Añade descripción del taller en README.md"
```

**Explicación:**
Las ramas permiten trabajar de manera independiente, evitando que los cambios afecten otras líneas de desarrollo.

---

## 5 Merge fast-forward de ramas

Fusiona `yo++` en `master`:

```bash
git checkout master
git merge yo++
```

**Explicación:**
Este es un merge **fast-forward**, ya que `master` estaba detrás de `yo++`. Git simplemente mueve el puntero de `master` al último commit de `yo++`.

---

## 6 Merge recursive de ramas

Fusiona `taller-info` en `master`:

```bash
git merge taller-info
```

**Explicación:**
Git realiza un **merge recursive**, creando un commit de fusión, porque ambas ramas se desarrollaron en paralelo y tienen historiales distintos.

---

## 7 Aparición de conflictos al realizar merge

En `master`, modifica la primera línea de `README.md` y haz commit:

```bash
git checkout master
# Edita README.md
git add README.md
git commit -m "Cambia README desde master"
```

En `taller-info`, modifica la primera línea de README.md de manera diferente y haz commit:

```bash
git checkout taller-info
# Edita README.md
git add README.md
git commit -m "Cambia README desde taller-info"
```

Ahora intenta fusionar `taller-info` en `master`:

```bash
git checkout master
git merge taller-info
```

**Explicación:**
Ocurre un **conflicto** porque ambas ramas modificaron la misma línea de un archivo. Git no puede decidir automáticamente cuál conservar.

---

## 8 Resolución de conflictos de merge

Abre `README.md` y elimina los marcadores de conflicto (`<<<<<<<`, `=======`, `>>>>>>>`), dejando el contenido final que desees.

Luego agrega y confirma los cambios:

```bash
git add README.md
git commit -m "Resolución del conflicto en README.md"
```

**Explicación:**
Git requiere que el usuario decida manualmente qué cambios conservar cuando hay conflictos. Una vez editado y confirmado, el merge se completa.

---

## 9 Primer repositorio de GitHub

Crea un repositorio público en GitHub llamado `<tu-nombre>-intro-git` (por ejemplo, `sem-intro-git`).

**Pregunta:** ¿Cómo es GitHub diferente a Git?
**Respuesta:** Git es un sistema de control de versiones local. GitHub es una plataforma online que permite alojar repositorios, colaborar y gestionar proyectos de forma remota usando Git.

---

## 10 Sube tus cambios a GitHub

Conecta tu repositorio local con GitHub y sube la rama `master`:

```bash
git remote add origin https://github.com/<tu-usuario>/<tu-repositorio>
git push -u origin master
```

Para subir las ramas restantes:

```bash
git push origin taller-info
git push origin yo++
```

**Explicación:**
Al hacer `push` de `master`, solo esa rama se sube. Las demás ramas permanecen locales hasta subirlas explícitamente.

---

# Fin del taller

¡Has completado todos los ejercicios! Ahora tienes un repositorio con historial, ramas, merges, resolución de conflictos y sincroniz

