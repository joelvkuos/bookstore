package com.example.bookstore;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.bookstore.model.BookRepository;
import com.example.bookstore.model.Category;
import com.example.bookstore.model.CategoryRepository;

@SpringBootTest
public class CategoryRepositoryTest {

    @Autowired
    private CategoryRepository repository;

    @Test
    public void findByCategoryName() {
        Category fiction = new Category(null, "Fiction", null);
        repository.save(fiction);

        List<Category> categories = repository.findByName("Fiction");

        assertFalse(categories.isEmpty());
        assertEquals("Fiction", categories.get(0).getName());
    }

    @Test
    public void createNewCategory() {
        Category war = new Category(null, "War", null);
        Category saved = repository.save(war);

        assertNotNull(saved.getId());
        assertEquals("War", saved.getName());
    }

    @Test
    public void deleteCategory() {
        Category newCategory = new Category(null, "war", null);
        Category saved = repository.save(newCategory);

        repository.delete(saved);

        List<Category> categories = repository.findByName("war");
        assertTrue(categories.isEmpty());
    }
}
