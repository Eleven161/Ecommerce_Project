package com.ecommerce.project.service;

import com.ecommerce.project.common.TransactionRequest;
import com.ecommerce.project.common.TransactionResponse;

public interface OrderService {
	TransactionResponse saveOrder(TransactionRequest request);
}
