package com.web.project.model.entity;

import java.time.LocalDate;
import java.util.Objects;

public class Account extends Entity {
    private static final long serialVersionUID = 1L;
    private final String firstName;
    private final String lastName;
    private final String password;
    private final String email;
    private final LocalDate date;
    private final String gender;

    public Account(String firstName, String lastName, String password, String email, int year, int month, int day,
                   String gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.email = email;
        this.date = LocalDate.of(year, month, day);
        this.gender = gender;
    }

    public String getFirstName() {
        return firstName;
    }


    public String getLastName() {
        return lastName;
    }


    public String getPassword() {
        return password;
    }


    public String getEmail() {
        return email;
    }


    public LocalDate getDate() {
        return date;
    }

    public String getGender() {
        return gender;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Objects.equals(firstName, account.firstName) &&
                Objects.equals(lastName, account.lastName) &&
                Objects.equals(password, account.password) &&
                Objects.equals(email, account.email) &&
                Objects.equals(date, account.date) &&
                Objects.equals(gender, account.gender);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
                + email.hashCode();
        return result;
    }
}
