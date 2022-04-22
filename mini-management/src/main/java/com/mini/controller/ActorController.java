package com.mini.controller;

import com.mini.beans.Actor;
import com.mini.repository.ActorRepository;
import com.mini.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class ActorController {

    @Autowired
    ActorRepository actorRepository;

    @Autowired
    MovieRepository movieRepository;


//Actors list
    @GetMapping("/actors")
    public String list(){
        return  "actors/list";
    }

    //Actor Request mapping
    @RequestMapping("/actors/list")
    public String listActors(Model model){
        model.addAttribute("actors", actorRepository.findAll());
//        model.addAttribute("movies", movieRepository.findAll());
        return "actors/list";
    }


    //Add an actor
    @GetMapping("/actors/add")
    public String actorForm(Model model) {
        model.addAttribute("actor", new Actor());
//        model.addAttribute("movie", new Movie());
        return "actors/actorform";
    }



    //Process Actor form
    @PostMapping("/processActorForm")
    public String processActorForm(@Valid Actor actor, Errors errors, RedirectAttributes redirectActors){
        if (errors.hasErrors()) {
            return "actors/actorform";
        } else {
            actorRepository.save(actor);
//            movieRepository.save(movie);
            redirectActors.addFlashAttribute("success", "New actor has been registered successfully!");

            return "redirect:/actors/add";
        }
    }







}
