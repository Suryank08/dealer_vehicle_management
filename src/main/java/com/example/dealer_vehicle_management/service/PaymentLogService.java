package com.example.dealer_vehicle_management.service;
import com.example.dealer_vehicle_management.entity.PaymentLog;

import java.util.List;
import java.util.UUID;

public interface PaymentLogService {
    public PaymentLog addPayment(PaymentLog paymentLog);
    public List<PaymentLog> getAllPayment();
    public PaymentLog getPayment(UUID id);
    public PaymentLog updatePayment(PaymentLog dealer);

}
