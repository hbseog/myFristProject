package com.example.firstproject.controller;

import com.example.firstproject.entity.Member;
import com.example.firstproject.repository.MemberRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
@Slf4j
@Controller
public class SearchController {
    @Autowired
    MemberRepository memberRepository;
    @PostMapping("/search")
    public String searchUser(@RequestParam String name, Model model){
        List<Member> members = memberRepository.findByName(name);
        log.info(members.toString());
        model.addAttribute("info",members);
        return "sns/searchView";
    }
}
