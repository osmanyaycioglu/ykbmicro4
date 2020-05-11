package com.ykb.cloud;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/first")
public class MyFirstRest {

    @GetMapping("/hello")
    public String hello() {
        return "Hello World";
    }

    @PostMapping("/hello")
    public String hello2() {
        return "Hello World 2";
    }

    @PutMapping("/hello")
    public String hello3() {
        return "Hello World 3";
    }

    @GetMapping("/hello4/{xyz}/{abc}")
    public String hello4(@PathVariable("xyz") final String name,
                         @PathVariable("abc") final String surname) {
        return "Hello World 4 : " + name + " " + surname;
    }

    @GetMapping("/hello5")
    public String hello5(@RequestParam("xyz") final String name,
                         @RequestParam("abc") final String surname) {
        return "Hello World 5 : " + name + " " + surname;
    }

    @GetMapping("/hello6/{xyz}/{abc}")
    public String hello6(@PathVariable("xyz") final String name,
                         @PathVariable("abc") final String surname,
                         @RequestParam("jkl") final int age) {
        return "Hello World 6 : " + name + " " + surname + " " + age;
    }

    @GetMapping("/hello7")
    public String hello7(@RequestHeader("xyz") final String name,
                         @RequestHeader("abc") final String surname) {
        return "Hello World 7 : " + name + " " + surname;
    }

    @PostMapping("/hello8")
    public String hello8(@RequestBody final Person person) {
        return "Hello World 8 : " + person;
    }

    @PostMapping(value = "/hello9",
                 consumes = {
                              MediaType.APPLICATION_JSON_VALUE,
                              MediaType.APPLICATION_XML_VALUE
                 },
                 produces = {
                              MediaType.APPLICATION_JSON_VALUE,
                              MediaType.APPLICATION_XML_VALUE
                 })
    public Person hello9(@RequestBody final Person person) {
        person.setAge(99);
        return person;
    }

    @PostMapping("/hello10")
    public Person hello10(@RequestBody final Person person,
                          final HttpServletRequest requestParam) {
        System.out.println("Request : " + requestParam.getContextPath());
        person.setAge(99);
        return person;
    }

    @PostMapping("/hello11")
    public Person hello11(@RequestBody final Person person) {
        if (person.getAge() > 120) {
            throw new IllegalArgumentException("age 120 den büyük olamaz");
        }
        if (person.getAge() < 10) {
            throw new IllegalStateException("age 10 dan küçük olamaz");
        }

        person.setAge(99);
        return person;
    }

    @PostMapping("/hello12")
    public Person hello12(@Validated @RequestBody final Person person) {
        person.setAge(99);
        return person;
    }

    //    @ExceptionHandler(IllegalArgumentException.class)
    //    public ErrorObj errorHandle(final IllegalArgumentException exp) {
    //        return new ErrorObj(exp.getMessage(),
    //                            "IT",
    //                            10045);
    //    }
    //
    //    @ExceptionHandler(IllegalStateException.class)
    //    public ErrorObj errorHandle2(final IllegalStateException exp) {
    //        return new ErrorObj(exp.getMessage(),
    //                            "IT",
    //                            10045);
    //    }


    // Default Http status for exceptions
    //    @ExceptionHandler(Exception.class)
    //    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    //    public ErrorObj errorHandle(final Exception exp) {
    //        if (exp instanceof IllegalArgumentException) {
    //            return new ErrorObj(exp.getMessage(),
    //                                "IT",
    //                                10045);
    //        } else if (exp instanceof IllegalStateException) {
    //            return new ErrorObj(exp.getMessage(),
    //                                "IT",
    //                                10046);
    //
    //        } else {
    //            return new ErrorObj(exp.getMessage(),
    //                                "IT",
    //                                11000);
    //        }
    //    }


}

