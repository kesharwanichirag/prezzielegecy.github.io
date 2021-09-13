package controllers;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;

import models.User;
import models.Product;

public class IndexServlet extends HttpServlet{
	public void doGet(HttpServletRequest request ,HttpServletResponse response) throws IOException,ServletException{
		
		//################### recommended ###########################
		
		ArrayList<Product> product = Product.getProductForIndex();
		request.setAttribute("pro_index",product);			
		//-------------------------forward--------------------------------
		request.getRequestDispatcher("index.jsp").forward(request,response);
		
	}
}