package org.example;

public class Setup {
    // Здесь хранятся эндпоинты для конструирования
    private final static String BASE_URI = "http://qa-scooter.praktikum-services.ru";
    private final static String CREATE_COURIER = "/api/v1/courier";
    private final static String LOGIN_COURIER = "/api/v1/courier/login";
    private final static String DELETE_COURIER = "/api/v1/courier/";
    private final static String CREATE_ORDER = "/api/v1/orders";
    private final static String GET_ORDERS_LIST = "/api/v1/orders?";
    private final static String GET_ORDER_ID_BY_TRACK = "/api/v1/orders/track?t=";
    private final static String PUT_ORDER_TO_COURIER = "/api/v1/orders/accept/";

    // Здесь возвращаются эндпоинты
    public String getBaseUri() {
        return BASE_URI;
    }

    public String getCreateCourier() {
        return CREATE_COURIER;
    }

    public String getLoginCourier() {
        return LOGIN_COURIER;
    }

    public String getDeleteCourier() {
        return DELETE_COURIER;
    }

    public String getCreateOrder() {
        return CREATE_ORDER;
    }

    public String getGetOrdersList() {
        return GET_ORDERS_LIST;
    }

    public String getGetOrderIdByTrack() {
        return GET_ORDER_ID_BY_TRACK;
    }

    public String getPutOrderToCourier() {
        return PUT_ORDER_TO_COURIER;
    }
}