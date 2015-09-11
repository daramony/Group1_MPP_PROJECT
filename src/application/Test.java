package application;

import com.mum.library.dataaccess.DataAccess;
import com.mum.library.dataaccess.DataAccessFacade;

public class Test {

	public static void main(String[] args) {
		DataAccess da=new DataAccessFacade();
//		System.out.println("Reading record forLibraryMembers:");
//		System.out.println(da.readLibraryMember("1"));
//		System.out.println(da.readLibraryMember("2"));
//		System.out.println(da.readLibraryMember("3"));
//		System.out.println("****************************************");
//
//		System.out.println("Reading record forBooks:");
//		System.out.println(da.readBook("123"));
//		System.out.println(da.readBook("456"));
//		System.out.println(da.readBook("789"));
//		System.out.println("****************************************");
//				
//		System.out.println("Reading record forUsers:");
//		System.out.println(da.readSystemUser("101"));
//		System.out.println(da.readSystemUser("102"));
//		System.out.println(da.readSystemUser("103"));
//		System.out.println("****************************************");
		System.out.println(da.readBook("ccc").getCopies().size());
		System.out.println(da.readLibraryMember("5"));
		System.out.println(da.readBook("ccc"));
	}

}
