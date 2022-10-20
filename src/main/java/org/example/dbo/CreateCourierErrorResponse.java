package org.example.dbo;

public class CreateCourierErrorResponse {
    //Переменные
    public String errorText;

    //Геттеры и сеттеры
    public CreateCourierErrorResponse(String id) {
        this.errorText = id;
    }

    public String getId() {
        return errorText;
    }

    //Конструктор класса
    public void setId(String id) {
        this.errorText = id;
    }
}