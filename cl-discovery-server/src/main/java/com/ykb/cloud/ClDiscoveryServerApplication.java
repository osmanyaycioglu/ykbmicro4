package com.ykb.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class ClDiscoveryServerApplication {

    public static void main(final String[] args) {
        SpringApplication.run(ClDiscoveryServerApplication.class,
                              args);
    }

}
