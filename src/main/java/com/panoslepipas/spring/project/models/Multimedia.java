package com.panoslepipas.spring.project.models;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Multimedia {

    private String src;

    public Multimedia(String src) {
        this.src = src;
    }
}

