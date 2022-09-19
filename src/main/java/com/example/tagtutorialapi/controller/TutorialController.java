package com.example.tagtutorialapi.controller;

import com.example.tagtutorialapi.repository.TutorialRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TutorialController {
    private final TutorialRepository tutorialRepository;

}
