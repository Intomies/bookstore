package hh.swd20.bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Optional;

import hh.swd20.bookstore.domain.Book;
import hh.swd20.bookstore.domain.BookRepository;
import hh.swd20.bookstore.domain.CategoryRepository;


@Controller
public class bookstoreController {
	
	@Autowired
	BookRepository bookRepository;
	
	@Autowired
	private CategoryRepository catrepository;
	
    @RequestMapping(value="/login")
    public String login() {	
        return "login";
    }
    
	//Indeksisivu
	@GetMapping("/")
	public String sayFirstHello() {
		return "bookstoreindex";

	}
	
	//Indeksisivu
	@GetMapping("/index")
	public String sayHello() {
		return "bookstoreindex";

	}
	
	//Kirjojen listaaminen
	@GetMapping("/booklist")
	public String getBooks(Model model) {
		List<Book> books = (List<Book>) bookRepository.findAll();
		model.addAttribute("books", books);
		return "booklist";
		
	}
	
	//Restful get all books
	@PreAuthorize("hasAuthority('ADMIN')")
	@GetMapping("/books")
	public @ResponseBody List<Book> getBooksRest() {
		return (List<Book>) bookRepository.findAll();
	}
	
	//Restful get book by id
	@PreAuthorize("hasAuthority('ADMIN')")
	@GetMapping("books/{id}")
	public @ResponseBody Optional<Book> getBookRest(@PathVariable("id") Long bookId) {
		return bookRepository.findById(bookId);
	}
	
	//Restful save new book
	@PreAuthorize("hasAuthority('ADMIN')")
	@PostMapping("/books")
	public @ResponseBody Book saveBookRest(@RequestBody Book book) {
		return bookRepository.save(book);
	}
	
	//Tyhjä lomake
	@PreAuthorize("hasAuthority('ADMIN')")
	@GetMapping("/newbook")
	public String getEmptyBookForm(Model model) {
	model.addAttribute("book", new Book());
	model.addAttribute("categories", catrepository.findAll());
	return "addbookform";
	
	}
	
	//Lomakkeen tietojen vastaanotto ja tallentaminen
	@PreAuthorize("hasAuthority('ADMIN')")
	@PostMapping("/newbook")
	public String saveBook(@ModelAttribute Book book) {
		bookRepository.save(book);
		return "redirect:/booklist";
		
	}
	
	//Kirjan poistaminen
	@PreAuthorize("hasAuthority('ADMIN')")
	@GetMapping("/deletebook/{id}")
	public String deleteBook(@PathVariable("id") Long bookId, Model model) {
		bookRepository.deleteById(bookId);
		return "redirect:../booklist";
		
	}
	
	//Kirjan muokkaaminen
	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value="/editbook/{id}")
	public String editBook(@PathVariable("id") Long bookId, Model model) {
		model.addAttribute("book", bookRepository.findById(bookId));
		model.addAttribute("categories", catrepository.findAll());
		return "editbookform";
		
	}
}
