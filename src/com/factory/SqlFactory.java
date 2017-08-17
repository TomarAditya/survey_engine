package com.factory;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class SqlFactory {
	
	Connection connection;

	public Connection getConnection(){
		try{			
			Class.forName("com.mysql.jdbc.Driver");  
			connection=DriverManager.getConnection(
						"jdbc:mysql://localhost:3306/system_survey_database","root","java");

		}
		catch(SQLException e){
			System.out.println(e);
		}
		catch(ClassNotFoundException cnfe){
			System.out.println(cnfe);
		}
		return connection;

	}
	
	public void closeConnection(){
		try{	
			if(connection != null) {
				connection.close();
			}
		}catch(SQLException se){
			System.out.println(se);
		}
			
	}
}
