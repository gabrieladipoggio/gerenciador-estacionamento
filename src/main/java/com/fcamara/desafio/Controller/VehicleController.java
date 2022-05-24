package com.fcamara.desafio.Controller;

import com.fcamara.desafio.Model.Vehicle;
import com.fcamara.desafio.Repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path="/vehicle")
public class VehicleController {
    @Autowired
    private VehicleRepository vehicleRepository;

    @PostMapping
    public ResponseEntity<Vehicle> createVehicle(@RequestBody @Valid Vehicle vehicle){
        vehicleRepository.save(vehicle);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    public List<Vehicle> getVehicles(){
        return vehicleRepository.findAll();
    }

    @GetMapping("/{id}")
    public Vehicle getCarById(@PathVariable Long id){
        Vehicle vehicle = vehicleRepository.findById(id).get();
        return vehicle;
    }

    @PutMapping ("/{id}")
    @Transactional
    public ResponseEntity<Vehicle> updateVehicle(@PathVariable Long id, @RequestBody @Valid Vehicle vehicle){
        vehicle.update(id, vehicleRepository);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Vehicle> deleteVehicle(@PathVariable Long id){
        vehicleRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
