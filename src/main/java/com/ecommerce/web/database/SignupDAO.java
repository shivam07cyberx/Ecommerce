package com.ecommerce.web.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SignupDAO {

	public static int UserCreated(String name,String mobile,String email,String password) throws ClassNotFoundException, SQLException {
		
		Connection x=Dbconfiguration.config();
		PreparedStatement pst= x.prepareStatement("""
				
				insert into users (user_name,user_mobile_no,user_email,password) values(?,?,?,?) """);
		
		pst.setString(1, name);
		pst.setString(2, mobile);
		pst.setString(3, email);
		pst.setString(4, password);
		
		int isInsert=pst.executeUpdate();
		
		
		
		return isInsert;
		
	}
	

	
}
