package com.example.on_site_react_project_backend.models;

public class Profile {
    private final int id;
    private final String name;

    public Profile(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
