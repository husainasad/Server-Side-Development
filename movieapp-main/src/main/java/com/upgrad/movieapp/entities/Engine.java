package com.upgrad.movieapp.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;


@Entity
public class Engine {

  @Id
  private int engineId ;
  private String engineName;
  @OneToOne(mappedBy = "engine")
  private Car car ;
}
