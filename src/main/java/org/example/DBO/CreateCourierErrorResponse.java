package org.example.DBO;

public class CreateCourierErrorResponse {
    public String errorText;

    public CreateCourierErrorResponse (String id) {
        this.errorText = id;
    }

    public String getId() {
        return errorText;
    }

    public void setId(String id) {
        this.errorText = id;
    }
}