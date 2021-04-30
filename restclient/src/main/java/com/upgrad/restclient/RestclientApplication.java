package com.upgrad.restclient;

import com.upgrad.restclient.resttemplates.RestTemplateDemo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;


@SpringBootApplication
public class RestclientApplication {



	public static void main(String[] args) {

		ApplicationContext applicationContext = SpringApplication.run(RestclientApplication.class, args);

		RestTemplateDemo restTemplateDemo = applicationContext.getBean(RestTemplateDemo.class);
		restTemplateDemo.fetchTheData();
	}


	@Bean
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}

}
