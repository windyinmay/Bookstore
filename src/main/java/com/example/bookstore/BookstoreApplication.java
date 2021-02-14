package com.example.bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.bookstore.domain.Book;
import com.example.bookstore.domain.Category;
import com.example.bookstore.repository.BookRepository;
import com.example.bookstore.repository.CategoryRepository;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner initBooks(BookRepository repository) {
		return (args) -> {
			repository.save(new Book(
				"Ao Hoa",
				"Pham Duy",
				2002,
				"AOHOA",
				4.5
			));
			
			repository.save(new Book(
				"Hom nay em mac ao huong",
				"Quang Le",
				2005,
				"THIEN DUONG",
				5.3
			));
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
