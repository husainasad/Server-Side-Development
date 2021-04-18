package com.upgrad.movieapp.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;


@Entity
public class Car {

  @Id
  private int carId;

  private String carName ;

  @OneToOne
  private Engine engine ;

  public int getCarId() {
    return carId;
  }

  public void setCarId(int carId) {
    this.carId = carId;
  }

  public String getCarName() {
    return carName;
  }

  public void setCarName(String carName) {
    this.carName = carName;
  }

  public Engine getEngine() {
    return engine;
  }

  public void setEngine(Engine engine) {
    this.engine = engine;
  }

  @Override
  public String toString() {
    return "Car{" + "carId=" + carId + ", carName='" + carName + '\'' + ", engine=" + engine + '}';
  }
}
