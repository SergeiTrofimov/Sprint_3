package org.example;

import io.restassured.RestAssured;
import org.junit.Before;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class CreateCourier {

    // Объявляем поля
    private String login;
    private String password;
    private String firsName;

    // Конструкторы
    public CreateCourier(String login, String password, String firsName) {
        this.login = login;
        this.password = password;
        this.firsName = firsName;
    }

    public CreateCourier() {
    }

    // Сеттеры и геттеры
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirsName() {
        return firsName;
    }

    public void setFirsName(String firsName) {
        this.firsName = firsName;
    }
}