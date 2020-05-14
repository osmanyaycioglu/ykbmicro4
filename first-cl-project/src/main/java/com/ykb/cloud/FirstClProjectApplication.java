package com.ykb.cloud;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// @SpringBootApplication(scanBasePackages = {"com.ykb.cloud","x.y.z"})
@SpringBootApplication
public class FirstClProjectApplication {

    @Autowired
    @Qualifier("osmanManager")
    private PersonManager personManager;


    @Autowired
    public FirstClProjectApplication(@Qualifier("osmanManager") final PersonManager pm) {
        // pm.addPerson(new Person());
    }

    @PostConstruct
    public void abc() {
        // this.personManager.addPerson(new Person());
    }

    @Autowired
    @Qualifier("osmanManager")
    public void name(final PersonManager pm) {

    }


    public static void main(final String[] args) {
        SpringApplication.run(FirstClProjectApplication.class,
                              args);
    }

}
