package com.example.dealer_vehicle_management.dao;

import com.example.dealer_vehicle_management.entity.PaymentLog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PaymentDao extends JpaRepository<PaymentLog, UUID> {
}
