import com.google.gson.Gson;
import io.restassured.response.Response;
import org.example.BodyGenerator.OrderGenerator;
import org.example.BodyGenerator.СourierGenerator;
import org.example.DBO.CreateOrderResponse;
import org.example.DBO.LoginCourierResponse;
import org.example.DBO.Order;
import org.example.RESTclient.CourierClient;
import org.example.RESTclient.OrderClient;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

public class OrderListTest {
    CourierClient courierClient = new CourierClient();
    OrderClient orderClient = new OrderClient();
    СourierGenerator сourierGenerator = new СourierGenerator();
    OrderGenerator orderGenerator = new OrderGenerator();
    Gson gson = new Gson();
    private String courierId;

    /**
     * если авторизоваться под несуществующим пользователем, запрос возвращает ошибку
     */
    @Before
    public void beforeOrder() {
        String[] body = сourierGenerator.bodyGenerator();
        courierClient.createCourierRequest(body[0], body[1], body[2]);
        //Логинимся созданной парой
        Response response = courierClient.loginCourierRequest(body[0], body[1]);
        courierId = response.getBody().as(LoginCourierResponse.class).getId();
    }

    @After
    public void afterOrder() {
        courierClient.deleteCourier(courierId);
    }
    @Test
    public void orderListIsNotEmpty()
    {
        HashMap<String, Object> orderBody = orderGenerator.bodyGenerator();
        String jsonBody = gson.toJson(orderBody);
        Response orderResponse = orderClient.createOrderRequest(jsonBody);
        orderResponse.then().statusCode(201);
        int orderTrack = orderResponse.getBody().as(CreateOrderResponse.class).getTrack();
        System.out.println(orderTrack);
        // узнаем id заказа
        Response orderIdResponse =orderClient.getOrderIdByTrackRequest(orderTrack);
        orderIdResponse.then().statusCode(200);
        //int orderId = orderIdResponse.getBody().as(Order.class).getId();
       // System.out.println(orderId);
        // привязываем к курьеру
        // делаем запрос на заказ
    }

}
