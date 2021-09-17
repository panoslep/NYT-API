package com.panoslepipas.spring.project.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class Article {

    private String title;
    @JsonProperty("abstract")
    private String summary;
    private List<Media> media;
    private String url;

}

