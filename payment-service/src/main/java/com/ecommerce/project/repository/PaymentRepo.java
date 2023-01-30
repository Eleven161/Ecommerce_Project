package com.ecommerce.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.project.entity.Payment;

public interface PaymentRepo extends JpaRepository<Payment,Integer>{

}
