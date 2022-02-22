package com.example.board.controller;

import com.example.board.service.ArticleService;
import java.util.HashMap;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@RequiredArgsConstructor
@RequestMapping("/articles")
@Controller
public class ArticleController {

    private final ArticleService articleService;

    @GetMapping
    public ModelAndView articles() {
        Map<String, Object> map = new HashMap<>();
        map.put("articles", articleService.getArticles());
        return new ModelAndView("articles/index", map);
    }

    @PostMapping("")
    public ModelAndView postArticle(@RequestBody Map<String, String> param) {
        Map<String, Object> article = new HashMap<>();
        article.put("likeCount", param.getOrDefault("likeCount", null));
//        "title", "content", "viewCount", "likeCount", "hashtag";

        return new ModelAndView("articles/index");
    }
}