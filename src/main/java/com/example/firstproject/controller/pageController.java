package com.example.firstproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class pageController {
//    @GetMapping("/sns/timeline")
//    public String mainPage() {
//        return "sns/main";
//    }

    @GetMapping("sns/login")
    public String loginPage(){
        return "sns/login";
    }
    @GetMapping("/login")
    public String loginPage2(){
        return "sns/login";
    }
    @GetMapping("/signup")
    public String signupPage(){
        return "sns/signup";
    }
    @GetMapping("/searchView")
    public String searchViewPage(){
        return "sns/searchView";
    }
}
