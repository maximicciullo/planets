package com.maximichu.planetsforecast.business;

import com.maximichu.planetsforecast.model.ForecastType;
import com.maximichu.planetsforecast.model.Planet;
import com.maximichu.planetsforecast.model.Position;
import com.maximichu.planetsforecast.model.PredictionType;
import org.springframework.stereotype.Component;
import com.maximichu.planetsforecast.utils.Constantes;

@Component
public class PlanetsForecast {

    private ForecastType forecastType;

    @Override
    public ForecastType calculateForecast(Integer years) {

        Integer aniosEnDias = years * Constantes.ANIO_EN_DIAS;

        this.iniciarPrediccion();

        ForecastType forecastType = new ForecastType();


        for (int i = 1; i <= aniosEnDias; i++) {

            // Obtener la prediccion para el dia.
            PredictionType prediccionDelDia = obtenerPrediccionDia(i);

            // Persistir la prediccion del dia.

            // Actualizar cantidades del pronostico.
            actualizarCantidadesPronostico(prediccionDelDia);
        }

        return forecastType;
    }

    public PredictionType obtenerPrediccionDia(int dia) {
        PredictionType predictionType = new PredictionType(dia);

    }

    public void actualizarCantidadesPronostico(PredictionType predictionType) {

    }

    private void iniciarPrediccion() {
        Planet ferengi = new Planet(Constantes.FERENGI, Constantes.DIST_FERENGI, Constantes.VEL_FERENGI, Constantes.ROT_FERENGI);
        Planet betasoide = new Planet(Constantes.BETASOIDE, Constantes.DIST_BETASOIDE, Constantes.VEL_BETASOIDE, Constantes.ROT_BETASOIDE);
        Planet vulcano = new Planet(Constantes.VULCANO, Constantes.DIST_VULCANO, Constantes.VEL_VULCANO, Constantes.ROT_VULCANO);

        // Inicializar contadores;
        forecastType = new ForecastType();
    }

    private Position getPosition(Planet planeta, Integer dia) {
        Double posicionAngular = getPosicionAngular(planeta, dia);
        Double x = getXPosition(planeta, posicionAngular);
        Double y = getYPosition(planeta, posicionAngular);
        Position position = new Position(posicionAngular, x, y);
        return position;
    }

    private Double getPosicionAngular(Planet planet, Integer dia) {
        Double posicionAngular = planet.getVelocity() * dia;

        if (posicionAngular >= Constantes.GRAD_CIRCUNF) {
            posicionAngular = Constantes.GRAD_CIRCUNF - posicionAngular;
        }

        if (posicionAngular != 0 && planet.getClockwise() != 1) {
            posicionAngular = Math.abs(posicionAngular - Constantes.GRAD_CIRCUNF);
        }
        return posicionAngular;
    }

    private Double getXPosition(Planet planet, Double posicionAngular){
        Double x = 0.0;

        if (posicionAngular != 90 && posicionAngular != 270) {
            x = planet.getDistance() * Math.cos(posicionAngular * Math.PI / 180);
        }
        return x;
    }

    private Double getYPosition(Planet planet, Double posicionAngular) {
        Double y = 0.0;

        if (posicionAngular != 180) {
            y = planet.getDistance() * Math.sin(posicionAngular * Math.PI / 180);
        }
        return y;
    }
}
