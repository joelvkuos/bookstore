package com.example.bookstore.controller;

import com.example.bookstore.model.Book;
import com.example.bookstore.model.BookRepository;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

import java.util.List;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/api")
public class BookRestController {

    private final BookRepository bookRepository;

    public BookRestController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GetMapping("/books")
    public List<Book> getAllBooks() {
        return (List<Book>) bookRepository.findAll();
    }

    @GetMapping("/books/{id}")
    public Book getBookById(@PathVariable Long id) {
        return bookRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Book not found"));
    }

    @PostMapping("/books")
    public Book createBook(@RequestBody Book book) {
        return bookRepository.save(book);
    }

    @DeleteMapping("/books/{id}")
    public void deleteBook(@PathVariable Long id) {
        bookRepository.deleteById(id);
    }

}
