package com.ykb.cloud;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@EnableRabbit
public class ClMsOrganizationFeignApplication {

    @Bean
    public MessageConverter mConverter() {
        return new Jackson2JsonMessageConverter();
    }

    public static void main(final String[] args) {
        SpringApplication.run(ClMsOrganizationFeignApplication.class,
                              args);
    }

}
