package com.api.library.controller;


import com.api.library.model.Book;
import com.api.library.service.BookService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Library APIs", description = "Manage library books")
@RestController
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService){
        this.bookService = bookService;
    }

    @Operation(summary = "Add a new book")
    @PostMapping
    public Book addBook(@RequestBody Book book){
        return bookService.addBook(book);
    }

    @GetMapping("/{id}")
    public Book getBook(@PathVariable int id){
        return bookService.getBookById(id);
    }

    @GetMapping("/search")
    public List<Book> getBooksByYear(@RequestParam(required = false) Integer year) {
        if (year == null) return List.of();
        return bookService.getBooksByYear(year);
    }


    @DeleteMapping("/{id}")
    public String deleteBook(@PathVariable int id)
    {
        bookService.deleteBook(id);
        return "Book deleted successfully. ";
    }



}
