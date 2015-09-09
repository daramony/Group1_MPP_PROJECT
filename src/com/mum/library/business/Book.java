package com.mum.library.business;

import java.io.Serializable;
import java.util.List;

public class Book extends Publication implements Serializable {
	private String isbn;
	private boolean available;
	private List<Author> authors;
	
	public Book(String isbn, String title,List<Author> authors) {
		super(title);
		this.isbn=isbn;
		this.authors=authors;
	}
	
	


	public String getIsbn() {
		return isbn;
	}



	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}



	public boolean isAvailable() {
		return available;
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



		public void isAvailable(boolean b) {
			available = b;
		}
		
		@Override
		public String toString() {
			
			return "Title:"+this.getTitle()+", ISBN:"+this.getIsbn();
		}
		
}
