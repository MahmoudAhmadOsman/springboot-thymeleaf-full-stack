package com.mini.controller;

import com.mini.model.Course;
import com.mini.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
public class CourseController {

    @Autowired
    CourseRepository courseRepository;


    @GetMapping("/courses")
    public String list(){
        return  "courses/list";
    }

    //Courses List
    @RequestMapping("/courses/list")
    public String listCourses(Model model){
        model.addAttribute("courses", courseRepository.findAll());
        return "courses/list";
    }


    //Add a course
    @GetMapping("/courses/add")
    public String courseForm(Model model) {
        model.addAttribute("course", new Course());
        return "courses/courseform";
    }



    //Process course form
    @PostMapping("/processCourses")
    public String processForm(@Valid Course job, BindingResult result){
        if (result.hasErrors()){
            return "courses/courseform";
        }
        courseRepository.save(job);
        return "redirect:/courses/list";
    }


}
