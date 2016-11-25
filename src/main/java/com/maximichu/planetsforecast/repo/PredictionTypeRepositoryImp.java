package com.maximichu.planetsforecast.repo;

import com.maximichu.planetsforecast.model.PredictionType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.Map;

@Repository
/**
 * Implementacion del Repositorio definido para PredictionType
 * utilizando motor de BD Redis almacenando los datos en memoria
 */
public class PredictionTypeRepositoryImp implements PredictionTypeRepository {

    private static final String KEY = "Prediction";

    private RedisTemplate<String, PredictionType> redisTemplate;
    private HashOperations hashOps;

    @Autowired
    private PredictionTypeRepositoryImp(RedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @PostConstruct
    private void init() {
        hashOps = redisTemplate.opsForHash();
    }

    @Override
    public void savePrediction(PredictionType predictionType) {
        hashOps.put(KEY, predictionType.getId(), predictionType);
    }

    @Override
    public void updatePrediction(PredictionType predictionType) {
        hashOps.put(KEY, predictionType.getId(), predictionType);
    }

    @Override
    public PredictionType findPrediction(Integer id) {
        return (PredictionType) hashOps.get(KEY, id);
    }

    @Override
    public Map<Object, Object> findAllPredictions() {
        return hashOps.entries(KEY);
    }

    @Override
    public void deletePrediction(Integer id) {
        hashOps.delete(KEY, id);
    }
}
