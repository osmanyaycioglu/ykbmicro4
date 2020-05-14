package com.ykb.cloud;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.bus.jackson.RemoteApplicationEventScan;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@SpringBootApplication
@EnableDiscoveryClient
@EnableRabbit
@EnableCircuitBreaker
@RemoteApplicationEventScan
@EnableResourceServer
public class ClMsEmployeeApplication {

    public static void main(final String[] args) {
        SpringApplication.run(ClMsEmployeeApplication.class,
                              args);
    }

}
