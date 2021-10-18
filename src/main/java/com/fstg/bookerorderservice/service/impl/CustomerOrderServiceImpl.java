package com.fstg.bookerorderservice.service.impl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fstg.bookerorderservice.bean.CustomerOrder;
import com.fstg.bookerorderservice.repository.CustomerOrderRepository;
import com.fstg.bookerorderservice.service.facade.CustomerOrderService;
import com.fstg.bookerorderservice.service.facade.OrderItemService;
import com.fstg.bookerorderservice.service.facade.OrderStatusService;

@Service
public class CustomerOrderServiceImpl implements CustomerOrderService {
	@Autowired
	private CustomerOrderRepository customerOrderRepository;
	@Autowired
	private OrderItemService orderItemService;
	@Autowired
	private OrderStatusService orderStatusService;

	@Override
	public Optional<CustomerOrder> save(CustomerOrder customerOrder) {
		// TODO Auto-generated method stub
		orderStatusService.save(customerOrder.getStatus());
		CustomerOrder savedCustomerOrder = customerOrderRepository.save(customerOrder);
		orderItemService.saveOrderItems(customerOrder.getOrderItems(), savedCustomerOrder);
		return Optional.of(savedCustomerOrder);
	}

	@Override
	public List<CustomerOrder> findAll() {
		// TODO Auto-generated method stub
		return customerOrderRepository.findAll();
	}

	@Override
	public Optional<CustomerOrder> findByRef(String ref) {
		// TODO Auto-generated method stub
		return customerOrderRepository.findByRef(ref);
	}

	@Override
	@Transactional
	public int deleteByRef(String ref) {
		// TODO Auto-generated method stub
		CustomerOrder customerOrderToBeDeleted = findByRef(ref).get();
		orderItemService.deleteOrderItems(customerOrderToBeDeleted.getOrderItems());
		return customerOrderRepository.deleteByRef(ref);
	}

}
