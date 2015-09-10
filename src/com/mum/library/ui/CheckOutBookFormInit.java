package com.mum.library.ui;

import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.ResourceBundle;

import com.mum.library.business.Book;
import com.mum.library.business.CheckOutRecordTable;
import com.mum.library.business.CheckoutRecordEntry;
import com.mum.library.business.LendableCopy;
import com.mum.library.business.LibraryMember;
import com.mum.library.dataaccess.DataAccess;
import com.mum.library.dataaccess.DataAccessFacade;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;


public class CheckOutBookFormInit {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private VBox vbCheckOutRecord;

    @FXML
    private AnchorPane pnCheckOutForm;

    @FXML
    private ScrollPane pnCheckOutRecord;

    @FXML
    private TableColumn<CheckOutRecordTable, Integer> thCopyNumber;

    @FXML
    private TableColumn<CheckOutRecordTable, LocalDate> thCheckOutDate;

    @FXML
    private TextField txtMemberId;

    @FXML
    private Button btnCheckOut;

    @FXML
    private TableView<CheckOutRecordTable> tblCheckOutRecord;

    @FXML
    private TableColumn<CheckOutRecordTable, LocalDate> thDueDate;

    @FXML
    private Label lblStudentName;

    @FXML
    private TableColumn<CheckOutRecordTable, String> thBook;

    @FXML
    private Label lblMemberId;

    @FXML
    private AnchorPane pnSubCheckOutForm;

    @FXML
    private TextField txtISBN;

    @FXML
    private Label lblISBN;

    @FXML
    void checkOutForm(ActionEvent event)  {
    	String memberId = txtMemberId.getText();
    	String isbn = txtISBN.getText();
    
    	checkoutBook(memberId, isbn);
    
    }

    
	// add by william 
	public LibraryMember searchMember(String memberId){
    	DataAccess da=new DataAccessFacade();
		LibraryMember lm = da.readLibraryMember(memberId);
		return lm;
	}
	public Book searchBook(String isbn){
		DataAccess da=new DataAccessFacade();
	
		Book b = da.readBook(isbn);
		return b;
		
	}
	public void saveNewCheckoutRecordEntry(LibraryMember member, Book book) {
		
		
	}
    public void checkoutBook(String memberId, String isbn)  {
    	
		LibraryMember m = searchMember(memberId);
		Book b = searchBook(isbn);
		
		if(m == null){
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("LibraryMember");
			alert.setHeaderText(null);
			alert.setContentText("This ID not exist in Library");
			alert.showAndWait();
			return;
		} 
		
		if(b == null){
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("Book");
			alert.setHeaderText(null);
			alert.setContentText("This Book not exist in Library");
			alert.showAndWait();
			return;
		} 
		
		
		/*
		DataAccess da = new DataAccessFacade();
		HashMap<String, Book> map = da.readBooksMap();
		map.get(isbn).addCopy();
		List<Book> allBooks = new ArrayList<Book>();
		for (Book value : map.values()) {
			allBooks.add(value);
		}		
		DataAccessFacade.saveBookMap(allBooks);
		*/

		List<CheckoutRecordEntry> recordEntries=new ArrayList<CheckoutRecordEntry>();
    	recordEntries=m.getRecord().getEntries();
    	setBookTable(recordEntries);
		
    	
    	
			
//			LendableCopy cb = b.getNextAvailableCopy();
//			int getMaxCheckoutLenght = b.getMaxCheckoutLength();
//			
//			da.searchMember(memberId).checkout(cb, LocalDate.now(), LocalDate.now().plusDays(getMaxCheckoutLenght));
//			
//			da.saveNewCheckoutRecordEntry(m,b);
//			queryCheckoutRecordToTable(m);
				
    }
    
    @SuppressWarnings("unchecked")
   	public void setBookTable(List<CheckoutRecordEntry> recordEntries) {

       	//A list that allows listeners to track changes when they occur
       			ObservableList<CheckOutRecordTable> bookRecordData = FXCollections
       					.observableArrayList();

       			List<CheckOutRecordTable> checkOutRecordTable = new ArrayList<CheckOutRecordTable>();
       	
       			for(CheckoutRecordEntry x: recordEntries){
       				checkOutRecordTable.add(new CheckOutRecordTable(
       						x.getCopy().getPublication().getTitle(),
       						x.getCopy().getCopyId(),
       						x.getCheckoutDate(),
       						x.getDueDate()
       						));
       			}
       			//System.out.println(checkOutRecordTable);
       			bookRecordData.addAll(checkOutRecordTable);
       			tblCheckOutRecord.setItems(bookRecordData);
       			
       			thBook.setCellValueFactory(new PropertyValueFactory<CheckOutRecordTable, String>(
   						"bookTitle"));
       			

       			thCopyNumber
       			.setCellValueFactory(new PropertyValueFactory<CheckOutRecordTable, Integer>(
   				"copyNumber"));
       			
       			
       			thCheckOutDate
       			.setCellValueFactory(new PropertyValueFactory<CheckOutRecordTable,LocalDate>(
   				"checkOutDate"));
       			
       			
       			thDueDate
       			.setCellValueFactory(new PropertyValueFactory<CheckOutRecordTable, LocalDate>(
   				"dueDate"));
       			
       			
   		
       }		
    
    

    public TableColumn<CheckOutRecordTable, Integer> getThCopyNumber() {
		return thCopyNumber;
	}

	public TableColumn<CheckOutRecordTable, LocalDate> getThCheckOutDate() {
		return thCheckOutDate;
	}

	public TableColumn<CheckOutRecordTable, LocalDate> getThDueDate() {
		return  thDueDate;
	}

	public TableColumn<CheckOutRecordTable, String> getThBook() {
		return thBook;
	}

	public Label getLblStudentName() {
		return lblStudentName;
	}
	
	public ScrollPane getPnCheckOutRecord() {
		return pnCheckOutRecord;
	}

	public TableView<CheckOutRecordTable> getTblCheckOutRecord() {
		return  tblCheckOutRecord;
	}

   public TextField getTxtMemberId() {
		return txtMemberId;
	}


	public TextField getTxtISBN() {
		return txtISBN;
	}


@FXML
    void initialize() {
        assert vbCheckOutRecord != null : "fx:id=\"vbCheckOutRecord\" was not injected: check your FXML file 'CheckOutBookForm.fxml'.";
        assert pnCheckOutForm != null : "fx:id=\"pnCheckOutForm\" was not injected: check your FXML file 'CheckOutBookForm.fxml'.";
        assert pnCheckOutRecord != null : "fx:id=\"pnCheckOutRecord\" was not injected: check your FXML file 'CheckOutBookForm.fxml'.";
        assert thCopyNumber != null : "fx:id=\"thCopyNumber\" was not injected: check your FXML file 'CheckOutBookForm.fxml'.";
        assert thCheckOutDate != null : "fx:id=\"thCheckOutDate\" was not injected: check your FXML file 'CheckOutBookForm.fxml'.";
        assert txtMemberId != null : "fx:id=\"txtMemberId\" was not injected: check your FXML file 'CheckOutBookForm.fxml'.";
        assert btnCheckOut != null : "fx:id=\"btnCheckOut\" was not injected: check your FXML file 'CheckOutBookForm.fxml'.";
        assert tblCheckOutRecord != null : "fx:id=\"tblCheckOutRecord\" was not injected: check your FXML file 'CheckOutBookForm.fxml'.";
        assert thDueDate != null : "fx:id=\"thDueDate\" was not injected: check your FXML file 'CheckOutBookForm.fxml'.";
        assert lblStudentName != null : "fx:id=\"lblStudentName\" was not injected: check your FXML file 'CheckOutBookForm.fxml'.";
        assert thBook != null : "fx:id=\"thBook\" was not injected: check your FXML file 'CheckOutBookForm.fxml'.";
        assert lblMemberId != null : "fx:id=\"lblMemberId\" was not injected: check your FXML file 'CheckOutBookForm.fxml'.";
        assert pnSubCheckOutForm != null : "fx:id=\"pnSubCheckOutForm\" was not injected: check your FXML file 'CheckOutBookForm.fxml'.";
        assert txtISBN != null : "fx:id=\"txtISBN\" was not injected: check your FXML file 'CheckOutBookForm.fxml'.";
        assert lblISBN != null : "fx:id=\"lblISBN\" was not injected: check your FXML file 'CheckOutBookForm.fxml'.";

    }
}
