package com.ecommerce.web.servlets;

import java.io.IOException;

import com.ecommerce.web.database.AddProductDAO;
import com.ecommerce.web.modal.Product;
import com.google.gson.Gson;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/AddProduct")
public class AddProductServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {

        Gson gson = new Gson();

        // JSON → Product Object
        Product product = gson.fromJson(req.getReader(), Product.class);
        
        
         String name  =product.getName();
        int price =(int) product.getPrice();
        String imageUrl=product.getImageUrl();
        String description=product.getDescription();
         String brand =product.getBrand();
         String category =product.getCategory();
         int quantity=product.getQuantity();

        boolean status = false;

        try {
            status = AddProductDAO.addProduct(name,imageUrl,price,description,brand,category,quantity);
        } catch (Exception e) {
            e.printStackTrace();
        }

        resp.setContentType("application/json");
        resp.getWriter().write(gson.toJson(status));
    }
}