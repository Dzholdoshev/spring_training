package com.cydeo.cydeo.controller;

import com.cydeo.cydeo.model.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

@RequestMapping("/employees")
    public String empList(Model model){

    //database,API, data Generator
    model.addAttribute("name","TEST");

    return "employees-list.html";
    }

    @RequestMapping("/employee-info")
    public String empInfo(Model model){

        Employee emp1 = new Employee("Henry","Stone",90000);
        model.addAttribute("emp",emp1);

        return "employee-info.html";
    }
}
