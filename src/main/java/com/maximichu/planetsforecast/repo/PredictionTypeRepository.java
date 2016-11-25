package com.maximichu.planetsforecast.repo;

import com.maximichu.planetsforecast.model.PredictionType;

import java.util.Map;

/**
 * Interfase que define los metodos publicos a imlementar en un
 * repositorio del tipo Prediction.
 */

public interface PredictionTypeRepository {

    /**
     * Persiste el objeto en memoria.
     *
     * @param predictionType
     */
    void savePrediction(PredictionType predictionType);

    /**
     * Actualiza el objecto que se encuentra persistido
     * memoria.
     *
     * @param predictionType
     */
    void updatePrediction(PredictionType predictionType);

    /**
     * Dado un dia realiza la busqueda del objecto
     * en memoria y lo retorna
     *
     * @param day
     * @return PredictionType
     */
    PredictionType findPrediction(Integer day);

    /**
     * Realiza la busqueda de todos los
     * objetos que cumplen con la key del
     * tipo Prediction
     *
     * @return Mapa objeto/valor
     */
    Map<Object, Object> findAllPredictions();

    /**
     * Busca el objeto a partir del parametro
     * de entrada y lo elimina de la memoria.
     *
     * @param day
     */
    void deletePrediction(Integer day);
}
