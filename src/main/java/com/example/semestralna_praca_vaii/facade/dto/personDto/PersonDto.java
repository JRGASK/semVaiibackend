package com.example.semestralna_praca_vaii.facade.dto.personDto;

public class PersonDto {

    private String email;

    private String name;

    private String surname;

    private String phoneNumber;

    private String role;

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    @Override
    public String toString() {
        return "PersonDto{" +
                "email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}