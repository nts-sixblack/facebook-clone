package com.example.facebook.Obj;

public class NewPost {
    private String status;
    private String message;
    private Post[] data;

    public NewPost(String status, String message, Post[] data) {
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

    public Post[] getData() {
        return data;
    }

    public void setData(Post[] data) {
        this.data = data;
    }
}
