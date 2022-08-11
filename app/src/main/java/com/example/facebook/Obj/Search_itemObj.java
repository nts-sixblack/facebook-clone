package com.example.facebook.Obj;

public class Search_itemObj {
    private int id;
    private  String itSearch_avt;
    private String itSearch_txtName;
    private String itSearch_txtBC;

    public Search_itemObj(int id, String itSearch_avt, String itSearch_txtName, String itSearch_txtBC) {
        this.id = id;
        this.itSearch_avt = itSearch_avt;
        this.itSearch_txtName = itSearch_txtName;
        this.itSearch_txtBC = itSearch_txtBC;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getItSearch_avt() {
        return itSearch_avt;
    }

    public void setItSearch_avt(String itSearch_avt) {
        this.itSearch_avt = itSearch_avt;
    }

    public String getItSearch_txtName() {
        return itSearch_txtName;
    }

    public void setItSearch_txtName(String itSearch_txtName) {
        this.itSearch_txtName = itSearch_txtName;
    }

    public String getItSearch_txtBC() {
        return itSearch_txtBC;
    }

    public void setItSearch_txtBC(String itSearch_txtBC) {
        this.itSearch_txtBC = itSearch_txtBC;
    }
}
