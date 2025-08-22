package com.example.dealer_vehicle_management.service;

import com.example.dealer_vehicle_management.dao.PaymentDao;
import com.example.dealer_vehicle_management.entity.Dealer;
import com.example.dealer_vehicle_management.entity.PaymentLog;
import com.example.dealer_vehicle_management.entity.Vehicle;
import com.example.dealer_vehicle_management.enums.PaymentStatus;
import com.example.dealer_vehicle_management.exception.ResourceNotFoundException;
import com.example.dealer_vehicle_management.request.PaymentRequest;
import com.example.dealer_vehicle_management.request.VehicleRequest;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@Service
@AllArgsConstructor
public class PaymentLogServiceLogImpl implements PaymentLogService {
    @Autowired
    private final PaymentDao paymentDao;
    @Autowired
    private final DealerService dealerService;
    @Override
    @Transactional
    public PaymentLog addPayment(PaymentRequest paymentRequest){
        PaymentLog paymentLog= this.setPaymentFromPaymentRequest(paymentRequest);
        return paymentDao.save(paymentLog);
    }
    @Override
    public List<PaymentLog> getAllPayment(){
        return paymentDao.findAll();
    }
    @Override
    public PaymentLog getPayment(UUID id){
        return paymentDao.findById(id).orElseThrow(()->new ResourceNotFoundException("Payment Id Not Found"+id));
    }
    @Override
    @Transactional
    public PaymentLog updatePayment(PaymentLog paymentLog){
        return paymentDao.save(paymentLog);
    }
    @Async
    public CompletableFuture<Void> updatePaymentStatusAfterDelay(UUID paymentId) {
        try {
            // Wait for 5 seconds to simulate processing
            Thread.sleep(5000);

            // Logic to fetch the payment record by ID and update its status
            PaymentLog payment = paymentDao.findById(paymentId).orElse(null);
            if (payment != null) {
                payment.setStatus(PaymentStatus.SUCCESS);
                paymentDao.save(payment);
                System.out.println("Payment " + paymentId + " status updated to SUCCESS.");
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        return CompletableFuture.completedFuture(null);
    }

    public PaymentLog setPaymentFromPaymentRequest(PaymentRequest paymentRequest){
        Dealer dealer = dealerService.getDealer(paymentRequest.getDealerId());
        PaymentLog paymentLog =new PaymentLog();
        paymentLog.setDealer(dealer);
        paymentLog.setStatus(PaymentStatus.PENDING);
        paymentLog.setAmount(paymentRequest.getAmount());
        paymentLog.setPaymentMethodType(paymentRequest.getPaymentMethodType());
        return  paymentLog;
    }
}
