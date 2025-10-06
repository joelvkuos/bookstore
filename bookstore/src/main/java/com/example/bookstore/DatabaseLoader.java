package com.example.bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.bookstore.model.User;
import com.example.bookstore.model.UserRepository;

@Configuration
public class DatabaseLoader {

    @Bean
    CommandLineRunner loadUsers(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        return args -> {
            if (userRepository.findByUsername("admin") == null) {
                User admin = new User();
                admin.setUsername("admin");
                admin.setPasswordHash(passwordEncoder.encode("admin"));
                admin.setRole("ROLE_ADMIN");
                admin.setEmail("admin@example.com");
                userRepository.save(admin);
            }

            if (userRepository.findByUsername("user") == null) {
                User user = new User();
                user.setUsername("user");
                user.setPasswordHash(passwordEncoder.encode("user"));
                user.setRole("ROLE_USER");
                user.setEmail("user@example.com");
                userRepository.save(user);
            }
        };
    }
}
