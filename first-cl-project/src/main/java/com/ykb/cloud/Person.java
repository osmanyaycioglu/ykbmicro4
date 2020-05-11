package com.ykb.cloud;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Person {

    @Size(max = 100, min = 2, message = "name 2 ile 100 arasında olmalı")
    @NotEmpty
    private String name;
    @NotEmpty
    private String surname;
    @Max(value = 120, message = "age 120 den büyük olamaz")
    @Min(value = 10, message = "age 10 dan küçük olamaz")
    private int    age;
    @Email(message = "email düzgün girilmeli")
    @NotEmpty
    private String email;

    public String getName() {
        return this.name;
    }

    public void setName(final String nameParam) {
        this.name = nameParam;
    }

    public String getSurname() {
        return this.surname;
    }

    public void setSurname(final String surnameParam) {
        this.surname = surnameParam;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(final int ageParam) {
        this.age = ageParam;
    }

    @Override
    public String toString() {
        return "Person [name=" + this.name + ", surname=" + this.surname + ", age=" + this.age + "]";
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(final String emailParam) {
        this.email = emailParam;
    }


}
