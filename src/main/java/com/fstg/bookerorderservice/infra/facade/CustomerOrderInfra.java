package com.fstg.bookerorderservice.infra.facade;

import com.fstg.bookerorderservice.domain.pojo.CustomerOrder;
import com.fstg.bookerorderservice.domain.pojo.Payment;
import com.fstg.bookerorderservice.infra.core.AbstractInfra;

public interface CustomerOrderInfra extends AbstractInfra {
    CustomerOrder findByReference(String reference);

    int deleteByReference(String reference);

    int save(CustomerOrder customerOrder);

    boolean userExistsByRef(String ref);

    boolean productExistsByRef(String ref);
    
    int pay(Payment payment);
}
