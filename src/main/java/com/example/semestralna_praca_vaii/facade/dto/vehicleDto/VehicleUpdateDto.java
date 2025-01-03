package com.example.semestralna_praca_vaii.facade.dto.vehicleDto;

import com.example.semestralna_praca_vaii.data.person.Person;
import com.example.semestralna_praca_vaii.data.vehicle.VehicleType;

public class VehicleUpdateDto {

    private String plateNumber;

    private VehicleType type;

    private String engine;

    private String make;

    private String model;

    private String color;

    private Person email;

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public VehicleType getType() {
        return type;
    }

    public void setType(VehicleType type) {
        this.type = type;
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Person getEmail() {
        return email;
    }

    public void setEmail(Person email) {
        this.email = email;
    }
}
