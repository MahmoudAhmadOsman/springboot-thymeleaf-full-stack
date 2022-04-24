package com.mini.beans;

import javax.persistence.*;
import javax.validation.constraints.*;


@Entity
@Table(name = "courses")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotEmpty(message = "Title is required!")
    private String title;

    @NotEmpty(message = "Instructor name is required!")
    private String instructor;

    @NotEmpty(message = "Course description is required!")
    @Lob
    private String description;

    @NotNull
    @Min(1)
    @Max(4)
    @PositiveOrZero
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
