package com.example.bookstore.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.bookstore.domain.Book;
import com.example.bookstore.repository.BookRepository;
import com.example.bookstore.repository.CategoryRepository;


@Controller
public class BookController {
	@Autowired
	private BookRepository repository;
	@Autowired
	private CategoryRepository crepository;
	
	@GetMapping("index")
	public String index() {
		return "index";
	}
	
	@GetMapping("booklist")
	public String bookList(Model model) {
		List<Book> books = repository.findAll();
		model.addAttribute("books", books);
		return "booklist";
	}
	
	@RequestMapping(value="/books", method = RequestMethod.GET)
	public @ResponseBody List<Book> bookListRest(){
		return (List<Book>)repository.findAll();
	}
	
	@RequestMapping(value="/book/{bookid}",method = RequestMethod.GET)
	public @ResponseBody Optional<Book> findBookRest(@PathVariable("bookid") Long bookId) {
		return repository.findById(bookId);
	}
	@GetMapping("addbook")
	public String addBook(Model model) {
		model.addAttribute("book", new Book());
		model.addAttribute("categories", crepository.findAll());
		return "addbook";
	}
	
	@PostMapping("save")
	public String createBook(Book book) {
		repository.save(book);
		return "redirect:booklist";
	}
	
	@GetMapping("delete/{id}")
	public String deleteBook(
		@PathVariable("id") Long bookId, 
		Model model
	) {
		repository.deleteById(bookId);
		return "redirect:../booklist";
	}
	
	@GetMapping("edit/{id}")
	public String editBook(
		@PathVariable("id") Long bookId,
		Model model
	) {
		model.addAttribute(
			"book", 
			repository.findById(bookId)
		);
		model.addAttribute(
			"categories",
			crepository.findAll()
		);
		return "editbook";
	}
	
}