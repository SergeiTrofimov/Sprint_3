package org.example.RESTclient;

import io.restassured.response.Response;
import org.example.DBO.CreateOrderRequest;
import org.example.Setup;

import static io.restassured.RestAssured.given;

public class OrderClient {
    Setup setup = new Setup();

    // Создать заказ
    public Response createOrderRequest(String jsonBody) {
       // CreateOrderRequest order = new CreateOrderRequest(requestBody);
        Response response = given()
                .header("Content-type", "application/json")
                .baseUri(setup.getBaseUri())
                .body(jsonBody)
                .when()
                .post(setup.getCreateOrder());
        return response;
    }
    //Получить номер заказа по трек номеру



    public Response getOrderIdByTrackRequest(int trackNumber) {
        Response response = given()
                .header("Content-type", "application/json")
                .baseUri(setup.getBaseUri())
                .when()
                .get(setup.getGetOrderIdByTrack()+trackNumber);
        return response;
    }

    //Назначить заказ курьеру
    public Response putOrderToCourier(int orderID, String courierID) {
        Response response = given()
                .header("Content-type", "application/json")
                .baseUri(setup.getBaseUri())
                .when()
                .put(setup.getPutOrderToCourier()+orderID+"?courierId="+courierID);
        return response;
    }

    // Получить список заказов
    public Response getOrdersRequest(String postfix) {
        Response response = given()
                .header("Content-type", "application/json")
                .baseUri(setup.getBaseUri())
                .when()
                .get(setup.getGetOrdersList()+postfix);
        return response;
    }
}