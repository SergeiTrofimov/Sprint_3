package org.example.RESTclient;

import io.restassured.response.Response;
import org.example.DBO.CreateOrderRequest;
import org.example.Setup;

import static io.restassured.RestAssured.given;

public class OrderClient {
    Setup setup = new Setup();

    // Создать заказ
    public Response createOrderRequest(String firstName,
                                       String lastName,
                                       String address,
                                       String metroStation,
                                       String phone,
                                       int rentTime,
                                       String deliveryDate,
                                       String comment,
                                       String[] color) {
        CreateOrderRequest order = new CreateOrderRequest(String firstName,
                lastName,
                address,
                metroStation,
                phone,
                rentTime,
                deliveryDate,
                comment,
                color);
        Response response = given()
                .header("Content-type", "application/json")
                .baseUri(setup.getBaseUri())
                .body(order)
                .when()
                .post(setup.getCreateOrder());
        return response;
    }
    // Получить список заказов
}
