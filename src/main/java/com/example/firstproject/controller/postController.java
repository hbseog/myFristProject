package com.example.firstproject.controller;

import com.example.firstproject.entity.Image;
import com.example.firstproject.entity.Member;
import com.example.firstproject.entity.Post;
import com.example.firstproject.repository.PostRepository;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Controller
@Slf4j
public class postController {
    @Autowired
    private PostRepository postRepository;

    @PostMapping("/post")
    public String createPost(@RequestParam("content") String content,
                             @RequestParam("images") MultipartFile[] files, HttpSession session) {
        try {
            Post post = new Post(content);
            List<Image> images = new ArrayList<>();

            for (MultipartFile file : files) {
                if (!file.isEmpty()) {
                    String fileName = StringUtils.cleanPath(file.getOriginalFilename());
                    String fileExtension = fileName.substring(fileName.lastIndexOf("."));
                    String uniqueFileName = UUID.randomUUID().toString() + fileExtension;
                    Path filePath = Paths.get("C:\\lecture\\firstproject\\src\\main\\resources\\static\\uploads").resolve(uniqueFileName);
                    Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
                    Image image = new Image(filePath.toString(), post);
                    images.add(image);
                }
            }
            post.setImages(images);
            UserControllerAdvice a = new UserControllerAdvice();
            post.setUser_id(a.idModel(session));
            postRepository.save(post);
            return "sns/main";

        } catch (IOException e) {
            throw new RuntimeException("Could not store the images. Please try again!", e);
        }
    }
}