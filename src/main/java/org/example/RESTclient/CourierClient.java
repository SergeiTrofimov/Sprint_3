package org.example.RESTclient;

import io.restassured.response.Response;
import org.example.DBO.CreateCourierRequest;

import static io.restassured.RestAssured.given;

public class CourierClient {
    // Создать
    public Response createCourierRequest() {
        CreateCourierRequest courier= new CreateCourierRequest("Login23", "Password43", "name22");
        Response response = given()
                .header("Content-type", "application/json")
                .and()
                .body(courier)
                .when()
                .post("/api/v1/courier");
        return response;
    }
    // Логин
    // Удалить


}
