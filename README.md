# Aplicación Web de Gramíneas

Esta aplicación web permite almacenar y mostrar una lista de gramíneas con su ID, nombre común, nombre científico, descripción e imagen. La aplicación está construida con Android Studio y utiliza un servidor web que ejecuta PHP para interactuar con una base de datos MySQL, donde se almacenan los datos de las gramíneas.

La lista de gramíneas se muestra en la aplicación web, y al seleccionar una gramínea, se muestra una nueva ventana con los detalles completos de la planta.

## Características

- **Visualización de Gramíneas:** Muestra una lista de gramíneas con los campos: ID, nombre común, nombre científico, descripción e imagen.
- **Detalles de Gramíneas:** Al seleccionar una gramínea de la lista, se abre una nueva ventana con los detalles completos, incluyendo una imagen.
- **Gestión de Datos:** Los datos de las gramíneas se almacenan en una base de datos MySQL a través de un servidor PHP que maneja las consultas.
- **Interfaz Web:** La aplicación tiene una interfaz web sencilla que se puede ver y usar desde dispositivos móviles y escritorios.

## Requisitos

### Requisitos del Servidor Web

1. **PHP**: La aplicación utiliza PHP para procesar las solicitudes HTTP y gestionar las consultas de la base de datos MySQL.
2. **MySQL**: Se requiere MySQL para almacenar los datos de las gramíneas.
3. **Servidor Web**: Puede utilizar Apache, Nginx, o cualquier otro servidor que soporte PHP y MySQL.

### Requisitos del Cliente (Android Studio)

1. **Android Studio**: La aplicación está desarrollada utilizando Android Studio.
2. **Permisos de Internet**: Se requiere el permiso de acceso a Internet para hacer solicitudes HTTP al servidor y recibir datos.

```xml
<uses-permission android:name="android.permission.INTERNET"/>
