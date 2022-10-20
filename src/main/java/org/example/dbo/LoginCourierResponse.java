package org.example.dbo;

public class LoginCourierResponse {
    //Переменные
    public String id;

    //Конструктор класса
    public LoginCourierResponse(String id) {
        this.id = id;
    }

    //Сеттеры и геттеры
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}