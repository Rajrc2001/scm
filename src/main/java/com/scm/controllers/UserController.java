package com.scm.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping(value = "/dashboard", method=RequestMethod.GET)
    public String userDashboard() {
        return new String("user/dashboard");
    }

    @RequestMapping(value = "/profile", method=RequestMethod.GET)
    public String userProfile() {
        return new String("user/profile");
    }
    
}
