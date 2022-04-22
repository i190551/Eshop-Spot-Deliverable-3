package application;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

import connectiondb.dbhandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.RadioButton;
import javafx.stage.Window;

public class BecomeMember  {
	
	 	private dbhandler handler=new dbhandler();
	    private Connection connection;
	    private PreparedStatement pst;
	    
	    

      	Main m=new Main();
	    private String memberpreference="";
	    private String cardstatus;
	    public String email;
	    
	    private int id,mid;
	    

	    @FXML
	    private TextField membername;

	    @FXML
	    private TextField memberaddress;

	    @FXML
	    private TextField memberemail;

	    @FXML
	    private TextField membercontact;

	    @FXML
	    private RadioButton memberhome;

	    @FXML
	    private RadioButton memberlifestyle;

	    @FXML
	    private RadioButton memberclothing;

	    @FXML
	    private RadioButton memberhealth;

	    @FXML
	    private RadioButton memberbeauty;

	    @FXML
	    private RadioButton memberelectronics;


	    @FXML
	    void memberback(ActionEvent event) throws IOException {
	    	
	    	Main m=new Main();
	        m.changeScene("/FXML/login.fxml","Login");
	        
	    	


	    }

	    @FXML
	    void membernext(ActionEvent event) throws IOException, SQLException {
	    	
	    	
	    	List<RadioButton> list = Arrays.asList(memberhome,memberclothing,memberlifestyle,memberhealth,memberbeauty,memberelectronics);
	    	
	    	for(int i=0;i<list.size();i++)
	    	{
	    		boolean isSelected = (list.get(i)).isSelected();
	    		
	    		
	    		if(isSelected)
	    		{	
	    			 memberpreference = String.join(" ",memberpreference, (list.get(i)).getText());
	    		}
	    		
	    	}
	    	
	    	
	    	
	    	
	    	
	    	String insert="INSERT INTO memberinfo(memberid,membername,membercontact,memberemail,memberaddress)"+"VALUES(?,?,?,?,?)";
			
	    	
	    	
			connection = handler.getConnection(); 
			try {
				pst=connection.prepareStatement(insert);
			}catch (SQLException e)
			{
				e.printStackTrace();
			}
			
			try {
				
				pst.setInt(1, 0);
				pst.setString(2,membername.getText());
				pst.setString(3,membercontact.getText());
				pst.setString(4,memberemail.getText());
				pst.setString(5,memberaddress.getText());
				
				pst.executeUpdate();
				
			}catch(SQLException e)
			{
				e.printStackTrace();
			}
	
         
			
			
           	String insert2="INSERT INTO preference(memberid,Preference)"+"VALUES(?,?)";
			
	    	
	    	
			connection = handler.getConnection(); 
			try {
				pst=connection.prepareStatement(insert2);
			}catch (SQLException e)
			{
				e.printStackTrace();
			}
			
			try {
				
				pst.setInt(1, 0);
				pst.setString(2,memberpreference);
				
				pst.executeUpdate();
				
			}catch(SQLException e)
			{
				e.printStackTrace();
			}
			
			
			
			showAlert1(Alert.AlertType.CONFIRMATION,null, "Success","Successfully become a member" );
			
			

	        m.changeScene("/FXML/Cardissuance.fxml","Card Issuance");
	        
	        



	    }
	     
	    
	    
	    private void showAlert1(AlertType error, Window owner, String string, String string2) {
	 		// TODO Auto-generated method stub
	 		 Alert alert = new Alert(error);
	 	        alert.setTitle(string);
	 	        alert.setHeaderText(null);
	 	        alert.setContentText(string2);
	 	        alert.initOwner(owner);
	 	        alert.show();
	 		
	 	}
	     
	     
	
	  
	    
	    

    	
    	
    
	
	

	
}
