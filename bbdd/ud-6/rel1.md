# 🛠️ **Ejercicios de Administración de Bases de Datos en MySQL**

## 📌 **Unidad Didáctica 6: Administración de Bases de Datos en MySQL**

---

## 🔹 **Sección 1: Creación y Gestión de Usuarios en MySQL**

### 📌 **Ejercicio 1: Creación de usuarios locales y remotos**
Crea los siguientes usuarios en MySQL:
- `admin_local` con acceso solo desde `localhost`, con contraseña `Admin123!`
- `user_remote` con acceso desde cualquier IP (`%`), con contraseña `UserSecure!`
- `backup_user` con acceso solo desde la red `192.168.1.%`, con contraseña `BackupPass!`

**✅ Solución:**
```sql
CREATE USER 'admin_local'@'localhost' IDENTIFIED BY 'Admin123!';
CREATE USER 'user_remote'@'%' IDENTIFIED BY 'UserSecure!';
CREATE USER 'backup_user'@'192.168.1.%' IDENTIFIED BY 'BackupPass!';
```

---

### 📌 **Ejercicio 2: Listado de usuarios existentes**
Ejecuta una consulta para obtener todos los usuarios existentes en MySQL, mostrando los campos `User` y `Host`.

**✅ Solución:**
```sql
SELECT User, Host FROM mysql.user;
```

---

### 📌 **Ejercicio 3: Modificación de contraseñas**
Cambia la contraseña de `admin_local` a `AdminNewPass!` y de `backup_user` a `BackupNewPass!`.

**✅ Solución:**
```sql
ALTER USER 'admin_local'@'localhost' IDENTIFIED BY 'AdminNewPass!';
ALTER USER 'backup_user'@'192.168.1.%' IDENTIFIED BY 'BackupNewPass!';
```

---

### 📌 **Ejercicio 4: Expiración de contraseñas**
Configura el usuario `user_remote` para que su contraseña expire y deba cambiarla en su próximo inicio de sesión.

**✅ Solución:**
```sql
ALTER USER 'user_remote'@'%' PASSWORD EXPIRE;
```

---

### 📌 **Ejercicio 5: Eliminación de usuarios**
Elimina el usuario `backup_user` del sistema.

**✅ Solución:**
```sql
DROP USER 'backup_user'@'192.168.1.%';
```

---

## 🔹 **Sección 2: Gestión de Privilegios en MySQL**

### 📌 **Ejercicio 6: Concesión de todos los privilegios sobre una base de datos**
Otorga a `admin_local` todos los privilegios sobre la base de datos `tienda_comics`.

**✅ Solución:**
```sql
GRANT ALL PRIVILEGES ON tienda_comics.* TO 'admin_local'@'localhost';
```

---

### 📌 **Ejercicio 7: Concesión de permisos específicos**
Concede a `user_remote` permisos de `SELECT` e `INSERT` sobre la tabla `pedido` en la base de datos `tienda_comics`.

**✅ Solución:**
```sql
GRANT SELECT, INSERT ON tienda_comics.pedido TO 'user_remote'@'%';
```

---

### 📌 **Ejercicio 8: Revocación de privilegios**
Revoca los privilegios de `INSERT` sobre `pedido` al usuario `user_remote` en la base de datos `tienda_comics`.

**✅ Solución:**
```sql
REVOKE INSERT ON tienda_comics.pedido FROM 'user_remote'@'%';
```

---

### 📌 **Ejercicio 9: Visualización de privilegios de un usuario**
Consulta los privilegios asignados a `admin_local`.

**✅ Solución:**
```sql
SHOW GRANTS FOR 'admin_local'@'localhost';
```

---

### 📌 **Ejercicio 10: Aplicación de cambios en los privilegios**
Ejecuta el comando necesario para aplicar los cambios en los privilegios tras realizar modificaciones.

**✅ Solución:**
```sql
FLUSH PRIVILEGES;
```

---

## 🔹 **Sección 3: Gestión de Roles en MySQL**

### 📌 **Ejercicio 11: Creación de roles**
Crea dos roles en MySQL:
- `gestor_ventas`
- `analista_datos`

**✅ Solución:**
```sql
CREATE ROLE 'gestor_ventas';
CREATE ROLE 'analista_datos';
```

---

### 📌 **Ejercicio 12: Asignación de privilegios a roles**
Otorga los siguientes privilegios:
- Al rol `gestor_ventas`, permisos de `SELECT`, `INSERT` y `UPDATE` sobre `tienda_comics`.
- Al rol `analista_datos`, permisos de solo `SELECT` sobre todas las tablas de `tienda_comics`.

**✅ Solución:**
```sql
GRANT SELECT, INSERT, UPDATE ON tienda_comics.* TO 'gestor_ventas';
GRANT SELECT ON tienda_comics.* TO 'analista_datos';
```

---

### 📌 **Ejercicio 13: Consulta de roles antes de la asignación**
Consulta los roles asignados al usuario `admin_local` antes de asignarle un nuevo rol.

**✅ Solución:**
```sql
SHOW GRANTS FOR 'admin_local'@'localhost';
```

---

### 📌 **Ejercicio 14: Asignación de roles a usuarios**
Asigna los siguientes roles:
- `gestor_ventas` al usuario `admin_local` en `localhost`.
- `analista_datos` al usuario `user_remote` en `%`.

**✅ Solución:**
```sql
GRANT 'gestor_ventas' TO 'admin_local'@'localhost';
GRANT 'analista_datos' TO 'user_remote'@'%';
```

---

### 📌 **Ejercicio 15: Verificación de roles asignados**
Consulta los roles asignados a `admin_local` y `user_remote` después de la asignación.

**✅ Solución:**
```sql
SHOW GRANTS FOR 'admin_local'@'localhost';
SHOW GRANTS FOR 'user_remote'@'localhost';
```

---

### 📌 **Ejercicio 16: Verificación de usuario y rol actual**
Usa `CURRENT_USER()` y `CURRENT_ROLE()` para verificar el usuario autenticado y el rol en uso en una sesión de MySQL. ¿Cuál es la diferencia entre ambos?

**✅ Solución:**
```sql
SELECT CURRENT_USER(), CURRENT_ROLE();
```

💡 *Nota:* `CURRENT_USER()` muestra el usuario autenticado en MySQL, mientras que `CURRENT_ROLE()` muestra el rol actualmente activado en la sesión. 

---
