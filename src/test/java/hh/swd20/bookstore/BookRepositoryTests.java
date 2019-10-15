package hh.swd20.bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import hh.swd20.bookstore.domain.Book;
import hh.swd20.bookstore.domain.BookRepository;
import hh.swd20.bookstore.domain.Category;

@RunWith(SpringRunner.class)
@DataJpaTest
public class BookRepositoryTests {
	@Autowired
	private BookRepository repository;

	@Test
	public void findByTitleShouldReturnBook() {
		List<Book> allBooks = (List<Book>) repository.findAll();
		List<Book> books = repository.findByTitle(allBooks.get(0).getTitle());
		assertThat(books).isNotEmpty();
	}

	@Test
	public void findByAuthorShouldReturnBook() {
		List<Book> allBooks = (List<Book>) repository.findAll();
		List<Book> books = repository.findByAuthor(allBooks.get(0).getAuthor());
		assertThat(books).isNotEmpty();
	}

	@Test
	public void createNewBookTest() {
		Category category = new Category("TestCat");
		Book book = new Book("TestTitle", "TestAuthor", "TestISBN", 15, 15.5, category);
		repository.save(book);
		assertThat(book.getId()).isNotNull();
		assertThat(!book.getAuthor().isEmpty());
		assertThat(!book.getTitle().isEmpty());
		assertThat(!book.getIsbn().isEmpty());
		assertThat(book.getYear()).isNotNull();
		assertThat(book.getPrice()).isNotNull();
		assertThat(!book.getCategory().toString().equals("TestCat"));
		assertThat(repository.findById(book.getId())).isNotNull();
	}

	@Test
	public void deleteBookTest() {
		Category category = new Category("TestCat");
		Book book = new Book("TestTitle", "TestAuthor", "TestISBN", 15, 15.5, category);
		repository.save(book);
		assertThat(repository.findById(book.getId())).isNotNull();
		repository.deleteById(book.getId());
		assertThat(repository.findById(book.getId())).isEmpty();
	}
}
