package com.example.facebook.Obj;

public class story_items {
    private String imgAva;
    private String img;
    private String txtNameStory;

    public story_items(String imgAva, String img,String txtNameStory) {
        this.imgAva = imgAva;
        this.img = img;
        this.txtNameStory = txtNameStory;
    }

    public String getImgAva() {
        return imgAva;
    }

    public void setImgAva(String imgAva) {
        this.imgAva = imgAva;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getTxtNameStory() {
        return txtNameStory;
    }

    public void setTxtNameStory(String txtNameStory) {
        this.txtNameStory = txtNameStory;
    }
}

