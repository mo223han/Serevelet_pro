package com.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.db.Provider;
import com.db.Users;

public class UsersDao {
	public static int save(Users u)
	{
		int status=0;
		
		 
		try {
			Connection con=Provider.getConnection();
			System.out.print("Hi"+con);
			String sql="Insert into Third values(?,?,?,?,?,?)";
			PreparedStatement pst=con.prepareStatement(sql);
			pst.setString(1,u.getReg());
			pst.setString(2,u.getName());
			pst.setString(3,u.getBranch());
			pst.setString(4,u.getBg());
			pst.setString(5,u.getDob());
			pst.setString(6,u.getMob());
			status=pst.executeUpdate();
			System.out.print(status);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status;
	}

}
