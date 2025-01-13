package com.example.semestralna_praca_vaii.facade.dto.personDto;

public class PersonDtoWithVehicle {

    private String email;

    private String vehiclePlateNumber;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getVehiclePlateNumber() {
        return vehiclePlateNumber;
    }

    public void setVehiclePlateNumber(String vehiclePlateNumber) {
        this.vehiclePlateNumber = vehiclePlateNumber;
    }

    @Override
    public String toString() {
        return "PersonDtoWithVehicle{" +
                "email='" + email + '\'' +
                ", vehiclePlateNumber='" + vehiclePlateNumber + '\'' +
                '}';
    }
}
