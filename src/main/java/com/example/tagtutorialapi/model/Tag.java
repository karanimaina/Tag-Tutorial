package com.example.tagtutorialapi.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter


public class Tag {
    private Long id;
    private String name;
    private Set<Tutorial> tutorials= new HashSet<>();


}
