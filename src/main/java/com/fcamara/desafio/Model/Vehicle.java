package com.fcamara.desafio.Model;

import com.fcamara.desafio.Repository.VehicleRepository;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="Vehicles")
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty @NotNull
    private String make;

    @NotEmpty @NotNull
    private String model;

    @NotEmpty @NotNull
    private String color;

    @NotEmpty @NotNull
    private String registration;

    @NotEmpty @NotNull
    private String type;

    @ManyToOne
    private Company company;

    public Vehicle(String make, String model, String color, String registration, String type) {
        this.make = make;
        this.model = model;
        this.color = color;
        this.registration = registration;
        this.type = type;
    }

    public Vehicle(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getRegistration() {
        return registration;
    }

    public void setRegistration(String registration) {
        this.registration = registration;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Vehicle update(Long id, VehicleRepository vehicleRepository){
        Vehicle vehicle = vehicleRepository.getReferenceById(id);
        vehicle.setMake(this.getMake());
        vehicle.setModel(this.getModel());
        vehicle.setColor(this.getColor());
        vehicle.setRegistration(this.getRegistration());
        vehicle.setType(this.getType());
        return vehicle;
    }

    public Boolean addToGarage(Long id, VehicleRepository vehicleRepository, Company company){
        Vehicle vehicle = vehicleRepository.getReferenceById(id);
        if(company.checkAvailability(vehicle)) {
            vehicle.setCompany(company);
            return true;
        } else {
            return false;
        }
    }
}
