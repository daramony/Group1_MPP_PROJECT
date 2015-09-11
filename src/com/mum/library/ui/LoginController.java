package com.mum.library.ui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.mum.library.dataaccess.DataAccess;
import com.mum.library.dataaccess.DataAccessFacade;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
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
    	String username=TxtUsername.getText();
    	String password=TxtPassword.getText();    	 	
    	loginRules(username,password);
    	
    
    
    }

    private void loginRules(String username, String password) {
    	DataAccess da=new DataAccessFacade();
    	if (da.readUserMap().get(username)!=null&&da.readUserMap().get(username).getPassword().equals(password)) {
    		try {   			
    	    	Stage stage = new Stage();
    	    				Window window = header.getScene().getWindow();
    	    				if (window instanceof Stage) {
    	    					((Stage) window).close();
    	    				}   	   
    	    		
    				FXMLLoader loader = new FXMLLoader(getClass().getResource(
    						"MainFrame.fxml"));
    				
    				Parent root = loader.load();
    	    		
    	    		// Passing Username from login window to Mainframe window
    				MainFrameController controller = loader.<MainFrameController> getController();
    				controller.initData(username, da.readUserMap().get(username).getAuthorization().name());
    				controller.RoleFuction(da.readUserMap().get(username));
    				
    				stage.setTitle("Library System");
    	    		Scene scene = new Scene(root);
    	    		stage.setScene(scene);
    	    		stage.show();
    	    	} catch (IOException e) {
    				e.printStackTrace();
    			}
		}else {
			TxtUsername.setText("");
			TxtPassword.setText("");
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("Library System");
			alert.setHeaderText(null);
			alert.setContentText("You input the wrong username or password,please try again!");
			alert.showAndWait();
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

