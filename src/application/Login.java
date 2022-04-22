package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class Login {

	  @FXML
	    private TextField loginusername;

	    @FXML
	    private PasswordField loginpassword;

	    @FXML
	    void login(ActionEvent event) throws IOException {
	    	
	      	Main m=new Main();
	        m.changeScene("/FXML/BecomeMember.fxml","Become a Member");

	    }

	    @FXML
	    void signup(ActionEvent event) throws IOException {
	    	

			Main m=new Main();
	        m.changeScene("/FXML/Signup.fxml","Sign Up");

	    }
}
