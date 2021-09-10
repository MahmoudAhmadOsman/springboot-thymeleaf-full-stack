package com.music.controller;

import com.music.model.Job;
import com.music.model.Song;
import com.music.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
        return "redirect:/jobs";
    }




}
