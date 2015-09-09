package com.mum.library.business;

<<<<<<< HEAD
import java.io.Serializable;
import java.util.List;

public class Book extends Publication implements Serializable {
	private int id;
	private String isbn;
	private boolean available;
	private List<Author> authors;
	public Book(int id, String isbn, String title,List<Author> authors) {
		super(title);
		this.id = id;
=======
public class Book {
	private String isbn;
	private String title;
	private int maxCheckoutLength;
	private int noOfcopies;
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
>>>>>>> origin/master
		this.isbn = isbn;
		this.authors=authors;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getMaxCheckoutLength() {
		return maxCheckoutLength;
	}
	public void setMaxCheckoutLength(int maxCheckoutLength) {
		this.maxCheckoutLength = maxCheckoutLength;
	}
	public int getNoOfcopies() {
		return noOfcopies;
	}
	public void setNoOfcopies(int noOfcopies) {
		this.noOfcopies = noOfcopies;
	}
	
}
