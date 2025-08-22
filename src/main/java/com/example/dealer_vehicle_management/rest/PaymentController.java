package com.example.dealer_vehicle_management.rest;

import com.example.dealer_vehicle_management.entity.PaymentLog;
import com.example.dealer_vehicle_management.request.PaymentRequest;
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
    private PaymentLogService paymentLogService;

    @GetMapping("/{id}")
    public ResponseEntity<PaymentLog> getPaymentLogById(@PathVariable UUID id){
        PaymentLog PaymentLog = paymentLogService.getPayment(id);
        return new ResponseEntity<>(PaymentLog, HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<List<PaymentLog>> getAllPaymentLog() {
        List<PaymentLog> PaymentLogList = paymentLogService.getAllPayment();
        if (PaymentLogList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(PaymentLogList, HttpStatus.OK);
    }
    @PostMapping("/")
    public ResponseEntity<PaymentLog> createPaymentLog(@RequestBody PaymentRequest paymentRequest) {
        PaymentLog createdPaymentLog = paymentLogService.addPayment(paymentRequest);
        return new ResponseEntity<>(createdPaymentLog, HttpStatus.CREATED);
    }

    @PostMapping("/initiate")
    public ResponseEntity<PaymentLog> initiatePayment(@RequestBody PaymentRequest paymentRequest) {
        PaymentLog savedPayment = paymentLogService.addPayment(paymentRequest);

        paymentLogService.updatePaymentStatusAfterDelay(savedPayment.getPaymentId());

        return ResponseEntity.ok(savedPayment);
    }
}
