package com.example.dealer_vehicle_management.dao;

import com.example.dealer_vehicle_management.entity.Dealer;
import com.example.dealer_vehicle_management.enums.SubscriptionType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface DealerDao extends JpaRepository<Dealer, UUID> {
    @Query("SELECT d FROM Dealer d WHERE d.subscriptionType = :subType")
    List<Dealer> findBySubscriptionType(@Param("subType") SubscriptionType subscriptionType);

}
