package com.example.semestralna_praca_vaii.facade.dto.customerOrderDto;

import com.example.semestralna_praca_vaii.data.customerServices.CustomerServices;
import com.example.semestralna_praca_vaii.data.person.Person;
import com.example.semestralna_praca_vaii.data.vehicle.Vehicle;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public class CustomerOrderDto {

    private Long id;

    private LocalDate dateofcreate;

    private LocalDate date;

    private String price;

    private Integer serviceId;

    private String vehiclePlateNumber;

    private String email;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDateofcreate() {
        return dateofcreate;
    }

    public void setDateofcreate(LocalDate dateofcreate) {
        this.dateofcreate = dateofcreate;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Integer getServiceId() {
        return serviceId;
    }

    public void setServiceId(Integer serviceId) {
        this.serviceId = serviceId;
    }

    public String getVehiclePlateNumber() {
        return vehiclePlateNumber;
    }

    public void setVehiclePlateNumber(String vehiclePlateNumber) {
        this.vehiclePlateNumber = vehiclePlateNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
