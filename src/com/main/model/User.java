package com.main.model;

/**
 * @author Onkar Jadhav
 */
public class User {
    String currentUsername;
    String name;
    String email;

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public User(String currentUsername, String name, String email) {
        this.currentUsername = currentUsername;
        this.name = name;
        this.email = email;
    }

    public String getCurrentUsername() {
        return currentUsername;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
}
