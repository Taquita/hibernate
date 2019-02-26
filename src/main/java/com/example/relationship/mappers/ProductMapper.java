package com.example.relationship.mappers;

import com.example.relationship.domains.Product;
import com.example.relationship.dtos.ProductNoIdDTO;
import org.modelmapper.ModelMapper;

public class ProductMapper {

    public static ModelMapper convert(ModelMapper mapper) {
        if (mapper.getTypeMap(ProductNoIdDTO.class, Product.class) == null)
            mapper.createTypeMap(ProductNoIdDTO.class, Product.class)
                    .addMappings(propertyMap -> propertyMap.skip(Product::setId));
        return mapper;
    }

}
