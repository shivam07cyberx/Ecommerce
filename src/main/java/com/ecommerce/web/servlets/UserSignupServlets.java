package com.ecommerce.web.servlets;

import java.io.IOException;
import java.sql.SQLException;

import com.ecommerce.web.database.SignupDAO;
import com.ecommerce.web.modal.User;
import com.ecommerce.web.modal.UserSignup;
import com.google.gson.Gson;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/Signup")
public class UserSignupServlets extends HttpServlet {

	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		
		
		
		  Gson gson = new Gson();


	        UserSignup user = gson.fromJson(req.getReader(), UserSignup.class);

	        String username = user.getName();
	        String password = user.getPassword();
	        String mobile = user. getMobile();
	        String email = user.   getEmail();

	        // Convert Java object → JSON response
	        resp.setContentType("application/json");
		
		
		int isCreated=0;
		
	try {
		 isCreated=	SignupDAO.UserCreated(username,mobile,email,password);
	} catch (ClassNotFoundException e) {
		
		e.printStackTrace();
	} catch (SQLException e) {
	
		e.printStackTrace();
	}
		
	
	
    String jsonResponse = gson.toJson(isCreated);

    resp.getWriter().write(jsonResponse);

		
	}
	
}
