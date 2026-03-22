package com.ecommerce.web.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ecommerce.web.database.ShowProductDAO;
import com.ecommerce.web.modal.Product;
import com.google.gson.Gson;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/shoeproduct")
public class ShowProductServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		ArrayList<Product> p= new ArrayList<>();
		try {
			p=ShowProductDAO.showProcuts();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		 Gson gson = new Gson();
		    String json = gson.toJson(p);

		    resp.setContentType("application/json");
		    resp.getWriter().write(json);
		
		
		
		
		
	}
	
	

}
