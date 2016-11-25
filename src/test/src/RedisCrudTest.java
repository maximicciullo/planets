import com.maximichu.planetsforecast.enums.Clima;
import com.maximichu.planetsforecast.model.PredictionType;
import com.maximichu.planetsforecast.repo.PredictionTypeRepository;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

/**
 * Created by max on 25/11/16.
 */
public class RedisCrudTest {

    @Autowired
    private PredictionTypeRepository repository;

    @Test
    public void save() {
        PredictionType prediction = new PredictionType(145);
        prediction.setPerimetro(56.78);
        prediction.setEstadoClima(Clima.HUMEDO);
        prediction.setSolConPlanetas(Boolean.TRUE);

        repository.savePrediction(prediction);

        PredictionType predictionFromDB = repository.findPrediction(145);

        assertNotNull(predictionFromDB);
        assertEquals(predictionFromDB.getEstadoClima(), prediction.getEstadoClima());
        assertEquals(predictionFromDB.getPerimetro(), prediction.getPerimetro());
        assertEquals(predictionFromDB.getSolConPlanetas(), prediction.getSolConPlanetas());
        assertEquals(predictionFromDB.getId(), prediction.getId());
    }

    @Test
    public void delete() {
        PredictionType prediction = new PredictionType(145);
        prediction.setPerimetro(56.78);
        prediction.setEstadoClima(Clima.HUMEDO);
        prediction.setSolConPlanetas(Boolean.TRUE);

        repository.savePrediction(prediction);

        PredictionType predictionFromDB = repository.findPrediction(145);
        assertNotNull(predictionFromDB);

        repository.deletePrediction(145);

        PredictionType predictionAgainFromDB = repository.findPrediction(145);
        assertNull(predictionAgainFromDB);
    }

}
