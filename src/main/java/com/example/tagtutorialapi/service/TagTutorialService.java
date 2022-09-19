package com.example.tagtutorialapi.service;

import com.example.tagtutorialapi.model.Tag;
import com.example.tagtutorialapi.model.Tutorial;
import com.example.tagtutorialapi.repository.TagRepository;
import com.example.tagtutorialapi.repository.TutorialRepository;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TagTutorialService {
    private final TagRepository tagRepository;
    private final TutorialRepository tutorialRepository;
   public ResponseEntity<List<Tag>>getAllTags(){
        List<Tag>tags = new ArrayList<>();
        tagRepository.findAll().forEach(tags::add);
        if (tags.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(tags,HttpStatus.OK);
    }
  public ResponseEntity<Tag>getTagsById(@PathVariable (value = "id")Long id){
       Tag tag  = tagRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Not found with tagId"));

       return  new ResponseEntity<>(tag,HttpStatus.OK);
  }
//  public ResponseEntity<List<Tag>>
    public ResponseEntity<List<Tag>>getAllTagsByTutorialId(@PathVariable("tutorial_id")Long tutoriald ){
       if (!tutorialRepository.existsById(tutoriald)){
           throw new ResourceNotFoundException("Not foundTutorial with id" + tutoriald);
       }
       List<Tag>tags  = tagRepository.findTagByTutorialsId(tutoriald);
        return new ResponseEntity<>(tags, HttpStatus.OK);
    }

}
