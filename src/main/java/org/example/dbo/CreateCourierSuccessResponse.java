package org.example.dbo;

public class CreateCourierSuccessResponse {

    // Переменные
    String text;
    boolean isOk;

    // Конструктор класса
    public CreateCourierSuccessResponse(String text, boolean isOk) {
        this.text = text;
        this.isOk = isOk;
    }

    // Геттеры и сеттеры
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isOk() {
        return isOk;
    }

    public void setOk(boolean ok) {
        isOk = ok;
    }

}
