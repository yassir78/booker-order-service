package com.fstg.bookerorderservice.infra.mappers;

import com.fstg.bookerorderservice.application.dto.OrderItemDto;
import com.fstg.bookerorderservice.application.dto.OrderStatusDto;
import com.fstg.bookerorderservice.domain.pojo.OrderItem;
import com.fstg.bookerorderservice.domain.pojo.OrderStatus;
import com.fstg.bookerorderservice.infra.entity.OrderItemEntity;
import com.fstg.bookerorderservice.infra.entity.OrderStatusEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface OrderStatusMapper {
    OrderStatusMapper Instance = Mappers.getMapper(OrderStatusMapper.class);

    OrderStatusEntity pojoToEntity(OrderStatus orderStatus);

    OrderStatus entityToPojo(OrderStatusEntity orderStatusEntity);

    OrderStatusDto pojoToDto(OrderStatus orderStatus);

    OrderStatus dtoToPojo(OrderStatusDto orderStatusDto);
}