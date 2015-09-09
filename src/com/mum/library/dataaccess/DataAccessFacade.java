package com.mum.library.dataaccess;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;








import com.mum.library.business.Book;
import com.mum.library.business.LibraryMember;
import com.mum.library.business.User;




public class DataAccessFacade implements DataAccess {
	
	
	enum StorageType {
		BOOKS, MEMBERS, USERS;
	}
	
	
	public static final String OUTPUT_DIR = System.getProperty("user.dir") 
			+ "\\src\\com\\mum\\library\\dataaccess\\storage";
	public static final String DATE_PATTERN = "MM/dd/yyyy";
	
<<<<<<< HEAD
	public static HashMap<String, Book> booksMap;
	public static HashMap<String, LibraryMember> membersMap;
	public static HashMap<String, User> usersMap;
	
   //access storage	
	static void saveToStorage(StorageType type, Object ob) {
=======
	@Override
	public void saveData(String name, Object object) {
		ObjectOutputStream out = null;
		try {
			Path path = FileSystems.getDefault().getPath(OUTPUT_DIR, name);
			out = new ObjectOutputStream(Files.newOutputStream(path));
			out.writeObject(object);
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			if(out != null) {
				try {
					out.close();
				} catch(Exception e) {}
			}
		}
		
	}
	@Override
	public Object readData(String name) {
		ObjectInputStream in = null;
		Object out = null;
		try {
			Path path = FileSystems.getDefault().getPath(OUTPUT_DIR, name);
			in = new ObjectInputStream(Files.newInputStream(path));
			out = in.readObject();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if(in != null) {
				try {
					in.close();
				} catch(Exception e) {}
			}
		}
		return out;
	}
	
	public void saveLibraryMember(String name, LibraryMember member) {
>>>>>>> origin/master
		ObjectOutputStream out = null;
		try {
			Path path = FileSystems.getDefault().getPath(OUTPUT_DIR,
					type.toString());
			out = new ObjectOutputStream(Files.newOutputStream(path));
			out.writeObject(ob);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (out != null) {
				try {
					out.close();
				} catch (Exception e) {
				}
			}
		}
	}

	static Object readFromStorage(StorageType type) {
		ObjectInputStream in = null;
		Object retVal = null;
		try {
			Path path = FileSystems.getDefault().getPath(OUTPUT_DIR,
					type.toString());
			in = new ObjectInputStream(Files.newInputStream(path));
			retVal = in.readObject();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (Exception e) {
				}
			}
		}
		return retVal;
	}

<<<<<<< HEAD
	static {
		saveToStorage(StorageType.BOOKS, new HashMap<String, Book>());
		saveToStorage(StorageType.MEMBERS, new HashMap<String, LibraryMember>());
		saveToStorage(StorageType.USERS, new HashMap<String, User>());
		DataAccess da = new DataAccessFacade();
		booksMap = da.readBooksMap();
		if (booksMap == null) {
			booksMap = new HashMap<String, Book>();
		}

		membersMap = da.readMemberMap();
		if (membersMap == null) {
			membersMap = new HashMap<String, LibraryMember>();
		}
		
		usersMap = da.readUserMap();
		if(usersMap==null) {
			usersMap = new HashMap<String, User>();
		}
	}
	
	
	//read methods that return full maps

	@SuppressWarnings("unchecked")
	public HashMap<String, Book> readBooksMap() {
		return (HashMap<String, Book>) readFromStorage(StorageType.BOOKS);
	}

	@SuppressWarnings("unchecked")
	public HashMap<String, User> readUserMap() {
		return (HashMap<String, User>) readFromStorage(StorageType.USERS);
	}
	
	@SuppressWarnings("unchecked")
	public HashMap<String, LibraryMember> readMemberMap() {
		return (HashMap<String, LibraryMember>) readFromStorage(StorageType.MEMBERS);
	}
	
	//LibraryMember
	public void saveLibraryMember(LibraryMember member) {
		membersMap.put(member.getMemberID(), member);
		saveToStorage(StorageType.MEMBERS, membersMap);
	}
	
	public LibraryMember readLibraryMember(String memberId) {
		LibraryMember lm = membersMap.get(memberId);
		return lm;
	}
	
	
//	public void saveLibraryMember(String name, LibraryMember member) {
//		ObjectOutputStream out = null;
//		try {
//			Path path = FileSystems.getDefault().getPath(OUTPUT_DIR, name);
//			out = new ObjectOutputStream(Files.newOutputStream(path));
//			out.writeObject(member);
//		} catch(IOException e) {
//			e.printStackTrace();
//		} finally {
//			if(out != null) {
//				try {
//					out.close();
//				} catch(Exception e) {}
//			}
//		}
//	}
//	
//	public LibraryMember readLibraryMember(String name) {
//		ObjectInputStream in = null;
//		LibraryMember member = null;
//		try {
//			Path path = FileSystems.getDefault().getPath(OUTPUT_DIR, name);
//			in = new ObjectInputStream(Files.newInputStream(path));
//			member = (LibraryMember)in.readObject();
//		} catch(Exception e) {
//			e.printStackTrace();
//		} finally {
//			if(in != null) {
//				try {
//					in.close();
//				} catch(Exception e) {}
//			}
//		}
//		return member;
//	}
=======
	
>>>>>>> origin/master
	
}
