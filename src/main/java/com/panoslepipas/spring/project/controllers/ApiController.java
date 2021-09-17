package com.panoslepipas.spring.project.controllers;

import com.panoslepipas.spring.project.models.Article;
import com.panoslepipas.spring.project.models.Movie;
import com.panoslepipas.spring.project.services.ApiService;
import org.dom4j.rule.Mode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ApiController {

    //inject the service into the method
    @Autowired
    ApiService apiService;

    @GetMapping
    public String goToIndex(Model model) {
        return "index";
    }

    @GetMapping("/most-popular")
    // This is going to interact with the service.
    public String displayMostPopular(Model model) {

        List<Article> articleList = apiService.getMostPopular();
        model.addAttribute("articleList", articleList);

        return "most-popular";
    }

    @GetMapping("/movie-reviews")
    public String displayMovieReviews(@RequestParam(name = "q", required = false, defaultValue = "movie") String query, Model model) {

        List<Movie> movieList = apiService.getMovieReviews(query);
        model.addAttribute("movieList", movieList);
        return "movie-reviews";
    }

    @PostMapping("/movie-reviews")
    public String postMovieReviews(@RequestParam(name = "q", required = false) String query, Model model) {

        List<Movie> movieList = apiService.getMovieReviews(query);
        model.addAttribute("movieList", movieList);
        return "movie-reviews";
    }

}
