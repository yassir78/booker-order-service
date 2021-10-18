package com.fstg.bookerorderservice.service.facade;

import java.util.List;

import com.fstg.bookerorderservice.bean.CustomerOrder;
import com.fstg.bookerorderservice.bean.OrderItem;

public interface OrderItemService {
	public void saveOrderItems(List<OrderItem> orderItems, CustomerOrder customerOrder);

	public void deleteOrderItems(List<OrderItem> orderItems);
}
