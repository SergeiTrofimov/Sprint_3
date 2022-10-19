import com.google.gson.Gson;
import io.restassured.response.Response;
import org.example.BodyGenerator.CourierGenerator;
import org.example.BodyGenerator.OrderGenerator;
import org.example.DBO.LoginCourierResponse;
import org.example.RESTclient.CourierClient;
import org.example.RESTclient.OrderClient;
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
    public void beforeOrder() {
        // Создаем курьера для теста
        String[] body = courierGenerator.bodyGenerator();
        courierClient.createCourierRequest(body[0], body[1], body[2]);
        //Логинимся созданной парой и получаем id курьера
        Response response = courierClient.loginCourierRequest(body[0], body[1]);
        courierId = response.getBody().as(LoginCourierResponse.class).getId();
    }

    @After
    // Убираем за собой
    public void afterOrder() {
        courierClient.deleteCourier(courierId);
    }
}
