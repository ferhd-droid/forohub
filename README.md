# API de Gestión de Tópicos para Foro de Programación

## Descripción

Esta API permite gestionar tópicos en un foro de programación, específicamente relacionados con errores y dudas sobre cursos de programación. Los usuarios pueden crear nuevos tópicos, leer los existentes, actualizarlos y eliminarlos. Cada tópico incluye información como el título, la descripción del error o duda, y el curso relacionado.

## Endpoints

### Autenticación y Autorización

- **URL:** `/login`
- **Método:** `POST`
- **Descripción:** Permite crear un JWT (Jason Web Token).
- **Parámetros:**
  - `username` (string, requerido): Nombre del usuario.
  - `passwd` (string, requerido): Contraseña
- **Cuerpo del ejemplo:**
 
   ```json
  {
    "username": "henry heffernan",
    "passwd": "123456"
  }

- **Respuesta de éxito:**

  ```json
  {
  "jwtToken": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJmb3JvIGh1YiIsInN1YiI6IkZlcm5hbmRvIEhlcm7DoW5kZXoiLCJpZCI6MiwiZXhwIjoxNzE5MjA5MTEyfQ.T1i-uzISn9_lJg3ztidpWfNdmC4dRpq4GFGvPISbW6g"
  }

### Crear un Tópico

- **URL:** `/topicos`
- **Método:** `POST`
- **Descripción:** Permite crear un nuevo tópico.
- **Nota: Se necesita el JWT Bearer para autorizar en Header Authorization:**
- **Parámetros:**
  - `idusuario` (string del número requerido): id de usuario
  - `titulo` (string, requerido): Título del tópico.
  - `mensaje` (string, requerido): Descripción del error o duda.
  - `nombreCurso` (string, requerido): Nombre del curso relacionado.
- **Cuerpo del ejemplo:**

  ```json
  {
    "idUsuario": "1",
    "titulo": "Problemas con la instalación de Node.js",
    "mensaje": "No puedo instalar Node.js en Windows 10, aparece un error...",
    "nombreCurso": "Curso de JavaScript Básico"
  }

- **Respuesta de éxito:**

  ```json
  {
    "id": 1,
    "titulo": "Problemas con la instalación de Node.js",
    "mensaje": "No puedo instalar Node.js en Windows 10, aparece un error...",
    "fecha_creacion": "2024-06-19T12:34:56Z"
  }

### Listar Tópicos

- **URL:** `/topicos`
- **Método:** `GET`
- **Descripción:** Retorna una lista de todos los tópicos.
- **Nota: Se necesita el JWT Bearer para autorizar en Header Authorization:**

- **Respuesta de éxito:**

    ```json
  [
  {
    "id": 1,
    "titulo": "Problemas con la instalación de Node.js",
    "mensaje": "No puedo instalar Node.js en Windows 10, aparece un error...",
    "nombreCurso": "Curso de JavaScript Básico",
    "fecha_creacion": "2024-06-19T12:34:56Z"
  },
  {
    "id": 2,
    "titulo": "Error en el código de Python",
    "mensaje": "Tengo un error de sintaxis en mi script...",
    "nombreCurso": "Curso de Python Avanzado",
    "fecha_creacion": "2024-06-18T11:22:33Z"
  }
  ]

### Leer un Tópico

- **URL:** `/topicos/{id}`
- **Método:** `GET`
- **Descripción:** Obtiene la información de un tópico específico.
- **Nota: Se necesita el JWT Bearer para autorizar en Header Authorization:**
- **Parámetros de ruta:**
  - `id` (integer, requerido): ID del tópico.

- **Respuesta de éxito:**

    ```json
    {
    "id": 1,
    "titulo": "Problemas con la instalación de Node.js",
    "mensaje": "No puedo instalar Node.js en Windows 10, aparece un error...",
    "nombreCurso": "Curso de JavaScript Básico",
    "fecha_creacion": "2024-06-19T12:34:56Z"
    }



### Actualizar un Tópico

- **URL:** `/topicos/{id}`
- **Método:** `PUT`
- **Descripción:** Actualiza la información de un tópico específico.
- **Nota: Se necesita el JWT Bearer para autorizar en Header Authorization:**
- **Parámetros de ruta:**
  - `id` (integer, requerido): ID del tópico.
- **Parámetros del cuerpo:**
  - `titulo` (string, opcional): Nuevo título del tópico.
  - `mensaje` (string, opcional): Nuevo mensaje del error o duda.
  - `nombreCurso` (string, opcional): Nuevo curso relacionado.

- **Cuerpo del ejemplo:**

  ```json
  {
    "titulo": "Problemas con la instalación de Node.js (actualizado)",
    "mensaje": "No puedo instalar Node.js en Windows 10, aparece un error...",
    "nombreCurso": "Curso de JavaScript Básico"
  }

- **Respuesta de éxito:**

  ```json
  {
    "id": "1",
    "titulo": "Problemas con la instalación de Node.js (actualizado)",
    "mensaje": "No puedo instalar Node.js en Windows 10, aparece un error...",
    "nombreCurso": "Curso de JavaScript Básico"
  }

### Eliminar un Tópico

- **URL:** `/topicos/{id}`
- **Método:** `DELETE`
- **Nota: Se necesita el JWT Bearer para autorizar en Header Authorization:**
- **Descripción:** Elimina un tópico específico.
- **Parámetros de ruta:**
  - `id` (integer, requerido): ID del tópico.

