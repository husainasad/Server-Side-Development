package com.upgrad.controllerdemo.controllers;

import com.upgrad.controllerdemo.dto.IdeaDTO;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;


@RestController
@RequestMapping(value = "/demo_app/v1")
public class IdeaController {

  /**
   * this acts as the in-memory storage of the ideas
   */
  private static final Map<Integer, IdeaDTO> IDEA_MAP = new HashMap<>() ;

  public IdeaController(){
    IdeaDTO ideaDTO1 = new IdeaDTO(121,"crazyIdea"
        ,"this will make people crazy","Vishwa");
    IdeaDTO ideaDTO2 = new IdeaDTO(122,"simpleIdea"
        ,"this will not make people crazy","Mohan");
    IDEA_MAP.put(ideaDTO1.getId(), ideaDTO1);
    IDEA_MAP.put(ideaDTO2.getId(), ideaDTO2);
  }

  /**
   *
   * CRUD :
   *
   * C - Create :  POST  @PostMapping
   * R - Read : GET  @GetMapping
   * U - Update : UPDATE   @PutMapping
   * D - Delete  : DELETE  @DeleteMapping
   */

  /**
   * Create an idea resource
   *
   * POST : 127.0.0.1:8080/demo_app/v1/ideas
   */
  @PostMapping(value = "/ideas" , consumes = MediaType.APPLICATION_JSON_VALUE,
  produces = MediaType.APPLICATION_JSON_VALUE)
   public ResponseEntity createIdea(@RequestBody IdeaDTO ideaDTO){
     System.out.println(ideaDTO);
     IDEA_MAP.put(ideaDTO.getId(), ideaDTO);
     return new ResponseEntity(ideaDTO, HttpStatus.CREATED);
   }

  /**
   *
   * I need to get all the ideas
   *
   * GET : 127.0.0.1:8080/demo_app/v1/ideas
   *
   */
  @GetMapping(value = "/ideas" , produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity fetchAllIdeas(){

    List<IdeaDTO> ideas =  new ArrayList<>();

    for(IdeaDTO ideaDTO : IDEA_MAP.values()){
      ideas.add(ideaDTO);
    }


    return new ResponseEntity(ideas, HttpStatus.OK);
  }

  /**
   *
   * C
   * R
   *
   * U -> Update | http : PUT Verb -> @PutMapping
   *
   *
   * PUT  :  127.0.0.1:8080/demo_app/v1/ideas   -- End point
   *
   * Request body : Json
   *
   *
   * path param -> @PathVariable
   *
   * request body -> @RequestBody
   *
   */
  @PutMapping(value = "/ideas/{id}" , consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity updateIdea(@PathVariable(value = "id") int id , @RequestBody IdeaDTO ideaDTO){
    IDEA_MAP.put(id, ideaDTO);
    return new ResponseEntity( ideaDTO, HttpStatus.ACCEPTED);
  }

  /**
   * Delete a resource
   *
   * DELETE  127.0.0.1:8080/demo_app/v1/ideas/{id}  -> @DeleteMapping
   *
   */
  @DeleteMapping(value = "/ideas/{id}")
  public ResponseEntity deleteIdea(@PathVariable(value="id") int id){

    IDEA_MAP.remove(id);
    return new ResponseEntity(null, HttpStatus.OK);
  }








  /**
   * I want to search an idea based on it's id
   * GET 127.0.0.1:8080/demo_app/ideas/121
   *
   * Response : Details about the response with id 121
   *
   */

  @GetMapping(value = "/ideas/{id}")
  public ResponseEntity fetchIdeaBasedOnId(@PathVariable(name="id") int id){

    return  new ResponseEntity(IDEA_MAP.get(id) , HttpStatus.OK);
  }
}
