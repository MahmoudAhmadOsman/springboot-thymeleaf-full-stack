package com.mini.model;

import javax.persistence.ManyToMany;
import java.util.Set;

public class Actor {
    private long id;
    private String name;
    private String realname;


    //Relationship ManyToMany
    @ManyToMany(mappedBy = "cast")
    private Set<Movie> movies;

    public Actor() {
    }

    public Actor(long id, String name, String realname) {
        this.id = id;
        this.name = name;
        this.realname = realname;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }
}
