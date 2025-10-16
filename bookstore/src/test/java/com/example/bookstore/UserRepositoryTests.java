package com.example.bookstore;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.bookstore.model.User;
import com.example.bookstore.model.UserRepository;

@SpringBootTest
public class UserRepositoryTests {

    @Autowired
    private UserRepository repository;

    @Test
    public void findUserByName() {
        User jolle = new User(null, "hashedpass", "jolle@email.com", "USER", "Jolle");
        repository.save(jolle);

        List<User> users = repository.findByUsername("Jolle");

        assertEquals("Jolle", users.get(0).getUsername());
    }

    @Test
    public void createNewUser() {
        User jolle = new User(null, "Jolle123", "jolle@email.com", "USER", "Jolle");
        User saved = repository.save(jolle);

        assertNotNull(saved.getId());
        assertEquals("Jolle", saved.getUsername());
    }

    @Test
    public void deleteUser() {
        User newUser = new User(null, "Jolle123", "jolle@email.com", "USER", "Jolle");
        User saved = repository.save(newUser);

        repository.delete(saved);

        List<User> users = repository.findByUsername("Jolle");
        assertTrue(users.isEmpty());
    }

}
