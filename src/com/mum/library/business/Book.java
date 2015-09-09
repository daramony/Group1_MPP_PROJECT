package com.mum.library.business;

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
		this.authors=authors;
	}
		
		public void isAvailable(boolean b) {
			available = b;
		}
		@Override
		public String toString() {
			return "id: " + id + ", isbn: " + isbn + ", available: " + available;
		}
}
