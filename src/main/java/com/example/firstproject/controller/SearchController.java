package com.example.firstproject.controller;

import com.example.firstproject.entity.Member;
import com.example.firstproject.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class SearchController {
    @Autowired
    MemberRepository memberRepository;
    @PostMapping("/search")
    public String searchUser(@RequestParam String name, Model model){
        List<Member> members = memberRepository.findByName(name);
        model.addAttribute("info",members);
        return "/searchView";
    }
}
