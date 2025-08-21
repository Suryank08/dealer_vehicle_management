package com.example.dealer_vehicle_management.entity;

import com.example.dealer_vehicle_management.enums.SubscriptionType;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "dealer")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Dealer {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "dealer_id")
    private UUID dealerId;
    @Column(name = "name", nullable = false)
    private String dealerName;
    @Email
    @Column(name = "email", nullable = false, unique = true)
    private String dealerEmail;
    @Enumerated(value = EnumType.STRING)
    @Column(name = "subscription_type",nullable = false)
    private SubscriptionType subscriptionType;
    @OneToMany(mappedBy = "dealer",fetch = FetchType.LAZY , cascade = {CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.DETACH, CascadeType.REFRESH})
    @JsonManagedReference
    List<Vehicle> vehicleList;
    @OneToMany(mappedBy = "dealer",fetch = FetchType.LAZY)
    @JsonManagedReference
   List<PaymentLog> paymentLogList;
}
