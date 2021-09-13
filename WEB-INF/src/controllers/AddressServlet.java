package controllers;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;

import java.io.IOException;

import models.User;
import models.City;
import models.Address;

public class AddressServlet extends HttpServlet{
	public void doGet(HttpServletRequest request ,HttpServletResponse response) throws IOException,ServletException{
		
		HttpSession session = request.getSession();

		User user = (User)session.getAttribute("user");
		if(user!=null){	
			Address address = new Address(user);
			
			address.showAddress();
			request.setAttribute("address",address);
			
			request.getRequestDispatcher("address.jsp").forward(request,response);
		}else{
			request.getRequestDispatcher("login.jsp").forward(request,response);
		}
	}

	public void doPost(HttpServletRequest request ,HttpServletResponse response) throws IOException,ServletException{
		HttpSession session = request.getSession();
		
		User user = (User)session.getAttribute("user");
		if(user!=null){
			Integer cityId = Integer.parseInt(request.getParameter("city_id")); 
			String ct = request.getParameter("city"); 
			String pin = request.getParameter("pin");
			String addr = request.getParameter("address");
			City city = new City(cityId,ct);
			
			Address add = new Address(user,city,pin,addr);
			if(add.saveAddress()){
				
				response.sendRedirect("address.do");
			}else{
				request.getRequestDispatcher("address.jsp").forward(request,response);	
			}
		}else{
			response.sendRedirect("login.do");
		}
	}
}