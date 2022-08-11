package com.example.facebook.Obj;

public class CommentListObj {
    private String status;
    private String message;
    private Comment[] data;

    public CommentListObj(String status, String message, Comment[] data) {
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

    public Comment[] getData() {
        return data;
    }

    public void setData(Comment[] data) {
        this.data = data;
    }
}
