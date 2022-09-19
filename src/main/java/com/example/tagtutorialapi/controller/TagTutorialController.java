package com.example.tagtutorialapi.controller;

import com.example.tagtutorialapi.model.Tag;
import com.example.tagtutorialapi.model.Tutorial;
import com.example.tagtutorialapi.repository.TagRepository;
import com.example.tagtutorialapi.repository.TutorialRepository;
import com.example.tagtutorialapi.exceptions.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class TagTutorialController {
    private final TagRepository tagRepository;
    private final TutorialRepository tutorialRepository;

   @GetMapping("/tags")
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
    public ResponseEntity<List<Tutorial>>getAllTutorialsByTagsId(@PathVariable("tag") Long tagId){
       if (!tagRepository.existsById(tagId)){
           throw new ResourceNotFoundException("Not found tag  with id "+ tagId);
       }
       List<Tutorial>tutorials  = tutorialRepository.findTutorialByTagsId(tagId);
       return new ResponseEntity<>(tutorials,HttpStatus.OK);
    }
    public ResponseEntity<Tag>addTag(@PathVariable("tutorialId")Long tutorialId,@RequestBody Tag tagRequest){
       Tag tag  = tutorialRepository.findById(tutorialId).map(tutorial -> {
           long tagId = tagRequest.getId();
           if (tagId != 0L) {
               Tag _tag = tagRepository.findById(tagId)
                       .orElseThrow(() -> new ResourceNotFoundException("Tag wth id does not exist"));
               tutorial.addTag(_tag);
               tutorialRepository.save(tutorial);
               return _tag;
           }
           tutorial.addTag(tagRequest);
           return tagRepository.save(tagRequest);


       }).orElseThrow(()->new ResourceNotFoundException("not found with the giveb id"));
       return  new ResponseEntity<>(tag, HttpStatus.CREATED);
    }
    public ResponseEntity<Tag>updateTag(@PathVariable("id")Long id,@RequestBody Tag tagRequest){
       Tag tag  = tagRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("tutorial does not Exist"));
       tag.setName(tagRequest.getName());
       return  new ResponseEntity<>(tagRepository.save(tag), HttpStatus.OK);
    }
    public ResponseEntity<HttpStatus>deleteTagFromTutorial(@PathVariable("tutorialId")Long tutorialId, @PathVariable("tagId")Long tagId){
       Tutorial tutorial = tutorialRepository.findById(tutorialId).orElseThrow(()->new ResourceNotFoundException("tutorial does not Exist"));
       tutorial.removeTag(tagId);
       tutorialRepository.save(tutorial);
       return  new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    public ResponseEntity<HttpStatus>deleteTag(@PathVariable("id")Long tagId){
       tagRepository.deleteById(tagId);
       return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
