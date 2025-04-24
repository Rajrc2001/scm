package com.scm.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.scm.entities.User;
import com.scm.forms.UserForm;
import com.scm.helpers.Message;
import com.scm.helpers.MessageType;
import com.scm.services.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
public class PageController {

    @Autowired
    private UserService userService;

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
    public String servicesPage() {
        System.out.println("Services page handler");
        return "services";

    }

    @GetMapping("/contact")
    public String contactPage() {
        return new String("contact");
    }

    @GetMapping("/login")
    public String loginPage() {
        return new String("login");
    }

    @GetMapping("/signup")
    public String signupPage(Model model) {

        UserForm userForm = new UserForm();
        model.addAttribute("userForm", userForm);

        return new String("signup");
    }

    // Registration Process controller
    @RequestMapping(value = "/register-user", method = RequestMethod.POST)
    public String processRegister(@ModelAttribute UserForm userForm, HttpSession session) {
        System.out.println("Registration Process...");

        System.out.println(userForm);

        // User user = new User();

        // user.setName(userForm.getName());
        // user.setEmail(userForm.getEmail());
        // user.setPassword(userForm.getPassword());
        // user.setAbout(userForm.getAbout());
        // user.setPhoneNumber(userForm.getPhoneNumber());

        User user = User.builder()
        .name(userForm.getName())
        .email(userForm.getEmail())
        .password(userForm.getPassword())
        .about(userForm.getAbout())
        .phoneNumber(userForm.getPhoneNumber())
        .build();

        User savedUser = userService.saveUser(user);
        System.out.println("User saved: \n" +savedUser);

        Message message = Message.builder().content("Registration Successfull.").type(MessageType.blue).build();
        session.setAttribute("message", message);


        return "redirect:/signup";
    }

}
