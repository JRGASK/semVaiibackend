package com.example.semestralna_praca_vaii.facade.dto.customerOrderDto;

import java.time.LocalDate;

public class CustomerUpdateDto {

    private LocalDate date;

    private String price;

    private Integer serviceId;

    private String vehiclePlateNumber;


    @Override
    public String toString() {
        return "CustomerUpdateDto{" +
                "date=" + date +
                ", price='" + price + '\'' +
                ", serviceId=" + serviceId +
                ", vehiclePlateNumber='" + vehiclePlateNumber + '\'' +
                '}';
    }
}
