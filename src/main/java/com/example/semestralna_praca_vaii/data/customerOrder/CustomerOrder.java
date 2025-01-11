package com.example.semestralna_praca_vaii.data.customerOrder;

import com.example.semestralna_praca_vaii.data.customerServices.CustomerServices;
import com.example.semestralna_praca_vaii.data.person.Person;
import com.example.semestralna_praca_vaii.data.vehicle.Vehicle;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

@Entity
@Table(name = "customerorder")
public class CustomerOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "orderid", nullable = false)
    private Long id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "email", referencedColumnName = "email", nullable = false)
    private Person person;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vehicleregistrationnumber", referencedColumnName ="vehicleregistrationnumber")
    private Vehicle vehicle;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "service_id",referencedColumnName ="service_id", nullable = false)
    private CustomerServices service;

    @NotNull
    @Column(name = "dateofcreate", nullable = false)
    private LocalDate dateofcreate;

    @NotNull
    @Column(name = "date", nullable = false)
    private LocalDate date;

    @Size(max = 255)
    @Column(name = "price")
    private String price;

    @Column(insertable=false, updatable=false)
    private Integer service_id;

    @Column(insertable=false, updatable=false)
    private String vehicleregistrationnumber;

    @Column(insertable=false, updatable=false)
    private String email;

    public String getVehiclePlateNumber() {
        return vehicleregistrationnumber;
    }

    public void setVehiclePlateNumber(String vehiclePlateNumber) {
        this.vehicleregistrationnumber = vehiclePlateNumber;
    }

    public Integer getServiceId() {
        return service_id;
    }

    public void setServiceId(Integer serviceId) {
        this.service_id = serviceId;
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
        return service;
    }

    public void setService(CustomerServices service) {
        this.service = service;
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

    @Override
    public String toString() {
        return "CustomerOrder{" +
                "id=" + id +
                ", dateofcreate=" + dateofcreate +
                ", date=" + date +
                ", price='" + price + '\'' +
                ", serviceId=" + service.getId() +
                ", vehiclePlateNumber='" + vehicle.getPlateNumber() + '\'' +
                ", email='" + person.getEmail() + '\'' +
                '}';
    }
}
