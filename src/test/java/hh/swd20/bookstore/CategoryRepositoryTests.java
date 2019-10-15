package hh.swd20.bookstore;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import hh.swd20.bookstore.domain.Category;
import hh.swd20.bookstore.domain.CategoryRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CategoryRepositoryTests {

	@Autowired
	private CategoryRepository repository;
	
	@Test
	public void findByNameReturnsCategoryTest() {
		List<Category> categories = (List<Category>) repository.findAll();
		assertThat(repository.findByName(categories.get(0).getName())).isNotNull();
	}
	
	@Test
	public void createCategoryTest() {
		Category category = new Category("TestCat");
		repository.save(category);
		assertThat(repository.findById(category.getCategoryId())).isNotNull();
	}
	
	@Test
	public void deleteCategoryTest() {
		Category category = new Category("TestCat");
		repository.save(category);
		assertThat(repository.findById(category.getCategoryId())).isNotNull();
		repository.deleteById(category.getCategoryId());
		assertThat(repository.findById(category.getCategoryId())).isEmpty();
	}
}
