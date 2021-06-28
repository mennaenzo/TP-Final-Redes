# TP-Final-Redes

### Instalación 
En la carpeta _Builds_ encontraremos dos aplicaciones, el servidor y el cliente.
1. Primero debemos ejecutar el servidor ubicado en la carpeta _Server_ especificando un número de puerto (por ejemplo 3000)
```
java -jar ./Sockets.jar 3000
```
2. Luego debemos repetir el mismo paso con el cliente ubicado en la carpeta _Client_, pero ahora especificando nombre del host y número de puerto al que deseamos conectarnos.
```
java -jar ./Sockets-Client.jar localhost 3000
```

### Crear un modelo cliente - servidor utilizando TCP/IP Sockets a partir de los siguientes puntos:

* Crear un servidor:
  * Debe aceptar conexiones entrantes
  * Usar el port number 3000 
  * Utilizar telnet para emular el lado del cliente, y realizar conexiones entrantes
(Para desarrollar el lado del servidor)    
  * Recibir data en el TCP/IP socket (Utilizar telnet para emular dicho
comportamiento)    
  * La data enviada debe ser texto y se debe mostrar en la consola tanto del lado
del cliente como del servidor los mensajes enviados / recibidos.    
  * Utilizar una aplicación telnet de celular para mandar datos al server    
  * Utilizar el hostname en vez de la IP para mandar información    
  * Verificar que el firewall tenga en inbound rules los permisos correctos para la
entrada y salida de data.    
  * El servidor debe tener la funcionalidad de poder responderle al cliente.    
  * Si el usuario presiona ‘X’, se corta la conexion. La conexión se debe poder
terminar tanto del lado del cliente como del servidor.
* Crear un cliente:
  * Debe poder conectarse con un servidor por medio de la IP y el puerto. Dichos
datos se ingresan por consola (configurables). Puede haber más de un cliente
corriendo.
  * Manejar los errores si el usuario ingresa mal la dirección IP y el puerto, y
devolver un mensaje coherente.
  * Mostrar el estado de conexión paso a paso.
  * El cliente debe poder tanto enviar como recibir data.
