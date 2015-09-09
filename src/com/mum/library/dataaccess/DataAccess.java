package com.mum.library.dataaccess;

import com.mum.library.business.LibraryMember;

public interface DataAccess {
	public void saveLibraryMember(String name, LibraryMember member);
	public LibraryMember readLibraryMember(String name);
	
	public void saveData(String name, Object object);
	public Object readData(String name);
	
}
