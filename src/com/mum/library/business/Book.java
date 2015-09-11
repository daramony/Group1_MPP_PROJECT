package com.mum.library.business;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class Book extends Publication implements Serializable {
	private String isbn;
	private boolean available;
	private List<Author> authors;
	private List<LendableCopy> copies = new ArrayList<LendableCopy>();
	private String copiesNumString;
	private int maxLendDaysAllowed;
	private int noOfCopies;
	
	
//	public Book(String isbn, String title,List<Author> authors,int copyNum) {
//		super(title);
//		this.isbn=isbn;
//		this.authors=authors;
//		
//		for(int i=0; i<copyNum; i++) {
//			addCopy();
//		}
//		
//	}
	
	public Book(String isbn, String title, int maxLendDaysAllowed, int noOfcopies, List<Author> authors) {
		super(title);
		this.isbn = isbn;
		this.maxLendDaysAllowed = maxLendDaysAllowed;
		this.authors = authors;
		this.noOfCopies = noOfcopies;
		for (int i = 0; i < noOfCopies; i++) {
			addCopy();
		}

	}

	
	public String getCopiesNumString() {
		return getCopiesString();
	}

	public void setCopiesNumString(String copiesNumString) {
		this.copiesNumString = copiesNumString;
	}

	public List<LendableCopy> getCopies() {
		return copies;
	}

	public void setCopies(List<LendableCopy> copies) {
		this.copies = copies;
	}
	
	public String getCopiesString() {
		
		StringBuilder sb = new StringBuilder();
		sb.append("");
		sb.append(this.copies.size());
		String strI = sb.toString();
		
		return strI;
	}


	
	public void addCopy() {
		LendableCopy copy = new LendableCopy(this, this.copies.size()+1);
		copies.add(copy);
	}

	public void removeCopy() {
		LendableCopy copy = new LendableCopy(this, this.copies.size()-1);
		copies.remove(copies.size()-1);
	}
	public int getCopysize() {
		return copies.size();
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
		
		
	


	

	

		public int getMaxLendDaysAllowed() {
			return maxLendDaysAllowed;
		}

		public void setMaxLendDaysAllowed(int maxLendDaysAllowed) {
			this.maxLendDaysAllowed = maxLendDaysAllowed;
		}

	



		
}
