package com.askar.webproject.model.entity;

import java.time.LocalDate;
import java.util.Objects;

public class Account extends Entity {
    private static final long serialVersionUID = 1L;
    private String firstName;
    private String lastName;
    private String password;
    private double accountBalance;
    private String email;
    private LocalDate date;
    private String gender;

    public Account() {

    }

    public Account(String firstName, String lastName, String password, double accountBalance, String email, int year, int month, int day,
                   String gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.accountBalance = accountBalance;
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

    public double getAccountBalance() {
        return accountBalance;
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
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAccountBalance(double accountBalance) {
        this.accountBalance = accountBalance;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Account account = (Account) o;
        return Double.compare(account.accountBalance, accountBalance) == 0 &&
                Objects.equals(firstName, account.firstName) &&
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
