package com.mum.library.business;

import java.io.Serializable;

public class Person implements Serializable {
	private static final long serialVersionUID = 3665880920647848288L;
	private String firstName;
	private String lastName;
	private String phoneNo;
	private Address address;

	public Person(String firstName, String lastName, String phoneNo, Address address) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNo = phoneNo;
		this.address = address;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public Address getAddress() {
		return address;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
}
