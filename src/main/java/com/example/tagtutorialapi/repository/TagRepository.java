package com.example.tagtutorialapi.repository;

import com.example.tagtutorialapi.model.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TagRepository extends JpaRepository<Tag,Long> {
    List<Tag>findTagByTutorialsId(Long tutorialId);
}
