package com.example.firstproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MemberController {
    @GetMapping("/member/signup")
    public String newSignup(){
        return "/member/signup";
    }
    @PostMapping("/member/create")
    public String createMember(){

    }
}
