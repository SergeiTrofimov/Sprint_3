import io.restassured.response.Response;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.hamcrest.Matchers.equalTo;

@RunWith(Parameterized.class)
public class LoginCourierParametrizedTest extends CourierTests {
    /**
     * если какого-то поля нет, запрос возвращает ошибку
     */

    private final String login;
    private final String password;

    public LoginCourierParametrizedTest(String login, String password) {
        this.login = login;
        this.password = password;
    }

    @Parameterized.Parameters(name = "Логин:{0}/Пароль:{1}") // добавили аннотацию
    public static Object[][] getSumData() {
        return new Object[][]{
                {"Login1", ""},
                {"", "Password1"}
        };
    }

    @Test
    @DisplayName("Если какого-то поля нет, запрос возвращает ошибку")
    public void checkMandatoryParametersTest() {
        Response response = courierClient.loginCourierRequest(login, password);
        response.then().statusCode(400);
        response.then().assertThat().body("message", equalTo("Недостаточно данных для входа"));
    }
}