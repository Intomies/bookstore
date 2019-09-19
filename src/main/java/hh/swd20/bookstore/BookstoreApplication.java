package hh.swd20.bookstore;

import hh.swd20.bookstore.domain.Book;
import hh.swd20.bookstore.domain.BookRepository;
import hh.swd20.bookstore.domain.Category;
import hh.swd20.bookstore.domain.CategoryRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BookstoreApplication {

	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);  // uusi loggeriattribuutti
	
	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

@Bean
public CommandLineRunner carDemo(BookRepository bookRepository, CategoryRepository catRepository) { 
	return (args) -> {
		log.info("create categories");
		Category adventure = new Category("Adventure");
		catRepository.save(adventure);
		Category science = new Category("Science");
		catRepository.save(science);
		
		log.info("save a couple of books");
		bookRepository.save(new Book("Suuri Seikkailu", "Kari Kirjailija", "978-951-98548-9-2", 2016, 19.90, adventure));
		bookRepository.save(new Book("Pieni Seikkailu", "Kari Kirjailija", "978-951-98548-9-3", 2000, 29.90, adventure));	
		bookRepository.save(new Book("Uutta Tietoa", "Viisas Tietäjä", "978-951-98548-9-4", 2018, 15.95, science));
		
		log.info("fetch all books");
		for (Book book : bookRepository.findAll()) {
			log.info(book.toString());
		}

		};
	}
}
