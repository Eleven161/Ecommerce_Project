package com.ecommerce.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.project.entity.Payment;
import com.ecommerce.project.service.PaymentService;

@RestController
@RequestMapping("/payment")
public class PaymentController {
	@Autowired
	private PaymentService paymentService;
	@PostMapping
	public ResponseEntity<Payment> initiatePayment(@RequestBody Payment payment){
		
		return ResponseEntity.ok(paymentService.initiatePayment(payment));
	}
	

}
