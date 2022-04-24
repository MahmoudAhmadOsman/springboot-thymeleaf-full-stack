package com.mini.service;

import com.mini.beans.Course;
import com.mini.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class CourseService {
    @Autowired
    private CourseRepository courseRepository;


    //get method
    public List<Course> getListOfCourses(){
        try{
            return courseRepository.findAll();
        }catch (Exception e){
            throw new ResponseStatusException(
              HttpStatus.NOT_FOUND, "No courses found!", e
            );
        }

    }

//get by id

   public Course getCourseById(Long id) {
        try {
            return courseRepository.findById(id).get();
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "Can't find course with this id! ", e
            );
        }
   }


   //post method


public Course saveCourse(Course course){
        try {
            return courseRepository.save(course);
        }catch (Exception e){
            throw new ResponseStatusException(
              HttpStatus.BAD_REQUEST, "Unable to save this course! ", e
            );
        }
}


}
