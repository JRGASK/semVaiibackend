package com.example.semestralna_praca_vaii.facade.dto.customerOrderDto;

import java.time.LocalDate;

public class CustomerOrderCreateDto {

    private LocalDate date;

    private String price;

    private Integer serviceId;

    private String vehiclePlateNumber;

    private String email;

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

    @Override
    public String toString() {
        return "CustomerOrderCreateDto{" +
                "date=" + date +
                ", price='" + price + '\'' +
                ", serviceId=" + serviceId +
                ", vehiclePlateNumber='" + vehiclePlateNumber + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
