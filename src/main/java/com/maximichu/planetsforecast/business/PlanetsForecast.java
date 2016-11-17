package com.maximichu.planetsforecast.business;

import com.maximichu.planetsforecast.model.ForecastType;
import org.springframework.stereotype.Component;

@Component
public class PlanetsForecast implements IForecastPrediction {


    @Override
    public ForecastType calculateForecast(Integer years) {

        ForecastType forecastType = new ForecastType();

        // Calcular cantidad de sequias.

        // Calcular cantidad de lluvias.

        // Calcular dia maximo de lluvia.

        // Calcular cantidad de dias optimos.

        return forecastType;
    }


}
