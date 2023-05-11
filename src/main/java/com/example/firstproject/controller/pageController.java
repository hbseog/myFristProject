package com.example.firstproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class pageController {
    @GetMapping("/sns/main")
    public String mainPage() {
        return "sns/main";
    }
    @GetMapping("/login")
    public String loginPage(){
        return "sns/login";
    }
    @GetMapping("/signup")
    public String signupPage(){
        return "sns/signup";
    }
}
