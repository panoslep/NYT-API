package com.panoslepipas.spring.project.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class Media {

    @JsonProperty("media-metadata")
    private List<MetaMedia> metaMedia;

}
