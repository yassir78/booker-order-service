package com.fstg.bookerorderservice.infra.dao;

import com.fstg.bookerorderservice.infra.entity.CustomerOrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerOrderRepository extends JpaRepository<CustomerOrderEntity, Long> {
	public Optional<CustomerOrderEntity> findByRef(String ref);
	public int deleteByRef(String ref);
}
