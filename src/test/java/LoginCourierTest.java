import io.restassured.response.Response;
import org.example.BodyGenerator.СourierGenerator;
import org.example.RESTclient.CourierClient;
import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.core.IsNot.not;

public class LoginCourierTest {
    CourierClient courierClient = new CourierClient();
    СourierGenerator generator = new СourierGenerator();

    /**
     * 1.курьер может авторизоваться;
     * 2.для авторизации нужно передать все обязательные поля;
     */
    @Test
    public void canLoginCourier() {
        // Вызываем создание клиента
        String[] body = generator.bodyGenerator();
        courierClient.createCourierRequest(body[0], body[1], body[2]);
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
    public void wrongPasswordCourier() {
        // Вызываем создание клиента
        String[] body = generator.bodyGenerator();
        courierClient.createCourierRequest(body[0], body[1], body[2]);
        //Логинимся созданной парой
        Response response = courierClient.loginCourierRequest(body[0], body[0]);
        response.then().statusCode(404);
        response.then().assertThat().body("message", equalTo("Учетная запись не найдена"));
        // Убираем за собой
        courierClient.clearTestData(body[0], body[1]);
    }

    /**
     * система вернёт ошибку, если неправильно указать логин
     */
    @Test
    public void wrongLoginCourier() {
        // Вызываем создание клиента
        String[] body = generator.bodyGenerator();
        courierClient.createCourierRequest(body[1], body[1], body[2]);
        //Логинимся созданной парой
        Response response = courierClient.loginCourierRequest(body[0], body[1]);
        response.then().statusCode(404);
        response.then().assertThat().body("message", equalTo("Учетная запись не найдена"));
        // Убираем за собой
        courierClient.clearTestData(body[0], body[1]);
    }

    /**
     * успешный запрос возвращает id.
     */
    @Test
    public void idBodyCheck() {
        // Вызываем создание клиента
        String[] body = generator.bodyGenerator();
        courierClient.createCourierRequest(body[0], body[1], body[2]);
        //Логинимся созданной парой
        Response response = courierClient.loginCourierRequest(body[0], body[1]);
        response.then().statusCode(200);
        response.then().assertThat().body("id", not(equalTo(null)));
        // Убираем за собой
        courierClient.clearTestData(body[0], body[1]);
    }

    /**
     * если авторизоваться под несуществующим пользователем, запрос возвращает ошибку
     */
    public void userIsNotCreated() {
        String[] body = generator.bodyGenerator();
        Response response = courierClient.loginCourierRequest(body[0], body[1]);
        response.then().statusCode(404);
        response.then().assertThat().body("message", equalTo("Учетная запись не найдена"));
    }

    /**
     * если какого-то поля нет, запрос возвращает ошибку
     */
    @ParameterizedTest
    @CsvSource({"Login1, ",
            ",svtPassword1"})

    public void checkMandatoryParameters(String login, String password) {
        Response response = courierClient.loginCourierRequest(login, password);
        response.then().statusCode(400);
        response.then().assertThat().body("message", equalTo("Недостаточно данных для входа"));
    }
}