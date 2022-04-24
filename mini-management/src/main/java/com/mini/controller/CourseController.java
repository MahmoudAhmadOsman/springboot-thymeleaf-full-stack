package com.mini.controller;

import com.mini.beans.Course;
import com.mini.repository.CourseRepository;
import com.mini.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class CourseController {
    @Autowired
    private CourseService courseService;

    @Autowired
    CourseRepository courseRepository;


    //Courses List
        @RequestMapping(value = "/courses/list")
        public String listCourses(Model model){
            //model.addAttribute("courses", courseRepository.findAll());
            model.addAttribute("courses", courseService.getListOfCourses());
            return "courses/list";
        }


    //Show Courses
        @RequestMapping(value = "/courses/show")
        public String showCourses(Model model){
            // model.addAttribute("courses", courseRepository.findAll());
            model.addAttribute("courses", courseService.getListOfCourses());
            return "courses/show";
        }

    //Add a course
        @GetMapping(value = "/courses/add")
        public String courseForm(Model model) {
            model.addAttribute("course", new Course());
            return "courses/courseform";
        }


    //Process course form
        @PostMapping(value = "/processCourses")
        public String processForm(@Valid Course course, Errors errors, RedirectAttributes redirAttrs){
          try{
              if (errors.hasErrors()){
                  return "courses/courseform";
              }else {
                  courseService.saveCourse(course);
                  redirAttrs.addFlashAttribute("success", "New courses has been added successfully!");
                  return "redirect:/courses/add";
              }
          }catch (Exception e){
              throw  new ResponseStatusException(
                      HttpStatus.BAD_REQUEST,
                      "Unable to save course", e
              );
          }
        }



    //Update Course and show success message
    @PostMapping(value = "/updateCourses")
    public String processUpdate(@Valid Course job, Errors errors, RedirectAttributes successRedirect){
        if (errors.hasErrors()) {
            return "courses/courseform";
        } else {
            courseRepository.save(job);
            successRedirect.addFlashAttribute("successUpdate", "Course has been updated successfully!");
            return "redirect:/courses/list";
        }
    }


    //Show course Details
    @RequestMapping(value = "/courses/details/{id}")
    public  String showCourse(@PathVariable("id") long id, Model model){
    //  model.addAttribute("course", courseRepository.findById(id).get());
        model.addAttribute("course", courseService.getCourseById(id));
        return "courses/show";

    }

    //Update Course -- ku noqo oo dhamaystir
    @RequestMapping(value = "/courses/update/{id}")
    public String updateCourse(@PathVariable("id") long id, Model model){
        model.addAttribute("course", courseRepository.findById(id).get());
        return "courses/update";

    }


    //Delete Course
    @RequestMapping(value = "/delete/{id}")
    public String deleteCourse(@PathVariable("id") long id, RedirectAttributes delSuccess){
        courseRepository.deleteById(id);
        delSuccess.addFlashAttribute("deleteSuccess", "Course has been deleted successfully!");
        return "redirect:/courses/list";
    }

}
