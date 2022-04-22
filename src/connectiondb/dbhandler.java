package connectiondb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import connectiondb.configs;

public class dbhandler extends configs {
	Connection dbcon;
	public Connection getConnection()
	{
		String connectionString="jdbc:mysql://"+configs.dbhost+":"+configs.dbport+"/"+ configs.dbname+"?autoReconnect=true&useSSl=false";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		}catch(ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		try
		{
			dbcon=DriverManager.getConnection(connectionString,configs.dbuser,configs.dbpass);
			
		}catch(SQLException e)
		{
		e.printStackTrace();
		}
		
		return dbcon; 
	}


}
