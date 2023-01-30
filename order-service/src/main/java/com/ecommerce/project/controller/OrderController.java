package com.ecommerce.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.project.common.TransactionRequest;
import com.ecommerce.project.common.TransactionResponse;
import com.ecommerce.project.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {
	@Autowired
	private OrderService orderService;
	
	@PostMapping("/bookOrder")
	public ResponseEntity<TransactionResponse> saveOrder(@RequestBody TransactionRequest request){
		return ResponseEntity.ok(orderService.saveOrder(request));
	}

}
