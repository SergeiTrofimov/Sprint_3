import com.google.gson.Gson;
import io.restassured.response.Response;
import org.example.BodyGenerator.OrderGenerator;
import org.example.BodyGenerator.СourierGenerator;
import org.example.DBO.CreateOrderResponse;
import org.example.DBO.LoginCourierResponse;
import org.example.RESTclient.CourierClient;
import org.example.RESTclient.OrderClient;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

@RunWith(Parameterized.class)
public class CreateOrderTest {


    CourierClient courierClient = new CourierClient();
    OrderClient orderClient = new OrderClient();
    СourierGenerator сourierGenerator = new СourierGenerator();
    OrderGenerator orderGenerator = new OrderGenerator();
    private String id;
    String[] colorArray;

    public CreateOrderTest(String [] colorArray) {
        this.colorArray = colorArray;
    }


    @Parameterized.Parameters(name = "Проверка цвета -{0}")
    public static String[][][] getSumData() {
        return new String[][][]{

                {{"Black", "Grey"}},
                {{"Grey", "Black"}},
                {{"", "Grey"}},
                {{"Black", ""}},
                {{}}
        };
    }

    @Before
    public void beforeOrder() {
        String[] body = сourierGenerator.bodyGenerator();
        courierClient.createCourierRequest(body[0], body[1], body[2]);
        //Логинимся созданной парой
        Response response = courierClient.loginCourierRequest(body[0], body[1]);
        id = response.getBody().as(LoginCourierResponse.class).getId();
    }

    @After
    public void afterOrder() {
        courierClient.deleteCourier(id);
    }

    /**
     * тело ответа содержит track
     */
    @Test
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
    @Test
    public void colorTest() {
        HashMap<String, Object> orderBody = orderGenerator.bodyGenerator();
        orderBody.remove("color");
        orderBody.put("color", colorArray);
        Gson gson = new Gson();
        String jsonBody = gson.toJson(orderBody);
        Response response = orderClient.createOrderRequest(jsonBody);
        response.then().statusCode(201);
        int track = response.getBody().as(CreateOrderResponse.class).getTrack();
        System.out.println(track);
    }
}