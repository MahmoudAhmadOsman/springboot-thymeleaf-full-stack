package com.music.model;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Entity
@Table(name = "jobs")
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name="title", nullable = false)
    private String title;

    @Column(name = "employer", nullable = false)
    private String employer;

    @Column(name = "description", nullable = false)
    @Max(600)
    @Min(10)
    private String description;

}
