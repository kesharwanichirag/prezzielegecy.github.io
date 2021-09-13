package controllers;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import javax.servlet.ServletContext;

import java.io.IOException;
import java.util.ArrayList;


import models.Product;

public class ShowByCategoryServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{
		Integer catId = Integer.parseInt(request.getParameter("category_id"));
		
		ArrayList<Product> prd = Product.getProductByCatId(catId);
		request.setAttribute("probycat",prd);
		
		request.getRequestDispatcher("show_by_cat.jsp").forward(request,response);
	}
}