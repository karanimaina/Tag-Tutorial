package com.example.tagtutorialapi.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.security.CodeSigner;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@AllArgsConstructor
@Setter
@NoArgsConstructor
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
@ManyToMany(fetch = FetchType.LAZY,mappedBy = "tags",,cascade = {
        CascadeType.PERSIST,
        CascadeType.MERGE
})
    private Set<Tutorial> tutorials= new HashSet<>();


}
