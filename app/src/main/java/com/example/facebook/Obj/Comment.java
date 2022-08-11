package com.example.facebook.Obj;

public class Comment {
    private int postsCommentId;
    private String comment;
    private int postsId;
    private int userId;
    private String name;
    private String image;
    private String dateCreate;

    public Comment(){}

    public Comment(int postsCommentId, String comment, int postsId, int userId, String name, String image, String dateCreate) {
        this.postsCommentId = postsCommentId;
        this.comment = comment;
        this.postsId = postsId;
        this.userId = userId;
        this.name = name;
        this.image = image;
        this.dateCreate = dateCreate;
    }

    public int getPostsCommentId() {
        return postsCommentId;
    }

    public void setPostsCommentId(int postsCommentId) {
        this.postsCommentId = postsCommentId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getPostsId() {
        return postsId;
    }

    public void setPostsId(int postsId) {
        this.postsId = postsId;
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
