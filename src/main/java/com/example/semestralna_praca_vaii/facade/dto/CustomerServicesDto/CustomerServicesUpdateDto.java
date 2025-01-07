package com.example.semestralna_praca_vaii.facade.dto.CustomerServicesDto;

public class CustomerServicesUpdateDto {


    private String name;

    private String price;

    private String info;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    @Override
    public String toString() {
        return "CustomerServicesUpdateDto{" +
                "name='" + name + '\'' +
                ", price='" + price + '\'' +
                ", info='" + info + '\'' +
                '}';
    }
}
