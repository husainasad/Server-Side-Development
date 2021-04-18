package com.upgrad.movieapp;

import com.upgrad.movieapp.dao.CustomerDAO;
import com.upgrad.movieapp.dao.MovieDao;
import com.upgrad.movieapp.entities.Customer;
import com.upgrad.movieapp.entities.Movie;
import com.upgrad.movieapp.services.MovieService;
import java.time.LocalDateTime;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@SpringBootApplication
public class MovieappApplication {

	public static void main(String[] args) {


		ApplicationContext context = SpringApplication.run(MovieappApplication.class, args);

//		CustomerDAO customerDAO = context.getBean(CustomerDAO.class);
////
////
////		Customer customer = new Customer();
////		customer.setFirstName("Emma");
////		customer.setLastName("Stone");
////		customer.setUserName("email123stone");
////		customer.setPassword("*******");
////		customer.setDateOfBirth(LocalDateTime.of(1988,11,6,0,0));
////
////		System.out.println("Before saving : "+customer);
////		Customer savedCustomer = customerDAO.save(customer);
////
////		System.out.println("After saving : "+ savedCustomer);
////
////		Customer retrievedCustomer = customerDAO.findById(savedCustomer.getCustomerId());
////		System.out.println("Retrieved customer : "+ retrievedCustomer);
////
////
////
////		customer.setUserName("newName");
////
////		Customer updatedCustomer = customerDAO.update(customer);
////		System.out.println("Updated customer : "+ updatedCustomer);
////
////
////
////		customerDAO.delete(updatedCustomer);
////
////		System.out.println("After deleting : "+ customerDAO.findById(updatedCustomer.getCustomerId()));

		/**
		 * Crud operation on Movies
		 */

//		MovieDao movieDao = context.getBean(MovieDao.class);
//
//		System.out.println(movieDao);
//
//		Movie movie = new Movie();
//
//		movie.setMovieName("Avengers : Infinity War");
//		movie.setMovieDescription("The Avenges should must stop Thano's");
//		movie.setReleaseDate(LocalDateTime.of(2018,4,27,5,30));
//		movie.setDuration(150);
//		movie.setCoverPhotoUrl("Cover photo url");
//    movie.setTrailerUrl("Trailer URL");
//
//		System.out.println("Before saving : "+ movie);
//
//		Movie savedMovie = movieDao.save(movie);
//
//		System.out.println("After Saving : "+ savedMovie);
//
//		//We want to search based on the primary key which movie id
//		Movie retrievedMovie = movieDao.findById(savedMovie.getMovieId()).orElse(null);
//
//		System.out.println("After retrieving : " + retrievedMovie);
//
//
//
//		movie.setDuration(160);
//
//		Movie movieUpdated = movieDao.save(movie);
//
//		System.out.println("Updated movies : "+ movieUpdated);
//
//
//		movieDao.delete(movieUpdated);
//
//		System.out.println("After deleting : "+ movieDao.findById(savedMovie.getMovieId()).orElse(null));

		/**
		 *
		 * Testing movie service
		 */

		MovieService movieService = context.getBean(MovieService.class);

		System.out.println("Movie Service bean : "+ movieService);
//
		Movie movie1 = new Movie();
		movie1.setMovieName("Avengers");
		movie1.setMovieDescription("It is superheroes movie");
		movie1.setReleaseDate(LocalDateTime.of(2020,11,04,23,12));
   	 	movie1.setCoverPhotoUrl("photo url");
   	 	movie1.setTrailerUrl("trailer url");
    	movie1.setDuration(120);


    	Movie savedMovie  = movieService.acceptMovieDetails(movie1);

		System.out.println(savedMovie);

		Movie searchedMovie = movieService.getMovieDetails(savedMovie.getMovieId());
		System.out.println("Searched movie : "+ searchedMovie);

	}


}
