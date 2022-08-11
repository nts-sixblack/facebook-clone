package com.example.facebook.Obj;

import java.io.Serializable;

public class Story implements Serializable {
    private String ID;
    private String IDND;
    private String Name;
    private String Avt;
    private String Type;
    private String Src;
    private String created_at;
    private String updated_at;

    public Story(String ID, String IDND, String name, String avt, String type, String src, String created_at, String updated_at) {
        this.ID = ID;
        this.IDND = IDND;
        Name = name;
        Avt = avt;
        Type = type;
        Src = src;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    public Story(String name, String avt, String src) {
        Name = name;
        Avt = avt;
        Src = src;
    }

    public String getAvt() {
        return Avt;
    }

    public String getID() {
        return ID;
    }

    public String getIDND() {
        return IDND;
    }

    public String getName() {
        return Name;
    }

    public String getType() {
        return Type;
    }

    public String getSrc() {
        return Src;
    }

    public String getCreated_at() {
        return created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }
}
