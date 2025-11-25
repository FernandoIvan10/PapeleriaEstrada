# Sistema de Gestión para Papelería Estrada

Sistema desarrollado en **2022** como proyecto académico y funcional para la papelería **Papelería Estrada**.  
Permite gestionar ventas, compras, inventario, productos, proveedores y usuarios mediante una interfaz construida con **Java Swing** y una base de datos **PostgreSQL**.

## Características principales

- **Autenticación**
  - Inicio de sesión para dueño y vendedores.
  - Registro de nuevos vendedores.

- **Gestión de productos**
  - Alta de productos.
  - Búsqueda de productos.
  - Actualización de datos.
  - Visualización del inventario.

- **Módulo de ventas**
  - Agregar productos a la venta.
  - Registrar ventas.
  - Buscar ventas.
  - Eliminar ventas.

- **Módulo de compras**
  - Agregar productos a compras.
  - Registrar compras.
  - Buscar compras.
  - Eliminar compras.

- **Gestión de proveedores**
  - Alta de proveedores.
  - Búsqueda.
  - Actualización de datos.

## Funcionalidades pendientes

- Generación de reportes (producto más vendido, mejor vendedor, mejor proveedor, ventas, compras).
- Botón de cerrar sesión.

## Mejoras pendientes

- Corregir triggers que ajustan el stock al eliminar ventas/compras.
- Validación del dueño mediante consulta a la BD (actualmente comparación estática).
- Evitar duplicado de filas al refrescar el inventario.
- Actualizar automáticamente la información al cambiar de módulo.
- Actualizar productos desde el formulario (no desde la tabla).
- Mejorar nombres de variables, estructura interna y agregar comentarios.
- Uso de variables de entorno.
- Mejorar la organización completa del proyecto.

## Tecnologías utilizadas

- **Lenguaje:** Java (JDK 21)
- **IDE:** NetBeans
- **Interfaz gráfica:** Java Swing
- **Base de datos:** PostgreSQL
- **Conexión:** JDBC
- **Librerías externas:**
  - Autocompleter
  - JasperReport
  - JCalendar

## Requisitos previos

Asegúrate de tener instalado:

- Java JDK 21  
- PostgreSQL  
- NetBeans (o cualquier otro IDE compatible)  
- Conector JDBC de PostgreSQL  

## Configuración del proyecto

1. Clona este repositorio:

   ```bash
   git clone https://github.com/FernandoIvan10/PapeleriaEstrada
   cd PapeleriaEstrada
   ```

2. Importa el proyecto en NetBeans.

3. Crea una Base de datos con PostgreSQL

4. Configura el archivo `Conexion.java` asignando el valor de los siguientes parámetros según tu Base de Datos:

   - Host, puerto y nombre de la Base de Datos (URL, conexión JDBC)
   - Usuario
   - Contraseña

5. Ejecuta los scripts SQL incluidos en el repositorio para crear la base de datos, tablas, funciones y triggers.

6. Ejecuta el proyecto desde NetBeans.

## Nota
El código refleja el estado del proyecto tal como fue desarrollado durante el periodo académico.

## Autores
- Fernando Iván.
- Zaraida.


## Licencia
Proyecto académico creado con fines educativos. No se autoriza su uso comercial sin permiso de los autores.