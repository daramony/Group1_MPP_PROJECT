//package com.mum.library.controller;
//import java.util.ArrayList;
//import java.util.List;
//import com.mum.library.business.Address;
//import com.mum.library.business.Author;
//import com.mum.library.business.Book;
//import com.mum.library.dataaccess.DataAccessFacade;
//import javafx.beans.property.SimpleStringProperty;
//import javafx.collections.FXCollections;
//import javafx.collections.ObservableList;
//import javafx.event.ActionEvent;
//import javafx.fxml.FXML;
//import javafx.scene.control.Alert;
//import javafx.scene.control.Alert.AlertType;
//import javafx.scene.control.Button;
//import javafx.scene.control.Label;
//import javafx.scene.control.TableColumn;
//import javafx.scene.control.TableView;
//import javafx.scene.control.TextField;
//public class AddBookController {
//	@FXML
//	private TextField txtBookTitle;
//	@FXML
//	private TextField txtISBN;
//	@FXML
//	private TextField txtBookMaxLendDays;
//	@FXML
//	private Button btnAddBookAuthor;
//	@FXML
//	private Button btnAddBook;
//	
//	@FXML
//	private TableView<Author> tblBookList;
//
//	@FXML
//	private TableColumn<Author, String> bookAuthorFirstName;
//	@FXML
//	private TableColumn<Author, String> bookAuthorLastName;
//	@FXML
//	private TableColumn<Author, String> bookAuthorCredentials;
//	@FXML
//	private TableColumn<Author, String> bookAuthorStreet;
//	@FXML
//	private TableColumn<Author, String> bookAuthorCity;
//	@FXML
//	private TableColumn<Author, String> bookAuthorState;
//	@FXML
//	private TableColumn<Author, String> bookAuthorZip;
//	@FXML
//	private TableColumn<Author, String> bookAuthorPhoneNo;
//	@FXML
//	private TableColumn<Author, String> bookAuthorShortBio;
//
//	@FXML
//	private TextField txtBookAuthorFirstName;
//	@FXML
//	private TextField txtBookAuthorLastName;
//	@FXML
//	private TextField txtBookAuthorCredentials;
//	@FXML
//	private TextField txtBookAuthorStreet;
//	@FXML
//	private TextField txtBookAuthorCity;
//	@FXML
//	private TextField txtBookAuthorState;
//	@FXML
//	private TextField txtBookAuthorZip;
//	@FXML
//	private TextField txtBookAuthorPhoneNo;
//	@FXML
//	private TextField txtBookAuthorShortBio;
//
//	private ObservableList<Author> bookAuthor = FXCollections.observableArrayList();
//	private List<Author> authorList = new ArrayList<Author>();
//
//
//	@FXML
//	private void initialize() {
//
//		bookAuthorFirstName
//				.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getFirstName()));
//		bookAuthorLastName.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getLastName()));
//		bookAuthorCredentials
//				.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCredentials()));
//		bookAuthorStreet.setCellValueFactory(
//				cellData -> new SimpleStringProperty(cellData.getValue().getAddress().getStreet()));
//		bookAuthorCity
//				.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getAddress().getCity()));
//		bookAuthorState
//				.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getAddress().getState()));
//		bookAuthorZip
//				.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getAddress().getZip()));
//		bookAuthorPhoneNo.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getPhoneNo()));
//		bookAuthorShortBio.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getShortBio()));
//
//	}
//
//	@FXML
//	public void AddAuthor(ActionEvent event) {
//		Address address = new Address(txtBookAuthorStreet.getText(), txtBookAuthorCity.getText(),
//				txtBookAuthorState.getText(), txtBookAuthorZip.getText());
//		Author bookauthor = new Author(txtBookAuthorFirstName.getText(), txtBookAuthorLastName.getText(),
//				txtBookAuthorPhoneNo.getText(), txtBookAuthorCredentials.getText(), address,
//				txtBookAuthorShortBio.getText());
//		bookAuthor.add(bookauthor);
//		tblBookList.setItems(bookAuthor);
//		clearAuthorData();
//	}
//
//	@FXML
//	public void AddBook(ActionEvent event) {
//		authorList.addAll(bookAuthor);
//		Book book = new Book(txtISBN.getText(), txtBookTitle.getText(), Integer.parseInt(txtBookMaxLendDays.getText()),
//				authorList);
//		DataAccessFacade.saveToStorage(DataAccessFacade.StorageType.BOOKS, (Object) book);
//		clearBookData();
//		Alert alert = new Alert(AlertType.INFORMATION);
//		alert.setTitle("Added SuccessFull");
//		alert.setHeaderText(null);
//		alert.setContentText("Book has been added SuccessFully");
//		alert.showAndWait();
//	}
//
//	private void clearBookData() {
//		authorList.clear();
//		clearAuthorData();
//		txtBookTitle.clear();
//		txtISBN.clear();
//		txtBookMaxLendDays.clear();
//		bookAuthor.clear();
//		tblBookList.setItems(bookAuthor);
//
//	}
//
//	private void clearAuthorData() {
//		txtBookAuthorCity.clear();
//		txtBookAuthorCredentials.clear();
//		txtBookAuthorFirstName.clear();
//		txtBookAuthorLastName.clear();
//		txtBookAuthorPhoneNo.clear();
//		txtBookAuthorShortBio.clear();
//		txtBookAuthorState.clear();
//		txtBookAuthorStreet.clear();
//		txtBookAuthorZip.clear();
//
//	}
//
//}
