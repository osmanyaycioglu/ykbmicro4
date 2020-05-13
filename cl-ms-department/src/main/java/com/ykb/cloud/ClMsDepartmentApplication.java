package com.ykb.cloud;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableRabbit
public class ClMsDepartmentApplication {

    public static void main(final String[] args) {
        SpringApplication.run(ClMsDepartmentApplication.class,
                              args);
    }

}
