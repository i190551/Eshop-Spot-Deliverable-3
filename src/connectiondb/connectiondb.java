package connectiondb;

import java.sql.*;

public class connectiondb {
	
	public static void main(String args[])
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/members","root","bwin17");
			
			System.out.println("Successfully Connected");
			
			
		}
		
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	
	
	
	
	

}
