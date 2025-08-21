package com.example.dealer_vehicle_management.dao;

import com.example.dealer_vehicle_management.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface VehicleDao extends JpaRepository<Vehicle, UUID> {
}
