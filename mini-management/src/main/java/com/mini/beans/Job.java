package com.mini.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Data
@AllArgsConstructor
@NoArgsConstructor
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
    @Lob
    private String description;



}