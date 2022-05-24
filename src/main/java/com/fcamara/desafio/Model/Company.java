package com.fcamara.desafio.Model;

import com.fcamara.desafio.Repository.CompanyRepository;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name="Companies")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty @NotNull
    private String name;

    @NotEmpty @NotNull
    private String cnpj;

    @NotEmpty @NotNull
    private String address;

    @NotEmpty @NotNull
    private String phone;

    private Integer carCapacity;
    private Integer motorcycleCapacity;

    @OneToMany
    private List<Vehicle> carsInGarage;

    @OneToMany
    private List<Vehicle> motorcyclesInGarage;

    public Company(String name, String cnpj, String address, String phone, Integer carCapacity, Integer motorcycleCapacity) {
        this.name = name;
        this.cnpj = cnpj;
        this.address = address;
        this.phone = phone;
        this.carCapacity = carCapacity;
        this.motorcycleCapacity = motorcycleCapacity;
    }

    public Company() {
    }

    public Long getId() {return id;}

    public void setId(Long id) { this.id = id;}

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

    public List<Vehicle> getCarsInGarage() {
        return carsInGarage;
    }

    public void setCarsInGarage(List<Vehicle> carsInGarage) {
        this.carsInGarage = carsInGarage;
    }

    public List<Vehicle> getMotorcyclesInGarage() {
        return motorcyclesInGarage;
    }

    public void setMotorcyclesInGarage(List<Vehicle> motorcyclesInGarage) {
        this.motorcyclesInGarage = motorcyclesInGarage;
    }

    public Company update(Long id, CompanyRepository companyRepository){
        Company company = companyRepository.getReferenceById(id);
        company.setName(this.getName());
        company.setCnpj(this.getCnpj());
        company.setAddress(this.getAddress());
        company.setPhone(this.getPhone());
        company.setCarCapacity(this.getCarCapacity());
        company.setMotorcycleCapacity(this.getMotorcycleCapacity());
        return company;
    }

    public Boolean checkAvailability(Vehicle vehicle){
        if(vehicle.getType() == "car"){
            Integer carCount = this.carsInGarage.size();
            return carCount < this.carCapacity;
        } else {
            Integer motorcycleCount = this.motorcyclesInGarage.size();
            return motorcycleCount < this.motorcycleCapacity;
        }
    }
}
