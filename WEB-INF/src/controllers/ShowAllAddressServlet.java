package controllers;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletException;

import java.io.IOException;
import java.util.ArrayList;

import models.User;
import models.Address;
import models.City;

public class ShowAllAddressServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{
		HttpSession session = request.getSession();

		User user = (User)session.getAttribute("user");

		if(user!=null){
			ArrayList<Address> addresses = Address.getAllAddresses(user.getUserId());
			
			request.setAttribute("addresses_",addresses);
			request.getRequestDispatcher("show_all_addresses.jsp").forward(request,response);
		}else{
			request.getRequestDispatcher("login.jsp").forward(request,response);
		}
	}
}
