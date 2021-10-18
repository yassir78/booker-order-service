package com.fstg.bookerorderservice.service.impl;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fstg.bookerorderservice.bean.CustomerOrder;
import com.fstg.bookerorderservice.bean.OrderItem;
import com.fstg.bookerorderservice.repository.OrderItemRepository;
import com.fstg.bookerorderservice.service.facade.OrderItemService;

@Service
public class OrderItemServiceimpl implements OrderItemService {
	@Autowired
	private OrderItemRepository orderItemRepository;

	@Override
	public void saveOrderItems(List<OrderItem> orderItems, CustomerOrder customerOrder) {
		// TODO Auto-generated method stub
		System.out.println(orderItems.size());
		orderItems.forEach(orderItem -> {
			orderItem.setRelatedCustomerOrder(customerOrder);
			orderItemRepository.save(orderItem);
			//customerOrder.getOrderItems().add(orderItem);
		});
	}

	@Override
	public void deleteOrderItems(List<OrderItem> orderItems) {
		// TODO Auto-generated method stub
		orderItems.stream().filter(Objects::nonNull).forEach(customerOrderItem -> {
			orderItemRepository.delete(customerOrderItem);
		});
	}

}
