package org.example.RESTclient;

import io.restassured.response.Response;
import org.example.DBO.CreateCourierRequest;
import org.example.DBO.LoginCourierRequest;
import org.example.Setup;

import static io.restassured.RestAssured.given;

public class CourierClient {
    Setup setup = new Setup();

    // Создать
    public Response createCourierRequest(String login, String password, String firstName) {
        CreateCourierRequest courier = new CreateCourierRequest("Login23", "Password43", "name22");
        Response response = given()
                .header("Content-type", "application/json")
                .baseUri(setup.getBaseUri())
                .body(courier)
                .when()
                .post(setup.getCreateCourier());
        return response;
    }

    // Логин
    public Response loginCourierRequest(String login, String password) {
        LoginCourierRequest loginZ = new LoginCourierRequest("2212", "2313");
        Response resposne = given()
                .header("Content-type", "application/json")
                .baseUri(setup.getBaseUri())
                .body(loginZ)
                .when()
                .post(setup.getLoginCourier());
        return resposne;
    }

    // Удалить
    public void deleteCourier(String id) {
        given()
                .header("Content-type", "application/json")
                .baseUri(setup.getBaseUri())
                .when()
                .delete(setup.getDeleteCourier() + id);
    }


}
