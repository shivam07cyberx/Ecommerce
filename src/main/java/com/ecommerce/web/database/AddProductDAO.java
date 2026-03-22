package com.ecommerce.web.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AddProductDAO {

	
	public static boolean addProduct(String productNmae,String p_url,int price,String desc,String brand,String category,int quantity) throws ClassNotFoundException, SQLException {
	
	
		
		Connection con=Dbconfiguration.config();
		
		PreparedStatement pst= con.prepareStatement("""
				insert into products(p_name ,p_img_url,p_price ,p_description,brand,p_catagory,quantity  ) values(?,?,?,?,?,?,?);
				
				
				""");
		
		pst.setString(1, productNmae);
		pst.setString(2, p_url);
		pst.setInt(3, price);
		pst.setString(4, desc);
		pst.setString(5, brand);
		pst.setString(6, category);
		pst.setInt(7, quantity);
		
		
		int  rs=pst.executeUpdate();
		
		
		if(rs==0) {
			return false;
		}
		
		else {
		
		
		return true;
		
		}
		
}

}