package hh.swd20.bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

import hh.swd20.bookstore.domain.Book;
import hh.swd20.bookstore.domain.BookRepository;


@Controller

public class bookstoreController {
	
	@Autowired
	BookRepository bookRepository;
	
	@GetMapping("/index")
	public String sayHello() {
		return "bookstoreindex";

	}
	
	@GetMapping("/books")
	public String getBooks(Model model) {
		List<Book> books = (List<Book>) bookRepository.findAll();
		model.addAttribute("books", books);
		return "booklist";
		
	}

}
