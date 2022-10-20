package org.example.dbo;

public class AvailableStation {
    // Переменные
    private String name;
    private String number;
    private String color;

    // Конструктор класса
    public AvailableStation(String name, String number, String color) {
        this.name = name;
        this.number = number;
        this.color = color;
    }
    //Геттеры и сеттеры


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}