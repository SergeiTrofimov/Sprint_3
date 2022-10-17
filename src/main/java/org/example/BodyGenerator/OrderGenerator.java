package org.example.BodyGenerator;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.HashMap;

public class OrderGenerator {
    public HashMap<String, String> bodyGenerator() {
        HashMap<String, String> result = new HashMap<>();
        result.put("firstName", RandomStringUtils.randomAlphabetic(5));
        result.put("lastName", RandomStringUtils.randomAlphabetic(5));
        result.put("metroStation", RandomStringUtils.randomNumeric(15));
        result.put("phone", "+7911" + RandomStringUtils.randomAlphabetic(7));
        result.put("rentTime", RandomStringUtils.randomAlphabetic(10));
        result.put("deliveryDate", "2022-11-17");
        result.put("comment", RandomStringUtils.randomAlphabetic(55));
        return result;
    }
}