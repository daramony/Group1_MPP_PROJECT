//package com.mum.library.model;
//
//import java.io.Serializable;
//import java.util.List;
//
//public class Book extends Publication implements Serializable {
//	private String isbn;
//	private int maxLendDaysAllowed;
//	private boolean available;
//	private List<Author> authors;
//
//	public Book(String isbn, String title, int maxLendDaysAllowed, List<Author> authors) {
//		super(title);
//		this.isbn = isbn;
//		this.maxLendDaysAllowed = maxLendDaysAllowed;
//		this.authors = authors;
//	}
//
//	public void isAvailable(boolean b) {
//		available = b;
//	}
//
//	public String getIsbn() {
//		return isbn;
//	}
//
//	public void setIsbn(String isbn) {
//		this.isbn = isbn;
//	}
//
//	public int getMaxLendDaysAllowed() {
//		return maxLendDaysAllowed;
//	}
//
//	public void setMaxLendDaysAllowed(int maxLendDaysAllowed) {
//		this.maxLendDaysAllowed = maxLendDaysAllowed;
//	}
//
//	public void setAvailable(boolean available) {
//		this.available = available;
//	}
//
//	public List<Author> getAuthors() {
//		return authors;
//	}
//
//	public void setAuthors(List<Author> authors) {
//		this.authors = authors;
//	}
//	
//
//}
