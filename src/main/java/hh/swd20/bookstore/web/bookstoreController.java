package hh.swd20.bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import hh.swd20.bookstore.domain.Book;
import hh.swd20.bookstore.domain.BookRepository;


@Controller

public class bookstoreController {
	
	@Autowired
	BookRepository bookRepository;
	
	//Indeksisivu
	@GetMapping("/index")
	public String sayHello() {
		return "bookstoreindex";

	}
	
	//Kirjojen listaaminen
	@GetMapping("/books")
	public String getBooks(Model model) {
		List<Book> books = (List<Book>) bookRepository.findAll();
		model.addAttribute("books", books);
		return "booklist";
		
	}
	
	//Tyhjä lomake
	@GetMapping("/newbook")
	public String getEmptyBookForm(Model model) {
	model.addAttribute("book", new Book());
	return "addbookform";
	
	}
	
	//Lomakkeen tietojen vastaanotto ja tallentaminen
	@PostMapping("/newbook")
	public String saveBook(@ModelAttribute Book book) {
		bookRepository.save(book);
		return "redirect:/books";
		
	}
	
	//Kirjan poistaminen
	@GetMapping("/deletebook/{id}")
	public String deleteBook(@PathVariable("id") Long bookId, Model model) {
		bookRepository.deleteById(bookId);
		return "redirect:../books";
		
	}
	
	//Kirjan muokkaaminen
	@RequestMapping(value = "/editbook/{id}")
	public String editBook(@PathVariable("id") Long bookId, Model model) {
		model.addAttribute("book", bookRepository.findById(bookId));
		return "editbookform";
		
	}
}
