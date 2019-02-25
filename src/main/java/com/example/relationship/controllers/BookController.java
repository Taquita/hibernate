package com.example.relationship.controllers;

import com.example.relationship.domains.Book;
import com.example.relationship.dtos.BookDTO;
import com.example.relationship.dtos.BookNoIdDTO;
import com.example.relationship.services.BookService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Api(value = "BookController", description = "Book endpoints")
@RestController
@RequestMapping(value = "/book")
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @RequestMapping(method = RequestMethod.POST)
    @ApiOperation(value = "Create Book")
    public ResponseEntity<BookDTO> createBook(
            @ApiParam(value = "Book Entity", required = true)
            @RequestBody BookNoIdDTO book
    ) {
        BookDTO entity = this.bookService.create(book);
        return new ResponseEntity<BookDTO>(entity, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.PUT)
    @ApiOperation(value = "Update Book")
    public ResponseEntity<BookDTO> updateBook(
            @ApiParam(value = "Book Entity", required = true)
            @RequestBody BookDTO book
    ) {
        BookDTO entity = this.bookService.update(book);
        return new ResponseEntity<BookDTO>(entity, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ApiOperation(value = "Remove Book")
    public void removeBook(
            @ApiParam(value = "Book ID", required = true)
            @PathVariable Long id) {
        this.bookService.remove(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ApiOperation(value = "Get Book by ID")
    public BookDTO getBook(
            @ApiParam(value = "Book ID", required = true)
            @PathVariable Long id) {
        return this.bookService.getOne(id);
    }

    @RequestMapping(method = RequestMethod.GET)
    @ApiOperation(value = "Get Book with pagination")
    public Page<BookDTO> pageBook(
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "count", defaultValue = "10") int count,
            @RequestParam(value = "direction", defaultValue = "ASC") Sort.Direction direction,
            @RequestParam(value = "property", defaultValue = "id") String property
    ) {
        return this.bookService.pagine(page, count, direction, property);
    }

}
