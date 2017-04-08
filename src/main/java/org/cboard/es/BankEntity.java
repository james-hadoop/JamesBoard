package org.cboard.es;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BankEntity {
    @JsonProperty(value = "account_number")
    private String account_number;

    @JsonProperty(value = "balance")
    private String balance;

    @JsonProperty(value = "firstname")
    private String firstname;

    @JsonProperty(value = "lastname")
    private String lastname;

    @JsonProperty(value = "age")
    private String age;

    @JsonProperty(value = "gender")
    private String gender;

    @JsonProperty(value = "address")
    private String address;

    @JsonProperty(value = "employer")
    private String employer;

    @JsonProperty(value = "email")
    private String email;

    @JsonProperty(value = "city")
    private String city;

    @JsonProperty(value = "state")
    private String state;

    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    public String[] toStringArray() {
        String[] row = new String[11];

        row[0] = this.account_number;
        row[1] = this.balance;
        row[2] = this.firstname;
        row[3] = this.lastname;
        row[4] = this.age;
        row[5] = this.gender;
        row[6] = this.address;
        row[7] = this.employer;
        row[8] = this.email;
        row[8] = this.city;
        row[10] = this.state;

        return row;
    }

    public String getAccount_number() {
        return account_number;
    }

    public void setAccount_number(String account_number) {
        this.account_number = account_number;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmployer() {
        return employer;
    }

    public void setEmployer(String employer) {
        this.employer = employer;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
