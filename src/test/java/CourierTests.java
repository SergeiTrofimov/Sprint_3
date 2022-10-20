import io.qameta.allure.Step;
import org.example.bodygenerator.CourierGenerator;
import org.example.restclient.CourierClient;
import org.junit.After;
import org.junit.Before;

public class CourierTests {
    CourierClient courierClient = new CourierClient();
    CourierGenerator generator = new CourierGenerator();
    String[] body;

    @Before
    @Step("Создаем курьера для тестов")
    public void beforeLogin() {
        body = generator.bodyGenerator();
        courierClient.createCourierRequest(body[0], body[1], body[2]);
    }

    @After
    @Step("Убираем за собой")
    public void afterLogin() {
        courierClient.clearTestData(body[0], body[1]);
    }
}
