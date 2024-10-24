# GestorTareas
URL https://cvds-app.azurewebsites.net

probando pagina principal

![image](https://github.com/user-attachments/assets/79e5127b-8b16-41b0-aa46-885687d0a037)

probando parte de graficas

![image](https://github.com/user-attachments/assets/11796150-267b-494a-b15f-9b9751f46ba4)

En los ultimos laboratorios se hizo la migracion del front a react ademas de que se hizo el despliegue en azure web app

Pagina principal

![image](https://github.com/user-attachments/assets/60782fb4-700d-4f5e-b842-25d26714d22d)

Para un usuario x

![image](https://github.com/user-attachments/assets/b2fe096c-ff72-44ea-b151-d0467d9add28)

Ademas se hizo un cubrimiento en cuanto a pruebas unitarias del 85% y se confabulo con jacoco

![image](https://github.com/user-attachments/assets/ec93d0a9-41b1-4696-bcc3-cf6ede52c6cd)

Resumen:
El Gestor de Tareas es una aplicación web diseñada para ayudar a los usuarios a organizar y gestionar sus tareas de manera eficiente. El sistema está construido utilizando una arquitectura moderna, basada en principios de diseño SOLID para garantizar un código robusto, mantenible y escalable. La aplicación está dividida en dos secciones principales: Usuarios y Tareas, donde los usuarios pueden registrarse, iniciar sesión y gestionar sus listas de tareas pendientes.

El backend del sistema está desarrollado con Spring Boot y gestionado con Maven para la configuración del proyecto. Además, se implementa un pipeline de CI/CD utilizando Azure DevOps para garantizar despliegues continuos y automatizados en una Azure Web App. El frontend está desarrollado con React, proporcionando una interfaz de usuario interactiva y fácil de usar.

Características Principales:
Gestión de Usuarios:

Registro y autenticación de usuarios.
Actualización de información de perfil.
Inicio de sesión con validación de credenciales.
Gestión de Tareas:

Crear, editar, eliminar y ver tareas.
Asignación de prioridades y fechas inicio y fin .
Visualización de tareas pendientes y completadas.
Tecnologías y Herramientas Utilizadas:
Backend:

Spring Boot: Framework para la implementación del backend, con APIs RESTful para manejar las operaciones de usuarios y tareas.
Maven: Herramienta de gestión de dependencias y construcción del proyecto.
SOLID: Principios de diseño orientado a objetos aplicados en la arquitectura del código para asegurar flexibilidad y mantenibilidad.
Frontend:

React: Framework para el desarrollo de la interfaz de usuario, permitiendo una experiencia dinámica e interactiva.
Integración Continua / Despliegue Continuo (CI/CD):

Azure DevOps: Plataforma utilizada para la integración y despliegue continuos.
Pipeline de CI/CD: Automatización del proceso de compilación, pruebas y despliegue de la aplicación a una Azure Web App.
Tests automatizados: Implementación de pruebas unitarias y de integración, garantizando la calidad del código.
Infraestructura y Despliegue:

Azure Web App: Plataforma en la nube donde la aplicación es desplegada y alojada.
Docker: Contenerización del backend para un entorno de ejecución consistente.
Estructura del Proyecto:
Sección de Usuarios:

Los usuarios pueden registrarse, iniciar sesión y actualizar sus perfiles.
Validación de contraseñas y control de sesiones.
Interfaz sencilla para la gestión de datos de usuario.
Sección de Tareas:

Creación de tareas con descripciones, fechas  y prioridades.
Posibilidad de marcar tareas como completadas o pendientes.
Visualización clara de las tareas en una lista ordenada por prioridad o fecha de vencimiento.
Flujo de Trabajo:
Registro e Inicio de Sesión: Los usuarios se registran proporcionando un nombre de usuario y contraseña. Una vez autenticados, pueden acceder a su perfil y gestionar sus tareas.

Gestión de Tareas: Los usuarios pueden crear nuevas tareas, asignarles una prioridad  y actualizarlas según sea necesario. Además, las tareas se pueden marcar como completadas o eliminadas.

Pipeline de CI/CD: El código es administrado en un repositorio de Git y cada cambio en el proyecto activa el pipeline de CI/CD en Azure DevOps, que se encarga de compilar, ejecutar las pruebas y desplegar la aplicación en la nube.

Principios SOLID aplicados:
Responsabilidad Única (SRP): Cada clase tiene una única responsabilidad, como manejar la lógica de usuarios o la gestión de tareas.
Abierto/Cerrado (OCP): El sistema está diseñado para ser extensible sin necesidad de modificar el código existente, facilitando la adición de nuevas características.
Sustitución de Liskov (LSP): Las subclases o derivados pueden ser utilizadas sin alterar el comportamiento esperado.
Segregación de Interfaces (ISP): Las interfaces están diseñadas de manera que las clases no necesiten implementar métodos que no utilizan.
Inversión de Dependencias (DIP): Las dependencias se inyectan en lugar de ser creadas directamente dentro de las clases, facilitando la prueba y el mantenimiento.
Este proyecto proporciona una plataforma robusta y escalable para la gestión de tareas, con un enfoque en la calidad del código, automatización de despliegues y principios de diseño SOLID, que aseguran que la aplicación sea fácil de mantener y evolucionar a largo plazo.
