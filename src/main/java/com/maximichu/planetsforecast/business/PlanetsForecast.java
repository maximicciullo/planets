package com.maximichu.planetsforecast.business;

        import com.maximichu.planetsforecast.model.ForecastType;
        import com.maximichu.planetsforecast.model.PredictionType;
        import com.maximichu.planetsforecast.utils.Constantes;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Component;

@Component
public class PlanetsForecast {

    @Autowired
    private WeatherPrediction weatherPrediction;

    private Double picoMaximoLluvias = new Double(0.00);

    public ForecastType calculateForecast(Integer years) {

        Integer aniosEnDias = years * Constantes.ANIO_EN_DIAS;

        ForecastType forecastType = new ForecastType();

        // Iterar todos los dias del total de anios para calcular el pronostico.
        for (int i = 1; i <= aniosEnDias; i++) {

            // Obtener la prediccion para el dia.
            PredictionType prediccionDelDia = obtenerPrediccionDia(i);

            // Persistir la prediccion del dia.

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
        if (prediccionDia.getEstadoClima().equalsIgnoreCase(Constantes.CLIMA_SECO)) {
            forecastType.setCantidadSequias(forecastType.getCantidadSequias() + 1);
        } else if (prediccionDia.getEstadoClima().equalsIgnoreCase(Constantes.CLIMA_OPTIMO)) {
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
