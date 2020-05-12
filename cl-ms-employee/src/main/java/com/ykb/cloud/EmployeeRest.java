package com.ykb.cloud;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
public class EmployeeRest {

    @Value("${server.port}")
    private int port;

    @GetMapping("/greet")
    public String greet() {
        return "Hello " + this.port;
    }

}
