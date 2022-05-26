package com.fcamara.desafio.Repository;

import com.fcamara.desafio.Model.Vehicle;
import com.fcamara.desafio.Model.VehicleInGarage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface VehicleInGarageRepository extends JpaRepository<VehicleInGarage, Long> {
    VehicleInGarage findByVehicleId(Long vehicle_id);
}
