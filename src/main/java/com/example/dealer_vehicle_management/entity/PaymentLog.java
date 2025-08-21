package com.example.dealer_vehicle_management.entity;

import com.example.dealer_vehicle_management.enums.PaymentMethodType;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@AllArgsConstructor@NoArgsConstructor
@Getter
@Setter
public class PaymentLog {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "payment_id")
    private UUID paymentId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dealer_id",nullable = false)
    @JsonBackReference
    private Dealer dealer;

    @Column(name = "amount")
    private Long amount;

    @Enumerated(value = EnumType.STRING)
    @Column(name="method")
    private PaymentMethodType paymentMethodType;

    //__TO_BE CONSIDERED LATER__//
    @Column(name="status")
    private String status;

}
