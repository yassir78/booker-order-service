package com.fstg.bookerorderservice.infra.mappers;

import com.fstg.bookerorderservice.application.dto.CustomerOrderDto;
import com.fstg.bookerorderservice.domain.customerOrder.create.CustomerOrderCreateInput;
import com.fstg.bookerorderservice.domain.pojo.CustomerOrder;
import com.fstg.bookerorderservice.infra.entity.CustomerOrderEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CustomerOrderMapper {
    CustomerOrderMapper Instance = Mappers.getMapper(CustomerOrderMapper.class);

    CustomerOrderEntity pojoToEntity(CustomerOrder customerOrder);

    CustomerOrder entityToPojo(CustomerOrderEntity customerOrderEntity);

    @Mapping(source = "customerOrderDto.sellerRef", target = "ref")
    @Mapping(source = "customerOrderDto", target = "customerOrder")
    CustomerOrderCreateInput dtoToCreateInput(CustomerOrderDto customerOrderDto);

    @Mapping(source = "customerOrder.orderItems", target = "orderItemDtos")
    CustomerOrderDto pojoToDto(CustomerOrder customerOrder);

    @InheritInverseConfiguration
    CustomerOrder dtoToPojo(CustomerOrderDto customerOrderDto);
}
