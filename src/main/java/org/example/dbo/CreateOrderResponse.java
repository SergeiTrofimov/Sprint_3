package org.example.dbo;

public class CreateOrderResponse {
    // Переменные
    int track;

    //Конструктор класса
    public CreateOrderResponse(int track) {
        this.track = track;
    }

    //Геттеры и сеттеры
    public int getTrack() {
        return track;
    }

    public void setTrack(int track) {
        this.track = track;
    }
}