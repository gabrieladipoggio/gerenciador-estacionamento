package com.fcamara.desafio.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fcamara.desafio.Repository.VehicleRepository;
import io.swagger.annotations.ApiModel;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name="Vehicles")
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Long id;

    @NotEmpty @NotNull
    private String make;

    @NotEmpty @NotNull
    private String model;

    @NotEmpty @NotNull
    private String color;

    @NotEmpty @NotNull
    private String registration;

    @NotNull
    @Enumerated(EnumType.STRING)
    private TypeOfVehicle type;

    @ApiModel
    public enum TypeOfVehicle {
        CAR,
        MOTORCYCLE
    }

    @OneToMany(mappedBy = "vehicle")
    @JsonIgnore
    private List<VehicleInGarage> companyHistory;

    public Vehicle(String make, String model, String color, String registration, TypeOfVehicle type) {
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

    public TypeOfVehicle getType() {
        return type;
    }

    public void setType(TypeOfVehicle type) {
        this.type = type;
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
}
