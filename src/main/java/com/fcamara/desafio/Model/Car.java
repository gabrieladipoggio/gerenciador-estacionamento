package com.fcamara.desafio.Model;

import com.fcamara.desafio.Repository.CarRepository;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="Cars")
public class Car {
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

    public Car(String make, String model, String color, String registration, String type) {
        this.make = make;
        this.model = model;
        this.color = color;
        this.registration = registration;
        this.type = type;
    }

    public Car(){

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

    public Car update(Long id, CarRepository carRepository){
        Car car = carRepository.getReferenceById(id);
        car.setMake(this.getMake());
        car.setModel(this.getModel());
        car.setColor(this.getColor());
        car.setRegistration(this.getRegistration());
        car.setType(this.getType());
        return car;
    }
}
