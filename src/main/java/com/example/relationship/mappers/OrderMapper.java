package com.example.relationship.mappers;

import com.example.relationship.domains.Order;
import com.example.relationship.dtos.OrderNoIdDTO;
import org.modelmapper.ModelMapper;

public class OrderMapper {

    public static ModelMapper convert(ModelMapper mapper) {
        if (mapper.getTypeMap(OrderNoIdDTO.class, Order.class) == null)
            mapper.createTypeMap(OrderNoIdDTO.class, Order.class)
                    .addMappings(propertyMap -> {
                        propertyMap.skip(Order::setId);
                        propertyMap.map(OrderNoIdDTO::getProducts, Order::setProducts);
                    });
        return mapper;
    }

}
