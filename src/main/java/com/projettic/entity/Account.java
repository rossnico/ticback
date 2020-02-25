package com.projettic.entity;

public class Account {
    private int uid;
    private String username;
    private String password;
    private String email;
    private int groupid;

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getGroupid() {
        return groupid;
    }

    public void setGroupid(int groupid) {
        this.groupid = groupid;
    }

    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", groupid=" + groupid +
                '}';
    }

    public boolean isEquals(Account accountDb) {
        if(this.username.length() != 0){
            if (this.username.equals(accountDb.getUsername())) {
                return this.password.equals(accountDb.getPassword()) && this.groupid == accountDb.getGroupid();
            }
        } else {
            if (this.email.equals(accountDb.getEmail())) {
                return this.password.equals(accountDb.getPassword()) && this.groupid == accountDb.getGroupid();
            }
        }
        return false;
    }

}
