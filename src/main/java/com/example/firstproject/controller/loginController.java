package com.example.firstproject.controller;

import com.example.firstproject.entity.Member;
import com.example.firstproject.repository.MemberRepository;
import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@Slf4j
@AllArgsConstructor
public class loginController {
    private final MemberRepository userRepository;
    @GetMapping("/sns/main")
    public String mainPage() {
        return "sns/main";
    }

    @PostMapping("/login")
    public String checkInfo(@RequestParam String email, @RequestParam String pass, HttpSession session, Model model) {
        log.info(email);
        log.info(pass);
        Member user = userRepository.findByEmail(email).orElse(null);
        if (user != null && user.getPass().equals(pass)) {
            // 로그인 성공
            session.setAttribute("user", user); // 세션 생성
            userRepository.findByEmail(email).
            model.addAttribute("username", user.getName());
            model.addAttribute("loginStatus", user.getLoginStatus());
            return "sns/main";
        } else {
            // 로그인 실패
            return "sns/login";
        }
    }
}
