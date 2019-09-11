package hh.swd20.bookstore;

import hh.swd20.bookstore.domain.Book;
import hh.swd20.bookstore.domain.BookRepository;

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
public CommandLineRunner carDemo(BookRepository bookRepository) { 
	return (args) -> {
		log.info("save a couple of books");
		bookRepository.save(new Book("Suuri Seikkailu", "Kari Kirjailija", "978-951-98548-9-2", 2016, 19.90));
		bookRepository.save(new Book("Pieni Seikkailu", "Kari Kirjailija", "978-951-98548-9-3", 2000, 29.90));	
			
		log.info("fetch all books");
		for (Book book : bookRepository.findAll()) {
			log.info(book.toString());
		}

		};
	}
}
