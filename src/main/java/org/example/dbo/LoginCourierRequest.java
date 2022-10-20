package org.example.DBO;

public class LoginCourierRequest {

    //Переменные
    private String login;
    private String password;

    // Конструктор класса
    public LoginCourierRequest(String login, String password) {
        this.login = login;
        this.password = password;
    }

    //Пустой конструктор для gson
    public LoginCourierRequest() {
    }

    // cеттеры и геттеры
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


}
