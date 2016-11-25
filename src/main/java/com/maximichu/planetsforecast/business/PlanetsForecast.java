package com.maximichu.planetsforecast.business;

import com.maximichu.planetsforecast.enums.Clima;
import com.maximichu.planetsforecast.model.ForecastType;
import com.maximichu.planetsforecast.model.PredictionType;
import com.maximichu.planetsforecast.repo.PredictionTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PlanetsForecast {

    public static Integer ANIO_EN_DIAS = 365;

    @Autowired
    private WeatherPrediction weatherPrediction;

    @Autowired
    private PredictionTypeRepository predictionTypeRepository;

    private Double picoMaximoLluvias = new Double(0.00);

    public ForecastType calculateForecast(Integer years) {

        Integer aniosEnDias = years * ANIO_EN_DIAS;

        ForecastType forecastType = new ForecastType();

        // Iterar todos los dias del total de anios para calcular el pronostico.
        for (int i = 1; i <= aniosEnDias; i++) {

            // Obtener la prediccion para el dia.
            PredictionType prediccionDelDia = obtenerPrediccionDia(i);

            // Persistir la prediccion del dia.
            predictionTypeRepository.savePrediction(prediccionDelDia);

            // Actualizar cantidades del pronostico.
            actualizarCantidadesPronostico(prediccionDelDia, forecastType);
        }

        return forecastType;
    }

    public PredictionType obtenerPrediccionDia(int dia) {
        PredictionType predictionType = new PredictionType(dia);
        predictionType = weatherPrediction.prediction(predictionType);
        return predictionType;
    }

    public void actualizarCantidadesPronostico(PredictionType prediccionDia, ForecastType forecastType) {
        if (prediccionDia.getEstadoClima().equalsIgnoreCase(Clima.SECO.getClima())) {
            forecastType.setCantidadSequias(forecastType.getCantidadSequias() + 1);
        } else if (prediccionDia.getEstadoClima().equalsIgnoreCase(Clima.OPTIMO.getClima())) {
            forecastType.setCantidadCondOptimas(forecastType.getCantidadCondOptimas() + 1);
        } else {
            forecastType.setCantidadLluvias(forecastType.getCantidadLluvias() + 1);
            if (picoMaximoLluvias < prediccionDia.getPerimetro()) {
                picoMaximoLluvias = prediccionDia.getPerimetro();
                forecastType.setDiaMaximoLluvias(prediccionDia.getId());
            }
        }
    }
}
