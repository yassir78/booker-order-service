package com.fstg.bookerorderservice.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fstg.bookerorderservice.bean.OrderStatus;
import com.fstg.bookerorderservice.repository.OrderStatusRepository;
import com.fstg.bookerorderservice.service.facade.OrderStatusService;
@Service
public class OrderStatusServiceImpl implements OrderStatusService {
    @Autowired
    private OrderStatusRepository orderStatusRepository;
	@Override
	public Optional<OrderStatus> save(OrderStatus orderStatus) {
		// TODO Auto-generated method stub
		
		return Optional.of(orderStatusRepository.save(orderStatus));
	}

}
