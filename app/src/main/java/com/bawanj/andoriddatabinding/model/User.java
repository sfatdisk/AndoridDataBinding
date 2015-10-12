package com.bawanj.andoriddatabinding.model;


public class User {

    private String userName;
    private String userPassword;
    private boolean isExist;

    public User(String userName, String userPassword, boolean isExist) {
        this.userName = userName;
        this.userPassword = userPassword;
        this.isExist= isExist;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public boolean isExist() {
        return isExist;
    }

    public void setIsExist(boolean isExist) {
        this.isExist = isExist;
    }
}
