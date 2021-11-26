package com.example.demo.contollers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("title", "Главная страница");
        return "home";
    }
//    @GetMapping("/job12")
//    public String job(Model model) {
//        model.addAttribute("title", "Job page");
//        return "job";
//    }
}