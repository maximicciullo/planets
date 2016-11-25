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

    @Autowired
    protected PlanetsForecast planetsForecast;

    @Autowired
    protected PredictionTypeRepository predictionTypeRepository;

    @Override
    public void generarPronostico() {
        // Generar pronostico para los proximos 10 anios
        planetsForecast.calculateForecast(10);
    }

    @Override
    public ForecastType calcularPronostico(int years) {
       return planetsForecast.calculateForecast(years);
    }

    @Override
    public PredictionType obterPrediccionPorDia(int dia) {
       return predictionTypeRepository.findPrediction(dia);
    }
}
