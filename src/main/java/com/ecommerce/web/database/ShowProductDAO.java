package com.ecommerce.web.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ecommerce.web.modal.Product;


public class ShowProductDAO {

	public static  ArrayList<Product>  showProcuts() throws ClassNotFoundException, SQLException {
	
	ArrayList<Product> p= new ArrayList<>();
	Connection con=Dbconfiguration.config();
	
	PreparedStatement pst=con.prepareStatement("select * from products");
	
	
	ResultSet rs=pst.executeQuery();
	
	while(rs.next()) {
		
		int quantity=rs.getInt("quantity");
		int id=rs.getInt("p_id");
		String name = rs.getString("p_name");
		int price = rs.getInt("p_price");
		String imageUrl = rs.getString("p_img_url");
		String description = rs.getString("p_description");
		String brand = rs.getString("brand");
		String category = rs.getString("p_catagory");
		
		Product myprod=new Product(id,name,price,imageUrl,description,brand,category,quantity);
		
		
	p.add(myprod);
	
	
		
	}
	
	return p;
	}
	
}
