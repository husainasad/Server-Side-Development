package com.upgrad.movieapp;

import com.upgrad.movieapp.dao.CustomerRepository;
import com.upgrad.movieapp.entities.Customer;
import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.RestController;


@RestController
@SpringBootApplication
public class MovieappApplication implements CommandLineRunner {

	@Autowired
	CustomerRepository customerRepository ;

	public static void main(String[] args) {


		ApplicationContext context = SpringApplication.run(MovieappApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {
		Customer customer1 = new Customer(1, "Vishwa", "Mohan", "vmohan",
				"*********", LocalDateTime.of(1995,12,07,12,00));
		Customer customer2 = new Customer(2, "Sachin", "Mohan", "smohan",
				"*********", LocalDateTime.of(1975,8,04,12,00));
		Customer customer3 = new Customer(3, "Rakesh", "Roshan", "rroshan",
				"*********", LocalDateTime.of(1985,10,03,11,00));

		/**
		 * How to save these in the mongodb
		 */
		customerRepository.save(customer1);
		customerRepository.save(customer2);
		customerRepository.save(customer3);

		/**
		 * Fetching the data from the Mongodb
		 */
		for(Customer customer : customerRepository.findAll()){
			System.out.println(customer);
		}

		/**
		 * Find the record based on the first Name
		 */
		System.out.println(customerRepository.findByFirstName("Vishwa"));

		/**
		 * Fetch the results based on the last name
		 */
		System.out.println(customerRepository.findByLastName("Mohan"));

	}
}
