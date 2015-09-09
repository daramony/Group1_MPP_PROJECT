package com.mum.library.dataaccess;

import java.util.HashMap;

import com.mum.library.business.Book;
import com.mum.library.business.LibraryMember;
import com.mum.library.business.User;



public interface DataAccess {
	
	public void saveLibraryMember(LibraryMember member);
	public LibraryMember readLibraryMember(String memberId);
	
	public void saveSystemUser(User user);
	public User readSystemUser(String userId);
	
	public void saveBook(Book book);
	public Book readBook(String userIsbn);
	
     //read methods
		public HashMap<String, Book> readBooksMap();
		public HashMap<String, User> readUserMap();
		public HashMap<String, LibraryMember> readMemberMap();
}
