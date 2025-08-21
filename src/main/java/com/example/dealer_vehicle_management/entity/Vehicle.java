package com.example.dealer_vehicle_management.entity;

import com.example.dealer_vehicle_management.enums.StatusType;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "vehicle")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID vehicleId;
    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.DETACH, CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "dealer_id", nullable = false)
    @JsonBackReference
    private Dealer dealer;
    @Column(name = "model", nullable = false)
    private String model;
    @Column(name = "price", nullable = false)
    private Long price;
    @Enumerated(value = EnumType.STRING)
    @Column(name = "status_type", nullable = false)
    private StatusType statusType;
}
