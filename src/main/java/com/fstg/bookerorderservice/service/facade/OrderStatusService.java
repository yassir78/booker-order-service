package com.fstg.bookerorderservice.service.facade;

import java.util.Optional;

import com.fstg.bookerorderservice.bean.OrderStatus;

public interface OrderStatusService {
	public Optional<OrderStatus> save(OrderStatus orderStatus);
}
