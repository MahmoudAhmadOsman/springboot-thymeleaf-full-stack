package com.mini.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Past;
import java.util.Set;

@Entity
@Table(name = "movies")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotEmpty(message = "Moive title is required!")
    private String title;

    @NotEmpty(message = "Movie year required!")
    @Past
    private long year;

    @NotEmpty(message = "Movie description is required!")
    @Lob
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
