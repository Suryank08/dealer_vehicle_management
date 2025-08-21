package com.example.dealer_vehicle_management.service;

import com.example.dealer_vehicle_management.entity.Dealer;
import com.example.dealer_vehicle_management.enums.SubscriptionType;

import java.util.List;
import java.util.UUID;

public interface DealerService {
    public Dealer addDealer(Dealer dealer);
    public List<Dealer> getAllDealer();
    public Dealer getDealer(UUID id);
    public List<Dealer> getAllDealerBySubscriptionType(SubscriptionType subscriptionType);
    public Dealer updateDealer(Dealer dealer);
    public void removeDealer(UUID id);
}
