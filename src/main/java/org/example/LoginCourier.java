package org.example;

public class LoginCourier {

    //Переменные полей
    private String login;
    private String password;

    // конструкторы
    public LoginCourier(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public LoginCourier() {
    }

    // сеттеры и геттеры
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
