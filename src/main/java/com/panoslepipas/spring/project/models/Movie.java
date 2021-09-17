package com.panoslepipas.spring.project.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class Movie {
    private String display_title;
    private String summary_short;
    private Multimedia multimedia;
    private Link link;


    public void setMultimedia(Multimedia multimedia) {
        if (multimedia == null) {
            this.multimedia = new Multimedia("/images/default.jpg");
        } else {
            this.multimedia = multimedia;
        }
    }
}





