package com.maximichu.planetsforecast.enums;

public enum DistanciaAlSol {
    FERENGI(500.0),
    BETASOIDE(2000.0),
    VULCANO(1000.0);

    private final double distancia;

    DistanciaAlSol(Double distancia) {
        this.distancia = distancia;
    }

    public double getDistancia() {
        return distancia;
    }
}
