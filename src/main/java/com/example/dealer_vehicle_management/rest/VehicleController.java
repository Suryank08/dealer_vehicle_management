package com.example.dealer_vehicle_management.rest;


import com.example.dealer_vehicle_management.entity.Vehicle;
import com.example.dealer_vehicle_management.enums.SubscriptionType;
import com.example.dealer_vehicle_management.request.VehicleRequest;
import com.example.dealer_vehicle_management.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/vehicles")
public class VehicleController {
    @Autowired
    private VehicleService vehicleService;

    @GetMapping("/{id}")
    public ResponseEntity<Vehicle> getVehicleById(@PathVariable UUID id){
        Vehicle vehicle = vehicleService.getVehicleById(id);
        return new ResponseEntity<>(vehicle, HttpStatus.OK);
    }
    @GetMapping("/")
    public ResponseEntity<List<Vehicle>> getAllVehicle() {
        List<Vehicle> vehicleList = vehicleService.getAllVehicle();
        if (vehicleList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(vehicleList, HttpStatus.OK);
    }
    @PostMapping("/")
    public ResponseEntity<Vehicle> createVehicle(@RequestBody VehicleRequest vehicleRequest) {

        Vehicle createdVehicle = vehicleService.addVehicle(vehicleRequest);
        return new ResponseEntity<>(createdVehicle, HttpStatus.CREATED);
    }
    @PostMapping("/update")
    public ResponseEntity<Vehicle> updateVehicle(@RequestBody Vehicle vehicle) {
        Vehicle createdVehicle = vehicleService.updateVehicle(vehicle);
        return new ResponseEntity<>(createdVehicle, HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVehicle(@PathVariable UUID id) {
        vehicleService.removeVehicle(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @GetMapping("/premium-dealers")
    public ResponseEntity<List<Vehicle>> getAllVehicleOfPremiumDealer(){
       List<Vehicle> vehicleList= vehicleService.getAllVehicleByDealerSubscription(SubscriptionType.PREMIUM);
       return new ResponseEntity<>(vehicleList,HttpStatus.OK);
    }
}
