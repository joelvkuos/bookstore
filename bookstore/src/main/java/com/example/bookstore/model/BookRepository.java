package com.example.bookstore.model;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {

    void deleteAllById(Long id);

    List<Book> findByAuthor(String author);

}
