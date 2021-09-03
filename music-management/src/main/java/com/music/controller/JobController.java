package com.music.controller;

import com.music.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

public class JobController {
    @Autowired
    JobRepository jobRepository;

    @RequestMapping("/jobs")
    public String listJobs(Model model){
        model.addAttribute("jobs", jobRepository.findAll());
        return "list";
    }
}
