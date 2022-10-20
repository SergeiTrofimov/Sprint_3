package org.example.bodygenerator;

import io.qameta.allure.Step;
import org.apache.commons.lang3.RandomStringUtils;

public class CourierGenerator {
    @Step("Генерируем случайное тело модели курьера")
    public String[] bodyGenerator() {

        String[] result = new String[3];
        for (int i = 0; i < 3; i++) {
            result[i] = RandomStringUtils.randomAlphabetic(5);
        }
        return result;
    }
}