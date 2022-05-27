package com.fcamara.desafio.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fcamara.desafio.Repository.VehicleInGarageRepository;
import org.apache.tomcat.jni.Local;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;

@Entity
@Table(name="vehicles_in_garage")
public class VehicleInGarage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Long id;

    @ManyToOne
    @JoinColumn(name = "vehicle_id", referencedColumnName = "id")
    private Vehicle vehicle;

    @ManyToOne
    @JoinColumn(name = "company_id", referencedColumnName = "id")
    private Company company;

    private LocalDateTime entryTime;
    private LocalDateTime exitTime;

    public VehicleInGarage(Vehicle vehicle, Company company) {
        this.vehicle = vehicle;
        this.company = company;
        this.entryTime = LocalDateTime.now();
    }

    public VehicleInGarage(){

    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public Company getCompany() {
        return company;
    }

    public LocalDateTime getEntryTime() {
        return entryTime;
    }

    public LocalDateTime getExitTime() {
        return exitTime;
    }

    public void setExitTime(LocalDateTime exitTime) {
        this.exitTime = exitTime;
    }
}
