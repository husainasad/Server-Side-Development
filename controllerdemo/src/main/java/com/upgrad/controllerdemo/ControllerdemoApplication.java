package com.upgrad.controllerdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ControllerdemoApplication {

	public static void main(String[] args) {

		SpringApplication.run(ControllerdemoApplication.class, args);

		System.out.println("Hello Students");
	}

}
