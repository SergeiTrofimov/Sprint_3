import io.restassured.response.Response;
import org.example.BodyGenerator.СourierGenerator;
import org.example.RESTclient.CourierClient;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.hamcrest.Matchers.equalTo;

;


public class CreateCourierTest {
    CourierClient courierClient = new CourierClient();
    СourierGenerator generator = new СourierGenerator();

    /**
     * 1.курьера можно создать,
     * 2.запрос возвращает правильный код ответа,
     * 3.успешный запрос возвращает ok: true;
     */
    @Test
    @DisplayName("Проверка создания курьера.Проверка кода и тела")
    public void canCreateCourierTest() {

        // Вызываем создание клиента
        String[] body = generator.bodyGenerator();
        Response response = courierClient.createCourierRequest(body[0], body[1], body[2]);
        response.then().statusCode(201);
        response.then().assertThat().body("ok", equalTo(true));
        // Убираем за собой
        courierClient.clearTestData(body[0], body[1]);
    }

    /**
     * 1.нельзя создать двух одинаковых курьеров;
     */
    @Test
    @DisplayName("Нельзя создать двух одинковых курьеров")
    public void cantCreateDoubleTest() {
        Response response = null;
        String[] body = generator.bodyGenerator();
        for (int i = 0; i < 2; i++) {
            response = courierClient.createCourierRequest(body[0], body[1], body[2]);
        }
        response.then().statusCode(409);
        // Убираем за собой
        courierClient.clearTestData("svtDouble1", "svtDouble2");
    }

    /**
     * если создать пользователя с логином,который уже есть,возвращается ошибка
     */
    @Test
    @DisplayName("Если создать пользователя с логином,который уже есть,возвращается ошибка")
    public void cantReuseLoginTest() {
        String[] body = generator.bodyGenerator();
        Response response = null;
        for (int i = 0; i < 2; i++) {
            response = courierClient.createCourierRequest(body[0], "password" + i, "testDouble" + i);
        }
        response.then().statusCode(409);
        response.then().assertThat().body("message", equalTo("Этот логин уже используется. Попробуйте другой."));
        // Убираем за собой
        courierClient.clearTestData(body[0], "password0");
    }

    /**
     * 1.чтобы создать курьера,нужно передать в ручку все обязательные поля
     * 2.если одного из полей нет,запрос возвращает ошибку;
     */
    @ParameterizedTest
    @CsvSource({"svtLogin1, ,svtName1",
            " ,svtPassword1,svtName1"})

    public void checkMandatoryParametersTest(String login, String password, String firstName) {
        Response response = courierClient.createCourierRequest(login, password, firstName);
        response.then().statusCode(400);
        response.then().assertThat().body("message", equalTo("Недостаточно данных для создания учетной записи"));
    }
}