package com.example.dealer_vehicle_management.service;

import com.example.dealer_vehicle_management.dao.DealerDao;
import com.example.dealer_vehicle_management.dao.PaymentDao;
import com.example.dealer_vehicle_management.dao.VehicleDao;
import com.example.dealer_vehicle_management.entity.Dealer;
import com.example.dealer_vehicle_management.entity.PaymentLog;
import com.example.dealer_vehicle_management.entity.Vehicle;
import com.example.dealer_vehicle_management.enums.SubscriptionType;
import com.example.dealer_vehicle_management.exception.ResourceNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
@Service
@AllArgsConstructor
public class DealerServiceImpl implements DealerService{
    @Autowired
    private final DealerDao dealerDao;
    @Autowired
    private final VehicleDao vehicleDao;
    @Autowired
    private final PaymentDao paymentDao;
    @Override
    @Transactional
    public Dealer addDealer(Dealer dealer){
        Dealer newDealer = new Dealer();
        newDealer.setDealerName(dealer.getDealerName());
        newDealer.setDealerEmail(dealer.getDealerEmail());
        newDealer.setSubscriptionType(dealer.getSubscriptionType());

        Dealer savedDealer = dealerDao.save(newDealer);

        if (dealer.getVehicleList() != null && !dealer.getVehicleList().isEmpty()) {
            for (Vehicle vehicle : dealer.getVehicleList()) {
                vehicle.setDealer(savedDealer);
                vehicleDao.save(vehicle);
            }
        }

        if (dealer.getPaymentLogList() != null && !dealer.getPaymentLogList().isEmpty()) {
            for (PaymentLog paymentLog : dealer.getPaymentLogList()) {
                paymentLog.setDealer(savedDealer);
                paymentDao.save(paymentLog);
            }
        }
        return savedDealer;
    }
    @Override
    public List<Dealer> getAllDealer(){
        return dealerDao.findAll();
    }
    @Override
    public Dealer getDealer(UUID id){
        return dealerDao.findById(id).orElseThrow(()->new ResourceNotFoundException("No Dealer Found of this Id"));
    }
    @Override
    public List<Dealer> getAllDealerBySubscriptionType(SubscriptionType subscriptionType){
       List<Dealer> dealerList= dealerDao.findBySubscriptionType(subscriptionType);
       return dealerList;
    }
    @Override
    @Transactional
    public Dealer updateDealer(Dealer dealer) {
        Dealer existingDealer = dealerDao.findById(dealer.getDealerId())
                .orElseThrow(() -> new ResourceNotFoundException("Dealer with ID " + dealer.getDealerId() + " not found"));

        existingDealer.setDealerName(dealer.getDealerName());
        existingDealer.setDealerEmail(dealer.getDealerEmail());
        existingDealer.setSubscriptionType(dealer.getSubscriptionType());

        if (dealer.getVehicleList() != null) {
            existingDealer.getVehicleList().clear();
            for (Vehicle vehicle : dealer.getVehicleList()) {
                vehicle.setDealer(existingDealer);
                Vehicle managedVehicle = vehicleDao.save(vehicle);
                existingDealer.getVehicleList().add(managedVehicle);
            }
        }
        if (dealer.getPaymentLogList() != null) {
            existingDealer.getPaymentLogList().clear();
            for (PaymentLog paymentLog : dealer.getPaymentLogList()) {
                paymentLog.setDealer(existingDealer);
                PaymentLog managedPaymentLog = paymentDao.save(paymentLog);
                existingDealer.getPaymentLogList().add(managedPaymentLog);
            }
        }
        return dealerDao.save(existingDealer);
    }
    @Override
    @Transactional
    public void removeDealer(UUID id){
        Dealer dealer = dealerDao.findById(id).orElseThrow(()->new ResourceNotFoundException("No Dealer Found of this Id"));
        dealerDao.delete(dealer);
    }
}
