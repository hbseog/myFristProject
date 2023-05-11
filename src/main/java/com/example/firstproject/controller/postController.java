package com.example.firstproject.controller;

import com.example.firstproject.entity.Image;
import com.example.firstproject.entity.Post;
import com.example.firstproject.repository.PostRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;

@Controller
@Slf4j
public class postController {
    @Autowired
    private PostRepository postRepository;

    @PostMapping("/post")
    public String createPost(@RequestParam("content") String content,
                             @RequestParam("images") MultipartFile[] files) {
        try {
            Post post = new Post(content);
            List<Image> images = new ArrayList<>();

            for (MultipartFile file : files) {
                if (!file.isEmpty()) {
                    String fileName = StringUtils.cleanPath(file.getOriginalFilename());
                    log.info("1");
                    Path filePath = Paths.get("/static/uploads").resolve(fileName);
                    log.info("2");
                    log.info(file.getInputStream().toString());
                    log.info(filePath.toString());
                    Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
                    log.info("3");

                    Image image = new Image(filePath.toString(), post);
                    log.info("4");
                    images.add(image);
                    log.info("5");
                }
            }

            post.setImages(images);
            log.info("6");
            postRepository.save(post);
            log.info("7");
            return "sns/main";

        } catch (IOException e) {
            throw new RuntimeException("Could not store the images. Please try again!", e);
        }
    }
}