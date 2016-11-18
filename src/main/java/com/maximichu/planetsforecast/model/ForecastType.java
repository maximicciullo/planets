package com.maximichu.planetsforecast.model;


public class ForecastType {

    private Integer cantidadSequias;
    private Integer cantidadLluvias;
    private Integer diaMaximoLluvias;
    private Integer cantidadCondOptimas;



    public ForecastType() {

    }

    public ForecastType(Integer cantSequias, Integer cantLluvias, Integer diaMaxLluvias, Integer cantCondOpt) {
        this.cantidadSequias = cantSequias;
        this.cantidadLluvias = cantLluvias;
        this.diaMaximoLluvias = diaMaxLluvias;
        this.cantidadCondOptimas = cantCondOpt;
    }

    public Integer getCantidadSequias() {
        return cantidadSequias;
    }

    public void setCantidadSequias(Integer cantidadSequias) {
        this.cantidadSequias = cantidadSequias;
    }

    public Integer getCantidadLluvias() {
        return cantidadLluvias;
    }

    public void setCantidadLluvias(Integer cantidadLluvias) {
        this.cantidadLluvias = cantidadLluvias;
    }

    public Integer getDiaMaximoLluvias() {
        return diaMaximoLluvias;
    }

    public void setDiaMaximoLluvias(Integer diaMaximoLluvias) {
        this.diaMaximoLluvias = diaMaximoLluvias;
    }

    public Integer getCantidadCondOptimas() {
        return cantidadCondOptimas;
    }

    public void setCantidadCondOptimas(Integer cantidadCondOptimas) {
        this.cantidadCondOptimas = cantidadCondOptimas;
    }

}
