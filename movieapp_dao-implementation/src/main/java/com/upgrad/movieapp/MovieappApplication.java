package com.upgrad.movieapp;

import com.upgrad.movieapp.dao.CustomerDao;
import com.upgrad.movieapp.entities.Customer;
import java.time.LocalDateTime;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.RestController;


@RestController
@SpringBootApplication
public class MovieappApplication {

  public static void main(String[] args) {

    ApplicationContext context = SpringApplication.run(MovieappApplication.class, args);
    CustomerDao customerDao = context.getBean(CustomerDao.class);
    Customer customer = new Customer();
    customer.setFirstName("Emma");
    customer.setLastName("Stone");
    customer.setUsername("emma123stone");
    customer.setPassword("emma@amme");
    customer.setDateOfBirth(LocalDateTime.of(1988, 11, 6, 0, 0));

    System.out.println("Before Saving: " + customer);

    Customer savedCustomer = customerDao.save(customer);
    System.out.println("After saving: " + savedCustomer);

    Customer retrievedCustomer = customerDao.findById(savedCustomer.getCustomerId());
    System.out.println("After retrieving: " + retrievedCustomer);

    customer.setUsername("emmastone123");
    Customer updatedCustomer = customerDao.update(customer);
    System.out.println("After updating: " + updatedCustomer);

    customerDao.delete(updatedCustomer);
    System.out.println("After deleting: " + customerDao.findById(updatedCustomer.getCustomerId()));
  }
}
