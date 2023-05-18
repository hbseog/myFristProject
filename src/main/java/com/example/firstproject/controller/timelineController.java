package com.example.firstproject.controller;

import com.example.firstproject.entity.Post;
import com.example.firstproject.repository.PostRepository;
import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Map;

@Controller
@Slf4j
@AllArgsConstructor
public class timelineController {
    UserControllerAdvice a =  new UserControllerAdvice();
    @Autowired
    PostRepository postRepository;
    @GetMapping("/sns/main")
    public String viewTimeline(HttpSession session, Model model){
        log.info("아이디는 " + a.idModel(session).toString());
        List<Post> post = postRepository.findByUserId(a.idModel(session));
        model.addAttribute("timeline","1");
        for(Post i : post) {
            model.addAttribute("text", i.getContent());
            log.info(post.toString());
        }
        return "sns/main";
    }
}
