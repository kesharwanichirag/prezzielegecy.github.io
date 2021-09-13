package controllers;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;

import com.google.gson.Gson;

import models.User;
import models.Product;

public class AllProductsServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{
		HttpSession session = request.getSession();
		
		String rsp = "session Expired";
		
		User user = (User)session.getAttribute("user");
		if(user!=null){
			int sellerId = Integer.parseInt(request.getParameter("seller_id"));
		
			ArrayList<Product> list = Product.getAllProducts(sellerId);
			Gson gson = new Gson();
			rsp = gson.toJson(list);	
		}
		
		response.getWriter().write(rsp);
	}
}