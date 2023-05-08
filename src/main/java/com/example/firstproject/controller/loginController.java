package com.example.firstproject.controller;

import com.example.firstproject.entity.Member;
import com.example.firstproject.repository.MemberRepository;
import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@Slf4j
@AllArgsConstructor
public class loginController {
    private final MemberRepository userRepository;
    @GetMapping("/login")
    public String login(){
        return "/login/login";
    }
    @PostMapping("/login/try")
    public String checkInfo(@RequestParam String email, @RequestParam String pass, HttpSession session){
        log.info(email);
        log.info(pass);
        Member user = userRepository.findByEmail(email).orElse(null);
        if (user != null && user.getPass().equals(pass)) {
            // 로그인 성공
            session.setAttribute("user", user); // 세션 생성
            //return "redirect:/home/home"; // 홈 페이지로 리다이렉트
            return "home/home";
        } else {
            // 로그인 실패
            return "/login/login";
        }
    }
}
