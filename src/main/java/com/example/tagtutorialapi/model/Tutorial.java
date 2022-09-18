package com.example.tagtutorialapi.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Tutorial {
private Long id;
private String title;
private String description;
private String published;
@ManyToMany(fetch = FetchType.LAZY,cascade = {
        CascadeType.PERSIST,
        CascadeType.MERGE
})
 @JoinTable(name = "tutorial_tags")
}

}
