package com.maximichu.planetsforecast.model;


public class ForecastType {

    private Integer cantidadSequias;
    private Integer cantidadLluvias;
    private Integer diaMaximoLluvias;
    private Integer cantidadCondOptimas;
    private Double  maximoPrecipitaciones;


    public ForecastType() {
        this.cantidadSequias = 0;
        this.cantidadLluvias = 0;
        this.cantidadCondOptimas = 0;
        this.cantidadCondOptimas = 0;
        this.maximoPrecipitaciones = 0.0;
    }

    public ForecastType(Integer cantSequias, Integer cantLluvias, Integer diaMaxLluvias, Integer cantCondOpt, Double maximoPrecipitaciones) {
        this.cantidadSequias = cantSequias;
        this.cantidadLluvias = cantLluvias;
        this.diaMaximoLluvias = diaMaxLluvias;
        this.cantidadCondOptimas = cantCondOpt;
        this.maximoPrecipitaciones = maximoPrecipitaciones;
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

    public Double getMaximoPrecipitaciones() {
        return maximoPrecipitaciones;
    }

    public void setMaximoPrecipitaciones(Double maximoPrecipitaciones) {
        this.maximoPrecipitaciones = maximoPrecipitaciones;
    }
}
