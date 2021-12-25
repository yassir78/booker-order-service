package com.fstg.bookerorderservice.application.ws;

import com.fstg.bookerorderservice.application.dto.CustomerOrderDto;
import com.fstg.bookerorderservice.domain.core.Result;
import com.fstg.bookerorderservice.domain.customerOrder.create.CustomerOrderCreateProcess;
import com.fstg.bookerorderservice.domain.customerOrder.update.CustomerOrderUpdateProcess;
import com.fstg.bookerorderservice.domain.pojo.CustomerOrder;
import com.fstg.bookerorderservice.infra.facade.CustomerOrderInfra;
import com.fstg.bookerorderservice.infra.mappers.CustomerOrderMapper;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequestMapping("/api/v1/customerOrder")
@Api("Cette classe permet de tester les process de la commande")
@RequiredArgsConstructor
public class CustomerOrderRest {
    private final CustomerOrderCreateProcess customerOrderCreateProcess;
    private final CustomerOrderUpdateProcess customerOrderUpdateProcess;
    private final CustomerOrderMapper customerOrderMapper;
    private final CustomerOrderInfra customerOrderInfra;

    @PostMapping("/")
    public ResponseEntity<Result> create(@RequestBody CustomerOrderDto customerOrderDto) {
        System.out.println("**************REst Dto Display: " + customerOrderDto.toString());
        Result result = customerOrderCreateProcess.execute(customerOrderMapper.dtoToCreateInput(customerOrderDto));
        System.out.println("**************CreateInput: " + customerOrderMapper.dtoToCreateInput(customerOrderDto));
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @PutMapping("/")
    public ResponseEntity<Result> update(@RequestBody CustomerOrderDto customerOrderDto) {
        System.out.println("Update method: " + customerOrderDto.toString());
        Result result = customerOrderUpdateProcess.execute(customerOrderMapper.dtoToUpdateInput(customerOrderDto));
        System.out.println(customerOrderMapper.dtoToUpdateInput(customerOrderDto));
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/test/{name}")
    public boolean test(@PathVariable String name) {
        return Objects.equals(name, "hiba");
    }

    @GetMapping("/ref/{ref}")
    public CustomerOrder findByReference(@PathVariable String ref) {
        System.out.println("**************find By reference rest: " + ref);
        CustomerOrder customerOrder = customerOrderInfra.findByReference(ref);
        System.out.println("**************find By reference rest: re" + customerOrder);
        return customerOrder;
    }

}