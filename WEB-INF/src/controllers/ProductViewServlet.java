package controllers;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;

import java.io.IOException;

import models.Product;

public class ProductViewServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{
		Integer productId = Integer.parseInt(request.getParameter("product_id"));
		
		Product product = new Product(productId);
		product.getProductDetails();

		request.setAttribute("product",product);

		request.getRequestDispatcher("seller_product.jsp").forward(request,response);
	}
}