Planets Forecast
=============

This is a project that has the goal to predict the weather between 3 planets and the Sun. It is using Spring MVC + Redis NoSQL. 

The main goal of the project is to do a particular logical excercise just to determine when will happen differents wheather conditions since the position between the planets and the Sun.

Yuo would use two different endpoints to get the information:

1) Example: http://localhost:8080 - Will give you a page where you can complete with the number of years to get a pronostic. Then you can watch as response all the weather information.

2) As an API you can hit http://localhost:8080/forecast/123 and you will get as response a JSON object like {"dia":123,"clima":"LLUVIA"}

As you can imagine... /forecast/123 is the way to generate the request to the API and '123' is the day number to get the forecast weather.
