package com.example.spring.mongo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring.mongo.dto.OrderDTO;
import com.example.spring.mongo.service.OrderService;

@RestController
@RequestMapping("/order")
public class BookOrderController {

	private OrderService orderService;

	public BookOrderController(OrderService orderService) {
		super();
		this.orderService = orderService;
	}

	@GetMapping
	public ResponseEntity<List<OrderDTO>> getOrders() {
		List<OrderDTO> Orders = orderService.getAllResource();
		return ResponseEntity.status(HttpStatus.OK).body(Orders);
	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<OrderDTO> getOrderById(@PathVariable int id) throws Exception {
		OrderDTO orderDTO = orderService.getResourceById(id);
		return ResponseEntity.status(HttpStatus.OK).body(orderDTO);
	}

	@PostMapping(path = "/save-resource")
	public ResponseEntity<OrderDTO> saveOrder(@RequestBody OrderDTO orderDTO) {
		OrderDTO order = orderService.createResource(orderDTO);
		return ResponseEntity.status(HttpStatus.CREATED).body(order);
	}

	@PutMapping(path = "/update-resource")
	public ResponseEntity<OrderDTO> updateOrderDetails(@RequestBody OrderDTO orderDTO) {
		OrderDTO updatedOrder = orderService.updateResource(orderDTO);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(updatedOrder);
	}

	@DeleteMapping(path = "/delete-resource")
	public ResponseEntity<String> deleteorder(@RequestBody OrderDTO orderDTO) {
		orderService.deleteResource(orderDTO);
		return ResponseEntity.status(HttpStatus.OK).body("Order deleted!");
	}


}
