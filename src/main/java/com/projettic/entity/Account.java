package com.projettic.entity;

public class Account {
    private int userId;
    private String userName;
    private String userPassword;
    private String userEmail;
    private int userClass;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public int getUserClass() {
        return userClass;
    }

    public void setUserClass(int userClass) {
        this.userClass = userClass;
    }

    @Override
    public String toString() {
        return "Account{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", userClass=" + userClass +
                '}';
    }

    public boolean isEquals(Account accountDb) {
//        if(this.userName.length() != 0){
//            if (this.userName.equals(accountDb.getUserName())) {
//                return this.userPassword.equals(accountDb.getUserPassword()) && this.userClass == accountDb.getUserClass();
//            }
//        } else {
//            if (this.userEmail.equals(accountDb.getUserEmail())) {
//                return this.userPassword.equals(accountDb.getUserPassword()) && this.userClass == accountDb.getUserClass();
//            }
//        }
//        return false;
        return (this.getUserPassword().equals(accountDb.getUserPassword()) && this.userClass == accountDb.getUserClass());
    }
}
