package com.fstg.bookerorderservice.infra.mappers;

import com.fstg.bookerorderservice.application.dto.OrderItemDto;
import com.fstg.bookerorderservice.domain.pojo.OrderItem;
import com.fstg.bookerorderservice.infra.entity.OrderItemEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface OrderItemMapper {
    OrderItemMapper Instance = Mappers.getMapper(OrderItemMapper.class);

    OrderItemEntity pojoToEntity(OrderItem orderItem);

    OrderItem entityToPojo(OrderItemEntity orderItemEntity);

    OrderItemDto pojoToDto(OrderItem orderItem);

    OrderItem dtoToPojo(OrderItemDto orderItemDto);
}
