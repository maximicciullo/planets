package com.maximichu.planetsforecast.enums;

public enum Clima {
    HUMEDO("LLUVIA"),
    SECO("SECO"),
    OPTIMO("OPTIMO"),
    NO_DEFINIDO("NO DEFINIDO");

    private final String clima;

    Clima(String clima) {
        this.clima = clima;
    }

    public String getClima() {
        return clima;
    }
}
