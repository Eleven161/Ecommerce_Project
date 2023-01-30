package com.ecommerce.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.project.entity.Order;

public interface OrderRepo extends JpaRepository<Order, Integer>{

}
