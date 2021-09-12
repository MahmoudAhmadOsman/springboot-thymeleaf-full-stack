package com.music.controller;

import com.music.model.Song;
import org.dom4j.rule.Mode;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class HomeController {

    @GetMapping("/")
    public String index(){
        return "index";
    }


    @RequestMapping("/songs")
    public String songs(){
        return "songs/songs";
    }


//  Song landing page
@GetMapping("/songs")
public String songsPage(){
    return
            "songs/songs";
}


    //Load the form
    @GetMapping("/songs/form")
    public String loadFormPage(Model model) {
        model.addAttribute("song", new Song());
        return "songs/form";
    }


    //Process form data
    @PostMapping("/songs/form")
    public String loadFormPage(@Valid @ModelAttribute Song song, Model model,  BindingResult result) {
       if(result.hasErrors()){
           return "songs/songs";
       }
       else{
           model.addAttribute("song", song);
           return "songs/songs";
       }

    }



    @GetMapping("/about")
    public String aboutPage() {
        return "about";
    }

    @GetMapping("/contact")
    public String contactPage() {
        return "contact";
    }




}
