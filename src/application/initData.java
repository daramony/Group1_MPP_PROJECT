package application;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;




import java.util.ArrayList;
import java.util.List;

import com.mum.library.business.Address;
import com.mum.library.business.Auth;
import com.mum.library.business.Author;
import com.mum.library.business.Book;
import com.mum.library.business.LendableCopy;
import com.mum.library.business.LibraryMember;
import com.mum.library.business.Publication;
import com.mum.library.business.User;
import com.mum.library.dataaccess.DataAccess;
import com.mum.library.dataaccess.DataAccessFacade;




public class initData {
	
	public static void main(String[] args) {
		
		List<Address> addresses = new ArrayList<Address>() {
			{
				add(new Address("101 S. Main", "Fairfield", "IA", "52556"));
				add(new Address("51 S. George", "Georgetown", "MI", "65434"));
				add(new Address("23 Headley Ave", "Seville", "Georgia", "41234"));
				add(new Address("1 N. Baton", "Baton Rouge", "LA", "33556"));
				add(new Address("5001 Venice Dr.", "Los Angeles", "CA", "93736"));
				add(new Address("1435 Channing Ave", "Palo Alto", "CA", "94301"));
				add(new Address("42 Dogwood Dr.", "Fairfield", "IA", "52556"));
				add(new Address("501 Central", "Mountain View", "CA", "94707"));
			}
		};
		
		List<Author> allAuthors = new ArrayList<Author>() {
			{
				add(new Author("Joe", "Thomas", "641-445-2123", addresses.get(0), "A happy man is he."));
				add(new Author("Sandra", "Thomas", "641-445-2123", addresses.get(0), "A happy wife is she."));
				add(new Author("Nirmal", "Pugh", "641-919-3223", addresses.get(1), "Thinker of thoughts."));
				add(new Author("Andrew", "Cleveland", "976-445-2232", addresses.get(2), "Author of childrens' books."));
				add(new Author("Sarah", "Connor", "123-422-2663", addresses.get(3), "Known for her clever style."));
			}
		};
			
		//add LibraryMembers
		LibraryMember member1 = new LibraryMember("John", "Pugh", "641-445-2123", addresses.get(0),"1");
		LibraryMember member2 = new LibraryMember("Sandra", "Cleveland", "976-445-2232", addresses.get(1),"2");
		LibraryMember member3 = new LibraryMember("Nirmal", "Thomas", "123-422-2663", addresses.get(2),"3");
		
		//add books
		List<Author> aAuthors = new ArrayList<Author>();
		aAuthors.add(allAuthors.get(0));
		aAuthors.add(allAuthors.get(1));
		Publication p1 = new Book("123","Gone with the Wind",aAuthors);
		Publication p2 = new Book("456","Headley",aAuthors);
		Publication p3 = new Book("789","Central",aAuthors);
		
		//add users
		User user1=new User("101", "xyz", Auth.LIBRARIAN);
		User user2=new User("102", "abc", Auth.ADMIN);
		User user3=new User("103", "111", Auth.BOTH);
				
		
		LendableCopy c1 = new LendableCopy();
		c1.setPublication(p1);
		c1.setCopyId(1);
		
		LendableCopy c2 = new LendableCopy();
		c2.setPublication(p2);
		c2.setCopyId(1);
		
		LendableCopy c3 = new LendableCopy();
		c3.setPublication(p3);
		c3.setCopyId(1);
		
		member1.checkout(c1, LocalDate.now(), LocalDate.now().plus(30, ChronoUnit.DAYS));
		member2.checkout(c2, LocalDate.now(), LocalDate.now().plus(14, ChronoUnit.DAYS));
		member3.checkout(c3, LocalDate.now(), LocalDate.now().plus(30, ChronoUnit.DAYS));
		
		//System.out.println("Location of 'user.dir':\n  "+DataAccessFacade.OUTPUT_DIR);
		
		DataAccess da = new DataAccessFacade();
		da.saveLibraryMember(member1);
		da.saveLibraryMember(member2);
		da.saveLibraryMember(member3);
		da.saveBook((Book)p1);
		da.saveBook((Book)p2);
		da.saveBook((Book)p3);
		da.saveSystemUser(user1);
		da.saveSystemUser(user2);
		da.saveSystemUser(user3);
		
		System.out.println("Reading record forLibraryMembers:");
		System.out.println(da.readLibraryMember("1"));
		System.out.println(da.readLibraryMember("2"));
		System.out.println(da.readLibraryMember("3"));
		System.out.println("****************************************");

		System.out.println("Reading record forBooks:");
		System.out.println(da.readBook("123"));
		System.out.println(da.readBook("456"));
		System.out.println(da.readBook("789"));
		System.out.println("****************************************");
				
		System.out.println("Reading record forUsers:");
		System.out.println(da.readSystemUser("101"));
		System.out.println(da.readSystemUser("102"));
		System.out.println(da.readSystemUser("103"));
		System.out.println("****************************************");
	}
	

}
