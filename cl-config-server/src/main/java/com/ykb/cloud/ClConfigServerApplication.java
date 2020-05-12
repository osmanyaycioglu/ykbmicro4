package com.ykb.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class ClConfigServerApplication {

    public static void main(final String[] args) {
        SpringApplication.run(ClConfigServerApplication.class,
                              args);
    }

}
