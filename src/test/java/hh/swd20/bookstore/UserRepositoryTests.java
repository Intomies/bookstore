package hh.swd20.bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import hh.swd20.bookstore.domain.User;
import hh.swd20.bookstore.domain.UserRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryTests {
	
	@Autowired
	private UserRepository repository;
	
	@Test
	public void findByUsernameWithListShouldReturnUser() {	
		List<User> allUsers = (List<User>) repository.findAll();
		assertThat(repository.findByUsername(allUsers.get(0).getUsername())).isNotNull();
	}
	
	@Test
	public void createUserTest() {
		User user = new User("testuser", "testuser@testuseremail.com", "testpassword", "USER");
		repository.save(user);
		
		assertThat(user).hasNoNullFieldsOrProperties();
		assertThat(repository.findById(user.getId())).isNotNull();
	}
	
	@Test
	public void deleteUserTest() {
		User user = new User("testuser", "testuser@testuseremail.com", "testpassword", "USER");
		repository.save(user);
		assertThat(repository.findById(user.getId())).isNotNull();
		repository.deleteById(user.getId());
		assertThat(repository.findById(user.getId())).isEmpty();
	}

}
