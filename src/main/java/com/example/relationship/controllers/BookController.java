package com.example.relationship.controllers;

import com.example.relationship.domains.Book;
import com.example.relationship.dtos.BookNoIdDTO;
import com.example.relationship.services.BookService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "BookController", description = "Book endpoints")
@RestController
@RequestMapping(value = "book")
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @RequestMapping(method = RequestMethod.POST)
    @ApiOperation(value = "Create Book")
    public ResponseEntity<Book> createBook(@RequestBody BookNoIdDTO book) {
        Book entity = this.bookService.create(book);
        return new ResponseEntity<Book>(entity, HttpStatus.CREATED);
    }

}
