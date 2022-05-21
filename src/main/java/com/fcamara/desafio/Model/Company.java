package com.fcamara.desafio.Model;

import javax.persistence.*;

@Entity
@Table(name="Companies")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String cnpj;
    private String address;
    private String phone;
    private Integer carCapacity;
    private Integer motorcycleCapacity;

    public Company(String name, String cnpj, String address, String phone, Integer carCapacity, Integer motorcycleCapacity) {
        this.name = name;
        this.cnpj = cnpj;
        this.address = address;
        this.phone = phone;
        this.carCapacity = carCapacity;
        this.motorcycleCapacity = motorcycleCapacity;
    }

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

    public Integer getCarCapacity() {
        return carCapacity;
    }

    public void setCarCapacity(Integer carCapacity) {
        this.carCapacity = carCapacity;
    }

    public Integer getMotorcycleCapacity() {
        return motorcycleCapacity;
    }

    public void setMotorcycleCapacity(Integer motorcycleCapacity) {
        this.motorcycleCapacity = motorcycleCapacity;
    }
}
