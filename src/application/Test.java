package application;

import com.mum.library.dataaccess.DataAccess;
import com.mum.library.dataaccess.DataAccessFacade;

public class Test {

	public static void main(String[] args) {
		DataAccess da=new DataAccessFacade();
		System.out.println(da.readLibraryMember("1"));
		System.out.println(da.readLibraryMember("2"));
		System.out.println(da.readLibraryMember("3"));
		
//		System.out.println(da.readBook(userIsbn));
//		System.out.println(da.readLibraryMember("2"));
//		System.out.println(da.readLibraryMember("3"));


	}

}
