package com.fstg.bookerorderservice.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fstg.bookerorderservice.bean.CustomerOrder;

@Repository
public interface CustomerOrderRepository extends JpaRepository<CustomerOrder, Long> {
	public Optional<CustomerOrder> findByRef(String ref);

	public int deleteByRef(String ref);
}
