package com.mum.library.ui;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.mum.library.business.Auth;
import com.mum.library.business.User;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.Window;

public class MainFrameController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button AddBook;

    @FXML
    private Button addMem;

    @FXML
    private Text TxtUserID;

    @FXML
    private Pane FunctionPane;

    @FXML
    private Button addCopy;
    
    @FXML
    private VBox butionsControl;

    @FXML
    private Button CheckOutBook;

    @FXML
    private Button Logout;

    @FXML
    private Button PrintCheckoutRecord;

    @FXML
    private Text TxtRole;
    
    @FXML
    private VBox header;
    
   
    @FXML
    void OpenAddMemWin(ActionEvent event) {
        try {
    	  	
    		Parent openaddcopy = FXMLLoader.load(getClass().getResource("AddLibraryMember.fxml"));
    	
          FunctionPane.getChildren().clear();
          FunctionPane.getChildren().add(openaddcopy);
        	} catch (IOException e) {
        		e.printStackTrace();
        	}
    }

    @FXML
    void OpenCheckOutBookWin(ActionEvent event) {
    	try {
    	  	
    	Parent openaddcopy = FXMLLoader.load(getClass().getResource("CheckOutBookForm.fxml"));
    	
          FunctionPane.getChildren().clear();
          FunctionPane.getChildren().add(openaddcopy);
        	} catch (IOException e) {
        		e.printStackTrace();
        	}
    }

    @FXML
    void OpenAddCopyWin(ActionEvent event) {
    	try {
  	
    		Parent openaddcopy = FXMLLoader.load(getClass().getResource("AddLendableCopy.fxml"));
    	
          FunctionPane.getChildren().clear();
          FunctionPane.getChildren().add(openaddcopy);
        	} catch (IOException e) {
        		e.printStackTrace();
        	}
    }

    @FXML
    void OpenAddBookWin(ActionEvent event) {
    	try {
    	  	
    		Parent openaddcopy = FXMLLoader.load(getClass().getResource("AddBooks.fxml"));
    	
          FunctionPane.getChildren().clear();
          FunctionPane.getChildren().add(openaddcopy);
        	} catch (IOException e) {
        		e.printStackTrace();
        	}
    }

    @FXML
    void OpenPrintCheckoutRecordWin(ActionEvent event) {
    	try {
    	  	
    		Parent openaddcopy = FXMLLoader.load(getClass().getResource("PrintCheckoutRecordWin.fxml"));
    	
          FunctionPane.getChildren().clear();
          FunctionPane.getChildren().add(openaddcopy);
        	} catch (IOException e) {
        		e.printStackTrace();
        	}
    }

    @FXML
    void BackLoginWin(ActionEvent event) {
    	try {
    	Stage stage = new Stage();
		Window window = header.getScene().getWindow();
		if (window instanceof Stage) {
			((Stage) window).close();
		}
        Parent root;	
		root = FXMLLoader.load(getClass().getResource("Login.fxml"));
	
      stage.setTitle("Library System");
      Scene scene = new Scene(root);
      stage.setScene(scene);
      stage.show();
    	} catch (IOException e) {
    		e.printStackTrace();
    	}
    }

    @FXML
    void initialize() {
        assert AddBook != null : "fx:id=\"AddBook\" was not injected: check your FXML file 'MainFrame.fxml'.";
        assert addMem != null : "fx:id=\"addMem\" was not injected: check your FXML file 'MainFrame.fxml'.";
        assert TxtUserID != null : "fx:id=\"TxtUserID\" was not injected: check your FXML file 'MainFrame.fxml'.";
        assert FunctionPane != null : "fx:id=\"FunctionPane\" was not injected: check your FXML file 'MainFrame.fxml'.";
        assert addCopy != null : "fx:id=\"addCopy\" was not injected: check your FXML file 'MainFrame.fxml'.";
        assert CheckOutBook != null : "fx:id=\"CheckOutBook\" was not injected: check your FXML file 'MainFrame.fxml'.";
        assert Logout != null : "fx:id=\"Logout\" was not injected: check your FXML file 'MainFrame.fxml'.";
        assert PrintCheckoutRecord != null : "fx:id=\"PrintCheckoutRecord\" was not injected: check your FXML file 'MainFrame.fxml'.";
        assert TxtRole != null : "fx:id=\"TxtRole\" was not injected: check your FXML file 'MainFrame.fxml'.";
        assert header != null : "fx:id=\"header\" was not injected: check your FXML file 'MainFrame.fxml'.";
        assert butionsControl != null : "fx:id=\"butionsControl\" was not injected: check your FXML file 'MainFrame.fxml'.";

    }
    
    


	public void initData(String username, String Rolename) {
		TxtUserID.setText(username);
		TxtRole.setText(Rolename);
		
	}

	public void RoleFuction(User user) {
		if (user.getAuthorization().equals(Auth.ADMIN)) {
			butionsControl.getChildren().remove(CheckOutBook);
			butionsControl.getChildren().remove(PrintCheckoutRecord);
		}else if (user.getAuthorization().equals(Auth.LIBRARIAN)) {
			butionsControl.getChildren().remove(addMem);
			butionsControl.getChildren().remove(addCopy);
			butionsControl.getChildren().remove(AddBook);
		}
		
	}
}
