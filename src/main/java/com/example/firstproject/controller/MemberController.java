package com.example.firstproject.controller;

import com.example.firstproject.dto.MemberDto;
import com.example.firstproject.entity.Member;
import com.example.firstproject.repository.MemberRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class MemberController {
    MemberRepository memberRepository;
    @GetMapping("/member/signup")
    public String newSignup(){
        return "/member/signup";
    }
    @PostMapping("/member/create")
    public String createMember(MemberDto memberDto){
        log.info(memberDto.toString());
        Member member = memberDto.memberEntity();
        log.info(member.toString());
        Member saved = memberRepository.save(member);
        log.info(saved.toString());
        return "";
    }
}
