package com.ykb.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

@SpringBootApplication
@EnableDiscoveryClient
@RibbonClient(name = "EMPLOYEE", configuration = MyRibbonConfig.class)
public class ClMsOrganizationApplication {

    public static void main(final String[] args) {
        SpringApplication.run(ClMsOrganizationApplication.class,
                              args);
    }

}
