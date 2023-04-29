package com.example.firstproject.controller;

import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FristController {
    @GetMapping("/hi")//get방식으로 hi라고 받으면
    public String hello(Model model){
        model.addAttribute("username","석");
        return "greetings";// templates/greetings.mustache를 찾아서 전송
    }
    @GetMapping("/bye")
    public String byebye(Model model){
        model.addAttribute("abc","석");
        return "goodbye";
    }
}
