package com.fstg.bookerorderservice.service.facade;

import java.util.List;
import java.util.Optional;

import com.fstg.bookerorderservice.bean.CustomerOrder;


public interface CustomerOrderService {
	public Optional<CustomerOrder> save(CustomerOrder CustomerOrder);

	public List<CustomerOrder> findAll();

	public Optional<CustomerOrder> findByRef(String ref);

	public int deleteByRef(String ref);
}
