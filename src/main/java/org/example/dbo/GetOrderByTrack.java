package org.example.dbo;

public class GetOrderByTrack {
    //Переменные
    private Order order;

    //Конструктор класса
    public GetOrderByTrack(Order order) {
        this.order = order;
    }

    //Геттеры и сеттеры
    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }


}
