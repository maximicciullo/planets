package com.maximichu.planetsforecast.enums;

public enum SentidoRotacion {
    FERENGI(1),
    BETASOIDE(1),
    VULCANO(-1);

    private final int sentidoRotacion;

    SentidoRotacion(int sentidoRotacion) {
        this.sentidoRotacion = sentidoRotacion;
    }

    public int getSentidoRotacion() {
        return sentidoRotacion;
    }
}
