package com.music.controller;

import com.music.model.Song;
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


//    Song form


    @RequestMapping("/songform")
    public String loadFormPage(){

        return  "songform";
    }


//    @RequestMapping("/songform")
//    public  String loadFormPage(Model model){
//        model.addAttribute("song", new Song());
//        return "songform";
//    }

}
