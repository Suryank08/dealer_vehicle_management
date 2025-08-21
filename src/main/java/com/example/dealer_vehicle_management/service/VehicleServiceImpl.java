package com.example.dealer_vehicle_management.service;

import com.example.dealer_vehicle_management.dao.VehicleDao;
import com.example.dealer_vehicle_management.entity.Dealer;
import com.example.dealer_vehicle_management.entity.Vehicle;
import com.example.dealer_vehicle_management.enums.SubscriptionType;
import com.example.dealer_vehicle_management.exception.ResourceNotFoundException;
import com.example.dealer_vehicle_management.request.VehicleRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class VehicleServiceImpl implements VehicleService {
    private  final VehicleDao vehicleDao;
    private final DealerService dealerService;
    @Override
    @Transactional
    public Vehicle addVehicle(VehicleRequest vehicleRequest){

       Vehicle vehicle = this.setVehicleFromVehicleRequest(vehicleRequest);
        return vehicleDao.save(vehicle);
    }
    @Override
    public List<Vehicle> getAllVehicle(){
        return vehicleDao.findAll();
    }
    @Override
    public Vehicle getVehicleById(UUID id){
        return vehicleDao.findById(id).orElseThrow(()->new ResourceNotFoundException("Vehicle Id Not Found"));
    }
    @Override
    public List<Vehicle> getAllVehicleByDealerSubscription(SubscriptionType subscriptionType){
        List<Vehicle> vehicleList=new ArrayList<>();
        List<Dealer> dealerList= dealerService.getAllDealerBySubscriptionType(subscriptionType);
        for( Dealer dealer:dealerList){
            vehicleList.addAll(dealer.getVehicleList());
        }
        return vehicleList;
    }
    @Override
    @Transactional
    public Vehicle updateVehicle(Vehicle vehicle){
        return vehicleDao.save(vehicle);
    }
    @Override
    @Transactional
    public void removeVehicle(UUID id){
        Vehicle vehicle= vehicleDao.findById(id).orElseThrow(()->new ResourceNotFoundException("No such vehicle id found"));
        vehicleDao.delete(vehicle);
    }
    public Vehicle setVehicleFromVehicleRequest(VehicleRequest vehicleRequest){
        Dealer dealer = dealerService.getDealer(vehicleRequest.getDealerId());
        Vehicle vehicle = new Vehicle();
        vehicle.setModel(vehicleRequest.getModel());
        vehicle.setDealer(dealer);
        vehicle.setPrice(vehicleRequest.getPrice());
        vehicle.setStatusType(vehicleRequest.getStatusType());
        return  vehicle;
    }
}
