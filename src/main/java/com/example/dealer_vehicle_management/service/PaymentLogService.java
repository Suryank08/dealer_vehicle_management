package com.example.dealer_vehicle_management.service;
import com.example.dealer_vehicle_management.entity.PaymentLog;
import com.example.dealer_vehicle_management.request.PaymentRequest;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

public interface PaymentLogService {
    public PaymentLog addPayment(PaymentRequest paymentRequest);
    public List<PaymentLog> getAllPayment();
    public PaymentLog getPayment(UUID id);
    public PaymentLog updatePayment(PaymentLog dealer);
    public CompletableFuture<Void> updatePaymentStatusAfterDelay(UUID paymentId);
}
