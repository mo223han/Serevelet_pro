package com.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Provider {

	public static Connection getConnection() {
		// TODO Auto-generated method stub
		Connection con=null;
		 
			 try {
				 
				 
					 Class.forName("com.mysql.jdbc.Driver");
					 con=DriverManager.getConnection("jdbc:mysql://localhost:3306/kratu","root","mohan");
				 
				 } catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
		
		
		return con;
	}


}
