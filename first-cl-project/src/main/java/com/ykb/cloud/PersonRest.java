package com.ykb.cloud;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/person")
public class PersonRest {

    @PutMapping
    public String addPerson(@RequestBody final Person person) {
        return "OK";
    }

    @PatchMapping
    public String updatePerson(@RequestBody final Person person) {
        return "OK";
    }

    @GetMapping
    public Person getPerson(@RequestParam("name") final String name) {
        return null;
    }

    @DeleteMapping
    public String deletePerson(@RequestParam("name") final String name) {
        return null;
    }


}
