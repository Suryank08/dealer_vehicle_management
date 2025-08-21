package com.example.dealer_vehicle_management.service;

import com.example.dealer_vehicle_management.dao.PaymentDao;
import com.example.dealer_vehicle_management.entity.PaymentLog;
import com.example.dealer_vehicle_management.exception.ResourceNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class PaymentLogServiceLogImpl implements PaymentLogService {
    private final PaymentDao paymentDao;
    @Override
    @Transactional
    public PaymentLog addPayment(PaymentLog payment){
        return paymentDao.save(payment);
    }
    @Override
    public List<PaymentLog> getAllPayment(){
        return paymentDao.findAll();
    }
    @Override
    public PaymentLog getPayment(UUID id){
        return paymentDao.findById(id).orElseThrow(()->new ResourceNotFoundException("Payment Id Not Found"));
    }
    @Override
    @Transactional
    public PaymentLog updatePayment(PaymentLog paymentLog){
        return paymentDao.save(paymentLog);
    }
}
