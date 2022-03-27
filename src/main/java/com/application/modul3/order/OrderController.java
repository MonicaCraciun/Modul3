package com.application.modul3.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.application.modul3.order.dto.OrderDTO;
import com.application.modul3.order.mapper.OrderMapper;

@RestController
@RequestMapping("/orders")
public class OrderController {

	@Autowired
	private OrderService orderService;

	@Autowired
	private OrderMapper orderMapper;

	@PostMapping("/add/{clientId}")
	public ResponseEntity<Object> createOrder(@PathVariable Integer clientId, @RequestBody OrderDTO orderDTO) {
		try {
			Order createdOrder = orderService.createOrder(clientId, orderMapper.orderDTO2Order(orderDTO));
			return ResponseEntity.ok(orderMapper.order2OrderDTO(createdOrder));
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	@DeleteMapping("delete/{orderId}")
	public void deleteOrder(@PathVariable Integer orderId) {
		orderService.deleteOrder(orderId);
	}

}
