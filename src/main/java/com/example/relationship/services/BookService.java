package com.example.relationship.services;

import com.example.relationship.domains.Book;
import com.example.relationship.dtos.BookDTO;
import com.example.relationship.dtos.BookNoIdDTO;
import com.example.relationship.repositories.BookRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.List;

@Service
public class BookService extends GenericService<Book, Long> {

    private final BookRepository repository;
    private final ModelMapper mapper;

    @Autowired
    public BookService(BookRepository repository) {
        super(repository);
        this.repository = repository;
        this.mapper = new ModelMapper();
    }

    public BookDTO create(BookNoIdDTO book) {
        Book entity = mapper.map(book, Book.class);
        return mapper.map(super.create(entity), BookDTO.class);
    }

    public BookDTO update(BookDTO book) {
        Book entity = mapper.map(book, Book.class);
        return mapper.map(super.update(entity), BookDTO.class);
    }

    public BookDTO getOne(Long id) {
        return mapper.map(super.getById(id), BookDTO.class);
    }

    public Page<BookDTO> pagine(int page, int count, Sort.Direction direction, String property) {
        Type listType = new TypeToken<List<BookDTO>>() {}.getType();
        return mapper.map(super.pagination(page, count, direction, property), listType);
    }
}
