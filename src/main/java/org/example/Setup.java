package org.example;

public class Setup {
    private final static String BASE_URI = "http://qa-scooter.praktikum-services.ru";
    private final static String CREATE_COURIER = "/api/v1/courier";
    private final static String LOGIN_COURIER = "/api/v1/courier/login";
    private final static String DELETE_COURIER = "/api/v1/courier/";
    private final static String CREATE_ORDER = "/api/v1/orders";
    private final static String GET_ORDERS_LIST = "/api/v1/orders?";
    //
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
}