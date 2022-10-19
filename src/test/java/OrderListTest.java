import com.google.gson.Gson;
import io.restassured.response.Response;
import org.example.BodyGenerator.OrderGenerator;
import org.example.BodyGenerator.CourierGenerator;
import org.example.DBO.CreateOrderResponse;
import org.example.DBO.GetOrderByTrack;
import org.example.DBO.GetOrdersResponse;
import org.example.DBO.LoginCourierResponse;
import org.example.RESTclient.CourierClient;
import org.example.RESTclient.OrderClient;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;

public class OrderListTest {
    CourierClient courierClient = new CourierClient();
    OrderClient orderClient = new OrderClient();
    CourierGenerator courierGenerator = new CourierGenerator();
    OrderGenerator orderGenerator = new OrderGenerator();
    Gson gson = new Gson();
    private String courierId;

    @Before
    public void beforeOrder() {
        // Создаем курьера для теста
        String[] body = courierGenerator.bodyGenerator();
        courierClient.createCourierRequest(body[0], body[1], body[2]);
        //Логинимся созданной парой и получаем id курьера
        Response response = courierClient.loginCourierRequest(body[0], body[1]);
        courierId = response.getBody().as(LoginCourierResponse.class).getId();
    }

    @After
    // Убираем за собой
    public void afterOrder() {
        courierClient.deleteCourier(courierId);
    }

    @Test
    @DisplayName("Тело ответа не пустое, если у курьера есть заказы")
    public void orderListIsNotEmptyTest() {
        HashMap<String, Object> orderBody = orderGenerator.bodyGenerator();
        String jsonBody = gson.toJson(orderBody);
        Response orderResponse = orderClient.createOrderRequest(jsonBody);
        orderResponse.then().statusCode(201);
        int orderTrack = orderResponse.getBody().as(CreateOrderResponse.class).getTrack();
        // узнаем id заказа
        Response orderIdResponse = orderClient.getOrderIdByTrackRequest(orderTrack);
        orderIdResponse.then().statusCode(200);
        int orderId = orderIdResponse.getBody().as(GetOrderByTrack.class).getOrder().getId();
        // привязываем к курьеру
        Response putOrderResponse = orderClient.putOrderToCourier(orderId, courierId);
        putOrderResponse.then().statusCode(200);
        // делаем запрос на заказ
        String prefix = "courierId=" + courierId;
        Response getOrdersListResponse = orderClient.getOrdersRequest(prefix);
        getOrdersListResponse.then().statusCode(200);
        ArrayList order = getOrdersListResponse.getBody().as(GetOrdersResponse.class).getOrders();
        assertEquals(false, order.isEmpty());
    }
}