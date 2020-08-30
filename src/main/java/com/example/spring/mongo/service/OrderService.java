package com.example.spring.mongo.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.spring.mongo.dto.OrderDTO;
import com.example.spring.mongo.model.Order;
import com.example.spring.mongo.repository.OrderRepository;

@Service
public class OrderService {

	private OrderRepository orderRepository;
	
	@Autowired
	private ModelMapper mapper;

	public OrderService(OrderRepository orderRepository) {
		super();
		this.orderRepository = orderRepository;
	}

	public List<OrderDTO> getAllResource() {
		List<Order> orders = orderRepository.findAll();
		return orders.stream().map(order -> mapper.map(order, OrderDTO.class)).collect(Collectors.toList());
	}

	@Transactional
	public OrderDTO createResource(OrderDTO orderDTO) {
		Order order = orderRepository.save(mapper.map(orderDTO, Order.class));
		return mapper.map(order, OrderDTO.class);

	}

	@Transactional
	public OrderDTO updateResource(OrderDTO orderDTO) {
		return createResource(orderDTO);
	}

	@Transactional
	public void deleteResource(OrderDTO orderDTO) {
		orderRepository.delete(mapper.map(orderDTO, Order.class));
	}

	public OrderDTO getResourceById(int orderId) throws Exception {
		Optional<Order> orderOpt = orderRepository.findById(orderId);
		if (orderOpt.isPresent()) return mapper.map(orderOpt.get(), OrderDTO.class);
		throw new Exception("Not found");
	}

}
