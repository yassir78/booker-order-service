package com.fstg.bookerorderservice.application.ws;

import com.fstg.bookerorderservice.application.dto.CustomerOrderDto;
import com.fstg.bookerorderservice.domain.core.Result;
import com.fstg.bookerorderservice.domain.customerOrder.create.CustomerOrderCreateProcess;
import com.fstg.bookerorderservice.domain.pojo.CustomerOrder;
import com.fstg.bookerorderservice.infra.facade.CustomerOrderInfra;
import com.fstg.bookerorderservice.infra.mappers.CustomerOrderMapper;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequestMapping("/api/v1/customerOrder")
@Api("Cette classe permet de tester les process de la commande")
public class CustomerOrderRest {
    @Autowired
    private CustomerOrderCreateProcess customerOrderCreateProcess;
    @Autowired
    private CustomerOrderMapper customerOrderMapper;
    @Autowired
    private CustomerOrderInfra customerOrderInfra;

    @RequestMapping("/")
    public ResponseEntity<Result> create(@RequestBody CustomerOrderDto customerOrderDto) {
        System.out.println(customerOrderDto.getOrderDate());
        System.out.println("éééééééééééééééééééééé");
        System.out.println(customerOrderDto.toString());
        System.out.println(customerOrderMapper.dtoToCreateInput(customerOrderDto).getCustomerOrder().toString());
        System.out.println("éééééééééééééééééééééé");
        Result result = customerOrderCreateProcess.execute(customerOrderMapper.dtoToCreateInput(customerOrderDto));
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }
  
    @GetMapping("/test/{name}")
    public boolean test(@PathVariable String name) {
        return Objects.equals(name, "hiba");
    }
	@GetMapping("/ref/{ref}")
	public CustomerOrder findByReference( @PathVariable String reference) {
		System.out.println("**************REFE: "+reference);
		return customerOrderInfra.findByReference(reference);
		
	}
	
}