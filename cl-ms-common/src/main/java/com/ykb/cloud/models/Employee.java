package com.ykb.cloud.models;

import java.time.ZonedDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

@Entity
public class Employee {

    @Id
    @NotEmpty
    @Size(min = 6, max = 30, message = "username 6 dan büyük 30 dan küçük")
    private String        username;
    @NotEmpty
    private String        password;
    private String        name;
    private String        surname;
    @NotEmpty
    private String        email;
    @Past
    private ZonedDateTime birthday;

    public String getUsername() {
        return this.username;
    }

    public void setUsername(final String usernameParam) {
        this.username = usernameParam;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(final String passwordParam) {
        this.password = passwordParam;
    }

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

    public String getEmail() {
        return this.email;
    }

    public void setEmail(final String emailParam) {
        this.email = emailParam;
    }

    public ZonedDateTime getBirthday() {
        return this.birthday;
    }

    public void setBirthday(final ZonedDateTime birthdayParam) {
        this.birthday = birthdayParam;
    }


}
