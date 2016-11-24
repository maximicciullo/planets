package com.maximichu.planetsforecast.service;


import com.maximichu.planetsforecast.model.ForecastType;
import com.maximichu.planetsforecast.model.PredictionType;

public interface WeatherService {

    void generarPronostico();
    ForecastType calcularPronostico(int years);
    PredictionType obterPrediccionPorDia(int dia);
}
