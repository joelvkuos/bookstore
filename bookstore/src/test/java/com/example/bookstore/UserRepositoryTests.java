package com.example.bookstore;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.example.bookstore.model.User;
import com.example.bookstore.model.UserRepository;

@SpringBootTest
@Transactional
public class UserRepositoryTests {

    @Autowired
    private UserRepository repository;

    @Test
    public void findUserByName() {
        User jolle = new User(null, "hashedpass", "jolle@email.com", "USER", "Jolle");
        repository.save(jolle);

        Optional<User> users = repository.findByUsername("Jolle");

        assertEquals("Jolle", users.get().getUsername());
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

        Optional<User> users = repository.findByUsername("Jolle");
        assertTrue(users.isEmpty());
    }

}
