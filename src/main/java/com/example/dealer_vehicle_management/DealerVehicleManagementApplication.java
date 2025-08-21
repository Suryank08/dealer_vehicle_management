package com.example.dealer_vehicle_management;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class DealerVehicleManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(DealerVehicleManagementApplication.class, args);
	}

}
