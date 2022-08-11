package com.example.facebook.Obj;

public class LoginObjv2 {
    private String status;
    private String message;
    private UserV2 data;

    public LoginObjv2(String status, String message, UserV2 data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public UserV2 getData() {
        return data;
    }

    public void setData(UserV2 data) {
        this.data = data;
    }
}
