package com.fcamara.desafio.Model;

public class Company {
    private Long id;
    private String name;
    private String cnpj;
    private String address;
    private String phone;
    private String carCapacity;
    private String motorcycleCapacity;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCarCapacity() {
        return carCapacity;
    }

    public void setCarCapacity(String carCapacity) {
        this.carCapacity = carCapacity;
    }

    public String getMotorcycleCapacity() {
        return motorcycleCapacity;
    }

    public void setMotorcycleCapacity(String motorcycleCapacity) {
        this.motorcycleCapacity = motorcycleCapacity;
    }
}
