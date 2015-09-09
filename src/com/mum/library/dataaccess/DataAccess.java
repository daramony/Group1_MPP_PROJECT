package com.mum.library.dataaccess;

import java.util.HashMap;

import com.mum.library.business.Book;
import com.mum.library.business.LibraryMember;
import com.mum.library.business.User;



public interface DataAccess {
<<<<<<< HEAD
	public void saveLibraryMember(LibraryMember member);
	public LibraryMember readLibraryMember(String memberId);
	
     //read methods
		public HashMap<String, Book> readBooksMap();
		public HashMap<String, User> readUserMap();
		public HashMap<String, LibraryMember> readMemberMap();
=======
	public void saveLibraryMember(String name, LibraryMember member);
	public LibraryMember readLibraryMember(String name);
	
	public void saveData(String name, Object object);
	public Object readData(String name);
	
>>>>>>> origin/master
}
