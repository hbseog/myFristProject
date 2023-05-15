package com.example.firstproject.controller;

import com.example.firstproject.entity.Member;
import com.example.firstproject.entity.Post;
import com.example.firstproject.repository.ImageRepository;
import com.example.firstproject.repository.MemberRepository;
import com.example.firstproject.repository.PostRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@Slf4j
@AllArgsConstructor
public class loginController {
    private final MemberRepository userRepository;
    private final PostRepository postRepository;
    private final ImageRepository imageRepository;

    @PostMapping("/login")
    public String checkInfo(@RequestParam String email, @RequestParam String pass, HttpSession session, Model model) {
        log.info(email);
        log.info(pass);
        Member user = userRepository.findByEmail(email).orElse(null);
//        Post post = postRepository.findBy

        if (user != null && user.getPass().equals(pass)) {
            // 로그인 성공
            user.setLoginstatus("1");
            userRepository.save(user);
            session.setAttribute("user", user); // 세션 생성
            model.addAttribute("username", user.getName());
            model.addAttribute("loginstatus", user.getLoginstatus());
            return "redirect:sns/main";
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
