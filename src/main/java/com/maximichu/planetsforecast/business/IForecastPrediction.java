package com.maximichu.planetsforecast.business;


import com.maximichu.planetsforecast.model.ForecastType;

public interface IForecastPrediction {

    public ForecastType calculateForecast(Integer years);
}
