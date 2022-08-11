package com.example.facebook.Obj;

public class Market {
    public int image;
    public String price;
    public String des;

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public Market(int image, String name, String des) {
        this.image = image;
        this.price = name;
        this.des = des;
    }
}
