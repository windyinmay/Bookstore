package com.example.bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.bookstore.domain.Book;
import com.example.bookstore.domain.Category;
import com.example.bookstore.domain.User;
import com.example.bookstore.repository.BookRepository;
import com.example.bookstore.repository.CategoryRepository;
import com.example.bookstore.repository.UserCrudRepository;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner initBooks(BookRepository repository) {
		return (args) -> {
			repository.save(new Book(
				"Ernest Hemingway",
				"A Farewell to Arms",
				1929,
				"1232323-21",
				11.5
			));
			
			repository.save(new Book(
				"George Orwell",
				"Animal Farm",
				1945,
				"2212343-5",
				10.3
			));
		};
	}
		
	@Bean
	public CommandLineRunner initUsers(UserCrudRepository urepository) {
		// Create users: admin/admin user/user
	return (args) -> {
		User user1 = new User("user1"
		,
		"abcd@1234", "USER","user@example.com");
		User user2 = new User("admin1"
		,
		"$2a$10$0MMwY", "ADMIN", "admin@example.com");
		urepository.save(user1);
		urepository.save(user2);
	};
}
	
	
	@Bean
	public CommandLineRunner initCategories(CategoryRepository repository) {
		return (args) -> {
			repository.save(new Category("romance"));
			repository.save(new Category("thriller"));
		};
	}
}
