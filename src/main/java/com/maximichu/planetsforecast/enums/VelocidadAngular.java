package com.maximichu.planetsforecast.enums;

public enum VelocidadAngular {
    FERENGI(1.0),
    BETASOIDE(3.0),
    VULCANO(5.0);

    private final double velocidad;

    VelocidadAngular(Double velocidad) {
        this.velocidad = velocidad;
    }

    public double getVelocidad() {
        return velocidad;
    }
}
