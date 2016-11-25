package com.maximichu.planetsforecast.service;

import com.maximichu.planetsforecast.business.PlanetsForecast;
import com.maximichu.planetsforecast.model.ForecastType;
import com.maximichu.planetsforecast.model.PredictionType;
import com.maximichu.planetsforecast.repo.PredictionTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
/**
 * Implementacion del servicio climatico
 */
public class WeatherImp implements WeatherService {

    protected static int ANIOS_PREDICCION = 10;

    @Autowired
    protected PlanetsForecast planetsForecast;

    @Autowired
    protected PredictionTypeRepository predictionTypeRepository;

    @Override
    public ForecastType calcularPronostico(int years) {
       return planetsForecast.calculateForecast(years);
    }

    @Override
    public PredictionType obterPrediccionPorDia(int dia) {
        planetsForecast.calculateForecast(ANIOS_PREDICCION);
        return predictionTypeRepository.findPrediction(dia);
    }
}
