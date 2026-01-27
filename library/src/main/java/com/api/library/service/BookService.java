package com.api.library.service;


import com.api.library.model.Book;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class BookService {
    private final Map<Integer, Book> bookStore = new HashMap<>();

    public Book addBook(Book book){
        bookStore.put(book.getId(), book);
        return book;
    }
    public Book getBookById(int id){
        return bookStore.get(id);
    }
    public List<Book> getBooksByYear(int year){
        return bookStore.values()
                .stream()
                .filter(book -> book.getYear() == year)
                .collect(Collectors.toList());
    }

    public void deleteBook(int id){
        bookStore.remove(id);
    }
}
