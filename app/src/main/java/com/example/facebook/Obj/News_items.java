package com.example.facebook.Obj;

public class News_items {
    private int postsId;
    private String name;
    private String time;
    private String imgAvaNews;
    private String imgNews;
    private String txtThinkNews;
    private boolean feel;
    private int countFeel;
    private int countComment;

    public News_items(int postsId, String name, String time, String imgAvaNews, String imgNews, String txtThinkNews) {
        this.postsId = postsId;
        this.name = name;
        this.time = time;
        this.imgAvaNews = imgAvaNews;
        this.imgNews = imgNews;
        this.txtThinkNews = txtThinkNews;
    }

    public News_items(int postsId, String name, String time, String imgAvaNews, String imgNews, String txtThinkNews, boolean feel, int countFeel, int countComment) {
        this.postsId = postsId;
        this.name = name;
        this.time = time;
        this.imgAvaNews = imgAvaNews;
        this.imgNews = imgNews;
        this.txtThinkNews = txtThinkNews;
        this.feel = feel;
        this.countFeel = countFeel;
        this.countComment = countComment;
    }

    public boolean isFeel() {
        return feel;
    }

    public void setFeel(boolean feel) {
        this.feel = feel;
    }

    public int getCountFeel() {
        return countFeel;
    }

    public void setCountFeel(int countFeel) {
        this.countFeel = countFeel;
    }

    public int getCountComment() {
        return countComment;
    }

    public void setCountComment(int countComment) {
        this.countComment = countComment;
    }

    public int getPostsId() {
        return postsId;
    }

    public void setPostsId(int postsId) {
        this.postsId = postsId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getImgAvaNews() {
        return imgAvaNews;
    }

    public void setImgAvaNews(String imgAvaNews) {
        this.imgAvaNews = imgAvaNews;
    }

    public String getImgNews() {
        return imgNews;
    }

    public void setImgNews(String imgNews) {
        this.imgNews = imgNews;
    }

    public String getTxtThinkNews() {
        return txtThinkNews;
    }

    public void setTxtThinkNews(String txtThinkNews) {
        this.txtThinkNews = txtThinkNews;
    }
}
