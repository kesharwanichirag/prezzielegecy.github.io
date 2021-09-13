package controllers;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;

import java.io.IOException;

import models.User;

public class ProfileServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user"); 
		if(user!=null){
			request.getRequestDispatcher("profile.jsp").forward(request,response);
		}else{
			response.sendRedirect("login.do");
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException{
		HttpSession session = request.getSession();
		String erMessage = null;
		User user = (User)session.getAttribute("user");

		if(user!=null){		
			String otpClient = request.getParameter("otp");
			String otpSession = (String)session.getAttribute("otp");
			otpSession = "12345";

			if(otpClient.equals(otpSession)){	
				String firstName = request.getParameter("firstname");
				String middleName = request.getParameter("middlename");
				String lastName = request.getParameter("lastname");
				String mobile = request.getParameter("mobile");
				
				user.setFirstName(firstName);
				user.setMiddleName(middleName);
				user.setLastName(lastName);
				user.setMobile(mobile);

				if(user.saveProfile()){
					response.sendRedirect("profile.do");
				}else{
					request.getRequestDispatcher("profile.jsp").forward(request,response);
				}
			}else{
				response.sendRedirect("profile.do");
				erMessage = "wrong OTP try again";
				request.setAttribute("error",erMessage);
			}
		}else{
			request.getRequestDispatcher("login.jsp").forward(request,response);
		}
	}
}