package hh.swd20.bookstore.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;



@Entity
public class Category {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long categoryId;
	private String name;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "category")
	private List<Book> books;
	
	public Category() {}
	
	public Category(String name) {
		super();
		this.name = name;		
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	public Long getCategoryId() {
		return categoryId;
	}

	public String getName() {
		return name;
	}

	public List<Book> getBooks() {
		return books;
	}

	@Override
	public String toString() {
		return "Category [categoryId=" + categoryId + ", name=" + name + "]";
	}
	
}
