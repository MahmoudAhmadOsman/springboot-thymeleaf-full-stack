package com.music.controller;

import com.music.model.Job;
import com.music.model.Song;
import com.music.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

public class JobController {
    @Autowired
    JobRepository jobRepository;




    //Get the form
    @GetMapping("/list")
    public String loadJobPage(Model model) {
        model.addAttribute("job", new Job());
        return "list";
    }


    @RequestMapping("/jobs")
    public String listJobs(Model model){
        model.addAttribute("jobs", jobRepository.findAll());
        return "list";
    }
}
