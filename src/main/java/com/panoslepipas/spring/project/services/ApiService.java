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

    //hint - use code from other projects
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



//    // this method is used for testing
//    public Article populateArticle(){
//        Article testArticle = new Article();
//        testArticle.setTitle("test title");
//        testArticle.setSummary("test abstract");
//        MetaMedia testMeta = new MetaMedia();
//        testMeta.setUrl("https://platform.codingnomads.co/learn/theme/image.php/maker/theme/1614200408/favicon");
//        Media testMedia = new Media();
//        testMedia.setMetaMedia(new ArrayList<MetaMedia>(Collections.singletonList(testMeta)));
//        testArticle.setMedia(new ArrayList<Media>(Collections.singletonList(testMedia))); //allows to create a list with one item through the constructor
//
//        return testArticle;
//    }

}

