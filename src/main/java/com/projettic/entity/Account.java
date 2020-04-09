package com.projettic.entity;

import lombok.Data;

@Data
public class Account {
    private int userId;
    private String userName;
    private String userPassword;
    private String userEmail;
    private int userClass;

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


}
