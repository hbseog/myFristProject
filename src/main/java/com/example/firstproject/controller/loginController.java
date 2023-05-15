package com.example.firstproject.controller;


import com.example.firstproject.entity.Image;
import com.example.firstproject.entity.Member;
import com.example.firstproject.entity.Post;
import com.example.firstproject.mapper.TimelineMapper;
import com.example.firstproject.model.TimelineViewModel;
import com.example.firstproject.repository.ImageRepository;
import com.example.firstproject.repository.MemberRepository;
import com.example.firstproject.repository.PostRepository;
import com.example.firstproject.service.TimelineService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@Slf4j
@AllArgsConstructor
public class loginController {
    private final MemberRepository userRepository;
    private final PostRepository postRepository;
    private final ImageRepository imageRepository;
    @Autowired
    private TimelineService timelineService;

    @PostMapping("/login")
    public String checkInfo(@RequestParam String email, @RequestParam String pass, HttpSession session, Model model) {
        log.info(email);
        log.info(pass);
        Member user = userRepository.findByEmail(email).orElse(null);

        if (user != null && user.getPass().equals(pass)) {
            // 로그인 성공
            user.setLoginstatus("1");
            userRepository.save(user);
            session.setAttribute("user", user); // 세션 생성
            model.addAttribute("username", user.getName());
            model.addAttribute("loginstatus", user.getLoginstatus());
            model.addAttribute("id",user.getId());
//            model.addAttribute()

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

    @GetMapping("/timeline")
    public ResponseEntity<TimelineViewModel> getTimeline() {
        // 게시글 정보 및 연관된 이미지 조회
        List<Post> posts = timelineService.getPosts(0); // 첫 페이지의 게시글을 가져옵니다. 원하는 페이지 번호를 인수로 전달하십시오.
        List<Image> images = timelineService.getImagePath(); // 이미지 목록을 가져옵니다.

        // ViewModel 생성
        TimelineViewModel viewModel = TimelineMapper.map(posts, images);
        return ResponseEntity.ok(viewModel);
    }
}
