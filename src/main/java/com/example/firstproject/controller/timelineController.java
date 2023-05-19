package com.example.firstproject.controller;

import com.example.firstproject.entity.Image;
import com.example.firstproject.entity.Post;
import com.example.firstproject.repository.ImageRepository;
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
import java.util.Optional;

@Controller
@Slf4j
@AllArgsConstructor
public class timelineController {
    UserControllerAdvice a =  new UserControllerAdvice();
    @Autowired
    PostRepository postRepository;
    @Autowired
    ImageRepository imageRepository;
    @GetMapping("/sns/timeline")
    public String viewTimeline(HttpSession session, Model model){
        log.info("아이디는 " + a.idModel(session).toString());
        List<Post> post = postRepository.findByUserIdOrderByCreatedAtDesc(a.idModel(session));
        log.info(String.valueOf(post.size()));
        for(Post i : post){
            List<Image> images = imageRepository.findByPost(i);
            i.setImages(images);
//            if(i.getContent() == ""null""){
//                i.setContent("123");
//                postRepository.saveAll(post);
//            }
        }
//        for(Post i : post) {
//            List<Image> images = imageRepository.findByPost(i);
//            model.addAttribute("imageUrl", images);
////            model.addAttribute("text", i.getContent());
//            log.info(i.toString());
//        }
        model.addAttribute("timeline",post);



        return "sns/main";
    }
}
