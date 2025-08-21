package com.example.dealer_vehicle_management.service;

import com.example.dealer_vehicle_management.entity.Vehicle;
import com.example.dealer_vehicle_management.enums.SubscriptionType;
import com.example.dealer_vehicle_management.request.VehicleRequest;

import java.util.List;
import java.util.UUID;

public interface VehicleService {
    public Vehicle addVehicle(VehicleRequest vehicleRequest);
    public List<Vehicle> getAllVehicle();
    public Vehicle getVehicleById(UUID id);
    public List<Vehicle> getAllVehicleByDealerSubscription(SubscriptionType subscriptionType);
    public Vehicle updateVehicle(Vehicle vehicle);
    public void removeVehicle(UUID id);
}
