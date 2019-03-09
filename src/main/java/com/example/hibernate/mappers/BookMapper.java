package com.example.hibernate.mappers;

import com.example.hibernate.models.book.Book;
import com.example.hibernate.models.book.BookDTO;
import com.example.hibernate.models.book.BookNoIdDTO;
import com.example.hibernate.models.category.CategoryDTO;
import org.modelmapper.ModelMapper;

public class BookMapper {

    public static ModelMapper convert(ModelMapper mapper) {
        if (mapper.getTypeMap(BookNoIdDTO.class, Book.class) == null)
            mapper.createTypeMap(BookNoIdDTO.class, Book.class)
                    .addMappings(propertyMap -> propertyMap.skip(Book::setId));
        if (mapper.getTypeMap(Book.class, BookDTO.class) == null)
            mapper.createTypeMap(Book.class, BookDTO.class)
                    .addMappings(propertyMap -> propertyMap.map(Book::getCategory, (dest, val) -> {
                        dest.setCategory((CategoryDTO) val);
                    }));
        return mapper;
    }

}
