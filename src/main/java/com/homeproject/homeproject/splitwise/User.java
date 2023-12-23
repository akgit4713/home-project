package com.homeproject.homeproject.splitwise;

import java.util.UUID;

public class User {
    private String name;
    private String id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public User(String name) {
        this.name = name;
        this.id = UUID.randomUUID().toString();
    }
}
