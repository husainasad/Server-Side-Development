package com.upgrad.movieapp.dao;

import java.util.List;

import com.upgrad.movieapp.entities.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface CustomerRepository extends MongoRepository<Customer, Integer> {

  public Customer findByFirstName(String firstName);
  public List<Customer>  findByLastName(String lastName);
}
