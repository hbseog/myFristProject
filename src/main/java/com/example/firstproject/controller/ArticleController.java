package com.example.firstproject.controller;

import com.example.firstproject.DTO.ArticleForm;
import com.example.firstproject.entity.Article;
import com.example.firstproject.repository.ArticleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j // 로깅을 위한 어노테이션
public class ArticleController {
    @Autowired
    ArticleRepository articleRepository;
    @GetMapping("/articles/new")
    public String newArticleController(){
        return "articles/new";
    }
    @PostMapping("/articles/create")
    public String createArticle(ArticleForm articleForm){
        log.info(articleForm.toString());
        //System.out.println();

        Article article = articleForm.toEntity(); //변환
        log.info(article.toString());
        //System.out.println(article.toString());

        Article saved = articleRepository.save(article);
        log.info(saved.toString());
        //System.out.println(saved.toString());
        return "";
    }
}
