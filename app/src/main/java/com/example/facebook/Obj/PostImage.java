package com.example.facebook.Obj;

public class PostImage {
    private int postsImageId;
    private String image;
    private String dateCreate;

    public PostImage(int postsImageId, String image, String dateCreate) {
        this.postsImageId = postsImageId;
        this.image = image;
        this.dateCreate = dateCreate;
    }

    public int getPostsImageId() {
        return postsImageId;
    }

    public void setPostsImageId(int postsImageId) {
        this.postsImageId = postsImageId;
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
