package com.ykb.cloud;

import java.time.ZonedDateTime;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
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

    @Autowired
    private RabbitTemplate  rt;

    @GetMapping("/hello")
    public String hello() {
        return this.ec.greet();
    }

    @GetMapping("/get_emp")
    public Employee getEmp() {
        Employee employeeLoc = new Employee();
        employeeLoc.setBirthday(ZonedDateTime.now());
        return employeeLoc;
    }

    @PostMapping("/create/employee")
    public String createEmp(@RequestBody final Employee emp) {
        //        Department d = new Department();
        //        d.setName("IT");
        //        d.setName("Teknoloji");
        //        d.setSupport("support.it@ykb.com");
        //        d.setEmployeeCount(1000);
        this.rt.convertAndSend("dep_exchange",
                               "dep.it",
                               emp.getDepartment());

        this.ec.addEmployee(emp);
        return "OK";
    }


}

