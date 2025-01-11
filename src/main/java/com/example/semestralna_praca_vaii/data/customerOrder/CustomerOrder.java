package com.example.semestralna_praca_vaii.data.customerOrder;

import com.example.semestralna_praca_vaii.data.customerServices.CustomerServices;
import com.example.semestralna_praca_vaii.data.person.Person;
import com.example.semestralna_praca_vaii.data.vehicle.Vehicle;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

@Entity
@Table(name = "customerOrder")
public class CustomerOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "orderId", nullable = false)
    private Long id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "email", referencedColumnName = "email", nullable = false)
    private Person person;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vehicle")
    private Vehicle vehicle;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "serviceId", nullable = false)
    private CustomerServices serviceid;

    @NotNull
    @Column(name = "dateOfCreate", nullable = false)
    private LocalDate dateofcreate;

    @NotNull
    @Column(name = "date", nullable = false)
    private LocalDate date;

    @Size(max = 255)
    @Column(name = "price")
    private String price;

    @Column(insertable=false, updatable=false)
    private Integer serviceId;

    @Column(insertable=false, updatable=false)
    private String vehiclePlateNumber;

    @Column(insertable=false, updatable=false)
    private String email;

    public String getVehiclePlateNumber() {
        return vehiclePlateNumber;
    }

    public void setVehiclePlateNumber(String vehiclePlateNumber) {
        this.vehiclePlateNumber = vehiclePlateNumber;
    }

    public Integer getServiceId() {
        return serviceId;
    }

    public void setServiceId(Integer serviceId) {
        this.serviceId = serviceId;
    }

    public @NotNull Person getPerson() {
        return person;
    }

    public void setPerson(@NotNull Person person) {
        this.person = person;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalDate getDateofcreate() {
        return dateofcreate;
    }

    public void setDateofcreate(LocalDate dateofcreate) {
        this.dateofcreate = dateofcreate;
    }

    public CustomerServices getService() {
        return serviceid;
    }

    public void setService(CustomerServices serviceid) {
        this.serviceid = serviceid;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
