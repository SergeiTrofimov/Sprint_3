import io.restassured.response.Response;
import org.example.BodyGenerator.OrderGenerator;
import org.example.BodyGenerator.СourierGenerator;
import org.example.DBO.LoginCourierResponse;
import org.example.RESTclient.CourierClient;
import org.example.RESTclient.OrderClient;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

public class CreateOrderTest {

    /**
     можно указать один из цветов — BLACK или GREY;
    можно указать оба цвета;
    можно совсем не указывать цвет;
    тело ответа содержит track.
     */
    CourierClient courierClient = new CourierClient();
    OrderClient orderClient = new OrderClient();
    СourierGenerator сourierGenerator = new СourierGenerator();
    OrderGenerator orderGenerator = new OrderGenerator();
    private String id;

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
    @Test
    public void colorTest()
    {
        HashMap<String,String> orderBody = orderGenerator.bodyGenerator();
    //orderClient.createOrderRequest();
     System.out.println(id);
    }
}
