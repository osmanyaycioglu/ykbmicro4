package com.ykb.cloud;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ykb.cloud.models.Employee;

@RestController
@RequestMapping("/employee")
public class EmployeeRest {

    @Value("${server.port}")
    private int         port;

    @Autowired
    private EmployeeDAO empDoa;

    @GetMapping("/greet")
    public String greet() {
        return "Hello " + this.port;
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

