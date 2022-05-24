package com.fcamara.desafio.Repository;

import com.fcamara.desafio.Model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
}
