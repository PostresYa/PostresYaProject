![]("/src/main/resources/static/app/images/Logo.png")
##Escuela Colombiana de Ingeniería
##Construcción de Software - COSW
## PostresYaProject

###Introducción

Muchas personas amantes de los postres, no pueden acceder a ellos por falta de tiempo, se busca ayudarlos a adquirirlos sin que ellos tengan que moverse de su ubicación; también se pretende que las reposterías amplíen su negocio por medio de Postres ya, las cuales tendrán un rango de domicilios, en el cual estas consideran que no sufren pérdidas.

En el siguiente proyecto, se trabajaran las siguientes historias de usuario:
   * Historia de usuario registrar postre.
   * Historia de usuario consultar pedidos.
   * Historia de usuario registrar repostería.


###Integrantes

El proyecto PostresYa fue creado por:

 - Duván Barrera.
 - Giovanny Sissa.
 - Wilmer Cortez.
 - Diego Rodriguez.


###Descripción del proyecto


Este proyecto estara basado en el siguiente diagrama de clases,para satisface las historias de usuario

![]("/src/main/resources/static/app/images/DiagramaDeClases.PNG")
###Tabla de contenido
1.  Inicio de sesión.
2.  Registro de una repostería.
3.  Registro de un postre.
4.  Consulta de postres.
5.  Consulta de estado de los pedidos.

###Inicio de sesión

Para iniciar sesión como una repostería ingrese a esta [dirección](http://projectpostresya.herokuapp.com/app/index.html#/viewLogin),
una vez allí ingrese los datos de usuario( nit y password) y oprima el botón Submit.

###Registro de una repostería

Si desea registrarse en la página web ingrese al link de inicio de sesión, y oprima el botón Regístrese, allí encontrara una          validación con el INVIMA para saber si tiene el registro de sanidad vigente, de tenerlo vigente se habilitaran los demás campos       necesarios para completar el registro, de no tenerlo no podrá registrarse en postresYa.
  
###Registro de un postre

Una vez autenticado en la aplicación ingrese a la vista -REGISTRAR UN NUEVO POSTRE-, e ingrese los datos necesarios para añadir un nuevo postre, en caso de que el código del postre ya este registrado, se podrá elegir si se actualiza la información del postre o se cancela la operación.
  
###Consulta de postres

Una vez autenticado en la aplicación ingrese a la vista -POSTRES-, allí se mostraran todos los postres que tiene registrados la       repostería y podrá ordenarlos por nombre, código o precio.
  
###Consulta del estado de los pedidos

Una vez autenticado en la aplicación ingrese a la vista -LISTA DE PEDIDOS-, allí se mostraran los pedidos que tiene la repostería y podrá ordenarlos por código, fecha o estado; cada pedido tendrá dos botones:
   * -cambiar estado-, con el cual podrá cambiar el estado del pedido de en espera ha enviado, si ya se encuentra enviado le             recordara que no puede cambiar el estado.
   * -detalles-, con el cual podrá observar el detalle de todos los postres que pertenecen al pedido en particular.





