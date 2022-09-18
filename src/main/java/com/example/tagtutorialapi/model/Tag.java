package com.example.tagtutorialapi.model;

import lombok.Getter;

import javax.persistence.Entity;

@Entity
@Getter

public class Tag {
    private Long id;
    private String name;


}
