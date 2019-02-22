package com.example.relationship.services;

import com.example.relationship.domains.Book;
import com.example.relationship.dtos.BookNoIdDTO;
import com.example.relationship.repositories.BookRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public Book create(BookNoIdDTO book) {
        Book entity = mapper.map(book, Book.class);
        return super.create(entity);
    }
}
