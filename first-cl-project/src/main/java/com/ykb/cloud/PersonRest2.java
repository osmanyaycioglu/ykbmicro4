package com.ykb.cloud;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import x.y.z.MySecond;

@RestController
@RequestMapping("/v1/person2")
//@RequestScope
//@SessionScope
//@ApplicationScope
public class PersonRest2 {

    @Autowired
    @Qualifier("osmanManager")
    private PersonManager pm;

    @Autowired
    @Qualifier("personManager")
    private PersonManager pm2;

    @Autowired
    private MySecond      ms;

    @PostMapping("/create")
    public String addPerson(@RequestBody final Person person) {
        this.pm.addPerson(person);
        return "OK";
    }

    @PostMapping("/update")
    public String updatePerson(@RequestBody final Person person) {
        return "OK";
    }

    @GetMapping("/read")
    public Person getPerson(@RequestParam("name") final String name) {
        return null;
    }

    @GetMapping("/delete")
    public String deletePerson(@RequestParam("name") final String name) {
        return null;
    }

    @GetMapping("/read_all")
    public List<Person> getAll() {
        return null;
    }

}

