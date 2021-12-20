package com.fstg.bookerorderservice.infra.impl;

import com.fstg.bookerorderservice.domain.pojo.CustomerOrder;
import com.fstg.bookerorderservice.domain.pojo.Payment;
import com.fstg.bookerorderservice.infra.core.AbstractInfraImpl;
import com.fstg.bookerorderservice.infra.dao.CustomerOrderRepository;
import com.fstg.bookerorderservice.infra.dao.OrderItemRepository;
import com.fstg.bookerorderservice.infra.dao.OrderStatusRepository;
import com.fstg.bookerorderservice.infra.dto.PaymentDto;
import com.fstg.bookerorderservice.infra.entity.CustomerOrderEntity;
import com.fstg.bookerorderservice.infra.facade.CustomerOrderInfra;
import com.fstg.bookerorderservice.infra.mappers.CustomerOrderMapper;
import com.fstg.bookerorderservice.infra.proxy.PaymentProxy;
import com.fstg.bookerorderservice.infra.proxy.ProductProxy;
import com.fstg.bookerorderservice.infra.proxy.UserProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Component
public class CustomOrderInfraImpl extends AbstractInfraImpl implements CustomerOrderInfra {
    @Autowired
    private CustomerOrderRepository customerOrderRepository;
    @Autowired
    private CustomerOrderMapper customerOrderMapper;
    @Autowired
    private OrderItemRepository orderItemRepository;
    @Autowired
    private OrderStatusRepository orderStatusRepository;
    @Autowired
    private UserProxy userProxy;
    @Autowired
    private ProductProxy productProxy;
    
    @Autowired
    private PaymentProxy paymentProxy;

    @Override
    public CustomerOrder findByReference(String reference) {
        Optional<CustomerOrderEntity> customerOrderEntity = customerOrderRepository.findByRef(reference);
        return customerOrderEntity.isPresent() ? customerOrderMapper.entityToPojo(customerOrderEntity.get()) : new CustomerOrder();
    }

    @Override
    @Transactional
    public int deleteByReference(String reference) {
        return customerOrderRepository.deleteByRef(reference);
    }

    @Override
    public int save(CustomerOrder customerOrder) {
        CustomerOrderEntity customerOrderEntity = customerOrderMapper.pojoToEntity(customerOrder);
        orderStatusRepository.save(customerOrderEntity.getStatus());
        CustomerOrderEntity savedCustomerOrderEntity = customerOrderRepository.save(customerOrderEntity);
        customerOrderEntity.getOrderItems().forEach(orderItemEntity -> {
            orderItemEntity.setRelatedCustomerOrder(savedCustomerOrderEntity);
            orderItemRepository.save(orderItemEntity);
        });
        return 1;
    }

    @Override
    public boolean userExistsByRef(String ref) {
        return userProxy.existByRef(ref);
    }

    @Override
    public boolean productExistsByRef(String ref) {
        return productProxy.existByRef(ref);
    }

	@Override
	public int pay(Payment payment) {
		 paymentProxy.pay( new PaymentDto(payment.getId(), payment.getReference(), payment.getAmount(), payment.getOrderReference()));
		 return 1;
	}


}
