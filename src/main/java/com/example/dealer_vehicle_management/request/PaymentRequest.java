package com.example.dealer_vehicle_management.request;

import com.example.dealer_vehicle_management.entity.Dealer;
import com.example.dealer_vehicle_management.enums.PaymentMethodType;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PaymentRequest {
    @NotNull
    @JsonProperty("dealer_id")
    private UUID dealerId;
    @NotNull
    private Long amount;
    @NotNull
    @Enumerated(value = EnumType.STRING)
    private PaymentMethodType paymentMethodType;

}
