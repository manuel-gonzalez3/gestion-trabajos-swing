# Job Management — Copy Shop (Java Swing)

> 🇬🇧 English version below · 🇪🇸 [Versión en español](#gestión-de-trabajos--fotocopiadora-java-swing)

Desktop application built with **Java Swing** to manage the jobs of a copy shop, with
per-user login and two roles (administrator and user). Built as the final project for the
**Object-Oriented Language** course.

## Features

- **Login** with a password per user (four preloaded users: one administrator and three
  regular users).
- **Administrator**:
  - Create, enable and disable users.
  - Change job status (pending, received, in progress, finished, delivered).
  - View jobs by stage and jobs per user.
- **User**:
  - Request a job (number of copies and quality: color / black & white).
  - Delete a job if it has not been started yet.
  - View their job history.
- Validation: negative or zero quantities are not allowed.

## Design

UI built with **JFrame/JPanel** and data held in **arrays** (no database, per the
assignment). The windows (`Ventana*.java`) act as per-role containers, and the panels
(`Panel*.java`) implement each specific feature. Models `Usuario` and `Trabajo`, with
shared state in `Variables`.

```
src/TrabajoFinal/
  main.java                 # entry point
  VentanaLogin.java         # password login
  VentanaAdmin.java         # administrator role container
  VentanaUser.java          # user role container
  PanelListaUsuarios.java   # user management/listing (admin)
  PanelNuevoUsuario.java    # create user (admin)
  PanelListaTrabajos.java   # job listing and status change
  PanelNuevoTrabajo.java    # request a job (user)
  Usuario.java Trabajo.java Variables.java
docs/
  consigna.txt              # original assignment (Spanish)
  Informe.pdf               # project report — Spanish (description + screenshots)
```

## Build & run

```bash
cd src
javac TrabajoFinal/*.java module-info.java
java TrabajoFinal.main
```

(Or import the project into Eclipse / IntelliJ and run `main`.)

> Note: source code and comments are in Spanish.

---

# Gestión de Trabajos — Fotocopiadora (Java Swing)

> 🇪🇸 Versión en español · 🇬🇧 [English version above](#job-management--copy-shop-java-swing)

Aplicación de escritorio en **Java Swing** para administrar los trabajos de una
fotocopiadora, con login por usuario y dos roles (administrador y usuario). Desarrollada
como trabajo final de la materia **Lenguaje Orientado a Objetos**.

## Funcionalidades

- **Login** con clave por usuario (cuatro usuarios precargados: un administrador y tres
  usuarios normales).
- **Administrador**:
  - Crear, activar y desactivar usuarios.
  - Cambiar el estado de los trabajos (pendiente, recibido, en ejecución, terminado,
    entregado).
  - Ver lista de trabajos por etapa y listado de trabajos por usuario.
- **Usuario**:
  - Pedir un trabajo (cantidad de copias y calidad: color / blanco y negro).
  - Eliminar un trabajo si aún no fue comenzado.
  - Ver su histórico de trabajos.
- Validaciones: no se admiten cantidades negativas o cero.

## Diseño

Interfaz construida con **JFrame/JPanel** y datos manejados en **arrays** (sin base de
datos, según consigna). Las ventanas (`Ventana*.java`) actúan como contenedores por rol
y los paneles (`Panel*.java`) resuelven cada funcionalidad concreta. Modelos `Usuario` y
`Trabajo`, con estado compartido en `Variables`.

```
src/TrabajoFinal/
  main.java                 # punto de entrada
  VentanaLogin.java         # ingreso con clave
  VentanaAdmin.java         # contenedor del rol administrador
  VentanaUser.java          # contenedor del rol usuario
  PanelListaUsuarios.java   # gestión/listado de usuarios (admin)
  PanelNuevoUsuario.java    # alta de usuario (admin)
  PanelListaTrabajos.java   # listado y cambio de estado de trabajos
  PanelNuevoTrabajo.java    # pedido de trabajo (usuario)
  Usuario.java Trabajo.java Variables.java
docs/
  consigna.txt              # enunciado original
  Informe.pdf               # informe del trabajo (descripción + capturas)
```

## Compilar y ejecutar

```bash
cd src
javac TrabajoFinal/*.java module-info.java
java TrabajoFinal.main
```

(O importar el proyecto en Eclipse / IntelliJ y ejecutar `main`.)

## Autor / Author

Manuel González Janin
