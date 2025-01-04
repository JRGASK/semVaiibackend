package com.example.semestralna_praca_vaii.data.vehicle;

import com.example.semestralna_praca_vaii.data.person.Person;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "vehicle")
public class Vehicle {

    @Id
    @NotEmpty(message = "plateNumber must be not null")
    @Size(max = 9)
    @Column(name = "vehicleregistrationnumber", nullable = false, length = 9)
    private String plateNumber;

    @Column(name = "type" ,nullable = false, length = Integer.MAX_VALUE)
    @Enumerated(EnumType.STRING)
    private VehicleType type;

    @Size(max = 255)
    @Column(name = "engine")
    private String engine;

    @Size(max = 255)
    @Column(name = "make")
    private String make;

    @Size(max = 255)
    @Column(name = "model")
    private String model;

    @Size(max = 255)
    @Column(name = "color")
    private String color;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "email", referencedColumnName = "email", nullable = false)
    private Person person;

    @Column(insertable=false, updatable=false)
    private String email;

    public @NotNull Person getPerson() {
        return person;
    }

    public void setPerson(@NotNull Person person) {
        this.person = person;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public VehicleType getType() {
        return type;
    }

    public void setType(VehicleType type) {
        this.type = type;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "plateNumber='" + plateNumber + '\'' +
                ", type=" + type +
                ", engine='" + engine + '\'' +
                ", make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", color='" + color + '\'' +
                ", email=" + person.getEmail() +
                '}';
    }
}
