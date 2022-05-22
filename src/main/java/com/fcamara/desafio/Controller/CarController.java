package com.fcamara.desafio.Controller;

import com.fcamara.desafio.Model.Car;
import com.fcamara.desafio.Repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Table;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path="/car")
public class CarController {
    @Autowired
    private CarRepository carRepository;

    @PostMapping
    public ResponseEntity<Car> createCar(@RequestBody @Valid Car car){
        carRepository.save(car);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    public List<Car> getCars(){
        return carRepository.findAll();
    }

    @GetMapping("/{id}")
    public Car getCarById(@PathVariable Long id){
        Car car = carRepository.findById(id).get();
        return car;
    }

    @PutMapping ("/{id}")
    @Transactional
    public ResponseEntity<Car> updateCar(@PathVariable Long id, @RequestBody @Valid Car car){
        car.update(id, carRepository);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Car> deleteCar(@PathVariable Long id){
        carRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
