package com.ykb.cloud;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@FeignClient(name = "employee")
@RequestMapping("/employee")
public interface IEmployeeClient {

    @GetMapping("/greet")
    public String greet();

    @PostMapping("/add")
    public String addEmployee(@RequestBody final Employee emp);

    @GetMapping("/get_all")
    public List<Employee> getAll();

    @GetMapping("/delete/{un}")
    public String delete(@PathVariable("un") final String username);

}
