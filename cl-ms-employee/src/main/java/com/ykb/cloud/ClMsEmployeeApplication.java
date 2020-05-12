package com.ykb.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ClMsEmployeeApplication {

    public static void main(final String[] args) {
        SpringApplication.run(ClMsEmployeeApplication.class,
                              args);
    }

}
