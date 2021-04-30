package com.upgrad.controllerdemo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
/**
 * Support multi uri
 */
@RequestMapping(value = {"/demo" , "/example"})
/**
 *  127.0.0.1:8080/demo
 */ public class DemoController {

  /**
   * 127.0.0.1:8080/demo/hello
   * GET
   * @return
   */
  @GetMapping(value= {"/hello","/greet"})
  public String helloStudents() {
    System.out.println("Method helloStudents() is invoked");
    return "Hello students from @RestController demo";
  }
}
