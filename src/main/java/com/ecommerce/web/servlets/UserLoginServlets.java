package com.ecommerce.web.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ecommerce.web.database.LoginDAO;
import com.ecommerce.web.modal.ShowUserDetails;
import com.ecommerce.web.modal.User;
import com.google.gson.Gson;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/Loginvalidate")
public class UserLoginServlets  extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		

		  Gson gson = new Gson();

	        // 1️⃣ Convert JSON body → Java object
	        User user = gson.fromJson(req.getReader(), User.class);

	        String username = user.getUsername();
	        String password = user.getPassword();

	        // 2️⃣ Convert Java object → JSON response
	        resp.setContentType("application/json");
	        ShowUserDetails users=null;
	     
	    try {
			 users=    LoginDAO.Isvalid(username, password);
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
	      
	        
	        String jsonResponse = gson.toJson(users);

	        resp.getWriter().write(jsonResponse);
		
		
		
		
		
	}

}
