import io.restassured.response.Response;
import org.example.BodyGenerator.CourierGenerator;
import org.example.RESTclient.CourierClient;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.core.IsNot.not;

public class LoginCourierTest {
    CourierClient courierClient = new CourierClient();
    CourierGenerator generator = new CourierGenerator();
    private String[] body;

    @Before
    public void beforeLogin() {
        // Создаем курьера для тестов
        body = generator.bodyGenerator();
        courierClient.createCourierRequest(body[0], body[1], body[2]);
    }

    public void afterLogin() {
        // Убираем за собой
        courierClient.clearTestData(body[0], body[1]);
    }

    /**
     * 1.курьер может авторизоваться;
     * 2.для авторизации нужно передать все обязательные поля;
     */
    @Test
    @DisplayName("Курьер может авторизоваться, введя обязательные поля")
    public void canLoginCourierTest() {
        //Логинимся созданной парой
        Response response = courierClient.loginCourierRequest(body[0], body[1]);
        response.then().statusCode(200);
        // Убираем за собой
        courierClient.clearTestData(body[0], body[1]);
    }

    /**
     * система вернёт ошибку, если неправильно указать пароль
     */
    @Test
    @DisplayName("Ошибка при неверном пароле")
    public void wrongPasswordCourierTest() {
        //Логинимся созданной парой
        Response response = courierClient.loginCourierRequest(body[0], body[0]);
        response.then().statusCode(404);
        response.then().assertThat().body("message", equalTo("Учетная запись не найдена"));

    }

    /**
     * система вернёт ошибку, если неправильно указать логин
     */
    @Test
    @DisplayName("Ошибка при неверном логине")
    public void wrongLoginCourierTest() {
        //Логинимся созданной парой
        Response response = courierClient.loginCourierRequest(body[2], body[1]);
        response.then().statusCode(404);
        response.then().assertThat().body("message", equalTo("Учетная запись не найдена"));
    }

    /**
     * успешный запрос возвращает id.
     */
    @Test
    @DisplayName("Успешный запрос возвращает id.")
    public void idBodyCheckTest() {
        //Логинимся созданной парой
        Response response = courierClient.loginCourierRequest(body[0], body[1]);
        response.then().statusCode(200);
        response.then().assertThat().body("id", not(equalTo(null)));
    }

    /**
     * если авторизоваться под несуществующим пользователем, запрос возвращает ошибку
     */
    @Test
    @DisplayName("Если авторизоваться под несуществующим пользователем, запрос возвращает ошибку")
    public void userIsNotCreatedTest() {
        String[] body = generator.bodyGenerator();
        Response response = courierClient.loginCourierRequest(body[0], body[1]);
        response.then().statusCode(404);
        response.then().assertThat().body("message", equalTo("Учетная запись не найдена"));
    }


}