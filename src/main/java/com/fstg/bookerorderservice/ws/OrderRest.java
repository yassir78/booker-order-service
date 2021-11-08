package com.fstg.bookerorderservice.ws;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fstg.bookerorderservice.bean.CustomerOrder;
import com.fstg.bookerorderservice.service.facade.CustomerOrderService;
import com.fstg.bookerorderservice.service.required.ProductServiceRequired;

@RequestMapping("/booker-order")
@RestController
public class OrderRest {

	@Autowired
	private CustomerOrderService customerOrderService;
	@Autowired
	private ProductServiceRequired productServiceRequired;

	@PostMapping
	public Optional<CustomerOrder> save(@RequestBody CustomerOrder order) {
		return customerOrderService.save(order);
	}

	@GetMapping
	public List<CustomerOrder> findAll() {
		return customerOrderService.findAll();
	}

	@GetMapping("/ref/{ref}")
	public Optional<CustomerOrder> findByRef(@PathVariable String ref) {
		return customerOrderService.findByRef(ref);
	}

	@DeleteMapping("/ref/{ref}")
	public int deleteByRef(@PathVariable String ref) {
		return customerOrderService.deleteByRef(ref);
	}

}
