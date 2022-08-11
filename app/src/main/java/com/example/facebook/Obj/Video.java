package com.example.facebook.Obj;

public class Video {
    public String anchor;
    public Boolean isFollow;
    public String date;
    public String content;
    public int image;
    public Boolean isLike;
    public String url;
    public int avt = 0;

    public Video(String anchor, Boolean isFollow, String date, String content, int image, Boolean isLike, String url, int avt) {
        this.anchor = anchor;
        this.isFollow = isFollow;
        this.date = date;
        this.content = content;
        this.image = image;
        this.isLike = isLike;
        this.url = url;
        this.avt = avt;
    }

    public Video(String anchor, Boolean isFollow, String date, String content, int image, Boolean isLike, String url) {
        this.anchor = anchor;
        this.isFollow = isFollow;
        this.date = date;
        this.content = content;
        this.image = image;
        this.isLike = isLike;
        this.url = url;
    }

    public String getAnchor() {
        return anchor;
    }

    public void setAnchor(String anchor) {
        this.anchor = anchor;
    }

    public Boolean getFollow() {
        return isFollow;
    }

    public void setFollow(Boolean follow) {
        isFollow = follow;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public Boolean getLike() {
        return isLike;
    }

    public void setLike(Boolean like) {
        isLike = like;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
