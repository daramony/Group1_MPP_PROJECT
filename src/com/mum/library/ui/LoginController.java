package com.mum.library.ui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.Window;

public class LoginController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnLogin;
    
    @FXML
    private AnchorPane header;

    @FXML
    private PasswordField TxtPassword;

    @FXML
    private TextField TxtUsername;

    @FXML
    void login(ActionEvent event) {
    
    	try {
//    		FXMLLoader loader = new FXMLLoader(getClass().getResource(
//				"MainFrame1.fxml")); 
//    		
//			Parent root = loader.load();
//   	
    	Stage stage = new Stage();
//		stage.setTitle("Library System");
//		stage.setScene(new Scene(root));
//		stage.show();
    	// Close login window
    				Window window = header.getScene().getWindow();
    				if (window instanceof Stage) {
    					((Stage) window).close();
    				}
    		Parent root = FXMLLoader.load(getClass().getResource("MainFrame.fxml"));
    		stage.setTitle("Library System");
    		Scene scene = new Scene(root);
    		stage.setScene(scene);
    		stage.show();
    		
    		
    	} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    @FXML
    void initialize() {
        assert btnLogin != null : "fx:id=\"btnLogin\" was not injected: check your FXML file 'Login.fxml'.";
        assert TxtPassword != null : "fx:id=\"TxtPassword\" was not injected: check your FXML file 'Login.fxml'.";
        assert TxtUsername != null : "fx:id=\"TxtUsername\" was not injected: check your FXML file 'Login.fxml'.";
        assert header != null : "fx:id=\"header\" was not injected: check your FXML file 'Login1.fxml'.";

    }
}

