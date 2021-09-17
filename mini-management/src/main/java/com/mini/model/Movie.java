package com.mini.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String title;
    private long year;
    private String description;


//    Many:Many Relationship
    @ManyToMany
    private Set<Actor> cast;

    public Movie() {
    }

    public Movie(long id, String title, long year, String description) {
        this.id = id;
        this.title = title;
        this.year = year;
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
