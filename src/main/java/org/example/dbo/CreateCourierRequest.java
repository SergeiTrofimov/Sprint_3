package org.example.DBO;

public class CreateCourierRequest {

    // Переменные
    private String login;
    private String password;
    private String firstName;

    // Конструктор класса
    public CreateCourierRequest(String login, String password, String firsName) {
        this.login = login;
        this.password = password;
        this.firstName = firsName;
    }

    public CreateCourierRequest() {
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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
}