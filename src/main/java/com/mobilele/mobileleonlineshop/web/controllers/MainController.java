package com.mobilele.mobileleonlineshop.web.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping()
public class MainController {

    @GetMapping("/")
    public String getIndex(){
        return "index";
    }

    @GetMapping("/home")
    public String getHome(){
        return "index";
    }



}
