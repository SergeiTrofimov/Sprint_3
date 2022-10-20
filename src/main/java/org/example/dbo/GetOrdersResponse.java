package org.example.dbo;

import java.util.ArrayList;

public class GetOrdersResponse {
    // Перменные
    private ArrayList<Order> orders;
    private PageInfo pageInfo;
    private ArrayList<AvailableStation> availableStations;

    // Конструктор класса
    public GetOrdersResponse(ArrayList<Order> orders, PageInfo pageInfo, ArrayList<AvailableStation> availableStations) {
        this.orders = orders;
        this.pageInfo = pageInfo;
        this.availableStations = availableStations;
    }

    //Геттеры и сеттеры
    public ArrayList<Order> getOrders() {
        return orders;
    }

    public void setOrders(ArrayList<Order> orders) {
        this.orders = orders;
    }

    public PageInfo getPageInfo() {
        return pageInfo;
    }

    public void setPageInfo(PageInfo pageInfo) {
        this.pageInfo = pageInfo;
    }

    public ArrayList<AvailableStation> getAvailableStations() {
        return availableStations;
    }

    public void setAvailableStations(ArrayList<AvailableStation> availableStations) {
        this.availableStations = availableStations;
    }
}
