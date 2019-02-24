package com.example.relationship.mappers;

import com.example.relationship.domains.Book;
import com.example.relationship.domains.Category;
import com.example.relationship.dtos.BookNoIdDTO;
import org.modelmapper.ModelMapper;

public class BookMapper {

    public static ModelMapper convert(ModelMapper mapper) {
        mapper.createTypeMap(BookNoIdDTO.class, Book.class)
                .addMappings(propertyMap -> {
                    propertyMap.skip(Book::setId);
                    propertyMap.map(BookNoIdDTO::getCategory, (dest, value) -> {
                        dest.setCategory(mapper.map(value, Category.class));
                    });
                });
        return mapper;
    }

}
