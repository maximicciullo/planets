package com.maximichu.planetsforecast.repo;

import com.maximichu.planetsforecast.model.PredictionType;

import java.util.Map;

/**
 * Created by max on 23/11/16.
 */
public interface PredictionTypeRepository {

    void savePrediction(PredictionType predictionType);
    void updatePrediction(PredictionType predictionType);
    PredictionType findPrediction(Integer day);
    Map<Object, Object> findAllPredictions();
    void deletePrediction(Integer day);
}
