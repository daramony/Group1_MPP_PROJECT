package com.mum.library.business;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Book extends Publication implements Serializable {
	private String isbn;
	private int maxLendDaysAllowed;
	private int noOfCopies;
	private boolean available;
	private List<Author> authors;
	private List<LendableCopy> copies;

	public Book(String isbn, String title, int maxLendDaysAllowed, int noOfcopies, List<Author> authors) {
		super(title);
		this.isbn = isbn;
		this.maxLendDaysAllowed = maxLendDaysAllowed;
		this.authors = authors;
		this.noOfCopies = noOfcopies;
		copies = new ArrayList<>();
		for (int i = 0; i < noOfCopies; i++) {
			addCopy();
		}

	}
	public void addCopy() {
		LendableCopy copy = new LendableCopy(this, this.copies.size()+1);
		copies.add(copy);
	}

	public void isAvailable(boolean b) {
		available = b;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public int getMaxLendDaysAllowed() {
		return maxLendDaysAllowed;
	}

	public void setMaxLendDaysAllowed(int maxLendDaysAllowed) {
		this.maxLendDaysAllowed = maxLendDaysAllowed;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

	public List<Author> getAuthors() {
		return authors;
	}

	public void setAuthors(List<Author> authors) {
		this.authors = authors;
	}

}
