package com.application.modul3.order;

import org.springframework.data.jpa.repository.JpaRepository;

import com.application.modul3.client.Client;

public interface OrderRepository extends JpaRepository<Order, Integer> {

	

}
