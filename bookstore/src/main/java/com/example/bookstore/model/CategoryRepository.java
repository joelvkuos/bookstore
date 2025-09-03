package com.example.bookstore.model;

import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Book, Long> {

    void deleteAllById(Long id);

}