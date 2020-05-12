package com.ykb.cloud;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component
// @Scope("prototype")
public class PersonManager {

    private final Map<String, Person> personMap = new HashMap<>();

    public void addPerson(final Person person) {
        this.personMap.put(person.getName(),
                           person);
    }


}
