package com.application.modul3.order;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.modul3.client.Client;
import com.application.modul3.client.ClientService;
import com.application.modul3.exemplary.Exemplary;

@Service
public class OrderService {

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private ClientService clientService;

	public Order createOrder(Integer clientId, Order order) throws Exception {
		Client client = clientService.getClientById(clientId);
		if (client == null) {
			throw new Exception("Client with id: " + clientId + "was not found");
		}

		client.addOrder(order);
		return orderRepository.saveAndFlush(order);

	}

	public void deleteOrder(Integer orderId) {
		orderRepository.deleteById(orderId);
	}

}
