package com.panoslepipas.spring.project.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class MovieRevApiResponse {

    String status;
    String copyright;
    int num_results;
    List<Movie> results;

}



