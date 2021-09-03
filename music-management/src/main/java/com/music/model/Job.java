package com.music.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

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
