package com.example.wtmapp;

import java.io.Serializable;
import java.util.HashMap;

public class Users implements Serializable {

    private String name;
    private String id;
    private String email;
    private String photoUrl;

    public Users() {
    }

    public Users(String id, String name, String email , String photoUrl) {
        this.email = email;
        this.name = name;
        this.id = id;
        this.photoUrl = photoUrl;
    }

    public String getUserName() {
        return name;
    }

    public void setUserName(String name) {
        this.name = name;
    }

    public String getUserEmail() {
        return email;
    }

    public void setUserEmail(String email) {
        this.email = email;
    }

    public String getUserKey() {
        return id;
    }

    public void setUserKey(String id) {
        this.id = id;
    }

    public String getUserPhotoUrl() {
        return photoUrl;
    }

    public void setUserPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public HashMap<String,String> toUsersFirebaseObject() {
        HashMap<String,String> user =  new HashMap<String,String>();
        user.put("user_name", name);
        user.put("user_email", email);
        user.put("user_photo", photoUrl);
        user.put("user_id",id);
        return user;
    }



}
