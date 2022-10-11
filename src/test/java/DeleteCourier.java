import io.restassured.RestAssured;
import org.junit.Before;

import static io.restassured.RestAssured.given;

public class DeleteCourier {
    public void deleteCourier (String id) {
        RestAssured.baseURI = "http://qa-scooter.praktikum-services.ru";
        given()
                .header("Content-type", "application/json")
                .and()
                .when()
                .delete("/api/v1/courier/"+id);
    }
}
