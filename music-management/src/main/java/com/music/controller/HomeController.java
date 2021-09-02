package com.music.controller;

import com.music.model.Song;
import org.dom4j.rule.Mode;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {

    @GetMapping("/")
    public String index(){

        return  "index";
    }


    @RequestMapping("/songs")
    public String songs(){
        return  "songs";
    }

    @GetMapping("/form")
    public String loadFormPage(Model model) {
        model.addAttribute("song", new Song());
        return "form";
    }


    //Process form data
    @PostMapping("/form")
    public String loadFormPage(@ModelAttribute Song song, Model model) {
        model.addAttribute("song", song);
        return "songs";
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
