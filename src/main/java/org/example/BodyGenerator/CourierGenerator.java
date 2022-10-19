package org.example.BodyGenerator;

import org.apache.commons.lang3.RandomStringUtils;

public class CourierGenerator {
    //Генерируем случайоного курьера
    public String[] bodyGenerator() {

        String[] result = new String[3];
        for (int i = 0; i < 3; i++) {
            result[i] = RandomStringUtils.randomAlphabetic(5);
        }
        return result;
    }
}