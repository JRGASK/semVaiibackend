package com.example.semestralna_praca_vaii.facade.dto;

import com.example.semestralna_praca_vaii.data.RoleType;

public class PersonCreateDto {

    private String email;

    private String name;

    private String surname;

    private String password;

    private RoleType role;

    public void setEmail(String email) {
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRole(RoleType role) {
        this.role = role;
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

    public String getPassword() {
        return password;
    }

    public RoleType getRole() {
        return role;
    }

    @Override
    public String toString() {
        return "PersonCreateDto{" +
                "email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                '}';
    }
}
