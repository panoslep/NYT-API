package com.panoslepipas.spring.project.services;

import com.panoslepipas.spring.project.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;



@Service
public class ApiService {

    @Value("${url.mostpopular}")
    String siteURL;

    @Value("${api.key.mostpopular}")
    String apiKey;

    @Value("${url.moviereviews}")
    String siteMovieReviewsURL;

    @Value("${url.moviereviews2}")
    String siteMovieReviewsURL2;

    @Autowired
    RestTemplate restTemplate;

    public List<Article> getMostPopular() {

        ApiResponse response = restTemplate.getForObject(siteURL+apiKey, ApiResponse.class);
        if (response == null) {
            return new ArrayList<>();
        } else {
            return response.getResults();
        }
    }


    public List<Movie> getMovieReviews(String query) {

        MovieRevApiResponse response = restTemplate.getForObject(siteMovieReviewsURL + query + siteMovieReviewsURL2 +apiKey, MovieRevApiResponse.class);
        if (response == null) {
            return new ArrayList<>();
        } else {
            return response.getResults();
        }
    }

}

