package com.example.facebook.Obj;

public class SearchObj {
    private String status;
    private String  message;
    private SearchdataObj[] data;

    public SearchObj(String status, String message, SearchdataObj[] data) {
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

    public SearchdataObj[] getData() {
        return data;
    }

    public void setData(SearchdataObj[] data) {
        this.data = data;
    }
}
