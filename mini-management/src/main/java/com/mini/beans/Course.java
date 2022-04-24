package com.mini.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.*;



@Data
@AllArgsConstructor
@NoArgsConstructor
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

}
