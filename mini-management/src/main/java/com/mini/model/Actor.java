package com.mini.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Set;


@Entity

@Table(name = "actors")
public class Actor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotEmpty(message = "Actor name is required!")
    private String name;

    @NotEmpty(message = "Actor real name is required!")
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
