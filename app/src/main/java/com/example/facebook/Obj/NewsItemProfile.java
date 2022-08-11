package com.example.facebook.Obj;

public class NewsItemProfile {
    private int postsId;
    private String imgAvaProfile;
    private String txtNameProfile;
    private String imgNewsProfile;
    private String txtThinkNewsProfile;
    private String txtTimeNewsProfile;
    private int countFeel;
    private int countComment;
    private boolean feel;

    public NewsItemProfile(){}

    public NewsItemProfile(int postsId, String imgAvaProfile, String txtNameProfile, String imgNewsProfile, String txtThinkNewsProfile, String txtTimeNewsProfile, int countFeel, int countComment) {
        this.postsId = postsId;
        this.imgAvaProfile = imgAvaProfile;
        this.txtNameProfile = txtNameProfile;
        this.imgNewsProfile = imgNewsProfile;
        this.txtThinkNewsProfile = txtThinkNewsProfile;
        this.txtTimeNewsProfile = txtTimeNewsProfile;
        this.countFeel = countFeel;
        this.countComment = countComment;
    }

    public NewsItemProfile(String imgAvaProfile, String txtNameProfile, String imgNewsProfile, String txtThinkNewsProfile, String txtTimeNewsProfile, int countFeel, int countComment) {
        this.imgAvaProfile = imgAvaProfile;
        this.txtNameProfile = txtNameProfile;
        this.imgNewsProfile = imgNewsProfile;
        this.txtThinkNewsProfile = txtThinkNewsProfile;
        this.txtTimeNewsProfile = txtTimeNewsProfile;
        this.countFeel = countFeel;
        this.countComment = countComment;
    }

    public NewsItemProfile(String imgAvaProfile, String txtNameProfile, String imgNewsProfile, String txtThinkNewsProfile, String txtTimeNewsProfile) {
        this.imgAvaProfile = imgAvaProfile;
        this.txtNameProfile = txtNameProfile;
        this.imgNewsProfile = imgNewsProfile;
        this.txtThinkNewsProfile = txtThinkNewsProfile;
        this.txtTimeNewsProfile = txtTimeNewsProfile;
    }

    public int getPostsId() {
        return postsId;
    }

    public void setPostsId(int postsId) {
        this.postsId = postsId;
    }

    public String getImgAvaProfile() {
        return imgAvaProfile;
    }

    public void setImgAvaProfile(String imgAvaProfile) {
        this.imgAvaProfile = imgAvaProfile;
    }

    public String getTxtNameProfile() {
        return txtNameProfile;
    }

    public void setTxtNameProfile(String txtNameProfile) {
        this.txtNameProfile = txtNameProfile;
    }

    public String getImgNewsProfile() {
        return imgNewsProfile;
    }

    public void setImgNewsProfile(String imgNewsProfile) {
        this.imgNewsProfile = imgNewsProfile;
    }

    public String getTxtThinkNewsProfile() {
        return txtThinkNewsProfile;
    }

    public void setTxtThinkNewsProfile(String txtThinkNewsProfile) {
        this.txtThinkNewsProfile = txtThinkNewsProfile;
    }

    public String getTxtTimeNewsProfile() {
        return txtTimeNewsProfile;
    }

    public void setTxtTimeNewsProfile(String txtTimeNewsProfile) {
        this.txtTimeNewsProfile = txtTimeNewsProfile;
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

    public boolean isFeel() {
        return feel;
    }

    public void setFeel(boolean feel) {
        this.feel = feel;
    }
}
