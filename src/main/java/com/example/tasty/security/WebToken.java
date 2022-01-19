package com.example.tasty.security;

public class WebToken {

    private String username;
    private String expiryDate;
    private String token;

    public WebToken() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "WebToken{" +
                "username='" + username + '\'' +
                ", expiryDate='" + expiryDate + '\'' +
                ", token='" + token + '\'' +
                '}';
    }
}
