package com.example.tagtutorialapi.repository;

import com.example.tagtutorialapi.model.Tutorial;
import org.springframework.boot.json.JacksonJsonParser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TutorialRepository extends JpaRepository<Tutorial,Long> {
    List<Tutorial>findByPublished(boolean Published);
    List<Tutorial>findByTitleContaining(String title);
    List<Tutorial>findTutorialByTagsId(Long tagId);

}
