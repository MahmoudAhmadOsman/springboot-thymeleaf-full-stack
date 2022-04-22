## Spring Boot & Thymeleaf   CRUD RESTAPI

 Built  with [Spring](https://spring.io/projects/spring-boot) Boot, JPA, Thymeleaf and MYSQL.
## Used Technologies :+1: 
 * Spring Boot
 * Thymeleaf
 * MYSQL
 * JPA
 * Bootstrap 3


## Code Samples
#### Course Class with JPA annotations
 

```bash
package com.mini.model;

import org.springframework.format.annotation.NumberFormat;

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
```

## Display the course content in Thymeleaf template using Bootstrap
```bash
<section class="course-list-page" layout:fragment="content">
    <div class="container">
        <!-- Show success alert when a course is updated-->
        <div class="alert alert-info" role="alert" th:text="${successUpdate}" th:if="${successUpdate}"></div>
        <!-- Show delete success alert when a course is deleted-->
        <div class="alert alert-danger" role="alert" th:text="${deleteSuccess}" th:if="${deleteSuccess}"></div>
        <div class="row">
            <div class="col-md-10">
                <h1 class="text-info">List of Courses</h1>
                <hr>
            </div>
            <div class="col-md-2">
                <a href="/courses/add" class="btn btn-success">Add Course</a>
            </div>
        </div>
        <div class="row">
            <div class="col-md-3" th:each="course, stat : ${courses}">
            
                <div class="thumbnail">
                    <img src="https://source.unsplash.com/1600x900/?code" alt="course image">
                    <div class="caption">
                        <h3><a th:href="@{/courses/details/{id}(id=${course.id})}" th:text="${course.title}"></a> <span class="badge" th:text="${stat.index + 1}">1</span></h3>
                        <!-- <p><b>Instructor: </b>[[${course.instructor}]]</p>-->
                        <p><b>Credits: </b> [[${course.credit}]]</p>
                        <p> [[${course.description}]]</p>
                        <p>
                            <a th:href="@{/courses/details/{id}(id=${course.id})}" class="btn btn-primary" role="button">Details</a>
                        </p>
                    </div>
                </div>
         
            </div>
        </div>
    </div>
</section>
```








### My Website

Please, visit my website
[www.mahmoudosman.com](http://www.mahmoudosman.com/)

### Social Media

LinkedIn Profile Link: [LinkedIn](https://www.linkedin.com/in/mahmoudaoman/) 
