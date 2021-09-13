package controllers;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;

import java.io.IOException;

import models.User;
import models.Seller;

public class MyProductsServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{
		HttpSession session = request.getSession();

		User user = (User)session.getAttribute("user");

		if(user!=null){
			int sellerId = Integer.parseInt(request.getParameter("seller_id"));
			String sellerName = request.getParameter("seller_name");
			
			Seller seller = new Seller(sellerId,sellerName);

			session.setAttribute("seller",seller);

			request.getRequestDispatcher("my_products.jsp").forward(request,response);
		}else{
			request.getRequestDispatcher("login.jsp").forward(request,response);
		}		
	}
}