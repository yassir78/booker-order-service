package com.fstg.bookerorderservice.infra.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.fstg.bookerorderservice.domain.core.Result;
import com.fstg.bookerorderservice.infra.dto.PaymentDto;


@FeignClient(name = "PAYMENT-SERVICE")
public interface PaymentProxy {
	    @PostMapping("/api/v1/payment/")
	    public boolean pay(@RequestBody PaymentDto paymentDto);
}
	      