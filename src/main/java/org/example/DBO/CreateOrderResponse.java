package org.example.DBO;

public class CreateOrderResponse {
    int track;

    //
    public CreateOrderResponse(int track) {
        this.track = track;
    }

    //
    public int getTrack() {
        return track;
    }

    public void setTrack(int track) {
        this.track = track;
    }
}