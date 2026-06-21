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

## Autor

Manuel González Janin
