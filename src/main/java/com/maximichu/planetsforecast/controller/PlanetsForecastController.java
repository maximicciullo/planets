package com.maximichu.planetsforecast.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.maximichu.planetsforecast.model.ForecastType;
import com.maximichu.planetsforecast.model.Prediction;
import com.maximichu.planetsforecast.model.PredictionType;
import com.maximichu.planetsforecast.repo.PredictionTypeRepository;
import com.maximichu.planetsforecast.service.WeatherService;
import com.maximichu.planetsforecast.utils.Constantes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
public class PlanetsForecastController {

    @Autowired
    protected WeatherService weatherService;

    /**
     * Enpoint para consultar las predicciones de los planetas.
     * Dada la cantidad de años, informa la cantidad de dias de seguia, cantidad de dias de lluvias,
     * cantidad de dias de condiciones optimas y dia de pico maximo de lluvia.
     *
     * @param model
     * @param years
     * @return - PlanetForecastType indicando toda la informacion a mostrar.
     */
    @RequestMapping(value = "/planetForecast", method = RequestMethod.POST)
    public ModelAndView planetForecast(Map<String, Object> model, @RequestParam("years") String years) {

        // Calcular prediccion de tiempo para los años que se pasan por parametro
        model.put("years", years);

        ForecastType forecast = weatherService.calcularPronostico(Integer.valueOf(years)) ;

        model.put("cantSequias", forecast.getCantidadSequias());
        model.put("cantLluvias", forecast.getCantidadLluvias());
        model.put("diaPicoMax", forecast.getDiaMaximoLluvias());
        model.put("cantCondOpt", forecast.getCantidadCondOptimas());

        return new ModelAndView("listForecast");
    }

    /**
     * Endpoint que informa la condicion climatica del dia consultado enviado
     * por parametro en la url. Retorna la informacion en formato JSON.
     *
     * @param model
     * @param day
     * @return jsonObject con la informacion del dia y el clima correspondiente.
     */
    @RequestMapping(value = "forecast/{day}", method = RequestMethod.GET, produces = "application/json")
    public ModelAndView forecast(Map<String, Object> model, @PathVariable("day") Integer day) throws JsonProcessingException {

        weatherService.generarPronostico();

        // Buscar el pronostico para el dia pasado por parametro y retornarlo como json object.
        PredictionType predictionType = weatherService.obterPrediccionPorDia(day);

        // Creo el objeto Prediction para mostrar el json de la API.
        Prediction prediction = new Prediction(predictionType.getId(), predictionType.getEstadoClima());

        // Genreo el Objeto JSON.
        String jsonString = Constantes.JSON_MAPPER.writeValueAsString(prediction);

        model.put("jsonObject", jsonString);

        return new ModelAndView("forecastDay");
    }
}