package com.mum.library.business;

import java.io.Serializable;

public class LendableCopy implements Serializable {
	private Publication publication;
	private int copyId; 
	
	public LendableCopy(Publication p, int copyId) {
		this.publication = p;
		this.copyId = copyId;
	}
	
	public void setPublication(Publication publication) {
		this.publication = publication;
	}
	public void setCopyId(int copyId) {
		this.copyId = copyId;
	}
	
	public int getCopyId() {
		return this.copyId;
	}
	
	public String toString() {
		return publication.toString();
	}
	
}
