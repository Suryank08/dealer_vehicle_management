package com.example.dealer_vehicle_management.rest;

import com.example.dealer_vehicle_management.entity.Dealer;
import com.example.dealer_vehicle_management.service.DealerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(("/api/dealers"))
public class DealerController {
    @Autowired
    private DealerService dealerService;

    @GetMapping("/{id}")
    public ResponseEntity<Dealer> getDealerById(@PathVariable UUID id){
            Dealer dealer = dealerService.getDealer(id);
            return new ResponseEntity<>(dealer, HttpStatus.OK);
    }
    @GetMapping("/")
    public ResponseEntity<List<Dealer>> getAllDealer() {
        List<Dealer> dealerList = dealerService.getAllDealer();
        if (dealerList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(dealerList, HttpStatus.OK);
    }
    @PostMapping("/")
    public ResponseEntity<Dealer> createDealer(@RequestBody Dealer dealer) {
        Dealer createdDealer = dealerService.addDealer(dealer);
        return new ResponseEntity<>(createdDealer, HttpStatus.CREATED);
    }
    @PostMapping("/update")
    public ResponseEntity<Dealer> updateDealer(@RequestBody Dealer dealer) {
        Dealer createdDealer = dealerService.updateDealer(dealer);
        return new ResponseEntity<>(createdDealer, HttpStatus.OK);
    }
    @DeleteMapping("/dealers/{id}")
    public ResponseEntity<Void> deleteDealer(@PathVariable UUID id) {
        dealerService.removeDealer(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
