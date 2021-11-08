package com.fstg.bookerorderservice.service.required;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "booker-product-service", url = "localhost")
public interface ProductServiceRequired {

	@RequestMapping("/ref/{ref}")
	public boolean findByRef(@PathVariable(name = "ref") String reference);
}
