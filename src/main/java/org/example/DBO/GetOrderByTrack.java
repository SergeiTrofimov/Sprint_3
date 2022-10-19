package org.example.DBO;

public class GetOrderByTrack {
    private Order order;
    //
    public GetOrderByTrack(Order order) {
        this.order = order;
    }
//
    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }


}
