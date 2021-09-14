package com.music.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
@Table(name = "courses")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull
    @Size(min = 3)

    private String title;

    @NotNull
    @Size(min = 3)
    private String instructor;

    @NotNull
    @Size(min = 10)
    private String description;


    @NotNull
    @Size(min = 3)
    private int credit;


    public Course() {
    }

    public Course(long id, String title, String instructor, String description, int credit) {
        this.id = id;
        this.title = title;
        this.instructor = instructor;
        this.description = description;
        this.credit = credit;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getInstructor() {
        return instructor;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }
}
