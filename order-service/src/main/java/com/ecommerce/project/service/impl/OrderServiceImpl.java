package com.ecommerce.project.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ecommerce.project.common.Payment;
import com.ecommerce.project.common.TransactionRequest;
import com.ecommerce.project.common.TransactionResponse;
import com.ecommerce.project.entity.Order;
import com.ecommerce.project.repository.OrderRepo;
import com.ecommerce.project.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	private OrderRepo orderRepo;
	@Autowired
	private RestTemplate template;

	@Override
	public TransactionResponse saveOrder(TransactionRequest request) {
		String message="";
		Payment payment=request.getPayment();
		Order order=request.getOrder();
		payment.setOrderId(order.getId());
		payment.setAmount(order.getPrice());
		Payment paymentResponse=template.postForObject("http://PAYMENT-SERVICE/payment", payment, Payment.class);
		message=paymentResponse.getPaymentStatus().equals("success") 
				? "payment done and order successfully" : "payment failed"; 
		orderRepo.save(order);
		return new TransactionResponse(order,paymentResponse.getTransactionId(),paymentResponse.getAmount(),message);
	}
	
   
}
