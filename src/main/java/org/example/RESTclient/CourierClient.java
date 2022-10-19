package org.example.RESTclient;

import io.restassured.response.Response;
import org.example.DBO.CreateCourierRequest;
import org.example.DBO.LoginCourierRequest;
import org.example.DBO.LoginCourierResponse;
import org.example.Setup;

import static io.restassured.RestAssured.given;

public class CourierClient {
    Setup setup = new Setup();

    // Создать курьера
    public Response createCourierRequest(String login, String password, String firstName) {
        CreateCourierRequest courier = new CreateCourierRequest(login, password, firstName);
        Response response = given()
                .header("Content-type", "application/json")
                .baseUri(setup.getBaseUri())
                .body(courier)
                .when()
                .post(setup.getCreateCourier());
        return response;
    }

    // Логин курьера
    public Response loginCourierRequest(String login, String password) {
        LoginCourierRequest loginBody = new LoginCourierRequest(login, password);
        Response response = given()
                .header("Content-type", "application/json")
                .baseUri(setup.getBaseUri())
                .body(loginBody)
                .when()
                .post(setup.getLoginCourier());
        return response;
    }

    // Удалить курьера
    public void deleteCourier(String id) {
        given()
                .header("Content-type", "application/json")
                .baseUri(setup.getBaseUri())
                .when()
                .delete(setup.getDeleteCourier() + id);


    }

    // Очистка данных теста
    public void clearTestData(String login, String password) {
        Response response = loginCourierRequest(login, password);
        String id = response.getBody().as(LoginCourierResponse.class).getId();
        deleteCourier(id);
    }
}