package com.example.facebook.Obj;

public class Friend_items_Obj {
    private String frImg;
    private String frName;
    private String frTime;

    public Friend_items_Obj(String frImg, String frName, String frTime) {
        this.frImg = frImg;
        this.frName = frName;
        this.frTime = frTime;
    }

    public String getFrImg() {
        return frImg;
    }

    public void setFrImg(String frImg) {
        this.frImg = frImg;
    }

    public String getFrName() {
        return frName;
    }

    public void setFrName(String frName) {
        this.frName = frName;
    }

    public String getFrTime() {
        return frTime;
    }

    public void setFrTime(String frTime) {
        this.frTime = frTime;
    }
}
