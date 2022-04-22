package application;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import connectiondb.dbhandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class Signup {
	

	 	private dbhandler handler=new dbhandler();
	    private Connection connection;
	    private PreparedStatement pst;
	    

	 @FXML
	    private TextField name;

	    @FXML
	    private TextField cnic;

	    @FXML
	    private PasswordField password;

	    @FXML
	    private TextField email;

	    @FXML
	    void backtologin(ActionEvent event) throws IOException {
	    	

			Main m=new Main();
	        m.changeScene("/FXML/login.fxml","Login");

	    }

	    @FXML
	    void signupdone(ActionEvent event) throws IOException {
	    	
	    	String insert="INSERT INTO users(name,cnic,email,password)"+"VALUES(?,?,?,?)";
			
			connection = handler.getConnection(); 
			try {
				pst=connection.prepareStatement(insert);
			}catch (SQLException e)
			{
				e.printStackTrace();
			}
			
			try {
				
				pst.setString(1, name.getText());
				pst.setString(2,cnic.getText());

				pst.setString(3,email.getText());
				pst.setString(4,password.getText());
				
				pst.executeUpdate();
				
			}catch(SQLException e)
			{
				e.printStackTrace();
			}
			
			Main m=new Main();
	        m.changeScene("/FXML/login.fxml","Login");
	        
			
			}


	    

}

