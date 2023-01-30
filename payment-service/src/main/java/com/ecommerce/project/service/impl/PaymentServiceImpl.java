package com.ecommerce.project.service.impl;

import java.util.Random;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.project.entity.Payment;
import com.ecommerce.project.repository.PaymentRepo;
import com.ecommerce.project.service.PaymentService;

@Service
public class PaymentServiceImpl implements PaymentService {
	@Autowired
    private PaymentRepo paymentRepo;
	@Override
	public Payment initiatePayment(Payment payment) {
		payment.setTransactionId(UUID.randomUUID().toString());
		payment.setPaymentStatus(paymentProcessing());
		return paymentRepo.save(payment);
	}
	//this api is dummy for payment status sent thru 3rd party apis like razorpay,paypal,paytm 
		public String paymentProcessing() {
			return new Random().nextBoolean()?"success":"false";	
		}
}
