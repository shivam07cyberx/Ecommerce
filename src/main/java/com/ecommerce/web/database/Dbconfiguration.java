package com.ecommerce.web.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Dbconfiguration {

	public static Connection config() throws ClassNotFoundException, SQLException {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/e_commerce",
                "root",
                "Shivam@22");
		
		
		return con;
	}
	
}
