import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.example.CreateCourier;
import org.example.LoginCourier;
import io.restassured.response.Response;
import com.google.gson.Gson;
import org.junit.Before;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class LoginCourierTest {
    @Before
    public void setup(){
        RestAssured.baseURI = "http://qa-scooter.praktikum-services.ru";
    }
    @Test
    public void test (){
        LoginCourier login = new LoginCourier("Login23","Password43");
        Response response = given()
                .header("Content-type", "application/json")
                .and()
                .body(login)
                .when()
                .post("/api/v1/courier/login");
        System.out.println(response.getBody().asString());
        //Set<> id = gson.fromJson(response.getBody(),id);

    }
}
