package com.music.controller;

import com.music.model.Course;
import com.music.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CourseController {

    @Autowired
    CourseRepository courseRepository;


    @GetMapping("/courses")
    public String list(){
        return  "courses/list";
    }

    @RequestMapping("/courses")
    public String listCourses(Model model){
        model.addAttribute("courses", courseRepository.findAll());
        return "courses/list";

    }


   //Add course
    @GetMapping("/courses/add")
   public String courseForm(Model model){
        model.addAttribute("course", new Course());
        return "courses/courseform";

   }



}
