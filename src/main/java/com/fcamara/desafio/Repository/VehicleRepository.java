package com.fcamara.desafio.Repository;

import com.fcamara.desafio.Model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
    Vehicle findByRegistration(String registration);
}
