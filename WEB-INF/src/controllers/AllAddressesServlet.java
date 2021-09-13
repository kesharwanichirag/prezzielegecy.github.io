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

public class AllAddressesServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{
		HttpSession session = request.getSession();

		User user = (User)session.getAttribute("user");

		if(user!=null){
			ArrayList<Address> addresses = Address.getAllAddresses(user.getUserId());
			
			request.setAttribute("addresses",addresses);
			request.getRequestDispatcher("all_addresses.jsp").forward(request,response);
		}else{
			request.getRequestDispatcher("login.jsp").forward(request,response);
		}
	
	}
	public void doPost(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{
		HttpSession session = request.getSession();
		
		User user = (User)session.getAttribute("user");
		if(user!=null){
			String name = request.getParameter("name");
			Integer cityId = Integer.parseInt(request.getParameter("city_id"));
			String pin = request.getParameter("pin");
			String address = request.getParameter("address");
			String recMobile = request.getParameter("rec_mobile");

			Address adrs = new Address(user,new City(cityId),pin,address,name,recMobile);
			adrs.saveAddress();
			response.sendRedirect("all_addresses.do");
		}else{
			request.getRequestDispatcher("login.jsp").forward(request,response);
		}
	}
}
