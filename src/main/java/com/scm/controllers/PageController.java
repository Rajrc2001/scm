package com.scm.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {

    @RequestMapping("/home")
    public String home(Model model) {

        System.out.println("Home page handler!");

        model.addAttribute("name", "Raj Technologies!");
        model.addAttribute("githubProfile", "rajrc2001");
        model.addAttribute("githubRepoLink", "https://github.com/Rajrc2001");

        return "home";
    }

    @RequestMapping("/about")
    public String aboutPage(Model model) {

        System.out.println("About page handler");

        model.addAttribute("isLogin", false);
        return "about";

    }

    @RequestMapping("/services")
    public String servicesPage()
    {
        System.out.println("Services page handler");
        return "services";
        
    }
}
