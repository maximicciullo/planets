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
