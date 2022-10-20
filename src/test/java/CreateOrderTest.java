import com.google.gson.Gson;
import io.restassured.response.Response;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import java.util.HashMap;

import static org.hamcrest.Matchers.notNullValue;

public class CreateOrderTest extends OrderTest {

    /**
     * тело ответа содержит track
     */
    @Test
    @DisplayName("Тело ответа содержит track")
    public void responseTest() {
        HashMap<String, Object> orderBody = orderGenerator.bodyGenerator();
        Gson gson = new Gson();
        String jsonBody = gson.toJson(orderBody);
        Response response = orderClient.createOrderRequest(jsonBody);
        response.then().statusCode(201);
        response.then().assertThat().body(notNullValue());
    }

}