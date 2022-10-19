import org.example.BodyGenerator.CourierGenerator;
import org.example.RESTclient.CourierClient;
import org.junit.After;
import org.junit.Before;

public class CourierTests {
    CourierClient courierClient = new CourierClient();
    CourierGenerator generator = new CourierGenerator();
    String[] body;

    @Before
    public void beforeLogin() {
        // Создаем курьера для тестов
        body = generator.bodyGenerator();
        courierClient.createCourierRequest(body[0], body[1], body[2]);
    }

    @After
    public void afterLogin() {
        // Убираем за собой
        courierClient.clearTestData(body[0], body[1]);
    }
}
