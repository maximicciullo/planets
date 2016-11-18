package com.maximichu.planetsforecast.business;


import com.maximichu.planetsforecast.model.ForecastType;

public interface IForecastPrediction {

    public ForecastType calculateForecast(Integer years);
    public Integer calcularCantidadSequia(Integer years);
    public Integer calcularCantidadLluvia(Integer years);
    public Integer calcularCondicionesOptimas(Integer years);
    public Integer calcularDiaMaximoLluvia(Integer years);

}
