package com.maximichu.planetsforecast.business;

import com.maximichu.planetsforecast.model.ForecastType;
import com.maximichu.planetsforecast.model.Planet;
import com.maximichu.planetsforecast.model.Position;
import org.springframework.stereotype.Component;
import com.maximichu.planetsforecast.utils.Constantes;

@Component
public class PlanetsForecast implements IForecastPrediction {


    @Override
    public ForecastType calculateForecast(Integer years) {

        this.iniciarPrediccion();

        ForecastType forecastType = new ForecastType();

        // Calcular cantidad de sequias.
        Integer cantSequias = calcularCantidadSequia(years);
        forecastType.setCantidadSequias(cantSequias);

        // Calcular cantidad de lluvias.
        Integer cantLluvias = calcularCantidadLluvia(years);
        forecastType.setCantidadLluvias(cantLluvias);

        // Calcular dia maximo de lluvia.
        Integer diaMaximoLluvias = calcularDiaMaximoLluvia(years);
        forecastType.setDiaMaximoLluvias(diaMaximoLluvias);

        // Calcular cantidad de dias optimos.
        Integer cantDiasOptimos = calcularCondicionesOptimas(years);
        forecastType.setCantidadCondOptimas(cantDiasOptimos);

        return forecastType;
    }

    @Override
    public Integer calcularCantidadSequia(Integer years) {
        return 10;
    }

    @Override
    public Integer calcularCantidadLluvia(Integer years) {
        return 200;
    }

    @Override
    public Integer calcularCondicionesOptimas(Integer years) {
        return 15;
    }

    @Override
    public Integer calcularDiaMaximoLluvia(Integer years) {
        return 156;
    }

    private void iniciarPrediccion() {
        Planet ferengi = new Planet(Constantes.FERENGI, Constantes.DIST_FERENGI, Constantes.VEL_FERENGI, Constantes.ROT_FERENGI);
        Planet betasoide = new Planet(Constantes.BETASOIDE, Constantes.DIST_BETASOIDE, Constantes.VEL_BETASOIDE, Constantes.ROT_BETASOIDE);
        Planet vulcano = new Planet(Constantes.VULCANO, Constantes.DIST_VULCANO, Constantes.VEL_VULCANO, Constantes.ROT_VULCANO);
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
