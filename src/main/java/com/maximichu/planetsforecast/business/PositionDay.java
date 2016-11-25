package com.maximichu.planetsforecast.business;

import com.maximichu.planetsforecast.model.Planet;
import com.maximichu.planetsforecast.model.Position;
import org.springframework.stereotype.Component;

@Component
public class PositionDay {

    public static Integer GRAD_CIRCUNF = 360;

    public static Position getPosition(Planet planeta, Integer dia) {
        Double posicionAngular = getPosicionAngular(planeta, dia);
        Double x = getXPosition(planeta, posicionAngular);
        Double y = getYPosition(planeta, posicionAngular);
        Position position = new Position(posicionAngular, x, y);
        return position;
    }

    private static Double getPosicionAngular(Planet planet, Integer dia) {
        Double posicionAngular = planet.getVelocity() * dia;

        if (posicionAngular >= GRAD_CIRCUNF) {
            posicionAngular = GRAD_CIRCUNF - posicionAngular;
        }

        if (posicionAngular != 0 && planet.getClockwise() != 1) {
            posicionAngular = Math.abs(posicionAngular - GRAD_CIRCUNF);
        }
        return posicionAngular;
    }

    private static Double getXPosition(Planet planet, Double posicionAngular){
        Double x = 0.0;

        if (posicionAngular != 90 && posicionAngular != 270) {
            x = planet.getDistance() * Math.cos(posicionAngular * Math.PI / 180);
        }
        return x;
    }

    private static Double getYPosition(Planet planet, Double posicionAngular) {
        Double y = 0.0;

        if (posicionAngular != 180) {
            y = planet.getDistance() * Math.sin(posicionAngular * Math.PI / 180);
        }
        return y;
    }

}
