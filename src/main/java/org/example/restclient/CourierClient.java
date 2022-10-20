package org.example.restclient;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.example.dbo.CreateCourierRequest;
import org.example.dbo.LoginCourierRequest;
import org.example.dbo.LoginCourierResponse;
import org.example.Setup;

import static io.restassured.RestAssured.given;

public class CourierClient {
    Setup setup = new Setup();

    @Step("Создать курьера")
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

    @Step("Логин курьера")
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

    @Step("Удалить курьера")
    public void deleteCourier(String id) {
        given()
                .header("Content-type", "application/json")
                .baseUri(setup.getBaseUri())
                .when()
                .delete(setup.getDeleteCourier() + id);


    }

    @Step("Логинимся курьером, чтобы получить id и удаляем его.")
    public void clearTestData(String login, String password) {
        Response response = loginCourierRequest(login, password);
        String id = response.getBody().as(LoginCourierResponse.class).getId();
        deleteCourier(id);
    }
}