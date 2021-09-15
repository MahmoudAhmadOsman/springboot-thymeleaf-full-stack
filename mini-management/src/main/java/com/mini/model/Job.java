package com.mini.model;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "jobs")
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name="title", nullable = false)
    @NotEmpty(message = "Title is required")
    private String title;

    @NotEmpty(message = "Employer name is required")
    @Column(name = "employer", nullable = false)
    private String employer;

    @NotEmpty(message = "Jobs description  is required")
    @Column(name = "description", nullable = false)
    @Min(3)
    @Lob
    private String description;


    public Job() {
    }


    public Job(long id, String title, String employer, String description) {
        this.id = id;
        this.title = title;
        this.employer = employer;
        this.description = description;
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

    public String getEmployer() {
        return employer;
    }

    public void setEmployer(String employer) {
        this.employer = employer;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}