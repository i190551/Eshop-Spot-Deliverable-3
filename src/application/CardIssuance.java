package application;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import connectiondb.dbhandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class CardIssuance {
	
 	private dbhandler handler=new dbhandler();
    private Connection connection;
    private PreparedStatement pst;
	private static Stage stg;
	private String card;
	
	
	  @FXML
	    private RadioButton silver;

	    @FXML
	    private RadioButton platinum;

	    @FXML
	    private RadioButton gold;

	    @FXML
	    void cardissueback(ActionEvent event) throws IOException {
	    	
	    	Main m=new Main();
	        m.changeScene("/FXML/BecomeMember.fxml","Login");
	        

	    }

	    @FXML
	    void generatecard(ActionEvent event) throws IOException 
	    {
	    	
	    	List<RadioButton> list = Arrays.asList(silver,gold,platinum);
	    	
	    	for(int i=0;i<list.size();i++)
	    	{
	    		boolean isSelected = (list.get(i)).isSelected();
	    		if(isSelected)
	    		{
	    			card=list.get(i).getText();
	    			
	    			
	    		}
	    		
	    	}
	    	
	    	String insert="INSERT INTO cardinfo(name_m,card_num,cardtype,cardid)"+"VALUES(?,?,?,?)";
			
	    	
	    	
			connection = handler.getConnection(); 
			try {
				pst=connection.prepareStatement(insert);
			}catch (SQLException e)
			{
				e.printStackTrace();
			}
			
			try {
				
				pst.setString(1,"");
				pst.setString(2,"");
				pst.setString(3,card);
				pst.setInt(4,0);
				
				pst.executeUpdate();
				
			}catch(SQLException e)
			{
				e.printStackTrace();
			}
	
         
	    	
	    	
	    	if(card.equals("Gold"))
	    	{
	    			
		    	Stage votingproc=new Stage();
				Parent root=FXMLLoader.load(getClass().getResource("/FXML/goldcard.fxml"));

				Scene scene=new Scene(root);
				votingproc.setScene(scene);
				votingproc.show();
				votingproc.setResizable(false);

				votingproc.setTitle("Gold Card");
	    		
	    		}
	    	
	    	else if(card.equals("Silver"))
    		{
    			
	    	Stage votingproc=new Stage();
			Parent root=FXMLLoader.load(getClass().getResource("/FXML/silvercard.fxml"));

			Scene scene=new Scene(root);
			votingproc.setScene(scene);
			votingproc.show();
			votingproc.setResizable(false);

			votingproc.setTitle("Silver Card");
    		
    		}
	    	
	    	else if(card.equals("Platinum"))
    		{
    			
	    	Stage votingproc=new Stage();
			Parent root=FXMLLoader.load(getClass().getResource("/FXML/platinumcard.fxml"));

			Scene scene=new Scene(root);
			votingproc.setScene(scene);
			votingproc.show();
			votingproc.setResizable(false);

			votingproc.setTitle("Platinum Card");
    		
    		}
	    		
	    }
	    		
	    	
	    	
	    	

	    
}

