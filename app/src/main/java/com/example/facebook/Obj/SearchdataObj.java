package com.example.facebook.Obj;

public class SearchdataObj {
    private int userId;
    private String firstName;
    private String lastName;
    private String avatar;
    private String background;
    private String email;
    private String password;
    private String name;
    private int phone;
    private String followStatus;
    private int numberOfPosts;
    private int numberOfFollower;
    private int numberOfFollowing;
    private String token;
    private String dateCreate;
    private int follow;
    private String userSender;
    private String userRecipient;
    private String postsList;


    public SearchdataObj(int userId, String firstName, String lastName, String avatar, String background, String email, String password, String name, int phone, String followStatus, int numberOfPosts, int numberOfFollower, int numberOfFollowing, String token, String dateCreate, int follow, String userSender, String userRecipient, String postsList) {
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

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getFollowStatus() {
        return followStatus;
    }

    public void setFollowStatus(String followStatus) {
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
}
