Planets Forecast
=============

This is a project that has the goal to predict the weather between 3 planets and the Sun. 

The main goal of the project is to do a particular logical excercise just to determine when will happen differents wheather conditions since the position between the planets and the Sun.

The project is using Spring MVC + Redis NoSQL. You need to get an instanse of Redis Server up and running in order to use the application. To get more information please visit http://redis.io/download 

After download Redis you can initialize the server as './src/redis-server'

Yuo would use two different endpoints to get the information:

1) Example: http://localhost:8080 - Will give you a page where you can complete with the number of years to get a pronostic. Then you can watch as response all the weather information.

2) As an API you can hit http://localhost:8080/forecast/123 and you will get as response a JSON object like {"dia":123,"clima":"LLUVIA"}

As you can imagine... /forecast/123 is the way to generate the request to the API and '123' is the day number to get the forecast weather.

If you wanna test how the application works, an EC2 instance was created running Tomcat8 and Redis. You can hit the endpoints and take a look at the result as follow:

CHECK FORECAST FOR ANY YEARS:
http://ec2-35-164-45-250.us-west-2.compute.amazonaws.com:8080

CHECK FORECAST FOR A PARTICULAR DAY:
http://ec2-35-164-45-250.us-west-2.compute.amazonaws.com:8080/forecast/120

=============

Este proyecto tiene por objetivo predecir el pronostico del tiempo entre 3 Planetas y el Sol.

El objetivo principal del proyecto is hacer un ejercicio de logica para determinar cuando van a suceder diferentes condiciones climaticas a partir de la posicion de los Planetas respecto al Sol.

El proyecto utiliza la teconogia de Spring MVC Framework y la persistencia de datos en memoria por medio de Redis. Para ello fue necesario generar una instancia de Redis Server corriendo. Tambien se instalo un Server Tomcat para correr el war de la aplicacion.

Se pueden utilizar dos diferentes endpoint que brinda la aplicacion:

Ejemplo 1: http://localhost:8080 Nos va a mostrar una pagina en donde se puede introducir un numero que haga referencia a los anios a predecir el pronostico del tiempo. Luego haciendo un submit se puede observar la informacion del tiempo para esa cantidad de anios futuros.

Ejemplo 2: Como API se puede consultar http://localhost:8080/forecast/123 y se obtendra como respuesta un Objeto JSON indicando el dia y el clima para ese dia, de la forma {"dia":123,"clima":"LLUVIA"}

La forma de hacer el llamado es haciendo '/forecast/123' donde '123' hace referencia al numero de dia a consultar el pronostico del clima.

Se se quiere ver como funciona la aplicacion sin generar el proyecto y configurar los servidores se puede ingresar a los siguientes links. Para esto se creo un Instancia EC2 en un servidor de Amazon Cloud (AWS) instalando servidores Tomcat 8 y Redis. 

CHEQUEAR PRONOSTICO PARA CUALQUIER ANIO:
http://ec2-35-164-45-250.us-west-2.compute.amazonaws.com:8080

CHEQUEAR PRONOSTICO PARA UN DIA EN PARTICULAR:
http://ec2-35-164-45-250.us-west-2.compute.amazonaws.com:8080/forecast/120
