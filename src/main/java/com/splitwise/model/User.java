package com.splitwise.model;

public class User {
    private String userId;
    private String name;
    private String email;
    private String phoneNumber;

    public User(String userId, String name, String email, String phoneNumber) {
        this.userId =  userId;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }
}
