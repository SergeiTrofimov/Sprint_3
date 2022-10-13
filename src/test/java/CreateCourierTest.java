import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.example.DBO.CreateCourierRequest;
import org.example.DBO.CreateCourierResponse;
import org.example.DBO.LoginCourierResponse;
import org.example.RESTclient.CourierClient;
import org.example.Setup;
import org.junit.Before;
import org.junit.Test;

import static io.restassured.RestAssured.config;
import static io.restassured.RestAssured.given;

public class CreateCourierTest {
    CourierClient courierClient = new CourierClient();
    @Test
    public void test (){
        Response response = courierClient.createCourierRequest("123","321","1123");
        String id = response.getBody().as(CreateCourierResponse.class).getId();
        courierClient.deleteCourier(id);
    }

}