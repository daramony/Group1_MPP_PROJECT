package com.mum.library.ui;

import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import com.mum.library.business.CheckOutRecordTable;
import com.mum.library.business.CheckoutRecordEntry;
import com.mum.library.business.LibraryMember;
import com.mum.library.dataaccess.DataAccess;
import com.mum.library.dataaccess.DataAccessFacade;


import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;


public class PrintCheckoutCntroller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label showState;

    @FXML
    private Button Print;

    @FXML
    private TableColumn<CheckOutRecordTable, LocalDate> CheckoutDate;

    @FXML
    private TableView<CheckOutRecordTable> ShowCheckState;

    @FXML
    private TableColumn<CheckOutRecordTable, Integer> CheckOutCopyNums;

    @FXML
    private TableColumn<CheckOutRecordTable, String> CheckOutBookTitle;

    @FXML
    private TableColumn<CheckOutRecordTable, LocalDate> DueDate;

    @FXML
    private TextArea TxtMemID;

    @FXML
    void DoPrint(ActionEvent event) {
    	printInConsole();
    }

    @FXML
    void initialize() {
        assert showState != null : "fx:id=\"showState\" was not injected: check your FXML file 'PrintCheckoutRecordWin.fxml'.";
        assert Print != null : "fx:id=\"Print\" was not injected: check your FXML file 'PrintCheckoutRecordWin.fxml'.";
        assert CheckoutDate != null : "fx:id=\"CheckoutDate\" was not injected: check your FXML file 'PrintCheckoutRecordWin.fxml'.";
        assert ShowCheckState != null : "fx:id=\"ShowCheckState\" was not injected: check your FXML file 'PrintCheckoutRecordWin.fxml'.";
        assert CheckOutCopyNums != null : "fx:id=\"CheckOutCopyNums\" was not injected: check your FXML file 'PrintCheckoutRecordWin.fxml'.";
        assert CheckOutBookTitle != null : "fx:id=\"CheckOutBookTitle\" was not injected: check your FXML file 'PrintCheckoutRecordWin.fxml'.";
        assert DueDate != null : "fx:id=\"DueDate\" was not injected: check your FXML file 'PrintCheckoutRecordWin.fxml'.";
        assert TxtMemID != null : "fx:id=\"TxtMemID\" was not injected: check your FXML file 'PrintCheckoutRecordWin.fxml'.";

    }
    
    public void printInConsole(){
    	String memId=TxtMemID.getText();
    	String leftAlignFormat = "| %-32s | %-10d | %-13s | %-13s |%n";
    	DataAccess da=new DataAccessFacade();
    	if (da.readLibraryMember(memId)!=null) {
    		LibraryMember aMember=da.readLibraryMember(memId);
        	List<CheckoutRecordEntry> recordEntries=new ArrayList<CheckoutRecordEntry>();
        	recordEntries=aMember.getRecord().getEntries();
        	
        	System.out.format("+----------------------------------+------------+---------------+---------------+%n");
    		System.out.printf("| Book Title                       |Copy Number | Checkout Date | Due Date      |%n");
    		System.out.format("+----------------------------------+------------+---------------+---------------+%n");
    		for(CheckoutRecordEntry x: recordEntries){
    			System.out.format(leftAlignFormat, x.getCopy().getPublication().getTitle(), x.getCopy().getCopyId(), x.getCheckoutDate().toString(), x.getDueDate().toString());
    		}
    		System.out.format("+----------------------------------+------------+---------------+---------------+%n");  
    		
    		
    		showState.setText("Print Sucessed.");
    		setBookTable(recordEntries);
    		
    		
		}else {
			TxtMemID.setText("");
			showState.setText("");
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("LibraryMember");
			alert.setHeaderText(null);
			alert.setContentText("This ID not exist in Library");
			alert.showAndWait();
		}
    	

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
    			ShowCheckState.setItems(bookRecordData);
    			
    			CheckOutBookTitle
				.setCellValueFactory(new PropertyValueFactory<CheckOutRecordTable, String>(
						"bookTitle"));
    			

    			CheckOutCopyNums
    			.setCellValueFactory(new PropertyValueFactory<CheckOutRecordTable, Integer>(
				"copyNumber"));
    			
    			
    			CheckoutDate
    			.setCellValueFactory(new PropertyValueFactory<CheckOutRecordTable,LocalDate>(
				"checkOutDate"));
    			
    			
    			DueDate
    			.setCellValueFactory(new PropertyValueFactory<CheckOutRecordTable, LocalDate>(
				"dueDate"));
    			
    			
		
    }		
		


	}
    

