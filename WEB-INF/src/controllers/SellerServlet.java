package controllers;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletException;

import java.io.IOException;
import java.util.ArrayList;

import models.User;
import models.Seller;

public class SellerServlet extends HttpServlet{
	public void doPost(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{
		doGet(request,response);
	}
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{
		
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		
		if(user!=null){
			ArrayList<Seller> sellerAccounts = Seller.showSellerAccounts(user.getUserId());
			
			request.setAttribute("seller",sellerAccounts);
			
			request.getRequestDispatcher("seller.jsp").forward(request,response);	
		}else{
			request.getRequestDispatcher("login.jsp").forward(request,response);
		}
	}
}