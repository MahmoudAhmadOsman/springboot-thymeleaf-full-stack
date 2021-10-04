package com.mini.controller;

import com.mini.model.Job;
import com.mini.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller

public class JobController {
    @Autowired
    JobRepository jobRepository;

    @GetMapping("/jobs")
    public String list(){
        return  "jobs/list";
    }


    @RequestMapping("/jobs/list")
    public String listJobs(Model model){
        model.addAttribute("jobs", jobRepository.findAll());
        return "jobs/list";
    }


    //Add a job
    @GetMapping("/jobs/add")
    public String jobForm(Model model) {
        model.addAttribute("job", new Job());
        return "jobs/jobform";
    }

    //Process jobs form
    @PostMapping("/process")
    public String processForm(@Valid Job job, BindingResult result){
        if (result.hasErrors()){
            return "jobs/jobform";
        }
        jobRepository.save(job);
        return "redirect:/jobs/list";
    }


    //Show course Details
    @RequestMapping("/jobs/details/{id}")
    public  String showJob(@PathVariable("id") long id, Model model){
        model.addAttribute("job", jobRepository.findById(id).get());
        return "jobs/show";

    }


    //Delete job
    @RequestMapping("/deleteJob/{id}")
    public String deleteAJob(@PathVariable("id") long id, RedirectAttributes deljobSuccess){
        jobRepository.deleteById(id);
        deljobSuccess.addFlashAttribute("deljobSuccess", "Job has been deleted successfully!");
        return "redirect:/jobs/list";
    }



}
