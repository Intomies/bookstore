package hh.swd20.bookstore.domain;

public class Book {
	
	private String title;
	private String author;
	private String isbn;
	private int year;
	private double price;
	
	public Book() {
		super();
		this.title = null;
		this.author = null;
		this.isbn = null;
		this.year = 0;
		this.price = 0;
	}
	
	public Book(String title, String author, String isbn, int year, double price) {
		super();
		this.title = title;
		this.author = author;
		this.isbn = isbn;
		this.year = year;
		this.price = price;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getTitle() {
		return title;
	}

	public String getAuthor() {
		return author;
	}

	public String getIsbn() {
		return isbn;
	}

	public int getYear() {
		return year;
	}

	public double getPrice() {
		return price;
	}

	@Override
	public String toString() {
		return "Book [title=" + title + ", author=" + author + ", isbn=" + isbn + ", year=" + year + ", price=" + price
				+ "]";
	}
	

	
}
