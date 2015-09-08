package application;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import com.mum.library.business.Book;
import com.mum.library.business.LendableCopy;
import com.mum.library.business.LibraryMember;
import com.mum.library.business.Publication;
import com.mum.library.dataaccess.DataAccess;
import com.mum.library.dataaccess.DataAccessFacade;



public class initData {
	
	public static void main(String[] args) {
		LibraryMember member = new LibraryMember("John");
		Publication p = new Book(1, "1234","Gone with the Wind");
		LendableCopy c = new LendableCopy();
		c.setPublication(p);
		c.setCopyId(1);
		member.checkout(c, LocalDate.now(), LocalDate.now().plus(30, ChronoUnit.DAYS));
		System.out.println("Location of 'user.dir':\n  "+DataAccessFacade.OUTPUT_DIR);
		DataAccess da = new DataAccessFacade();
		da.saveLibraryMember("John", member);
		System.out.println("Reading record for John:\n"+"  "+da.readLibraryMember("John"));
		

	}
	

}
