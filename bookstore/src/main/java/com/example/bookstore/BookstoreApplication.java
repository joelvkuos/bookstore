package com.example.bookstore;

import com.example.bookstore.model.Book;
import com.example.bookstore.model.BookRepository;
import com.example.bookstore.model.Category;
import com.example.bookstore.model.CategoryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	CommandLineRunner initDatabase(CategoryRepository categoryRepository, BookRepository bookRepository) {
		return args -> {
			if (categoryRepository.count() == 0) {
				Category fiction = categoryRepository.save(new Category(null, "Fiction", null));
				Category science = categoryRepository.save(new Category(null, "Science", null));
				Category history = categoryRepository.save(new Category(null, "History", null));
				Category biography = categoryRepository.save(new Category(null, "Biography", null));
				Category technology = categoryRepository.save(new Category(null, "Technology", null));
				Category mystery = categoryRepository.save(new Category(null, "Mystery", null));
				Category fantasy = categoryRepository.save(new Category(null, "Fantasy", null));

				bookRepository.save(new Book("The Stranger", "Albert Camus", 1942, "978-0679720201", 13.99, fiction));

			}
		};
	}
}
