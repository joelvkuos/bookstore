package com.example.bookstore;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Locale.Category;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.bookstore.model.Book;
import com.example.bookstore.model.BookRepository;

@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)

@SpringBootTest
class BookRepositoryTest {

    @Autowired
    private BookRepository repository;

    @Test
    void findByBookAuthor() {
        Book book = new Book("The Stranger", "Albert Camus", 1942, "978-0141182506", 12.99, null);
        repository.save(book);

        List<Book> books = repository.findByAuthor("Albert Camus");

        assertFalse(books.isEmpty());
        assertEquals("Albert Camus", books.get(0).getAuthor());
        assertEquals("The Stranger", books.get(0).getTitle());
    }

    @Test
    void createNewBook() {
        Book book = new Book("The Visitor", "Leonard Marchand", 2025, "978-1234567890", 14.99, null);
        Book saved = repository.save(book);

        assertNotNull(saved.getId());
        assertEquals("The Visitor", saved.getTitle());
    }

    @Test
    void deleteBook() {
        Book book = new Book("The Plague", "Albert Camus", 1947, "978-0141185132", 15.99, null);
        Book saved = repository.save(book);

        repository.delete(saved);

        List<Book> books = repository.findByAuthor("Albert Camus");
        assertTrue(books.stream().noneMatch(b -> b.getTitle().equals("The Plague")));
    }
}