package org.example.BodyGenerator;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.HashMap;


public class OrderGenerator {
    //Генерируем тело для заказа
    public HashMap<String, Object> bodyGenerator() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("firstName", RandomStringUtils.randomAlphabetic(5));
        result.put("lastName", RandomStringUtils.randomAlphabetic(5));
        result.put("metroStation", RandomStringUtils.randomNumeric(3));
        result.put("phone", "+7911" + RandomStringUtils.randomNumeric(7));
        result.put("rentTime", RandomStringUtils.randomNumeric(2));
        result.put("deliveryDate", "2023-11-17");
        result.put("comment", RandomStringUtils.randomAlphabetic(55));
        result.put("color", new String[]{"BLACK", "GREY"});
        return result;
    }
}