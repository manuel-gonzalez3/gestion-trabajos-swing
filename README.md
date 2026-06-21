# Gestión de Trabajos — Fotocopiadora (Java Swing)

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

Interfaz construida con **JFrame** y datos manejados en **arrays** (sin base de datos,
según consigna). Una ventana (`Ventana*.java`) por pantalla, modelos `Usuario` y
`Trabajo`, y estado compartido en `Variables`.

```
src/TrabajoFinal/
  main.java                 # punto de entrada
  VentanaLogin.java
  VentanaAdmin.java VentanaUser.java
  VentanaUsuarios.java VentanaNuevoTrabajo.java VentanaTrabajos.java
  VentanaModificarUsuario.java
  Usuario.java Trabajo.java Variables.java
docs/consigna.txt           # enunciado original
```

## Compilar y ejecutar

```bash
cd src
javac TrabajoFinal/*.java module-info.java
java TrabajoFinal.main
```

(O importar el proyecto en Eclipse / IntelliJ y ejecutar `main`.)

## Autor

Manuel González Janin
