import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.maximichu.planetsforecast.enums.Clima;
import com.maximichu.planetsforecast.model.Prediction;
import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by max on 25/11/16.
 */
public class JsonTest {

    public static final ObjectMapper JSON_MAPPER = new ObjectMapper();

    @Test
    public void jsonMapperTest() throws JsonProcessingException {
        Prediction prediction = new Prediction(145, Clima.HUMEDO.getClima());

        String jsonString = JSON_MAPPER.writeValueAsString(prediction);

        assertThat(jsonString, is(equalTo("{\"dia\":145,\"clima\":\"LLUVIA\"}")));
    }


}
