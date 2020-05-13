package com.ykb.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class ClMsOrganizationFeignApplication {

    public static void main(final String[] args) {
        SpringApplication.run(ClMsOrganizationFeignApplication.class,
                              args);
    }

}
