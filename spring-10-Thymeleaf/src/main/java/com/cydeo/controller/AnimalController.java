package com.cydeo.controller;


import com.cydeo.bootstrap.DataGenerator;
import com.cydeo.model.Animal;
import com.cydeo.model.Mentor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/animal")
public class AnimalController {

    @RequestMapping("/home")
    public String home(){
        return "animal/home";
    }

    @GetMapping("/shop") //localhost:8080/animal/register
    public String buy(Model model){

        model.addAttribute("animal", DataGenerator.createAnimals());

        return "animal/shop";
    }

    @PostMapping("/confirm")
    public String submitForm(@ModelAttribute("mentor") Animal animal){

        // return "mentor/mentor-confirmation";
        //    model.addAttribute("mentor", new Mentor());

        return "redirect:/mentor/register";

    }


}
