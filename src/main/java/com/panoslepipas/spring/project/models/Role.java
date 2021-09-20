package com.panoslepipas.spring.project.models;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Role {

    @Id
    @GeneratedValue
    private Long id;

    private String role;

    public Role(String role) {
        this.role = role;
    }
}
