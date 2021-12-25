package com.fstg.bookerorderservice.infra.impl;

import com.fstg.bookerorderservice.domain.pojo.CustomerOrder;
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

import java.math.BigDecimal;

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
        CustomerOrderEntity customerOrderEntity = customerOrderRepository.findByRef(reference);
        if (customerOrderEntity != null) {
            return customerOrderMapper.entityToPojo(customerOrderEntity);
        } else {
            return new CustomerOrder();
        }
    }

    @Override
    @Transactional
    public int deleteByReference(String reference) {
        return customerOrderRepository.deleteByRef(reference);
    }

    @Override
    public void update(CustomerOrder customerOrder) {
        this.save(customerOrder);
    }

    @Override
    public void save(CustomerOrder customerOrder) {
        CustomerOrderEntity customerOrderEntity = customerOrderMapper.pojoToEntity(customerOrder);
        orderStatusRepository.save(customerOrderEntity.getStatus());
        CustomerOrderEntity savedCustomerOrderEntity = customerOrderRepository.save(customerOrderEntity);
        customerOrderEntity.getOrderItems().forEach(orderItemEntity -> {
            orderItemEntity.setRelatedCustomerOrder(savedCustomerOrderEntity);
            orderItemRepository.save(orderItemEntity);
        });
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
    public void pay(String ref, BigDecimal amount, String customerOrderRef) {
        PaymentDto paymentDto = new PaymentDto(ref, amount, customerOrderRef);
        paymentProxy.pay(paymentDto);
    }


}
