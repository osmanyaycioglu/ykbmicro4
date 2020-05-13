package com.ykb.cloud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/organization")
public class OrganizationRest {

    @Autowired
    private IEmployeeClient ec;

    @GetMapping("/hello")
    public String hello() {
        return this.ec.greet();
    }

    @PostMapping("/create/employee")
    public String createEmp(@RequestBody final Employee emp) {
        this.ec.addEmployee(emp);
        return "OK";
    }

}

