package com.example.dealer_vehicle_management.rest;

import com.example.dealer_vehicle_management.entity.PaymentLog;
import com.example.dealer_vehicle_management.service.PaymentLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {
    @Autowired
    private PaymentLogService PaymentLogService;

    @GetMapping("/{id}")
    public ResponseEntity<PaymentLog> getPaymentLogById(@PathVariable UUID id){
        PaymentLog PaymentLog = PaymentLogService.getPayment(id);
        return new ResponseEntity<>(PaymentLog, HttpStatus.OK);
    }
    @GetMapping("/")
    public ResponseEntity<List<PaymentLog>> getAllPaymentLog() {
        List<PaymentLog> PaymentLogList = PaymentLogService.getAllPayment();
        if (PaymentLogList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(PaymentLogList, HttpStatus.OK);
    }
    @PostMapping("/")
    public ResponseEntity<PaymentLog> createPaymentLog(@RequestBody PaymentLog PaymentLog) {
        PaymentLog createdPaymentLog = PaymentLogService.addPayment(PaymentLog);
        return new ResponseEntity<>(createdPaymentLog, HttpStatus.CREATED);
    }
    @PostMapping("/update")
    public ResponseEntity<PaymentLog> updatePaymentLog(@RequestBody PaymentLog PaymentLog) {
        PaymentLog createdPaymentLog = PaymentLogService.updatePayment(PaymentLog);
        return new ResponseEntity<>(createdPaymentLog, HttpStatus.OK);
    }
}
