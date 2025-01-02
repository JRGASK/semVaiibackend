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
    @NotEmpty(message = "VRN must be not null")
    @Size(max = 9)
    @Column(name = "vehicleregistrationnumber", nullable = false, length = 9)
    private String VHC;

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
    @NotEmpty(message = "Email must be not null")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "email", nullable = false)
    private Person email;

    public Person getEmail() {
        return email;
    }

    public void setEmail(Person email) {
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

    public String getVHC() {
        return VHC;
    }

    public void setVHC(String VHC) {
        this.VHC = VHC;
    }
}
