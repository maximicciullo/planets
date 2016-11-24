package com.maximichu.planetsforecast.controller;

import com.maximichu.planetsforecast.business.PlanetsForecast;
import com.maximichu.planetsforecast.model.ForecastType;
import com.maximichu.planetsforecast.model.PredictionType;
import com.maximichu.planetsforecast.repo.PredictionTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@Controller
public class PlanetsForecastController {

    @Autowired
    protected PlanetsForecast planetsForecast;

    @Autowired
    protected PredictionTypeRepository predictionTypeRepository;

    /**
     * Enpoint para consultar las predicciones de los planetas.
     * Dada la cantidad de años, informa la cantidad de dias de seguia, cantidad de dias de lluvias,
     * cantidad de dias de condiciones optimas y dia de pico maximo de lluvia.
     *
     * @param request
     * @param response
     * @param model
     * @param years
     * @return - PlanetForecastType indicando toda la informacion a mostrar.
     */
    @RequestMapping(value = "/planetForecast", method = RequestMethod.POST)
    public ModelAndView planetForecast(HttpServletRequest request, HttpServletResponse response,
                                       Map<String, Object> model, @RequestParam("years") String years) {

        // Calcular prediccion de tiempo para los años que se pasan por parametro
        model.put("years", years);

        ForecastType forecast = planetsForecast.calculateForecast(Integer.valueOf(years)) ;

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
     * @param request
     * @param response
     * @param model
     * @param day
     * @return
     */
    @RequestMapping(value = "forecast/{day}", method = RequestMethod.GET)
    public ModelAndView forecast(HttpServletRequest request, HttpServletResponse response,
                                 Map<String, Object> model, @PathVariable("day") Integer day) {

        // Generar pronostico para los proximos 10 anios
        planetsForecast.calculateForecast(10);

        // Buscar el pronostico para el dia pasado por parametro y retornarlo como json object.
        PredictionType prediction = predictionTypeRepository.findPrediction(day);

        // ahora lo mando a la view por el momento
        model.put("day", prediction.getId());
        model.put("estadoClima", prediction.getEstadoClima());

        return new ModelAndView("forecastDay");
    }
}