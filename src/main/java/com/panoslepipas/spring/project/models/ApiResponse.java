package com.panoslepipas.spring.project.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class ApiResponse {

    String status;
    String copyright;
    int num_results;
    List<Article> results;


}

