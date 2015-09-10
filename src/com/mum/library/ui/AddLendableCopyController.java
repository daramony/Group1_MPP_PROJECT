package com.mum.library.ui;

import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.ResourceBundle;

import com.mum.library.dataaccess.DataAccess;
import com.mum.library.dataaccess.DataAccessFacade;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import com.mum.library.business.*;


import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class AddLendableCopyController{

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableColumn<Book, String> titleColumn;

    @FXML
    private TextField numberOfCopyText;

    @FXML
    private TextField isbnText;

    @FXML
    private TableView<Book> bookTableView;

    @FXML
    private TableColumn<Book, String> isbnColumn;

    @FXML
    private TableColumn<Book, String> numberOfCopyColumn;

    private ObservableList<Book> memberData;
    
    
    @FXML
    void searchClick(ActionEvent event) throws Exception {
    	
    	String isbn = isbnText.getText();
    	
    	DataAccess data = new DataAccessFacade();
    	HashMap<String, Book> map = data.readBooksMap();
    	
    	if (map.containsKey(isbn)) {
			//Book book = map.get(isbn);
		}
    	System.out.println("search");
    }
    
    
    @FXML 
    void myRowClick(MouseEvent event) {
    	System.out.println("Select" + bookTableView.getSelectionModel().getSelectedIndex());
    	
    	String isbn = memberData.get(bookTableView.getSelectionModel().getSelectedIndex()).getIsbn();
    	DataAccess data = new DataAccessFacade();
    	HashMap<String, Book> map = data.readBooksMap();
  
    	if (map.containsKey(isbn)) {
			//System.out.println("ID " + isbn + " not found");
			Book book = map.get(isbn);
			isbnText.setText(book.getIsbn());
			numberOfCopyText.setText("0");
		}
    }
    
    @FXML
    void initialize() {
        assert titleColumn != null : "fx:id=\"titleColumn\" was not injected: check your FXML file 'AddLendableCopy.fxml'.";
        assert numberOfCopyText != null : "fx:id=\"numberOfCopyText\" was not injected: check your FXML file 'AddLendableCopy.fxml'.";
        assert isbnText != null : "fx:id=\"isbnText\" was not injected: check your FXML file 'AddLendableCopy.fxml'.";
        assert bookTableView != null : "fx:id=\"bookTableView\" was not injected: check your FXML file 'AddLendableCopy.fxml'.";
        assert isbnColumn != null : "fx:id=\"isbnColumn\" was not injected: check your FXML file 'AddLendableCopy.fxml'.";
        assert numberOfCopyColumn != null : "fx:id=\"numberOfCopyColumn\" was not injected: check your FXML file 'AddLendableCopy.fxml'.";
        loadTableData();
    }
    
    private void loadTableData() {
    	
		memberData = FXCollections.observableArrayList();
		DataAccess da = new DataAccessFacade();
		HashMap<String, Book> map = da.readBooksMap();
		Iterator it = map.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, Book> member = (Map.Entry) it.next();
			memberData.add(member.getValue());
		}
		
		bookTableView.setItems(memberData);
		isbnColumn.setCellValueFactory(new PropertyValueFactory<Book, String>("isbn"));
		titleColumn.setCellValueFactory(new PropertyValueFactory<Book, String>("title"));
		numberOfCopyColumn.setCellValueFactory(new PropertyValueFactory<Book, String>("copy"));
		
    }
}
