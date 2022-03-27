package com.application.modul3.order.mapper;

import java.util.List;

import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.application.modul3.order.Order;
import com.application.modul3.order.dto.OrderDTO;

@Service
public class OrderMapper {

	public OrderDTO order2OrderDTO(Order order) {
		OrderDTO orderDTO = new OrderDTO();
		orderDTO.setId(order.getId());
		orderDTO.setDate(order.getDate());
		orderDTO.setNrOfItems(order.getNrOfItems());
		return orderDTO;
	}

	public Order orderDTO2Order(OrderDTO orderDTO) {
		Order order = new Order();
		order.setId(orderDTO.getId());
		order.setDate(orderDTO.getDate());
		order.setNrOfItems(orderDTO.getNrOfItems());
		return order;
	}

	public List<OrderDTO> orderList2OrderDTOList(List<Order> orderList) {
		return orderList.stream().map(order -> order2OrderDTO(order)).collect(Collectors.toList());
	}

}
