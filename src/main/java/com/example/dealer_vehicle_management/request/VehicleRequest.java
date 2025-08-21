package com.example.dealer_vehicle_management.request;

import com.example.dealer_vehicle_management.entity.Dealer;
import com.example.dealer_vehicle_management.enums.StatusType;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VehicleRequest {
    @NotNull
    @JsonProperty("dealer_id")
    private UUID dealerId;
    @NotNull
    @JsonProperty("model")
    private String model;
    @NotNull
    private Long price;
    @Enumerated(value = EnumType.STRING)
    @NotNull
    private StatusType statusType;

    @Override
    public String toString() {
        return "VehicleRequest{" +
                "dealerId=" + dealerId +
                ", modelName='" + model + '\'' +
                ", price=" + price +
                ", statusType=" + statusType +
                '}';
    }
}
