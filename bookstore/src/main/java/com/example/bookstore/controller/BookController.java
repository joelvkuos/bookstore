package com.example.bookstore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.bookstore.model.Book;

@RestController
public class BookController {

    @GetMapping(value = "/index")
    public Book getBook(Model model) {
        return new Book("Sivullinen", "Albert Camus", 1942, "101010-2020202", 20.00);
    }

}
