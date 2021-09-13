package controllers;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletContext;

import java.io.IOException;

import models.User;

public class ActivateAccountServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{
		
		String userName = request.getParameter("userkey");
		String activationCode = request.getParameter("activationcode");
		
		if(User.activateAccount(userName,activationCode)){
			request.setAttribute("success","account activated sucessfully....!");
		}else{
			request.setAttribute("error","account activation failed....!");
		}
		request.getRequestDispatcher("result.jsp").forward(request,response);
	}
}