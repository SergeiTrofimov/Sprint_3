import org.example.BodyGenerator.СourierGenerator;
import org.example.RESTclient.CourierClient;

public class CreateOrderTest {

    /**
     можно указать один из цветов — BLACK или GREY;
    можно указать оба цвета;
    можно совсем не указывать цвет;
    тело ответа содержит track.
     */
    CourierClient courierClient = new CourierClient();
    СourierGenerator generator = new СourierGenerator();
}
