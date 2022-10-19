import com.google.gson.Gson;
import io.restassured.response.Response;
import org.example.BodyGenerator.OrderGenerator;
import org.example.BodyGenerator.CourierGenerator;
import org.example.RESTclient.CourierClient;
import org.example.RESTclient.OrderClient;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.HashMap;
import java.util.stream.Stream;

import static org.hamcrest.Matchers.notNullValue;

public class CreateOrderTest {


    CourierClient courierClient = new CourierClient();
    OrderClient orderClient = new OrderClient();
    CourierGenerator courierGenerator = new CourierGenerator();
    OrderGenerator orderGenerator = new OrderGenerator();
    private String id;


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