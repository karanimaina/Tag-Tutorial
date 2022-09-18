package com.example.tagtutorialapi.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.security.CodeSigner;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@
@Setter


public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;
    private String name;

    private Set<Tutorial> tutorials= new HashSet<>();


}
