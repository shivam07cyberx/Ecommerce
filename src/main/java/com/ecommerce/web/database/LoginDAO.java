package com.ecommerce.web.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ecommerce.web.modal.ShowUserDetails;

public class LoginDAO {

	
	public static ShowUserDetails Isvalid(String name, String password) throws ClassNotFoundException, SQLException {
	
		Connection x=Dbconfiguration.config();
		 PreparedStatement ps = x.prepareStatement("select * from users where user_name=? and password=? ");

             ps.setString(1,name);
             ps.setString(2,password);
		 
             ResultSet r= ps.executeQuery();
             
             
          if(r.next()) {
        	  ShowUserDetails s=new ShowUserDetails();
        	 s.setName(r.getString(2));
        	 s.setMobile( r.getString(3));
        	 s.setEmail(r.getString(4));
        	 s.setStatus(r.getString(5));
        	  return s;
          }
          else return null ;
		 
	}
	
}
