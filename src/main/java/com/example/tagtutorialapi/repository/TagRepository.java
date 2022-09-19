package com.example.tagtutorialapi.repository;

import com.example.tagtutorialapi.model.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository extends JpaRepository<Tag,Long> {
}
