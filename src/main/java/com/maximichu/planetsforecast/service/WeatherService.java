package com.maximichu.planetsforecast.service;


import com.maximichu.planetsforecast.model.ForecastType;
import com.maximichu.planetsforecast.model.PredictionType;

/**
 * Servicio encargado de proveer toda a informacion
 * relacionada para el pronostico de los planetas.
 */
public interface WeatherService {

    /**
     * Obtiene el pronositco del tiempo para los anios
     * indicados por parametro.
     *
     * @param years
     * @return ForecastType
     */
    ForecastType calcularPronostico(int years);

    /**
     * Obtiene las condiciones meteorologicas
     * para un dia en particular del pronostico.
     *
     * @param dia
     * @return PredictionType
     */
    PredictionType obterPrediccionPorDia(int dia);
}
