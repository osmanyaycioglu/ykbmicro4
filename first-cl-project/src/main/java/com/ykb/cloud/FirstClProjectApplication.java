package com.ykb.cloud;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// @SpringBootApplication(scanBasePackages = {"com.ykb.cloud","x.y.z"})
@SpringBootApplication
public class FirstClProjectApplication {

    @Autowired
    private PersonManager personManager;


    @Autowired
    public FirstClProjectApplication(final PersonManager pm) {
        // pm.addPerson(new Person());
    }

    @PostConstruct
    public void abc() {
        // this.personManager.addPerson(new Person());
    }

    @Autowired
    public void name(final PersonManager pm) {

    }


    public static void main(final String[] args) {
        SpringApplication.run(FirstClProjectApplication.class,
                              args);
    }

}
