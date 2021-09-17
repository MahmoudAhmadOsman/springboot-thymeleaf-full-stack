package com.mini.controller;

import com.mini.model.Course;
import com.mini.repository.CourseRepository;
import org.dom4j.rule.Mode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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


    //Show Courses
    @RequestMapping("/courses/show")
    public String showCourses(Model model){
        model.addAttribute("courses", courseRepository.findAll());
        return "courses/show";
    }

    //Add a course
    @GetMapping("/courses/add")
    public String courseForm(Model model) {
        model.addAttribute("course", new Course());
        return "courses/courseform";
    }

    //Process course form
    @PostMapping("/processCourses")
    public String processForm(@Valid Course job, Errors errors, RedirectAttributes redirAttrs){
        if (errors.hasErrors()) {
            return "courses/courseform";
        } else {
            courseRepository.save(job);
            redirAttrs.addFlashAttribute("success", "New courses has been added successfully!");
            return "redirect:/courses/add";
        }
    }


    //Show course Details
    @RequestMapping("/courses/details/{id}")
    public  String showCourse(@PathVariable("id") long id, Model model){
        model.addAttribute("course", courseRepository.findById(id).get());
        return "courses/show";

    }

    //Update Course -- ku noqo oo dhamaystir
    @RequestMapping("/courses/update/{id}")
    public String updateCourse(@PathVariable("id") long id, Model model){
        model.addAttribute("course", courseRepository.findById(id).get());
        return "courses/update";
    }


    //Delete Course
    @RequestMapping("/delete/{id}")
    public String deleteCourse(@PathVariable("id") long id){
        courseRepository.deleteById(id);
        return "redirect:/courses/list";
    }

}
