package com.example.facebook.Obj;

public class Post {
    private int postsId;
    private String caption;
    private int totalFeel;
    private int totalComment;
    private String dateCreate;
    private boolean feel;
    private PostUser postsUserList[] ;
    private String postsCommentList;
    private String postsFeelList;
    private PostImage postsImageList[];

    public Post(){}

    public Post(int postsId, String caption, int totalFeel, int totalComment, String dateCreate, boolean feel, PostUser[] postsUserList, String postsCommentList, String postsFeelList, PostImage[] postsImageList) {
        this.postsId = postsId;
        this.caption = caption;
        this.totalFeel = totalFeel;
        this.totalComment = totalComment;
        this.dateCreate = dateCreate;
        this.feel = feel;
        this.postsUserList = postsUserList;
        this.postsCommentList = postsCommentList;
        this.postsFeelList = postsFeelList;
        this.postsImageList = postsImageList;
    }

    public int getPostsId() {
        return postsId;
    }

    public void setPostsId(int postsId) {
        this.postsId = postsId;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public int getTotalFeel() {
        return totalFeel;
    }

    public void setTotalFeel(int totalFeel) {
        this.totalFeel = totalFeel;
    }

    public int getTotalComment() {
        return totalComment;
    }

    public void setTotalComment(int totalComment) {
        this.totalComment = totalComment;
    }

    public String getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(String dateCreate) {
        this.dateCreate = dateCreate;
    }

    public boolean isFeel() {
        return feel;
    }

    public void setFeel(boolean feel) {
        this.feel = feel;
    }

    public PostUser[] getPostsUserList() {
        return postsUserList;
    }

    public void setPostsUserList(PostUser[] postsUserList) {
        this.postsUserList = postsUserList;
    }

    public String getPostsCommentList() {
        return postsCommentList;
    }

    public void setPostsCommentList(String postsCommentList) {
        this.postsCommentList = postsCommentList;
    }

    public String getPostsFeelList() {
        return postsFeelList;
    }

    public void setPostsFeelList(String postsFeelList) {
        this.postsFeelList = postsFeelList;
    }

    public PostImage[] getPostsImageList() {
        return postsImageList;
    }

    public void setPostsImageList(PostImage[] postsImageList) {
        this.postsImageList = postsImageList;
    }
}
