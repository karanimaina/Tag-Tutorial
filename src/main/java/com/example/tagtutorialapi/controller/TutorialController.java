package com.example.tagtutorialapi.controller;

import com.example.tagtutorialapi.exceptions.ResourceNotFoundException;
import com.example.tagtutorialapi.model.Tutorial;
import com.example.tagtutorialapi.repository.TutorialRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class TutorialController {
    private final TutorialRepository tutorialRepository;

    @GetMapping("/tutorials")
    public ResponseEntity<List<Tutorial>>getAllTutorials(@RequestParam(required = false)String title){
        List<Tutorial> tutorials = new ArrayList<>();
        if (title == null)
            tutorialRepository.findAll().forEach(tutorials::add);
        else
            tutorialRepository.findByTitleContaining(title).forEach(tutorials::add);
        if (tutorials.isEmpty()){
            return  new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return  new ResponseEntity<>(tutorials,HttpStatus.OK);
    }

    @GetMapping("/tutorials/{id}")
    public ResponseEntity<Tutorial>getTutorialById(@PathVariable("id")Long id){
        Tutorial tutorial = tutorialRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Not found tutorial does not exist"));
        return  new ResponseEntity<>(tutorial,HttpStatus.OK);
    }
    @PostMapping("/tutorials")
    public ResponseEntity<Tutorial> createTutorial(@RequestBody Tutorial tutorial) {
        Tutorial _tutorial = tutorialRepository.save(Tutorial.builder()
                .description(tutorial.getDescription())
                .title(tutorial.getTitle())
                        .published(true)
                .build());
        return new ResponseEntity<>(_tutorial, HttpStatus.CREATED);
    }
    @
}
