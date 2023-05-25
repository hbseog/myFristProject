package com.example.firstproject.controller;


import com.example.firstproject.entity.Image;
import com.example.firstproject.entity.Member;
import com.example.firstproject.entity.Post;
import com.example.firstproject.repository.ImageRepository;
import com.example.firstproject.repository.MemberRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@Slf4j
@AllArgsConstructor
public class loginController {
    private final MemberRepository userRepository;
//    @Autowired
//    private TimelineService timelineService;

    @PostMapping("/login")
    public String checkInfo(@RequestParam String email, @RequestParam String pass, HttpSession session, Model model) {
        log.info(email);
        log.info(pass);
        Member user = userRepository.findByEmail(email).orElse(null);
//        log.info(user.toString());

        if (user != null && user.getPass().equals(pass)) {
            // 로그인 성공
            user.setLoginstatus("1");
            userRepository.save(user);
            session.setAttribute("user", user); // 세션 생성
            model.addAttribute("username", user.getName());
            model.addAttribute("loginstatus", user.getLoginstatus());
            model.addAttribute("id",user.getId());
//            model.addAttribute()

            return "redirect:sns/timeline";
//            return "sns/main";
        } else {
            // 로그인 실패
            return "sns/login";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            Member user = (Member) session.getAttribute("user");
            if (user != null) {
                user.setLoginstatus(null);
                userRepository.save(user);
            }
            session.invalidate(); // 세션 무효화
        }
        return "redirect:sns/login"; // 로그인 페이지로 리다이렉트
    }

    @GetMapping("/email-check")
    public ResponseEntity<Object> checkEmail(@RequestParam String email) {
        Member user = userRepository.findByEmail(email).orElse(null);
        if (user != null) {
            return ResponseEntity.ok(true);
        } else {
            return ResponseEntity.ok(false);
        }
    }

}
