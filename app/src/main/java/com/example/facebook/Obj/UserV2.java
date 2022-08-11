package com.example.facebook.Obj;

import java.io.Serializable;

public class UserV2 implements Serializable {
    private int userId;
    private String firstName;
    private String lastName ;
    private String avatar;
    private String background;
    private String email;
    private String password ;
    private String name ;
    private String phone ;
    private boolean followStatus ;
    private int numberOfPosts ;
    private int numberOfFollower ;
    private int numberOfFollowing;
    private String token;
    private String dateCreate;
    private int follow ;
    private String userSender ;
    private String userRecipient ;
    private String postsList ;
    private String songList ;
    private String listSongInfoList;

    public UserV2(){}

    public UserV2(int userId, String firstName, String lastName, String avatar, String background, String email, String password, String name, String phone, boolean followStatus, int numberOfPosts, int numberOfFollower, int numberOfFollowing, String token, String dateCreate, int follow, String userSender, String userRecipient, String postsList, String songList, String listSongInfoList) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.avatar = avatar;
        this.background = background;
        this.email = email;
        this.password = password;
        this.name = name;
        this.phone = phone;
        this.followStatus = followStatus;
        this.numberOfPosts = numberOfPosts;
        this.numberOfFollower = numberOfFollower;
        this.numberOfFollowing = numberOfFollowing;
        this.token = token;
        this.dateCreate = dateCreate;
        this.follow = follow;
        this.userSender = userSender;
        this.userRecipient = userRecipient;
        this.postsList = postsList;
        this.songList = songList;
        this.listSongInfoList = listSongInfoList;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getBackground() {
        return background;
    }

    public void setBackground(String background) {
        this.background = background;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public boolean getFollowStatus() {
        return followStatus;
    }

    public void setFollowStatus(boolean followStatus) {
        this.followStatus = followStatus;
    }

    public int getNumberOfPosts() {
        return numberOfPosts;
    }

    public void setNumberOfPosts(int numberOfPosts) {
        this.numberOfPosts = numberOfPosts;
    }

    public int getNumberOfFollower() {
        return numberOfFollower;
    }

    public void setNumberOfFollower(int numberOfFollower) {
        this.numberOfFollower = numberOfFollower;
    }

    public int getNumberOfFollowing() {
        return numberOfFollowing;
    }

    public void setNumberOfFollowing(int numberOfFollowing) {
        this.numberOfFollowing = numberOfFollowing;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(String dateCreate) {
        this.dateCreate = dateCreate;
    }

    public int getFollow() {
        return follow;
    }

    public void setFollow(int follow) {
        this.follow = follow;
    }

    public String getUserSender() {
        return userSender;
    }

    public void setUserSender(String userSender) {
        this.userSender = userSender;
    }

    public String getUserRecipient() {
        return userRecipient;
    }

    public void setUserRecipient(String userRecipient) {
        this.userRecipient = userRecipient;
    }

    public String getPostsList() {
        return postsList;
    }

    public void setPostsList(String postsList) {
        this.postsList = postsList;
    }

    public String getSongList() {
        return songList;
    }

    public void setSongList(String songList) {
        this.songList = songList;
    }

    public String getListSongInfoList() {
        return listSongInfoList;
    }

    public void setListSongInfoList(String listSongInfoList) {
        this.listSongInfoList = listSongInfoList;
    }
}
