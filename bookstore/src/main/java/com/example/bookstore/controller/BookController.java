package com.example.bookstore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.example.bookstore.model.Book;
import com.example.bookstore.model.BookRepository;

@Controller
public class BookController {

    private final BookRepository repository;

    // constructor injection. Can only be one constructor then.
    public BookController(BookRepository repository) {
        this.repository = repository;
    }

    @RequestMapping(value = { "/", "/booklist" })
    public String bookList(Model model) {
        model.addAttribute("books", repository.findAll());
        return "booklist";
    }

}
