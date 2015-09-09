package com.mum.library.model;

public class Book {
	private String isbn;
	private String title;
	private int maxCheckoutLength;
	private int noOfcopies;
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
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
