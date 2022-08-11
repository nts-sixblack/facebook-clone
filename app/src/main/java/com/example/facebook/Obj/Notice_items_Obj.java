package com.example.facebook.Obj;

public class Notice_items_Obj {
    private String noticeImg;
    private String noticeName;
    private String noticeContent;
    private String noticeTime;

    public Notice_items_Obj(String noticeImg, String noticeName, String noticeContent, String noticeTime) {
        this.noticeImg = noticeImg;
        this.noticeName = noticeName;
        this.noticeContent = noticeContent;
        this.noticeTime = noticeTime;
    }

    public String getNoticeImg() {
        return noticeImg;
    }

    public void setNoticeImg(String noticeImg) {
        this.noticeImg = noticeImg;
    }

    public String getNoticeName() {
        return noticeName;
    }

    public void setNoticeName(String noticeName) {
        this.noticeName = noticeName;
    }

    public String getNoticeContent() {
        return noticeContent;
    }

    public void setNoticeContent(String noticeContent) {
        this.noticeContent = noticeContent;
    }

    public String getNoticeTime() {
        return noticeTime;
    }

    public void setNoticeTime(String noticeTime) {
        this.noticeTime = noticeTime;
    }
}
