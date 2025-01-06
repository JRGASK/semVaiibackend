package com.example.semestralna_praca_vaii.data.customerServices;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "customerService")
public class CustomerServices {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "serviceid", nullable = false)
    private Integer id;

    @Size(max = 255)
    @Column(name = "name")
    private String name;

    @Size(max = 255)
    @Column(name = "price")
    private String price;

    @Size(max = 255)
    @Column(name = "info")
    private String info;

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "CustomerServices{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price='" + price + '\'' +
                ", info='" + info + '\'' +
                '}';
    }
}
