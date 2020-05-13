package com.ykb.cloud;

import java.time.ZonedDateTime;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.bus.SpringCloudBusClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.ApplicationContext;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ykb.cloud.event.MyRemoteEvent;


@RestController
@RequestMapping("/organization")
@RefreshScope
public class OrganizationRest {

    @Autowired
    private IEmployeeClient      ec;

    @Autowired
    private RabbitTemplate       rt;

    @Autowired
    private ApplicationContext   ap;

    @Autowired
    private SpringCloudBusClient scc;

    @Value("${my.config}")
    private String               dynVal;


    @GetMapping("/hello")
    public String hello() {
        return this.ec.greet();
    }

    @GetMapping("/dyn")
    public String dyn() {
        MyRemoteEvent eventLoc = new MyRemoteEvent(this,
                                                   this.ap.getId(),
                                                   "My first event");
        this.scc.springCloudBusOutput()
                .send(MessageBuilder.withPayload(eventLoc)
                                    .build());
        return this.dynVal;
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

