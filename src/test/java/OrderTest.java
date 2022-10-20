import com.google.gson.Gson;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.example.bodygenerator.CourierGenerator;
import org.example.bodygenerator.OrderGenerator;
import org.example.dbo.LoginCourierResponse;
import org.example.restclient.CourierClient;
import org.example.restclient.OrderClient;
import org.junit.After;
import org.junit.Before;

public class OrderTest {
    CourierClient courierClient = new CourierClient();
    OrderClient orderClient = new OrderClient();
    CourierGenerator courierGenerator = new CourierGenerator();
    OrderGenerator orderGenerator = new OrderGenerator();
    Gson gson = new Gson();
    String courierId;

    @Before
    @Step("Создаем курьера для теста.Логинимся созданной парой и получаем id курьера")
    public void beforeOrder() {
        String[] body = courierGenerator.bodyGenerator();
        courierClient.createCourierRequest(body[0], body[1], body[2]);

        Response response = courierClient.loginCourierRequest(body[0], body[1]);
        courierId = response.getBody().as(LoginCourierResponse.class).getId();
    }

    @After
    @Step("Убираем за собой")
    public void afterOrder() {
        courierClient.deleteCourier(courierId);
    }
}
