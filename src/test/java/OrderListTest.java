import io.restassured.response.Response;
import org.example.BodyGenerator.OrderGenerator;
import org.example.BodyGenerator.СourierGenerator;
import org.example.DBO.LoginCourierResponse;
import org.example.RESTclient.CourierClient;
import org.example.RESTclient.OrderClient;
import org.junit.After;
import org.junit.Before;

public class OrderListTest {
    CourierClient courierClient = new CourierClient();
    OrderClient orderClient = new OrderClient();
    СourierGenerator сourierGenerator = new СourierGenerator();
    OrderGenerator orderGenerator = new OrderGenerator();
    private String id;

    /**
     * если авторизоваться под несуществующим пользователем, запрос возвращает ошибку
     */
    @Before
    public void beforeOrder() {
        String[] body = сourierGenerator.bodyGenerator();
        courierClient.createCourierRequest(body[0], body[1], body[2]);
        //Логинимся созданной парой
        Response response = courierClient.loginCourierRequest(body[0], body[1]);
        id = response.getBody().as(LoginCourierResponse.class).getId();
    }

    @After
    public void afterOrder() {
        courierClient.deleteCourier(id);
    }

}
