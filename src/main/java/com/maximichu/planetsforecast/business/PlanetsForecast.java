package com.maximichu.planetsforecast.business;

import com.maximichu.planetsforecast.model.ForecastType;
import com.maximichu.planetsforecast.model.Planet;
import com.maximichu.planetsforecast.model.Position;
import com.maximichu.planetsforecast.model.PredictionType;
import org.springframework.stereotype.Component;
import com.maximichu.planetsforecast.utils.Constantes;

@Component
public class PlanetsForecast {

    // contiene los contadores.
    private ForecastType forecastType;

    public ForecastType calculateForecast(Integer years) {

        Integer aniosEnDias = years * Constantes.ANIO_EN_DIAS;

        //this.iniciarPrediccion();

        ForecastType forecastType = new ForecastType();


        for (int i = 1; i <= aniosEnDias; i++) {

            // Obtener la prediccion para el dia.
            PredictionType prediccionDelDia = obtenerPrediccionDia(i);

            // Persistir la prediccion del dia.

            // Actualizar cantidades del pronostico.
            actualizarCantidadesPronostico(forecastType);
        }

        return forecastType;
    }

    public PredictionType obtenerPrediccionDia(int dia) {
        PredictionType predictionType = new PredictionType(dia);

    }

    public void actualizarCantidadesPronostico(ForecastType forecastType) {

    }

    /*
    private void iniciarPrediccion() {
        Planet ferengi = new Planet(Constantes.FERENGI, Constantes.DIST_FERENGI, Constantes.VEL_FERENGI, Constantes.ROT_FERENGI);
        Planet betasoide = new Planet(Constantes.BETASOIDE, Constantes.DIST_BETASOIDE, Constantes.VEL_BETASOIDE, Constantes.ROT_BETASOIDE);
        Planet vulcano = new Planet(Constantes.VULCANO, Constantes.DIST_VULCANO, Constantes.VEL_VULCANO, Constantes.ROT_VULCANO);

        // Inicializar contadores;
        forecastType = new ForecastType();
    }*/


}
