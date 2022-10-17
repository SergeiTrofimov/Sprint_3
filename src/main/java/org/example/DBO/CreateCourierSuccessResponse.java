package org.example.DBO;

public class CreateCourierSuccessResponse {


    String text;
    boolean isOk;
//
    public CreateCourierSuccessResponse(String text, boolean isOk) {
        this.text = text;
        this.isOk = isOk;
    }
//
public void setText(String text) {
    this.text = text;
}

    public void setOk(boolean ok) {
        isOk = ok;
    }
//
    public String getText() {
        return text;
    }

    public boolean isOk() {
        return isOk;
    }

}
