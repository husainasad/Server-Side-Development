package com.upgrad.greeting;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class EnglishGreetingService implements GreetingService{


    private TimeService timeService;

    @Autowired
    public EnglishGreetingService(@Qualifier("timeService24HourFormat") TimeService timeService) {
        this.timeService = timeService;
    }

    @Override
    public void greet(String name) {
        System.out.println("Hello, " +name);
    }

    public TimeService getTimeService() {
        return timeService;
    }

    public void setTimeService(TimeService timeService) {
        this.timeService = timeService;
    }
}
