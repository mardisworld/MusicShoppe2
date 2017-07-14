package com.musicshoppe2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by Marissa on 7/9/17.
 */

@Controller
public class HomeController {

    @RequestMapping("/")
    public String home() {
        return "home";
    }

    @RequestMapping("/login")
    public String login(@RequestParam(value = value-"error", required = false) String error, @RequestParam(value="logout",
    required = false) String logout, Model model) {
        if (error!=null) {
            model.addAttribute("error", "Invalid username and password.");

        }

        if (logout!=null) {
            model.addAttribute("msg", "You have been logged out successfully.");

        }
        return "login";
    }

}
