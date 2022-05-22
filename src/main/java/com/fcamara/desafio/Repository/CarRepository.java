package com.fcamara.desafio.Repository;

import com.fcamara.desafio.Model.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Long> {
}
