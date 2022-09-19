package com.example.tagtutorialapi.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Tutorial {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)

private Long id;
private String title;
private String description;
private boolean published;
@ManyToMany
 @JoinTable(name = "tutorial_tags", joinColumns = { @JoinColumn(name = "tutorial_id") }, inverseJoinColumns = { @JoinColumn(name = "tag_id") })
 private Set<Tag> tags = new HashSet<>();

public void  addTag(Tag tag){
 this.tags.add(tag);
 tag.getTutorials().add(this);
}
public void removeTag(long tagId){
 Tag tag = this.tags.stream().filter(t ->t.getId() ==tagId)
         .findFirst().orElse(null);
  if (tag !=null){
   this.tags.remove(tag);
   tag.getTutorials().remove(this);
  }
}
}
