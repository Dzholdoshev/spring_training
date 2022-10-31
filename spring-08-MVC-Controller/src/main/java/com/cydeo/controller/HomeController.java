package com.cydeo.controller;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    @RequestMapping("/home")
    public String home(){
        return "home.html";
    }

    @RequestMapping("/ozzy")
    public String home1(){
        return "home.html";
    }

    @RequestMapping//nothing and /
    public String home2(){
        return "home.html";
    }
    @RequestMapping({"/apple","/orange"})
    public String home3(){
        return "home.html";
    }

    @RequestMapping({"/password"})
    public String password(){
        return "index.html";
    }

}
