package com.ykb.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableZuulProxy
@EnableDiscoveryClient
public class ClApiGatewayApplication {

    @Bean
    public RestTemplate name() {
        return new RestTemplate();
    }

    public static void main(final String[] args) {
        SpringApplication.run(ClApiGatewayApplication.class,
                              args);
    }

}
