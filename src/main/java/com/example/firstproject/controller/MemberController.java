package com.example.firstproject.controller;


import com.example.firstproject.DTO.memberDto;
import com.example.firstproject.entity.Member;
import com.example.firstproject.repository.MemberRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@Slf4j
public class MemberController {
    @Autowired
    MemberRepository memberRepository;
    @GetMapping("/sns/signup")
    public String newSignup(){
        return "sns/signup";
    }
    @PostMapping("/create")
    public String createMember(memberDto memberDto){
        log.info(memberDto.toString());
        Member member = memberDto.memberEntity();
        log.info(member.toString());
        Member saved = memberRepository.save(member);
        log.info(saved.toString());
        return "sns/login";
    }

}
