package com.fcamara.desafio.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
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

    private ZonedDateTime entryTime;
    private ZonedDateTime exitTime;

    public VehicleInGarage(Vehicle vehicle, Company company) {
        this.vehicle = vehicle;
        this.company = company;
        this.entryTime = ZonedDateTime.now();
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public Company getCompany() {
        return company;
    }

    public ZonedDateTime getEntryTime() {
        return entryTime;
    }

    public ZonedDateTime getExitTime() {
        return exitTime;
    }

    public void setExitTime(ZonedDateTime exitTime) {
        this.exitTime = exitTime;
    }
}
