package com.example.facebook.Obj;

public class PostUser {
    private int postsUserId;
    private int userId;
    private String name;
    private String image;
    private String dateCreate;

    public PostUser(int postsUserId, int userId, String name, String image, String dateCreate) {
        this.postsUserId = postsUserId;
        this.userId = userId;
        this.name = name;
        this.image = image;
        this.dateCreate = dateCreate;
    }

    public int getPostsUserId() {
        return postsUserId;
    }

    public void setPostsUserId(int postsUserId) {
        this.postsUserId = postsUserId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(String dateCreate) {
        this.dateCreate = dateCreate;
    }
}
