package com.mini.model;

import java.util.Collection;

public class Role {
    private long id;
    private String role;


    private Collection<User> users;


    public Role() {
    }


    public Role(long id, String role) {
        this.id = id;
        this.role = role;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
