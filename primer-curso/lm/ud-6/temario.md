# Unidad Didáctica 6: Uso de Fetch y APIs RESTful  

## 1. Introducción a las APIs y RESTful  

### 1.1. ¿Qué es una API?  

Una **API (Interfaz de Programación de Aplicaciones)** es un conjunto de definiciones y protocolos que permiten que diferentes aplicaciones se comuniquen entre sí. Las APIs facilitan el intercambio de datos y funcionalidades, actuando como puentes que conectan sistemas.  

En el desarrollo web, las APIs permiten que las aplicaciones obtengan y envíen datos a servidores, permitiendo la creación de aplicaciones dinámicas y conectadas con bases de datos o servicios en la nube.  

---

### 1.2. ¿Qué es una API RESTful?  

Las APIs **RESTful** siguen los principios de **REST (Representational State Transfer)**, un estilo arquitectónico que organiza las interacciones entre clientes y servidores a través de **HTTP**.  

**Características de las APIs RESTful:**  
- **Stateless (Sin estado):** Cada solicitud contiene toda la información necesaria; el servidor no almacena información de solicitudes previas.  
- **Operaciones CRUD:** Se utilizan métodos HTTP estándar para operar sobre recursos (Crear, Leer, Actualizar y Eliminar).  
- **Recursos identificados por URIs:** Cada recurso tiene una dirección única (`/usuarios`, `/productos`).  
- **Formato de datos:** JSON es el formato más utilizado por su simplicidad y eficiencia.  

---

### 1.3. Postman y Pruebas de APIs  

**Postman** es una herramienta que facilita el desarrollo, prueba y documentación de APIs. Permite enviar solicitudes HTTP a servidores y recibir respuestas sin necesidad de escribir código.  

Con Postman se pueden realizar solicitudes **GET, POST, PUT y DELETE**, simulando las mismas operaciones que una aplicación web realizaría mediante `fetch()`. Es útil para verificar el funcionamiento de una API antes de integrarla en un proyecto.  

---

## 2. Métodos HTTP en APIs RESTful  

### 2.1. Métodos principales  

RESTful utiliza los siguientes métodos HTTP para interactuar con recursos:  

- **GET (Obtener):** Solicita datos de un recurso. No modifica nada, solo lee.  
- **POST (Crear):** Envía datos para crear un nuevo recurso.  
- **PUT (Actualizar):** Modifica o reemplaza un recurso existente.  
- **DELETE (Eliminar):** Elimina un recurso.  

---

### 2.2. Ejemplos prácticos con Postman  

1. **GET – Obtener datos:**  
   ```http
   GET /productos/1
   ```  
   - Recupera información sobre el producto con ID 1.  
   - Respuesta en JSON:  
     ```json
     {
       "id": 1,
       "nombre": "Laptop",
       "precio": 1200
     }
     ```  

2. **POST – Crear un nuevo producto:**  
   ```http
   POST /productos
   Content-Type: application/json
   ```  
   Cuerpo (Body) de la solicitud:  
   ```json
   {
     "nombre": "Tablet",
     "precio": 800
   }
   ```  
   - El servidor responde con `201 Created` y el objeto creado.  

3. **PUT – Actualizar un producto existente:**  
   ```http
   PUT /productos/1
   Content-Type: application/json
   ```  
   ```json
   {
     "nombre": "Laptop Pro",
     "precio": 1500
   }
   ```  
   - El producto con ID 1 se actualiza con los nuevos datos.  

4. **DELETE – Eliminar un producto:**  
   ```http
   DELETE /productos/1
   ```  
   - Elimina el producto con ID 1 y responde con `204 No Content`.  

---

## 3. Uso de Fetch para Consumir APIs RESTful  

### 3.1. ¿Qué es Fetch?  

`fetch()` es una función de JavaScript que permite realizar solicitudes HTTP a servidores para obtener o enviar datos. Es el método principal para interactuar con APIs desde aplicaciones web.  

**Ventajas de fetch():**  
- Es nativa de los navegadores modernos.  
- Permite manejar solicitudes de manera sencilla.  
- Funciona con `async/await` para código asincrónico.  

---

### 3.2. Realizar solicitudes con Fetch  

#### 3.2.1. GET – Obtener datos de una API  
```javascript
const response = await fetch('https://jsonplaceholder.typicode.com/posts')  
const datos = await response.json()  
console.log(datos)
```  
- Se realiza una solicitud GET a la API.  
- La respuesta se convierte a JSON.  

---

#### 3.2.2. POST – Crear un nuevo recurso  

Se define el objeto con los datos a enviar y luego se realiza la solicitud.  

```javascript
const nuevoPost = {
  title: 'Nuevo artículo',
  body: 'Este es el contenido del artículo',
  userId: 1
}

const response = await fetch('https://jsonplaceholder.typicode.com/posts', {
  method: 'POST',
  headers: {
    'Content-Type': 'application/json'
  },
  body: JSON.stringify(nuevoPost)
})  

const datos = await response.json()  
console.log(datos)
```  
- Se define un objeto `nuevoPost`.  
- Se envía como JSON utilizando `fetch()`.  
- La API responde con el nuevo objeto creado.  

---

#### 3.2.3. PUT – Actualizar un recurso existente  

De forma similar a POST, se define el objeto a actualizar y se envía usando `PUT`.  

```javascript
const actualizarPost = {
  id: 1,
  title: 'Artículo actualizado',
  body: 'Nuevo contenido actualizado',
  userId: 1
}

const response = await fetch('https://jsonplaceholder.typicode.com/posts/1', {
  method: 'PUT',
  headers: {
    'Content-Type': 'application/json'
  },
  body: JSON.stringify(actualizarPost)
})  

const datos = await response.json()  
console.log(datos)
```  
- El objeto `actualizarPost` contiene la actualización.  
- Se realiza la solicitud PUT enviando los nuevos datos al recurso con ID 1.  

---

#### 3.2.4. DELETE – Eliminar un recurso  

```javascript
await fetch('https://jsonplaceholder.typicode.com/posts/1', {
  method: 'DELETE'
})  

console.log('Recurso eliminado')
```  
- No es necesario enviar un cuerpo (`body`) en la solicitud DELETE.  
- El servidor responde confirmando la eliminación.  

---

## 4. Conclusión  

El uso de `fetch()` junto con APIs RESTful permite que las aplicaciones web se comuniquen con servidores y bases de datos, facilitando el desarrollo de aplicaciones dinámicas y escalables.  

Probar las solicitudes con Postman antes de implementarlas con JavaScript ayuda a verificar el correcto funcionamiento de la API, evitando errores durante la integración.  

Dominar estos conceptos es esencial para el desarrollo de aplicaciones modernas que interactúan con recursos externos y servicios en línea.