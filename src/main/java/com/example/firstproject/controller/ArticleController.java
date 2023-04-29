package com.example.firstproject.controller;

import com.example.firstproject.dto.ArticleForm;
import com.example.firstproject.entity.Article;
import com.example.firstproject.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ArticleController {
    @Autowired
    ArticleRepository articleRepository;
    @GetMapping("/articles/new")
    public String newArticleController(){
        return "articles/new";
    }
    @PostMapping("/articles/create")
    public String createArticle(ArticleForm articleForm){
        System.out.println(articleForm.toString());

        Article article = articleForm.toEntity(); //변환
        System.out.println(article.toString());

        Article saved = articleRepository.save(article);
        System.out.println(saved.toString());
        return "";
    }
}
