package com.upgrad.greeting;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext("com.upgrad.greeting");
        EnglishGreetingService greetingService1 = (EnglishGreetingService) context.getBean("englishGreetingService");

        EnglishGreetingService greetingService2 = (EnglishGreetingService) context.getBean("englishGreetingService");

        System.out.println(greetingService1==greetingService2);

/*
        greetingService.greet("Agent");
        System.out.println(greetingService.getTimeService().getCurrentTime());
*/
    }
}
