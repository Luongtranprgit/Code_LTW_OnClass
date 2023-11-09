package com.example.bookory.purchase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class PurchaseController {
	@Autowired
	PurchaseService service;
	@PostMapping("/cancelled/{orderid}")
	public ResponseEntity<?> cancelOrder(@PathVariable String orderid){
		service.savePurchase(orderid, "cancelled");
		return ResponseEntity.status(HttpStatus.OK).body(200);
	}
	@PostMapping("/completed/{orderid}")
	public ResponseEntity<?> completedOrder(@PathVariable String orderid){
		service.savePurchase(orderid, "completed");
		return ResponseEntity.status(HttpStatus.OK).body(200);
	}
}
