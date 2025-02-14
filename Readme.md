# 🚀 Servidor Web en Java con IoC y Soporte para Anotaciones

Servidor web ligero en Java, desarrollado desde cero, con soporte para HTML, imágenes PNG y un framework IoC basado en POJOs. Implementa un mecanismo de anotaciones para definir rutas HTTP de forma similar a frameworks como Spring Boot.

## 📌 Características Principales

✅ Servidor HTTP con soporte para solicitudes GET
✅ Manejo de archivos estáticos (HTML, imágenes, CSS, JS)
✅ Inversión de Control (IoC) con inyección de dependencias automática
✅ Definición de rutas con anotaciones como `@RestController`, `@GetMapping` y `@RequestParam`
✅ Arquitectura extensible y modular

---

## 🛠️ Requisitos

Antes de ejecutar el proyecto, asegúrate de tener instalado lo siguiente:

- **Java 11 o superior** - Ambiente de desarrollo
- **Maven** - Para la compilación y gestión de dependencias
- **Git** - Para clonar el repositorio

---

## 🚀 Instalación y Ejecución

1️⃣ Clonar el repositorio:

```sh
git clone https://github.com/TuUsuario/ServidorWebJava.git
```

2️⃣ Acceder a la carpeta del proyecto:

```sh
cd ServidorWebJava
```

3️⃣ Compilar y ejecutar la aplicación:

```sh
mvn clean package exec:java -Dexec.mainClass="server.Main"
```

4️⃣ Una vez iniciado el servidor, accede desde el navegador a:

🔗 [http://localhost:8080](http://localhost:8080)

---

## 📂 Estructura del Proyecto

```
ServidorWebJava/
│── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── server/
│   │   │   │   ├── WebServer.java  # Implementación del servidor HTTP
│   │   │   │   ├── IoCFramework.java  # Gestión de inyección de dependencias
│   │   │   │   ├── RequestHandler.java  # Procesamiento de solicitudes HTTP
│   │   │   │   ├── annotations/
│   │   │   │   │   ├── RestController.java
│   │   │   │   │   ├── GetMapping.java
│   │   │   │   │   ├── RequestParam.java
│   │   ├── resources/
│   │   │   ├── static/  # Archivos HTML, CSS, JS
```

---

## 🏗️ Implementación de Requerimientos del Taller

### ✅ 1. Manejo de Solicitudes HTTP con Anotaciones

El servidor permite definir rutas utilizando `@RestController` y `@GetMapping`:

```java
@RestController
public class MyController {

    @GetMapping("/hello")
    public String sayHello() {
        return "¡Hola, mundo!";
    }
}
```

📌 **¿Dónde se resuelve en el código?**
- `IoCFramework.java`: Escanea clases con `@RestController` y detecta métodos con `@GetMapping`.
- `RequestHandler.java`: Mapea rutas y ejecuta métodos asociados.

---

### ✅ 2. Soporte para Parámetros en URL

Se pueden definir parámetros en las rutas con `@RequestParam`:

```java
@GetMapping("/saludo")
public String saludo(@RequestParam("nombre") String nombre) {
    return "Hola, " + nombre + "!";
}
```

📌 **¿Dónde se resuelve en el código?**
- `IoCFramework.java`: Extrae parámetros de la URL y los inyecta en el método adecuado.

Ejemplo de uso en el navegador:
🔗 [http://localhost:8080/saludo?nombre=Aglaea](http://localhost:8080/saludo?nombre=Aglaea)

---

### ✅ 3. Servir Archivos Estáticos

El servidor puede devolver archivos HTML, CSS, JS e imágenes PNG desde una carpeta `static`.

Ejemplo:
🔗 [http://localhost:8080/index.html](http://localhost:8080/index.html)

📌 **¿Dónde se resuelve en el código?**
- `WebServer.java`: Detecta si la ruta solicitada es un archivo y lo devuelve al cliente.
- `RequestHandler.java`: Determina el tipo de contenido (`Content-Type`).

---

### ✅ 4. Inversión de Control y Creación Dinámica de Instancias

El framework IoC escanea clases con `@RestController` e instancia automáticamente los objetos.

📌 **¿Dónde se resuelve en el código?**
- `IoCFramework.java`:
    - Carga dinámicamente las clases usando `ClassLoader`.
    - Usa `Reflection API` para instanciar controladores automáticamente.

---

## 🔥 Mejoras Futuras

🔹 Soporte para solicitudes `POST`
🔹 Manejo de errores y respuestas HTTP más robustas
🔹 Implementación de `ThreadPool` para manejo concurrente

---

## 📌 Autor

👨‍💻 **Andres Felipe Parra Quiroga**

🔗 GitHub: [Flyp](https://github.com/FlypZed)
📧 Contacto: Flyp.and@gmail.com

---
