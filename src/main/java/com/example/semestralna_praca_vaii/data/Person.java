package com.example.semestralna_praca_vaii.data;

//TODO ROLE AKO
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "person")
public class Person {


    @Id
    @Size(max = 255)
    @NotEmpty(message = "Email must be not null")
    @Column(name = "email", nullable = false)
    private String email;

    @Size(max = 255)
    @NotNull
    @NotEmpty(message = "Name must be not null")
    @Column(name = "name", nullable = false)
    private String name;

    @Size(max = 255)
    @NotNull
    @NotEmpty(message = "Surname must be not null")
    @Column(name = "surname", nullable = false)
    private String surname;

    @Size(max = 255)
    @NotNull
    @NotEmpty(message = "Password must be not null")
    @Column(name = "password", nullable = false)
    private String password;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "role", nullable = false, length = Integer.MAX_VALUE)
    private RoleType role;

    @Size(max = 255)
    @NotNull
    @NotEmpty(message = "Phone number must be not null")
    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public RoleType getRole() {
        return role;
    }

    public void setRole(RoleType role) {
        this.role = role;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
