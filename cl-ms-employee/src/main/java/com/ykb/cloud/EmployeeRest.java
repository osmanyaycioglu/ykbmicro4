package com.ykb.cloud;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.ykb.cloud.models.Employee;

@RestController
@RequestMapping("/employee")
@RefreshScope
public class EmployeeRest {

    @Value("${server.port}")
    private int         port;

    @Value("${my.config}")
    private String      dynVal;

    @Autowired
    private EmployeeDAO empDoa;

    private int         counter = 0;

    @HystrixCommand(fallbackMethod = "greetFallback",
                    commandProperties = @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",
                                                         value = "500"))
    @GetMapping("/greet")
    public String greet() {
        this.counter++;
        if ((this.counter % 3) == 0) {
            throw new IllegalArgumentException();
        }
        if ((this.counter % 5) == 0) {
            try {
                Thread.sleep(2000);
            } catch (Exception eLoc) {
            }
        }

        return "Hello " + this.port + " " + this.dynVal;
    }

    public String greetFallback() {
        return "Fallback " + this.port;
    }

    @PostMapping("/add")
    public String addEmployee(@RequestBody final Employee emp) {
        this.empDoa.save(emp);
        return "OK";
    }

    @GetMapping("/get_all")
    public List<Employee> getAll() {
        Iterable<Employee> findAllLoc = this.empDoa.findAll();
        List<Employee> ea = new ArrayList<>();
        for (Employee employeeLoc : findAllLoc) {
            ea.add(employeeLoc);
        }
        return ea;
    }

    @GetMapping("/delete/{un}")
    public String delete(@PathVariable("un") final String username) {
        this.empDoa.deleteById(username);
        return "OK";
    }


}

