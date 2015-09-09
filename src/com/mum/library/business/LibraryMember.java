package com.mum.library.business;

import java.io.Serializable;
import java.time.LocalDate;

public class LibraryMember extends Person implements Serializable {
	


	private static final long serialVersionUID = -2226197306790714013L;
	private String memberID;
	private CheckoutRecord record = new CheckoutRecord();
	
	public LibraryMember(String firstname, String lastname, String tel, Address a,String memberId) {
		super(firstname, lastname, tel, a);
		this.memberID=memberId;
	}
	
	public void checkout(LendableCopy copy, LocalDate checkoutDate, LocalDate dueDate) {
		CheckoutRecordEntry entry = new CheckoutRecordEntry(copy, checkoutDate, dueDate);
		record.addEntry(entry);
		
	}
	
	public String toString() {
		return "Checkout record for library member " + super.getFirstName()+" "+super.getLastName() + ": " + record;
	}
	
	public String getMemberID() {
		return memberID;
	}
	
	
}
