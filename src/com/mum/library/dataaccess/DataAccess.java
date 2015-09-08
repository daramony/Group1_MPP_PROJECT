package com.mum.library.dataaccess;

import com.mum.library.business.LibraryMember;

public interface DataAccess {
	public void saveLibraryMember(String name, LibraryMember member);
	public LibraryMember readLibraryMember(String name);
}
