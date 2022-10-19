import com.google.gson.Gson;
import io.restassured.response.Response;
import org.example.BodyGenerator.OrderGenerator;
import org.example.BodyGenerator.СourierGenerator;
import org.example.RESTclient.CourierClient;
import org.example.RESTclient.OrderClient;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.HashMap;
import java.util.stream.Stream;

import static org.hamcrest.Matchers.notNullValue;

public class CreateOrderTest {


    CourierClient courierClient = new CourierClient();
    OrderClient orderClient = new OrderClient();
    СourierGenerator сourierGenerator = new СourierGenerator();
    OrderGenerator orderGenerator = new OrderGenerator();
    private String id;

    //Хранилище параметров для параметризации
    static Stream<Arguments> stringArrayProvider() {
        return Stream.of(
                Arguments.of((Object) new String[]{"Black", "Grey"}),
                Arguments.of((Object) new String[]{"Grey", "Black"}),
                Arguments.of((Object) new String[]{"Black"}),
                Arguments.of((Object) new String[]{"Grey"}),
                Arguments.of((Object) new String[]{})
        );
    }

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

    /**
     * 1.можно указать один из цветов — BLACK или GREY
     * 2.можно указать оба цвета
     * 3.можно совсем не указывать цвет
     */
    @ParameterizedTest
    @MethodSource("stringArrayProvider")
    public void colorTest(String[] colorArray) {
        HashMap<String, Object> orderBody = orderGenerator.bodyGenerator();
        orderBody.remove("color");
        orderBody.put("color", colorArray);
        Gson gson = new Gson();
        String jsonBody = gson.toJson(orderBody);
        Response response = orderClient.createOrderRequest(jsonBody);
        response.then().statusCode(201);
        response.then().assertThat().body(notNullValue());
    }
}