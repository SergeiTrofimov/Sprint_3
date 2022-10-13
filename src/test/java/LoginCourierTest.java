import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.example.DBO.LoginCourierRequest;
import org.example.DBO.LoginCourierResponse;
import org.junit.Before;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class LoginCourierTest {
    @Before
    public void setup() {
        RestAssured.baseURI = "http://qa-scooter.praktikum-services.ru";
    }

    @Test
    public void test() {
        LoginCourierRequest login = new LoginCourierRequest("Login23", "Password43");
        Response response = given()
                .header("Content-type", "application/json")
                .and()
                .body(login)
                .when()
                .post("/api/v1/courier/login");
        System.out.println(response.getBody().asString());
        String id = response.getBody().as(LoginCourierResponse.class).getId();
        System.out.println(id);
    }
}
