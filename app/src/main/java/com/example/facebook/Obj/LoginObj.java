package com.example.facebook.Obj;

public class LoginObj {
    private String access_token;
    private String token_type;
    private int expires_in;
    private User user;

    public LoginObj(String access_token, String token_type, int expires_in, User user) {
        this.access_token = access_token;
        this.token_type = token_type;
        this.expires_in = expires_in;
        this.user = user;
    }

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public String getToken_type() {
        return token_type;
    }

    public void setToken_type(String token_type) {
        this.token_type = token_type;
    }

    public int getExpires_in() {
        return expires_in;
    }

    public void setExpires_in(int expires_in) {
        this.expires_in = expires_in;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
