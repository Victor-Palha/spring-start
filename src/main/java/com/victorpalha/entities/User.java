package com.victorpalha.entities;

public class User {

    private int id;
    public String name;
    public String description;

    public User(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public User getUser() {
        return this;
    }
}
