import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.example.CreateCourier;
import org.junit.Before;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class CreateCourierTest {
    @Before
    public void setup(){
        RestAssured.baseURI = "http://qa-scooter.praktikum-services.ru";
    }
    @Test
    public void test (){
        CreateCourier courier = new CreateCourier("Login23","Password43","name22");
       Response response = given()
                .header("Content-type", "application/json")
                .and()
                .body(courier)
                .when()
                .post("/api/v1/courier");
                //.then().statusCode(201);
       System.out.println(response.getBody().asString());
    }
}