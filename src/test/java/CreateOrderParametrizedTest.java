import com.google.gson.Gson;
import io.restassured.response.Response;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.HashMap;

import static org.hamcrest.Matchers.notNullValue;

@RunWith(Parameterized.class)
public class CreateOrderParametrizedTest extends OrderTest {

    String[] colorArray;

    public CreateOrderParametrizedTest(String[] colorArray) {
        this.colorArray = colorArray;
    }


    @Parameterized.Parameters(name = "Проверка цвета. Сейчас цвета - {0},{1}") // добавили аннотацию
    public static String[][][] getSumData() {
        return new String[][][]{
                {{"Black", "Grey"}},
                {{"Grey", "Black"}},
                {{"Black"}},
                {{"Grey"}},
                {{}}
        };
    }

    /**
     * 1.можно указать один из цветов — BLACK или GREY
     * 2.можно указать оба цвета
     * 3.можно совсем не указывать цвет
     */

    @Test
    public void colorTest() {
        HashMap<String, Object> orderBody = orderGenerator.bodyGenerator();
        orderBody.remove("color");
        orderBody.put("color", colorArray);
        Gson gson = new Gson();
        String jsonBody = gson.toJson(orderBody);
        Response response = orderClient.createOrderRequest(jsonBody);
        response.then().statusCode(201);
        response.then().assertThat().body(notNullValue());
    }
}